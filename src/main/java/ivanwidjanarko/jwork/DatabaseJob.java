package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for Database Job
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * Method for get Job's Database
     * @return    Array List of JOB_DATABASE
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    /**
     * Method for get Last ID from Job's Database
     * @return    last ID
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method for get Job by its ID
     * @param id Job's ID
     * @return    job
     * @throws JobNotFoundException Exception if Job not found
     */
    public static Job getJobById(int id) throws JobNotFoundException
    {
        Job returnObject = null;
        for(Job jobObject: JOB_DATABASE)
        {
            if(jobObject.getId() == id)
            {
                returnObject = jobObject;
            }
        }
        if (returnObject == null) {
            throw new JobNotFoundException(id);
        } else {
            return returnObject;
        }
    }

    /**
     * Method for get job by Recruiter's ID
     * @param recruiterId Recruiter's ID
     * @return    job
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        ArrayList<Job> returnObject = new ArrayList<Job>();
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
     * Method for get job by Its Category
     * @param category Job's Category
     * @return    job
     */
    public static ArrayList<Job> getJobByCategory(String category)
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
     * Method for add Job into database
     * @param job Job
     * @return job addition status
     */
    public static boolean addJob(Job job)
    {
        lastId = job.getId();
        return JOB_DATABASE.add(job);
    }

    /**
     * Method for remove the job from database
     * @param id Job's ID
     * @return    job deletion status
     * @throws JobNotFoundException Exception if Job not found
     */
    public static boolean removeJob(int id) throws JobNotFoundException
    {
        if (JOB_DATABASE.removeIf(job -> job.getId() == id)) {
            return true;
        } else {
            throw new JobNotFoundException(id);
        }
    }
}
