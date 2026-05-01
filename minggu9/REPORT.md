# REPORT

## Percobaan 1: Mahasiswa Mengumpulkan Tugas

### Kode Program

Mahasiswa22.java

```java
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
```

StackTugasMahasiswa22.java

```java
class StackTugasMahasiswa22 {
  int size, top;
  Mahasiswa22[] stack;

  StackTugasMahasiswa22(int size) {
    this.size = size;
    stack = new Mahasiswa22[this.size];
    top = -1;
  }

  boolean isFull() {
    if (top == size - 1) {
      return true;
    } else {
      return false;
    }
  }

  boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  void push(Mahasiswa22 mhs) {
    if (this.isFull()) {
      System.out.println("\u001B[31mStack penuh! Tidak bisa menambahkan tugas lagi.\u001B[0m");
      return;
    }
    top++;
    this.stack[top] = mhs;
  }

  Mahasiswa22 pop() {
    if (isEmpty()) {
      System.out.println("\u001B[31mStack kosong! Tidak ada tugas untuk dinilai.\u001B[0m");
      return null;
    }
    Mahasiswa22 val = this.stack[top];
    top--;
    return val;
  }

  Mahasiswa22 peek() {
    if (this.isEmpty()) {
      System.out.println("\u001B[31mStack kosong! Tidak ada tugas untuk dinilai.\u001B[0m");
      return null;
    }
    return this.stack[top];
  }

  void print() {
    for (int i = top; i >= 0; i--) {
      System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
  }

}
```

MahasiswaDemo22.java

```java
import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    StackTugasMahasiswa22 stack = new StackTugasMahasiswa22(5);

    Scanner sc = new Scanner(System.in);

    int pilih = 0;

    do {

      System.out.println("\nMenu");
      System.out.println("1. Mengumpulkan Tugas");
      System.out.println("2. Menilai Tugas");
      System.out.println("3. Melihat Tugas Teratas");
      System.out.println("4. Melihat Daftar Tugas");
      System.out.print("Pilih: ");

      if (!sc.hasNextInt()) {
        break;
      }
      pilih = sc.nextInt();
      sc.nextLine();

      switch (pilih) {
        case 1:
          System.out.print("Nama: ");
          String nama = sc.nextLine();
          System.out.print("NIM: ");
          String nim = sc.nextLine();
          System.out.print("Kelas: ");
          String kelas = sc.nextLine();
          Mahasiswa22 mhs = new Mahasiswa22(nim, nama, kelas);
          stack.push(mhs);
          System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
          break;
        case 2:
          Mahasiswa22 dinilai = stack.pop();
          if (dinilai != null) {
            System.out.println("Menilai tugas dari " + dinilai.nama);
            System.out.print("Masukkan nilai diantara (0-100): ");
            int nilai = sc.nextInt();
            dinilai.tugasDinilai(nilai);
            System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
          }
          break;

        case 3:
          Mahasiswa22 lihat = stack.peek();
          if (lihat != null) {
            System.out.println("Tugas akhir dikumpulkan oleh " + lihat.nama);
          }
          break;
        case 4:
          System.out.println("Daftar semua tugas.");
          System.out.println("Nama\tNIM\tKelas");
          stack.print();
          break;
        default:
          System.out.println("Pilihan tidak valid.");
      }

    } while (pilih >= 1 && pilih <= 4);

    sc.close();
  }
}
```

Kita buatkan file input agar inputting data tidak manual:
1.in

```txt

```

output:

```bash
❯ java ./MahasiswaDemo22.java < ./1.in

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Stack kosong! Tidak ada tugas untuk dinilai.

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Nama: NIM: Kelas: Tugas Dila berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Nama: NIM: Kelas: Tugas Erik berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Tugas akhir dikumpulkan oleh Erik

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Nama: NIM: Kelas: Tugas Tika berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Daftar semua tugas.
Nama    NIM     Kelas
Tika    1003    1C
Erik    1002    1B
Dila    1001    1A

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Menilai tugas dari Tika
Masukkan nilai diantara (0-100): Nilai Tugas Tika adalah 87

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Daftar semua tugas.
Nama    NIM     Kelas
Dila    1001    1A
Erik    1002    1B


Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: Pilihan tidak valid.
```

### Jawaban pertanyaan

