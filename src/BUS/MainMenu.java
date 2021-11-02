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
public class MainMenu {
    static Scanner sc = new Scanner(System.in) ;
        public static int getUserChoice(String[] options){
        int choice = 0;
        for(int i = 0;i < options.length ; i++){
            System.out.println(i + "--" + options[i]);
        }
        System.out.print("Choose 1 ... " + options.length +":");
        choice = Integer.parseInt(sc.nextLine()) ;
        return choice ;
    }
        public static int getChoiceForAdd(String[] options){
        int choice = 0;
        for(int i = 0;i < options.length ; i++){
            System.out.println((i+1) +  "--" + options[i]);
        }
        System.out.print("Choose 1 ... " + options.length +":");
        choice = Integer.parseInt(sc.nextLine()) ;
        return choice ;
    }
}
