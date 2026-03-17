# REPORT

## Percobaan 1: Menghitung Nilai Faktorial dengan Algoritma Brute Force dan Divide and Conquer

### Kode Program

Faktorial22.java

```java
public class Faktorial22 {

  int faktorialBF(int n) {
    int fakto = 1;
    for (int i = 1; i <= n; i++) {
      fakto = fakto * i;
    }
    return fakto;
  }

  int faktorialDC(int n) {
    if (n == 1) {
      return 1;
    } else {
      int fakto = n * faktorialDC(n - 1);
      return fakto;
    }
  }
}
```

MainFaktorial.java

```java
import java.util.Scanner;

public class MainFaktorial {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Masukkan nilai: ");
    int nilai = input.nextInt();
    Faktorial22 fk = new Faktorial22();
    System.out.println("Nilai faktorial " + nilai + " Menggunakan BF: " + fk.faktorialBF(nilai));
    System.out.println("Nilai faktorial " + nilai + " Menggunakan DC: " + fk.faktorialDC(nilai));
    input.close();
  }

}
```

output:

```bash
PrakAlgoData26_1E_22 main  ? ❯ java minggu5/MainFaktorial.java
Masukkan nilai: 5
Nilai faktorial 5 Menggunakan BF: 120
Nilai faktorial 5 Menggunakan DC: 120

```

### Jawaban pertanyaan

1\. pertanyaan: "Pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial, jelaskan perbedaan bagian kode pada penggunaan if dan else!"
  
  jawab:
pada bagian if `n == 1` merupakan sebuah "base case" yang menjadikan kondisi yang mencegah adanya infinite loop dikarenakan fungsi rekursif akan memanggil dirinya sendiri.

selanjutyya pada bagian else merupakan bagian dimana fungsi tersebut memanggil dirinya sendiri

2\. pertanyaan: "Apakah memungkinkan perulangan pada method faktorialBF() diubah selain menggunakan for? Buktikan!"

Ya, memungkinkan. Perulangan pada method faktorialBF() tidak harus menggunakan for. Secara konsep, faktorial hanya membutuhkan perulangan berulang (iterasi), jadi bisa diganti dengan:

```java
int faktorialBF(int n) {
  int fakto = 1;
  int i = 1;

  while (i <= n) {
    fakto = fakto * i;
    i++;
  }

  return fakto;
}
```

ataupun menggunakan `do while`:

```java
int faktorialBF(int n) {
  int fakto = 1;
  int i = 1;

  do {
    fakto = fakto * i;
    i++;
  } while (i <= n);

  return fakto;
}
```

3\. pertanyaan: "Jelaskan perbedaan antara fakto *= i; dan int fakto = n* faktorialDC(n-1); !"

Perbedaan antara fakto `*= i;` dan `int fakto = n* faktorialDC(n-1);` terletak pada pendekatannya: `fakto *= i;` digunakan dalam metode iteratif (loop) yang secara bertahap mengalikan nilai dari `1` hingga `n` dengan memperbarui variabel yang sama, sedangkan `n* faktorialDC(n-1);` digunakan dalam metode rekursif, di mana fungsi memanggil dirinya sendiri untuk menghitung faktorial dari nilai yang lebih kecil hingga mencapai kondisi dasar, kemudian hasilnya dikalikan saat proses kembali (`return`); meskipun keduanya menghasilkan nilai faktorial yang sama, iteratif lebih efisien dalam penggunaan memori, sedangkan rekursif lebih mencerminkan definisi matematis faktorial.

4\. pertanyaan: "Buat Kesimpulan tentang perbedaan cara kerja method faktorialBF() dan faktorialDC()!"

jawab:
Kesimpulannya, method `faktorialBF()` dan `faktorialDC()` memiliki cara kerja yang berbeda meskipun menghasilkan nilai yang sama. `faktorialBF()` menggunakan pendekatan iteratif (brute force) dengan perulangan for untuk mengalikan angka dari `1` sampai `n` secara langsung dan bertahap, sehingga lebih sederhana dan efisien dalam penggunaan memori. Sementara itu, `faktorialDC()` menggunakan pendekatan rekursif (divide and conquer), di mana fungsi memanggil dirinya sendiri dengan nilai yang lebih kecil hingga mencapai kondisi dasar, lalu hasilnya dikalikan saat proses kembali. Dengan demikian, `faktorialBF()` bekerja secara berulang dalam satu fungsi, sedangkan `faktorialDC()` bekerja melalui pemanggilan fungsi berlapis (call stack).

