
# REPORT

## Percobaan 1: Operasi Dasar Queue

### Kode Program

Queue.java

```java
public class Queue {
  int[] data;
  int front;
  int rear;
  int size;
  int max;

  public Queue(int n) {
    max = n;
    data = new int[max];
    size = 0;
    front = rear = -1;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if (size == max) {
      return true;
    } else {
      return false;
    }
  }

  public void peek() {
    if (!isEmpty()) {
      System.out.println("Elemen terdepan: " + data[front]);
    } else {
      System.out.println("Queue Masih Kosong");
    }
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Queue Masih Kosong");
    } else {
      int i = front;
      while (i != rear) {
        System.out.print(data[i] + " ");
        i = (i + 1) % max;
      }
      System.out.println(data[i] + " ");
      System.out.println("Jumlah elemen = " + size);
    }
  }

  public void clear() {
    if (!isEmpty()) {
      front = rear = -1;
      size = 0;
      System.out.println("Queue berhasil dikosongkan");
    } else {
      System.out.println("Queue masih kosong");
    }
  }

  public void Enqueue(int dt) {
    if (isFull()) {
      System.out.println("Queue sudah penuh");
    } else {
      if (isEmpty()) {
        front = rear = 0;
      } else {
        if (rear == max - 1) {
          rear = 0;
        } else {
          rear++;
        }
      }
      data[rear] = dt;
      size++;
    }
  }

  public int Dequeue() {
    int dt = 0;
    if (isEmpty()) {
      System.out.println("Queue masih kosong");
    } else {
      dt = data[front];
      size--;
      if (isEmpty()) {
        front = rear = -1;
      } else {
        front++;
      }
    }
    return dt;
  }
}
```

QueueMain.java

```java
import java.util.Scanner;

public class QueueMain {
  public static void menu() {
    System.out.println("Masukkan operasi yang diinginkan ");
    System.out.println("1. Enqueue");
    System.out.println("2. Dequeue");
    System.out.println("3. Print");
    System.out.println("4. Peek");
    System.out.println("5. Clear");
    System.out.println("======================================");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan kapasistas queue: ");
    int n = sc.nextInt();

    Queue Q = new Queue(n);

    int pilih;

    do {
      menu();
      pilih = sc.nextInt();
      switch (pilih) {
        case 1:
          System.out.print("Masukkan data baru: ");
          int dataMasuk = sc.nextInt();
          Q.Enqueue(dataMasuk);
          break;
        case 2:
          int dataKeluar = Q.Dequeue();
          if (dataKeluar != 0) {
            System.out.println("Data yang dikeluarkan " + dataKeluar);
            break;
          }
        case 3:
          Q.print();
          break;
        case 4:
          Q.peek();
          break;
        case 5:
          Q.clear();
          break;
      }

    } while (pilih > 0 && pilih <= 5);

    sc.close();
  }
}
```

output:

```bash
java QueueMain.java
Masukkan kapasistas queue: 1000
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
1
Masukkan data baru: 10
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
1
Masukkan data baru: 10
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
1
Masukkan data baru: 90
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
3
10 10 90 
Jumlah elemen = 3
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
2
Data yang dikeluarkan 10
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
3
10 90 
Jumlah elemen = 2
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
4
Elemen terdepan: 10
Masukkan operasi yang diinginkan 
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
======================================
```

### Jawaban pertanyaan

1\. Mengapa nilai awal `front` dan `rear` bernilai -1, sementara `size` bernilai 0""

jawab:
Nilai -1 digunakan sebagai penanda bahwa Queue dalam kondisi kosong dan belum ada indeks array yang ditunjuk. Sementara itu, size bernilai 0 karena variabel ini berfungsi menghitung jumlah elemen yang benar-benar ada di dalam Queue secara riil. Penggunaan -1 memudahkan pengecekan saat pertama kali data dimasukkan (indeks akan berubah menjadi 0).

2\. Jelaskan maksud potongan kode: `if (rear == max - 1) { rear = 0; }` pada method `Enqueue`!

jawab:
Potongan kode ini menerapkan prinsip **Circular Queue**. Artinya, jika posisi `rear` (penunjuk belakang) sudah mencapai batas maksimal indeks array (`max - 1`), namun Queue belum penuh (masih ada ruang kosong di depan akibat proses dequeue), maka `rear` akan dikembalikan ke indeks **0**. Ini dilakukan agar ruang array dapat digunakan secara optimal dan terus berputar.

3\. Jelaskan maksud potongan kode: `if (front == max - 1) { front = 0; }` pada method **Dequeue**!

jawab:
Sama halnya dengan `Enqueue`, kode ini berfungsi untuk mendukung **Circular Queue**. Ketika elemen pada indeks terakhir (`max - 1`) diambil (didikeluarkan), maka posisi `front` (penunjuk depan) akan bergeser kembali ke indeks 0. Ini memastikan alur antrian tetap berlanjut secara melingkar di dalam array.

4\. Pada method print, mengapa pada proses perulangan variabel i tidak dimulai dari 0 `(int i=0)`, melainkan int `i = front` ?

jawab:

Karena dalam struktur data Queue, urutan elemen tidak selalu dimulai dari indeks 0, melainkan dari posisi `front`. Elemen yang pertama kali keluar adalah elemen yang ditunjuk oleh `front`, sehingga proses penampilan data harus mengikuti urutan antrian yang sah, bukan urutan fisik array dari nol.

5\. Perhatikan kembali method print, jelaskan maksud dari potongan kode berikut!
`i = (i + 1) % max;`

jawab:

Operasi Modulo (`% max`) digunakan untuk melakukan iterasi secara melingkar (circular navigation). Kode ini memastikan bahwa ketika variabel pembantu i mencapai indeks terakhir array, ia akan kembali ke indeks 0 untuk terus mencetak data hingga mencapai posisi `rear`.

6\. Tunjukkan potongan kode program yang merupakan queue overflow!

jawab:

Queue Overflow terjadi ketika kita mencoba menambahkan data ke dalam Queue yang sudah penuh. Potongan kodenya adalah:

```java
if (isFull()) {
    System.out.println("Queue sudah penuh");
}
```

Kondisi `isFull()` inilah yang mendeteksi terjadinya overflow.

7\. Pada saat terjadi queue overflow dan queue underflow, program tersebut tetap dapat berjalan dan hanya menampilkan teks informasi. Lakukan modifikasi program sehingga pada saat terjadi queue overflow dan queue underflow, program dihentikan!

jawab:

Untuk menghentikan program (bukan hanya menampilkan pesan), kamu bisa menggunakan `System.exit(0)`.

Modifikasi pada `Enqueue` (Overflow):

```java
public void Enqueue (int dt) {
    if (IsFull()) {
        System.out.println("Queue sudah penuh. Program dihentikan.");
        System.exit(0); // Menghentikan program
    } else {
        // ... sisa kode tetap ...
    }
}
```

Modifikasi pada `Dequeue` (Underflow):

```java
public int Dequeue() {
    int dt = 0;
    if (IsEmpty()) {
        System.out.println("Queue masih kosong. Program dihentikan.");
        System.exit(0); // Menghentikan program
    } else {
        // ... sisa kode tetap ...
    }
    return dt;
}
```

## Percobaan 2: Antrian Layanan Akademik
