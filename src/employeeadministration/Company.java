package employeeadministration;

import java.util.HashSet;
import java.util.Iterator;

public class Company{

    private String companyName;
    private HashSet<Employee> staff = new HashSet<Employee>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void addNewStaff(Employee hola) {
        staff.add(hola);
        System.out.println("Employee " + hola.getName() + " has been added to the list");
        System.out.println();
    }

    public void getStaffNumber() {
        for ( Employee employee : staff){
            System.out.println(employee.getEmpNum());
        }
    }
    
    public void getListEmployee() {
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            System.out.println(employee.getEmpNum() + " " + employee.getName() + " " + employee.getEmail());
        }
    }
    public void getListEmployee(int num) {
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            if (employee.getEmpNum() == num) {
                System.out.println(employee.getName());
            }
        }
    }
    
    public void removeStaff(int empNum){
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            if (employee.getEmpNum() == empNum) {
                System.out.println("Employee " + employee.getName() + " has been removed");
                listEmp.remove();
            }
        }
    }
}
