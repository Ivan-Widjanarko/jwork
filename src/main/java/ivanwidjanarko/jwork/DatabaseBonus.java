package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for Database Bonus
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class DatabaseBonus
{
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * Method for get Bonus' Database
     * @return    Array List of BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
    }

    /**
     * Method for get Last ID from Bonus' Database
     * @return    last ID
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method for get bonus by its ID
     * @param id Bonus' ID
     * @return    bonus
     * @throws BonusNotFoundException Exception if Bonus not found
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException
    {
        Bonus returnObject = null;
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getId() == id)
            {
                returnObject = bonusObject;
            }
        }
        if (returnObject == null) {
            throw new BonusNotFoundException(id);
        } else {
            return returnObject;
        }
    }

    /**
     * Method for get Bonus by Its Referral Code
     * @param referralCode Referral Code
     * @return    bonus
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Bonus returnObject = null;
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getReferralCode().equals(referralCode))
            {
                returnObject = bonusObject;
            }
        }
        return returnObject;
    }

    /**
     * Method for add Bonus into database
     * @param bonus Bonus
     * @return    bonus addition status
     * @throws ReferralCodeAlreadyExistsException Exception if Referral Code already exists
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException
    {
        for(Bonus bonusObject: BONUS_DATABASE)
        {
            if(bonusObject.getReferralCode() == bonus.getReferralCode())
            {
                throw new ReferralCodeAlreadyExistsException(bonusObject);
            }
        }
        lastId = bonus.getId();
        return BONUS_DATABASE.add(bonus);
    }

    /**
     * Method for activate the bonus
     * @param id Bonus' ID
     * @return    bonus activation status
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
     * Method for deactivate the bonus
     * @param id Bonus' ID
     * @return    bonus deactivation status
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
     * Method for remove the bonus from database
     * @param id Bonus' ID
     * @return    bonus deletion status
     * @throws BonusNotFoundException Exception if Bonus not found
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException
    {
        if (BONUS_DATABASE.removeIf(job -> job.getId() == id)) {
            return true;
        } else {
            throw new BonusNotFoundException(id);
        }
    }
}
