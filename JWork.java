public class JWork
{
    public static void main(String [] args)
    {
        Location locationIvan = new Location("DKI Jakarta", "Depok", "Ivan's House");
        Recruiter recruiterIvan = new Recruiter(1806148706, "Ivan", "ivan@ui.ac.id", "085780736569", locationIvan);
        Job jobIvan = new Job(1806148706, "Programmer", recruiterIvan, 10000000, "Engineer");
        Jobseeker jobseekerWidjanarko = new Jobseeker(1806148706, "Widjanarko", "widjanarko@ui.ac.id", "123456", "18-03-2021");
        Invoice invoiceWidjanarko = new Invoice(1806148707, 369, "18-03-2021", 10000000, jobseekerWidjanarko);
    }
}
