package Cafe;

import java.util.*;

public class Cafe extends Cafes implements Restaurants{
   // private String[][] menu = {{"Espresso", "Latte", "Capuchino"}, {"Tosts", "Omelette", "Cheesecakes"}};
   //private double[][] prise = {{2.50, 3.10, 4.20}, {3.40, 4.10, 5.00}};
    private double myMoney = 15.70;
    private double iPay;
    Map<String, Double> menu = new HashMap<>();
   // List<String> menu = new ArrayList<>();
   // List<Double> price = new ArrayList();

   {
       menu.put("Espresso", 2.50);
       menu.put("Latte", 3.10);
       menu.put("Capuchino", 4.20);
    }


    private void Info(String message) {
        System.err.println(message);
    }

    public Cafe() {
        System.out.println("Good morning. Please see our menu:");
        for(Map.Entry<String, Double> entry: menu.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
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
   if(menu.containsKey(item)){
       iPay = iPay + menu.get(item);
    return "Your order is:" + item + "with price" + menu.get(item);
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
