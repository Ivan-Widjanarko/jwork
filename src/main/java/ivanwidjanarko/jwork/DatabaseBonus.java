package ivanwidjanarko.jwork;

import java.util.ArrayList;

/**
 * Class for DatabaseBonus
 *
 * @author Ivan Widjanarko
 * @version 18-05-2021
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
     * @throws BonusNotFoundException Exception for Bonus
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
     * @throws ReferralCodeAlreadyExistsException Exception for Referral Code
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
     * @throws BonusNotFoundException Exception for Bonus
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
