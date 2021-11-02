/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SubMenu {

    static Scanner sc = new Scanner(System.in);

    public static String Menu() {
        int choice = 0;
        System.out.println("Choice vaccine: ");
        System.out.println("1. AstraZeneca");
        System.out.println("2. SPUTNIK V");
        System.out.println("3. Vero Cell");
        System.out.println("4. Pfizer");
        System.out.println("5. Moderna");
        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> {
                return "AstraZeneca";
            }

            case 2 -> {
                return "SPUTINK V";
            }

            case 3 -> {
                return "VeroCell";
            }

            case 4 -> {
                return "Pfizer";
            }

            case 5 -> {
                return "Moderna";
            }

        }
        return null ;
    }
    public static int searchMenu(){
        int choice = 0 ;
        System.out.println("1.Search by studentID");
        System.out.println("2.Search by student's name");
        System.out.print("Enter your choice: ");
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1 : return 1 ;
            case 2 : return 2;
        }
        return 0 ;
    }
}
