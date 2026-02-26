# REPORT

## Percobaan 1: Membuat Array dari Object, mengisi dan menampilkan

### Kode Program

Mahasiswa22.java

```java
public class Mahasiswa22 {

  public String nim;
  public String nama;
  public String kelas;
  public float ipk;

  public static void main(String[] args) {
    Mahasiswa22[] arrayOfMahasiswa = new Mahasiswa22[3];

    arrayOfMahasiswa[0] = new Mahasiswa22();
    arrayOfMahasiswa[0].nim = "244107060033";
    arrayOfMahasiswa[0].nama = "AGNES TITANIA KINANTI";
    arrayOfMahasiswa[0].kelas = "SIB-1E";
    arrayOfMahasiswa[0].ipk = (float) 3.75;

    arrayOfMahasiswa[1] = new Mahasiswa22();
    arrayOfMahasiswa[1].nim = "234170172";
    arrayOfMahasiswa[1].nama = "ACHMAD MAULANA HAMZAH";
    arrayOfMahasiswa[1].kelas = "TI-2A";
    arrayOfMahasiswa[1].ipk = (float) 3.36;

    arrayOfMahasiswa[2] = new Mahasiswa22();
    arrayOfMahasiswa[2].nim = "244107023006";
    arrayOfMahasiswa[2].nama = "DIRHAMAWAN PUTRANTO";
    arrayOfMahasiswa[2].kelas = "TI-2E";
    arrayOfMahasiswa[2].ipk = (float) 3.80;

    System.out.println("NIM      : " + arrayOfMahasiswa[0].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[0].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[0].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[0].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[1].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[1].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[1].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[1].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[2].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[2].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[2].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[2].ipk);
    System.out.println("----------------------------------------");
  }

}

```

MahasiswaDemo22.java

```java

public class MahasiswaDemo22 {
  public static void main(String[] args) {
    Mahasiswa22[] arrayOfMahasiswa = new Mahasiswa22[3];

    arrayOfMahasiswa[0] = new Mahasiswa22();
    arrayOfMahasiswa[0].nim = "244107060033";
    arrayOfMahasiswa[0].nama = "AGNES TITANIA KINANTI";
    arrayOfMahasiswa[0].kelas = "SIB-1E";
    arrayOfMahasiswa[0].ipk = (float) 3.75;

    arrayOfMahasiswa[1] = new Mahasiswa22();
    arrayOfMahasiswa[1].nim = "234170172";
    arrayOfMahasiswa[1].nama = "ACHMAD MAULANA HAMZAH";
    arrayOfMahasiswa[1].kelas = "TI-2A";
    arrayOfMahasiswa[1].ipk = (float) 3.36;

    arrayOfMahasiswa[2] = new Mahasiswa22();
    arrayOfMahasiswa[2].nim = "244107023006";
    arrayOfMahasiswa[2].nama = "DIRHAMAWAN PUTRANTO";
    arrayOfMahasiswa[2].kelas = "TI-2E";
    arrayOfMahasiswa[2].ipk = (float) 3.80;

    System.out.println("NIM      : " + arrayOfMahasiswa[0].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[0].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[0].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[0].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[1].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[1].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[1].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[1].ipk);
    System.out.println("----------------------------------------");

    System.out.println("NIM      : " + arrayOfMahasiswa[2].nim);
    System.out.println("Nama     : " + arrayOfMahasiswa[2].nama);
    System.out.println("Kelas    : " + arrayOfMahasiswa[2].kelas);
    System.out.println("IPK      : " + arrayOfMahasiswa[2].ipk);
    System.out.println("----------------------------------------");
  }
}
```

output:

```bash
PrakAlgoData26_1E_22/minggu3 main ? ❯ java MahasiswaDemo22.java
NIM : 244107060033
Nama : AGNES TITANIA KINANTI
Kelas : SIB-1E
IPK : 3.75
----------------------------------------
NIM : 234170172
Nama : ACHMAD MAULANA HAMZAH
Kelas : TI-2A
IPK : 3.36
----------------------------------------
NIM : 244107023006
Nama : DIRHAMAWAN PUTRANTO
Kelas : TI-2E
IPK : 3.8
----------------------------------------
```

### Jawaban pertanyaan

1\. pertanyaan: "Berdasarkan uji coba 3.2, apakah class yang akan dibuat array of object harus selalu memiliki atribut dan sekaligus method? Jelaskan!"
  
  jawab:
  biasanya array of object memiliki atribut dan juga method namun tidak kedua harus ada bersamaan contoh:
  
  ```java
  public class dummy {
    public void printHello() {
      System.out.println("Hello!");
    }
  
    public static void main(String[] args) {
      dummy[] arrayOfHello = new dummy[2];
      arrayOfHello[0] = new dummy();
  
      arrayOfHello[0].printHello();
  
    }
  }
  ```
  
  syntax diatas akan tetap berjalan walau class dummy tidak memiliki atribut:
  
  ```bash
  > java dummy.java
  Hello!
  ```
  
  namun disarankan memiliki setidaknya atribut untuk memberikan "ciri khas" pada class tersebut

2\. pertanyaan: "Apa yang dilakukan oleh kode program berikut?"

```java
    Mahasiswa22[] arrayOfMahasiswa = new Mahasiswa22[3];
```

kode program tersebut berfungsi sebagai melakukan instansiasi dari sebuah array yang memiliki elemen bertipe class Mahasiswa22. namun pada setiap elemen tersebut kita tetap harus melakukan instansiasi kembali. hal tersebut dikarenakan pada saat melakukan instansiasi kita hanya memberikan `referenc3`  pada indeks array namun belum/bukan membuat object tersebut.

3\. pertanyaan: "Apakah class Mahasiswa memiliki konstruktor? Jika tidak, kenapa bisa dilakukan pemanggilan
konstruktur pada baris program berikut?"

```java
arrayOfMahasiswa[0] = new Mahasiswa22();
```

<br>

Jawaban:
Karena Java sudah menyediakan konstruktor kosong `Mahasiswa22()` konstruktor tersebut dibuat otomatis saat tidak ada konstruktor lain yang didefinisikan.

4\. pertanyaan: "Apa yang dilakukan kode program berikut?"

```java
arrayOfMahasiswa[0] = new Mahasiswa22();
arrayOfMahasiswa[0].nim = "244107060033";
arrayOfMahasiswa[0].nama = "AGNES TITANIA KINANTI";
arrayOfMahasiswa[0].kelas = "SIB-1E";
arrayOfMahasiswa[0].ipk = (float) 3.75;
```

jawaban:
kode program tersebut berguna sebagai pemberi nilai pada setiap atribut pada class tersebut

5\. pertanyaan: "5. Mengapa class Mahasiswa dan MahasiswaDemo dipisahkan pada uji coba 3.2?"

Jawaban:
hal tersebut berguana untuk membagi tugas, MahasiswaDemo22 class hanya memiliki tugas main yang akan dipanggil oleh compiler sedangkan Mahasiswa22 class hanya memiliki tugas sebagai blueprint oleh object yang akan digunakan pada MahasiswaDemo22.

## Percobaan 2: Menerima Input Isian Array Menggunakan Looping
