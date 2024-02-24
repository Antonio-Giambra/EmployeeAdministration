package employeeadministration;

import java.util.ArrayList;

public class EmployeeAdministration {

    public static void EmployeeTest(int num) {
        Employee perons1 = new Employee("Joe Bloggs", "jb@gmail.com");
        Employee perons2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee perons3 = new Employee("Tom Thumb", "tt@gmail.com");

        ArrayList<Employee> projectGroup = new ArrayList<>();
        projectGroup.add(perons1);
        projectGroup.add(perons2);
        projectGroup.add(perons3);
        
        //Printing out the value of variable nextEmpNum to the terminal window. 
        for (int i = 0; i < projectGroup.size(); i++) {
            System.out.println(projectGroup.get(i).getNextEmpNum());

        }
        //Searching and displaying the name of each of the employees in the projectGroup array who have an employee number above the value stored in a variable called m.
        for (int i = 0; i < projectGroup.size(); i++) {
            if (projectGroup.get(i).getNextEmpNum() == num) {
                System.out.println(projectGroup.get(i).getName());
            }

        }

    }

    public static void main(String[] args) {
        int m = 1;
        EmployeeTest(m);
    }

}
