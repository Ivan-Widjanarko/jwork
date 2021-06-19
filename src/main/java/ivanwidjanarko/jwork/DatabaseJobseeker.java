package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for Database Jobseeker
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseJobseeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    /**
     * Method for get Jobseeker's Database
     * @return    Array List of JOBSEEKER_DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }

    /**
     * Method for get Last ID from Jobseeker's Database
     * @return    last ID
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method for get jobseeker by its ID
     * @param id Jobseeker's ID
     * @return    jobseeker
     * @throws JobseekerNotFoundException Exception if Jobseeker not found
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
     * Method for add Jobseeker into database
     * @param jobseeker Jobseeker
     * @return job addition status
     * @throws EmailAlreadyExistsException Exception if Email already exists
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
     * Method for remove the jobseeker from database
     * @param id Jobseeker's ID
     * @return    jobseeker deletion status
     * @throws JobseekerNotFoundException Exception if Job not found
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
     * Method for jobseeker to login
     * @param email Jobseeker's Email
     * @param password Jobseeker's Password
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
