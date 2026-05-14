
# REPORT

## Percobaan 1: Operasi Penambahan pada Double Linked List

kode program:

Mahasiswa22.java

```java
public class Mahasiswa22 {
  String nim, nama, kelas;
  double ipk;

  public Mahasiswa22(String nim, String nama, String kelas, double ipk) {
    this.nim = nim;
    this.nama = nama;
    this.kelas = kelas;
    this.ipk = ipk;
  }

  public void tampil() {
    System.out.println("NIM   : " + nim + "\nNama  : " + nama +
        "\nKelas : " + kelas + "\nIPK   : " + ipk);
  }
}
```

Node22.java

```java
public class Node22 {
  Mahasiswa22 data;
  Node22 prev, next;

  public Node22(Mahasiswa22 data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}
```

DoubleLinkedList22.java

```java
public class DoubleLinkedList22 {
  Node22 head, tail;

  public DoubleLinkedList22() {
    head = tail = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void addFirst(Mahasiswa22 data) {
    Node22 newNode = new Node22(data);
    if (isEmpty()) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public void addLast(Mahasiswa22 data) {
    Node22 newNode = new Node22(data);
    if (isEmpty()) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  public void insertAfter(String keyNim, Mahasiswa22 data) {
    Node22 current = head;
    while (current != null && !current.data.nim.equals(keyNim)) {
      current = current.next;
    }
    if (current == null) {
      System.out.println("NIM tidak ditemukan.");
      return;
    }
    Node22 newNode = new Node22(data);
    if (current == tail) {
      addLast(data);
    } else {
      newNode.next = current.next;
      newNode.prev = current;
      current.next.prev = newNode;
      current.next = newNode;
    }
  }

  public void removeFirst() {
    if (isEmpty())
      return;
    System.out.println("Data " + head.data.nama + " berhasil dihapus.");
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }
  }

  public void removeLast() {
    if (isEmpty())
      return;
    System.out.println("Data " + tail.data.nama + " berhasil dihapus.");
    if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
    }
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Linked List masih kosong.");
      return;
    }
    Node22 current = head;
    while (current != null) {
      current.data.tampil();
      current = current.next;
    }
  }

  public void printReverse() {
    if (isEmpty()) {
      System.out.println("Linked List masih kosong.");
      return;
    }
    Node22 current = tail;
    while (current != null) {
      current.data.tampil();
      current = current.prev;
    }
  }
}
```

DoubleLinkedListMain22.java

```java
public class DoubleLinkedListMain22 {
  public static void main(String[] args) {
    DoubleLinkedList22 dll = new DoubleLinkedList22();

    Mahasiswa22 mhs1 = new Mahasiswa22("123001", "Harry", "1A", 3.76);
    Mahasiswa22 mhs2 = new Mahasiswa22("123002", "Ron", "1A", 3.5);
    Mahasiswa22 mhs3 = new Mahasiswa22("123003", "Hermione", "1A", 4.0);
    Mahasiswa22 mhs4 = new Mahasiswa22("123004", "Neville", "1B", 3.2);

    System.out.println("======= UJI COBA PENAMBAHAN =======");
    dll.addFirst(mhs2);
    dll.addFirst(mhs3);
    dll.addLast(mhs1);

    System.out.println("Isi Linked List:");
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("Sisipkan Neville setelah NIM 123002 (Ron):");
    dll.insertAfter("123002", mhs4);
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= UJI COBA PENGHAPUSAN =======");
    dll.removeFirst();
    System.out.println("Setelah removeFirst:");
    dll.print();

    System.out.println("\nSetelah removeLast:");
    dll.removeLast();
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= CETAK TERBALIK (REVERSE) =======");
    dll.printReverse();

    System.out.println("\nSelesai.");
  }
}
```

output:

```bash
======= UJI COBA PENAMBAHAN =======
Isi Linked List:
NIM   : 123003
Nama  : Hermione
Kelas : 1A
IPK   : 4.0
...
======= CETAK TERBALIK (REVERSE) =======
NIM   : 123004
Nama  : Neville
Kelas : 1B
IPK   : 3.2
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5

Selesai.
```

jawab pertanyaan:

1. Jelaskan perbedaan struktur dan mekanisme traversal antara Single Linked List dan Double Linked List!

jawab:

- Struktur: Single Linked List hanya memiliki satu pointer (next) yang merujuk ke node berikutnya. Double Linked List memiliki dua pointer, yaitu next untuk node berikutnya dan prev untuk merujuk kembali ke node sebelumnya.  

- Mekanisme Traversal: Pada Single Linked List, penelusuran (traversal) hanya dapat dilakukan satu arah, yaitu maju dari head ke arah tail. Pada Double Linked List, penelusuran dapat dilakukan dua arah: maju dari head ke tail menggunakan pointer next, dan mundur dari tail ke head menggunakan pointer prev.

2\. Jelaskan fungsi atribut next dan prev pada proses traversal dan manipulasi node!

jawab:

- Atribut next: Berfungsi sebagai penghubung untuk melangkah ke node selanjutnya selama traversal maju dan digunakan untuk menyambungkan node saat proses penambahan atau penghapusan data.  
- Atribut prev: Berfungsi sebagai penghubung untuk kembali ke node sebelumnya (traversal mundur) dan memungkinkan manipulasi node (seperti penghapusan di tengah atau akhir) tanpa harus menelusuri list dari awal untuk mencari node sebelumnya.

