import java.util.Scanner;

public class PeminjamanMain22 {

  static int pilihanMenu;
  static boolean isDendaSorted = false;
  static boolean isNimSorted = false;

  static Mahasiswa dataMhs[] = new Mahasiswa[3];
  static Buku22 dataBuku[] = new Buku22[4];
  static Peminjaman22 dataPeminjaman[] = new Peminjaman22[5];
  static Peminjaman22 dataPeminjamanSortedByDenda[] = new Peminjaman22[5];
  static Peminjaman22 dataPeminjamanSortedByNim[] = new Peminjaman22[5];

  static Scanner sc = new Scanner(System.in);

  // Merge Sort untuk Denda (Descending)
  static void merge(Peminjaman22 arr[], int l, int m, int r) {
    // Hitung ukuran potongan kiri dan kanan
    int n1 = m - l + 1;
    int n2 = r - m;

    // subarray untuk menampung objek sementara
    Peminjaman22 kiri[] = new Peminjaman22[n1];
    Peminjaman22 kanan[] = new Peminjaman22[n2];

    // Salin data dari array asli ke subarray sementara
    for (int i = 0; i < n1; i++)
      kiri[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
      kanan[j] = arr[m + 1 + j];

    // membandingkan isi wadah kiri vs kanan
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      // Jika denda di kiri lebih besar, masukkan ke array asli (Descending)
      if (kiri[i].denda >= kanan[j].denda) {
        arr[k] = kiri[i];
        i++;
      } else {
        arr[k] = kanan[j];
        j++;
      }
      k++;
    }

    // Memasukkan sisa data yang belum terangkut
    while (i < n1)
      arr[k++] = kiri[i++];
    while (j < n2)
      arr[k++] = kanan[j++];
  }

  static void mergeSort(Peminjaman22 arr[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);
      merge(arr, l, m, r);
    }
  }

  // Merge Sort untuk NIM (Ascending)
  static void mergeByNim(Peminjaman22 arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    Peminjaman22 kiri[] = new Peminjaman22[n1];
    Peminjaman22 kanan[] = new Peminjaman22[n2];

    for (int i = 0; i < n1; i++)
      kiri[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
      kanan[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      // Urutan Ascending untuk Binary Search
      if (kiri[i].mhs.nim.compareTo(kanan[j].mhs.nim) <= 0) {
        arr[k] = kiri[i];
        i++;
      } else {
        arr[k] = kanan[j];
        j++;
      }
      k++;
    }
    while (i < n1)
      arr[k++] = kiri[i++];
    while (j < n2)
      arr[k++] = kanan[j++];
  }

  static void mergeSortByNim(Peminjaman22 arr[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;
      mergeSortByNim(arr, l, m);
      mergeSortByNim(arr, m + 1, r);
      mergeByNim(arr, l, m, r);
    }
  }

  // Binary Search berdasarkan NIM
  static int binarySearchNim(Peminjaman22 arr[], int l, int r, String x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;

      if (arr[mid].mhs.nim.equalsIgnoreCase(x)) {
        return mid;
      }

      // Jika NIM tengah lebih besar, cari di kiri
      if (arr[mid].mhs.nim.compareTo(x) > 0) {
        return binarySearchNim(arr, l, mid - 1, x);
      }

      // Jika NIM tengah lebih kecil, cari di kanan
      return binarySearchNim(arr, mid + 1, r, x);
    }
    return -1; // Tidak ditemukan
  }

  static void tampilMenuPemilihan() {
    System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
    System.out.println("1. Tampilkan Mahasiswa");
    System.out.println("2. Tampilkan Buku");
    System.out.println("3. Tampilkan Peminjaman");
    System.out.println("4. Urutkan Berdasarkan Denda");
    System.out.println("5. Cari Peminjaman Berdasarkan NIM");
    System.out.println("0. Keluar");
    System.out.print("Pilih: ");
  }

  static void tampilMenuUrutanDenda() {
    if (!isDendaSorted) {
      dataPeminjamanSortedByDenda = dataPeminjaman.clone();
      mergeSort(dataPeminjamanSortedByDenda, 0, dataPeminjamanSortedByDenda.length - 1);
      isDendaSorted = true;
    }
    System.out.println();
    for (Peminjaman22 ps : dataPeminjamanSortedByDenda)
      ps.tampilPeminjaman();
  }

  static void tampilMenuCariNIM() {
    // Syarat Binary Search: Harus urut berdasarkan NIM
    if (!isNimSorted) {
      dataPeminjamanSortedByNim = dataPeminjaman.clone();
      mergeSortByNim(dataPeminjamanSortedByNim, 0, dataPeminjamanSortedByNim.length - 1);
      isNimSorted = true;
    }

    System.out.print("Masukkan NIM yang dicari: ");
    String cari = sc.next();

    int hasil = binarySearchNim(dataPeminjamanSortedByNim, 0, dataPeminjamanSortedByNim.length - 1, cari);

    if (hasil != -1) {
      System.out.println("\n--- Data Ditemukan ---");
      dataPeminjamanSortedByNim[hasil].tampilPeminjaman();
    } else {
      System.out.println("Data peminjaman untuk NIM " + cari + " tidak ditemukan.");
    }
  }

  public static void main(String[] args) {
    // Inisialisasi Data
    dataMhs[0] = new Mahasiswa("22001", "Andi", "Teknik Informatika");
    dataMhs[1] = new Mahasiswa("22002", "Budi", "Teknik Informatika");
    dataMhs[2] = new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis");

    dataBuku[0] = new Buku22("B001", "Algoritma", "2020");
    dataBuku[1] = new Buku22("B002", "Basis Data", "2019");
    dataBuku[2] = new Buku22("B003", "Pemrograman", "2021");
    dataBuku[3] = new Buku22("B004", "Fisika", "2024");

    dataPeminjaman[0] = new Peminjaman22(dataMhs[0], dataBuku[0], 7);
    dataPeminjaman[1] = new Peminjaman22(dataMhs[1], dataBuku[1], 3);
    dataPeminjaman[2] = new Peminjaman22(dataMhs[2], dataBuku[2], 10);
    dataPeminjaman[3] = new Peminjaman22(dataMhs[2], dataBuku[3], 6);
    dataPeminjaman[4] = new Peminjaman22(dataMhs[0], dataBuku[0], 4);

    boolean on = true;
    while (on) {
      tampilMenuPemilihan();
      pilihanMenu = sc.nextInt();
      switch (pilihanMenu) {
        case 1:
          for (Mahasiswa m : dataMhs)
            m.tampilMahasiswa();
          break;
        case 2:
          for (Buku22 b : dataBuku)
            System.out.println(b.judul);
          break;
        case 3:
          for (Peminjaman22 p : dataPeminjaman)
            p.tampilPeminjaman();
          break;
        case 4:

          tampilMenuUrutanDenda();
          break;
        case 5:
          tampilMenuCariNIM();
          break;
        case 0:
          on = false;
          break;
        default:
          System.out.println("Pilihan salah!");
      }
    }
    sc.close();
  }
}
