# Laporan Praktikum Minggu 14: Collection

---

## Percobaan 1: Menambahkan elemen, mengakses elemen, dan menghapus sebuah elemen

### Kode Program
**ContohList22.java**
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContohList22 {
  public static void main(String[] args) {
    List<Object> l = new ArrayList<>();

    l.add(1);
    l.add(2);
    l.add(3);
    l.add("Cireng");
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %s\n", l.get(0), l.size(), l.get(l.size() - 1));
    
    l.add(4);
    l.remove(0);
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %s\n", l.get(0), l.size(), l.get(l.size() - 1));

    List<String> names = new LinkedList<>();
    names.add("Noureen");
    names.add("Akhleema");
    names.add("Shannum");
    names.add("Uwais");
    names.add("Al-Qarni");
    System.out.printf("Element 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
    names.set(0, "My kid");
    System.out.printf("Element 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
    System.out.println("Names: " + names.toString());
    
  }
}
```

### Output Main Program
```bash
❯ java minggu14/ContohList22.java
Element 0: 1 total elemen: 4 elemen terakhir: Cireng
Element 0: 2 total elemen: 4 elemen terakhir: 4
Element 0: Noureen total elemen: 5 elemen terakhir: Al-Qarni
Element 0: My kid total elemen: 5 elemen terakhir: Al-Qarni
Names: [My kid, Akhleema, Shannum, Uwais, Al-Qarni]
```

### Pertanyaan 16.1
1. **Perhatikan baris kode 25-36, mengapa semua jenis data bisa ditampung ke dalam sebuah Arraylist?**
    Hal tersebut dapat terjadi karena pada kode aslinya, List l = new ArrayList(); dibuat menggunakan raw type (tanpa menentukan parameter tipe data generic <>). Di dalam Java, jika sebuah Collection tidak didefinisikan tipe datanya secara spesifik (atau jika didefinisikan sebagai <Object> seperti modifikasi kodemu), secara otomatis Java akan menganggap semua elemen yang dimasukkan sebagai objek dari class Object. Karena Object merupakan superclass tertinggi dari semua tipe data di Java, maka ArrayList tersebut bersifat universal sehingga mampu menampung tipe data apa pun sekaligus, baik itu wrapper class dari tipe primitif (seperti Integer) maupun String.  
2. **Modifikasi baris kode 25-36 sehingga data yang ditampung hanya satu jenis atau spesifik tipe tertentu!**
    Agar ArrayList tersebut hanya bisa menampung satu jenis tipe data yang spesifik (misalnya hanya angka/Integer), kita harus menambahkan fitur Generics dengan menyematkan operator <Integer> saat deklarasi objeknya.  Karena datanya diubah menjadi khusus angka, kata "Cireng" pada kode bawaan harus dihapus atau diganti dengan angka agar tidak memicu compile error. Berikut adalah potongan kode modifikasinya:
```java
// Deklarasi list yang spesifik hanya menerima data Integer
List<Integer> l = new ArrayList<>();

l.add(1);
l.add(2);
l.add(3);
l.add(99); // Mengganti "Cireng" dengan angka 99 agar tipe datanya seragam

// Elemen terakhir dicetak menggunakan %d karena tipenya sudah pasti Integer
System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));

l.add(4);
l.remove(0);
System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));
```

3. **Ubah Kode pada baris 38 menjadi seperti ini:**
```java
LinkedList<String> names = new LinkedList<>();
```
4. **Tambahkan juga baris berikut ini, untuk memberikan perbedaan dari tampilan yang sebelumnya:**
```java
names.push("Mei-mei");
System.out.printf("Elemen 0: %s total elemen: %s elemen terakhir: %s\n", names.getFirst(), names.size(), names.getLast());
System.out.println("Names: " + names.toString());
```

5. **Hasil dijalankannya program**
kode program yang sudah diubah:
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContohList22 {
  public static void main(String[] args) {
    // Pertanyaan 2: Mengubah menjadi tipe spesifik Integer
    List<Integer> l = new ArrayList<>();

    l.add(1);
    l.add(2);
    l.add(3);
    l.add(99); // Diubah dari "Cireng" menjadi angka
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));
    
    l.add(4);
    l.remove(0);
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));

    LinkedList<String> names = new LinkedList<>();
    names.add("Noureen");
    names.add("Akhleema");
    names.add("Shannum");
    names.add("Uwais");
    names.add("Al-Qarni");
    
    System.out.printf("Element 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
    
    names.push("Mei-mei");
    System.out.printf("Elemen 0: %s total elemen: %d elemen terakhir: %s\n", names.getFirst(), names.size(), names.getLast());
    System.out.println("Names: " + names.toString());
  }
}
```

