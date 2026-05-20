public class DLLPesanan22 {
  NodePesanan22 head, tail;
  int size;

  public boolean isEmpty() {
    return head == null;
  }

  public void addLast(Pesanan22 pesanan) {
    if (isEmpty()) {
      head = tail = new NodePesanan22(null, pesanan, null);
    } else {
      NodePesanan22 newNode = new NodePesanan22(tail, pesanan, null);
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public void sortByName() {
    if (size < 2)
      return;
    boolean swapped;
    do {
      swapped = false;
      NodePesanan22 current = head;
      while (current != null && current.next != null) {
        if (current.pesanan.namaPesanan.compareToIgnoreCase(current.next.pesanan.namaPesanan) > 0) {
          Pesanan22 temp = current.pesanan;
          current.pesanan = current.next.pesanan;
          current.next.pesanan = temp;
          swapped = true;
        }
        current = current.next;
      }
    } while (swapped);
  }

  public int hitungTotalPendapatan() {
    int total = 0;
    NodePesanan22 current = head;
    while (current != null) {
      total += current.pesanan.harga;
      current = current.next;
    }
    return total;
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Belum ada pesanan.");
      return;
    }
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.printf("%-15s | %-20s | %-10s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
    NodePesanan22 current = head;
    while (current != null) {
      System.out.printf("%-15d | %-20s | %-10d\n", current.pesanan.kodePesanan, current.pesanan.namaPesanan,
          current.pesanan.harga);
      current = current.next;
    }
    System.out.println("TOTAL PENDAPATAN: " + hitungTotalPendapatan());
  }
}
