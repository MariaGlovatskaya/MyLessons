package Cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cafe extends Cafes implements Restaurants{
   // private String[][] menu = {{"Espresso", "Latte", "Capuchino"}, {"Tosts", "Omelette", "Cheesecakes"}};
   //private double[][] prise = {{2.50, 3.10, 4.20}, {3.40, 4.10, 5.00}};
    private double myMoney = 15.70;
    private double iPay;
    List<String> menu = new ArrayList<>();
    List<Double> price = new ArrayList();

   {
        menu.add("Espresso");
        menu.add("Latte");
        menu.add("Capuchino");
       price.add(2.50);
       price.add(3.10);
       price.add(4.20);
    }


    private void Info(String message) {
        System.err.println(message);
    }

    public Cafe() {
        System.out.println("Good morning. Please see our menu:");
        for (String item:menu) {
           Double pr = price.get(menu.indexOf(item));
                System.out.println(item + " Price " + pr.toString());
        }
    }

    @Override
    public void takeOrder() {
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
   if(menu.contains(item)){
       iPay = iPay + price.get(menu.indexOf(item));
    return "Your order is:" + menu.get(menu.indexOf(item)) + "with price" + price.get(menu.indexOf(item));
            }else{
                System.out.println("There is no such position in menu");
                return "";
            }
}

@Override
protected void pay(){
    myMoney = myMoney - iPay;
Info("Money paid: " + iPay + "Money left: " + myMoney);
}

}
//грокаем Алгоритмы
//comme
