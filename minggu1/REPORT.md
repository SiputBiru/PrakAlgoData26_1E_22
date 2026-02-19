# REPORT

## Getting Started

### Dependencies

* JDK version 11 minimum(cause we can just run java file without actually creating new class file) for the installation refer to [link](https://www.java.com/en/download/manual.jsp)

* Operating System windows or linux compatible with java

* Text Editor (like Vscode or Sublime or vim)

### Executing program

* go to the cloned repo/downloaded

* execute change the FILENAME with the Java file that you want to execute. all of the file is not connected or related. and also change the minggu to the directory you want:

```bash
java {minggu}/src/{filename}.java
```

## Authors

SiputBiru<br>
Nama: Raditya Mahatma Ghosi<br>
NIM: 254107020102<br>
Kelas: TI-1E<br>

## Percobaan 1: Pemilihan

Kode Program:

```java
import java.util.Scanner;

class NilaiAkhirMahasiswa {
  static String nilaiHurufSetara[] = {
      "A",
      "B+",
      "B",
      "C+",
      "C",
      "D",
      "E"
  };

  static Float nilaiSetara[] = {
      4.0f,
      3.5f,
      3.0f,
      2.5f,
      2.0f,
      1.0f,
      0.0f,
  };

  static String nilaiAkhir[] = {
      "Tugas",
      "Kuis",
      "UTS",
      "UAS"
  };

  public static void main(String[] args) {
    System.out.println("Program Menghitung Nilai Akhir");
    System.out.println("==============================");

    Scanner sc = new Scanner(System.in);
    double[] nilaiKotor = new double[4];
    double avg = 0;
    String nilaiHuruf = " ";
    Boolean isValid = true;

    for (int i = 0; i < nilaiAkhir.length; i++) {
      System.out.printf("Masukkan Nilai %-6s : ", nilaiAkhir[i]);
      nilaiKotor[i] = sc.nextDouble();
      if (nilaiKotor[i] > 100 || nilaiKotor[i] < 0) {
        isValid = false;
      }
      switch (nilaiAkhir[i]) {
        case "Tugas":
          avg += (0.2 * nilaiKotor[i]);
          break;
        case "Kuis":
          avg += (0.2 * nilaiKotor[i]);
          break;
        case "UTS":
          avg += (0.3 * nilaiKotor[i]);
          break;
        case "UAS":
          avg += (0.4 * nilaiKotor[i]);
      }
    }
    sc.close();

    if (!isValid || avg == 0) {
      System.out.println("nilai tidak valid!");
      System.out.println("============================");
      System.out.println("============================");
      return;
    }

    if (avg > 80 && avg <= 100) {
      nilaiHuruf = "A";
    } else if (avg > 73 && avg <= 80) {
      nilaiHuruf = "B+";
    } else if (avg > 65 && avg <= 73) {
      nilaiHuruf = "B";
    } else if (avg > 60 && avg <= 65) {
      nilaiHuruf = "C+";
    } else if (avg > 50 && avg <= 60) {
      nilaiHuruf = "C";
    } else if (avg > 39 && avg <= 50) {
      nilaiHuruf = "D";
    } else if (avg <= 39) {
      nilaiHuruf = "E";
    }
    System.out.println("============================");
    System.out.println("============================");
    System.out.printf("Nilai Akhir: %.1f", avg);
    System.out.printf("\nNilai Huruf: %s\n", nilaiHuruf);
    System.out.println("============================");
    System.out.println("============================");
    if (nilaiHuruf.equals("D") || nilaiHuruf.equals("E")) {
      System.out.println("Maaf Anda tidak Lulus!");
      System.out.println("Jangan Putus Asa dan Tetap Semangat!");
    } else {
      System.out.println("Selamat Anda Lulus!");
    }

  }
}
```

### Penjelasan Logika

Program ini menggunakan beberapa konsep dasar pemrograman untuk menyelesaikan masalah:

1. **Input Data**: Menggunakan Scanner untuk mengambil input nilai tugas, kuis, UTS, dan UAS dari pengguna.

2. **Validasi**: Program memeriksa apakah nilai yang dimasukkan berada dalam rentang 0-100.

3. **Perhitungan Bobot**: Nilai akhir (*Avg*) dihitung dengan rumus:

    ```
    Avg = (0.2 * Tugas) + (0.2 * Kuis) + (0.3 * UTS) + (0.4 * UAS)
    ```

4. **Konversi Nilai Huruf**: Menggunakan struktur `if-else if` untuk menentukan nilai huruf (A, B+, B, C+, C, D, E) berdasarkan rentang nilai angka yang didapat.

5. **Penentuan Kelulusan**: Mahasiswa dinyatakan LULUS jika mendapatkan nilai huruf A, B+, B, C+, atau C. Jika mendapatkan D atau E, mahasiswa dinyatakan **TIDAK LULUS**.

## Contoh Hasil Dijalankannya program

### Input Valid

```bash
Program Menghitung Nilai Akhir
==============================
Masukkan Nilai Tugas  : 80
Masukkan Nilai Kuis   : 85
Masukkan Nilai UTS    : 75
Masukkan Nilai UAS    : 80
============================
============================
Nilai Akhir: 87.5
Nilai Huruf: A
============================
============================
Selamat Anda Lulus!
```

### Input Tidak Valid

```bash
Program Menghitung Nilai Akhir
==============================
Masukkan Nilai Tugas  : 1000
Masukkan Nilai Kuis   : 10000
Masukkan Nilai UTS    : 100000
Masukkan Nilai UAS    : 100000
nilai tidak valid!
============================
============================
```

## Percobaan 2: Perulangan (Deretan Bilangan)

### Deskripsi Tugas

Program ini menampilkan deretan bilangan dari angka 1 sampai $n$, di mana $n$ adalah 2 digit terakhir NIM mahasiswa. Jika $n < 10$, maka $n$ akan ditambah 10. Pencetakan deretan memiliki aturan khusus:

1. Bilangan kelipatan 3 dicetak dengan simbol `#`.
2. Bilangan genap (selain kelipatan 3) dicetak sesuai angkanya.
3. Bilangan ganjil dicetak dengan simbol `*`.
4. Angka 10 dan 15 tidak dicetak.

### Kode Program

```java
import java.util.Scanner;

class DeretanBilangan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Input NIM: ");
        String curNim = sc.nextLine();

        // Mengambil 2 digit terakhir NIM
        int n = Integer.parseInt(curNim.substring(curNim.length() - 2));
        if (n < 10) {
            n += 10;
        }

        for (int i = 1; i <= n; i++) {
            // Aturan a: Kelipatan 3 dicetak #
            if (i % 3 == 0) {
              System.out.printf("# ");
            } 
            // Aturan d: Angka 10 dan 15 tidak dicetak
            else if (i == 10 || i == 15) {
              continue;
            } 
            // Aturan b: Genap bukan kelipatan 3 dicetak angkanya
            else if (i % 2 == 0) {
              System.out.printf("%d ", i);
            } 
            // Aturan c: Ganjil dicetak *
            else {
              System.out.printf("* ");
            }
        }
        sc.close();
    }
}
```

### Penjelasan Logika

Logika penyelesaian masalah ini menggunakan teknik manipulasi String dan struktur kontrol perulangan:

1. **Ekstraksi NIM**: Program menggunakan `substring(curNim.length() - 2)` untuk mengambil dua karakter terakhir dari input NIM String, kemudian mengubahnya menjadi integer menggunakan `Integer.parseInt`.

2. **Kondisi n < 10**: Sesuai instruksi, dilakukan pengecekan `if (n < 10)` untuk menambahkan nilai 10 jika digit terakhir kecil.

3. **Perulangan For**: Digunakan `for (int i = 1; i <= n; i++)` untuk menelusuri setiap angka dari 1 hingga *n*.

4. Kontrol Alur (Selection):

* `continue`: Digunakan untuk melewati angka 10 dan 15 tanpa mencetak apa pun ke layar.
* **Prioritas Kondisi**: Urutan `if-else` sangat penting. Kondisi kelipatan 3 diperiksa lebih dulu karena jika sebuah angka genap sekaligus kelipatan 3 (seperti 6), ia harus dicetak sebagai `#` sesuai aturan.

## Contoh Hasil Dijalankannya program

**Input NIM: 2541720102** *(n = 12)*

```bash
Input NIM: 2541720102
* 2 # 4 * # * 8 # * #
```

**Input NIM: 2541720120** *(n = 20)*

```bash
Input NIM: 2541720120
* 2 # 4 * # * 8 # * 14 16 * # * 20

```

## Percobaan 3: Array (Menghitung IP Semester)

### Deskripsi Tugas

Program ini menghitung Indeks Prestasi (IP) semester berdasarkan nilai angka dari beberapa mata kuliah. Program akan melakukan konversi dari nilai angka ke nilai huruf dan bobot nilai sesuai standar akademik, kemudian menghitung rata-rata bobot tersebut sebagai nilai IP.

### Kode Program

```java
import java.util.Scanner;

class HitungIPSem {
    // Array konstanta untuk standar bobot nilai
    static Float nilaiSetara[] = {4.0f, 3.5f, 3.0f, 2.5f, 2.0f, 1.0f, 0.0f};

    static String listmataKuliah[] = {
        "Pancasila", "Konsep Teknologi Informasi", 
        "Critical Thinking dan Problem Solving", "Matematika Dasar", 
        "Bahasa Inggris", "Dasar Pemrograman", 
        "Praktikum Dasar Pemrograman", "Keselamatan dan Kesehatan Kerja"
    };

    static Float nilaiAngka[] = new Float[listmataKuliah.length];
    static String nilaiHuruf[] = new String[listmataKuliah.length];
    static Float bobotNilai[] = new Float[listmataKuliah.length];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Float totBobot = 0.0f;

        System.out.println("=================================================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("=================================================");

        for (int i = 0; i < listmataKuliah.length; i++) {
            System.out.printf("Masukkan nilai Angka untuk MK %s: ", listmataKuliah[i]);

            // Validasi: Input harus berupa angka
            if (!sc.hasNextFloat()) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine(); // Membersihkan buffer
                i--; continue;
            }

            nilaiAngka[i] = sc.nextFloat();

            // Validasi: Rentang nilai 0 - 100
            if (nilaiAngka[i] < 0 || nilaiAngka[i] > 100) {
                System.out.println("Nilai harus di antara 0 - 100!");
                i--; continue;
            }

            // Seleksi kondisi konversi nilai
            if (nilaiAngka[i] > 80) {
                nilaiHuruf[i] = "A"; bobotNilai[i] = nilaiSetara[0];
            } else if (nilaiAngka[i] > 73) {
                nilaiHuruf[i] = "B+"; bobotNilai[i] = nilaiSetara[1];
            } else if (nilaiAngka[i] > 65) {
                nilaiHuruf[i] = "B"; bobotNilai[i] = nilaiSetara[2];
            } else if (nilaiAngka[i] > 60) {
                nilaiHuruf[i] = "C+"; bobotNilai[i] = nilaiSetara[3];
            } else if (nilaiAngka[i] > 50) {
                nilaiHuruf[i] = "C"; bobotNilai[i] = nilaiSetara[4];
            } else if (nilaiAngka[i] > 39) {
                nilaiHuruf[i] = "D"; bobotNilai[i] = nilaiSetara[5];
            } else {
                nilaiHuruf[i] = "E"; bobotNilai[i] = nilaiSetara[6];
            }
            
            totBobot += bobotNilai[i];
        }

        // Penghitungan IP (Rata-rata bobot karena SKS dianggap sama/tidak ditentukan)
        Float ip = totBobot / listmataKuliah.length;

        System.out.println("=================================================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("=================================================");
        System.out.printf("%-40s %-15s %-15s %-15s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        
        for (int i = 0; i < listmataKuliah.length; i++) {
            System.out.printf("%-40s %-15.2f %-15s %-15.2f\n", 
                listmataKuliah[i], nilaiAngka[i], nilaiHuruf[i], bobotNilai[i]);
        }
        System.out.println("=================================================");
        System.out.printf("IP : %.2f\n", ip);
        sc.close();
    }
}
```

### Penjelasan Logika

1. **Penggunaan Parallel Array**: Program menggunakan beberapa array (listmataKuliah, nilaiAngka, nilaiHuruf, bobotNilai) yang saling terhubung melalui indeks yang sama ($i$) untuk menyimpan informasi mata kuliah secara terorganisir.

2. **Validasi Input (Robustness)**:

    * Menggunakan `sc.hasNextFloat()` untuk memastikan input pengguna adalah angka, mencegah program crash jika menerima input teks.

    * Mengecek rentang nilai ($0 \le nilai \le 100$) agar data yang diolah valid secara logika akademik.

3. **Mekanisme Konversi**: Menggunakan struktur `if-else if` untuk memetakan nilai angka ke dalam skala nilai mutu (A hingga E) dan mengambil bobot setara dari array `nilaiSetara`.

4. **Kalkulasi IP**: Karena bobot SKS tidak dicantumkan dalam soal, perhitungan IP dilakukan dengan menjumlahkan seluruh bobotNilai yang didapat, kemudian dibagi dengan total jumlah mata kuliah yang ditempuh.

    $$IP = \frac{\sum BobotNilai}{JumlahMataKuliah}$$

### Hasil Dijalankannya program

```bash
=================================================
Program Menghitung IP Semester
=================================================
Masukkan nilai Angka untuk MK Pancasila: 90
Masukkan nilai Angka untuk MK Konsep Teknologi Informasi: 87
Masukkan nilai Angka untuk MK Critical Thinking dan Problem Solving: 67
Masukkan nilai Angka untuk MK Matematika Dasar: 78
Masukkan nilai Angka untuk MK Bahasa Inggris: 89
Masukkan nilai Angka untuk MK Dasar Pemrograman: 78
Masukkan nilai Angka untuk MK Praktikum Dasar Pemrograman: 89
Masukkan nilai Angka untuk MK Keselamatan dan Kesehatan Kerja: 78
=================================================
Hasil Konversi Nilai
=================================================
MK                                       Nilai Angka     Nilai Huruf     Bobot Nilai
   
Pancasila                                90.00                A             4.00           

Konsep Teknologi Informasi               87.00                A             4.00           

Critical Thinking dan Problem Solving    67.00                B             3.00           

Matematika Dasar                         78.00                B+            3.50           

Bahasa Inggris                           89.00                A             4.00           

Dasar Pemrograman                        78.00                B+            3.50           

Praktikum Dasar Pemrograman              89.00                A             4.00           

Keselamatan dan Kesehatan Kerja          78.00                B+            3.50           
=================================================
IP: 3.69
```

## Percobaan 4: Fungsi

### Deskripsi Tugas

Program ini mensimulasikan manajemen inventaris toko bunga "Royal Garden" yang memiliki beberapa cabang. Program memiliki dua fungsi utama: menampilkan tabel stok bunga saat ini dan menghitung total pendapatan setiap cabang berdasarkan harga satuan setiap jenis bunga jika seluruh stok terjual habis.

### Kode Program

```java
class RoyalGarden {

  static int stokBunga[][] = {
      { 10, 5, 15, 7 },
      { 6, 11, 9, 12 },
      { 2, 10, 10, 5 },
      { 5, 7, 12, 9 },
  };

  static int rincianHarga[] = {
      75_000,
      50_000,
      60_000,
      10_000
  };

  static String[] jenisBunga = {
      "Aglonema",
      "Keladi",
      "Alocasta",
      "Mawar",
  };

  public static void main(String[] args) {
    tampilkanTabelStok();
    hitungPendapatan(stokBunga);
    tampilkanPendapatan();

  }

  static double[] pendapatanPerBunga = new double[jenisBunga.length];
  static double[] pendapatanPerCabang = new double[stokBunga[0].length];

  static void hitungPendapatan(int[][] arr) {
    // hitung pendapatan Per Cabang
    for (int j = 0; j < arr[0].length; j++) {
      double totalCabang = 0;
      for (int i = 0; i < arr.length; i++) {
        totalCabang += (rincianHarga[j] * arr[i][j]);
      }
      pendapatanPerCabang[j] = totalCabang;
    }

    // hitung pendapatan Per Bunga
    for (int i = 0; i < arr.length; i++) {
      double totalBunga = 0;
      for (int j = 0; j < arr[i].length; j++) {
        totalBunga += (rincianHarga[j] * arr[i][j]);
      }
      pendapatanPerBunga[i] = totalBunga;
    }

  }

  static void tampilkanPendapatan() {
    System.out.println("\nLAPORAN PENDAPATAN PER CABANG:");
    System.out.println("======================================================");
    System.out.printf("| %-15s | %-14s | %-15s |\n", "Cabang", "Pendapatan", "Status");
    System.out.println("======================================================");

    for (int i = 0; i < pendapatanPerCabang.length; i++) {
      String status = (pendapatanPerCabang[i] > 1_500_000) ? "Sangat Baik" : "Perlu Evaluasi";

      System.out.printf("| RoyalGarden %-3d | Rp%,12.0f | %-15s |\n",
          i, pendapatanPerCabang[i], status);
    }
    System.out.println("======================================================");
  }

  static void tampilkanTabelStok() {
    System.out.println("DATA STOK BUNGA:");
    System.out.println("\n" + "=".repeat(71));
    System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-10s |\n",
        "", jenisBunga[0], jenisBunga[1], jenisBunga[2], jenisBunga[3]);
    System.out.println("-".repeat(71));

    for (int i = 0; i < stokBunga.length; i++) {
      System.out.printf("| %-15s |", "RoyalGarden " + (i + 1)); // i + 1 agar mulai dari 1
      for (int j = 0; j < stokBunga[i].length; j++) {
        System.out.printf(" %-10d |", stokBunga[i][j]);
      }
      System.out.println();
    }
    System.out.println("=".repeat(71));
  }

}
```

### Penjelasan Logika

Penyelesaian masalah ini memanfaatkan struktur data matriks dan modularitas fungsi:

1. Struktur Data Matriks: Data stok bunga disimpan dalam array dua dimensi `stokBunga[4][4]`, di mana baris mewakili **Cabang Toko** (Royal Garden 1-4) dan kolom mewakili <**Jenis Bunga** (Aglonema, Keladi, Alocasia, Mawar).

2. **Fungsi** `hitungPendapatan`:

    * Fungsi ini melakukan iterasi pada matriks untuk mengalikan jumlah stok dengan `rincianHarga` yang sesuai.

    * **Pendapatan per Cabang**: Dihitung dengan menjumlahkan hasil perkalian harga dan jumlah bunga untuk setiap baris.

    * Hasil perhitungan disimpan ke dalam array `pendapatanPerCabang` untuk ditampilkan kemudian.

3. **Fungsi** `tampilkanTabelStok`: Berfungsi untuk menyajikan data mentah dari array multidimensi ke dalam format tabel yang rapi menggunakan `System.out.printf`.

4. **Penentuan Status**: Menggunakan operator ternary untuk menentukan status cabang. Jika pendapatan $> 1.500.000$, maka berstatus "**Sangat Baik**", selain itu berstatus "**Perlu Evaluasi**".

    **Rumus Pendapatan Cabang:**

    $$Pendapatan_{i} = \sum_{j=0}^{n} (Stok_{i,j} \times Harga_{j})$$

### Hasil Dijalankannya program

```bash
DATA STOK BUNGA:

=======================================================================
|                 | Aglonema   | Keladi     | Alocasta   | Mawar      |
-----------------------------------------------------------------------
| RoyalGarden 1   | 10         | 5          | 15         | 7          |
| RoyalGarden 2   | 6          | 11         | 9          | 12         |
| RoyalGarden 3   | 2          | 10         | 10         | 5          |
| RoyalGarden 4   | 5          | 7          | 12         | 9          |
=======================================================================

LAPORAN PENDAPATAN PER CABANG:
======================================================
| Cabang          | Pendapatan     | Status          |
======================================================
| RoyalGarden 0   | Rp   1,725,000 | Sangat Baik     |
| RoyalGarden 1   | Rp   1,650,000 | Sangat Baik     |
| RoyalGarden 2   | Rp   2,760,000 | Sangat Baik     |
| RoyalGarden 3   | Rp     330,000 | Perlu Evaluasi  |
======================================================
```

## Tugas 1 (Pencarian Kode Plat Mobil)

### Deskripsi Tugas

Program ini dirancang untuk memetakan kode plat nomor kendaraan (karakter tunggal) ke nama kota yang sesuai di Indonesia. Program menggunakan dua struktur data utama: array satu dimensi KODE untuk menyimpan inisial plat secara terurut, dan array dua dimensi KOTA yang bertipe char untuk menyimpan nama kota secara mendetail per karakter.

### Kode Program

```java
import java.util.Scanner;

class KodePlatMobil {
  public static void main(String[] args) {
    char[] KODE = { 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T' };

    char[][] KOTA = {
        { 'B', 'A', 'N', 'T', 'E', 'N' },
        { 'J', 'A', 'K', 'A', 'R', 'T', 'A' },
        { 'B', 'A', 'N', 'D', 'U', 'N', 'G' },
        { 'C', 'I', 'R', 'E', 'B', 'O', 'N' },
        { 'B', 'O', 'G', 'O', 'R' },
        { 'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N' },
        { 'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G' },
        { 'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A' },
        { 'M', 'A', 'L', 'A', 'N', 'G' },
        { 'T', 'E', 'G', 'A', 'L' }
    };

    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Kode Plat: ");
    char input = sc.next().toUpperCase().charAt(0);

    int hasilIndeks = binarySearch(KODE, input);

    if (hasilIndeks != -1) {
      System.out.print("Kota: ");
      for (char c : KOTA[hasilIndeks]) {
        System.out.print(c);
      }
      System.out.println();
    } else {
      System.out.println("Kode plat tidak ditemukan.");
    }
    sc.close();
  }

  // Fungsi Binary Search
  private static int binarySearch(char[] arr, char x) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      // Cek apakah x ada di tengah
      if (arr[mid] == x)
        return mid;

      // Jika x lebih besar, abaikan bagian kiri
      if (arr[mid] < x)
        left = mid + 1;

      // Jika x lebih kecil, abaikan bagian kanan
      else
        right = mid - 1;
    }
    return -1; // Tidak ditemukan
  }
}
```

### Penjelasan Logika

Program ini bekerja dengan cara menerima input karakter kode plat dari pengguna, kemudian menggunakan algoritma Binary Search untuk mencari posisi indeks karakter tersebut di dalam array `KODE`. Karena array `KODE` sudah disusun secara alfabetis (A hingga T), algoritma **Binary Search** dapat bekerja secara efisien dengan terus membagi dua area pencarian hingga target ditemukan atau area pencarian habis. Setelah indeks ditemukan, program akan menggunakan indeks yang sama untuk mengakses baris tertentu pada array dua dimensi `KOTA` dan mencetak seluruh karakter di baris tersebut menggunakan perulangan, sehingga menghasilkan output nama kota yang utuh sesuai dengan kode plat yang diinputkan.

### Contoh Hasil Dijalankannya program

```bashMasukkan
Kode Plat: N
Kota: MALANG

Masukkan Kode Plat: Z
Kode plat tidak ditemukan.
```

## Tugas 2 (Kelola Jadwal Kuliah mahasiswa)

### Deskripsi Tugas

Tujuan dari tugas ini adalah membangun sebuah sistem informasi sederhana untuk mengelola jadwal kuliah mahasiswa menggunakan struktur data array dan fungsi di Java. Program ini memiliki kemampuan untuk menyimpan data jadwal dalam jumlah dinamis ($n$), menampilkan seluruh daftar jadwal dalam format tabel, serta melakukan pencarian spesifik berdasarkan filter hari atau nama mata kuliah tertentu.

### Kode Program

```java
import java.util.Scanner;

public class JadwalKuliah {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Masukkan jumlah jadwal kuliah (n): ");
    int n = sc.nextInt();
    sc.nextLine();

    String[][] jadwal = new String[n][4];

    inputData(jadwal);
    tampilkanSeluruh(jadwal);

    System.out.print("\nCari jadwal berdasarkan hari: ");
    String cariHari = sc.nextLine();
    tampilkanBerdasarkanHari(jadwal, cariHari);

    System.out.print("\nCari jadwal berdasarkan nama mata kuliah: ");
    String cariMK = sc.nextLine();
    tampilkanBerdasarkanMK(jadwal, cariMK);
  }

  static void inputData(String[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println("\nInput Jadwal ke-" + (i + 1));
      System.out.print("Nama Mata Kuliah: ");
        arr[i][0] = sc.nextLine();
        System.out.print("Ruang           : ");
        arr[i][1] = sc.nextLine();
        System.out.print("Hari            : ");
        arr[i][2] = sc.nextLine();
        System.out.print("Jam             : ");
        arr[i][3] = sc.nextLine();
    }
  }

  static void tampilkanSeluruh(String[][] arr) {
    System.out.println("\n====================================================================");
    System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", "Mata Kuliah", "Ruang", "Hari", "Jam");
    System.out.println("====================================================================");
    for (String[] baris : arr) {
      System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", baris[0], baris[1], baris[2], baris[3]);
    }
  }

  static void tampilkanBerdasarkanHari(String[][] arr, String hari) {
    System.out.println("\nJadwal pada hari " + hari + ":");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][2].equalsIgnoreCase(hari)) {
        System.out.printf("- %s (%s) Jam: %s\n", arr[i][0], arr[i][1], arr[i][3]);
      }
    }
  }

  static void tampilkanBerdasarkanMK(String[][] arr, String mk) {
    System.out.println("\nDetail Mata Kuliah " + mk + ":");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][0].equalsIgnoreCase(mk)) {
        System.out.println("Ruang: " + arr[i][1] + " | Hari: " + arr[i][2] + " | Jam: " + arr[i][3]);
      }
    }
  }
}

```

### Penjelasan Logika

* **Penyimpanan Data (Array 2D)**: Seluruh informasi jadwal disimpan dalam sebuah matriks String `jadwal[n][4]`. Indeks baris merepresentasikan urutan jadwal, sedangkan empat indeks kolom digunakan secara konsisten untuk menyimpan informasi spesifik: Nama Mata Kuliah (indeks 0), Ruang (indeks 1), Hari (indeks 2), dan Jam Kuliah (indeks 3).

* **Modularitas Fungsi**: Program dibagi menjadi empat fungsi utama untuk menangani tugas yang berbeda: `inputData` untuk pengisian array, `tampilkanSeluruh` untuk mencetak tabel, serta dua fungsi pencarian yaitu `tampilkanBerdasarkanHari` dan `tampilkanBerdasarkanMK`.

* **Mekanisme Pencarian (Linear Search)**: Untuk filtering, program ini menggunakan metode pencarian linear dengan melakukan iterasi (perulangan) pada seluruh baris array. Program akan membandingkan input pengguna dengan nilai yang tersimpan di kolom hari (indeks 2) atau kolom nama MK (indeks 0) menggunakan metode `.equalsIgnoreCase()` agar hasil pencarian akurat tanpa mempedulikan penggunaan huruf kapital.

### Contoh Hasil Dijalankannya program

```bash
Masukkan jumlah jadwal kuliah (n): 2

Input Jadwal ke-1
Nama Mata Kuliah: Dasar Pemrograman
Ruang           : Lab 1
Hari            : Senin
Jam             : 08.00-10.00

====================================================================
| Mata Kuliah          | Ruang      | Hari       | Jam        |
====================================================================
| Dasar Pemrograman    | Lab 1      | Senin      | 08.00-10.00|
...
```
