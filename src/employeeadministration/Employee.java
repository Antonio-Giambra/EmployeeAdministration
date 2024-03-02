package employeeadministration;

public class Employee {
    
    //Setting variables as private for security 
    private String name;
    private String email;
    private int empNum;
    private static int nextEmpNum = 1;
    private String username;
    private String password;
    
    //Constructor created in order to create an employee when parameters are no provided from main class
    public Employee() {
        this.name = "Sam Ronaldo";
        this.email = "samro@gmail.com";
        //Calling setNextEmpNum method for validation
        this.empNum = setNextEmpNum(nextEmpNum++);
    }
    
    //Contructor created in order to create an employee when parameters are provided
    public Employee(String fullName, String email) {
        this.name = fullName;
        //calling email validator
        this.email = emailChecker(email);
        this.empNum = setNextEmpNum(nextEmpNum++);
    }
    //Contructor created in order to create a manager employee when parameters are provided
    public Employee(String fullName, String email, String username, String password) {
        this.name = fullName;
        this.email = emailChecker(email);
        //Calling setUsername and setPassword methods for validation
        this.username = setUsername(username);
        this.password = setPassword(password);
        this.empNum = setNextEmpNum(nextEmpNum++);
    }
    
    //name accesor
    public String getName() {
        return name;
    }
    //email accesor
    public String getEmail() {
        return email;
    }
    //username accesor
    public String getUsername() {
        return username;
    }
    //password accesor
    public String getPassword() {
        return password;
    }
    //Employee number accesor
    public int getEmpNum() {
        return empNum;
    }
    //NextEmployee Number accesor
    public int getNextEmpNum() {
        return nextEmpNum;
    }
    //setUsername setter for privacy and security
    public String setUsername(String setUsername) {
        this.username = setUsername;
        return username;
    }
    //setPassword setter for privacy and security
    public String setPassword(String setPassword) {
        this.password = setPassword;
        return password;
    }
    //setName setter for privacy and security
    public void setName(String name) {
        this.name = name;
    }
    //setEmail setter for privacy and security
    public void setEmail(String email) {
            this.email = emailChecker(email);
    }
    //setNextEmpNum setter for privacy and security
    public int setNextEmpNum(int nextEmpNum) {
        this.empNum = nextEmpNum;
        return empNum; 
    }
    //emailCheker method implemented in order to receive a valid email in our database
    public static String emailChecker(String email){
        //regexPattern does mean that the email should allow teh following characteristics
        //numeric values from o to 9
        //uppercase and lowercase letters from a to z are allowed
        //underscore and hyphen and dot
        //consecutive dots are not allowed
        //64 characteres are allowed
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        
        //if email is correct return email to the class if not return null and it will be evaluated within company class
        if(email.matches(regexPattern)){
            return email;
        }
        return null;
    }
    
}
