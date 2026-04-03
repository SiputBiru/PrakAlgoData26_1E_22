public class Dosen22 {
  String kode, nama;
  boolean jenisKelamin; // true: Pria, false: Wanita (atau sebaliknya)
  int usia;

  Dosen22(String kd, String name, boolean jk, int age) {
    kode = kd;
    nama = name;
    jenisKelamin = jk;
    usia = age;
  }

  void tampil() {
    System.out.println("Kode          : " + kode);
    System.out.println("Nama          : " + nama);
    System.out.println("Jenis Kelamin : " + (jenisKelamin ? "Pria" : "Wanita"));
    System.out.println("Usia          : " + usia);
  }
}
