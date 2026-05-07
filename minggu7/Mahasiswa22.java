public class Mahasiswa22 {
  String nim;
  String nama;
  String kelas;
  double ipk;

  public Mahasiswa22() {
  }

  public Mahasiswa22(String nm, String name, String kls, double ip) {
    nim = nm;
    nama = name;
    ipk = ip;
    kelas = kls;
  }

  public void tampilInformasi() {
    System.out.println("NIM: " + this.nim + " | " + "Nama: " + this.nama + " | " + "Prodi: " + this.kelas);
  }
}