```bash
❯ java minggu14/ContohList22.java
Element 0: 1 total elemen: 4 elemen terakhir: 99
Element 0: 2 total elemen: 4 elemen terakhir: 4
Element 0: Noureen total elemen: 5 elemen terakhir: Al-Qarni
Elemen 0: Mei-mei total elemen: 6 elemen terakhir: Al-Qarni
Names: [Mei-mei, Noureen, Akhleema, Shannum, Uwais, Al-Qarni]
```

Penjelasan:
- Penggunaan Generics (List<Integer>): Menentukan tipe data <Integer> membuat ArrayList menjadi aman dari kesalahan tipe data (type-safe) karena hanya mengizinkan angka bulat, sehingga menghilangkan semua warning kompilasi.  
- Perubahan ke LinkedList: Mengubah deklarasi menjadi LinkedList<String> membuka akses ke metode khusus seperti push(), getFirst(), dan getLast() yang tidak tersedia pada interface List biasa.  
- Efek names.push("Mei-mei"): Metode push() memasukkan data baru ke urutan paling depan (indeks 0) dengan prinsip Stack (LIFO), sehingga menggeser posisi data lainnya dan menambah total elemen menjadi 6.  
- Fungsi getFirst() dan getLast(): Kedua metode ini mempermudah pengambilan data di ujung awal ("Mei-mei") dan ujung akhir ("Al-Qarni") secara langsung tanpa perlu menghitung indeks secara manual.  

---

## Percobaan 2: Mengambil/Menampilkan elemen pada sebuah collection

### Kode Program
**LoopCollection22.java**
```java
import java.util.Iterator;
import java.util.Stack;

public class LoopCollection22 {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.push("Salak");

        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        System.out.println("\n" + fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }
        System.out.println("");

        fruits.push("Melon");
        fruits.push("Durian");
        System.out.println("");

        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");

        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });
        System.out.println("");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
        System.out.println("");
    }
}
```

### Output Main Program
```bash
❯ java minggu14/LoopCollection22.java
Banana Orange Watermelon Leci Salak
[Banana, Orange, Watermelon, Leci, Salak]
Salak Leci Watermelon Orange Banana

Melon Durian
Melon Durian
Melon Durian
```

### Pertanyaan 16.3.3 
1. **Apakah perbedaan fungsi push() dan add() pada objek fruits?**
    - `push()`: Merupakan metode spesifik dari class Stack yang digunakan untuk memasukkan elemen ke dalam tumpukan berdasarkan prinsip LIFO (Last In, First Out). Elemen yang dimasukkan melalui push() secara konseptual ditempatkan di posisi paling atas tumpukan (top of stack).  
    - `add()`: Merupakan metode turunan dari interface Collection (dan List) yang diwarisi oleh class Stack. Fungsi ini menyisipkan elemen ke posisi paling akhir dari struktur data linear (diimplementasikan sebagai array dinamis di dalam Vector/Stack).  
2. **Silakan hilangkan baris 43 dan 44, apakah yang akan terjadi? Mengapa bisa demikian?**
    hasil:

```bash
❯ java minggu14/LoopCollection22.java
Banana Orange Watermelon Leci Salak
[Banana, Orange, Watermelon, Leci, Salak]
Salak Leci Watermelon Orange Banana
```

    Jika baris 43 dan 44 (fruits.push("Melon"); dan fruits.push("Durian");) dihilangkan, maka tiga proses pencetakan di bawahnya (menggunakan Iterator, Stream, dan perulangan for indeks) tidak akan menampilkan data apa pun atau menghasilkan output kosong. Hal tersebut terjadi karena pada baris kode sebelumnya (baris 37-39), seluruh isi di dalam objek fruits sudah dikeluarkan dan dihapus satu per satu menggunakan metode pop() di dalam perulangan while (!fruits.empty()) hingga kondisi stack benar-benar kosong.
3. **Jelaskan fungsi dari baris 46-49?**
kode yang dimaksud:
```java
for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
    String fruit = it.next();
    System.out.printf("%s ", fruit);
}
```
Baris kode tersebut berfungsi untuk menampilkan atau menjelajahi (traversing) seluruh elemen yang tersisa di dalam objek fruits secara berurutan menggunakan objek Iterator.

- `fruits.iterator()` digunakan untuk membuat objek penunjuk (pointer).  
- `it.hasNext()` berfungsi sebagai kondisi perulangan untuk memeriksa apakah masih ada elemen berikutnya di dalam collection.  
- `it.next()` berfungsi untuk mengambil elemen yang sedang ditunjuk saat ini sekaligus menggeser posisi penunjuk ke elemen berikutnya.  

4. **Silakan ganti baris kode 25, Stack<String> menjadi List<String> dan apakah yang terjadi? mengapa bisa demikian?**

