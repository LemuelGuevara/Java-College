package OOP;

import java.util.*;

class Date
{
    private int dateMonth, dateDay, dateYear;

    Date(int dateMonth, int dateDay, int dateYear)
    {
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
        this.dateYear = dateYear;
    }

    public int getDateMonth()
    {
        return dateMonth;
    }

    public int getDateDay()
    {
        return dateDay;
    }

    public int getDateYear()
    {
        return dateYear;
    }

    public String toString()
    {
        return getDateMonth() + "-" + getDateDay() + "-" + getDateYear();
    }
}

class Bill
{
    private final double pharmacyCharges, doctorCharges, roomCharges;

    Bill(double pharmacyCharges, double doctorCharges, double roomCharges)
    {
        this.pharmacyCharges = pharmacyCharges;
        this.doctorCharges = doctorCharges;
        this.roomCharges = roomCharges;
    }

    private double getPharmacyCharges()
    {
        return pharmacyCharges;
    }

    private double getDoctorCharges()
    {
        return doctorCharges;
    }

    private double getRoomCharges()
    {
        return roomCharges;
    }

    private double computeTotalCharge()
    {
        return getPharmacyCharges() + getDoctorCharges() + getRoomCharges();
    }

    public String toString()
    {
        return "\nPharmaceutical Charges: " + getPharmacyCharges() + "\nDoctor Charges: " + getDoctorCharges()
                + "\nRoom Charges: " + getRoomCharges() + "\nTotal Charge: " + computeTotalCharge();
    }
}

class Person
{
    private final String firstName, lastName;

    Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String toString()
    {
        return getFirstName() + " " +  getLastName();
    }
}

class Doctor extends Person
{
    private final String speciality;

    Doctor(String firstName, String lastName, String speciality)
    {
        super(firstName, lastName);
        this.speciality = speciality;
    }

    public String getSpeciality()
    {
        return speciality;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}

class Patient extends Person
{
    private final Doctor doctor;
    private final int age, patientID;
    private final Date dateAdmitted, dateDischarged, birthDate;

    Patient(String firsName, String lastName, int patientID, Doctor doctor, int age, Date birthDate,
            Date dateAdmitted, Date dateDischarged)
    {
        super(firsName, lastName);
        this.patientID = patientID;
        this.doctor = doctor;
        this.age = age;
        this.birthDate = birthDate;
        this.dateAdmitted = dateAdmitted;
        this.dateDischarged = dateDischarged;
    }

    private long getPatientID()
    {
        return patientID;
    }

    public Date getPatientBirthDate()
    {
        return birthDate;
    }

    public Doctor getDoctorName()
    {
        return doctor;
    }

    public int getPatientAge()
    {
        return age;
    }

    private Date getDateAdmitted()
    {
        return dateAdmitted;
    }

    private Date getDateDischarged()
    {
        return dateDischarged;
    }

    @Override
    public String toString()
    {
        return "\nPatient ID: " + getPatientID() + "\nPatient Name: " + super.toString()
                + "\nPatient Age: " + getPatientAge() + "\nPatient's Birthdate: " + getPatientBirthDate()
                + "\n" + "\nPatient Doctor: " + getDoctorName() + "\n" + "\nDate Admitted: " + getDateAdmitted()
                + "\nDate Discharged: " + getDateDischarged();
    }
}

public class OOPInheritanceBill
{
    static Scanner in = new Scanner(System.in);

    public static Date getDate()
    {
        int month, day, year;

        System.out.print("\nEnter Month: ");
        month = in.nextInt();
        System.out.print("Enter Day: ");
        day = in.nextInt();
        System.out.print("Enter Year: ");
        year = in.nextInt();

        return new Date(month, day, year);
    }

    public static Doctor getDoctorInformation()
    {
        String firstName, lastName, speciality;

        System.out.println("\n--DOCTOR DETAILS---");

        System.out.print("\nDoctor's Firstname: ");
        firstName = in.next();
        System.out.print("Doctor's Lastname: ");
        lastName = in.next();
        System.out.print("Doctor's Speciality: ");
        speciality = in.next();

        return new Doctor(firstName, lastName, speciality);
    }

    public static Patient getPatientInformation(Doctor doctor)
    {
        String firstName, lastName;
        int age, patientID;
        Date birthDate, admittedDate, dischargedDate;

        System.out.println("\n--PATIENT DETAILS---");

        System.out.print("Patient's Firstname: ");
        firstName = in.next();
        System.out.print("Patient's Lastname: ");
        lastName = in.next();
        System.out.print("Patient's ID: ");
        patientID = in.nextInt();
        System.out.print("Patient's Age: ");
        age = in.nextInt();
        System.out.print("Patient's Birthdate: ");
        birthDate = getDate();
        System.out.print("Date Admitted: ");
        admittedDate = getDate();
        System.out.print("Date Discharged: ");
        dischargedDate = getDate();

        return new Patient(firstName, lastName, patientID, doctor, age, birthDate, admittedDate, dischargedDate);
    }

    public static Bill getHospitalCharges()
    {
        double pharmacyCharges, doctorCharges, roomCharges;

        System.out.println("--HOSPITAL CHARGES---");

        System.out.print("Enter Pharmaceutical Charges: ");
        pharmacyCharges = in.nextDouble();
        System.out.print("Enter Doctor Charges: ");
        doctorCharges = in.nextDouble();
        System.out.print("Enter Room Charges: ");
        roomCharges = in.nextDouble();

        return new Bill(pharmacyCharges, doctorCharges, roomCharges);
    }

    public static void printMedicalBill()
    {
        Doctor doctor = getDoctorInformation();
        Patient patient = getPatientInformation(doctor);
        Bill bill = getHospitalCharges();

        System.out.println("\n\n");

        System.out.println("-----------------------------------------");
        System.out.println("DOCTOR INFORMATION\n" + "Doctor's Name: " + doctor + "\nDoctor's Speciality: " +
                doctor.getSpeciality());
        System.out.println("-----------------------------------------");
        System.out.println("PATIENT INFORMATION\n" + patient);
        System.out.println("-----------------------------------------");
        System.out.println("HOSPITAL CHARGE\n" + bill);
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args)
    {
        printMedicalBill();
    }
}
