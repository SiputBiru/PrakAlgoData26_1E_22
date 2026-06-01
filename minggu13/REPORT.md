# Laporan Praktikum Minggu 13: Tree

---

## Percobaan 1: Implementasi Binary Search Tree menggunakan Linked List

### Deskripsi
Pada percobaan ini, mengimplementasikan Binary Search Tree (BST) menggunakan struktur data linked list. Tree dibangun dengan kelas `Node22` yang menyimpan objek `Mahasiswa22` sebagai data. Kelas `BinaryTree22` mengimplementasikan logika BST, dengan operasi `add`, `find`, `delete`, serta metode traversal (`PreOrder`, `InOrder`, dan `PostOrder`). Nilai IPK digunakan sebagai indikator posisi node dalam tree: lebih kecil ke kiri, dan lebih besar ke kanan.

### Kode Program
**Mahasiswa22.java**
```java
public class Mahasiswa22 {
    String nim, nama, kelas;
    double ipk;

    public Mahasiswa22() {}

    public Mahasiswa22(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + nim + " Nama: " + nama + " Kelas: " + kelas + " IPK: " + ipk);
    }
}
```

**Node22.java**
```java
public class Node22 {
    Mahasiswa22 mahasiswa;
    Node22 left, right;

    public Node22() {}

    public Node22(Node22 left, Mahasiswa22 mahasiswa, Node22 right) {
        this.mahasiswa = mahasiswa;
        this.left = left;
        this.right = right;
    }
}
```

**BinaryTree22.java**
```java
public class BinaryTree22 {
    Node22 root;

    public BinaryTree22() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa22 mahasiswa) {
        if (isEmpty()) {
            root = new Node22(null, mahasiswa, null);
        } else {
            Node22 current = root;
            while (true) {
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node22(null, mahasiswa, null);
                        break;
                    }
                } else if (mahasiswa.ipk > current.mahasiswa.ipk) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node22(null, mahasiswa, null);
                        break;
                    }
                } else { // ipk sama, abaikan atau timpa
                    break;
                }
            }
        }
    }

    public boolean find(double ipk) {
        Node22 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                return true;
            } else if (ipk < current.mahasiswa.ipk) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void traversePreOrder(Node22 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node22 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node22 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node22 getSuccessor(Node22 del) {
        Node22 successor = del.right;
        Node22 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) return;
        Node22 parent = root;
        Node22 current = root;
        boolean isLeftChild = false;
        while (current.mahasiswa.ipk != ipk) {
            parent = current;
            if (ipk < current.mahasiswa.ipk) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) return;
        }
        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.left = null;
            else parent.right = null;
        } else if (current.left == null) {
            if (current == root) root = current.right;
            else if (isLeftChild) parent.left = current.right;
            else parent.right = current.right;
        } else if (current.right == null) {
            if (current == root) root = current.left;
            else if (isLeftChild) parent.left = current.left;
            else parent.right = current.left;
        } else {
            Node22 successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.left = successor;
            else parent.right = successor;
            successor.left = current.left;
        }
    }

    public void addRekursif(Node22 current, Mahasiswa22 m) {
        if (isEmpty()) {
            root = new Node22(null, m, null);
        } else {
            if (m.ipk < current.mahasiswa.ipk) {
                if (current.left != null) {
                    addRekursif(current.left, m);
                } else {
                    current.left = new Node22(null, m, null);
                }
            } else if (m.ipk > current.mahasiswa.ipk) {
                if (current.right != null) {
                    addRekursif(current.right, m);
                } else {
                    current.right = new Node22(null, m, null);
                }
            }
        }
    }

    public void cariMinIPK() {
        if (isEmpty()) return;
        Node22 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.print("IPK Terkecil: ");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) return;
        Node22 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.print("IPK Terbesar: ");
        current.mahasiswa.tampilInformasi();
    }

    public void tampilMahasiswaIPKdiAtas(Node22 node, double ipkBatas) {
        if (node != null) {
            tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
        }
    }
}
```

