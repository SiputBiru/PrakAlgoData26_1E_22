class NilaiMahasiswa {

  // Divide and Conquer - nilai maksimum UTS
  int maxUTS(Mahasiswa[] arr, int l, int r) {
    if (l == r) {
      return arr[l].uts;
    }

    int mid = (l + r) >> 1;

    int left = maxUTS(arr, l, mid);
    int right = maxUTS(arr, mid + 1, r);

    return Math.max(left, right);
  }

  // Divide and Conquer - nilai minimum UTS
  int minUTS(Mahasiswa[] arr, int l, int r) {
    if (l == r) {
      return arr[l].uts;
    }

    int mid = (l + r) >> 1;

    int left = minUTS(arr, l, mid);
    int right = minUTS(arr, mid + 1, r);

    return Math.min(left, right);
  }

  // Brute Force - rata-rata UAS
  double rataUAS(Mahasiswa[] arr) {
    double total = 0;

    for (int i = 0; i < arr.length; i++) {
      total += arr[i].uas;
    }

    return total / arr.length;
  }
}
