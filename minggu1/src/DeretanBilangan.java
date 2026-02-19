import java.util.Scanner;

class DeretanBilangan {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.printf("Input NIM: ");
    String curNim = sc.nextLine();

    int n = Integer.parseInt(curNim.substring(curNim.length() - 2));
    if (n < 10) {
      n += 10;
    }

    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0) {
        System.out.printf("# ");
      } else if (i == 10 || i == 15) {
        continue;
      } else if (i % 2 == 0) {
        System.out.printf("%d ", i);
      } else {
        System.out.printf("* ");
      }
    }

    sc.close();

  }

}
