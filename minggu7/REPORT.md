
# REPORT

## Percobaan 1: Mengimplementasikan Sorting menggunakan object

### Kode Program

Mahasiswa22.java

```java
public class Mahasiswa22 {
  String nim;
  String nama;
  String kelas;
  double ipk;

  Mahasiswa22() {

  }

  Mahasiswa22(String nm, String name, String kls, double ip) {
    nim = nm;
    nama = name;
    ipk = ip;
    kelas = kls;
  }

  void tampilInformasi() {
    System.out.println("Nama: " + nama);
    System.out.println("NIM: " + nim);
    System.out.println("kelas: " + kelas);
    System.out.println("IPK: " + ipk);
  }
}
```

MahasiswaBerprestasi22.java

```java
public class MahasiswaBerprestasi22 {
  // kita ubah menjadi dinamis
  Mahasiswa22 listMhs[] = new Mahasiswa22[5];

  // Mahasiswa22 listMhs[];
  int idx;

  public MahasiswaBerprestasi22(int kapasitas) {
    listMhs = new Mahasiswa22[kapasitas];
    idx = 0;
  }

  void tambah(Mahasiswa22 m) {
    if (idx < listMhs.length) {
      listMhs[idx] = m;
      idx++;
    } else {
      System.out.println("data sudah penuh");
    }
  }

  void tampil() {
    for (Mahasiswa22 m : listMhs) {
      m.tampilInformasi();
      System.out.println("---------------------------------");
    }
  }

  void bubbleSort() {
    for (int i = 0; i < listMhs.length; i++) {
      for (int j = 1; j < listMhs.length - i; j++) {
        if (listMhs[j].ipk > listMhs[j - 1].ipk) {
          Mahasiswa22 tmp = listMhs[j];
          listMhs[j] = listMhs[j - 1];
          listMhs[j - 1] = tmp;
        }
      }
    }
  }

  // Mengurutkan Data Mahasiswa Berdasarkan IPK (Selection Sort
  void selectionSort() {
    for (int i = 0; i < listMhs.length - 1; i++) {
      int idxMin = i;
      for (int j = i + 1; j < listMhs.length; j++) {
        if (listMhs[j].ipk < listMhs[idxMin].ipk) {
          idxMin = j;
        }
      }
      Mahasiswa22 tmp = listMhs[idxMin];
      listMhs[idxMin] = listMhs[i];
      listMhs[i] = tmp;
    }
  }

  // Mengurutkan Data Mahasiswa Berdasarkan IPK Menggunakan Insertion Sort
  void InsertionSort() {
    for (int i = 1; i < listMhs.length; i++) {
      Mahasiswa22 temp = listMhs[i];
      int j = i;
      // while (j > 0 && listMhs[j - 1].ipk > temp.ipk) {
      while (j > 0 && listMhs[j - 1].ipk < temp.ipk) {
        listMhs[j] = listMhs[j - 1];
        j--;
      }
      listMhs[j] = temp;
    }
  }

  // SequntialSearching
  int sequntialSearching(double cari) {
    int posisi = -1; // kita buat base case jika tidak mendapatkan apa yang dicari
    for (int j = 0; j < listMhs.length; j++) {
      if (listMhs[j].ipk == cari) {
        posisi = j;
        break;
      }
    }

    return posisi;
  }

  void tampilPosisi(double x, int pos) {
    if (pos != -1) {
      System.out.println("data Mahasiswa dengan IPK :" + x + " ditemukan pada indesk" + pos);
    } else {
      System.out.println("data " + x + " tidak ditemukan");
    }
  }

  void tampilDataSearch(double x, int pos) {
    if (pos != -1) {
      System.out.println("nim\t : " + listMhs[pos].nim);
      System.out.println("nama\t : " + listMhs[pos].nama);
      System.out.println("kelas\t : " + listMhs[pos].kelas);
      System.out.println("ipk\t : " + x);
    } else {
      System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
    }
  }

}
```

MahasiswaDemo22.java

```java
import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22(5);
    Scanner sc = new Scanner(System.in);

    int jumMhs = 5;

    for (int i = 0; i < jumMhs; i++) {
      System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
      System.out.print("NIM    : ");
      String nim = sc.nextLine();
      System.out.print("Nama   : ");
      String nama = sc.nextLine();
      System.out.print("Kelas  : ");
      String kelas = sc.nextLine();
      System.out.print("IPK    : ");
      String ip = sc.nextLine();
      double ipk = Double.parseDouble(ip);
      System.out.println("------------------------------------");

      list.tambah(new Mahasiswa22(nim, nama, kelas, ipk));
    }

    list.tampil();

    System.out.println("-------------------------------------------------------");
    System.out.println("Pencarian data");
    System.out.println("-------------------------------------------------------");
    System.out.println("masukkan ipk mahasiswa yang dicari: ");
    System.out.print("IPK: ");
    double cari = sc.nextDouble();

    System.out.println("menggunakan sequential searching");

    double posisi = list.sequentialSearching(cari);
    int pss = (int) posisi;

    list.tampilPosisi(cari, pss);
    list.tampilDataSearch(cari, pss);
  }
}

```

