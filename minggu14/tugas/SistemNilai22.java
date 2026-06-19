import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SistemNilai22 {
    List<Mahasiswa22> listMahasiswa = new ArrayList<>();
    List<MataKuliah22> listMK = new ArrayList<>();
    
    List<Nilai22> listNilai = new ArrayList<>();
    
    Queue<Mahasiswa22> antreanHapusMhs = new LinkedList<>();

    public SistemNilai22() {
        // Data awal Mahasiswa sesuai tabel 
        listMahasiswa.add(new Mahasiswa22("20001", "Thalhah", "021xxx"));
        listMahasiswa.add(new Mahasiswa22("20002", "Zubair", "021xxx"));
        listMahasiswa.add(new Mahasiswa22("20003", "Abdur-Rahman", "021xxx"));
        listMahasiswa.add(new Mahasiswa22("20004", "Sa'ad", "021xxx"));
        listMahasiswa.add(new Mahasiswa22("20005", "Sa'id", "021xxx"));
        listMahasiswa.add(new Mahasiswa22("20006", "Ubaidah", "021xxx"));

        // Data awal Mata Kuliah sesuai tabel
        listMK.add(new MataKuliah22("00001", "Internet of Things", 3));
        listMK.add(new MataKuliah22("00002", "Algoritma dan Struktur Data", 2));
        listMK.add(new MataKuliah22("00003", "Algoritma dan Pemrograman", 2));
        listMK.add(new MataKuliah22("00004", "Praktikum Algoritma dan Struktur Data", 3));
        listMK.add(new MataKuliah22("00005", "Praktikum Algoritma dan Pemrograman", 3));
    }

    // Menu 1: Input Nilai
    public void inputNilai(Scanner sc) {
        System.out.println("Masukan data");
        System.out.print("Nilai : ");
        double nilai = sc.nextDouble();
        sc.nextLine(); 

        // Menampilkan daftar Mahasiswa untuk dipilih
        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println("*******");
        System.out.printf("%-10s %-15s %-10s\n", "NIM", "Nama", "Telf");
        for (Mahasiswa22 m : listMahasiswa) {
            System.out.printf("%-10s %-15s %-10s\n", m.nim, m.nama, m.telf);
        }
        System.out.print("Pilih mahasiswa by nim: ");
        String nim = sc.nextLine();
        
        Mahasiswa22 mhsTerpilih = null;
        for (Mahasiswa22 m : listMahasiswa) {
            if (m.nim.equals(nim)) {
                mhsTerpilih = m;
                break;
            }
        }

        // Menampilkan daftar Mata Kuliah untuk dipilih
        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.printf("%-10s %-40s %-5s\n", "Kode", "Mata Kuliah", "SKS");
        for (MataKuliah22 mk : listMK) {
            System.out.printf("%-10s %-40s %-5d\n", mk.kode, mk.namaMK, mk.sks);
        }
        System.out.print("Pilih MK by kode: ");
        String kodeMK = sc.nextLine();
        
        MataKuliah22 mkTerpilih = null;
        for (MataKuliah22 mk : listMK) {
            if (mk.kode.equals(kodeMK)) {
                mkTerpilih = mk;
                break;
            }
        }

        // Validasi dan penyimpanan ke list nilai
        if (mhsTerpilih != null && mkTerpilih != null) {
            listNilai.add(new Nilai22(mhsTerpilih, mkTerpilih, nilai));
            System.out.println("[INFO] Data Nilai Berhasil Dimasukkan!");
        } else {
            System.out.println("[ERROR] NIM Mahasiswa atau Kode MK tidak ditemukan!");
        }
    }

    // Menu 2: Tampil Nilai
    public void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf("%-10s %-15s %-40s %-5s %-6s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai22 n : listNilai) {
            System.out.printf("%-10s %-15s %-40s %-5d %-6.2f\n", 
                n.mhs.nim, n.mhs.nama, n.mk.namaMK, n.mk.sks, n.nilaiAngka);
        }
    }

    // Menu 3: Mencari Nilai Mahasiswa
    public void cariNilai(Scanner sc) {
        System.out.print("Masukkan data mahasiswa [nim] : ");
        String nim = sc.nextLine();
        
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.printf("%-10s %-15s %-40s %-5s %-6s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");
        
        int totalSks = 0;
        boolean ditemukan = false;
        for (Nilai22 n : listNilai) {
            if (n.mhs.nim.equals(nim)) {
                System.out.printf("%-10s %-15s %-40s %-5d %-6.2f\n", 
                    n.mhs.nim, n.mhs.nama, n.mk.namaMK, n.mk.sks, n.nilaiAngka);
                totalSks += n.mk.sks;
                ditemukan = true;
            }
        }
        
        if (ditemukan) {
            System.out.println("Total SKS " + totalSks + " telah diambil.");
        } else {
            System.out.println("[INFO] Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // Menu 4: Urut Data Nilai (Berdasarkan Nilai Angka Ascending)
    public void urutNilai() {
        listNilai.sort((n1, n2) -> Double.compare(n1.nilaiAngka, n2.nilaiAngka));
        System.out.println("[INFO] Data Nilai Berhasil Diurutkan!");
        tampilNilai();
    }

    // Masukkan Mahasiswa ke dalam Antrean Hapus (Queue)
    public void masukkanAntreanHapus(Scanner sc) {
        System.out.print("Masukkan NIM Mahasiswa untuk dimasukkan ke antrean hapus: ");
        String nim = sc.nextLine();
        Mahasiswa22 mhsTerpilih = null;
        for (Mahasiswa22 m : listMahasiswa) {
            if (m.nim.equals(nim)) {
                mhsTerpilih = m;
                break;
            }
        }
        if (mhsTerpilih != null) {
            antreanHapusMhs.add(mhsTerpilih);
            System.out.println("[QUEUE] " + mhsTerpilih.nama + " dimasukkan ke dalam antrean.");
        } else {
            System.out.println("[ERROR] NIM Mahasiswa tidak terdaftar.");
        }
    }

    // Eksekusi penghapusan dari Antrean terdepan (FIFO)
    public void eksekusiHapusQueue() {
        if (!antreanHapusMhs.isEmpty()) {
            Mahasiswa22 mhsDihapus = antreanHapusMhs.poll(); // Ambil dan hapus elemen terdepan FIFO
            
            // Hapus dari List Master Mahasiswa
            listMahasiswa.remove(mhsDihapus);
            
            // Hapus semua data transaksional nilai yang terkait dengan mahasiswa tersebut
            listNilai.removeIf(nilai -> nilai.mhs.nim.equals(mhsDihapus.nim));
            
            System.out.println("[QUEUE SUCCESS] " + mhsDihapus.nama + " (NIM: " + mhsDihapus.nim + ") telah dihapus dari sistem.");
        } else {
            System.out.println("[INFO] Antrean hapus kosong!");
        }
    }

    // Main Engine Menu
    public static void main(String[] args) {
        SistemNilai22 sn = new SistemNilai22();
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n*************************************************");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("*************************************************");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Masukkan ke Antrean Hapus (Queue)");
            System.out.println("6. Eksekusi Hapus Mahasiswa Terdepan (Queue)");
            System.out.println("7. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1: sn.inputNilai(sc); break;
                case 2: sn.tampilNilai(); break;
                case 3: sn.cariNilai(sc); break;
                case 4: sn.urutNilai(); break;
                case 5: sn.masukkanAntreanHapus(sc); break;
                case 6: sn.eksekusiHapusQueue(); break;
                case 7: System.out.println("Keluar dari program."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 7);
        sc.close();
    }
}
