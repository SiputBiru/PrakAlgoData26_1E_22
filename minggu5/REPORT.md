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
