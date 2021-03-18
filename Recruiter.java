
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
     * @param id Recruiter's ID
     * @param name Recruiter's name
     * @param email Recruiter's email
     * @param phoneNumber Recruiter's phone number
     * @param location Recruiter's location
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
     * @return    Recruiter's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getName
     * @return    Recruiter's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * method for getEmail
     * @return    Recruiter's email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * method for getPhoneNumber
     * @return    Recruiter's phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * method for getLocation
     * @return    Recruiter's location
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * method for setId
     * @param id Recruiter's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setEmail
     * @param email Recruiter's email
     */
    public void setEmail(String email)
    {
        this.name = name;
    }
    
    /**
     * method for setName
     * @param name Recruiter's name
     */
    public void setName(String name)
    {
        this.email = email;
    }
    
    /**
     * method for setPhoneNumber
     * @param phoneNumber Recruiter's phone number
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * method for setLocation
     * @param location Recruiter's location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**method for print Recruiter's nama*/
    public void printData()
    {
        System.out.println(name);
    }
}
