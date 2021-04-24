import java.util.ArrayList;

/**
 * Class for DatabaseJobseeker
 *
 * @author Ivan Widjanarko
 * @version 22 -04-2021
 */
public class DatabaseJobseeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    /**
     * method for getJobseekerDatabase
     * @return    JOBSEEKER_DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
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
     * method for getJobseekerById
     * @param id Jobseeker ID
     * @return    returnObject
     */
    public static Jobseeker getJobseekerById(int id)
    {
        Jobseeker returnObject = null;
        for(Jobseeker jobseekerObject: JOBSEEKER_DATABASE)
        {
            if(jobseekerObject.getId() == id)
            {
                returnObject = jobseekerObject;
            }
        }
        return returnObject;
    }

    /**
     * method for addJobseeker
     * @param jobseeker Jobseeker
     * @return    JOBSEEKER_DATABASE.add(jobseeker)
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        for(Jobseeker jobseekerObject: JOBSEEKER_DATABASE)
        {
            if(jobseekerObject.getEmail() == jobseeker.getEmail())
            {
                return false;
            }
        }
        lastId = jobseeker.getId();
        return JOBSEEKER_DATABASE.add(jobseeker);
    }

    /**
     * method for removeJobseeker
     * @param id Jobseeker ID
     * @return    boolean
     */
    public static boolean removeJobseeker(int id)
    {
        return JOBSEEKER_DATABASE.removeIf(jobseeker -> jobseeker.getId() == id);
    }
}
