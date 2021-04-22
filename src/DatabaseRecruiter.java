import java.util.ArrayList;

/**
 * Class for DatabaseRecruiter
 *
 * @author Ivan Widjanarko
 * @version 22 -04-2021
 */
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * method for getRecruiterDatabase
     * @return RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
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
     * method for getRecruiterById
     * @param id Recruiter ID
     * @return returnObject
     */
    public static Recruiter getRecruiterById(int id)
    {
        Recruiter returnObject = null;
        for(Recruiter recruiterObject: RECRUITER_DATABASE)
        {
            if(recruiterObject.getId() == id)
            {
                returnObject = recruiterObject;
            }
        }
        return returnObject;
    }

    /**
     * method for addRecruiter
     * @param recruiter Recruiter
     * @return RECRUITER_DATABASE.add(recruiter)
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        lastId = recruiter.getId();
        return RECRUITER_DATABASE.add(recruiter);
    }

    /**
     * method for removeRecruiter
     * @param id Recruiter ID
     * @return    RECRUITER_DATABASE.removeIf(recruiter -> recruiter.getId() == id)
     */
    public static boolean removeRecruiter(int id)
    {
        return RECRUITER_DATABASE.removeIf(recruiter -> recruiter.getId() == id);
    }
}
