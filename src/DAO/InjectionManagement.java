/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Injection;
import DTO.Student;
import DTO.Vaccine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class InjectionManagement implements InjectionInteface {

    Scanner sc = new Scanner(System.in);
    ArrayList<Injection> injection = new ArrayList<>();
    ArrayList<Student> student = new ArrayList<>();
    ArrayList<Vaccine> vaccine = new ArrayList<>();
    static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Student searchStudent(String code) {
        for (int i = 0; i < student.size(); i++) {
            if ((student.get(i).getStudentID()).equals(code) == true) {
                return student.get(i);
            }
        }
        return null;
    }

    public boolean checkExist(String code) {
        return searchStudent(code) != null;
    }

    public boolean isCodeDuplicate(String code) {
        return searchById(code) != null;
    }

    public boolean codeDuplicate(String code) {
        return searchStudentID(code) != null;
    }

    public Injection searchStudentID(String code) {
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getStudentID().equalsIgnoreCase(code)) {
                return injection.get(i);
            }
        }
        return null;
    }

    public Injection searchById(String code) {
        for (int i = 0; i < injection.size(); i++) {
            if (injection.get(i).getInjectionID().equalsIgnoreCase(code)) {
                return injection.get(i);
            }
        }
        return null;
    }

    @Override
    public void addInjection() {
        String firstPlace;
        String injectionID;
        LocalDate date1;
        String firstDate;
        String studentID;
        String firstvaccineID;
        String answer;
        String secondPlace = "";
        String secondVaccineID = "";
        LocalDate date2;
        String secondDate;
        boolean check = false;
        boolean checkDuplicate = false;
        boolean checkID = false, checkExist = false;
        int amountInjection = 0;
        int choice = 0;
        String[] options = {"Add first injection", "Add add injection"};
        do {
            choice = BUS.MainMenu.getChoiceForAdd(options);
            if (choice == 1) {
                try {
                    do {
                        System.out.println("The ID must be matched with the pattern[ID***]-with * is a number in the range[0-9]");
                        injectionID = BUS.CheckValidate.inputID("Enter the injection ID: ");
                        checkDuplicate = isCodeDuplicate(injectionID);
                        if (checkDuplicate) {
                            System.err.println("The ID is already exist in list");
                        }
                    } while (checkDuplicate == true);
                    firstPlace = BUS.CheckValidate.inputString("Enter the first place injection: ");
                    date1 = LocalDate.now();
                    firstDate = BUS.SupportFunction.convertToString(date1);
                    do {
                        do {
                            studentID = BUS.CheckValidate.inputStudentID("Enter student ID: ", "\\D\\D[0-9]{4}");
                            checkExist = checkExist(studentID);
                            if (checkExist == false) {
                                System.err.println("The student doesn't exist");
                                System.out.println("Please input another ID");
                            }
                        } while (checkExist == false);
                        checkID = codeDuplicate(studentID);
                        if (checkID) {
                            System.err.println("The student has been injected");
                            System.out.println("Please enter another ID");
                        }
                    } while (checkID == true);
                    System.out.println("Choose the id of vaccine");
                    firstvaccineID = BUS.SubMenu.Menu();
                    amountInjection++;
                    System.out.println("The second injection  will be after 42 days,so the secondDate will present the default value 01/01/200");
                    Injection a = new Injection(injectionID, firstPlace, secondPlace, firstPlace, secondPlace, studentID, firstvaccineID, secondVaccineID, amountInjection);
                    injection.add(a);
                } catch (Exception e) {
                    System.err.println(e);
                }
            } else if (choice == 2) {
                try {
                    do {
                        System.out.println("The ID must be matched with the pattern[ID***]-with * is a number in the range[0-9]");
                        injectionID = BUS.CheckValidate.inputID("Enter the injection ID: ");
                        checkDuplicate = isCodeDuplicate(injectionID);
                        if (checkDuplicate) {
                            System.err.println("The ID is already exist in list");
                        }
                    } while (checkDuplicate == true);
                    firstPlace = BUS.CheckValidate.inputString("Enter the first place injection: ");
                    date1 = LocalDate.now();
                    firstDate = BUS.SupportFunction.convertToString(date1);
                    do {
                        do {
                            studentID = BUS.CheckValidate.inputStudentID("Enter student ID: ", "\\D\\D[0-9]{4}");
                            checkExist = checkExist(studentID);
                            if (checkExist == false) {
                                System.err.println("The student doesn't exist");
                                System.out.println("Please input another ID");
                            }
                        } while (checkExist == false);
                        checkID = codeDuplicate(studentID);
                        if (checkID) {
                            System.err.println("The student has been injected");
                            System.out.println("Please enter another ID");
                        }
                    } while (checkID == true);
                    System.out.println("Choose the id of vaccine");
                    firstvaccineID = BUS.SubMenu.Menu();
                    secondPlace = BUS.CheckValidate.inputString("Enter the second place injection: ");
                    System.out.println("The 2nd vaccine should be same ID with the 1st injection");;
                    secondVaccineID = BUS.SubMenu.Menu();
                    System.out.print("Enter second date: ");
                    date2 = LocalDate.parse(sc.nextLine(), formatters);
                    if (date2.isAfter(date1) == true) {
                        long distance = BUS.SupportFunction.checkDate(date1, date2);
                        if (secondVaccineID.equals("AstraZeneca")) {
                            if (distance < 42) {
                                System.err.println("You don't enough day to get second injection.Must be greater or equal 42 days");
                                break;
                            }
                        } else if (secondVaccineID.equals("SPUTINK V") || secondVaccineID.equals("VeroCell") || secondVaccineID.equals("Pfizer")) {
                            if (distance < 21) {
                                System.err.println("You don't enough day to get second injection.Must be greater or equal 21 days");
                                break;
                            }
                        } else if (secondVaccineID.equals("Moderna")) {
                            if (distance < 28) {
                                System.out.println("You don't enough day to get second injection.Must be greater or equal 28 days");
                                break;
                            }
                        }
                    } else {
                        System.out.println("The date is invalid");
                    }
                    secondDate = BUS.SupportFunction.convertToString(date2);
                    amountInjection = 2;
                    Injection a = new Injection(injectionID, firstPlace, secondPlace, firstDate, secondDate, studentID, firstvaccineID, secondVaccineID, amountInjection);
                    injection.add(a);
                } catch (Exception e) {

                }
            }
            System.out.println("Do you want add more injection? (Y/N) : ");
            answer = sc.nextLine();
            check = BUS.SupportFunction.getAnswer(answer);
        } while (check == true);
    }

    @Override
    public void updateInjection() {
        boolean check = false;
        String answer = "";
        String firstPlace;
        String injectionID;
        Injection a = null;
        String secondVaccineID;
        LocalDate firstDate;
        LocalDate date2;
        String secondDate;
        int amount = 1;
        do {
            injectionID = BUS.CheckValidate.inputID("Enter the injection ID: ");
            a = this.searchById(injectionID);
            if (a == null) {
                System.err.println("The ID doesn't exist in list");
                return;
            } else if (a.getAmountInjection() == 2) {
                System.out.println("Update new first place or click Enter to skip: ");
                firstPlace = sc.nextLine();
                if (firstPlace.equalsIgnoreCase("")) {
                    firstPlace = a.getFirstPlace();
                }
                a.setFirstPlace(firstPlace);
                String secondPlace = BUS.CheckValidate.inputString("Enter new second place injection or press Enter to skip : ");
                if (secondPlace.equalsIgnoreCase("")) {
                    secondPlace = a.getSecondPlace();
                }

                a.setSecondPlace(secondPlace);
                System.out.println(injectionID + " has updated successfully ");
            } else {
                firstDate = BUS.SupportFunction.convertToLocalDate(a.getFirstDate());
                String secondPlace = BUS.CheckValidate.inputString("Enter new second place injection : ");
                System.out.println("The 2nd vaccine should be same ID with the 1st injection");;
                secondVaccineID = BUS.SubMenu.Menu();
                System.out.print("Enter second date: ");
                date2 = LocalDate.parse(sc.nextLine(), formatters);
                if (date2.isAfter(firstDate) == true) {
                    long distance = BUS.SupportFunction.checkDate(firstDate, date2);
                    if (secondVaccineID.equals("AstraZeneca")) {
                        if (distance < 42) {
                            System.out.println("You don't enough day to get second injection.Must be greater or equal 42 days");
                            break;
                        }
                    } else if (secondVaccineID.equals("SPUTINK V") || secondVaccineID.equals("VeroCell") || secondVaccineID.equals("Pfizer")) {
                        if (distance < 21) {
                            System.out.println("You don't enough day to get second injection.Must be greater or equal 21 days");
                            break;
                        }
                    } else if (secondVaccineID.equals("Moderna")) {
                        if (distance < 28) {
                            System.out.println("You don't enough day to get second injection.Must be greater or equal 28 days");
                            break;
                        }
                    }
                } else {
                    System.out.println("The date is invalid");
                }
                secondDate = BUS.SupportFunction.convertToString(date2);
                a.setSecondPlace(secondPlace);
                a.setSecondVaccineID(secondVaccineID);
                a.setSecondDate(secondDate);
                System.out.println(a.getStudentID() + " has completed the injection program");
            }
            System.out.println("Do you want to update more ? ");
            answer = sc.nextLine();
            check = BUS.SupportFunction.getAnswer(answer);
        } while (check == true);
    }

    @Override
    public void deleteInfor() {
        boolean checkAnswer = false;
        if (injection.isEmpty()) {
            System.out.println("No student have been injected ");
            return;
        }
        System.out.println("Enter the studentID: ");
        String studentID = BUS.CheckValidate.inputStudentID("Enter student ID: ", "\\D\\D[0-9]{4}");
        Injection x = this.searchById(studentID);
        if (x == null) {
            System.out.println("The student does not exist");
        } else {
            System.out.print("Are you sure to remove injection of " + studentID + "? Y/N : ");
            String answer = sc.nextLine();
            checkAnswer = BUS.SupportFunction.getAnswer(answer);
            if (checkAnswer == true) {
                injection.remove(x);
                Injection check = this.searchById(studentID);
                if (check == null) {
                    System.out.println("Injection of student  " + studentID + "is deleted successfully !");
                } else {
                    System.err.println("Remove fail ! ");
                }
                return;
            }

        }
    }

    @Override
    public void searchInjection() {
        int choice = BUS.SubMenu.searchMenu();
        if (choice == 1) {
            System.out.println("Enter the studentID: ");
            String studentID = BUS.CheckValidate.inputStudentID("Enter student ID: ", "\\D\\D[0-9]{4}");
            Injection x;
            x = this.searchStudentID(studentID);
            if (x != null) {
                x.showInjection();
            }
        } else if (choice == 2) {
            String name = BUS.CheckValidate.inputString("Enter student name: ");
            Student[] x = getStudentID(name);
            Injection[] a  = new Injection[injection.size()];
            for (int i = 0; i < injection.size(); i++) {
                a[i] = this.searchStudentID(x[i].getStudentID());
                if(a[i] != null){
                    a[i].showInjection();
                }
            }
        }
    }

    public Student[] getStudentID(String name) {
        Student[] stu = new Student[student.size()];
        for (int i = 0; i < stu.length; i++) {
            if (student.get(i).getStudentName().contains(name) == true) {
                stu[i] = student.get(i);
            }
        }
        return stu;
    }

    public void printList() {
        for (Injection x : injection) {
            x.showInjection();
        }
    }

    public void writeStudent(String fName) {
        try {
            FileOutputStream file = new FileOutputStream(fName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            student.add(new Student("SE1507", "Do Viet Hoang"));
            student.add(new Student("SE1508", "Tran Hoai Nam"));
            student.add(new Student("SE1509", "Pham Huu Anh Tai"));
            student.add(new Student("SE1510", "Le Xuan Dai"));
            student.add(new Student("SE1511", "Bui Ngoc Huy"));
            for (Student st : student) {
                oStream.writeObject(st);
            }
            oStream.close();
            file.close();
        } catch (IOException e) {

        }
    }

    public void readStudent(String fName) {
        try {
            FileInputStream fis = new FileInputStream(fName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student stu;
            while ((stu = (Student) (ois.readObject())) != null) {
                student.add(stu);
            }
            System.out.println("Sucessfull");
        } catch (Exception e) {
        }
    }

    public void writeVaccine(String fName) {
        try {
            File f = new File(fName);
            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            vaccine.add(new Vaccine("Covid-V1001", "AstraZeneca"));
            vaccine.add(new Vaccine("Covid-V1002", "SPUTNIK V"));
            vaccine.add(new Vaccine("Covid-V1003", "Vero Cell"));
            vaccine.add(new Vaccine("Covid-V1004", "Pfizer"));
            vaccine.add(new Vaccine("Covid-V1005", "Moderna"));
            for (Vaccine vc : vaccine) {
                oStream.writeObject(vc);
            }
            oStream.close();
            file.close();
        } catch (IOException e) {
        }
    }

    public void readVaccine(String fName) {
        try {
            try (FileInputStream fis = new FileInputStream(fName); ObjectInputStream ois = new ObjectInputStream(fis)) {
                Vaccine vcn;
                while ((vcn = (Vaccine) (ois.readObject())) != null) {
                    vaccine.add(vcn);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void writeInjection(String fName) {
        try {
            File f = new File(fName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Injection injection1 : injection) {
                oos.writeObject(injection1);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public void readInjection(String fName) {
        try {
            try (FileInputStream fis = new FileInputStream(fName); ObjectInputStream ois = new ObjectInputStream(fis)) {
                Injection inj;
                while ((inj = (Injection) (ois.readObject())) != null) {
                    injection.add(inj);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
