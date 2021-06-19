package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for BonusController
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {

    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId;

    /**
     * Method for get all bonus
     * @return Database Bonus Postgre
     */
    @RequestMapping(value = "")
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonusPostgre.getBonusDatabase();
    }

    /**
     * Method for get bonus by referral code
     * @param referralCode Referral Code
     * @return bonus
     */
    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode)
    {
        Bonus bonus = null;
        bonus = DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
        return bonus;
    }

    /**
     * Method for add bonus
     * @param referralCode Referral Code
     * @param extraFee Extra Fee
     * @param minTotalFee Minimal of Total Fee
     * @param active Bonus' Status
     * @return bonus
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                                  @RequestParam(value="extraFee") int extraFee,
                                  @RequestParam(value="minTotalFee") int minTotalFee,
                                  @RequestParam(value="active") boolean active)
    {
        Bonus bonus = null;
        try {
            bonus = new Bonus(DatabaseBonusPostgre.getLastId() + 1, referralCode, extraFee, minTotalFee, active);
            DatabaseBonusPostgre.addBonus(bonus);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return bonus;
    }
}