Ketika baris kode 25 diubah menjadi `List<String> fruits = new Stack<>();`, program akan mengalami compile error (gagal kompilasi) pada metode `fruits.empty()` dan `fruits.pop()`. Hal ini terjadi karena objek fruits direferensikan menggunakan interface `List`. Metode `empty()` dan `pop()` merupakan metode spesifik yang hanya dimiliki oleh class Stack (atau interface `Deque`), dan tidak dideklarasikan di dalam interface `List`.  

5. **Ganti elemen terakhir dari dari objek fruits menjadi “Strawberry”!**
Untuk mengubah elemen terakhir (elemen paling atas pada Stack) tanpa menghapusnya, dapat digunakan metode set() dengan parameter indeks ukuran dikurangi satu, atau menggunakan metode `setElementAt()` bawaan class Vector/Stack.
```java
// Mengganti elemen terakhir menjadi "Strawberry"
fruits.set(fruits.size() - 1, "Strawberry");
```

hasil:
```bash
❯ java minggu14/LoopCollection22.java
Banana Orange Watermelon Leci Strawberry
[Banana, Orange, Watermelon, Leci, Strawberry]
Strawberry Leci Watermelon Orange Banana
```

6. **Tambahkan 3 buah seperti “Mango”,”guava”, dan “avocado” kemudian dilakukan sorting!**
```java
fruits.add("Mango");
fruits.add("guava");
fruits.add("avocado");

java.util.Collections.sort(fruits);
```

hasil:
```bash
❯ java minggu14/LoopCollection22.java
Banana Leci Mango Orange Strawberry Watermelon avocado guava
[Banana, Leci, Mango, Orange, Strawberry, Watermelon, avocado, guava]
guava avocado Watermelon Strawberry Orange Mango Leci Banana
```

---

## Percobaan 3: mengimplementasikan sebuah collection untuk menampung objek yang dibuat sesuai kebutuhan

### Kode Program
**Mahasiswa22.java**
```java
public class Mahasiswa22 {
    String nim;
    String nama;
    String notelp;

    // Konstruktor default
    public Mahasiswa22() {
    }

    // Konstruktor dengan parameter
    public Mahasiswa22(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    // Mengubah representasi objek menjadi teks saat dicetak
    @Override
    public String toString() {
        return "Mahasiswa{" + "nim=" + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
    }
}
```
**ListMahasiswa22.java**
```java
rt java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMahasiswa22 {
    // Deklarasi List untuk menampung objek Mahasiswa
    List<Mahasiswa22> mahasiswas = new ArrayList<>();

    // Metode untuk menambahkan objek (menggunakan varargs / unlimited argument)
    public void tambah(Mahasiswa22... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    // Metode untuk menghapus elemen berdasarkan indeks
    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    // Metode untuk memperbarui data mahasiswa pada indeks tertentu
    public void update(int index, Mahasiswa22 mhs) {
        if (index >= 0 && index < mahasiswas.size()) {
            mahasiswas.set(index, mhs);
        }
    }

    // Metode untuk menampilkan seluruh elemen di dalam list
    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println(mhs.toString());
        });
    }

    // Metode pencarian linear berdasarkan NIM untuk mencari indeks objek
    public int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    // Main Method
    public static void main(String[] args) {
        ListMahasiswa lm = new ListMahasiswa();
        
        // Membuat instansiasi objek mahasiswa
        Mahasiswa22 m = new Mahasiswa22("201234", "Noureen", "021xx1");
        Mahasiswa22 m1 = new Mahasiswa22("201235", "Akhleema", "021xx2");
        Mahasiswa22 m2 = new Mahasiswa22("201236", "Shannum", "021xx3");

        // Menambahkan objek mahasiswa ke dalam list
        lm.tambah(m, m1, m2);

        // Menampilkan list mahasiswa sebelum update
        System.out.println("--- Daftar Mahasiswa Awal ---");
        lm.tampil();

        // Memperbarui data mahasiswa dengan NIM "201235"
        int indexData = lm.linearSearch("201235");
        lm.update(indexData, new Mahasiswa22("201235", "Akhleema Lela", "021xx2"));

        // Menampilkan list mahasiswa setelah update
        System.out.println("\n--- Daftar Mahasiswa Setelah Update ---");
        lm.tampil();
    }
}
```


### Output Main Program
```bash
❯ java minggu14/ListMahasiswa22.java
Daftar Mahasiswa Awal
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema, notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}

Daftar Mahasiswa Setelah Update
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema Lela, notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}
```

### Pertanyaan 16.3.3 
1. **Pada fungsi tambah() yang menggunakan unlimited argument itu menggunakan konsep apa? Dan kelebihannya apa?**
Fungsi `tambah(Mahasiswa... mahasiswa)` menggunakan konsep `Varargs` (Variable Arguments) yang ditandai dengan operator tiga titik (...) setelah tipe data komponen objek.  