3\. Jelaskan fungsi konstruktor pada class DoubleLinkedList terhadap kondisi awal linked list!

Konstruktor berfungsi untuk menginisialisasi kondisi awal Double Linked List saat objek pertama kali dibuat, yaitu dengan mengatur head dan tail bernilai null. Hal ini menandakan bahwa saat itu linked list masih dalam keadaan kosong.

4\. Mengapa head dan tail harus menunjuk node yang sama ketika linked list masih kosong (pada penambahan pertama)?

Karena pada saat penambahan node pertama kali, hanya terdapat satu buah node di dalam linked list. Dalam struktur data linked list, node tunggal tersebut secara otomatis berperan sebagai elemen pertama (head) sekaligus elemen terakhir (tail).

5\. Modifikasi method print() agar menampilkan pesan "Linked List masih kosong" ketika tidak terdapat data!

```java
public void print() {
    if (isEmpty()) {
        System.out.println("Linked List masih kosong.");
        return;
    }
    // ... proses print selanjutnya
}
```

6\. Modifikasi kode program dengan menambahkan method printReverse()!

jawab:

```java
public void printReverse() {
    if (isEmpty()) {
        System.out.println("Linked List masih kosong.");
        return;
    }
    Node22 current = tail;
    while (current != null) {
        current.data.tampil();
        current = current.prev;
    }
}
```

## Percobaan 2: Operasi Penghapusan pada Double Linked List

kode program:

pada Class DoubleLinkedList22 kita hanya perlu menambahkan 2 method ini:

```java
  public void removeFirst() {
    if (isEmpty())
      return;
    System.out.println("Data " + head.data.nama + " berhasil dihapus.");
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }
  }

  public void removeLast() {
    if (isEmpty())
      return;
    System.out.println("Data " + tail.data.nama + " berhasil dihapus.");
    if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
    }
  }

```

DoubleLinkedListMain22.java

```java
public class DoubleLinkedListMain22 {
  public static void main(String[] args) {
    DoubleLinkedList22 dll = new DoubleLinkedList22();

    Mahasiswa22 mhs1 = new Mahasiswa22("123001", "Harry", "1A", 3.76);
    Mahasiswa22 mhs2 = new Mahasiswa22("123002", "Ron", "1A", 3.5);
    Mahasiswa22 mhs3 = new Mahasiswa22("123003", "Hermione", "1A", 4.0);
    Mahasiswa22 mhs4 = new Mahasiswa22("123004", "Neville", "1B", 3.2);

    System.out.println("======= UJI COBA PENAMBAHAN =======");
    dll.addFirst(mhs2);
    dll.addFirst(mhs3);
    dll.addLast(mhs1);

    System.out.println("Isi Linked List:");
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("Sisipkan Neville setelah NIM 123002 (Ron):");
    dll.insertAfter("123002", mhs4);
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= UJI COBA PENGHAPUSAN =======");
    dll.removeFirst();
    System.out.println("Setelah removeFirst:");
    dll.print();

    System.out.println("\nSetelah removeLast:");
    dll.removeLast();
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= CETAK TERBALIK (REVERSE) =======");
    dll.printReverse();

    System.out.println("\nSelesai.");
  }
}

```

jawab pertanyaan:

1\. head = head.next;: Berfungsi untuk menggeser penanda awal list ke node berikutnya sehingga node pertama lama tidak lagi dapat diakses melalui head.

2\. head.prev = null;: Berfungsi untuk menghapus referensi balik dari node pertama yang baru ke arah node yang telah dihapus, guna memastikan node lama benar-benar terputus dari struktur.

3\. Output Modifikasi: Dengan menambahkan perintah System.out.println sebelum pointer dipindahkan, program sekarang akan menginformasikan nama mahasiswa yang berhasil dikeluarkan dari list.

output:

```bash
❯ java DoubleLinkedListMain22.java
======= UJI COBA PENAMBAHAN =======
Isi Linked List:
NIM   : 123003
Nama  : Hermione
Kelas : 1A
IPK   : 4.0
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5
NIM   : 123001
Nama  : Harry
Kelas : 1A
IPK   : 3.76
-----------------------------------
Sisipkan Neville setelah NIM 123002 (Ron):
NIM   : 123003
Nama  : Hermione
Kelas : 1A
IPK   : 4.0
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5
NIM   : 123004
Nama  : Neville
Kelas : 1B
IPK   : 3.2
NIM   : 123001
Nama  : Harry
Kelas : 1A
IPK   : 3.76
-----------------------------------

======= UJI COBA PENGHAPUSAN =======
Data Hermione berhasil dihapus.
Setelah removeFirst:
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5
NIM   : 123004
Nama  : Neville
Kelas : 1B
IPK   : 3.2
NIM   : 123001
Nama  : Harry
Kelas : 1A
IPK   : 3.76

Setelah removeLast:
Data Harry berhasil dihapus.
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5
NIM   : 123004
Nama  : Neville
Kelas : 1B
IPK   : 3.2
-----------------------------------

======= CETAK TERBALIK (REVERSE) =======
NIM   : 123004
Nama  : Neville
Kelas : 1B
IPK   : 3.2
NIM   : 123002
Nama  : Ron
Kelas : 1A
IPK   : 3.5

Selesai.
```
