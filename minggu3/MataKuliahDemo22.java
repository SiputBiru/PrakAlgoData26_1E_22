import java.util.Scanner;

public class MataKuliahDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int banyakInput = 0;

    System.out.println("Berapa banyak data Matakuliah yang ingin di input?");
    banyakInput = sc.nextInt();

    MataKuliah22[] arrayOfMataKuliah = new MataKuliah22[banyakInput];

    for (int i = 0; i < banyakInput; i++) {
      System.out.println("Masukkan Data MataKuliah ke-" + (i + 1));
      arrayOfMataKuliah[i] = new MataKuliah22();
      arrayOfMataKuliah[i].tambahData();
    }

    for (int i = 0; i < banyakInput; i++) {
      System.out.println("Data MataKuliah ke-" + (i + 1));
      arrayOfMataKuliah[i].cetakInfo();
    }

    sc.close();

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
