/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project0;

import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class Project0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random ran = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.print("Enter your date birth(dd/mm/yyyy): ");
        String date_birth = in.next();
        int x = date_birth.lastIndexOf("/");
        int y = date_birth.length();
        int m = date_birth.charAt(0);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = 0;
        // int count;
        int Point_counter = 0;
        String a = "";

        if (Character.isDigit(m)) {

            age = year - Integer.parseInt(date_birth.substring(x + 1, y));

        } else {
            boolean cond0 = true;
            while (cond0) {
                System.out.println("enter your date birth like(dd/mm/yyyy)");
                date_birth = in.next();
                // m = date_birth.charAt(0);
                x = date_birth.lastIndexOf("/");
                y = date_birth.length();
                m = date_birth.charAt(0);
                if (Character.isDigit(m)) {
                    cond0 = false;
                    age = year - Integer.parseInt(date_birth.substring(x + 1, y));

                }

            }

        }

        System.out.println("Start(s) New Game OR Exit(e): ");
        String cond = in.next();
        boolean cond1 = cond.toLowerCase().contains("s");
        boolean cond2 = cond.toLowerCase().contains("e");
        boolean c = true;
        int hidden_value = 0;
        int hidden_value2 = 0;
        while (c) {

            int ran1 = ran.nextInt(5) + 1;
            int ran2 = ran.nextInt(15) + 5;
            int ran3 = ran.nextInt(6) + 1;
            int ran4 = ran.nextInt(4) + 1;

            double w = 2;
            int digit_counter = 0;

            switch (ran4) {
                case 1:
                    w = Math.pow(ran1, ran3);
                    break;
                case 2:
                    w = w + ran3;
                    break;
                case 3:
                    w = w - ran3;
                    break;
                case 4:
                    w = w * ran3;
                    break;

            }
            if (ran4 % 2 == 0) {
                for (int i = ran4; digit_counter <= 8;) {
                    i = (int) (i + w);

                    if (digit_counter == ran3) {
                        System.out.print("?");
                        hidden_value = i;
                        //System.out.print(" , ");

                    } else {
                        System.out.print(i);

                    }
                    if (digit_counter < 8) {
                        System.out.print(" , ");
                    }
                    digit_counter++;

                }
            } else {

                String seq[] = {"A", "B", "C", "D", "E", "F",
                    "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                    "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

                for (int t = 0; digit_counter <= 8; t += 0) {

                    if (digit_counter == ran1) {
                        hidden_value2 = t;
                        System.out.print("?");

                    } else {

                        System.out.print(seq[t]);

                    }
                    t += ran4;
                    if (digit_counter < 8) {
                        System.out.print(" , ");
                    }
                    digit_counter++;

                }
                //  char e = seq.charAt(hidden_value2);
                a = seq[hidden_value2];

            }

            System.out.println();

            System.out.println("What is the hidden number? (If you want to exit, write stop)");
            System.out.println("                           (If you want to display user data), enter view");
            String cond3 = in.next();
            // int ex = Integer.parseInt(cond3);

            if (cond3.equals("stop")) {
                System.out.println("finish!");
                c = false;
            } else if (cond3.equals("view")) {
                System.out.println("Your name: " + name);
                System.out.println("Your age: " + age);
                System.out.println("your points in the game: " + Point_counter);

            } else if (cond3.equalsIgnoreCase(a)) {
                System.out.println("Excellent");

                Point_counter = Point_counter + 2;
                System.out.println("");
            } else if (Character.isDigit(cond3.charAt(0)) && Integer.parseInt(cond3) == hidden_value) {
                System.out.println("Excellent");
                Point_counter = Point_counter + 2;
                System.out.println("");

            } else {
                if ((Character.isDigit(cond3.charAt(0)) && a == "") || a == "") {
                    System.out.println("Oh, Wrong answer. The answer is: " + hidden_value);
                } else {
                    System.out.println("Oh, Wrong answer. The answer is: " + a);

                }
            }
            a = "";
        }

    }
}