1\. pertanyaan: "Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana yang perlu diperbaiki?"

jawab:

kita hanya perlu mengubah kondisi pada loop pada fungsi print class Mahasiswa22
sebelum:

```java
  // Mahasiswa22.java
  void print() {
    for (int i = 0; i <= top; i++) {
      System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
  }

```

sesudah:

```java
  // Mahasiswa22.java
  void print() {
+    for (int i = top; i >= 0; i--) { // kita balik dari top/atas ke bawah
      System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
  }
```

2\. pertanyaan: "Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan kode programnya!"

jawab:
Seberapa banyak data yang dapat dimasukkan adalah tergantung pada instansiasi kita memberikan berapa banyak

```java
  // MahasiswaDemo22.java
  public static void main(String[] args) {
    StackTugasMahasiswa22 stack = new StackTugasMahasiswa22(5); // pada titik inilah kita memberikan batasan dari stack nya

    Scanner sc = new Scanner(System.in);

    int pilih = 0;

```

3\. pertanyaan: "Mengapa perlu pengecekan kondisi !isFull() pada method push? Kalau kondisi if-else tersebut dihapus, apa dampaknya?"

jawab:

Penggunakan dan pembuatan fungsi isFull adalah untuk mengetahui apakah stack tersebut penuh atau tidak, jika kita tidak memberikan batasan tersebut ada kemungkinan user akan melakukan push yang melebihi size/ukuran stack yang sebelumnya di instansiasi.

4\. pertanyaan: "Modifikasi kode program pada class MahasiswaDemo dan StackTugasMahasiswa sehingga pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi lihat tugas terbawah!"

jawab:
dikarenakan kita menggunakan array kita hanya memerlukan untuk membuat method baru peekBottom yang akan melakukan return `this.stack[0]`

StackTugasMahasiswa22.java

```java
public Mahasiswa22 peekBottom() {
    if (this.isEmpty()) {
        System.out.println("\u001B[31mStack kosong! Tidak ada tugas.\u001B[0m");
        return null;
    }
    // Elemen pertama yang masuk berada di indeks 0
    return this.stack[0];
}
```

lalu kita tambahkan case baru pada MahasiswaDemo

```java
case 6:
    Mahasiswa22 bawah = stack.peekBottom();
    if (bawah != null) {
        System.out.println("Tugas pertama kali dikumpulkan oleh: " + bawah.nama);
    }
    break;
```

contoh ouput:

```bash
❯ java MahasiswaDemo22.java

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
Pilih: 1
Nama: Udin
NIM: 102938123
Kelas: 1B
Tugas Udin berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
Pilih: 1
Nama: Marwa
NIM: 102931209
Kelas: 1E
Tugas Marwa berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
Pilih: 1
Nama: Marwa
NIM: 1029381203
Kelas: 1D
Tugas Marwa berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
Pilih: 6
Tugas pertama kali dikumpulkan oleh: Udin
```

5\. pertanyaan: "Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat ini, serta tambahkan operasi menunya"

jawab:

kita hanya perlu menggunakan top yang nantinya kita tambahkan 1 untuk memberikan current ukuran dari stack:

StackTugasMahasiswa22.java

```java
  int count() {
    return top + 1;
  }

```

lalu tambahkan case baru

MahasiswaDemo22.java

```java
        case 7:
          int jumlah = stack.count();
          System.out.println("Jumlah tugas dalam stack saat ini: " + jumlah);
          break;
```

contoh output:

```bash
❯ java MahasiswaDemo22.java

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 1
Nama: udin
NIM: 1023981923
Kelas: 1D
Tugas udin berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 1
Nama: Marwa
NIM: 102398123
Kelas: 1C
Tugas Marwa berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 7
Jumlah tugas dalam stack saat ini: 2

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 0
```

## Percobaan 2: Konversi Nilai Tugas ke Biner

kode program

StackKonversi.java

```java
public class StackKonversi {
  int[] tumpukanBiner;
  int size;
  int top;

  public StackKonversi() {
    this.size = 32;
    tumpukanBiner = new int[size];
    top = -1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == size - 1;
  }

  public void push(int data) {
    if (isFull()) {
      System.out.println("Stack penuh");
    } else {
      top++;
      tumpukanBiner[top] = data;
    }

  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack Kosong");
      return -1;
    } else {
      int data = tumpukanBiner[top];
      top--;
      return data;
    }
  }
}
```

