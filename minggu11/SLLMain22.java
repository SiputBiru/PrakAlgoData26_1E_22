public class SLLMain22 {
  public static void main(String[] args) {
    SingleLinkedList22 sll = new SingleLinkedList22();

    Mahasiswa22 mhs1 = new Mahasiswa22("24212200", "Alvaro", "1A", 4.0);
    Mahasiswa22 mhs2 = new Mahasiswa22("22212202", "Cintia", "3C", 3.5);
    Mahasiswa22 mhs3 = new Mahasiswa22("23212201", "Bimon", "2B", 3.8);
    Mahasiswa22 mhs4 = new Mahasiswa22("21212203", "Dirga", "4D", 3.6);

    sll.print(); // Menghasilkan "Linked list kosong"
    sll.addFirst(mhs4);
    sll.print();
    sll.addLast(mhs1);
    sll.print();
    sll.insertAfter("Dirga", mhs3);
    sll.insertAt(2, mhs2);
    sll.print();

    // Pengujian Percobaan 2
    System.out.println("Data index 1: ");
    sll.getData(1);

    System.out.println("Data mahasiswa Bimon berada pada index: " + sll.indexOf("Bimon"));
    System.out.println();

    sll.removeFirst();
    sll.removeLast();
    sll.print();

    sll.removeAt(0);
    sll.print();

  }
}
