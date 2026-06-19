import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContohList22 {
  public static void main(String[] args) {
    // Pertanyaan 2: Mengubah menjadi tipe spesifik Integer
    List<Integer> l = new ArrayList<>();

    l.add(1);
    l.add(2);
    l.add(3);
    l.add(99); // Diubah dari "Cireng" menjadi angka
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));
    
    l.add(4);
    l.remove(0);
    System.out.printf("Element 0: %d total elemen: %d elemen terakhir: %d\n", l.get(0), l.size(), l.get(l.size() - 1));

    LinkedList<String> names = new LinkedList<>();
    names.add("Noureen");
    names.add("Akhleema");
    names.add("Shannum");
    names.add("Uwais");
    names.add("Al-Qarni");
    
    System.out.printf("Element 0: %s total elemen: %d elemen terakhir: %s\n", names.get(0), names.size(), names.get(names.size() - 1));
    
    names.push("Mei-mei");
    System.out.printf("Elemen 0: %s total elemen: %d elemen terakhir: %s\n", names.getFirst(), names.size(), names.getLast());
    System.out.println("Names: " + names.toString());
  }
}