StackTugasMahasiswa22.java

```java
  String konversiDesimalKeBiner(int nilai) {
    StackKonversi stack = new StackKonversi();
    while (nilai > 0) {
      int sisa = nilai % 2;
      stack.push(sisa);
      nilai = nilai / 2;

    }
    String biner = new String();

    while (!stack.isEmpty()) {
      biner += stack.pop();
    }
    return biner;

  }
```

output:

```bash
❯ java MahasiswaDemo22.java

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 1
Nama: Tika
NIM: 12093812903
Kelas: 1E
Tugas Tika berhasil dikumpulkan

Menu
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
5. Melihat Daftar Tugas(dari bawah)
6. Melihat Tugas pertama kali dikumpulkan
7. Menghitung Jumlah Tugas
Pilih: 2
Menilai tugas dari Tika
Masukkan nilai diantara (0-100): 90
Nilai Tugas Tika adalah 90
Nilai biner Tugas: 1011010
```

### Jawaban pertanyaan

1\. Jelaskan alur kerja dari method konversiDesimalKeBiner!

jawab:

- Method ini menggunakan prinsip LIFO (Last In First Out) dari Stack untuk membalik urutan sisa pembagian agar menjadi urutan biner yang benar. Alurnya adalah sebagai berikut:  
- Inisialisasi: Sebuah objek `StackKonversi` dibuat untuk menyimpan sisa pembagian, dan sebuah variabel `String biner` disiapkan sebagai wadah hasil akhir.  
- Proses Pembagian (Iterasi Pertama): Selama nilai desimal lebih besar dari 0, sistem akan menghitung sisa bagi (`nilai % 2`).  
Penyimpanan (Push): Sisa bagi tersebut (angka 0 atau 1) dimasukkan ke dalam stack. Kemudian, nilai desimal dibagi dua (`nilai / 2`) untuk iterasi berikutnya.  
- Penyusunan String (Iterasi Kedua): Setelah nilai desimal habis (0), data diambil keluar dari stack menggunakan `pop()` satu per satu.  
- Penggabungan: Karena stack bersifat terbalik, sisa bagi yang terakhir masuk (angka biner paling depan/signifikan) akan keluar pertama kali dan digabungkan ke dalam string `biner` hingga stack kosong.  

2\. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0), bagaimana hasilnya? Jelaskan alasannya!

jawab:

bentuk perubahan akan seperti ini:

```java
  String konversiDesimalKeBiner(int nilai) {
    StackKonversi stack = new StackKonversi();
    while (nilai != 0) { // diubah menjadi nilai != 0
      int sisa = nilai % 2;
      stack.push(sisa);
      nilai = nilai / 2;
    }
    String biner = new String();

    while (!stack.isEmpty()) {
      biner += stack.pop();
    }
    return biner;
  }
```

Penjelasan:

- Logika Berhenti yang Sama: Untuk bilangan desimal positif, proses pembagian akan terus dilakukan hingga nilai mencapai angka 0. Kondisi `nilai > 0` dan `nilai != 0` akan memberikan hasil evaluasi `false` yang sama persis ketika nilai sudah mencapai 0, sehingga perulangan berhenti di titik yang sama.  
- Penanganan Bilangan Bulat: Dalam Java, pembagian integer (bilangan bulat) akan membuang angka di belakang koma. Misalnya, $1 / 2$ akan menghasilkan $0$. Begitu nilai menjadi $0$, kedua kondisi tersebut (`> 0` maupun `!= 0`) sama-sama akan menghentikan proses perulangan.  
- Perbedaan Teoritis: Perbedaan baru akan muncul jika input yang diberikan adalah bilangan negatif. Kondisi `nilai != 0` akan menyebabkan infinite loop (perulangan tak terbatas) atau hasil yang tidak valid pada bilangan negatif, sedangkan `nilai > 0` akan langsung melewati perulangan tersebut. Namun, dalam konteks konversi nilai tugas (0-100), kedua kondisi ini bekerja secara identik.

## Latihan Praktikum

Kode program

Surat22.java

