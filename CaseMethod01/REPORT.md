# Case Method 1: Sistem Peminjaman Ruang Baca

## 1. Deskripsi Program

Program ini adalah sistem manajemen peminjaman buku sederhana yang mengelola data Mahasiswa, Buku, dan Peminjaman. Fitur utama mencakup pengolahan denda otomatis, pengurutan data berdasarkan denda terbesar, dan pencarian catatan peminjaman berdasarkan NIM mahasiswa.

## 2. Struktur Data (Object Oriented)

Program menggunakan tiga kelas utama:

- `Mahasiswa`: Menyimpan data profil mahasiswa (NIM, Nama, Jurusan).

- `Buku22`: Menyimpan informasi buku (Kode, Judul, Tahun Terbit).

- `Peminjaman22`: Menghubungkan Mahasiswa dan Buku, serta menghitung denda jika lama pinjam melebihi 5 hari.

## 3. Algoritma yang Digunakan

### A. Pengurutan (Merge Sort)

Digunakan untuk mengurutkan daftar peminjaman berdasarkan Denda secara Descending (dari yang terbesar ke terkecil).

- Divide: Membagi array peminjaman menjadi dua bagian secara rekursif hingga menjadi elemen tunggal.
  
- Conquer & Combine: Membandingkan nilai denda dari dua bagian tersebut dan menggabungkannya kembali ke dalam array utama dalam keadaan terurut.

lengkapnya bisa dilihat dari [geeksforgeeks.org](https://www.geeksforgeeks.org/dsa/merge-sort/)

### B. Pencarian (Binary Search)

Digunakan untuk fitur Cari Berdasarkan NIM. Algoritma ini jauh lebih cepat dibandingkan pencarian berurutan pada data yang besar.

- Prasyarat: Data harus dalam keadaan terurut berdasarkan NIM terlebih dahulu menggunakan Merge Sort.

- Cara Kerja: Program memeriksa elemen tengah (mid) dari array. Jika NIM tidak cocok, program akan membuang setengah bagian data yang tidak mungkin mengandung NIM tersebut dan melanjutkan pencarian pada setengah bagian sisanya.

## 4. Tampilan Menu

- Tampilkan Mahasiswa: Menampilkan daftar master mahasiswa.

- Tampilkan Buku: Menampilkan daftar koleksi buku.

- Tampilkan Peminjaman: Menampilkan riwayat peminjaman sesuai urutan input (asli).

- Urutkan Berdasarkan Denda: Menjalankan Merge Sort dan menampilkan hasil pengurutan denda terbesar.

- Cari Berdasarkan NIM: Mencari semua transaksi peminjaman milik mahasiswa tertentu.
