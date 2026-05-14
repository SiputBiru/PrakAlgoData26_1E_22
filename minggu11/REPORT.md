# REPORT

## Percobaan 1: Pembatan Single Linked List

### Kode Program

Mahasiswa22.java

```java
Mahasiswa22 {
  String nim, nama, kelas;
  double ipk;

  public Mahasiswa22() {
  }

  public Mahasiswa22(String nim, String nama, String kelas, double ipk) {
    this.nim = nim;
    this.nama = nama;
    this.kelas = kelas;
    this.ipk = ipk;
  }

  public void tampilInformasi() {
    System.out.println("Nama: " + nama);
    System.out.println("NIM: " + nim);
    System.out.println("Kelas: " + kelas);
    System.out.println("IPK: " + ipk);
  }

}
```

NodeMahasiswa22.java

```java
 class NodeMahasiswa22 {
  Mahasiswa22 data;
  NodeMahasiswa22 next;

  public NodeMahasiswa22(Mahasiswa22 data, NodeMahasiswa22 next) {
    this.data = data;
    this.next = next;
  }
}
```

SingleLinkedList22.java

```java
public class SingleLinkedList22 {
  NodeMahasiswa22 head;
  NodeMahasiswa22 tail;

  boolean isEmpty() {
    return (head == null);
  }

  public void print() {
    if (!isEmpty()) {
      NodeMahasiswa22 tmp = head;
      System.out.print("Isi Linked List:\t");
      while (tmp != null) {
        tmp.data.tampilInformasi();
        tmp = tmp.next;
      }
      System.out.println("");
    } else {
      System.out.println("Linked list kosong");
    }
  }

  public void addFirst(Mahasiswa22 input) {
    NodeMahasiswa22 ndInput = new NodeMahasiswa22(input, null);
    if (isEmpty()) {
      head = ndInput;
      tail = ndInput;
    } else {
      ndInput.next = head;
      head = ndInput;
    }
  }

  public void addLast(Mahasiswa22 input) {
    NodeMahasiswa22 ndInput = new NodeMahasiswa22(input, null);
    if (isEmpty()) {
      head = ndInput;
      tail = ndInput;
    } else {
      tail.next = ndInput;
      tail = ndInput;
    }
  }

  public void insertAfter(String key, Mahasiswa22 input) {
    NodeMahasiswa22 ndInput = new NodeMahasiswa22(input, null);
    NodeMahasiswa22 temp = head;
    do {
      if (temp.data.nama.equalsIgnoreCase(key)) {
        ndInput.next = temp.next;
        temp.next = ndInput;
        if (ndInput.next == null) {
          tail = ndInput;
        }
        break;
      }
      temp = temp.next;
    } while (temp != null);
  }

  public void insertAt(int index, Mahasiswa22 input) {
    if (index < 0) {
      System.out.println("indeks salah");
    } else if (index == 0) {
      addFirst(input);
    } else {
      NodeMahasiswa22 temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      temp.next = new NodeMahasiswa22(input, temp.next);
      if (temp.next.next == null) {
        tail = temp.next;
      }
    }
  }
}
```

SLLMain22.java

```java
public class SLLMain22 {
  public static void main(String[] args) {
    SingleLinkedList22 sll = new SingleLinkedList22();

    Mahasiswa22 mhs1 = new Mahasiswa22("24212200", "Alvaro", "1A", 4.0);
    Mahasiswa22 mhs2 = new Mahasiswa22("22212202", "Cintia", "3C", 3.5);
    Mahasiswa22 mhs3 = new Mahasiswa22("23212201", "Bimon", "2B", 3.8);
    Mahasiswa22 mhs4 = new Mahasiswa22("21212203", "Dirga", "4D", 3.6);

    sll.print(); 
    sll.addFirst(mhs4);
    sll.print();
    sll.addLast(mhs1);
    sll.print();
    sll.insertAfter("Dirga", mhs3);
    sll.insertAt(2, mhs2);
    sll.print();
  }
}
```

output:

```bash
❯ java SLLMain22.java
Linked list kosong
Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6

Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6
Nama: Alvaro
NIM: 24212200
Kelas: 1A
IPK: 4.0

Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6
Nama: Bimon
NIM: 23212201
Kelas: 2B
IPK: 3.8
Nama: Cintia
NIM: 22212202
Kelas: 3C
IPK: 3.5
Nama: Alvaro
NIM: 24212200
Kelas: 1A
IPK: 4.0
```

### Jawaban pertanyaan

1\. Mengapa baris pertama menghasilkan "Linked List Kosong"?

