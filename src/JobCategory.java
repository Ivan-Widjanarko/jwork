
/**
 * Enumeration class for JobCategory
 *
 * @author Ivan Widjanarko
 * @version 25-03-2021
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
    
    private String jobCategory;
    
    JobCategory(String jobCategory)
    {
        this.jobCategory = jobCategory;
    }
    
    public String toString(){
        return jobCategory;
    }
}
