public class AntrianKRS {
  Mahasiswa[] data;
  int front, rear, size, max;
  int totalServiced = 0;

  public AntrianKRS(int n) {
    max = n;
    data = new Mahasiswa[max];
    size = 0;
    front = 0;
    rear = -1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == max;
  }

  public void clear() {
    if (!isEmpty()) {
      front = 0;
      rear = -1;
      size = 0;
      System.out.println("Antrian berhasil dikosongkan");
    } else {
      System.out.println("Antrian sudah kosong");
    }
  }

  public void tambahAntrian(Mahasiswa mhs) {
    if (isFull()) {
      System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
    } else {
      rear = (rear + 1) % max;
      data[rear] = mhs;
      size++;
      System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }
  }

  public void layaniKRS() {
    if (size >= 2) {
      for (int i = 0; i < 2; i++) {
        Mahasiswa m = data[front];
        System.out.println("Memproses KRS: " + m.nama);
        front = (front + 1) % max;
        size--;
        totalServiced++;
      }
    } else if (size == 1) {
      System.out.println("Hanya ada 1 mahasiswa, tetap diproses.");
      Mahasiswa m = data[front];
      front = (front + 1) % max;
      System.out.println("Memproses KRS: " + m.nama);
      size--;
      totalServiced++;
    } else {
      System.out.println("Antrian kosong!");
    }
  }

  public void tampilkan2Terdepan() {
    if (size > 0) {
      int limit = Math.min(size, 2);
      for (int i = 0; i < limit; i++) {
        int index = (front + i) % max;
        data[index].tampilkanData();
      }
    } else {
      System.out.println("Antrian kosong.");
    }
  }

  public void tampilkanSemua() {
    if (isEmpty()) {
      System.out.println("Antrian kosong.");
    } else {
      System.out.println("Daftar Mahasiswa dalam Antrian:");
      System.out.println("NIM - NAMA - PRODI - KELAS");
      for (int i = 0; i < size; i++) {
        int index = (front + i) % max;
        System.out.print((i + 1) + ". ");
        data[index].tampilkanData();
      }
    }
  }

  public void lihatAkhir() {
    if (!isEmpty()) {
      System.out.print("Mahasiswa paling belakang: ");
      data[rear].tampilkanData();
    } else {
      System.out.println("Antrian kosong.");
    }
  }

  public void cetakStatistik() {
    System.out.println("Mahasiswa dalam antrian: " + size);
    System.out.println("Mahasiswa sudah KRS: " + totalServiced);
    // Maksimal ditangani DPA adalah 30
    System.out.println("Sisa kuota DPA: " + (30 - totalServiced));
  }
}
