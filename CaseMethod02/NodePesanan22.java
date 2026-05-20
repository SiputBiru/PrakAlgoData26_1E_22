public class NodePesanan22 {
  Pesanan22 pesanan;
  NodePesanan22 prev, next;

  public NodePesanan22(NodePesanan22 prev, Pesanan22 pesanan, NodePesanan22 next) {
    this.prev = prev;
    this.pesanan = pesanan;
    this.next = next;
  }
}
