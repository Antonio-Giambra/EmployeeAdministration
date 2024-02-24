
package employeeadministration;

public class Employee {
    private String name;
    private String email;
    private static int empNum = 1;
    private int nextEmpNum = empNum;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmpNum() {
        return empNum;
    }
    
    public int getNextEmpNum(){
        return nextEmpNum;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
    }
    public Employee() {
        this.name = "Antonio";
        this.email = "antonio@gmail.com";
        this.nextEmpNum = empNum++;
    }
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.nextEmpNum = empNum++;
    }
}
