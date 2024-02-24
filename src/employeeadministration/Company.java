
package employeeadministration;

import java.util.ArrayList;
import java.util.Iterator;

public class Company {
    static private String companyName;
    static private Employee employee = new Employee();
    static private ArrayList<Employee> staff = new ArrayList<>();

    public Company() {
        this.companyName = "Trump";
    }
    
    public Company(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public static void addNewStaff(Employee employee){
        staff.add(employee);
    }
    
    public static void getStaffNumber(){
        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i).getNextEmpNum());
        }
    }
    
    public static void listEmployee(int num){
        Iterator<Employee> listEmp = staff.iterator();
        while(listEmp.hasNext()) {
            System.out.println(listEmp.next().getNextEmpNum());
        }
        if(listEmp.next().getNextEmpNum() == num){
            System.out.println(listEmp.next().getName());
        }
    }
}
