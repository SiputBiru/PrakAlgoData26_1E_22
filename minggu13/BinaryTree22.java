public class BinaryTree22 {
    Node22 root;

    public BinaryTree22() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa22 mahasiswa) {
        if (isEmpty()) {
            root = new Node22(null, mahasiswa, null);
        } else {
            Node22 current = root;
            while (true) {
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node22(null, mahasiswa, null);
                        break;
                    }
                } else if (mahasiswa.ipk > current.mahasiswa.ipk) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node22(null, mahasiswa, null);
                        break;
                    }
                } else { // ipk sama, abaikan atau timpa
                    break;
                }
            }
        }
    }

    public boolean find(double ipk) {
        Node22 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                return true;
            } else if (ipk < current.mahasiswa.ipk) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void traversePreOrder(Node22 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node22 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node22 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node22 getSuccessor(Node22 del) {
        Node22 successor = del.right;
        Node22 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) return;
        Node22 parent = root;
        Node22 current = root;
        boolean isLeftChild = false;
        while (current.mahasiswa.ipk != ipk) {
            parent = current;
            if (ipk < current.mahasiswa.ipk) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) return;
        }
        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.left = null;
            else parent.right = null;
        } else if (current.left == null) {
            if (current == root) root = current.right;
            else if (isLeftChild) parent.left = current.right;
            else parent.right = current.right;
        } else if (current.right == null) {
            if (current == root) root = current.left;
            else if (isLeftChild) parent.left = current.left;
            else parent.right = current.left;
        } else {
            Node22 successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.left = successor;
            else parent.right = successor;
            successor.left = current.left;
        }
    }

    public void addRekursif(Node22 current, Mahasiswa22 m) {
        if (isEmpty()) {
            root = new Node22(null, m, null);
        } else {
            if (m.ipk < current.mahasiswa.ipk) {
                if (current.left != null) {
                    addRekursif(current.left, m);
                } else {
                    current.left = new Node22(null, m, null);
                }
            } else if (m.ipk > current.mahasiswa.ipk) {
                if (current.right != null) {
                    addRekursif(current.right, m);
                } else {
                    current.right = new Node22(null, m, null);
                }
            }
        }
    }

    public void cariMinIPK() {
        if (isEmpty()) return;
        Node22 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.print("IPK Terkecil: ");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) return;
        Node22 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.print("IPK Terbesar: ");
        current.mahasiswa.tampilInformasi();
    }

    public void tampilMahasiswaIPKdiAtas(Node22 node, double ipkBatas) {
        if (node != null) {
            tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
        }
    }
}