## Percobaan 2: Menghitung Hasil Pangkat dengan Algoritma Brute Force dan Divide and Conquer

kode program:
Pangkat22.java

```java
public class Pangkat22 {
  int nilai, pangkat;

  Pangkat22(int n, int p) {
    this.nilai = n;
    this.pangkat = p;
  }

  int pangkatBF(int a, int n) {
    int hasil = 1;
    for (int i = 0; i < n; i++) {
      hasil = hasil * a;
    }

    return hasil;
  }

  int pangkatDC(int a, int n) {
    if (n == 1) {
      return a;
    } else {
      if (n % 2 == 1) {
        return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
      } else {
        return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));

      }
    }
  }
}

```

PangkatMain.java

```java
import java.util.Scanner;

public class MainPangkat22 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Masukkan jumlah elemen: ");

    int elemen = input.nextInt();

    Pangkat22[] png = new Pangkat22[elemen];
    for (int i = 0; i < elemen; i++) {
      System.out.print("Masukkan nilai basis elemen ke-" + (i + 1) + ": ");
      int basis = input.nextInt();
      System.out.print("Masukkan nilai pangkat elemen ke-" + (i + 1) + ": ");
      int pangkat = input.nextInt();
      png[i] = new Pangkat22(basis, pangkat);

    }

    System.out.println("HASIL PANGKAT BRUTEFORCE:");
    for (Pangkat22 p : png) {
      System.out.println(p.nilai + "^" + p.pangkat + ": " + p.pangkatBF(p.nilai, p.pangkat));
    }

    System.out.println("HASIL PANGKAT DIVIDE AND CONQUER:");
    for (Pangkat22 p : png) {
      System.out.println(p.nilai + "^" + p.pangkat + ": " + p.pangkatDC(p.nilai, p.pangkat));
    }

    input.close();
  }
}

```

### Jawaban pertanyaan

1\. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu `pangkatBF()` dan `pangkatDC()`!