output:

```bash
✗ java MahasiswaDemo22.java < ./test.in
Masukkan Data Mahasiswa ke-1
NIM    : Nama   : Kelas  : IPK    : ------------------------------------
Masukkan Data Mahasiswa ke-2
NIM    : Nama   : Kelas  : IPK    : ------------------------------------
Masukkan Data Mahasiswa ke-3
NIM    : Nama   : Kelas  : IPK    : ------------------------------------
Masukkan Data Mahasiswa ke-4
NIM    : Nama   : Kelas  : IPK    : ------------------------------------
Masukkan Data Mahasiswa ke-5
NIM    : Nama   : Kelas  : IPK    : ------------------------------------
Nama: adi
NIM: 111
kelas: 2
IPK: 3.6
---------------------------------
Nama: tio
NIM: 222
kelas: 2
IPK: 3.8
---------------------------------
Nama: ila
NIM: 333
kelas: 2
IPK: 3.0
---------------------------------
Nama: lia
NIM: 444
kelas: 2
IPK: 3.5
---------------------------------
Nama: fia
NIM: 555
kelas: 2
IPK: 3.3
---------------------------------
-------------------------------------------------------
Pencarian data
-------------------------------------------------------
masukkan ipk mahasiswa yang dicari:
IPK: menggunakan sequential searching
data Mahasiswa dengan IPK :3.5 ditemukan pada indesk3
nim      : 444
nama     : lia
kelas    : 2
ipk      : 3.5
```

### Jawaban pertanyaan

1\. pertanyaan: "Jelaskan perbedaan method tampilDataSearch dan tampilPosisi pada class MahasiswaBerprestasi22!"

```java
if (data[j - 1] > data[j]) {
  temp = data[j];
  data[j] = data[j - 1];
  data[j - 1] = temp;
}
```
  
jawab:

- tampilPosisi: Berfungsi untuk menginformasikan apakah data yang dicari ditemukan atau tidak. Jika ditemukan, method ini hanya menampilkan nomor indeks tempat data tersebut berada dalam array.

- tampilDataSearch: Berfungsi untuk menampilkan detail informasi objek (seperti NIM, Nama, dan Kelas) dari mahasiswa yang berada pada indeks hasil pencarian tersebut.

2\. pertanyaan: "Jelaskan fungsi break pada kode program di bawah ini!"

```java
if (listMhs[j].ipk == cari) {
    posisi = j;
    break;
}
```

Fungsi break: Digunakan untuk menghentikan paksa perulangan (for) segera setelah data yang dicari ditemukan. Hal ini dilakukan untuk efisiensi program; jika data sudah ketemu di awal, program tidak perlu lagi memeriksa sisa elemen array lainnya.

3\. pertanyaan: "Apa fungsi variabel pos atau indeks hasil pencarian dalam program sequential search?"

- Variabel pos (atau posisi) berfungsi sebagai penanda (flag) sekaligus penyimpan lokasi.

  - Jika data ditemukan, ia menyimpan nomor indeks data tersebut agar bisa diakses kembali untuk ditampilkan detailnya.

  - Jika data tidak ditemukan, ia tetap bernilai `-1`, yang menjadi indikator bagi method lain bahwa pencarian gagal.

4\. pertanyaan: "Jika terdapat lebih dari satu data dengan nilai yang sama, hasil pencarian sequential search yang dibuat di atas akan menampilkan data ke-berapa? Jelaskan."

- Pencarian akan menampilkan data yang pertama kali ditemukan (data dengan indeks terkecil).

- Penjelasan: Hal ini dikarenakan adanya perintah `break`. Begitu program menemukan kecocokan pertama pada indeks `j`, program akan langsung menyimpan nilai tersebut ke variabel `posisi` dan keluar dari perulangan, sehingga data serupa di indeks setelahnya tidak akan pernah diperiksa.

5\. Berkaitan dengan pertanyaan nomor 2 di atas, apa yang terjadi jika perintah `break` dihapus dari kode di atas?

- Program akan terus melakukan perulangan hingga akhir array meskipun data sudah ditemukan.

- Jika ada data dengan nilai yang sama (duplikat), variabel `posisi` akan terus diperbarui dan hasil akhirnya adalah indeks dari data yang terakhir ditemukan (data dengan indeks terbesar).

- Secara performa, program menjadi kurang efisien karena melakukan iterasi yang tidak diperlukan setelah target ditemukan.

## Percobaan 2: Searching/Pencarian Menggunakan Algoritma Binary Search

kode program:

MahasiswaBerprestasi22.java

```java
  int findBinarySearch(double cari, int left, int right) {

    int mid;
    if (right >= left) {
      mid = (left + right) / 2;
      if (cari == listMhs[mid].ipk) {
        return mid;
      } else if (listMhs[mid].ipk > cari) {
        return findBinarySearch(cari, left, mid);
      } else {
        return findBinarySearch(cari, mid + 1, right);
      }

    }

    return -1;
  }

```
