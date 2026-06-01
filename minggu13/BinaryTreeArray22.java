public class BinaryTreeArray22 {
    Mahasiswa22[] data;
    int idxLast;

    public BinaryTreeArray22() {
        data = new Mahasiswa22[100]; // Ukuran default
        idxLast = -1;
    }

    public void populateData(Mahasiswa22[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    public void add(Mahasiswa22 m) {
        if (idxLast + 1 < data.length) {
            idxLast++;
            data[idxLast] = m;
        } else {
            System.out.println("Tree array is full!");
        }
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            traverseInOrder(2 * idxStart + 1);
            System.out.println(data[idxStart].nama + " (" + data[idxStart].ipk + ")");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != null) {
            System.out.println(data[idxStart].nama + " (" + data[idxStart].ipk + ")");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}
