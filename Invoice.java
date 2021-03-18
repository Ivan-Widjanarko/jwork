
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
     * @param id Jobseeker's ID
     * @param idJob Job's ID
     * @param date Date of Invoice
     * @param totalFee Total of Fee
     * @param jobseeker Jobseeker Information
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
     * @return    Jobseeker's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getIdJob
     * @return    Job's ID
     */
    public int getIdJob()
    {
        return idJob;
    }
    
    /**
     * method for getDate
     * @return    Date of Invoice
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * method for getTotalFee
     * @return    Total of Fee
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * method for getJobseeker
     * @return    Jobseeker Information
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * method for setId
     * @param id Jobseeker's ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setIdJob
     * @param idJob Job's ID
     */
    public void setIdJob(int idJob)
    {
        this.idJob = idJob;
    }
    
    /**
     * method for setDate
     * @param date Date of Invoice
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * method for setTotalFee
     * @param totalFee Total of Fee
     */
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
    /**
     * method for setJobseeker
     * @param jobseeker Jobseeker Information
     */
    public void setJobseeeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**method for printData*/
    public void printData()
    {
        
    }
}
