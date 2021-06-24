package ivanwidjanarko.jwork;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static ivanwidjanarko.jwork.DatabaseConnectionPostgre.connection;

/**
 * Class for Database Invoice Postgre
 *
 * @author Ivan Widjanarko
 * @version 22-06-2021
 */
public class DatabaseInvoicePostgre {

    private static Connection c = null;
    private static Statement stmt = null;

    /**
     * Method for get Invoice's Database
     * @return    Array List of Invoice
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        ArrayList<Invoice> invoiceObject = new ArrayList<>();
        Invoice value = null;
        Connection c = connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM invoice_jobseeker_bonus;");
            while (rs.next()) {
                int invoice_id = rs.getInt("invoice_id");
                int invoice_jobs = rs.getInt("invoice_jobs");
                int jobseeker_id = rs.getInt("jobseeker_id");
                String jobseeker_name = rs.getString("jobseeker_name");
                String jobseeker_email = rs.getString("jobseeker_email");
                String jobseeker_password = rs.getString("jobseeker_password");
                Date jobseker_join_date = rs.getDate("jobseker_join_date");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(jobseker_join_date);
                int bonus_id = rs.getInt("bonus_id");
                int bonus_extra_fee = rs.getInt("bonus_extra_fee");
                int bonus_min_total_fee = rs.getInt("bonus_min_total_fee");
                boolean bonus_active = rs.getBoolean("bonus_active");
                int invoice_admin_fee = rs.getInt("invoice_admin_fee");
                String invoice_category = rs.getString("invoice_category");
//                value = new Invoice(invoice_id,  invoice_jobs, new Jobseeker(jobseeker_id, jobseeker_name, jobseeker_email, jobseeker_password, calendar)) {
//                    @Override
//                    public PaymentType getPaymentType() {
//                        if (invoice_category.equals("bank")) {
//                            return PaymentType.BankPayment;
//                        }
//                        return PaymentType.EwalletPayment;
//                    }
//
//                    @Override
//                    public void setTotalFee() {
//                        if (invoice_category.equals("bank")) {
//                            if(invoice_admin_fee != 0)
//                            {
//                                for(Job job: getJobs())
//                                {
//                                    totalFee += job.getFee();
//                                }
//                                totalFee -= invoice_admin_fee;
//                            }
//                            else
//                            {
//                                for(Job job: getJobs())
//                                {
//                                    totalFee += job.getFee();
//                                }
//                            }
//                        }
//                        else {
//                            int total = 0;
//                            for(Job job: getJobs())
//                                total += job.getFee();
//                            if(bonus_id != 0 && bonus_active && total > bonus_min_total_fee)
//                            {
//                                totalFee = total + bonus_extra_fee;
//                            }
//                            else
//                            {
//                                totalFee = total;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public String toString() {
//                        return null;
//                    }
//                };
//                invoiceObject.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return invoiceObject;
    }

    /**
     * Method for get Last ID from Invoice's Database
     * @return    last ID
     */
    public static int getLastId() {
        int value = 0;
        c = connection();
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) FROM invoice;");
            while (rs.next()) {
                value = rs.getInt("max");
            }
            rs.close();
            stmt.close();
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
        return value;
    }

    /**
     * Method for add Invoice (Bank Payment) into database
     * @param invoice Bank Payment's Invoice
     * @return invoice addition status
     * @throws OngoingInvoiceAlreadyExistsException Exception if Ongoing Invoice already exists
     */
    public static Invoice addInvoiceBank (BankPayment invoice) throws OngoingInvoiceAlreadyExistsException {
        c = connection();
        try {
            int count = 0;
            stmt = c.createStatement();
            int id = invoice.getId();
            int jobs = invoice.getJobs().get(0).getId();
            Calendar cal = invoice.getDate();
            cal.add(Calendar.DATE, 0);
            Date date = cal.getTime();
            int adminFee = invoice.getAdminFee();
            int totalFee = invoice.getTotalFee();
            int jobseekerId = invoice.getJobseeker().getId();
            PaymentType paymentType = invoice.getPaymentType();
            InvoiceStatus invoiceStatus = invoice.getInvoiceStatus();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String invoiceDate = sdf.format(date);

            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM invoice WHERE invoice_status = '" + invoiceStatus +
                    "' AND jobseeker_id = " + jobseekerId +
                    ") AS invoice_status;");
            while (rs.next()) {
                count = rs.getInt("count");
            }
            if (count != 0) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
            else {
                String query = "INSERT INTO invoice (id, jobs, jobseeker_id, admin_fee, invoice_category, invoice_status, date, total_fee)"
                        + "VALUES (" + id + "," + jobs + "," + jobseekerId + "," + adminFee + ",'" + paymentType + "','" + invoiceDate + "'," + totalFee + ");";
                stmt.executeUpdate(query);
                stmt.close();
            }
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            return null;
        }
        return invoice;
    }

    /**
     * Method for add Invoice (E-Wallet Payment) into database
     * @param invoice E-Wallet Payment's Invoice
     * @return invoice addition status
     * @throws OngoingInvoiceAlreadyExistsException Exception if Ongoing Invoice already exists
     */
    public static Invoice addInvoiceEwallet (EwalletPayment invoice) throws OngoingInvoiceAlreadyExistsException {
        c = connection();
        try {
            int count = 0;
            stmt = c.createStatement();
            int id = invoice.getId();
            int jobs = invoice.getJobs().get(0).getId();
            Calendar cal = invoice.getDate();
            cal.add(Calendar.DATE, 0);
            Date date = cal.getTime();
            int bonusId = invoice.getBonus().getId();
            int totalFee = invoice.getTotalFee();
            int jobseekerId = invoice.getJobseeker().getId();
            Calendar jobseekerJoinDate = invoice.getJobseeker().getJoinDate();
            PaymentType paymentType = invoice.getPaymentType();
            InvoiceStatus invoiceStatus = invoice.getInvoiceStatus();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String invoiceDate = sdf.format(date);
            String invoiceJobseekerJoinDate = sdf.format(jobseekerJoinDate);

            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM" +
                    "(SELECT * FROM invoice WHERE invoice_status = '" + invoiceStatus +
                    "' AND jobseeker_id = " + jobseekerId +
                    ") AS invoice_status;");
            while (rs.next()) {
                count = rs.getInt("count");
            }
            if (count != 0) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
            else {
                String query = "INSERT INTO invoice (id, jobs, jobseeker_id, bonus_id, invoice_category, invoice_status, date, total_fee)"
                        + "VALUES (" + id + "," + jobs + "," + jobseekerId + "," + bonusId + ",'" + paymentType + "','" + invoiceDate + "'," + totalFee + ");";
                stmt.executeUpdate(query);
                stmt.close();
            }
            c.close();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            return null;
        }
        return invoice;
    }
}
