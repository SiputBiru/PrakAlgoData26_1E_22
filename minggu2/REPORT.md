# REPORT

## Percobaan 1: Pemilihan

Kode Program:

```java
class Mahasiswa22 {
  String nama;
  String nim;
  String kelas;
  double ipk;

  void tampilkanInformasi() {
    System.out.println("Nama: " + nama);
    System.out.println("NIM: " + nim);
    System.out.println("IPK: " + ipk);
    System.out.println("Nama: " + kelas);
  }

  void ubahKelas(String kelasBaru) {
    kelas = kelasBaru;
  }

  void updateIpk(double ipkBaru) {
    ipk = ipkBaru;
  }

  String nilaiKinerja() {
    if (ipk >= 3.5) {
      return "Kinerja sangat baik";
    } else if (ipk >= 3.0) {
      return "Kinerja baik";

    } else if (ipk >= 2.0) {
      return "Kinerja cukup";
    } else {
      return "Kinerja kurang";
    }
  }

}
```

### Jawaban Pertanyaan

1. class konstruktor atau blueprint yang dapat digunakan untuk membuat sebuah objek, class != objek. objek merupakan bentuk nyata dari class yang dibuat menggunakan "fungsi istimewa" `new`. Berbeda dengan C struct yang merupakan representasi mentah dari runtutan tipe data. pada Java "Struct/class" dapat memiliki fungsi/method. Sebenarnya kita dapat memiliki fungsi pada C Struct menggunakan function pointer tapi hal ini tidak terlalu disarankan.

    Struct di C:
    ![struct In C](https://overiq.com/media/uploads/structure-variable-in-memory-1504600232807.png)

    Class di java:
    ![Class in Java](https://media.geeksforgeeks.org/wp-content/uploads/20190614230114/JVM-Architecture-diagram.jpg)
    - JVM bekerja dengan membagi memory kepada beberapa runtime area yang nantinya akan atur.

    - Setiap memori area memiliki role/tugas yang berbeda-beda, seperti menyimpan class data, objects, method calls, atau instruksi pada saat eksekusi. [Sumber](https://www.geeksforgeeks.org/java/how-many-types-of-memory-areas-are-allocated-by-jvm/)

2. atribut pada class mahasiswa memiliki 4 atribut meliputi:

    - `nama`: String,
    - `nim`: String,
    - `kelas`: String
    - `ipk`: double

3. method yang ada pada class mahassiwa ada 4 yang meliputi;

    - `void tampilkanInformasi()`
    - `void ubahKelas(String kelasBaru)` yang membutuhkan argument kelasBaru bertipe String.
    - `void updateIpk(double ipkBaru)` yang membutuhkan argument ipkBaru bertipe double.
    - `String nilaiKinerja()`

4. kode setelah mengubah method `nilaiKinerja()`.

    ```java
    void updateIpk(double ipkBaru) {
      if (ipk <= 0.0 || ipk >= 4.0) {
        System.out.println("IPK tidak valid. Harus antara 0.0 dan 4.0");
        return;
      }
      ipk = ipkBaru;
    }
    ```

5. Penjelasan method `nilaiKinerja()`
  Method nilaiKinerja memiliki return type `String` berkerja dengan cara melakukan checking menggunakan if else.

  ```java
  String nilaiKinerja() {
    if (ipk >= 3.5) {
      return "Kinerja sangat baik";
    } else if (ipk >= 3.0) {
      return "Kinerja baik";

    } else if (ipk >= 2.0) {
      return "Kinerja cukup";
    } else {
      return "Kinerja kurang";
    }
  }
  ```

## Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method

### kode program

```java
class MahasiswaMain22 {
  public static void main(String[] args) {
    Mahasiswa22 mhs1 = new Mahasiswa22();
    mhs1.nama = "Muhammad Ali Zulfikar";
    mhs1.nim = "2141720088";
    mhs1.ipk = 3.55;

    mhs1.tampilkanInformasi();
    mhs1.ubahKelas("S1 2K");
    mhs1.updateIpk(3.60);
    mhs1.tampilkanInformasi();

  }
}
```

### hasil dijalankannya program

```bash
Nama: Muhammad Ali Zulfikar
NIM: 2141720088
IPK: 3.55
Nama: null
IPK tidak valid. Harus antara 0.0 dan 4.0
Nama: Muhammad Ali Farhan
NIM: 2241720171
IPK: 3.55
Nama: S1 2K

…/minggu2/src main ? ❯ 
```
