class Mahasiswa22 {
  String nim, nama, kelas;
  int nilai;

  Mahasiswa22() {

  }

  Mahasiswa22(String nim, String nama, String kelas) {
    this.nim = nim;
    this.nama = nama;
    this.kelas = kelas;
    this.nilai = -1;
  }

  void tugasDinilai(int nilai) {
    this.nilai = nilai;
  }

}
