// Kode program sebelum dimodifikasi
// public class MahasiswaDemo22 {
//   public static void main(String[] args) {
//     MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22();
//     Mahasiswa22 m1 = new Mahasiswa22("123", "Zidan", "2A", 3.2);
//     Mahasiswa22 m2 = new Mahasiswa22("124", "Ayu", "2A", 3.5);
//     Mahasiswa22 m3 = new Mahasiswa22("125", "Sofi", "2A", 3.1);
//     Mahasiswa22 m4 = new Mahasiswa22("126", "Sita", "2A", 3.9);
//     Mahasiswa22 m5 = new Mahasiswa22("127", "Miki", "2A", 3.7);
//
//     list.tambah(m1);
//     list.tambah(m2);
//     list.tambah(m3);
//     list.tambah(m4);
//     list.tambah(m5);
//
//     System.out.println("Data mahasiswa sebelum sorting: ");
//     list.tampil();
//
//     System.out.println("Data Mahasiwa setelah sorting berdasarkan IPK (DESC) : ");
//     list.bubbleSort();
//     list.tampil();
//   }
// }

import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan jumlah mahasiswa yang akan diinput: ");
    int jumlah = sc.nextInt();
    sc.nextLine();

    MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22(jumlah);

    for (int i = 0; i < jumlah; i++) {
      System.out.println("--- Data Mahasiswa ke-" + (i + 1) + " ---");
      System.out.print("NIM   : ");
      String nim = sc.nextLine();
      System.out.print("Nama  : ");
      String nama = sc.nextLine();
      System.out.print("Kelas : ");
      String kelas = sc.nextLine();
      System.out.print("IPK   : ");
      double ipk = sc.nextDouble();
      sc.nextLine();

      Mahasiswa22 m = new Mahasiswa22(nim, nama, kelas, ipk);
      list.tambah(m);
    }

    // System.out.println("\nData Mahasiswa Setelah Sorting (IPK DESC):");
    // list.bubbleSort();
    // list.tampil();

    // System.out.println("\nData yang sudah terurut menggunakan SELECTION SORT
    // (ASC):");
    // list.selectionSort();
    // list.tampil();

    System.out.println("\nData yang sudah terurut menggunakan INSERTION SORT (ASC):");
    list.InsertionSort();
    list.tampil();

    sc.close();
  }
}
