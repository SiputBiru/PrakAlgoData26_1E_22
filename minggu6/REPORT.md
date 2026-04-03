# REPORT

## Percobaan 1: Mengimplementasikan Sorting menggunakan object

### Kode Program

Sorting22.java

```java
public class Sorting22 {
  int[] data;
  int jumData;

  Sorting22(int Data[], int jmlDat) {
    jumData = jmlDat;
    data = new int[jmlDat];
    for (int i = 0; i < jumData; i++) {
      data[i] = Data[i];
    }
  }

  void tampil() {
    for (int i = 0; i < jumData; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }

  void bubbleSort() {
    for (int i = 0; i < jumData - 1; i++) {
      for (int j = 1; j < jumData - i - 1; j++) {
        if (data[j - 1] > data[j]) {
          // int temp = data[j];
          // data[j] = data[j - 1];
          // data[j - 1] = temp;

          data[j] ^= data[j - 1];
          data[j - 1] ^= data[j];
          data[j] ^= data[j - 1];

        }
      }
    }
  }

  void SelectionSort() {
    for (int i = 0; i < jumData; i++) {
      int min = i;
      for (int j = i + 1; j < jumData; j++) {
        if (data[j] < data[min]) {
          min = j;
        }
      }
      int temp = data[i];
      data[i] = data[min];
      data[min] = temp;
    }
  }

  void InsertionSort() {
    for (int i = 0; i < jumData; i++) {
      int temp = data[i];
      int j = i - 1;
      while (j >= 0 && data[j] > temp) {
        data[j + 1] = data[j];
        j--;
      }
      data[j + 1] = temp;
    }
  }
}
```

SortingMain22.java

```java
{
  public static void main(String[] args) {
    int a[] = { 20, 10, 2, 7, 12 };

    Sorting22 dataurut1 = new Sorting22(a, a.length);

    System.out.println("Data awal 1");
    dataurut1.tampil();
    dataurut1.bubbleSort();
    System.out.println("Data sudah diurut dengan BUBBLE SORT (ASC)");
    dataurut1.tampil();

    int b[] = { 30, 20, 2, 8, 14 };
    Sorting22 dataurut2 = new Sorting22(b, b.length);
    System.out.println("\nData awal 2");
    dataurut2.tampil();
    dataurut2.SelectionSort();
    System.out.println("Data sudah diurut dengan SELECTION SORT (ASC)");
    dataurut2.tampil();

    int c[] = { 40, 10, 4, 9, 3 };
    Sorting22 dataurut3 = new Sorting22(c, c.length);
    System.out.println("\nData awal 3");
    dataurut3.tampil();
    dataurut3.InsertionSort();
    System.out.println("Data sudah diurut dengan Insertion Sort (ASC)");
    dataurut3.tampil();

  }
}
```

output:

```bash
PrakAlgoData26_1E_22/minggu6 main ? ❯ java SortingMain22.java
Data awal 1
20 10 2 7 12
Data sudah diurut dengan BUBBLE SORT (ASC)
2 7 10 20 12

Data awal 2
30 20 2 8 14
Data sudah diurut dengan SELECTION SORT (ASC)
2 20 8 14 30

Data awal 3
40 10 4 9 3
Data sudah diurut dengan Insertion Sort (ASC)
3 4 9 10 40

```

### Jawaban pertanyaan

1\. pertanyaan: "Jelaskan fungsi kode program berikut"

```java
if (data[j - 1] > data[j]) {
  temp = data[j];
  data[j] = data[j - 1];
  data[j - 1] = temp;
}
```
  
jawab:

fungsi `if` tersebut adalah untuk melakukan pertukaran antara `data[j]` dengan `data[j - 1]` dengan membuat temp variabel sebagai penyimpan sementara .pertukaran variabel seperti ini juga dapat dilakukan dengan xor `^` operation seperti ini:

```java
data[j] ^= data[j - 1];
data[j - 1] ^= data[j];
data[j] ^= data[j - 1];
```

