import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.addPatient(this);
        System.out.println(name + " is consulting Dr. " + doctor.getName());
    }

    public void displayDoctors() {
        System.out.println("\nPatient: " + name + " - Consulted Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
        addPatient(patient);
    }

    public void displayPatients() {
        System.out.println("\nDr. " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospital() {
        System.out.println("\nHospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.getName());
        }
        System.out.println("\nPatients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Howard");
        Doctor doctor2 = new Doctor("Leonard");

        Patient patient1 = new Patient("Rajesh");
        Patient patient2 = new Patient("Sheldon");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        patient1.consultDoctor(doctor1);
        patient1.consultDoctor(doctor2);
        patient2.consultDoctor(doctor1);

        hospital.displayHospital();
        doctor1.displayPatients();
        doctor2.displayPatients();
        patient1.displayDoctors();
        patient2.displayDoctors();

//        Rajesh is consulting Dr. Howard
//        Rajesh is consulting Dr. Leonard
//        Sheldon is consulting Dr. Howard
//
//        Hospital: City Hospital
//        Doctors:
//        Dr. Howard
//        Dr. Leonard
//
//        Patients:
//        Rajesh
//                Sheldon
//
//        Dr. Howard - Patients:
//        Rajesh
//                Sheldon
//
//        Dr. Leonard - Patients:
//        Rajesh
//
//        Patient: Rajesh - Consulted Doctors:
//        Dr. Howard
//        Dr. Leonard
//
//        Patient: Sheldon - Consulted Doctors:
//        Dr. Howard


    }
}
