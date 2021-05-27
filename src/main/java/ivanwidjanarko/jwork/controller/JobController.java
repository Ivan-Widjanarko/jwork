package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for JobController
 *
 * @author Ivan Widjanarko
 * @version 27-05-2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * method for get all job
     * @return Database Job
     */
    @RequestMapping(value = "")
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }

    /**
     * method for get job by id
     * @param id Job's ID
     * @return job
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    /**
     * method for get job by recruiter id
     * @param recruiterId Recruiter's ID
     * @return Database Job
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    /**
     * method for get job by category
     * @param category Job's Category
     * @return Database Job
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    /**
     * method for add job
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
                                       @RequestParam(value="category") JobCategory category)
    {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(recruiterId);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }

        Job job = new Job(DatabaseJob.getLastId()+1, name, recruiter, fee, category);
        DatabaseJob.addJob(job);
        return job;
    }
}
