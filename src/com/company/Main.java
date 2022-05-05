package com.company;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public void execute() {
        ui();

    }

    public void ui() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                                    
                    Velkommen til prisberegner 2022!! v 0.42.
                                    
                    Indtast venligst et nummer for at tage et valg.
                                    
                    1. Beregn pris af produkter.
                    2. Udskriv alle rabatter.
                    3. Udksriv alle skatter.
                                    
                    """);

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> beregn();
                case "2" -> printRabat();
                case "3" -> printTax();
                // default -> System.out.println("Venligst indtast et tal som er validt.");
            }
        }while(true);
    }

        public void printRabat(){
            System.out.println("""
                    Ordre værdi	    Rabat mængde
                    $1,000	        3%
                    $5,000	        5%
                    $7,000	        7%
                    $10,000	        10%
                    $50,000	        15%
                    """);
        }

        public void printTax(){
            System.out.println("""
                    Stat	    Skat mængde
                    UT	        6.85%
                    NV	        8.00%
                    TX	        6.25%
                    AL	        4.00%
                    CA	        8.25%
                    """);
        }

        public void beregn() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Indtast varens pris: ");
            double varePris = sc.nextDouble();

            System.out.print("Indtast antal varer: ");
            int vareAntal = sc.nextInt();

            System.out.println();

            boolean validAnswer;
            String vareStat;
            double statSkat = 0;
            do {

                System.out.print("Indtast din nuværende stat: ");
                vareStat = sc.next().toUpperCase();

                validAnswer = false;

                switch (vareStat) {
                    case "UT":
                        statSkat = 6.68;
                        break;
                    case "NV":
                        statSkat = 8;
                        break;
                    case "TX":
                        statSkat = 6.25;
                        break;
                    case "AL":
                        statSkat = 4;
                        break;
                    case "CA":
                        statSkat = 8.25;
                        break;
                    default:
                        System.out.println("Venligst indtast en stat som findes på listen.");
                        validAnswer = true;
                        break;
                }
            } while (validAnswer);

            double vareTotal = varePris * vareAntal;

            if ( vareTotal >= 50000){
                System.out.println("Din ordre på $" + vareTotal + " har givet dig 15%!");
            } else if (vareTotal >= 10000){
                System.out.println("Din ordre på $" + vareTotal + " har givet dig 10%!");
            } else if (vareTotal >= 7000){
                System.out.println("Din ordre på $" + vareTotal + " har givet dig 7%!");
            } else if (vareTotal >= 5000){
                System.out.println("Din ordre på $" + vareTotal + " har givet dig 5%!");
            } else if (vareTotal <= 1000){
                System.out.println("Din ordre på $" + vareTotal + " har givet dig 3%!");
            } else {
                System.out.println("Din ordre på $" + vareTotal + " Ingen discount!");
            }

        }



    public static void main(String[] args) {
	Main main = new Main();
    main.execute();
    }
}