Jawaban:
Method `pangkatBF()` menggunakan pendekatan **iteratif (brute force)** dengan perulangan untuk mengalikan nilai basis sebanyak `n` kali sehingga prosesnya linear `(O(n))`, sedangkan `pangkatDC()` menggunakan pendekatan divide and conquer **(rekursif)** dengan membagi pangkat menjadi setengah `(n/2)`, kemudian menggabungkan hasilnya sehingga lebih efisien dengan kompleksitas `O(log n)`. penjelasan lengkah tentang Big O notation dapat dilihat dari [link](https://en.wikipedia.org/wiki/Big_O_notation)

2\. Apakah tahap combine sudah termasuk dalam kode tersebut? Tunjukkan!

Jawaban:

tahapan combine berapa pada bagian

```java
return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
```

dan juga:

```java
return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));
```

Bagian tersebut merupakan proses **combine**, karena menggabungkan hasil dari subproblem menjadi solusi akhir.

3\. Pada method `pangkatBF()` terdapat parameter untuk melewatkan nilai yang akan dipangkatkan dan pangkat berapa, padahal di sisi lain di class `Pangkat` telah ada atribut `nilai` dan `pangkat`, apakah menurut Anda method tersebut tetap relevan untuk memiliki parameter? Apakah bisa jika method tersebut dibuat dengan tanpa parameter? Jika bisa, seperti apa method `pangkatBF()` yang tanpa parameter?

Jawaban:

pada method `pangkatBF()` sebenarnya tidak diwajibkan memiliki parameter, kerena nilai `nilai` dan `pangkat` sudah tersedia sebagai atribut dalam class. Method dapat menggunakan atribut tersebut tanpa parameter agar lebih singkat.

contoh tanpa parameter:

```java
int pangkatBF() {
  int hasil = 1;
  for (int i = 0; i < pangkat; i++) {
    hasil = hasil * nilai;
  }
  return hasil;
}
```

4\. Tarik tentang cara kerja method `pangkatBF()` dan `pangkatDC()`!

Jawaban:

Dari percobaan yang telah dilakukan dapat disimpukan bahwa Method `pangkatBF()` bekerja dengan cara mengalikan nilai secara berulang dari 1 hingga n menggunakan perulangan, sehingga prosesnya langsung dan sederhana. Sedangkan `pangkatDC()` bekerja dengan cara memecah masalah menjadi lebih kecil menggunakan rekursi (`n/2`), lalu menggabungkan hasilnya kembali, sehingga lebih efisien karena jumlah operasi lebih sedikit.

## Percobaan 3: Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer

kode program:
Sum22.java

```java
public class Sum22 {
  double keuntungan[];

  Sum22(int el) {
    keuntungan = new double[el];
  }

  double totalBF() {
    double total = 0;
    for (int i = 0; i < keuntungan.length; i++) {
      total = total + keuntungan[i];

    }

    return total;
  }

  double totalDC(double arr[], int l, int r) {
    if (l == r) {
      return arr[l];
    }

    int mid = (l + r) >> 1;

    double lsum = totalDC(arr, l, mid);
    double rsum = totalDC(arr, mid + 1, r);

    return lsum + rsum;
  }
}
```

MainSum.java

```java
import java.util.Scanner;

public class MainSum {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Masukkan jumlah elemen: ");

    int elemen = input.nextInt();

    Sum22 sm = new Sum22(elemen);
    for (int i = 0; i < elemen; i++) {
      System.out.println("Masukkan keuntungan ke-" + (i + 1) + ": ");
      sm.keuntungan[i] = input.nextDouble();
    }

    System.out.println("Total keuntungan menggunakan BruteForce: " + sm.totalBF());
    System.out.println("Total keuntungan menggunakan Divide and Conquer: " + sm.totalDC(sm.keuntungan, 0, elemen - 1));

    input.close();
  }
}
```

### Jawaban pertanyaan

1\. Kenapa dibutuhkan variable `mid` pada method `TotalDC()`?

jawaban:
Variabel `mid` digunakan untuk menentukan titik tengah array agar dapat membagi array menjadi dua bagian (kiri dan kanan). Hal ini merupakan inti dari algoritma **divide and conquer**, yaitu memecah masalah besar menjadi sub-masalah yang lebih kecil.

2\. Untuk apakah statement di bawah ini dilakukan dalam `TotalDC()`?

```java
    double lsum = totalDC(arr, l, mid);
    double rsum = totalDC(arr, mid + 1, r);
```

jawaban:
Statement tersebut digunakan untuk membagi masalah menjadi dua bagian:

- `lsum` menghitung total bagian kiri array
= `rsum` menghitung total bagian kanan array

Keduanya merupakan proses divide dan conquer (rekursi) terhadap sub-array.

3\. Kenapa diperlukan penjumlahan hasil `lsum` dan `rsum` seperti di bawah ini?

```java
    return lsum + rsum;
```

jawaban:
Penjumlahan `lsum + rsum` merupakan tahap combine, yaitu menggabungkan hasil dari sub-masalah (kiri dan kanan) untuk mendapatkan total keseluruhan array.

4\. Apakah base case dari `totalDC()`?

jawaban:

Base case nya adalah:

```java
if (l == r) {
  return arr[l];
}
```

Artinya, jika hanya ada satu elemen, maka langsung dikembalikan nilainya karena tidak bisa dibagi lagi.

5\. Tarik Kesimpulan tentang cara kerja `totalDC()`

jawaban:
Method `totalDC()` bekerja dengan cara membagi array menjadi dua bagian secara rekursif hingga mencapai satu elemen (base case), kemudian hasil dari setiap bagian dijumlahkan kembali (combine) untuk memperoleh total keseluruhan, sehingga prosesnya lebih terstruktur dibandingkan iterasi biasa meskipun tujuannya sama dengan metode brute force.

## Latihan Praktikum

### Sebuah Kampus daftar nilai mahasiswa dengan data sesuai tabel di bawah ini

| Nama  | NIM        | Tahun Masuk | Nilai UTS | Nilai UAS |
|-------|------------|-------------|-----------|-----------|
| Ahmad | 220101001  | 2022        | 78        | 82        |
| Budi  | 220101002  | 2022        | 85        | 88        |
| Cindy | 220101003  | 2021        | 90        | 87        |
| Dian  | 220101004  | 2021        | 76        | 79        |
| Eko   | 220101005  | 2023        | 92        | 95        |
| Fajar | 220101006  | 2020        | 88        | 85        |
| Gina  | 220101007  | 2023        | 80        | 83        |
| Hadi  | 220101008  | 2020        | 82        | 84        |

Tentukan:

a) Nilau UTS tertinggi tertinggi menggunakan Divide and Conquer!
b) Nilai UTS terendah menggunakan Divide and Conquer!
c) Rata-rata nilai UAS dari semua mahasiswa menggunakan Brute Force!

