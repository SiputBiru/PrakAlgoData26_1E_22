public class DLLAntrian22 {
  NodeAntrian22 head, tail;
  int size;
  int counter = 1;

  public boolean isEmpty() {
    return head == null;
  }

  public void enqueue(Pembeli22 pembeli) {
    if (isEmpty()) {
      head = tail = new NodeAntrian22(null, counter++, pembeli, null);
    } else {
      NodeAntrian22 newNode = new NodeAntrian22(tail, counter++, pembeli, null);
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public NodeAntrian22 dequeue() {
    if (isEmpty()) {
      return null;
    }
    NodeAntrian22 temp = head;
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
      head.prev = null;
    }
    size--;
    return temp;
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Antrian kosong.");
      return;
    }
    System.out.println("+++++++++++++++++++++++++++++");
    System.out.println("Daftar Antrian Pembeli");
    System.out.println("+++++++++++++++++++++++++++++");
    System.out.printf("%-12s | %-15s | %-15s\n", "No Antrian", "Nama", "No HP");
    NodeAntrian22 current = head;
    while (current != null) {
      System.out.printf("%-12d | %-15s | %-15s\n", current.noAntrian, current.pembeli.namaPembeli,
          current.pembeli.noHp);
      current = current.next;
    }
  }
}
