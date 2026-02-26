public class MahasiswaDemo22 {
  public static void main(String[] args) {
    Mahasiswa22[] arrayOfMahasiswa = new Mahasiswa22[3];

    arrayOfMahasiswa[0] = new Mahasiswa22();
    arrayOfMahasiswa[0].nim = "244107060033";
    arrayOfMahasiswa[0].nama = "AGNES TITANIA KINANTI";
    arrayOfMahasiswa[0].kelas = "SIB-1E";
    arrayOfMahasiswa[0].ipk = (float) 3.75;

    arrayOfMahasiswa[1] = new Mahasiswa22();
    arrayOfMahasiswa[1].nim = "234170172";
    arrayOfMahasiswa[1].nama = "ACHMAD MAULANA HAMZAH";
    arrayOfMahasiswa[1].kelas = "TI-2A";
    arrayOfMahasiswa[1].ipk = (float) 3.36;

    arrayOfMahasiswa[2] = new Mahasiswa22();
    arrayOfMahasiswa[2].nim = "244107023006";
    arrayOfMahasiswa[2].nama = "DIRHAMAWAN PUTRANTO";
    arrayOfMahasiswa[2].kelas = "TI-2E";
    arrayOfMahasiswa[2].ipk = (float) 3.80;

    System.out.println("NIM      : " + arrayOfMahasiswa[0].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[0].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[0].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[0].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[1].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[1].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[1].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[1].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[2].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[2].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[2].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[2].ipk);
    System.out.println("----------------------------------------");

    /*
     * PrakAlgoData26_1E_22/minggu3 main ? ❯ java Mahasiswa22.java
     * NIM : 244107060033
     * Nama : AGNES TITANIA KINANTI
     * Kelas : SIB-1E
     * IPK : 3.75
     * ----------------------------------------
     * NIM : 234170172
     * Nama : ACHMAD MAULANA HAMZAH
     * Kelas : TI-2A
     * IPK : 3.36
     * ----------------------------------------
     * NIM : 244107023006
     * Nama : DIRHAMAWAN PUTRANTO
     * Kelas : TI-2E
     * IPK : 3.8
     * ----------------------------------------
     * 
     */
  }
}
