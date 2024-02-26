package employeeadministration;

public class Employee {

    private String name;
    private String email;
    private int empNum;
    private static int nextEmpNum = 1;
    private String username;
    private String password;

    public Employee() {
        this.name = "Antonio";
        this.email = "antonio@gmail.com";
        this.empNum = setNextEmpNum(nextEmpNum++);
    }

    public Employee(String fullName, String email) {
        this.name = fullName;
        this.email = emailChecker(email);
        this.empNum = setNextEmpNum(nextEmpNum++);
    }
    public Employee(String fullName, String email, String username, String password) {
        this.name = fullName;
        this.email = emailChecker(email);
        this.username = setUsername(username);
        this.password = setPassword(password);
        this.empNum = setNextEmpNum(nextEmpNum++);
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
    
    public static String emailChecker(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        
        if(email.matches(regexPattern)){
            return email;
        }
        return null;
    }
    
    public int setNextEmpNum(int nextEmpNum) {
        this.empNum = nextEmpNum;
        return empNum;
        
    }
}
