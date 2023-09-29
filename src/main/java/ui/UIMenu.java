package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS =
            {"January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {
        // userType=1 Doctor
        // userType=2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alan Florez", "alanf@mail.com"));
        doctors.add(new Doctor("Diana Pinzón", "dianap@mail.com"));
        doctors.add(new Doctor("Egan Beranl", "eganb@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Miguel Florez", "miguelf@mail.com"));
        patients.add(new Patient("Victor Araque", "victora@mail.com"));
        patients.add(new Patient("Freddy Vega", "freddyv@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [mail@domain.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1) {
                for (Doctor doctor :
                        doctors) {
                    if (doctor.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Get the info
                        doctorLogged = doctor;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2) {
                for (Patient patient :
                        patients) {
                    if (patient.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Get the info
                        patientLogged = patient;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }
        while (!emailCorrect);
    }

    static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");

                    break;
                case 2:
                    System.out.println("::My appointments");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + ". " + MONTHS[i]);
                    }
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }

}
