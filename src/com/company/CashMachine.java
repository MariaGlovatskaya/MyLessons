package com.company;

import java.util.Scanner;

public class CashMachine {

    private int[] cardNamber = {123345667, 457678436, 654456789};
    private int[] cardsPin = {1111, 4444, 5678};
    private int[] cardsSumm = {10000, 500, 1000};
    private int cashMachineSumm = 150000;
    private int indexCards;
    private boolean isCardValid;
    private boolean isPinValid;

    public CashMachine() {
        System.out.println("Пожалуйста вставте карту");
    }

    private void infoPanel(String message) {
        System.out.println(message);
    }

    public void setCardNamber(int cardNamber) {
        for (int i = 0; i < this.cardNamber.length; i++) {
            if (this.cardNamber[i] == cardNamber) {
                this.isCardValid = true;
                setPin(i);
                return;
            }
        }
        this.isCardValid = false;
        infoErrInfo("Ваша карта не валидна \n вставте новую карту в банкомат");
    }

    private void setPin(int i) {
        infoPanel("Введите пин (4-е цифры )... ");
        Scanner scanner = new Scanner(System.in);
        int inputString = scanner.nextInt();
        if (this.cardsPin[i] == inputString) {
            this.isPinValid = true;
            this.indexCards = i;
            infoPanel("Пин принят \n Введите сумму для снятия.....");
            int cashSumm = scanner.nextInt();
            getMoney(cashSumm);
            return;
        } else {
            this.isPinValid = false;
            infoErrInfo("Пин не принят \n");
        }
    }

    public void Balance() {
        infoPanel("Балан равен " + this.cardsSumm[this.indexCards]);
    }

    public int getMoney(int sum) {
        int sumC = this.cardsSumm[this.indexCards];
        if (this.isPinValid) {
            if (sumC >= sum) {
                this.cardsSumm[this.indexCards] = sumC - sum;
                this.cashMachineSumm = this.cashMachineSumm - sum;
                infoPanel("Выданная сумма " + sum);
                return sum;
            }
            if (sumC < sum) {
                infoErrInfo("Доступная сумма " + sumC);
                return 0;
            }
            if (this.cashMachineSumm < sum) {
                infoErrInfo("В банкомате нет средств \n" + sum + "доступно " + this.cashMachineSumm);
                return 0;
            }
        } else {
            infoErrInfo("Пин не принят \n");
            return 0;
        }
        return 0;
    }

    private void infoErrInfo(String message) {
        System.err.println(message);
    }
}