/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class Injection implements Serializable{
    private static final long serialVersionUID = 1427461703707854023L;
    public String injectionID ;
    public String firstPlace ;
    public String secondPlace ;
    public String firstDate ;
    public String secondDate ;
    public String studentID ;
    public String vaccineID ;
    public String secondVaccineID ;
    public int amountInjection ;

    public Injection() {
    }

    public Injection(String injectionID, String firstPlace, String secondPlace, String firstDate, String secondDate, String studentID, String vaccineID, String secondVaccineID, int amountInjection) {
        this.injectionID = injectionID;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.secondVaccineID = secondVaccineID;
        this.amountInjection = amountInjection;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getSecondVaccineID() {
        return secondVaccineID;
    }

    public void setSecondVaccineID(String secondVaccineID) {
        this.secondVaccineID = secondVaccineID;
    }

    public int getAmountInjection() {
        return amountInjection;
    }

    public void setAmountInjection(int amountInjection) {
        this.amountInjection = amountInjection;
    }

    @Override
    public String toString() {
        return "";
    }
    public void showInjection(){
        System.out.printf( "|%-15s|%-15s|%-20s|%-13s|%-20s|%-13s|%-20s|%-20s|%d|" + "\n ",injectionID,studentID,vaccineID,firstDate,firstPlace,
                secondDate,secondVaccineID,secondPlace,amountInjection);
    }
}
