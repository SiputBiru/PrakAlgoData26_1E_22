public class NodeAntrian22 {
  int noAntrian;
  Pembeli22 pembeli;
  NodeAntrian22 prev, next;

  public NodeAntrian22(NodeAntrian22 prev, int noAntrian, Pembeli22 pembeli, NodeAntrian22 next) {
    this.prev = prev;
    this.noAntrian = noAntrian;
    this.pembeli = pembeli;
    this.next = next;
  }
}
