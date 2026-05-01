import java.util.Scanner;

public class SuratIzinDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StackSuratIzin22 stack = new StackSuratIzin22(10);
    int pilih;

    do {
      System.out.println("\n--- Sistem Pengelolaan Surat Izin ---");
      System.out.println("1. Terima Surat Izin");
      System.out.println("2. Proses Surat Izin (Pop)");
      System.out.println("3. Lihat Surat Izin Terakhir (Peek)");
      System.out.println("4. Cari Surat (Berdasarkan Nama)");
      System.out.println("5. Keluar");
      System.out.print("Pilih Menu: ");
      pilih = sc.nextInt();
      sc.nextLine(); // clear buffer

      switch (pilih) {
        case 1:
          System.out.print("ID Surat: ");
          String id = sc.nextLine();
          System.out.print("Nama Mahasiswa: ");
          String nama = sc.nextLine();
          System.out.print("Kelas: ");
          String kelas = sc.nextLine();
          System.out.print("Jenis Izin (S/I): ");
          char jenis = sc.next().charAt(0);
          System.out.print("Durasi (hari): ");
          int durasi = sc.nextInt();

          Surat22 srt = new Surat22(id, nama, kelas, jenis, durasi);
          stack.push(srt);
          break;

        case 2:
          Surat22 diproses = stack.pop();
          if (diproses != null) {
            System.out.println("Memproses surat milik: " + diproses.namaMahasiswa);
          }
          break;

        case 3:
          Surat22 terakhir = stack.peek();
          if (terakhir != null) {
            System.out.println("Surat teratas adalah milik: " + terakhir.namaMahasiswa);
          }
          break;

        case 4:
          System.out.print("Masukkan nama mahasiswa yang dicari: ");
          String cariNama = sc.nextLine();
          stack.cariSurat(cariNama);
          break;

        case 5:
          System.out.println("Keluar dari program...");
          break;

        default:
          System.out.println("Pilihan tidak valid!");
      }
    } while (pilih != 5);
    sc.close();
  }
}
