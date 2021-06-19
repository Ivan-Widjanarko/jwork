package ivanwidjanarko.jwork;

/**
 * Enumeration class for Job's Category
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public enum JobCategory
{
    WebDeveloper("Web Developer"),
    FrontEnd("Front End"),
    BackEnd("Back End"),
    UI("User Interface"),
    UX("User Experience"),
    Devops("Development and Operations"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    /**
     * Method for set job's category
     */
    private final String jobCategory;

    /**
     * Method for get job's category
     * @param jobCategory job's category
     */
    JobCategory(String jobCategory)
    {
        this.jobCategory = jobCategory;
    }

    /**
     * Method for print job category's detail
     * @return job's category
     */
    public String toString(){
        return jobCategory;
    }
}
