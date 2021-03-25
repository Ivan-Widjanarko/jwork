
/**
 * Class for Job
 *
 * @author Ivan Widjanarko
 * @version 25-03-2021
 */
public class Job
{
    private int id, fee;
    private String name;
    private Recruiter recruiter;
    private JobCategory category;
    
    /**
     * Constructor for objects of class Job
     * @param id Recruiter's ID
     * @param name Jobs's name
     * @param recruiter Recruiter Information
     * @param fee Recruiter's fee
     * @param category Job's category
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
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
     * @return    Jobs's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * method for getFee
     * @return    Recruiter's fee
     */
    public int getFee()
    {
        return fee;
    }
    
    /**
     * method for getCategory
     * @return   Job's category
     */
    public JobCategory getCategory()
    {
        return category;
    }
    
    /**
     * method for getRecruiter
     * @return    Recruiter Information
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
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
     * method for setName
     * @param name Jobs's name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * method for setRecruiter
     * @param recruiter Recruiter Information
     */
    public void setRecuiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    
    /**
     * method for setFee
     * @param fee Recruiter's fee
     */
    public void setFee(int Fee)
    {
        this.fee = fee;
    }
    
    /**
     * method for setCategory
     * @param category Job's category
     */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }
    
    /**method for print Job's Description*/
    public void printData()
    {
        System.out.println("===================== JOB =====================");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Recruiter: " + getRecruiter().getName());
        System.out.println("City: " + getRecruiter().getLocation().getCity());
        System.out.println("Fee: " + fee);
        System.out.println("Category: " + category.toString());
    }
}
