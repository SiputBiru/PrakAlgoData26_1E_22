import java.util.Scanner;

public class MahasiswaDemo22 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Mahasiswa22[] arrayOfMahasiswa = new Mahasiswa22[3];
    String dummy;

    for (int i = 0; i < 3; i++) {
      arrayOfMahasiswa[i] = new Mahasiswa22();
      System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
      System.out.print("NIM        : ");
      arrayOfMahasiswa[i].nim = sc.nextLine();
      System.out.print("Nama       : ");
      arrayOfMahasiswa[i].nama = sc.nextLine();
      System.out.print("Kelas      : ");
      arrayOfMahasiswa[i].kelas = sc.nextLine();
      System.out.print("IPK        : ");
      dummy = sc.nextLine();
      arrayOfMahasiswa[i].ipk = Float.parseFloat(dummy);
      System.out.println("----------------------------------------");

    }

    sc.close();

    for (int i = 0; i < 3; i++) {
      System.out.println("Data mahasiswa ke-" + (i + 1));
      System.out.println("NIM      : " + arrayOfMahasiswa[i].nim);
      System.out.println("Nama     : " + arrayOfMahasiswa[i].nama);
      System.out.println("Kelas    : " + arrayOfMahasiswa[i].kelas);
      System.out.println("IPK      : " + arrayOfMahasiswa[i].ipk);
      System.out.println("----------------------------------------");
    }
    /*
     * Masukkan Data Mahasiswa ke-1
     * NIM : 322349009
     * Nama : andiryana
     * Kelas : 1E-TI
     * IPK : 4.00
     * ----------------------------------------
     * Masukkan Data Mahasiswa ke-2
     * NIM : 03294892304
     * Nama : andiryana
     * Kelas : 1E-TI
     * IPK : 3.95
     * ----------------------------------------
     * Masukkan Data Mahasiswa ke-3
     * NIM : 2034983204
     * Nama : Adnirya
     * Kelas : 1E-TI
     * IPK : 3.5
     * ----------------------------------------
     * Data mahasiswa ke-1
     * NIM : 322349009
     * Nama : andiryana
     * Kelas : 1E-TI
     * IPK : 4.0
     * ----------------------------------------
     * Data mahasiswa ke-2
     * NIM : 03294892304
     * Nama : andiryana
     * Kelas : 1E-TI
     * IPK : 3.95
     * ----------------------------------------
     * Data mahasiswa ke-3
     * NIM : 2034983204
     * Nama : Adnirya
     * Kelas : 1E-TI
     * IPK : 3.5
     * ----------------------------------------
     */
  }
}
