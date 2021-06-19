package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for JobController
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * Method for get all job
     * @return Database Job Postgre
     */
    @RequestMapping(value = "")
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    /**
     * Method for get job by id
     * @param id Job's ID
     * @return job
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        try {
            job = DatabaseJobPostgre.getJobById(id);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    /**
     * Method for get job by recruiter id
     * @param recruiterId Recruiter's ID
     * @return Database Job Postgre
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public Job getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Method for get job by category
     * @param category Job's Category
     * @return Database Job
     */
    @RequestMapping("/category/{category}")
    public Job getJobByCategory(@PathVariable String category) {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    /**
     * Method for add job
     * @param name Job's Name
     * @param recruiterId  Recruiter's ID
     * @param fee Fee
     * @param category Job's Category
     * @return job
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                                       @RequestParam(value="recruiterId") int recruiterId,
                                       @RequestParam(value="fee") int fee,
                                       @RequestParam(value="category") String category)
    {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(recruiterId);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }

        Job job = new Job(DatabaseJobPostgre.getLastId()+1, name, recruiter, fee, category);
        DatabaseJobPostgre.addJob(job);
        return job;
    }
}
