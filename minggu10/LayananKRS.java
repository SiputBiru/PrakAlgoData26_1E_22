import java.util.Scanner;

public class LayananKRS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    AntrianKRS antrian = new AntrianKRS(10);
    int pilihan;

    do {
      System.out.println("\n=== Sistem Antrian KRS DPA ===");
      System.out.println("1. Tambah Mahasiswa ke Antrian");
      System.out.println("2. Panggil Antrian");
      System.out.println("3. Lihat 2 Antrian Terdepan");
      System.out.println("4. Lihat Antrian Paling Akhir");
      System.out.println("5. Tampilkan Semua Antrian");
      System.out.println("6. Cetak Statistik (Jumlah Antrian & Sisa Kuota)");
      System.out.println("7. Kosongkan Antrian");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu: ");

      pilihan = sc.nextInt();
      sc.nextLine();

      switch (pilihan) {
        case 1:
          if (antrian.totalServiced + antrian.size >= 30) {
            System.out.println("Mohon maaf, kuota DPA (30 mahasiswa) sudah terpenuhi.");
          } else {
            System.out.print("NIM  : ");
            String nim = sc.nextLine();
            System.out.print("Nama : ");
            String nama = sc.nextLine();
            System.out.print("Prodi: ");
            String prodi = sc.nextLine();
            System.out.print("Kelas: ");
            String kelas = sc.nextLine();

            Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
            antrian.tambahAntrian(mhs);
          }
          break;

        case 2:
          antrian.layaniKRS();
          break;

        case 3:
          System.out.println("--- 2 Antrian Terdepan ---");
          antrian.tampilkan2Terdepan();
          break;

        case 4:
          antrian.lihatAkhir();
          break;

        case 5:
          antrian.tampilkanSemua();
          break;

        case 6:
          antrian.cetakStatistik();
          break;

        case 7:
          antrian.clear();
          break;

        case 0:
          System.out.println("Selesai.");
          break;

        default:
          System.out.println("Pilihan tidak valid!");
      }
    } while (pilihan != 0);

    sc.close();
  }
}
