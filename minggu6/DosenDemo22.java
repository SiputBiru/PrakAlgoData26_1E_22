import java.util.Scanner;

public class DosenDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DataDosen22 data = new DataDosen22();
    int pilih;

    do {
      System.out.println("\n=== MENU DATA DOSEN ===");
      System.out.println("1. Tambah Data");
      System.out.println("2. Tampil Data");
      System.out.println("3. Sorting ASC (Termuda)");
      System.out.println("4. Sorting DSC (Tertua)");
      System.out.println("5. Keluar");
      System.out.print("Pilih menu: ");
      pilih = sc.nextInt();
      sc.nextLine();

      switch (pilih) {
        case 1:
          System.out.print("Kode: ");
          String kd = sc.nextLine();
          System.out.print("Nama: ");
          String nm = sc.nextLine();
          System.out.print("Pria (true/false): ");
          boolean jk = sc.nextBoolean();
          System.out.print("Usia: ");
          int us = sc.nextInt();
          data.tambah(new Dosen22(kd, nm, jk, us));
          break;
        case 2:
          System.out.println("\n--- Daftar Dosen ---");
          data.tampil();
          break;
        case 3:
          data.sortingASC();
          System.out.println("\nData berhasil diurutkan (ASC)...");
          data.tampil();
          break;
        case 4:
          data.sortingDSC();
          System.out.println("\nData berhasil diurutkan (DSC)...");
          data.tampil();
          break;
      }
    } while (pilih != 5);
    sc.close();
  }
}
