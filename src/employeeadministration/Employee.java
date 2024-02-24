package employeeadministration;

public class Employee {

    private String name;
    private String email;
    private static int empNum = 1;
    private int nextEmpNum = empNum;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmpNum() {
        return empNum;
    }

    public int getNextEmpNum() {
        return nextEmpNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
            this.email = emailChecker(email);
    }
    
    public String emailChecker(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        
        if(email.matches(regexPattern)){
            return email;
        }
        return null;
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
        this.email = emailChecker(email);
        this.nextEmpNum = empNum++;
    }
}
