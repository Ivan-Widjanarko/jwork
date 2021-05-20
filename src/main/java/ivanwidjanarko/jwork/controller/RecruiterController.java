package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for RecruiterController
 *
 * @author Ivan Widjanarko
 * @version 20-05-2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    @RequestMapping(value = "")
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiter.getRecruiterDatabase();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }
        return recruiter;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="phoneNumber") String phoneNumber,
                            @RequestParam(value="province") String province,
                            @RequestParam(value="city") String city,
                            @RequestParam(value="description") String description)
    {
        Location location = new Location(province, city, description);
        Recruiter recruiter = new Recruiter(DatabaseRecruiter.getLastId()+1, name, email, phoneNumber, location);
        DatabaseRecruiter.addRecruiter(recruiter);
        return recruiter;
    }

}
