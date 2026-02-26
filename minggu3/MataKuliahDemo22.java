import java.util.Scanner;

public class MataKuliahDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    MataKuliah22[] arrayOfMataKuliah = new MataKuliah22[3];
    // String kode, nama, dummy;
    // int sks, jumlahJam;

    for (int i = 0; i < 3; i++) {
      System.out.println("Masukkan Data MataKuliah ke-" + (i + 1));
      arrayOfMataKuliah[i].tambahData();
    }

    sc.close();

    for (int i = 0; i < 3; i++) {
      System.out.println("Data MataKuliah ke-" + (i + 1));
      System.out.println("Kode               : " + arrayOfMataKuliah[i].kode);
      System.out.println("nama               : " + arrayOfMataKuliah[i].nama);
      System.out.println("Sks                : " + arrayOfMataKuliah[i].sks);
      System.out.println("Jumlah jam         : " + arrayOfMataKuliah[i].jumlahJam);
      System.out.println("--------------------------------------");
    }

  }

  /*
   * java MataKuliahDemo22.java
   * Masukkan Data MataKuliah ke-1
   * Kode : 1
   * Nama : Aljabar Linear
   * Sks : 4
   * Jumlah Jam : 19
   * --------------------------------------
   * Masukkan Data MataKuliah ke-2
   * Kode : 2
   * Nama : Calculus 1
   * Sks : 4
   * Jumlah Jam : 19
   * --------------------------------------
   * Masukkan Data MataKuliah ke-3
   * Kode : 3
   * Nama : Pre-Calculus
   * Sks : 3
   * Jumlah Jam : 19
   * --------------------------------------
   * Data MataKuliah ke-1
   * Kode : 1
   * nama : Aljabar Linear
   * Sks : 4
   * Jumlah jam : 19
   * --------------------------------------
   * Data MataKuliah ke-2
   * Kode : 2
   * nama : Calculus 1
   * Sks : 4
   * Jumlah jam : 19
   * --------------------------------------
   * Data MataKuliah ke-3
   * Kode : 3
   * nama : Pre-Calculus
   * Sks : 3
   * Jumlah jam : 19
   * --------------------------------------
   */
}
