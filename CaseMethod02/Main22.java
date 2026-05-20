import java.util.Scanner;

public class Main22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DLLAntrian22 antrian = new DLLAntrian22();
    DLLPesanan22 pesananList = new DLLPesanan22();
    int pilihan;

    do {
      System.out.println("=====================================");
      System.out.println("     SISTEM ANTRIAN ROYAL DELISH     ");
      System.out.println("=====================================");
      System.out.println("1. Tambah Antrian");
      System.out.println("2. Cetak Antrian");
      System.out.println("3. Hapus Antrian dan Pesan");
      System.out.println("4. Laporan Pesanan");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu : ");
      pilihan = sc.nextInt();
      sc.nextLine(); // clear buffer

      switch (pilihan) {
        case 1:
          System.out.print("Nama Pembeli : ");
          String nama = sc.nextLine();
          System.out.print("No HP        : ");
          String hp = sc.nextLine();
          antrian.enqueue(new Pembeli22(nama, hp));
          System.out.println("Antrian berhasil ditambahkan.");
          break;
        case 2:
          antrian.print();
          break;
        case 3:
          if (antrian.isEmpty()) {
            System.out.println("Antrian masih kosong.");
          } else {
            NodeAntrian22 pembeliDipanggil = antrian.dequeue();
            System.out.println("Panggilan untuk nomor antrian: " + pembeliDipanggil.noAntrian);
            System.out.println("Nama Pembeli: " + pembeliDipanggil.pembeli.namaPembeli);

            System.out.print("Kode Pesanan : ");
            int kode = sc.nextInt();
            sc.nextLine(); // clear buffer
            System.out.print("Nama Pesanan : ");
            String menu = sc.nextLine();
            System.out.print("Harga        : ");
            int harga = sc.nextInt();

            pesananList.addLast(new Pesanan22(kode, menu, harga));
            System.out.println(pembeliDipanggil.pembeli.namaPembeli + " telah memesan " + menu);
          }
          break;
        case 4:
          pesananList.sortByName();
          pesananList.print();
          break;
        case 0:
          System.out.println("Keluar...");
          break;
        default:
          System.out.println("Pilihan tidak valid!");
      }
    } while (pilihan != 0);

    sc.close();
  }
}
