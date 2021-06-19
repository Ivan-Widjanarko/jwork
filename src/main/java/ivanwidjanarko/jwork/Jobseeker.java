package ivanwidjanarko.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

/**
 * Class for Jobseeker
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password;
    public Calendar joinDate;
    
    /**
     * Constructor 1 for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     * @param joinDate Date when the Jobseeker register for the first time
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
     * Constructor 2 for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     * @param year Year when the Jobseeker register for the first time
     * @param month Month when the Jobseeker register for the first time
     * @param dayOfMonth Day when the Jobseeker register for the first time
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
     * Constructor 3 for objects of class Jobseeker
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
     * Method for get jobseeker's ID
     * @return id Jobseeker's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method for get jobseeker's name
     * @return name Jobseeker's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method for get jobseeker's email
     * @return    Jobseeker's email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Method for get jobseeker's password
     * @return    Jobseeker's password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Method for get date when the Jobseeker register for the first time
     * @return    Date when the Jobseeker register for the first time
     */
    public Calendar getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * Method for set jobseeker's ID
     * @param id Jobseeker's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Method for set jobseeker's name
     * @param name Jobseeker's name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Method for set jobseeler's email
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
     * Method for set jobseeker's password
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
     * Method 1 for set date when the Jobseeker register for the first time
     * @param joinDate Date when the Jobseeker register for the first time
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * Method 2 for set date when the Jobseeker register for the first time
     * @param year Year when the Jobseeker register for the first time
     * @param month Month when the Jobseeker register for the first time
     * @param dayOfMonth Day when the Jobseeker register for the first time
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate.set(year, month-1, dayOfMonth);
    }

    /**
     * Method for print jobseeker's detail
     * @return details
     */
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
    