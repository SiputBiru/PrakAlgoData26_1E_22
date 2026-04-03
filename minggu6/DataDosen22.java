public class DataDosen22 {
  Dosen22[] dataDosen22 = new Dosen22[10];
  int idx = 0;

  void tambah(Dosen22 dsn) {
    if (idx < dataDosen22.length) {
      dataDosen22[idx] = dsn;
      idx++;
    } else {
      System.out.println("Data dosen sudah penuh!");
    }
  }

  void tampil() {
    for (int i = 0; i < idx; i++) {
      dataDosen22[i].tampil();
      System.out.println("-----------------------------");
    }
  }

  // Bubble Sort ASC
  void sortingASC() {
    for (int i = 0; i < idx - 1; i++) {
      for (int j = 1; j < idx - i; j++) {
        if (dataDosen22[j].usia < dataDosen22[j - 1].usia) {
          Dosen22 tmp = dataDosen22[j];
          dataDosen22[j] = dataDosen22[j - 1];
          dataDosen22[j - 1] = tmp;
        }
      }
    }
  }

  // Selection Sort DSC
  void sortingDSC() {
    for (int i = 0; i < idx - 1; i++) {
      int idxMax = i;
      for (int j = i + 1; j < idx; j++) {
        if (dataDosen22[j].usia > dataDosen22[idxMax].usia) {
          idxMax = j;
        }
      }
      Dosen22 tmp = dataDosen22[idxMax];
      dataDosen22[idxMax] = dataDosen22[i];
      dataDosen22[i] = tmp;
    }
  }
}
