import java.util.Scanner;

class NilaiAkhirMahasiswa {
  static String nilaiHurufSetara[] = {
      "A",
      "B+",
      "B",
      "C+",
      "C",
      "D",
      "E"
  };

  static Float nilaiSetara[] = {
      4.0f,
      3.5f,
      3.0f,
      2.5f,
      2.0f,
      1.0f,
      0.0f,
  };

  static String nilaiAkhir[] = {
      "Tugas",
      "Kuis",
      "UTS",
      "UAS"
  };

  public static void main(String[] args) {
    System.out.println("Program Menghitung Nilai Akhir");
    System.out.println("==============================");

    Scanner sc = new Scanner(System.in);
    double[] nilaiKotor = new double[4];
    double avg = 0;
    String nilaiHuruf = " ";
    Boolean isValid = true;

    for (int i = 0; i < nilaiAkhir.length; i++) {
      System.out.printf("Masukkan Nilai %-6s : ", nilaiAkhir[i]);
      nilaiKotor[i] = sc.nextDouble();
      if (nilaiKotor[i] > 100 || nilaiKotor[i] < 0) {
        isValid = false;
      }
      switch (nilaiAkhir[i]) {
        case "Tugas":
          avg += (0.2 * nilaiKotor[i]);
          break;
        case "Kuis":
          avg += (0.2 * nilaiKotor[i]);
          break;
        case "UTS":
          avg += (0.3 * nilaiKotor[i]);
          break;
        case "UAS":
          avg += (0.4 * nilaiKotor[i]);
      }
    }
    sc.close();

    if (!isValid || avg == 0) {
      System.out.println("nilai tidak valid!");
      System.out.println("============================");
      System.out.println("============================");
      return;
    }

    if (avg > 80 && avg <= 100) {
      nilaiHuruf = "A";
    } else if (avg > 73 && avg <= 80) {
      nilaiHuruf = "B+";
    } else if (avg > 65 && avg <= 73) {
      nilaiHuruf = "B";
    } else if (avg > 60 && avg <= 65) {
      nilaiHuruf = "C+";
    } else if (avg > 50 && avg <= 60) {
      nilaiHuruf = "C";
    } else if (avg > 39 && avg <= 50) {
      nilaiHuruf = "D";
    } else if (avg <= 39) {
      nilaiHuruf = "E";
    }
    System.out.println("============================");
    System.out.println("============================");
    System.out.printf("Nilai Akhir: %.1f", avg);
    System.out.printf("\nNilai Huruf: %s\n", nilaiHuruf);
    System.out.println("============================");
    System.out.println("============================");
    if (nilaiHuruf.equals("D") || nilaiHuruf.equals("E")) {
      System.out.println("Maaf Anda tidak Lulus!");
      System.out.println("Jangan Putus Asa dan Tetap Semangat!");
    } else {
      System.out.println("Selamat Anda Lulus!");
    }

  }
}
