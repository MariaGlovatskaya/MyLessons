package Cafe;

import java.util.Scanner;

public class Cafe {
    private String[][] menu = {{"Espresso", "Latte", "Capuchino"}, {"Tosts", "Omelette", "Cheesecakes"}};
    private double[][] prise = {{2.50, 3.10, 4.20}, {3.40, 4.10, 5.00}};
    private double myMoney = 15.70;
    private double iPay;

    private void Info(String message) {
        System.err.println(message);
    }

    public Cafe() {
        System.out.println("Good morning. Please see our menu:");
        for (int i = 0; i < menu.length; i++) {
            for (int x = 0; x < menu[i].length; x++)
                System.out.println(menu[i][x] + " Price " + prise[i][x]);
        }
    }

    protected void takeOrder() {
        Info("Are you ready to make an order?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Yes")) {
            Info("What would you like to order?");
            String inputString = scanner.next();
                Info("Your order is:" + isItemInMenu(inputString));
        } else{
            Info("Sure, I'll come back to you a bit later");
        }

    }
private String isItemInMenu(String item){
    for (int i = 0; i < menu.length; i++) {
        for (int x = 0; x < menu[i].length; x++)
            if(menu[i][x].equalsIgnoreCase(item) ){
                iPay = iPay + prise[i][x];
                return "Your order is:" + menu[i][x] + "with prise:" + prise[i][x];
            }else{
                System.out.println("There is no such position in menu");
                return "";
            }
    }
    return "";
}

protected void pay(){
    myMoney = myMoney - iPay;
Info("Money paid: " + iPay + "Money left: " + myMoney);
}

}
//грокаем Алгоритмы
//comment