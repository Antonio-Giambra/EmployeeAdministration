package employeeadministration;

import java.util.Scanner;

//-----------------------------------GITHUB REPOSITORY---------------------------------------//
//------------- https://github.com/Antonio-Giambra/EmployeeAdministration -------------------//
//-------------------------------------------------------------------------------------------//

public class EmployeeAdministration {
    
//--------------------------Class Employee Test which create 3 employees----------------------//
    public static void EmployeeTest(int num, Company company) {
        Employee person1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee person2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee person3 = new Employee("Tom Thumb", "tt@gmail.com");
        
        //Array to keep our employees in this method
        Employee[] projectGroup = new Employee[3];
        projectGroup[0] = person1;
        projectGroup[1] = person2;
        projectGroup[2] = person3;
        company.addNewStaff(person1);
        company.addNewStaff(person2);
        company.addNewStaff(person3);
        
        //Printing out the value of variable nextEmpNum to the terminal window. 
        System.out.println("---------------------------------------------------------Printing out the value of variable nextEmpNum to the terminal window. --------------------------------------------------------------------------");
        
        System.out.println(projectGroup[projectGroup.length -1].getNextEmpNum());

        
        //Searching and displaying the name of each employee
        System.out.println("------------------Searching and displaying the name of each of the employees in the projectGroup array who have an employee number above the value stored in a variable called m.------------------------");
        //Searching and displaying the name of each of the employees in the projectGroup array who have an employee number above the value stored in a variable called m.
        for (int i = 0; i < projectGroup.length; i++) {
            if (projectGroup[i].getEmpNum() > num) {
                //Looping each employee in order to get their name
                System.out.println(projectGroup[i].getName());
            }

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        try{
        //Creating our company
        Company myCompany = new Company("Activision");
        
        //Calling employeeTest method
        int m = 1;
        EmployeeTest(m, myCompany);
        
        //Creation of 4 employee and adding them to company employee class, one of them should be the manager. This has been created for TESTING PURPOSES
        Employee person4 = new Employee("Donal Trump", "donT@gmail.com");
        Employee person5 = new Employee("Cillian Murphy", "cmurphy@gmail.com");
        Employee person6 = new Employee("Toretto Sanchez", "Toretico@gmail.com");
        Employee manager = new Employee("Antonio Giambra", "antonio@gmail.com","Gnomeo","smurf");
        myCompany.addNewStaff(person4);
        myCompany.addNewStaff(person5);
        myCompany.addNewStaff(person6);
        myCompany.addNewStaff(manager);
        
        //Implementing a menu for the operator (Manager)
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to Employee Administration System \n\nPlease introduce your username with capital letter if needed:");
        String username = sc.nextLine();
        System.out.println();
        System.out.println("Please introduce your password with capital letter if needed:");
        String password = sc.nextLine();
        //Once username and password is received they should match with employee 7 who is the manager. For this a simple if has been implemented
        if(username.equals(manager.getUsername()) && password.equals(manager.getPassword())){
            //trigger for while loop
            boolean trigger = false;
     
            while(trigger == false){
                System.out.println();
                System.out.println("Welcome " + manager.getName() + "\n Press 1 - to check the complete staff list \n Press 2 - to add a new staff \n Press 3 - to check the number of employees currently in the list \n Press 4 - to view employees with employee number above the provided number \n Press 5 - to remove a staff member \n Press 6 - to exit the system");
                //Getting selected option and storing in option integer
                int option = sc.nextInt();
                //Menu option managed by a switch cases
                switch(option){
                    //-----------CHECKING ALL STAFF IN THE LIST --------/
                    case 1:
                        //Calling getCompleteList() in order to get displayed all information in our ArrayList at Company class
                        try{
                            myCompany.getCompleteList();
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    //----------ADDING A NEW STAFF IN THE LIST ---------//
                    case 2:
                        try{
                            //Variable for storing new employee's name
                            String empName;
                            //Variable for storing new employee's email
                            String email;
                            System.out.println("Please enter employee name and surname");
                            //Since Scanner.nextInt() does not read the newline character in the input, Scanner.nextLine() called to returns after reading that newline.
                            sc.nextLine();
                            //Storing data entered by user
                            empName = sc.nextLine();
                            //For TESTING PURPOSES employees name should be longer than 3 characteres
                            if(empName.length() > 3){
                                System.out.println();
                                System.out.println("Please enter employee email. You must enter a valid email as example@gmail.com");
                                //Calling our email checker in Employee class in order to verify if the email comply with requirements
                                email = Employee.emailChecker(sc.nextLine());
                                
                                //If employee emailChecker return a verified email, then addNewStaff method in Company class is called.
                                if(!(email == null)) myCompany.addNewStaff(new Employee(empName,email)); 
                                else System.out.println("Sorry, the email entered does not comply with the requirements");
                                break;
                            }else System.out.println("Sorry, the name entered should not be shorter than 3 letters");
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    //--------------DISPLAYING THE NUMBER OF EMPLOYEES CURRENTLY IN THE LIST------------///
                    case 3:
                        try{
                            //Calling getStaffNumber() in order to get displayed the ArrayList length at Company class
                            System.out.println();
                            myCompany.getStaffNumber();
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                   //-----------DISPLAYING EMPLOYEES WITH EMPLOYEE NUMBER ABOVE OF THE PROVIDED NUMBER -------------//
                    case 4:
                        try{
                            System.out.println("Please a enter number equal or greater than 0");
                            //Since Scanner.nextInt() does not read the newline character in the input, Scanner.nextLine() called to returns after reading that newline.
                            sc.nextLine();
                            //Storing provided number in variable number
                            int number = Integer.parseInt(sc.nextLine());
                            //if number is less than ArrayList size and greater than 0, it is possible to call getListEmployee accessor
                            if(number >= 0){
                                myCompany.getListEmployee(number);
                                break;
                            }else{
                                System.out.println("Sorry, your number must be greater than 0");
                                break;
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    //-------------REMOVING AN EMPLOYEE FROM THE LIST---------------//
                    case 5:
                        try{
                            System.out.println();
                            System.out.println("Please enter the employee number which will be removed");
                            //Storing provided number in variable number
                            //int numberTest = Integer.parseInt(sc.nextLine());
                            //Calling removeStaff method at Company class in order to remove the employee with employee number equals to number
                            myCompany.removeStaff(sc.nextInt());
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    //-------------CLOSING PROGRAM--------------//
                    case 6:
                        try{
                            System.out.println();
                            System.out.println("Thank you for using this system. You have been logged out.");
                            //Activating our trigger in order to exit the while loop
                            trigger = true;
                            break;
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    default:
                        System.out.println();
                        System.out.println("You must enter a valid number");
                }
            }
        }else{
            System.out.println();
            System.out.println("Sorry, username or password is incorrect");
        }
       //closing the scanner
       sc.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }

}
