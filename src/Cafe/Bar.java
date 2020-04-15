package Cafe;

import java.util.Scanner;

public class Bar extends Cafes implements Restaurants {

    private void Info(String message) {
        System.err.println(message);
    }

    @Override
    public void takeOrder() {
        Info("Hey, wanna viskey?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Yes")) {
            Info("Here you are");}
    }

    @Override
    protected void pay(){
        Info("You pay 1 pound and tips");
    }
}