Hal ini terjadi karena objek sll baru saja diinstansiasi dan belum ada penambahan data apa pun ke dalam struktur tersebut, sehingga kondisi `head == null` terpenuhi.

2\. Jelaskan kegunaan variabel temp secara umum pada setiap method!

Variabel `temp` (atau tmp) digunakan sebagai variabel pembantu untuk melakukan traverse atau penelusuran dari satu node ke node berikutnya tanpa mengubah posisi referensi head yang asli.

3\. Modifikasi dengan input keyboard

kita bisa menambahkan scanner seperti ini:

```java
import java.util.Scanner;

public class SLLMain22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList22 sll = new SingleLinkedList22();

        System.out.println("--- Input Data Mahasiswa ---");
        for (int i = 0; i < 4; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine(); // Membersihkan buffer

            Mahasiswa22 mhs = new Mahasiswa22(nim, nama, kelas, ipk);
            
            // masukkan ke urutan terakhir
            sll.addLast(mhs);
            System.out.println("---------------------------");
        }

        System.out.println("\n--- Hasil Linked List ---");
        sll.print();
        
        sc.close();
    }
}
```

## Percobaan 2: Modifikasi Elemen pad Single Linked List

Kode program:

kita tambahkan beberapa method seperti ini:

SingleLinkedList22.java

```java
// Method untuk mendapatkan data pada indeks tertentu
    public void getData(int index) {
        NodeMahasiswa22 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    // Method untuk mendapatkan indeks berdasarkan nama (key)
    public int indexOf(String key) {
        NodeMahasiswa22 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) { 
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    // Method untuk menghapus node pertama
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    // Method untuk menghapus node terakhir
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa22 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    // Method untuk menghapus node berdasarkan nama (key)
    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else {
            NodeMahasiswa22 temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.next != null && temp.next.data.nama.equalsIgnoreCase(key)) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // Method untuk menghapus node pada indeks tertentu 
    public void removeAt(int index) {
        if (index == 0) { 
            removeFirst();
        } else {
            NodeMahasiswa22 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
```

SLLMain22.java

```java
        System.out.println("Data index 1: "); 
        sll.getData(1);
        
        System.out.println("Data mahasiswa Bimon berada pada index: " + sll.indexOf("Bimon"));
        System.out.println();
        
        sll.removeFirst();
        sll.removeLast();
        sll.print();
        
        sll.removeAt(0);
        sll.print();
```

output:

```bash
❯ java SLLMain22.java
Linked list kosong
Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6

Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6
Nama: Alvaro
NIM: 24212200
Kelas: 1A
IPK: 4.0

Isi Linked List: Nama: Dirga
NIM: 21212203
Kelas: 4D
IPK: 3.6
Nama: Bimon
NIM: 23212201
Kelas: 2B
IPK: 3.8
Nama: Cintia
NIM: 22212202
Kelas: 3C
IPK: 3.5
Nama: Alvaro
NIM: 24212200
Kelas: 1A
IPK: 4.0

Data index 1: 
Nama: Bimon
NIM: 23212201
Kelas: 2B
IPK: 3.8
Data mahasiswa Bimon berada pada index: 1

Isi Linked List: Nama: Bimon
NIM: 23212201
Kelas: 2B
IPK: 3.8
Nama: Cintia
NIM: 22212202
Kelas: 3C
IPK: 3.5

Isi Linked List: Nama: Cintia
NIM: 22212202
Kelas: 3C
IPK: 3.5
```

1\. Mengapa digunakan keyword break pada fungsi remove? Jelaskan!

Keyword break digunakan untuk menghentikan perulangan segera setelah data yang dicari (berdasarkan key) ditemukan dan berhasil dihapus. Hal ini bertujuan untuk efisiensi agar program tidak terus melakukan penelusuran ke node-node selanjutnya jika tugas penghapusan sudah selesai dilakukan.  

2\. Jelaskan kegunaan kode `temp.next = temp.next.next;` pada method remove!

Potongan kode ini berfungsi untuk memutuskan ikatan node yang ingin dihapus dari rantai Linked List. Secara teknis, referensi next dari node saat ini (temp) diarahkan untuk melompati satu node di depannya dan langsung menunjuk ke node berikutnya lagi (next.next), sehingga node target tidak lagi terhubung dalam list dan akan dihapus oleh garbage collector.  

Jelaskan kegunaan pengecekan if (temp.next == null) setelah penghapusan! Pengecekan ini bertujuan untuk memperbarui penanda tail. Jika setelah sebuah node dihapus ternyata temp.next menjadi null, itu berarti node temp sekarang menjadi elemen terakhir dalam list, sehingga tail harus diarahkan ke node temp tersebut agar integritas struktur Linked List tetap terjaga.
