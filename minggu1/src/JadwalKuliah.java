import java.util.Scanner;

public class JadwalKuliah {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Masukkan jumlah jadwal kuliah (n): ");
    int n = sc.nextInt();
    sc.nextLine();

    String[][] jadwal = new String[n][4];

    inputData(jadwal);
    tampilkanSeluruh(jadwal);

    System.out.print("\nCari jadwal berdasarkan hari: ");
    String cariHari = sc.nextLine();
    tampilkanBerdasarkanHari(jadwal, cariHari);

    System.out.print("\nCari jadwal berdasarkan nama mata kuliah: ");
    String cariMK = sc.nextLine();
    tampilkanBerdasarkanMK(jadwal, cariMK);
  }

  static void inputData(String[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println("\nInput Jadwal ke-" + (i + 1));
      System.out.print("Nama Mata Kuliah: ");
      arr[i][0] = sc.nextLine();
      System.out.print("Ruang           : ");
      arr[i][1] = sc.nextLine();
      System.out.print("Hari            : ");
      arr[i][2] = sc.nextLine();
      System.out.print("Jam             : ");
      arr[i][3] = sc.nextLine();
    }
  }

  static void tampilkanSeluruh(String[][] arr) {
    System.out.println("\n====================================================================");
    System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", "Mata Kuliah", "Ruang", "Hari", "Jam");
    System.out.println("====================================================================");
    for (String[] baris : arr) {
      System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", baris[0], baris[1], baris[2], baris[3]);
    }
  }

  static void tampilkanBerdasarkanHari(String[][] arr, String hari) {
    System.out.println("\nJadwal pada hari " + hari + ":");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][2].equalsIgnoreCase(hari)) {
        System.out.printf("- %s (%s) Jam: %s\n", arr[i][0], arr[i][1], arr[i][3]);
      }
    }
  }

  static void tampilkanBerdasarkanMK(String[][] arr, String mk) {
    System.out.println("\nDetail Mata Kuliah " + mk + ":");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][0].equalsIgnoreCase(mk)) {
        System.out.println("Ruang: " + arr[i][1] + " | Hari: " + arr[i][2] + " | Jam: " + arr[i][3]);
      }
    }
  }
}
