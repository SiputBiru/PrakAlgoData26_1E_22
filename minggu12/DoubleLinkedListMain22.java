public class DoubleLinkedListMain22 {
  public static void main(String[] args) {
    DoubleLinkedList22 dll = new DoubleLinkedList22();

    Mahasiswa22 mhs1 = new Mahasiswa22("123001", "Harry", "1A", 3.76);
    Mahasiswa22 mhs2 = new Mahasiswa22("123002", "Ron", "1A", 3.5);
    Mahasiswa22 mhs3 = new Mahasiswa22("123003", "Hermione", "1A", 4.0);
    Mahasiswa22 mhs4 = new Mahasiswa22("123004", "Neville", "1B", 3.2);

    System.out.println("======= UJI COBA PENAMBAHAN =======");
    dll.addFirst(mhs2);
    dll.addFirst(mhs3);
    dll.addLast(mhs1);

    System.out.println("Isi Linked List:");
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("Sisipkan Neville setelah NIM 123002 (Ron):");
    dll.insertAfter("123002", mhs4);
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= UJI COBA PENGHAPUSAN =======");
    dll.removeFirst();
    System.out.println("Setelah removeFirst:");
    dll.print();

    System.out.println("\nSetelah removeLast:");
    dll.removeLast();
    dll.print();
    System.out.println("-----------------------------------");

    System.out.println("\n======= CETAK TERBALIK (REVERSE) =======");
    dll.printReverse();

    System.out.println("\nSelesai.");
  }
}
