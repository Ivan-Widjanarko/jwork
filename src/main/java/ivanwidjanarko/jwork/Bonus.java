package ivanwidjanarko.jwork;

/**
 * Class for Bonus
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public class Bonus
{
    private int id, extraFee, minTotalFee;
    private String referralCode;
    private boolean active;
    

    /**
     * Constructor for objects of class Bonus
     * @param id Bonus' ID
     * @param referralCode Referal Code
     * @param extraFee Extra Fee
     * @param minTotalFee Minimum Amount of the Total Fee
     * @param active Bonus' Status
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * Method for get bonus's ID
     * @return    bonus' ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method for get referral code of the bonus
     * @return    Referral Code
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    
    /**
     * Method for get amount of the extra fee
     * @return    Extra Fee
     */
    public int getExtraFee()
    {
        return extraFee;
    }
    
    /**
     * Method for get minimum amount of the total fee
     * @return    Minimum Amount of the Total Fee
     */
    public int getMinTotalFee()
    {
        return minTotalFee;
    }
    
    /**
     * Method for get bonus' status
     * @return    active
     */
    public boolean getActive()
    {
        return active;
    }
    
    /**
     * Method for set bonus' ID
     * @param id Bonus' ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Method for set referral code of the bonus
     * @param referralCode Referral Code
     */
    public void setReferral(String referralCode)
    {
        this.referralCode = referralCode;
    }
    
    /**
     * Method for set amount of the extra fee
     * @param extraFee Extra Fee
     */
    public void setExtraFee(int extraFee)
    {
        this.extraFee = extraFee;
    }
    
    /**
     * Method for set minimum amount of the total fee
     * @param minTotalFee Minimum Amount of teh Total Fee
     */
    public void setMinTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * Method for set bonus' status
     * @param active Bonus' Status
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    /**
     * Method for print bonus' detail
     * @return details
     */
    public String toString(){
        String value =  "===================== BONUS =====================" + "\n" +
            "ID = " + id + "\n" +
            "Referral Code = " + referralCode + "\n" +
            "Extra Fee = " + extraFee + "\n" +
            "Min Total Fee = " + minTotalFee + "\n" +
            "Active Status = " + active + "\n";
        return value;
    }
}
