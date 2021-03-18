
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
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getName
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * method for getEmail
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * method for getPassword
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * method for getJoinDate
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * method for setId
     */
    public void setId(int id)
    {
        
    }
    
    /**
     * method for setName
     */
    public void setName(String name)
    {
        
    }
    
    /**
     * method for setEmail
     */
    public void setEmail(String email)
    {
        
    }
    
    /**
     * method for setPassword
     */
    public void setPassword(String password)
    {
        
    }
    
    /**
     * method for setJoinDate
     */
    public void setJoinDate(String joinDate)
    {
        
    }
    
    /**
     * method for printData
     */
    public void printData()
    {
        System.out.println(name);
    }
}
    