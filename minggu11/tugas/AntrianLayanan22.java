
import java.util.Scanner;

public class AntrianLayanan22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    QueueSLL22 antrian = new QueueSLL22();
    int pilihan;

    do {
      System.out.println("\n=== Menu Antrian Layanan Mahasiswa ===");
      System.out.println("1. Tambah Antrian (Pendaftaran)");
      System.out.println("2. Panggil Antrian (Layanan)");
      System.out.println("3. Lihat Antrian Terdepan & Terakhir");
      System.out.println("4. Cek Jumlah Pengantre");
      System.out.println("5. Kosongkan Antrian");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu: ");
      pilihan = sc.nextInt();
      sc.nextLine();

      switch (pilihan) {
        case 1:
          System.out.print("NIM: ");
          String nim = sc.nextLine();
          System.out.print("Nama: ");
          String nama = sc.nextLine();
          System.out.print("Kelas: ");
          String kelas = sc.nextLine();
          System.out.print("IPK: ");
          double ipk = sc.nextDouble();
          antrian.enqueue(new Mahasiswa22(nim, nama, kelas, ipk));
          break;
        case 2:
          antrian.dequeue();
          break;
        case 3:
          antrian.peek();
          break;
        case 4:
          antrian.displaySize();
          break;
        case 5:
          antrian.clear();
          break;
      }
    } while (pilihan != 0);
    sc.close();
  }
}