**BinaryTreeMain22.java**
```java
public class BinaryTreeMain22 {
    public static void main(String[] args) {
        BinaryTree22 bt = new BinaryTree22();
        
        // Tambah 4 mahasiswa pertama
        bt.add(new Mahasiswa22("244160185", "Candra", "C", 3.21));
        bt.add(new Mahasiswa22("244160220", "Dewi", "B", 3.54));
        bt.add(new Mahasiswa22("244160121", "Ali", "A", 3.57));
        bt.add(new Mahasiswa22("244160221", "Badar", "B", 3.85));

        // Tampilkan traversal InOrder dan lakukan pencarian
        System.out.println("Daftar semua mahasiswa (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\nPencarian data mahasiswa:");
        System.out.println("Cari mahasiswa dengan ipk: 3.54 : " + (bt.find(3.54) ? "Ditemukan" : "Tidak ditemukan"));
        System.out.println("Cari mahasiswa dengan ipk: 3.22 : " + (bt.find(3.22) ? "Ditemukan" : "Tidak ditemukan"));

        // Tambah 3 mahasiswa berikutnya
        bt.add(new Mahasiswa22("244160205", "Ehsan", "D", 3.37));
        bt.add(new Mahasiswa22("244160170", "Fizi", "B", 3.46));
        bt.add(new Mahasiswa22("244160131", "Devi", "A", 3.72));

        // Tampilkan traversal dengan header yang sesuai
        System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
        System.out.println("InOrder Traversal:");
        bt.traverseInOrder(bt.root);
        System.out.println("\nPreOrder Traversal:");
        bt.traversePreOrder(bt.root);
        System.out.println("\nPostOrder Traversal:");
        bt.traversePostOrder(bt.root);

        // Hapus Ali (IPK 3.57) dan tampilkan traversal InOrder akhir
        System.out.println("\nPenghapusan data mahasiswa");
        bt.delete(3.57); // Ali

        System.out.println("\nDaftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\nPenambahan 1 mahasiswa menggunakan addRekursif (Gani, IPK 3.65):");
        bt.addRekursif(bt.root, new Mahasiswa22("244160230", "Gani", "A", 3.65));

        System.out.println("\nDaftar semua mahasiswa setelah penambahan dengan addRekursif (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\n--- Uji Coba Tugas ---");
        bt.cariMinIPK();
        bt.cariMaxIPK();
        System.out.println("\nMahasiswa dengan IPK > 3.50:");
        bt.tampilMahasiswaIPKdiAtas(bt.root, 3.50);
    }
}
```

### Output Main Program
```bash
Daftar semua mahasiswa (in order traversal):
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Pencarian data mahasiswa:
Cari mahasiswa dengan ipk: 3.54 : Ditemukan
Cari mahasiswa dengan ipk: 3.22 : Tidak ditemukan

Daftar semua mahasiswa setelah penambahan 3 mahasiswa:
InOrder Traversal:
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

PreOrder Traversal:
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72

PostOrder Traversal:
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21

Penghapusan data mahasiswa

Daftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Penambahan 1 mahasiswa menggunakan addRekursif (Gani, IPK 3.65):

Daftar semua mahasiswa setelah penambahan dengan addRekursif (in order traversal):
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160230 Nama: Gani Kelas: A IPK: 3.65
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

--- Uji Coba Tugas ---
IPK Terkecil: NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
IPK Terbesar: NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Mahasiswa dengan IPK > 3.50:
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160230 Nama: Gani Kelas: A IPK: 3.65
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
```

### Pertanyaan 14.2.2
1. **Mengapa dalam binary search tree pencarian data bisa dilakukan lebih efektif dibanding binary tree biasa?**
   Karena data pada BST sudah terurut; nilai yang lebih kecil berada di subtree kiri dan nilai yang lebih besar di subtree kanan. Hal ini memungkinkan waktu pencarian rata-rata sebesar O(log n).
2. **Apa fungsi atribut `left` dan `right` pada class Node?**
   Sebagai pointer/referensi ke node anak (child nodes), yaitu child kiri (subtree kiri) dan child kanan (subtree kanan).
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
