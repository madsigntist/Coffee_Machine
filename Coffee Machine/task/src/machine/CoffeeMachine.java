package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int w = 400;
    private static int m = 540;
    private static int b = 120;
    private static int c = 9;
    private static int m$ = 550;
    private static boolean turnOff = false;

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        do {
            coffeeMachine.chooseAction();
        } while (!turnOff);
    }

    public static void state(){
        System.out.printf("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n", w, m, b, c, m$);
    }

    public boolean exit(String command){
        if (command.equals("exit")) {
            return true;
        } else {
            return false;
        }
    }

    public void chooseAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                chooseCoffee();
                break;
            case "fill":
                fillTheMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                state();
                break;
            case "exit":
                turnOff = exit("exit");
                break;
        }
    }

    public static void chooseCoffee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String action = scanner.next();

        switch (action) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
        }
    }

    public static void espresso(){
        if ((w >= 250) && (b >= 16) && (c >= 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            w -= 250;
            b -= 16;
            c -= 1;
            m$ += 4;
            System.out.println();
        } else if (w <250) {
            System.out.println("Sorry, not enough water!");
        } else if (b < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (c < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public static void latte() {
        if ((w >= 350) && (m >= 75) && (b >= 20) && (c >= 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            w -= 350;
            m -= 75;
            b -= 20;
            c -= 1;
            m$ += 7;
            System.out.println();
        } else if (w < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (m < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (b < 20) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (c < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public static void cappuccino() {
        if ((w >= 200) && (m >= 100) && (b >= 12) && (c >= 1)) {
            System.out.println("I have enough resources, making you a coffee!");
            w -= 200;
            m -= 100;
            b -= 12;
            c -= 1;
            m$ += 6;
            System.out.println();
        } else if (w < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (m < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (b < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (c < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public static void fillTheMachine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        w += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        m += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        b += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        c += scanner.nextInt();
    }

    public static void takeMoney(){
        System.out.printf("I gave you $%d\n\n", m$);
        m$ = 0;
    }
}