```java
public class Surat22 {
  String idSurat, namaMahasiswa, kelas;
  char jenisIzin;
  int durasi;

  public Surat22() {
  }

  public Surat22(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
    this.idSurat = idSurat;
    this.namaMahasiswa = namaMahasiswa;
    this.kelas = kelas;
    this.jenisIzin = jenisIzin;
    this.durasi = durasi;
  }
}
```

StackSuratIzin22.java

```java
public class StackSuratIzin22 {
    int size, top;
    Surat22[] stack;

    public StackSuratIzin22(int size) {
        this.size = size;
        stack = new Surat22[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat22 srt) {
        if (!isFull()) {
            top++;
            stack[top] = srt;
        } else {
            System.out.println("Stack Penuh! Tidak bisa menerima surat lagi.");
        }
    }

    public Surat22 pop() {
        if (!isEmpty()) {
            Surat22 srt = stack[top];
            top--;
            return srt;
        } else {
            System.out.println("Stack Kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat22 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Tidak ada surat di dalam tumpukan.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat ditemukan pada posisi ke-" + (top - i + 1) + " dari atas.");
                System.out.println("ID Surat: " + stack[i].idSurat + " | Jenis: " + stack[i].jenisIzin);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama " + nama + " tidak ditemukan.");
        }
    }
}
```

SuratIzinDemo22.java

```java
import java.util.Scanner;

public class SuratIzinDemo22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSuratIzin22 stack = new StackSuratIzin22(10);
        int pilih;

        do {
            System.out.println("\n--- Sistem Pengelolaan Surat Izin ---");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin (Pop)");
            System.out.println("3. Lihat Surat Izin Terakhir (Peek)");
            System.out.println("4. Cari Surat (Berdasarkan Nama)");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            pilih = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = sc.next().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = sc.nextInt();
                    
                    Surat22 srt = new Surat22(id, nama, kelas, jenis, durasi);
                    stack.push(srt);
                    break;

                case 2:
                    Surat22 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Memproses surat milik: " + diproses.namaMahasiswa);
                    }
                    break;

                case 3:
                    Surat22 terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("Surat teratas adalah milik: " + terakhir.namaMahasiswa);
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cariNama = sc.nextLine();
                    stack.cariSurat(cariNama);
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 5);
        sc.close();
    }
}
```

output:

```bash
❯ java ./SuratIzinDemo22.java

--- Sistem Pengelolaan Surat Izin ---
1. Terima Surat Izin
2. Proses Surat Izin (Pop)
3. Lihat Surat Izin Terakhir (Peek)
4. Cari Surat (Berdasarkan Nama)
5. Keluar
Pilih Menu: 1
ID Surat: 10293
Nama Mahasiswa: Udin
Kelas: 1B
Jenis Izin (S/I): S
Durasi (hari): 20

--- Sistem Pengelolaan Surat Izin ---
1. Terima Surat Izin
2. Proses Surat Izin (Pop)
3. Lihat Surat Izin Terakhir (Peek)
4. Cari Surat (Berdasarkan Nama)
5. Keluar
Pilih Menu: 3
Surat teratas adalah milik: Udin

--- Sistem Pengelolaan Surat Izin ---
1. Terima Surat Izin
2. Proses Surat Izin (Pop)
3. Lihat Surat Izin Terakhir (Peek)
4. Cari Surat (Berdasarkan Nama)
5. Keluar
Pilih Menu: 4
Masukkan nama mahasiswa yang dicari: leah
Surat atas nama leah tidak ditemukan.

--- Sistem Pengelolaan Surat Izin ---
1. Terima Surat Izin
2. Proses Surat Izin (Pop)
3. Lihat Surat Izin Terakhir (Peek)
4. Cari Surat (Berdasarkan Nama)
5. Keluar
Pilih Menu: 4
Masukkan nama mahasiswa yang dicari: Udin
Surat ditemukan pada posisi ke-1 dari atas.
ID Surat: 10293 | Jenis: S
```

Penjelasan Singkat:

- **LIFO Principle**: Surat yang terakhir masuk akan menjadi yang pertama diproses (menu 2).  

- **Pencarian**: Menu 4 melakukan iterasi dari `top` ke bawah untuk mencari kesesuaian nama mahasiswa.

- **Jenis Izin**: Menggunakan tipe data `char` ('S' untuk Sakit, 'I' untuk Izin) sesuai dengan diagram yang diminta
