import java.util.ArrayList;

/**
 * Class for DatabaseJob
 *
 * @author Ivan Widjanarko
 * @version 22 -04-2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * method for getJobDatabase
     * @return    JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    /**
     * method for getLastId
     * @return    lastId
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method for getJobById
     * @param id Job ID
     * @return    returnObject
     */
    public static Job getJobById(int id)
    {
        Job returnObject = null;
        for(Job jobObject: JOB_DATABASE)
        {
            if(jobObject.getId() == id)
            {
                returnObject = jobObject;
            }
        }
        return returnObject;
    }

    /**
     * method for getJobByRecruiter
     * @param recruiterId Recruiter ID
     * @return    returnObject
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        ArrayList<Job> returnObject = null;
        for(Job jobObject: JOB_DATABASE)
        {
            if(jobObject.getRecruiter().getId() == recruiterId)
            {
                returnObject.add(jobObject);
            }
        }
        return returnObject;
    }

    /**
     * method for getJobByCategory
     * @param category Job Category
     * @return    returnObject
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        ArrayList<Job> returnObject = new ArrayList<Job>();
        for(Job jobObject: JOB_DATABASE)
        {
            if(jobObject.getCategory() == category)
            {
                returnObject.add(jobObject);
            }
        }
        return returnObject;
    }

    /**
     * method for addJob
     * @param job Job
     * @return    JOB_DATABASE.add(job)
     */
    public static boolean addJob(Job job)
    {
        lastId = job.getId();
        return JOB_DATABASE.add(job);
    }

    /**
     * method for removeJob
     * @param id Job ID
     * @return    boolean
     */
    public static boolean removeJob(int id)
    {
        return JOB_DATABASE.removeIf(job -> job.getId() == id);
    }
}
