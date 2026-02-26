import java.util.Scanner;

public class MataKuliah22 {

  public String kode;
  public String nama;
  public int sks;
  public int jumlahJam;

  public MataKuliah22(String kode, String nama, int sks, int jumlahJam) {
    this.kode = kode;
    this.nama = nama;
    this.sks = sks;
    this.jumlahJam = jumlahJam;
  }

  public MataKuliah22() {

  }

  public void tambahData() {
    Scanner sc = new Scanner(System.in);

    String dummy;

    System.out.print("Kode         : ");
    this.kode = sc.nextLine();

    System.out.print("Nama         : ");
    this.nama = sc.nextLine();

    System.out.print("Sks          : ");
    dummy = sc.nextLine();
    this.sks = Integer.parseInt(dummy);

    System.out.print("Jumlah Jam   : ");
    dummy = sc.nextLine();
    this.jumlahJam = Integer.parseInt(dummy);
    System.out.println("--------------------------------------");

  }

  public void cetakInfo() {
    System.out.println("Kode               : " + this.kode);
    System.out.println("nama               : " + this.nama);
    System.out.println("Sks                : " + this.sks);
    System.out.println("Jumlah jam         : " + this.jumlahJam);
    System.out.println("--------------------------------------");
  }

}
