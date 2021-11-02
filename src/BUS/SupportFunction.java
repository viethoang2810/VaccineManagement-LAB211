/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.ChronoUnit ;

/**
 *
 * @author Admin
 */
public class SupportFunction {
    static Scanner sc =new Scanner(System.in) ;
    public static boolean getAnswer(String answer){
        if(answer.equalsIgnoreCase("Y") == true){
            return true ;
        }
        return false ;
    }
    public static long checkDate(LocalDate d1 ,LocalDate d2){
       long range = ChronoUnit.DAYS.between(d1, d2);
       
       return range ;
    }
    public static String convertToString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatterDate = date.format(formatter);
        return formatterDate ;
    }
    public static LocalDate convertToLocalDate(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
        return date ;
    }
}
