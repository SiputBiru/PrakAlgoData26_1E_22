class MahasiswaMain22 {
  public static void main(String[] args) {
    Mahasiswa22 mhs1 = new Mahasiswa22();
    mhs1.nama = "Muhammad Ali Zulfikar";
    mhs1.nim = "2241720171";
    mhs1.ipk = 3.55;

    mhs1.tampilkanInformasi();
    mhs1.ubahKelas("S1 2K");
    mhs1.updateIpk(3.60);
    mhs1.tampilkanInformasi();

  }
}
