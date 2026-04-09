public class Peminjaman22 {
  Mahasiswa mhs;
  Buku22 buku;
  int lamaPinjam;
  int batasPinjam = 5;
  int terlambat;
  int denda;

  Peminjaman22(Mahasiswa mhs, Buku22 buku, int lamaPinjam) {
    this.mhs = mhs;
    this.buku = buku;
    this.lamaPinjam = lamaPinjam;
    // hitung apakah mahasiswa terlambat atau tidak
    if (this.lamaPinjam > this.batasPinjam) {
      this.terlambat = this.lamaPinjam - this.batasPinjam;
    }

    hitungDenda();
  }

  void hitungDenda() {

    // cek jika peminjaman kosong / atau tidak
    if (this.terlambat <= 0) {
      return;
    }

    this.denda = this.terlambat * 2000;

  }

  void tampilPeminjaman() {
    System.out.printf("%s | %s | Lama: %s | terlambat: %s | Denda: %s\n", this.mhs.nama, this.buku.judul,
        this.lamaPinjam,
        this.terlambat, this.denda);
  }
}
