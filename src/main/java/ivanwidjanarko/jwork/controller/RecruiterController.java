package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for RecruiterController
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Method for get all recruiter
     * @return Database Recruiter Postgre
     */
    @RequestMapping(value = "")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * Method for get recruiter by id
     * @param id Recruiter's ID
     * @return recruiter
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiterPostgre.getRecruiterById(id);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return recruiter;
    }

    /**
     * Method for add recruiter
     * @param name Recruiter's Name
     * @param email Recruiter's Email
     * @param phoneNumber Recruiter's Phone Number
     * @param province Recruiter's Location (Province)
     * @param city Recruiter's Location (City)
     * @param description Recruiter's Location (Description)
     * @return recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="phoneNumber") String phoneNumber,
                            @RequestParam(value="province") String province,
                            @RequestParam(value="city") String city,
                            @RequestParam(value="description") String description)
    {
        Location location = new Location(province, city, description);
        Recruiter recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastId()+1, name, email, phoneNumber, location);
        DatabaseRecruiterPostgre.addRecruiter(recruiter);
        return recruiter;
    }
}
