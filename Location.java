
/**
 * Class for Location
 *
 * @author Ivan Widjanarko
 * @version 18-03-2021
 */
public class Location
{
    private String province, city, description;

    /**
     * Constructor for objects of class Location
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * method for getProvince
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * method for getCity
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * method for getDescription
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * method for setProvince
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * method for setCity
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * method for setDescription
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * method for printData
     */
    public void printData()
    {
        System.out.println(province);
    }
}
