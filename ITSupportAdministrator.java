import java.util.Random;

class Employee {
    String firstName;
    String lastName;
    String department;
    String emailAddress;
    String password;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class CredentialService {
    public static String generatePassword() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }

    public static String generateEmailAddress(Employee employee) {
        return employee.firstName.toLowerCase() + employee.lastName.toLowerCase() + "@" + employee.department.toLowerCase() + ".abc.com";
    }

    public static void showCredentials(Employee employee) {
        System.out.println("Dear " + employee.firstName + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + employee.emailAddress);
        System.out.println("Password ---> " + employee.password);
    }
}

public class ITSupportAdministrator {
    public static void createCredentials(String firstName, String lastName, String department) {
        Employee employee = new Employee(firstName, lastName);
        employee.department = department;
        employee.password = CredentialService.generatePassword();
        employee.emailAddress = CredentialService.generateEmailAddress(employee);
        CredentialService.showCredentials(employee);
    }

    public static void main(String[] args) {
        // Creating credentials for a new hire
        createCredentials("Harshit", "Choudary", "Tech");
    }
}