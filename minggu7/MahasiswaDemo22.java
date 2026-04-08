import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Kita buat banyak imput dinamis
    // int jumMhs = 5;

    System.out.print("Masukkan jumlah mahasiswa: ");
    int jumMhs = sc.nextInt();
    sc.nextLine(); // membersihkan buffer

    MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22(jumMhs);
    for (int i = 0; i < jumMhs; i++) {
      System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
      System.out.print("NIM    : ");
      String nim = sc.nextLine();
      System.out.print("Nama   : ");
      String nama = sc.nextLine();
      System.out.print("Kelas  : ");
      String kelas = sc.nextLine();
      System.out.print("IPK    : ");
      String ip = sc.nextLine();
      double ipk = Double.parseDouble(ip);
      System.out.println("------------------------------------");

      list.tambah(new Mahasiswa22(nim, nama, kelas, ipk));
    }

    list.tampil();

    // System.out.println("-------------------------------------------------------");
    // System.out.println("Pencarian data");
    // System.out.println("-------------------------------------------------------");
    // System.out.println("masukkan ipk mahasiswa yang dicari: ");
    // System.out.print("IPK: ");
    // double cari = sc.nextDouble();
    // System.out.println("menggunakan sequential searching");
    // double posisi = list.sequentialSearching(cari);
    // int pss = (int) posisi;
    // System.out.println("menggunakan Binary searching");
    // list.tampilPosisi(cari, pss);
    // list.tampilDataSearch(cari, pss);

    // melakukan pencarian data Binary
    System.out.println("-------------------------------------------------------");
    System.out.println("Pencarian data");
    System.out.println("-------------------------------------------------------");
    System.out.println("masukkan ipk mahasiswa yang dicari: ");
    System.out.print("IPK: ");
    double cari = sc.nextDouble();

    System.out.println("-------------------------------------------------------");
    System.out.println("menggunakan binary search");
    System.out.println("-------------------------------------------------------");

    int posisi2 = list.findBinarySearch(cari, 0, jumMhs - 1);

    // Menampilkan hasil pencarian
    list.tampilPosisi(cari, posisi2);
    list.tampilDataSearch(cari, posisi2);

    sc.close();
  }
}
