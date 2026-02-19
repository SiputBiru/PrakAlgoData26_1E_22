
class RoyalGarden {

  static int stokBunga[][] = {
      { 10, 5, 15, 7 },
      { 6, 11, 9, 12 },
      { 2, 10, 10, 5 },
      { 5, 7, 12, 9 },
  };

  static int rincianHarga[] = {
      75_000,
      50_000,
      60_000,
      10_000
  };

  static String[] jenisBunga = {
      "Aglonema",
      "Keladi",
      "Alocasta",
      "Mawar",
  };

  public static void main(String[] args) {
    tampilkanTabelStok();
    hitungPendapatan(stokBunga);
    tampilkanPendapatan();

  }

  static double[] pendapatanPerBunga = new double[jenisBunga.length];
  static double[] pendapatanPerCabang = new double[stokBunga[0].length];

  static void hitungPendapatan(int[][] arr) {
    // hitung pendapatan Per Cabang
    for (int j = 0; j < arr[0].length; j++) {
      double totalCabang = 0;
      for (int i = 0; i < arr.length; i++) {
        totalCabang += (rincianHarga[j] * arr[i][j]);
      }
      pendapatanPerCabang[j] = totalCabang;
    }

    // hitung pendapatan Per Bunga
    for (int i = 0; i < arr.length; i++) {
      double totalBunga = 0;
      for (int j = 0; j < arr[i].length; j++) {
        totalBunga += (rincianHarga[j] * arr[i][j]);
      }
      pendapatanPerBunga[i] = totalBunga;
    }

  }

  static void tampilkanPendapatan() {
    System.out.println("\nLAPORAN PENDAPATAN PER CABANG:");
    System.out.println("======================================================");
    System.out.printf("| %-15s | %-14s | %-15s |\n", "Cabang", "Pendapatan", "Status");
    System.out.println("======================================================");

    for (int i = 0; i < pendapatanPerCabang.length; i++) {
      String status = (pendapatanPerCabang[i] > 1_500_000) ? "Sangat Baik" : "Perlu Evaluasi";

      System.out.printf("| RoyalGarden %-3d | Rp%,12.0f | %-15s |\n",
          i, pendapatanPerCabang[i], status);
    }
    System.out.println("======================================================");
  }

  static void tampilkanTabelStok() {
    System.out.println("DATA STOK BUNGA:");
    System.out.println("\n" + "=".repeat(71));
    System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-10s |\n",
        "", jenisBunga[0], jenisBunga[1], jenisBunga[2], jenisBunga[3]);
    System.out.println("-".repeat(71));

    for (int i = 0; i < stokBunga.length; i++) {
      System.out.printf("| %-15s |", "RoyalGarden " + (i + 1)); // i + 1 agar mulai dari 1
      for (int j = 0; j < stokBunga[i].length; j++) {
        System.out.printf(" %-10d |", stokBunga[i][j]);
      }
      System.out.println();
    }
    System.out.println("=".repeat(71));
  }

}
