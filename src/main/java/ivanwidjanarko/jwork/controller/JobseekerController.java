package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import static ivanwidjanarko.jwork.DatabaseJobseeker.jobseekerLogin;

/**
 * Class for JobseekerController
 *
 * @author Ivan Widjanarko
 * @version 24-05-2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * method for index page
     * @param name name
     * @return String
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    /**
     * method for get jobseeker by id
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
     * method for register job
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
     * method for jobseeker login
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
    public Boolean removeJobseeker(@RequestParam(value = "id") int id){
        Boolean jobseeker = DatabaseJobseekerPostgre.removeJobseeker(id);
        return jobseeker;
    }
}
