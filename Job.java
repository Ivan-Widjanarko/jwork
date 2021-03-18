
/**
 * Class for Job
 *
 * @author Ivan Widjanarko
 * @version 18-03-2021
 */
public class Job
{
    private int id, fee;
    private String name, category;
    private Recruiter recruiter;
    
    /**
     * Constructor for objects of class Job
     */
    public Job(int id, String name, Recruiter recruiter, int fee, String category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
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
     * method for getFee
     */
    public int getFee()
    {
        return fee;
    }
    
    /**
     * method for getCategory
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     * method for getRecruiter
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    
    /**
     * method for setId
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setName
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * method for setRecruiter
     */
    public void setRecuiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    
    /**
     * method for setFee
     */
    public void setFee(int Fee)
    {
        this.fee = fee;
    }
    
    /**
     * method for setCategory
     */
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    /**
     * method for printData
     */
    public void printData()
    {
        
    }
}
