public class MahasiswaBerprestasi22 {
  // kita ubah menjadi dinamis
  // Mahasiswa22 listMhs[] = new Mahasiswa22[5];

  Mahasiswa22 listMhs[];
  int idx;

  public MahasiswaBerprestasi22(int kapasitas) {
    listMhs = new Mahasiswa22[kapasitas];
    idx = 0;
  }

  void tambah(Mahasiswa22 m) {
    if (idx < listMhs.length) {
      listMhs[idx] = m;
      idx++;
    } else {
      System.out.println("data sudah penuh");
    }
  }

  void tampil() {
    for (Mahasiswa22 m : listMhs) {
      m.tampilInformasi();
      System.out.println("---------------------------------");
    }
  }

  void bubbleSort() {
    for (int i = 0; i < listMhs.length; i++) {
      for (int j = 1; j < listMhs.length - i; j++) {
        if (listMhs[j].ipk > listMhs[j - 1].ipk) {
          Mahasiswa22 tmp = listMhs[j];
          listMhs[j] = listMhs[j - 1];
          listMhs[j - 1] = tmp;
        }
      }
    }
  }

  // Mengurutkan Data Mahasiswa Berdasarkan IPK (Selection Sort
  void selectionSort() {
    for (int i = 0; i < listMhs.length - 1; i++) {
      int idxMin = i;
      for (int j = i + 1; j < listMhs.length; j++) {
        if (listMhs[j].ipk < listMhs[idxMin].ipk) {
          idxMin = j;
        }
      }
      Mahasiswa22 tmp = listMhs[idxMin];
      listMhs[idxMin] = listMhs[i];
      listMhs[i] = tmp;
    }
  }

  // Mengurutkan Data Mahasiswa Berdasarkan IPK Menggunakan Insertion Sort
  void InsertionSort() {
    for (int i = 1; i < listMhs.length; i++) {
      Mahasiswa22 temp = listMhs[i];
      int j = i;
      // while (j > 0 && listMhs[j - 1].ipk > temp.ipk) {
      while (j > 0 && listMhs[j - 1].ipk < temp.ipk) {
        listMhs[j] = listMhs[j - 1];
        j--;
      }
      listMhs[j] = temp;
    }
  }

}
