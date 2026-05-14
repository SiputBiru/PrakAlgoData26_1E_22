public class QueueSLL22 {
  Node22 front, rear;
  int size;

  public boolean isEmpty() {
    return front == null;
  }

  public void enqueue(Mahasiswa22 data) {
    Node22 newNode = new Node22(data, null);
    if (isEmpty()) {
      front = rear = newNode;
    } else {
      rear.next = newNode;
      rear = newNode;
    }
    size++;
    System.out.println(data.nama + " berhasil masuk antrian.");
  }

  public void dequeue() {
    if (isEmpty()) {
      System.out.println("Antrian kosong!");
      return;
    }
    System.out.println("Memanggil antrian: " + front.data.nama);
    front = front.next;
    if (front == null) {
      rear = null;
    }
    size--;
  }

  public void peek() {
    if (!isEmpty()) {
      System.out.println("Antrian Terdepan: " + front.data.nama);
      System.out.println("Antrian Terakhir: " + rear.data.nama);
    } else {
      System.out.println("Antrian kosong.");
    }
  }

  public void displaySize() {
    System.out.println("Jumlah mahasiswa yang masih mengantre: " + size);
  }

  public void clear() {
    front = rear = null;
    size = 0;
    System.out.println("Antrian dikosongkan.");
  }
}
