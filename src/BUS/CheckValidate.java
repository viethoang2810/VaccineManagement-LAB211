/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CheckValidate {
    static ArrayList<Student> student = new ArrayList<Student>() ;
    static Scanner sc = new Scanner(System.in) ;
    static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String inputID(String msg){
        String pattern = "\\D\\D[0-9]{3}" ;
        String input = "";
        do{
            System.out.print(msg);
           input = sc.nextLine() ;
        }while(!input.matches(pattern)) ;
       return input ;
    }
    public static String inputStudentID(String str , String pattern){
        String input = "" ;
        do {                
            System.out.print(str);
            input = sc.nextLine().toUpperCase() ;
        } while (!input.matches(pattern));
        return input ;
    }
    public static String inputString(String str){
        String input = "" ;
        do {            
            System.out.print(str);
            input = sc.nextLine().toUpperCase();
        } while (input.length() == 0);
        return input ;
    }
    public static String inputAnswer(String str){
        String pattern1 = "Y" ;
        String pattern2 = "N" ;
        String input = " " ;
        do{
            System.out.println(str);
            input = sc.nextLine().toUpperCase() ;
        }while(!(input.matches(pattern1)||input.matches(pattern2)));
        return input ;
    }
    public static String inputWeight(String str){
        String weight ; 
        String pattern = "[0-15]";
        do {            
            System.out.println(str);
            weight = sc.nextLine() ;
        } while (!weight.matches(pattern));
        return weight ;
    }
    public static String checkDate(String str){
        String date ;
        String pattern ="[0-9]{2}/[0-9]{2}/[0-9]{4}";
        do{
            System.out.println(str);
            date = sc.nextLine();
        }while(!date.matches(pattern)) ;
        return date ;
    }
    
}
