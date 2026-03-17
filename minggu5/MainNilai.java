public class MainNilai {
  public static void main(String[] args) {

    // Dikarenakan tidak ada ketentuan apakah nilai harus di input menggunakan
    // Scanner untuk kepraktisan percobaan program data mahassiwa maka dibuat
    // harcoded seperti ini:
    Mahasiswa[] mhs = {
        new Mahasiswa("Ahmad", 220101001, 2022, 78, 82),
        new Mahasiswa("Budi", 220101002, 2022, 85, 88),
        new Mahasiswa("Cindy", 220101003, 2021, 90, 87),
        new Mahasiswa("Dian", 220101004, 2021, 76, 79),
        new Mahasiswa("Eko", 220101005, 2023, 92, 95),
        new Mahasiswa("Fajar", 220101006, 2020, 88, 85),
        new Mahasiswa("Gina", 220101007, 2023, 80, 83),
        new Mahasiswa("Hadi", 220101008, 2020, 82, 84)
    };

    NilaiMahasiswa nm = new NilaiMahasiswa();

    int max = nm.maxUTS(mhs, 0, mhs.length - 1);
    int min = nm.minUTS(mhs, 0, mhs.length - 1);
    double rata = nm.rataUAS(mhs);

    System.out.println("Nilai UTS tertinggi (DC): " + max);
    System.out.println("Nilai UTS terendah (DC): " + min);
    System.out.println("Rata-rata UAS (BF): " + rata);
  }
}
