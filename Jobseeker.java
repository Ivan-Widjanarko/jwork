
/**
 * Class for Jobseeker
 *
 * @author Ivan Widjanarko
 * @version 18-03-2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password, joinDate;
    
    /**
     * Constructor for objects of class Jobseeker
     * @param id Jobseeker's ID
     * @param name Jobseeker's name
     * @param email Jobseeker's email
     * @param password Jobseeker's password
     * @param joinDate Date when the Jobseeker join the app
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
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
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * method for setId
     * @param ID Jobseeker's ID
     */
    public void setId(int id)
    {
        
    }
    
    /**
     * method for setName
     * @param name Jobseeker's name
     */
    public void setName(String name)
    {
        
    }
    
    /**
     * method for setEmail
     * @param email Jobseeker's email
     */
    public void setEmail(String email)
    {
        
    }
    
    /**
     * method for setPassword
     * @param password Jobseeker's password
     */
    public void setPassword(String password)
    {
        
    }
    
    /**
     * method for setJoinDate
     * @param joinDate Date when the Jobseeker join the app
     */
    public void setJoinDate(String joinDate)
    {
        
    }
    
    /*method for print Jobseeker's name*/
    public void printData()
    {
        System.out.println(name);
    }
}
    