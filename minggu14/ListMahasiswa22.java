import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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

    // Metode pencarian binary berdasarkan NIM
    public int binarySearch(String nim) {
        // Membuat objek bantuan untuk parameter pencarian NIM
        Mahasiswa22 key = new Mahasiswa22(nim, "", "");
        
        // Menyediakan Comparator untuk membandingkan NIM antar Mahasiswa
        Comparator<Mahasiswa22> comp = new Comparator<Mahasiswa22>() {
            @Override
            public int compare(Mahasiswa22 m1, Mahasiswa22 m2) {
                return m1.nim.compareTo(m2.nim);
            }
        };
        
        // Melakukan sorting terlebih dahulu karena syarat utama binary search adalah data harus terurut
        Collections.sort(mahasiswas, comp);
        
        // Memanggil fungsi binary search dari Collections framework
        return Collections.binarySearch(mahasiswas, key, comp);
    }
    //
    // // Main Method
    // public static void main(String[] args) {
    //     ListMahasiswa22 lm = new ListMahasiswa22();
    //
    //     // Membuat instansiasi objek mahasiswa
    //     Mahasiswa22 m = new Mahasiswa22("201234", "Noureen", "021xx1");
    //     Mahasiswa22 m1 = new Mahasiswa22("201235", "Akhleema", "021xx2");
    //     Mahasiswa22 m2 = new Mahasiswa22("201236", "Shannum", "021xx3");
    //
    //     // Menambahkan objek mahasiswa ke dalam list
    //     lm.tambah(m, m1, m2);
    //
    //     System.out.println("Daftar Mahasiswa Awal:");
    //     lm.tampil();
    //
    //     String nimCari = "201235";
    //
    //     // Menggunakan Linear Search
    //     System.out.println("\nMenjalankan Linear Search...");
    //
    //     int indexLinear = lm.linearSearch(nimCari);
    //
    //     if (indexLinear >= 0) {
    //         System.out.println("[HASIL] NIM " + nimCari + " ditemukan via Linear Search pada indeks: " + indexLinear);
    //         // Update data hasil linear search
    //         lm.update(indexLinear, new Mahasiswa22("201235", "Akhleema Lela (Linear)", "021xx2"));
    //     } else {
    //         System.out.println("[HASIL] NIM " + nimCari + " tidak ditemukan via Linear Search.");
    //     }
    //
    //     System.out.println("\nData setelah di-update via Linear Search:");
    //     lm.tampil();
    //
    //
    //     // Menggunakan Binary Search
    //     System.out.println("\nMenjalankan Binary Search...");
    //
    //     int indexBinary = lm.binarySearch(nimCari);
    //
    //     if (indexBinary >= 0) {
    //         System.out.println("[HASIL] NIM " + nimCari + " ditemukan via Binary Search pada indeks: " + indexBinary);
    //         // Update data hasil binary search
    //         lm.update(indexBinary, new Mahasiswa22("201235", "Akhleema Lela (Binary)", "021xx2"));
    //     } else {
    //         System.out.println("[HASIL] NIM " + nimCari + " tidak ditemukan via Binary Search.");
    //     }
    //
    //     System.out.println("\nData akhir setelah di-update via Binary Search:");
    //     lm.tampil();
    // }

    // Fungsi untuk mengurutkan daftar mahasiswa berdasarkan NIM secara Ascending (Kecil ke Besar)
    public void sortAscending() {
        mahasiswas.sort((m1, m2) -> m1.nim.compareTo(m2.nim));
    }

    // Fungsi untuk mengurutkan daftar mahasiswa berdasarkan NIM secara Descending (Besar ke Kecil)
    public void sortDescending() {
        mahasiswas.sort((m1, m2) -> m2.nim.compareTo(m1.nim));
    }


    // percobaan sorting 
    public static void main(String[] args) {
        ListMahasiswa22 lm = new ListMahasiswa22();
        
        // Data diinputkan dengan NIM acak (tidak terurut)
        Mahasiswa22 m = new Mahasiswa22("201236", "Shannum", "021xx3");
        Mahasiswa22 m1 = new Mahasiswa22("201234", "Noureen", "021xx1");
        Mahasiswa22 m2 = new Mahasiswa22("201235", "Akhleema", "021xx2");

        lm.tambah(m, m1, m2);

        System.out.println("DATA AWAL");
        lm.tampil();

        // Menguji Urut Ascending
        lm.sortAscending();
        System.out.println("\nSETELAH SORT ASCENDING (NIM KECIL KE BESAR)");
        lm.tampil();

        // Menguji Urut Descending
        lm.sortDescending();
        System.out.println("\nSETELAH SORT DESCENDING (NIM BESAR KE KECIL)");
        lm.tampil();
    }
}
