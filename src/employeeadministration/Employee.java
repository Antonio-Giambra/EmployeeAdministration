package employeeadministration;

public class Employee {

    private String name;
    private String email;
    private static int empNum = 1;
    private int nextEmpNum;
    private String username;
    private String password;

    public Employee() {
        this.name = "Antonio";
        this.email = "antonio@gmail.com";
        this.nextEmpNum = empNum++;
    }

    public Employee(String fullName, String email) {
        this.name = fullName;
        this.email = emailChecker(email);
        this.nextEmpNum = setNextEmpNum(empNum++);
    }
    public Employee(String fullName, String email, String username, String password) {
        this.name = fullName;
        this.email = emailChecker(email);
        this.username = setUsername(username);
        this.password = password;
        this.nextEmpNum = setNextEmpNum(empNum++);
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getEmpNum() {
        return empNum;
    }

    public int getNextEmpNum() {
        return nextEmpNum;
    }

    public String setUsername(String setUsername) {
        this.username = setUsername;
        return username;
    }

    public String setPassword(String setPassword) {
        this.password = setPassword;
        return password;
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
    
    public int setNextEmpNum(int empNum) {
        this.nextEmpNum = empNum;
        return nextEmpNum;
        
    }
}
