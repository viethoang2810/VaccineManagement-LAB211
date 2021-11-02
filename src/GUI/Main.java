/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.InjectionManagement;
import DTO.Injection;
import DTO.Student;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        InjectionManagement list = new InjectionManagement();
        list.writeVaccine("Vaccine.dat");
        list.readStudent("student.dat");
        list.readInjection("Injection.dat");
        //list.readInjection("Injection.dat");
        String[] options = {"Show information all students have been injected",
            " Add student's vaccine injection information",
            "Updating information of students' vaccine injection",
            "Delete student vaccine injection information",
            "Search for injection information by studentID",
            "Print the list of injection",
            "Save to File",
            "Others- Quit"
        };
        do {
            choice = BUS.MainMenu.getUserChoice(options);
            switch (choice) {
                case 0:
                    list.readInjection("Injection.dat");
                    break;
                case 1:
                    list.addInjection();
                    list.writeInjection("Injection.dat");
                    break;
                case 2:
                    list.updateInjection();
                    list.writeInjection("Injection.dat");
                    break;
                case 3:
                    list.deleteInfor();
                    list.writeInjection("Injection.dat");
                    break;
                case 4:
                    list.searchInjection();
                    break;
                case 5:
                    System.out.println("|InjectionID    |StudentID      |First VaccineID     |FirstDate    |First Place         |SecondDate   |Second VaccineID    |Second Place        |Number of Injection   |");
                    list.printList();
                    break;
                case 6:
                    list.writeInjection("Injection.dat");
                    break;
            }
        } while (choice >= 0 && choice < 7);
    }
}
