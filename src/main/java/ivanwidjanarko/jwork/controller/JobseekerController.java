package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

/**
 * Class for JobseekerController
 *
 * @author Ivan Widjanarko
 * @version 25-06-2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Method for index page
     * @param name name
     * @return String
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    /**
     * Method for get jobseeker by id
     * @param id Jobseeker's ID
     * @return jobseeker
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseekerPostgre.getJobseekerById(id);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    /**
     * Method for register as jobseeker
     * @param name Jobseeker's Name
     * @param email Jobseeker's Email
     * @param password Jobseeker's Password
     * @return jobseeker
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastId()+1, name, email, password);
        try {
            DatabaseJobseekerPostgre.addJobseeker(jobseeker);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    /**
     * Method for jobseeker to login
     * @param email Jobseeker's Email
     * @param password Jobseeker's Password
     * @return Database Jobseeker
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.jobseekerLogin(email, password);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeJobseeker(@PathVariable(value = "id") int id) throws JobseekerNotFoundException {
        return DatabaseJobseekerPostgre.removeJobseeker(id);
    }
}
