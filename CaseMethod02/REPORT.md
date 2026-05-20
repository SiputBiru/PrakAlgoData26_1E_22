# Case Method 2: Sistem Antrian Resto Royal Delish

## Deskripsi Program

Program ini adalah sistem manajemen antrian dan pesanan makanan untuk Resto Royal Delish. Sistem ini dirancang untuk mengatasi masalah pencatatan antrian manual yang sering menyebabkan nomor antrian tertukar dan data tidak tercatat dengan rapi. Fitur utama mencakup penambahan antrian otomatis, pemanggilan pelanggan (dequeue), pencatatan pesanan, dan laporan pendapatan yang terurut secara alfabetis berdasarkan nama pesanan.

## Struktur Data (Object Oriented)

Program menggunakan beberapa kelas utama yang saling berhubungan menggunakan konsep **Double Linked List** untuk efisiensi manipulasi data di kedua ujung:

- `Pembeli22`: Model data untuk menyimpan informasi pelanggan (Nama, No HP).
- `Pesanan22`: Model data untuk menyimpan informasi pesanan (Kode, Nama Menu, Harga).
- `NodeAntrian22` & `NodePesanan22`: Kelas node yang menyimpan referensi ke objek data serta pointer `next` dan `prev`.
- `DLLAntrian22`: Implementasi Double Linked List untuk mengelola antrian pelanggan (FIFO).
- `DLLPesanan22`: Implementasi Double Linked List untuk mengelola riwayat pesanan yang sudah diproses.

## Algoritma yang Digunakan

### Manajemen Antrian (Queue with DLL)

Sistem menggunakan prinsip *First-In-First-Out* (FIFO). Pelanggan baru ditambahkan di bagian belakang (`addLast`/`enqueue`), dan pemanggilan pelanggan dilakukan dari bagian depan (`removeFirst`/`dequeue`). Penggunaan Double Linked List memungkinkan operasi ini dilakukan dengan kompleksitas waktu O(1).

### Pengurutan Manual (Bubble Sort)

Sesuai dengan batasan tugas, pengurutan laporan pesanan dilakukan secara manual menggunakan algoritma **Bubble Sort** di dalam kelas `DLLPesanan22`.

- Algoritma membandingkan `namaPesanan` dari node yang berdekatan.
- Jika urutan tidak sesuai (secara alfabetis), data pesanan di dalam node akan ditukar.
- Proses diulang hingga seluruh list terurut (tidak ada lagi pertukaran yang terjadi).

### Akumulasi Pendapatan

Program melakukan iterasi melalui seluruh node dalam `DLLPesanan22` untuk menjumlahkan atribut `harga` dari setiap objek `Pesanan22` guna mendapatkan total pendapatan restoran.

## Tampilan Menu

- **Tambah Antrian**: Menginput data pembeli baru dan memberikan nomor antrian secara otomatis.
- **Cetak Antrian**: Menampilkan daftar seluruh pelanggan yang masih menunggu dalam antrian.
- **Hapus Antrian dan Pesan**: Memanggil pelanggan terdepan untuk melakukan pemesanan, menghapusnya dari antrian, dan menyimpan data pesanannya.
- **Laporan Pesanan**: Menampilkan seluruh riwayat pesanan yang sudah diurutkan berdasarkan nama menu serta menampilkan total pendapatan.
- **Keluar**: Mengakhiri sesi program.
