public class Sorting22 {
  int[] data;
  int jumData;

  Sorting22(int Data[], int jmlDat) {
    jumData = jmlDat;
    data = new int[jmlDat];
    for (int i = 0; i < jumData; i++) {
      data[i] = Data[i];
    }
  }

  void tampil() {
    for (int i = 0; i < jumData; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }

  void bubbleSort() {
    for (int i = 0; i < jumData - 1; i++) {
      for (int j = 1; j < jumData - i - 1; j++) {
        if (data[j - 1] > data[j]) {
          // int temp = data[j];
          // data[j] = data[j - 1];
          // data[j - 1] = temp;

          data[j] ^= data[j - 1];
          data[j - 1] ^= data[j];
          data[j] ^= data[j - 1];

        }
      }
    }
  }

  void SelectionSort() {
    for (int i = 0; i < jumData; i++) {
      int min = i;
      for (int j = i + 1; j < jumData; j++) {
        if (data[j] < data[min]) {
          min = j;
        }
      }
      int temp = data[i];
      data[i] = data[min];
      data[min] = temp;
    }
  }

  void InsertionSort() {
    for (int i = 0; i < jumData; i++) {
      int temp = data[i];
      int j = i - 1;
      while (j >= 0 && data[j] > temp) {
        data[j + 1] = data[j];
        j--;
      }
      data[j + 1] = temp;
    }
  }
}