hal ini bisa dilakukan dikarenakan

  1\. `x = x ^ y`: akan menyimpan "mask" atau "hybrid" atau gabungan dari nilai dari kedua variabel.
  
  2\. `y = x ^ y`: dengan xor "mask" tersebut dengan value asli y kita akan mendapatkan nilai asli dari x.
  
  3\. `x = x ^ y`: dengan melakukan xor lagi kita akan mendapatkan nilai dari y sebelumnya.

contoh numerical:

diketahui `x = 5` (binary `0101`) dan `y = 10` (binary `1010`):

- Step 1: `x = 0101 ^ 1010 = 1111` (decimal 15).
- Step 2: `y = 1111 ^ 1010 = 0101` (decimal 5). sekarang `y` memiliki nilai original `x`.
- Step 3: x = 1111 ^ 0101 = 1010 (decimal 10). sekarang `x` has the original `y`.

2\. pertanyaan: "Tunjukkan kode program yang merupakan algoritma pencarian nilai minimum pada selection sort!"

Jawab:
kode program yang merupakan algoritma pencarian nilai minimum pada selection sort adalah:

```java
int min = i;
for (int j = i + 1; j < jumData; j++) {
  if (data[j] < data[min]) {
    min = j;
  }
}
```

  1\. Di dalam loop j, program akan membandingkan setiap elemen di depannya dengan elemen yang saat ini dianggap paling kecil (data[min]).

  2\. Pembaruan Indeks: Jika ditemukan angka yang lebih kecil (data[j] < data[min]), maka variabel min akan diperbarui dengan indeks j tersebut. Jadi, min bukan menyimpan nilainya, melainkan alamat/posisinya.

  3\. Hasil Akhir Loop: Setelah loop j selesai, variabel min akan memegang "kunci" atau indeks dari angka terkecil yang ditemukan di sepanjang sisa deretan data tersebut.

3\. pertanyaan: "Pada Insertion sort, jelaskan maksud dari kondisi pada perulangan"

```java
while (j >= 0 && data[j] > temp)
```

jawab:
Kondisi tersebut berfungsi sebagai kontrol pemindahan data, di mana perulangan akan terus berjalan selama indeks belum melewati batas awal array (`j >= 0`) dan nilai elemen di sebelah kiri masih lebih besar daripada nilai yang sedang diurutkan (`data[j] > temp`). Selama kedua syarat ini terpenuhi, elemen yang lebih besar akan terus digeser ke kanan untuk membuka jalan bagi variabel `temp` agar bisa disisipkan pada posisi yang tepat sehingga urutan data menjadi benar.

4\. Pertanyaan: "Pada Insertion sort, apakah tujuan dari perintah `data[j + 1] = data[j];`"

jawab:
Tujuan dari perintah tersebut adalah untuk menggeser elemen yang lebih besar ke posisi sebelah kanannya guna menciptakan ruang kosong bagi variabel `temp`. Karena dalam Insertion Sort kita ingin menyisipkan sebuah nilai ke barisan yang sudah terurut, kita harus "mendorong" angka-angka yang lebih besar satu per satu ke kanan hingga ditemukan posisi yang tepat untuk nilai `temp` tersebut. Tanpa perintah ini, nilai yang lebih besar akan tetap di tempatnya dan menutupi celah yang dibutuhkan untuk proses penyisipan.

