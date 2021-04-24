
/**
 * Class for Bonus
 *
 * @author Ivan Widjanarko
 * @version 10-04-2021
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
     * @param minTotalFee Minimal of Total Fee
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
     * method for getId
     * @return    Jobseeker's ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * method for getReferralCode
     * @return    Referral Code
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    
    /**
     * method for getExtraFee
     * @return    Extra Fee
     */
    public int getExtraFee()
    {
        return extraFee;
    }
    
    /**
     * method for getMinTotalFee
     * @return    Minimal of Total Fee
     */
    public int getMinTotalFee()
    {
        return minTotalFee;
    }
    
    /**
     * method for getActive
     * @return    false
     */
    public boolean getActive()
    {
        return active;
    }
    
    /**
     * method for setId
     * @param id Bonus' ID
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * method for setReferralCode
     * @param referralCode Referral Code
     */
    public void setReferral(String referralCode)
    {
        this.referralCode = referralCode;
    }
    
    /**
     * method for setExtraFee
     * @param extraFee Extra Fee
     */
    public void setExtraFee(int extraFee)
    {
        this.extraFee = extraFee;
    }
    
    /**
     * method for setMinTotalFee
     * @param minTotalFee Minimal of Total Fee
     */
    public void setMinTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * method for setActive
     * @param active Bonus' Status
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    /**method for print detail*/
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
