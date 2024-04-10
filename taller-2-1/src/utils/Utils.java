package utils;

import java.util.Scanner;

public class Utils {
  public static int printMenu(String[] menuOptions) {
    int opt = 0;
    Scanner input = new Scanner(System.in);

    do {
      clearConsole();
      for (int i = 0; i < menuOptions.length; i++) {
        System.out.println((i + 1) + ". " + menuOptions[i]);
      }
      System.out.print("> ");
      opt = input.nextInt();
      System.out.println("");
    } while (opt < 1 || opt > menuOptions.length);

    return opt;
  }

  public static void clearConsole() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("\b");
    }
  }

  public static void pause() {
    Scanner input = new Scanner(System.in);

    System.out.print("\nPulse enter para continuar...");
    input.nextLine();
    clearConsole();
  }
}
