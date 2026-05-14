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
