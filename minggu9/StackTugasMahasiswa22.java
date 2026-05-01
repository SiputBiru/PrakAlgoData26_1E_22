class StackTugasMahasiswa22 {
  int size, top;
  Mahasiswa22[] stack;

  StackTugasMahasiswa22(int size) {
    this.size = size;
    stack = new Mahasiswa22[this.size];
    top = -1;
  }

  boolean isFull() {
    if (top == size - 1) {
      return true;
    } else {
      return false;
    }
  }

  boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  void push(Mahasiswa22 mhs) {
    if (this.isFull()) {
      System.out.println("\u001B[31mStack penuh! Tidak bisa menambahkan tugas lagi.\u001B[0m");
      return;
    }
    top++;
    this.stack[top] = mhs;
  }

  Mahasiswa22 pop() {
    if (isEmpty()) {
      System.out.println("\u001B[31mStack kosong! Tidak ada tugas untuk dinilai.\u001B[0m");
      return null;
    }
    Mahasiswa22 val = this.stack[top];
    top--;
    return val;
  }

  Mahasiswa22 peek() {
    if (this.isEmpty()) {
      System.out.println("\u001B[31mStack kosong! Tidak ada tugas untuk dinilai.\u001B[0m");
      return null;
    }
    return this.stack[top];
  }

  void print() {
    for (int i = top; i >= 0; i--) {
      System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
  }

  void printDrBawah() {
    for (int i = 0; i <= top; i++) {
      System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
    }
    System.out.println("");
  }

  Mahasiswa22 peekBottom() {
    if (this.isEmpty()) {
      System.out.println("\u001B[31mStack kosong! Tidak ada tugas.\u001B[0m");
      return null;
    }
    // Elemen pertama yang masuk berada di indeks 0
    return this.stack[0];
  }

  int count() {
    return top + 1;
  }

  String konversiDesimalKeBiner(int nilai) {
    StackKonversi stack = new StackKonversi();
    while (nilai > 0) {
      int sisa = nilai % 2;
      stack.push(sisa);
      nilai = nilai / 2;
    }
    String biner = new String();

    while (!stack.isEmpty()) {
      biner += stack.pop();
    }
    return biner;
  }

}
