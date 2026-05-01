import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    StackTugasMahasiswa22 stack = new StackTugasMahasiswa22(5);

    Scanner sc = new Scanner(System.in);

    int pilih = 0;

    do {

      System.out.println("\nMenu");
      System.out.println("1. Mengumpulkan Tugas");
      System.out.println("2. Menilai Tugas");
      System.out.println("3. Melihat Tugas Teratas");
      System.out.println("4. Melihat Daftar Tugas");
      System.out.println("5. Melihat Daftar Tugas(dari bawah)");
      System.out.println("6. Melihat Tugas pertama kali dikumpulkan");
      System.out.println("7. Menghitung Jumlah Tugas");
      System.out.print("Pilih: ");

      if (!sc.hasNextInt()) {
        break;
      }
      pilih = sc.nextInt();
      sc.nextLine();

      switch (pilih) {
        case 1:
          System.out.print("Nama: ");
          String nama = sc.nextLine();
          System.out.print("NIM: ");
          String nim = sc.nextLine();
          System.out.print("Kelas: ");
          String kelas = sc.nextLine();
          Mahasiswa22 mhs = new Mahasiswa22(nim, nama, kelas);
          stack.push(mhs);
          System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
          break;
        case 2:
          Mahasiswa22 dinilai = stack.pop();
          if (dinilai != null) {
            System.out.println("Menilai tugas dari " + dinilai.nama);
            System.out.print("Masukkan nilai diantara (0-100): ");
            int nilai = sc.nextInt();
            dinilai.tugasDinilai(nilai);
            System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
          }
          break;
        case 3:
          Mahasiswa22 lihat = stack.peek();
          if (lihat != null) {
            System.out.println("Tugas akhir dikumpulkan oleh " + lihat.nama);
          }
          break;
        case 4:
          System.out.println("Daftar semua tugas.");
          System.out.println("Nama\tNIM\tKelas");
          stack.print();
          break;
        case 5:
          System.out.println("Daftar semua tugas(dari bawah).");
          System.out.println("Nama\tNIM\tKelas");
          stack.printDrBawah();
          break;
        case 6:
          Mahasiswa22 bawah = stack.peekBottom();
          if (bawah != null) {
            System.out.println("Tugas pertama kali dikumpulkan oleh: " + bawah.nama);
          }
          break;
        case 7:
          int jumlah = stack.count();
          System.out.println("Jumlah tugas dalam stack saat ini: " + jumlah);
          break;
        default:
          System.out.println("Pilihan tidak valid.");
      }

    } while (pilih >= 1 && pilih <= 7);

    sc.close();
  }
}
