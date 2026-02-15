import java.util.Scanner;

class HitungIPSem {

  static Float nilaiSetara[] = {
      4.0f,
      3.5f,
      3.0f,
      2.5f,
      2.0f,
      1.0f,
      0.0f,
  };

  static String listmataKuliah[] = {
      "Pancasila",
      "Konsep Teknologi Informasi",
      "Critical Thinking dan Problem Solving",
      "Matematika Dasar",
      "Bahasa Inggris",
      "Dasar Pemrograman",
      "Praktikum Dasar Pemrograman",
      "Keselamatan dan Kesehatan Kerja"
  };

  static Float nilaiAngka[] = new Float[listmataKuliah.length];
  static String nilaiHuruf[] = new String[listmataKuliah.length];
  static Float bobotNilai[] = new Float[listmataKuliah.length];
  static Float ip = 0.0f;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Float totBobot = 0.0f;

    System.out.println("=================================================");
    System.out.println("Program Menghitung IP Semester");
    System.out.println("=================================================");

    for (int i = 0; i < listmataKuliah.length; i++) {
      System.out.printf("Masukkan nilai Angka untuk MK %s: ", listmataKuliah[i]);

      // Error Handling
      // input harus berupa angka
      if (!sc.hasNextFloat()) {
        System.out.println("Input harus berupa Float/desimal/angka!");
        sc.nextLine();
        i--;
        continue;
      }

      nilaiAngka[i] = sc.nextFloat();

      // Input harus diantara 0 sampai 100
      if (nilaiAngka[i] < 0 || nilaiAngka[i] > 100) {
        System.out.println("Nilai harus di antara 0 - 100!");
        i--;
        continue;
      }

      if (nilaiAngka[i] > 80 && nilaiAngka[i] <= 100) {
        nilaiHuruf[i] = "A";
        bobotNilai[i] = nilaiSetara[0];
      } else if (nilaiAngka[i] > 73 && nilaiAngka[i] <= 80) {
        nilaiHuruf[i] = "B+";
        bobotNilai[i] = nilaiSetara[1];
      } else if (nilaiAngka[i] > 65 && nilaiAngka[i] <= 73) {
        nilaiHuruf[i] = "B";
        bobotNilai[i] = nilaiSetara[2];
      } else if (nilaiAngka[i] > 60 && nilaiAngka[i] <= 65) {
        nilaiHuruf[i] = "C+";
        bobotNilai[i] = nilaiSetara[3];
      } else if (nilaiAngka[i] > 50 && nilaiAngka[i] <= 60) {
        nilaiHuruf[i] = "C";
        bobotNilai[i] = nilaiSetara[4];
      } else if (nilaiAngka[i] > 39 && nilaiAngka[i] <= 50) {
        nilaiHuruf[i] = "D";
        bobotNilai[i] = nilaiSetara[5];
      } else if (nilaiAngka[i] <= 39) {
        nilaiHuruf[i] = "E";
        bobotNilai[i] = nilaiSetara[6];
      }
      totBobot += bobotNilai[i];
    }
    sc.close();

    ip = totBobot / listmataKuliah.length;

    System.out.println("=================================================");
    System.out.println("Hasil Konversi Nilai");
    System.out.println("=================================================");

    System.out.printf("%-40s %-15s %-15s %-15s", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai\n");
    for (int i = 0; i < listmataKuliah.length; i++) {
      System.out.printf("\n%-40s %-20.2f %-13s %-15.2f\n", listmataKuliah[i], nilaiAngka[i], nilaiHuruf[i],
          bobotNilai[i]);
    }
    System.out.println("=================================================");
    System.out.printf("IP: %.2f\n", ip);

  }
}
