import java.util.Scanner;

public class PeminjamanMain22 {

  static int pilihanMenu;
  static boolean isSorted = false;

  static Mahasiswa dataMhs[] = new Mahasiswa[3];
  static Buku22 dataBuku[] = new Buku22[4];
  static Peminjaman22 dataPeminjaman[] = new Peminjaman22[5];
  static Peminjaman22 dataPeminjamanSorted[] = new Peminjaman22[5];

  static Scanner sc = new Scanner(System.in);

  // Algoritma Merge Sort untuk pengurutan denda
  static void merge(Peminjaman22 arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    Peminjaman22 kiri[] = new Peminjaman22[n1];
    Peminjaman22 kanan[] = new Peminjaman22[n2];

    // Salin data ke array sementara
    for (int i = 0; i < n1; i++)
      kiri[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
      kanan[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;
    // Bandingkan elemen kiri dan kanan berdasarkan denda
    while (i < n1 && j < n2) {
      // Descending order berdasarkan denda
      if (kiri[i].denda >= kanan[j].denda) {
        arr[k] = kiri[i];
        i++;
      } else {
        arr[k] = kanan[j];
        j++;
      }
      k++;
    }

    // Salin sisa elemen jika ada
    while (i < n1)
      arr[k++] = kiri[i++];
    while (j < n2)
      arr[k++] = kanan[j++];
  }

  static void mergeSort(Peminjaman22 arr[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2; // Cari titik tengah
      mergeSort(arr, l, m); // Bagian kiri
      mergeSort(arr, m + 1, r); // Bagian kanan
      merge(arr, l, m, r); // Gabungkan kembali
    }
  }

  // Fungsi pencarian berdasarkan NIM (Sequential Search)
  static void cariBerdasarkanNim() {
    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
    String cari = sc.next();
    boolean ditemukan = false;

    System.out.println("\n--- Hasil Pencarian Peminjaman NIM: " + cari + " ---");
    for (Peminjaman22 p : dataPeminjaman) {
      // Membandingkan NIM di dalam objek Mahasiswa
      if (p.mhs.nim.equalsIgnoreCase(cari)) {
        p.tampilPeminjaman();
        ditemukan = true;
      }
    }

    if (!ditemukan) {
      System.out.println("Data peminjaman untuk NIM " + cari + " tidak ditemukan.");
    }
  }

  static void tampilMenuPemilihan() {
    System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
    System.out.println("1. Tampilkan Mahasiswa");
    System.out.println("2. Tampilkan Buku");
    System.out.println("3. Tampilkan Peminjaman");
    System.out.println("4. Urutkan Berdasarkan Denda (Desc)");
    System.out.println("5. Cari Peminjaman Berdasarkan NIM");
    System.out.println("0. Keluar");
    System.out.print("Pilih: ");
  }

  static void urutkanBerdasarkanDenda() {
    dataPeminjamanSorted = dataPeminjaman.clone(); // Clone agar data asli tidak teracak
    mergeSort(dataPeminjamanSorted, 0, dataPeminjamanSorted.length - 1);
    isSorted = true;
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
          if (!isSorted)
            urutkanBerdasarkanDenda();
          for (Peminjaman22 ps : dataPeminjamanSorted)
            ps.tampilPeminjaman();
          break;
        case 5:
          cariBerdasarkanNim();
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
