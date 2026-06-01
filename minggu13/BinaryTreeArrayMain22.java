public class BinaryTreeArrayMain22 {
    public static void main(String[] args) {
        BinaryTreeArray22 bta = new BinaryTreeArray22();
        
        System.out.println("--- Populate Data ---");
        Mahasiswa22[] mhs = new Mahasiswa22[10];
        mhs[0] = new Mahasiswa22("22001", "Ani", "1E", 3.8);
        mhs[1] = new Mahasiswa22("22002", "Budi", "1E", 3.5);
        mhs[2] = new Mahasiswa22("22003", "Cici", "1E", 3.9);
        
        bta.populateData(mhs, 2);
        
        System.out.println("InOrder Traversal:");
        bta.traverseInOrder(0);
        
        System.out.println("\n--- Add New Student ---");
        bta.add(new Mahasiswa22("22004", "Dodi", "1E", 3.2)); // Indeks 3, anak dari Budi
        
        System.out.println("PreOrder Traversal:");
        bta.traversePreOrder(0);
    }
}