## Percobaan 2: Sorting Menggunakan Array of Object

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
  Mahasiswa22 listMhs[] = new Mahasiswa22[5];
  int idx;

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

}
```

MahasiswaDemo22.java

```java
public class MahasiswaDemo22 {
  public static void main(String[] args) {
    MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22();
    Mahasiswa22 m1 = new Mahasiswa22("123", "Zidan", "2A", 3.2);
    Mahasiswa22 m2 = new Mahasiswa22("124", "Ayu", "2A", 3.5);
    Mahasiswa22 m3 = new Mahasiswa22("125", "Sofi", "2A", 3.1);
    Mahasiswa22 m4 = new Mahasiswa22("126", "Sita", "2A", 3.9);
    Mahasiswa22 m5 = new Mahasiswa22("127", "Miki", "2A", 3.7);

    list.tambah(m1);
    list.tambah(m2);
    list.tambah(m3);
    list.tambah(m4);
    list.tambah(m5);

    System.out.println("Data mahasiswa sebelum sorting: ");
    list.tampil();

    System.out.println("Data Mahasiwa setelah sorting berdasarkan IPK (DESC) : ");
    list.bubbleSort();
    list.tampil();
  }
}
```

hasil dijalankannya program:

```bash
PrakAlgoData26_1E_22/minggu6 main  ? ❯ java MahasiswaDemo22.java
Data mahasiswa sebelum sorting:
Nama: Zidan
NIM: 123
kelas: 2A
IPK: 3.2
---------------------------------
Nama: Ayu
NIM: 124
kelas: 2A
IPK: 3.5
---------------------------------
Nama: Sofi
NIM: 125
kelas: 2A
IPK: 3.1
---------------------------------
Nama: Sita
NIM: 126
kelas: 2A
IPK: 3.9
---------------------------------
Nama: Miki
NIM: 127
kelas: 2A
IPK: 3.7
---------------------------------
Data Mahasiwa setelah sorting berdasarkan IPK (DESC) :
Nama: Sita
NIM: 126
kelas: 2A
IPK: 3.9
---------------------------------
Nama: Miki
NIM: 127
kelas: 2A
IPK: 3.7
---------------------------------
Nama: Ayu
NIM: 124
kelas: 2A
IPK: 3.5
---------------------------------
Nama: Zidan
NIM: 123
kelas: 2A
IPK: 3.2
---------------------------------
ama: Sofi
NIM: 125
kelas: 2A
IPK: 3.1
---------------------------------
```

### Jawaban pertanyaan

1\. pertanyaan: "Perhatikan perulangan di dalam bubbleSort() di bawah ini:"

```java
for (int i = 0; i < listMhs.length; i++) {
  for (int j = 1; j < listMhs.length - i; j++) {
```

  a. Mengapa syarat dari perulangan i adalah i<listMhs.length-1 ?
  b. Mengapa syarat dari perulangan j adalah j<listMhs.length-i ?
  c. Jika banyak data di dalam listMhs adalah 50, maka berapakali perulangan i akan berlangsung? Dan ada berapa Tahap bubble sort yang ditempuh?

jawaban:
  a. Mengapa syarat perulangan $i$ adalah `i < listMhs.length - 1`?
  Karena dalam Bubble Sort, jika kita memiliki $n$ data, kita hanya perlu melakukan maksimal $n-1$ tahapan untuk memastikan seluruh data terurut. Ketika $n-1$ data sudah berada di posisi yang benar, maka data terakhir secara otomatis akan berada di posisi yang tepat pula. Jadi, perulangan sampai elemen terakhir tidak diperlukan lagi.
  
  b. Mengapa syarat perulangan $j$ adalah `j < listMhs.length - i`?
  Setiap kali satu tahapan perulangan $i$ (outer loop) selesai, satu data terbesar (atau terkecil, tergantung kondisi) sudah dipastikan "mengapung" ke posisi akhirnya di ujung array. Oleh karena itu, kita tidak perlu mengecek data yang sudah berada di posisi permanen tersebut. Mengurangi batas dengan `- i` membuat algoritma lebih efisien karena jumlah perbandingan berkurang di setiap tahapannya.
  
  c. Jika data berjumlah 50:Berapa kali perulangan $i$ berlangsung?   Perulangan akan berlangsung sebanyak 49 kali (dari indeks 0 sampai 48).Berapa tahap yang ditempuh?
  Terdapat 49 tahap pengurutan untuk memastikan seluruh 50 data terurut sempurna.

2\. pertanyaan: "Modifikasi program diatas dimana data mahasiswa bersifat dinamis (input dari keyborad) yang terdiri dari nim, nama, kelas, dan ipk!"

kita dapat mengubah seperti ini:
MahasiswaDemo22.java

```java
import java.util.Scanner;

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan jumlah mahasiswa yang akan diinput: ");
    int jumlah = sc.nextInt();
    sc.nextLine();

    MahasiswaBerprestasi22 list = new MahasiswaBerprestasi22(jumlah);

    for (int i = 0; i < jumlah; i++) {
      System.out.println("--- Data Mahasiswa ke-" + (i + 1) + " ---");
      System.out.print("NIM   : ");
      String nim = sc.nextLine();
      System.out.print("Nama  : ");
      String nama = sc.nextLine();
      System.out.print("Kelas : ");
      String kelas = sc.nextLine();
      System.out.print("IPK   : ");
      double ipk = sc.nextDouble();
      sc.nextLine();

      Mahasiswa22 m = new Mahasiswa22(nim, nama, kelas, ipk);
      list.tambah(m);
    }

    System.out.println("\nData Mahasiswa Setelah Sorting (IPK DESC):");
    list.bubbleSort();
    list.tampil();

    sc.close();
  }
}
```

MahasiswaBerprestasi22.java

```java
public class MahasiswaBerprestasi22 {
  // kita ubah menjadi dinamis
  // Mahasiswa22 listMhs[] = new Mahasiswa22[5];

