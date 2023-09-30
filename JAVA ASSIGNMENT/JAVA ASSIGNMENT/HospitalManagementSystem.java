import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Patient {
    private String name;
    private int age;
    private char sex;
    private String address;
    private String illness;
    private int hospitalCharges;
    private int daysAdmitted;

    public Patient(String name, int age, char sex, String address, String illness, int hospitalCharges, int daysAdmitted) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.illness = illness;
        this.hospitalCharges = hospitalCharges;
        this.daysAdmitted = daysAdmitted;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(int daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nSex: " + sex + "\nAddress: " + address
            + "\nIllness: " + illness + "\nHospital Charges: $" + hospitalCharges + "\nDays Admitted: " + daysAdmitted + " days\n";
    }
}

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<Patient>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Register a Patient");
            System.out.println("2. Update Patient Details");
            System.out.println("3. Display Patient Details");
            System.out.println("4. Remove Inactive Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    updatePatientDetails();
                    break;
                case 3:
                    displayPatientDetails();
                    break;
                case 4:
                    removeInactivePatients();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter patient sex (M/F): ");
        char sex = scanner.nextLine().charAt(0);

        System.out.print("Enter patient address: ");
        String address = scanner.nextLine();

        System.out.print("Enter patient illness: ");
        String illness = scanner.nextLine();

        System.out.print("Enter hospital charges: $");
        int hospitalCharges = scanner.nextInt();

        System.out.print("Enter days admitted: ");
        int daysAdmitted = scanner.nextInt();

        Patient patient = new Patient(name, age, sex, address, illness, hospitalCharges, daysAdmitted);
        patients.add(patient);
        System.out.println("Patient registered successfully.");
    }

    private static void updatePatientDetails() {
        System.out.print("Enter patient name to update details: ");
        String name = scanner.nextLine();

        Iterator<Patient> iterator = patients.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.toString().contains("Name: " + name)) {
                System.out.println("Enter new details for " + name + ":");
                System.out.print("Enter new hospital charges: $");
                int hospitalCharges = scanner.nextInt();
                patient.setDaysAdmitted(0);
                patient = new Patient(patient.toString().replace("$" + patient.hospitalCharges, "$" + hospitalCharges), patient.getDaysAdmitted());
                patients.set(patients.indexOf(patient), patient);
                found = true;
                System.out.println("Patient details updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Patient with name " + name + " not found.");
        }
    }

    private static void displayPatientDetails() {
        System.out.println("Patient Details:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void removeInactivePatients() {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.getDaysAdmitted() > 15) {
                iterator.remove();
                System.out.println("Removed inactive patient: " + patient);
            }
        }
    }
}
