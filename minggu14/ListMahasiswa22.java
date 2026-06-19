import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMahasiswa22 {
    // Deklarasi List untuk menampung objek Mahasiswa
    List<Mahasiswa22> mahasiswas = new ArrayList<>();

    // Metode untuk menambahkan objek (menggunakan varargs / unlimited argument)
    public void tambah(Mahasiswa22... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    // Metode untuk menghapus elemen berdasarkan indeks
    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    // Metode untuk memperbarui data mahasiswa pada indeks tertentu
    public void update(int index, Mahasiswa22 mhs) {
        if (index >= 0 && index < mahasiswas.size()) {
            mahasiswas.set(index, mhs);
        }
    }

    // Metode untuk menampilkan seluruh elemen di dalam list
    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println(mhs.toString());
        });
    }

    // Metode pencarian linear berdasarkan NIM untuk mencari indeks objek
    public int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    // Main Method
    public static void main(String[] args) {
        ListMahasiswa22 lm = new ListMahasiswa22();
        
        // Membuat instansiasi objek mahasiswa
        Mahasiswa22 m = new Mahasiswa22("201234", "Noureen", "021xx1");
        Mahasiswa22 m1 = new Mahasiswa22("201235", "Akhleema", "021xx2");
        Mahasiswa22 m2 = new Mahasiswa22("201236", "Shannum", "021xx3");

        // Menambahkan objek mahasiswa ke dalam list
        lm.tambah(m, m1, m2);

        // Menampilkan list mahasiswa sebelum update
        System.out.println("Daftar Mahasiswa Awal");
        lm.tampil();

        // Memperbarui data mahasiswa dengan NIM "201235"
        int indexData = lm.linearSearch("201235");
        lm.update(indexData, new Mahasiswa22("201235", "Akhleema Lela", "021xx2"));

        // Menampilkan list mahasiswa setelah update
        System.out.println("\nDaftar Mahasiswa Setelah Update");
        lm.tampil();
    }
}