  Mahasiswa22 listMhs[];
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

}
```

## Percobaan 2.2: Mengurutkan Data Mahassiwa Berdasarkan IPK (Selection Sort)

MahasiswaDemo22.java

```java
+    System.out.println("\nData yang sudah terurut menggunakan SELECTION SORT (ASC):");
+    list.selectionSort();
+    list.tampil();
```

MahasiswaBerprestasi22.java

```java
+  void selectionSort() {
+    for (int i = 0; i < listMhs.length - 1; i++) {
+      int idxMin = i;
+      for (int j = i + 1; j < listMhs.length; j++) {
+        if (listMhs[j].ipk < listMhs[idxMin].ipk) {
+          idxMin = j;
+        }
+      }
+      Mahasiswa22 tmp = listMhs[idxMin];
+      listMhs[idxMin] = listMhs[i];
+      listMhs[i] = tmp;
+    }
+  }
```

output:

```bash
PrakAlgoData26_1E_22/minggu6 main  ? ❯ java MahasiswaDemo22.java < datamhs1.in   
  
Masukkan jumlah mahasiswa yang akan diinput: --- Data Mahasiswa ke-1 ---
  
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-2 ---
  
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-3 ---
  
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-4 ---
  
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-5 ---
  
NIM   : Nama  : Kelas : IPK   :
  
Data yang sudah terurut menggunakan SELECTION SORT (ASC):
  
Nama: ila
  
NIM: 124
  
kelas: 2B
  
IPK: 3.1
  
---------------------------------
  
Nama: udin
  
NIM: 127
  
kelas: 2B
  
