package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for DatabaseJobseeker
 *
 * @author Ivan Widjanarko
 * @version 20-05-2021
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
     * @throws JobseekerNotFoundException Exception for Jobseeker
     */
    public static Jobseeker getJobseekerById(int id) throws JobseekerNotFoundException
    {
        Jobseeker returnObject = null;
        for(Jobseeker jobseekerObject: JOBSEEKER_DATABASE)
        {
            if(jobseekerObject.getId() == id)
            {
                returnObject = jobseekerObject;
            }
        }
        if (returnObject == null) {
            throw new JobseekerNotFoundException(id);
        } else {
            return returnObject;
        }
    }

    /**
     * method for addJobseeker
     * @param jobseeker Jobseeker
     * @return    JOBSEEKER_DATABASE.add(jobseeker)
     * @throws EmailAlreadyExistsException Exception for Email
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        for(Jobseeker jobseekerObject: JOBSEEKER_DATABASE)
        {
            if(jobseekerObject.getEmail() == jobseeker.getEmail())
            {
                throw new EmailAlreadyExistsException(jobseekerObject);
            }
        }
        lastId = jobseeker.getId();
        return JOBSEEKER_DATABASE.add(jobseeker);
    }

    /**
     * method for removeJobseeker
     * @param id Jobseeker ID
     * @return    boolean
     * @throws JobseekerNotFoundException Exception for Jobseeker
     */
    public static boolean removeJobseeker(int id) throws JobseekerNotFoundException
    {
        if (JOBSEEKER_DATABASE.removeIf(job -> job.getId() == id)) {
            return true;
        } else {
            throw new JobseekerNotFoundException(id);
        }
    }

    /**
     * method for jobseekerLogin
     * @param email Jobseeker Email
     * @param password Jobseeker Password
     * @return    Jobseeker
     */
    public static Jobseeker jobseekerLogin(String email, String password)
    {
        for(Jobseeker jobseeker: JOBSEEKER_DATABASE)
        {
            if(jobseeker.getEmail().equals(email) && jobseeker.getPassword().equals(password))
            {
                return jobseeker;
            }
        }
        return null;
    }
}