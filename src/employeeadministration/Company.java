package employeeadministration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Company{

    //Setting constructors as private for security 
    private String companyName;
    //Creation of HashSet for bonus challenge
    private HashSet<Employee> staffSet = new HashSet<Employee>();
    //ArrayList implemented as it will be allocating every employee created
    private ArrayList<Employee> staff = new ArrayList<Employee>();
    
    public Company() {
        this.companyName = "Epic Games";
    }
    //Constructor for company name with a parameter
    public Company(String companyName) {
        this.companyName = setCompanyName(companyName);
    }
    
    //Company name accesor
    public String getCompanyName() {
        return companyName;
    }
    
    //setCompanyName setter for privacy and security
    public String setCompanyName(String company) {
        this.companyName = company;
        return companyName;
    }
    
    
    //addNewStaff method implemented for adding new employee to arrayList by the Manager
    public void addNewStaff(Employee person) {
        
        try{
            //adding new staff method will work if the employee has a valid email address. For security this condition has been implemented
            if(person.getEmail() != null){
                
                //For HashSet - Bonus Challenge
                staffSet.add(person);
                
                //adding the employee to ArrayList and displaying employee information
                staff.add(person);
                System.out.println("Employee " + person.getName() + " has been added to the list");
            }
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    //getStaffNumber method implemented in order to get the size of the ArrayList to display it on terminal
    public void getStaffNumber() {
        try{
            System.out.println("There are " + staff.size() + " Employees within the Array List");
            System.out.println();
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    //getCompleteList method added in order to get all information stored in ArrayList and also, it has been created for TESTING PURPOSES
    public void getCompleteList() {
        try{
            System.out.println();
            System.out.println(companyName + " Company has the following employees:");
            //Iterating our ArrayList with Iterator object and displaying all information from ArrayList
            Iterator<Employee> listEmp = staff.iterator();

            while (listEmp.hasNext()) {
                Employee employee = listEmp.next();
                System.out.println(employee.getEmpNum() + " " + employee.getName() + " " + employee.getEmail());
            }
            System.out.println();
        }catch (Exception e){
            System.out.print(e);
        }
    }
    //getCompleteList accesor method added in order to get employee names above than number provided
    public void getListEmployee(int num) {
        try{
            //Iterating our ArrayList with Iterator object and displaying all information from ArrayList
            Iterator<Employee> listEmp = staff.iterator();
            System.out.println("Employees with a higher employee number than " + num + " are:");
            while (listEmp.hasNext()) {
                Employee employee = listEmp.next();
                //If EmpNum is greater than provided num, names will be displayed
                if (employee.getEmpNum() > num) {
                    System.out.println(employee.getName());
                }
            }
        }catch (Exception e){
            System.out.print(e);
        }
    }
    
    //removeStaff method implemented in order to remove a selected employee by its employee number
    public void removeStaff(int empNum){
        try{
            //Iterating our ArrayList with Iterator object in order to find the employee selected for removing
            Iterator<Employee> listEmp = staff.iterator();
            //boolean finder used to show whether employee exists or not.
            boolean finder = false;
            
            while (listEmp.hasNext()) {
                Employee employee = listEmp.next();
                //if employee does exist, will be removed.
                if (employee.getEmpNum() == empNum) {
                    System.out.println("Employee " + employee.getName() + " has been removed");
                    System.out.println();
                    listEmp.remove();
                    finder = true;
                } 
                
            }
            //if does not exist a "employee not found" will be displayed.
            if(finder == false)System.out.println("Sorry, employee not found");
        }catch (Exception e){
            System.out.print(e);
        }
    }
}
