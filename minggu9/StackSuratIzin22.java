public class StackSuratIzin22 {
  int size, top;
  Surat22[] stack;

  public StackSuratIzin22(int size) {
    this.size = size;
    stack = new Surat22[size];
    top = -1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == size - 1;
  }

  public void push(Surat22 srt) {
    if (!isFull()) {
      top++;
      stack[top] = srt;
    } else {
      System.out.println("Stack Penuh! Tidak bisa menerima surat lagi.");
    }
  }

  public Surat22 pop() {
    if (!isEmpty()) {
      Surat22 srt = stack[top];
      top--;
      return srt;
    } else {
      System.out.println("Stack Kosong! Tidak ada surat untuk diproses.");
      return null;
    }
  }

  public Surat22 peek() {
    if (!isEmpty()) {
      return stack[top];
    } else {
      System.out.println("Tidak ada surat di dalam tumpukan.");
      return null;
    }
  }

  public void cariSurat(String nama) {
    boolean ditemukan = false;
    for (int i = top; i >= 0; i--) {
      if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
        System.out.println("Surat ditemukan pada posisi ke-" + (top - i + 1) + " dari atas.");
        System.out.println("ID Surat: " + stack[i].idSurat + " | Jenis: " + stack[i].jenisIzin);
        ditemukan = true;
      }
    }
    if (!ditemukan) {
      System.out.println("Surat atas nama " + nama + " tidak ditemukan.");
    }
  }
}
