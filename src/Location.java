
/**
 * Class for Location
 *
 * @author Ivan Widjanarko
 * @version 10-04-2021
 */
public class Location
{
    private String province, city, description;

    /**
     * Constructor for objects of class Location
     * @param province Recruiter's province
     * @param city Recruiter's city
     * @param description Recruiter's description
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * method for getProvince
     * @return    Recruiter's province
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * method for getCity
     * @return    Recruiter's city
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * method for getDescription
     * @return    Recruiter's description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * method for setProvince
     * @param province Recruiter's province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * method for setCity
     * @param city Recruiter's city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * method for setDescription
     * @param description Recruiter's description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**method for print detail*/
    public String toString(){
        String value =  "===================== LOCATION =====================" + "\n" +
            "Province = " + province + "\n" +
            "City = " + city + "\n" +
            "Description = " + description + "\n";
        return value;
    }
}