IPK: 3.2
---------------------------------
Nama: tika
NIM: 126
kelas: 2B
IPK: 3.3
---------------------------------
Nama: agus
NIM: 125
kelas: 2B
IPK: 3.6
---------------------------------
Nama: Ali
NIM: 123
kelas: 2B
IPK: 3.9
---------------------------------
```

### Pertanyaan

Di dalam method selection sort, terdapat baris program seperti di bawah ini:

```java
int idxMin = i;
for (int j = i + 1; j < listMhs.length; j++) {
  if (listMhs[j].ipk < listMhs[idxMin].ipk) {
    idxMin = j;
  }
}
```

untuk apakah proses tersebut, jelaskan!

Jawaban:

Potongan kode tersebut berfungsi untuk mencari indeks elemen dengan nilai IPK terkecil dalam sisa daftar yang belum terurut. Proses ini dilakukan dengan mengasumsikan elemen saat ini (`i`) sebagai nilai minimum sementara, lalu membandingkannya satu per satu dengan elemen di posisi berikutnya hingga akhir array; jika ditemukan IPK yang lebih rendah, posisi tersebut disimpan ke dalam variabel `idxMin` agar nantinya dapat ditukarkan ke posisi yang tepat dalam urutan ascending.

## Percobaan 2.3: Mengurutkan Data Mahassiwa Berdasarkan IPK (Insertion Sort)

MahasiswaBerprestasi22.java

```java
+  void InsertionSort() {
+    for (int i = 1; i < listMhs.length; i++) {
+      Mahasiswa22 temp = listMhs[i];
+      int j = i;
+      while (j > 0 && listMhs[j - 1].ipk > temp.ipk) {
+        listMhs[j] = listMhs[j - 1];
+        j--;
+      }
+      listMhs[j] = temp;
+    }
+  }
```

MahasiswaDemo22.java

```java
+    System.out.println("\nData yang sudah terurut menggunakan INSERTION SORT (ASC):");
+    list.InsertionSort();
+    list.tampil();
```

output:

```bash
PrakAlgoData26_1E_22/minggu6 main  ? ❯ java MahasiswaDemo22.java < datamhs2.in     
Masukkan jumlah mahasiswa yang akan diinput: --- Data Mahasiswa ke-1 ---
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-2 ---
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-3 ---
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-4 ---
NIM   : Nama  : Kelas : IPK   : --- Data Mahasiswa ke-5 ---
NIM   : Nama  : Kelas : IPK   :
Data yang sudah terurut menggunakan INSERTION SORT (ASC):
Nama: dika
NIM: 222
kelas: 2c
IPK: 3.0
---------------------------------
Nama: susi
NIM: 444
kelas: 2c
IPK: 3.1
---------------------------------
Nama: yayuk
NIM: 555
kelas: 2c
IPK: 3.4
---------------------------------
Nama: ayu
NIM: 111
kelas: 2c
IPK: 3.7
---------------------------------
Nama: ila
NIM: 333
kelas: 2c
IPK: 3.8
---------------------------------
```

### Pertanyaan

Ubahlah fungsi pada InsertionSort sehingga fungsi ini dapat melaksanakan proses sorting dengan cara descending:

jawaban:

```java
+ while (j > 0 && listMhs[j - 1].ipk < temp.ipk) {
```

kita hanya perlu mengubah tanda `>` menjadi `<` untuk pengurutan descending

## Latihan Praktikum

### Kode program

Dosen22.java

```java
public class Dosen22 {
    String kode, nama;
    boolean jenisKelamin;
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
```

DataDosen22.java

```java
public class DataDosen22 {
    Dosen22[] dataDosen22 = new Dosen22[10];
    int idx = 0;

    void tambah(Dosen22 dsn) {
        if (idx < dataDosen22.length) {
            dataDosen22[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            dataDosen22[i].tampil();
            System.out.println("-----------------------------");
        }
    }

    // Bubble Sort ASC
    void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen22[j].usia < dataDosen22[j - 1].usia) {
                    Dosen22 tmp = dataDosen22[j];
                    dataDosen22[j] = dataDosen22[j - 1];
                    dataDosen22[j - 1] = tmp;
                }
            }
        }
    }

    // Selection Sort DSC
    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen22[j].usia > dataDosen22[idxMax].usia) {
                    idxMax = j;
                }
            }
            Dosen22 tmp = dataDosen22[idxMax];
            dataDosen22[idxMax] = dataDosen22[i];
            dataDosen22[i] = tmp;
        }
    }
}
```

DosenDemo22.java

```java
public class DataDosen22 {
  Dosen22[] dataDosen = new Dosen22[10];
  int idx = 0;

  void tambah(Dosen22 dsn) {
    if (idx < dataDosen.length) {
      dataDosen[idx] = dsn;
      idx++;
    } else {
      System.out.println("Data dosen sudah penuh!");
    }
  }

  void tampil() {
    for (int i = 0; i < idx; i++) {
      dataDosen[i].tampil();
      System.out.println("-----------------------------");
    }
  }

  // Bubble Sort ASC (Termuda ke Tertua)
  void sortingASC() {
    for (int i = 0; i < idx - 1; i++) {
      for (int j = 1; j < idx - i; j++) {
        if (dataDosen[j].usia < dataDosen[j - 1].usia) {
          Dosen tmp = dataDosen[j];
          dataDosen[j] = dataDosen[j - 1];
          dataDosen[j - 1] = tmp;
        }
      }
    }
  }

  // Selection Sort DSC (Tertua ke Termuda)
  void sortingDSC() {
    for (int i = 0; i < idx - 1; i++) {
      int idxMax = i;
      for (int j = i + 1; j < idx; j++) {
        if (dataDosen[j].usia > dataDosen[idxMax].usia) {
          idxMax = j;
        }
      }
      Dosen tmp = dataDosen[idxMax];
      dataDosen[idxMax] = dataDosen[i];
      dataDosen[i] = tmp;
    }
  }
}
```
