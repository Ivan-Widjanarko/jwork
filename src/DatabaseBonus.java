import java.util.ArrayList;

/**
 * Class for DatabaseBonus
 *
 * @author Ivan Widjanarko
 * @version 05-05-2021
 */
public class DatabaseBonus
{
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * method for getBonusDatabase
     * @return    BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
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
     * method for getBonusById
     * @param id Bonus ID
     * @return    returnObject
     */
    public static Bonus getBonusById(int id)
    {
        Bonus returnObject = null;
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getId() == id)
            {
                returnObject = bonusObject;
            }
        }
        return returnObject;
    }

    /**
     * method for getBonusByReferralCode
     * @param referralCode Referral Code
     * @return    returnObject
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Bonus returnObject = null;
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getReferralCode() == referralCode)
            {
                returnObject = bonusObject;
            }
        }
        return returnObject;
    }

    /**
     * method for addBonus
     * @param bonus Bonus
     * @return    BONUS_DATABASE.add(bonus)
     */
    public static boolean addBonus(Bonus bonus)
    {
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getReferralCode() == bonus.getReferralCode())
            {
                return false;
            }
        }
        lastId = bonus.getId();
        return BONUS_DATABASE.add(bonus);
    }

    /**
     * method for activateBonus
     * @param id Bonus ID
     * @return    false
     */
    public static boolean activateBonus(int id)
    {
        for(Bonus bonus: BONUS_DATABASE) {
            if (bonus.getId() == id) {
                bonus.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * method for deactivateBonus
     * @param id Bonus ID
     * @return    false
     */
    public static boolean deactivateBonus(int id)
    {
        for(Bonus bonus: BONUS_DATABASE) {
            if (bonus.getId() == id) {
                bonus.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * method for removeBonus
     * @param id Bonus ID
     * @return    false
     */
    public static boolean removeBonus(int id)
    {
        return BONUS_DATABASE.removeIf(bonus -> bonus.getId() == id);
    }
}