Jawaban:

kode program:

kita dapat mengerjakan latihan praktikum ini dengan pendekatan OOP yang membagi menjadi 3 Class (Mahasiswa, NilaiMahasiswa(proses), Main)

Mahasiswa.java

```java
public class Mahasiswa {
  String nama;
  int nim;
  int tahunMasuk;
  int uts;
  int uas;

  Mahasiswa(String nama, int nim, int thnMasuk, int uts, int uas) {
    this.nama = nama;
    this.nim = nim;
    this.tahunMasuk = thnMasuk;
    this.uts = uts;
    this.uas = uas;
  }
}
```

NilaiMahasiswa.java

```java
class NilaiMahasiswa {

  // Divide and Conquer - nilai maksimum UTS
  int maxUTS(Mahasiswa[] arr, int l, int r) {
    if (l == r) {
      return arr[l].uts;
    }

    int mid = (l + r) >> 1;

    int left = maxUTS(arr, l, mid);
    int right = maxUTS(arr, mid + 1, r);

    return Math.max(left, right);
  }

  // Divide and Conquer - nilai minimum UTS
  int minUTS(Mahasiswa[] arr, int l, int r) {
    if (l == r) {
      return arr[l].uts;
    }

    int mid = (l + r) >> 1;

    int left = minUTS(arr, l, mid);
    int right = minUTS(arr, mid + 1, r);

    return Math.min(left, right);
  }

  // Brute Force - rata-rata UAS
  double rataUAS(Mahasiswa[] arr) {
    double total = 0;

    for (int i = 0; i < arr.length; i++) {
      total += arr[i].uas;
    }

    return total / arr.length;
  }
}
```

MainNilai.java

```java
public class MainNilai {
  public static void main(String[] args) {

    // Dikarenakan tidak ada ketentuan apakah nilai harus di input menggunakan
    // Scanner untuk kepraktisan percobaan program data mahassiwa maka dibuat
    // harcoded seperti ini:
    Mahasiswa[] mhs = {
        new Mahasiswa("Ahmad", 220101001, 2022, 78, 82),
        new Mahasiswa("Budi", 220101002, 2022, 85, 88),
        new Mahasiswa("Cindy", 220101003, 2021, 90, 87),
        new Mahasiswa("Dian", 220101004, 2021, 76, 79),
        new Mahasiswa("Eko", 220101005, 2023, 92, 95),
        new Mahasiswa("Fajar", 220101006, 2020, 88, 85),
        new Mahasiswa("Gina", 220101007, 2023, 80, 83),
        new Mahasiswa("Hadi", 220101008, 2020, 82, 84)
    };

    NilaiMahasiswa nm = new NilaiMahasiswa();

    int max = nm.maxUTS(mhs, 0, mhs.length - 1);
    int min = nm.minUTS(mhs, 0, mhs.length - 1);
    double rata = nm.rataUAS(mhs);

    System.out.println("Nilai UTS tertinggi (DC): " + max);
    System.out.println("Nilai UTS terendah (DC): " + min);
    System.out.println("Rata-rata UAS (BF): " + rata);
  }
}
```
