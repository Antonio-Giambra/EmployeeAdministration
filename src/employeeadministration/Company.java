package employeeadministration;

import java.util.ArrayList;
import java.util.Iterator;

public class Company extends Employee{

    private String companyName;
    private ArrayList<Employee> staff = new ArrayList();

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
    }

    public void getStaffNumber() {
        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i).getNextEmpNum());
        }
    }
    
    public void getListEmployee() {
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            System.out.println(employee.getNextEmpNum() + " " + employee.getName() + " " + employee.getEmail());
        }
    }
    public void getListEmployee(int num) {
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            if (employee.getNextEmpNum() == num) {
                System.out.println(employee.getName());
            }
        }
    }
    
    public void removeStaff(int empNum){
        Iterator<Employee> listEmp = staff.iterator();
        
        while (listEmp.hasNext()) {
            Employee employee = listEmp.next();
            if (employee.getNextEmpNum() == empNum) {
                System.out.println("Employee " + employee.getName() + " has been removed");
                staff.remove(employee);
            }
        }
    }
}
