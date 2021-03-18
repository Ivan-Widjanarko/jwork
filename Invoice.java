
/**
 * Class for Invoice
 *
 * @author Ivan Widjanarko
 * @version 18-03-2021
 */
public class Invoice
{
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }

    /**
     * method for getId
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getIdJob
     */
    public int getIdJob()
    {
        return idJob;
    }
    
    /**
     * method for getDate
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * method for getTotalFee
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * method for getJobseeker
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * method for setId
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setIdJob
     */
    public void setIdJob(int idJob)
    {
        this.idJob = idJob;
    }
    
    /**
     * method for setDate
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * method for setTotalFee
     */
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
    /**
     * method for setJobseeker
     */
    public void setJobseeeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * method for printData
     */
    public void printData()
    {
        
    }
}
