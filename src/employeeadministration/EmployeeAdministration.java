package employeeadministration;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeAdministration {

    public static void EmployeeTest(int num) {
        Company myCompany = new Company("Trump");
        Employee person1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee person2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee person3 = new Employee("Tom Thumb", "tt@gmail.com");
        Employee person4 = new Employee("Antonio Giambra", "antonio@gmail.com","Gnomeo","smurf");

        ArrayList<Employee> projectGroup = new ArrayList();
        projectGroup.add(person1);
        projectGroup.add(person2);
        projectGroup.add(person3);
        projectGroup.add(person4);
        
        myCompany.addNewStaff(person2);
        myCompany.addNewStaff(person3);
        myCompany.addNewStaff(person1);
        myCompany.addNewStaff(person4);
        
        //Printing out the value of variable nextEmpNum to the terminal window. 
        for (int i = 0; i < projectGroup.size(); i++) {
            System.out.println(projectGroup.get(i).getEmpNum());

        }
        //Searching and displaying the name of each of the employees in the projectGroup array who have an employee number above the value stored in a variable called m.
        for (int i = 0; i < projectGroup.size(); i++) {
            if (projectGroup.get(i).getEmpNum() == num) {
                System.out.println(projectGroup.get(i).getName());
            }

        }

    }

    public static void main(String[] args) {
        Company myCompany = new Company("Trump");
        Employee person1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee person2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee person3 = new Employee("Tom Thumb", "tt@gmail.com");
        Employee person4 = new Employee("Antonio Giambra", "antonio@gmail.com","Gnomeo","smurf");
        myCompany.addNewStaff(person1);
        myCompany.addNewStaff(person2);
        myCompany.addNewStaff(person3);
        myCompany.addNewStaff(person4);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Administration System \n Please introduce your username with capital letter if needed:");
        String username = sc.nextLine();
        System.out.println("Please introduce your password with capital letter if needed:");
        String password = sc.nextLine();
        
        if(username.equals(person4.getUsername()) && password.equals(person4.getPassword())){
            boolean trigger = false;
            String empName;
            String email;
            while(trigger == false){
                System.out.println("Welcome " + person4.getName() + "\n Press 1 - to check the complete staff list \n Press 2 - to check a staff name by its employee number \n Press 3 - to add a new staff \n Press 4 - to remove a staff member \n Press 5 - to exit the system and log out");
                int option = sc.nextInt();
                switch(option){
                    case 1:
                        try{
                            myCompany.getListEmployee();
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    case 2:
                        try{
                            System.out.println("Please enter the employee number which will be showed");
                            myCompany.getListEmployee(sc.nextInt());
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    case 3:
                        try{
                            System.out.println("Please enter employee name and surname");
                            sc.nextLine();
                            empName = sc.nextLine();
                            if(empName.length() > 3){
                                System.out.println("Please enter employee email. You must enter a valid email as example@gmail.com");
                                email = Employee.emailChecker(sc.nextLine());
                                
                                if(!(email == null)) myCompany.addNewStaff(new Employee(empName,email)); 
                                else System.out.println("Sorry, the email entered does not comply with the requirements");
                                break;
                            }else System.out.println("Sorry, the name entered should not be shorter than 3 letters");
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    case 4:
                        try{
                            System.out.println("Please enter the employee number which will be removed");
                            myCompany.removeStaff(sc.nextInt());
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    case 5:
                        try{
                            System.out.println("Thank you for using this system. You are logging out");
                            trigger = true;
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    default:
                        System.out.println("You must enter a valid number");
                }
            }
        }else{
            System.out.println("Sorry, username or password is incorrect");
        }
        
        
    }

}
