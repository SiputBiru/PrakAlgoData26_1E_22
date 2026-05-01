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
