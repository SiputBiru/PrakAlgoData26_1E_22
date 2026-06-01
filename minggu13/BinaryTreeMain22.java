public class BinaryTreeMain22 {
    public static void main(String[] args) {
        BinaryTree22 bt = new BinaryTree22();
        
        // Tambah 4 mahasiswa pertama
        bt.add(new Mahasiswa22("244160185", "Candra", "C", 3.21));
        bt.add(new Mahasiswa22("244160220", "Dewi", "B", 3.54));
        bt.add(new Mahasiswa22("244160121", "Ali", "A", 3.57));
        bt.add(new Mahasiswa22("244160221", "Badar", "B", 3.85));

        // Tampilkan traversal InOrder dan lakukan pencarian
        System.out.println("Daftar semua mahasiswa (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\nPencarian data mahasiswa:");
        System.out.println("Cari mahasiswa dengan ipk: 3.54 : " + (bt.find(3.54) ? "Ditemukan" : "Tidak ditemukan"));
        System.out.println("Cari mahasiswa dengan ipk: 3.22 : " + (bt.find(3.22) ? "Ditemukan" : "Tidak ditemukan"));

        // Tambah 3 mahasiswa berikutnya
        bt.add(new Mahasiswa22("244160205", "Ehsan", "D", 3.37));
        bt.add(new Mahasiswa22("244160170", "Fizi", "B", 3.46));
        bt.add(new Mahasiswa22("244160131", "Devi", "A", 3.72));

        // Tampilkan traversal dengan header yang sesuai
        System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
        System.out.println("InOrder Traversal:");
        bt.traverseInOrder(bt.root);
        System.out.println("\nPreOrder Traversal:");
        bt.traversePreOrder(bt.root);
        System.out.println("\nPostOrder Traversal:");
        bt.traversePostOrder(bt.root);

        // Hapus Ali (IPK 3.57) dan tampilkan traversal InOrder akhir
        System.out.println("\nPenghapusan data mahasiswa");
        bt.delete(3.57); // Ali

        System.out.println("\nDaftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\nPenambahan 1 mahasiswa menggunakan addRekursif (Gani, IPK 3.65):");
        bt.addRekursif(bt.root, new Mahasiswa22("244160230", "Gani", "A", 3.65));

        System.out.println("\nDaftar semua mahasiswa setelah penambahan dengan addRekursif (in order traversal):");
        bt.traverseInOrder(bt.root);

        System.out.println("\n--- Uji Coba Tugas ---");
        bt.cariMinIPK();
        bt.cariMaxIPK();
        System.out.println("\nMahasiswa dengan IPK > 3.50:");
        bt.tampilMahasiswaIPKdiAtas(bt.root, 3.50);
    }
}
