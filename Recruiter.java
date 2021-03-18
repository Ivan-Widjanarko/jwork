
/**
 * Class for Recruiter
 *
 * @author Ivan Widjanarko
 * @version 18-03-2021
 */
public class Recruiter
{
    private int id;
    private String name, email, phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Recruiter
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * method for getPhoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * method for getLocation
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * method for setId
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setEmail
     */
    public void setEmail(String email)
    {
        this.name = name;
    }
    
    /**
     * method for setName
     */
    public void setName(String name)
    {
        this.email = email;
    }
    
    /**
     * method for setPhoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * method for setLocation
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
     * method for printData
     */
    public void printData()
    {
        System.out.println(name);
    }
}
