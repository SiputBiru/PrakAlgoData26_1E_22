public class Buku22 {
  String kodeBuku;
  String judul;
  String tahunTerbit;

  Buku22(String kode, String judul, String tahun) {
    this.kodeBuku = kode;
    this.judul = judul;
    this.tahunTerbit = tahun;
  }

  void tampilMahasiswa() {
    System.out.println(this.kodeBuku);
    System.out.println(this.judul);
    System.out.println(this.tahunTerbit);
  }
}
