public class AntrianLayanan {
  Mahasiswa[] data;
  int front;
  int rear;
  int size;
  int max;

  public AntrianLayanan(int n) {
    this.max = n;
    this.data = new Mahasiswa[max];
    this.size = 0;
    this.front = 0;
    this.rear = -1;
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

  public int getJumlahAntrian() {
    return size;
  }

  public void lihatTerdepan() {
    if (isEmpty()) {
      System.out.println("Queue Masih Kosong");
    } else {
      System.out.print("Mahasiswa terdepan: ");
      System.out.println("NIM - NAMA - PRODI - KELAS");
      data[front].tampilkanData();
    }
  }

  public void tampilkanSemua() {
    if (isEmpty()) {
      System.out.println("Antrian kosong.");
    } else {
      System.out.println("Daftar Mahasiswa dalam Antrian:");
      System.out.println("NIM - NAMA - PRODI - KELAS");
      for (int i = 0; i < size; i++) {
        int index = (front + 1) % max;
        System.out.print((i + 1) + ". ");
        data[index].tampilkanData();
      }
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

  public Mahasiswa layaniMahasiswa() {
    if (isEmpty()) {
      System.out.println("Queue masih kosong");
      return null;
    } else {
      Mahasiswa mhs = data[front];
      front = (front + 1) % max;
      size--;
      return mhs;
    }
  }
}
