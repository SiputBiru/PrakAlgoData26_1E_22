import java.util.Scanner;

class KodePlatMobil {
  public static void main(String[] args) {
    char[] KODE = { 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T' };

    char[][] KOTA = {
        { 'B', 'A', 'N', 'T', 'E', 'N' },
        { 'J', 'A', 'K', 'A', 'R', 'T', 'A' },
        { 'B', 'A', 'N', 'D', 'U', 'N', 'G' },
        { 'C', 'I', 'R', 'E', 'B', 'O', 'N' },
        { 'B', 'O', 'G', 'O', 'R' },
        { 'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N' },
        { 'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G' },
        { 'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A' },
        { 'M', 'A', 'L', 'A', 'N', 'G' },
        { 'T', 'E', 'G', 'A', 'L' }
    };

    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan Kode Plat: ");
    char input = sc.next().toUpperCase().charAt(0);

    int hasilIndeks = binarySearch(KODE, input);

    if (hasilIndeks != -1) {
      System.out.print("Kota: ");
      for (char c : KOTA[hasilIndeks]) {
        System.out.print(c);
      }
      System.out.println();
    } else {
      System.out.println("Kode plat tidak ditemukan.");
    }
    sc.close();
  }

  // Fungsi Binary Search
  private static int binarySearch(char[] arr, char x) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      // Cek apakah x ada di tengah
      if (arr[mid] == x)
        return mid;

      // Jika x lebih besar, abaikan bagian kiri
      if (arr[mid] < x)
        left = mid + 1;

      // Jika x lebih kecil, abaikan bagian kanan
      else
        right = mid - 1;
    }
    return -1; // Tidak ditemukan
  }

}
