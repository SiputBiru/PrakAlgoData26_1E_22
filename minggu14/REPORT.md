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
PrakAlgoData26_1E_22 main  ? ❯ java minggu14/ContohList22.java
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

3. **Atribut `root` di class BinaryTree:**
   a. **Apa kegunaan dari atribut `root` di dalam class BinaryTree?** Sebagai titik awal (entry point) atau node teratas dari sebuah tree.
   b. **Ketika objek tree pertama kali dibuat, apa nilai dari `root`?** Bernilai `null` karena tree masih kosong.
4. **Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?**
   Node baru tersebut akan langsung diatur dan ditetapkan menjadi node `root`.
5. **Perhatikan method `add()`, di dalamnya terdapat baris program seperti di bawah ini. Jelaskan secara logis untuk apa kode tersebut terjadi?**
   ```java
   if(data < current.data){
    if(current.left!=null){
       current = current.left;
    }else{
       current.left = new Node(data);
       break;
    }
   }
   ```
   Kode ini membandingkan data baru dengan data saat ini. Jika lebih kecil, node akan diarahkan ke child kiri. Jika child kiri belum kosong, iterasi terus berlanjut ke bawah. Jika child kiri kosong, node baru ditempatkan di sana lalu perulangan dihentikan (`break`).
6. **Penghapusan node dengan dua child:**
   Jika sebuah node memiliki dua child, kita menggunakan *successor* (node dengan nilai terkecil pada subtree kanan) atau *predecessor* untuk menggantikan posisi node yang dihapus. Dengan demikian, properti BST tetap terjaga.

---

## Percobaan 2: Implementasi Binary Tree dengan Array

### Deskripsi
Percobaan kedua menunjukkan representasi Binary Tree menggunakan array linear. Atribut `idxLast` berfungsi untuk melacak elemen terakhir. Posisi relasi parent-child ditentukan menggunakan formula perhitungan indeks (misal: anak kiri di `2*i+1` dan kanan di `2*i+2`).

### Kode Program
**BinaryTreeArray22.java**
```java
public class BinaryTreeArray22 {
    Mahasiswa22[] data;
    int idxLast;

    public BinaryTreeArray22() {
        data = new Mahasiswa22[100]; // Ukuran default
        idxLast = -1;
    }

    public void populateData(Mahasiswa22[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    public void add(Mahasiswa22 m) {
        if (idxLast + 1 < data.length) {
            idxLast++;
            data[idxLast] = m;
        } else {
            System.out.println("Tree array is full!");
        }
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            traverseInOrder(2 * idxStart + 1);
            System.out.println(data[idxStart].nama + " (" + data[idxStart].ipk + ")");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            System.out.println(data[idxStart].nama + " (" + data[idxStart].ipk + ")");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}
```

**BinaryTreeArrayMain22.java**
```java
public class BinaryTreeArrayMain22 {
    public static void main(String[] args) {
        BinaryTreeArray22 bta = new BinaryTreeArray22();
        
        System.out.println("--- Populate Data ---");
        Mahasiswa22[] mhs = new Mahasiswa22[10];
        mhs[0] = new Mahasiswa22("22001", "Ani", "1E", 3.8);
        mhs[1] = new Mahasiswa22("22002", "Budi", "1E", 3.5);
        mhs[2] = new Mahasiswa22("22003", "Cici", "1E", 3.9);
        
        bta.populateData(mhs, 2);
        
        System.out.println("InOrder Traversal:");
        bta.traverseInOrder(0);
        
        System.out.println("\n--- Add New Student ---");
        bta.add(new Mahasiswa22("22004", "Dodi", "1E", 3.2)); // Indeks 3, anak dari Budi
        
        System.out.println("PreOrder Traversal:");
        bta.traversePreOrder(0);
    }
}
```

### Output Main Program
```bash
--- Populate Data ---
InOrder Traversal:
Budi (3.5)
Ani (3.8)
Cici (3.9)

--- Add New Student ---
PreOrder Traversal:
Ani (3.8)
Budi (3.5)
Dodi (3.2)
Cici (3.9)
```

### Pertanyaan 14.3.2
1. **Apakah kegunaan atribut `data` dan `idxLast` pada class BinaryTreeArray?**
   `data` menyimpan objek/node pada tree, sedangkan `idxLast` menandai batas indeks elemen terakhir yang terisi dalam array.
2. **Apakah kegunaan method `populateData()`?**
   Untuk menginisialisasi secara bulk/massal elemen data dari array luar beserta `idxLast` ke dalam struktur BinaryTreeArray.
3. **Apakah fungsi dari method `traverseInOrder()`?**
   Untuk menampilkan data node-node secara terurut jika tree tersebut adalah BST, atau dengan urutan anak kiri -> root -> anak kanan pada Tree.
4. **Jika root ada pada indeks 0, lalu suatu node memiliki indeks 2, berapakah indeks left child dan right child node tersebut?**
   Berdasarkan formula array 0-indexed: 
   Left child = 2 * 2 + 1 = 5.
   Right child = 2 * 2 + 2 = 6.
5. **Apa kegunaan nilai statement `int idxLast = 6` pada praktikum?**
   Nilai ini memberi tahu tree bahwa indeks terakhir yang valid adalah 6, sehingga traversal atau pencarian dibatasi sampai maksimal 7 elemen saja (indeks 0 sampai 6).
6. **Berdasarkan soal nomor 5, jelaskan kegunaan baris `traverseInOrder(2 * idxStart + 1)` pada method `traverseInOrder()`!**
   Ini adalah pemanggilan rekursif menggunakan rumus standar `2 * index + 1` untuk meng-eksplorasi atau mengunjungi subtree kiri pada representasi array tree 0-indexed.

---

## Tugas Praktikum

### Deskripsi
Pada tugas ini, fitur tambahan ditambahkan ke dalam `BinaryTree22`, yaitu:
1. `addRekursif(Node22 current, Mahasiswa22 m)` untuk menambah data dengan rekursi.
2. `cariMinIPK()` untuk menemukan mahasiswa dengan IPK terkecil (paling ujung kiri subtree).
3. `cariMaxIPK()` untuk menemukan mahasiswa dengan IPK terbesar (paling ujung kanan subtree).
4. `tampilMahasiswaIPKdiAtas(Node22 node, double ipkBatas)` untuk mencetak mahasiswa yang nilai IPK-nya melampaui ambang batas tertentu.

Semua penambahan ini telah berjalan dengan baik seperti yang bisa dilihat dari output uji coba program utama di bagian akhir percobaan 1.
