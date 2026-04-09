public class Mahasiswa {
  String nim;
  String nama;
  String prodi;

  public Mahasiswa() {

  }

  public Mahasiswa(String nim, String nama, String prodi) {
    this.nim = nim;
    this.nama = nama;
    this.prodi = prodi;
  }

  public void tampilMahasiswa() {
    System.out.println("NIM: " + this.nim + " | " + "Nama: " + this.nama + " | " + "Prodi: " + this.prodi);
  }
}
