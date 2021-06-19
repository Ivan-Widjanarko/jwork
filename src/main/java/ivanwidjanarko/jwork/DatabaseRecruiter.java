package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for Database Recruiter
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * Method for get Recruiter's Database
     * @return    Array List of RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
    }

    /**
     * Method for get Last ID from Recruiter's Database
     * @return    last ID
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method for get Recruiter by its ID
     * @param id Recruiter's ID
     * @return    recruiter
     * @throws RecruiterNotFoundException Exception if Job not found
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException
    {
        Recruiter returnObject = null;
        for(Recruiter recruiterObject: RECRUITER_DATABASE)
        {
            if(recruiterObject.getId() == id)
            {
                returnObject = recruiterObject;
            }
        }
        if (returnObject == null) {
            throw new RecruiterNotFoundException(id);
        } else {
            return returnObject;
        }
    }

    /**
     * Method for add Recruiter into database
     * @param recruiter Recruiter
     * @return recruiter addition status
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        lastId = recruiter.getId();
        return RECRUITER_DATABASE.add(recruiter);
    }

    /**
     * Method for remove the recruiter from database
     * @param id recruiter's ID
     * @return    recruiter deletion status
     * @throws RecruiterNotFoundException Exception if Job not found
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException
    {
        if (RECRUITER_DATABASE.removeIf(job -> job.getId() == id)) {
            return true;
        } else {
            throw new RecruiterNotFoundException(id);
        }
    }
}