Kelebihannya: Memberikan fleksibilitas yang sangat tinggi saat pemanggilan metode. Jumlah argumen yang dikirimkan tidak perlu ditentukan secara kaku di awal. Metode tersebut dapat menerima satu objek, beberapa objek sekaligus yang dipisahkan oleh tanda koma (seperti `lm.tambah(m, m1, m2)`), menerima objek dalam bentuk satu larik penuh (array), bahkan bisa dipanggil tanpa argumen sama sekali tanpa memicu compile error.

2. **Pada fungsi linearSearch() di atas, silakan diganti dengan fungsi binarySearch() dari collection!**

Untuk menerapkan `Collections.binarySearch()`, objek di dalam list harus diurutkan terlebih dahulu, dan class `Mahasiswa22` perlu mengimplementasikan interface `Comparable` (atau menyediakan objek `Comparator`) agar program mengetahui parameter pencarian (dalam kasus ini adalah berdasarkan NIM).

Berikut adalah modifikasi fungsi pencariannya pada class ListMahasiswa:
```java
import java.util.Collections;
import java.util.Comparator;

int binarySearch(String nim) {
    // Membuat objek bantuan untuk parameter pencarian NIM
    Mahasiswa key = new Mahasiswa(nim, "", "");
    
    // Menyediakan Comparator untuk membandingkan NIM antar Mahasiswa
    Comparator<Mahasiswa> comp = new Comparator<Mahasiswa>() {
        @Override
        public int compare(Mahasiswa m1, Mahasiswa m2) {
            return m1.nim.compareTo(m2.nim);
        }
    };
    
    // Melakukan sorting terlebih dahulu karena syarat utama binary search adalah data harus terurut
    Collections.sort(mahasiswas, comp);
    
    // Memanggil fungsi binary search dari Collections framework
    return Collections.binarySearch(mahasiswas, key, comp);
}
```

hasil:
```bash
❯ java minggu14/ListMahasiswa22.java
Daftar Mahasiswa Awal:
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema, notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}

Menjalankan Linear Search...
[HASIL] NIM 201235 ditemukan via Linear Search pada indeks: 1

Data setelah di-update via Linear Search:
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema Lela (Linear), notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}

Menjalankan Binary Search...
[HASIL] NIM 201235 ditemukan via Binary Search pada indeks: 1

Data akhir setelah di-update via Binary Search:
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema Lela (Binary), notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}
```

3. **Tambahkan fungsi sorting baik secara ascending ataupun descending pada class tersebut!**

menambahkan kode ini:
```java
    // Fungsi untuk mengurutkan daftar mahasiswa berdasarkan NIM secara Ascending (Kecil ke Besar)
    public void sortAscending() {
        mahasiswas.sort((m1, m2) -> m1.nim.compareTo(m2.nim));
    }

    // Fungsi untuk mengurutkan daftar mahasiswa berdasarkan NIM secara Descending (Besar ke Kecil)
    public void sortDescending() {
        mahasiswas.sort((m1, m2) -> m2.nim.compareTo(m1.nim));
    }
```
Dua metode ini dapat dimasukkan ke dalam class `ListMahasiswa22` sebelum main method. Pengurutan dilakukan berdasarkan atribut NIM menggunakan ekspresi Lambda. 

hasil:
```bash
❯ java minggu14/ListMahasiswa22.java
DATA AWAL
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema, notelp=021xx2}

SETELAH SORT ASCENDING (NIM KECIL KE BESAR)
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
Mahasiswa{nim=201235, nama=Akhleema, notelp=021xx2}
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}

SETELAH SORT DESCENDING (NIM BESAR KE KECIL)
Mahasiswa{nim=201236, nama=Shannum, notelp=021xx3}
Mahasiswa{nim=201235, nama=Akhleema, notelp=021xx2}
Mahasiswa{nim=201234, nama=Noureen, notelp=021xx1}
```

## Tugas Praktikum

### Deskripsi
Pada tugas ini, fitur tambahan ditambahkan ke dalam `BinaryTree22`, yaitu:
1. `addRekursif(Node22 current, Mahasiswa22 m)` untuk menambah data dengan rekursi.
2. `cariMinIPK()` untuk menemukan mahasiswa dengan IPK terkecil (paling ujung kiri subtree).
3. `cariMaxIPK()` untuk menemukan mahasiswa dengan IPK terbesar (paling ujung kanan subtree).
4. `tampilMahasiswaIPKdiAtas(Node22 node, double ipkBatas)` untuk mencetak mahasiswa yang nilai IPK-nya melampaui ambang batas tertentu.

Semua penambahan ini telah berjalan dengan baik seperti yang bisa dilihat dari output uji coba program utama di bagian akhir percobaan 1.
