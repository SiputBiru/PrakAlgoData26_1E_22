public class Mahasiswa22 {
    String nim;
    String nama;
    String notelp;

    // Konstruktor default
    public Mahasiswa22() {
    }

    // Konstruktor dengan parameter
    public Mahasiswa22(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    // Mengubah representasi objek menjadi teks saat dicetak
    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
    }
}
