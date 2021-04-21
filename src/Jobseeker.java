import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for Jobseeker
 *
 * @author Ivan Widjanarko
 * @version 10-04-2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password;
    public Calendar joinDate;
    
    /**
     * Constructor for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     * @param joinDate Calendar when the Jobseeker join the app
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * Constructor for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     * @param year Year of Join
     * @param month Month of Join
     * @param dayOfMonth Day of Join
     */
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    /**
     * Constructor for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     */
    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.password = password;
        joinDate = Calendar.getInstance();
    }

    /**
     * method for getId
     * @return id Jobseeker's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getName
     * @return name Jobseeker's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * method for getEmail
     * @return    Jobseeker's email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * method for getPassword
     * @return    Jobseeker's password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * method for getJoinDate
     * @return    Date when the Jobseeker join the app
     */
    public Calendar getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * method for setId
     * @param ID Jobseeker's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setName
     * @param name Jobseeker's name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * method for setEmail
     * @param email Jobseeker's email
     */
    public void setEmail(String email)
    {
        String pattern = "^[\\w&*~]+(\\.?[\\w&*~]+)*@[^\\-][\\w&*~.-]+$";
        if(Pattern.matches(pattern, email)){
            this.email = email;
        }
        else{
            this.email = "";
        }
    }
    
    /**
     * method for setPassword
     * @param password Jobseeker's password
     */
    public void setPassword(String password)
    {
        String pattern = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])\\w.{6,}";
        if(Pattern.matches(pattern, password)){
            this.password = password;
        }
        else{
            this.password = "";
        }
    }
    
    /**
     * method for setJoinDate
     * @param joinDate Date when the Jobseeker join the app
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * method for setJoinDate
     * @return    Date when the Jobseeker join the app
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate.set(year, month-1, dayOfMonth);
    }
    
    /**method for print detail*/
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            
        String value = "===================== JOBSEEKER =====================" + "\n" +
            "Id = " + id + "\n" +
            "Nama = " + name + "\n" +
            "Email = " + email + "\n" +
            "Password = " + password + "\n" +
            "Join Date = " + sdf.format(joinDate.getTime()) + "\n";
        
            
        return value;
    }
}
    