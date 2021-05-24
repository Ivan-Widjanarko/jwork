package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for InvoiceController
 *
 * @author Ivan Widjanarko
 * @version 24-05-2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * method for get all invoice
     * @return  Database Invoice
     */
    @RequestMapping(value = "")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * method for get invoice by ID
     * @param id Invoice's ID
     * @return invoice
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * method for get invoice by jobseeker's ID
     * @param jobseekerId Jobseeker's ID
     * @return Database Invoice
     */
    @RequestMapping("/recruiter/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * method for change invoice status
     * @param id Invoice's ID
     * @param status Invoice's Status
     * @return invoice
     */
    @RequestMapping(value = "invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") int id,
                      @RequestParam(value="invoiceStatus") InvoiceStatus status)
    {
        Invoice invoice = null;
        try {
            DatabaseInvoice.getInvoiceById(id).setInvoiceStatus(status);
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * method for remove invoice
     * @param id Invoice's ID
     * @return boolean
     */
    @RequestMapping(name = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        Invoice invoice = null;
        try {
            return DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    /**
     * method for add bank payment invoice
     * @param jobIdList List of Job ID
     * @param jobseekerId   Jobseeker's ID
     * @param adminFee Administration Fee
     * @return Bank Payment's Invoice
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee") int adminFee)
    {
        BankPayment bankPayment = null;
        try {
            ArrayList<Job> arrayJob = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJob.getJobById(id);
                arrayJob.add(job);
            }
            bankPayment = new BankPayment(DatabaseInvoice.getLastId()+1, arrayJob, DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
            bankPayment.setTotalFee();
            DatabaseInvoice.addInvoice(bankPayment);
        }

        catch (JobNotFoundException | JobseekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        return bankPayment;
    }

    /**
     * method for add e-wallet payment invoice
     * @param jobIdList List of Job ID
     * @param jobseekerId   Jobseeker's ID
     * @param adminFee Administration Fee
     * @return E-Wallet Payment's Invoice
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee") int adminFee)
    {
        EwalletPayment ewalletPayment = null;
        try {
            ArrayList<Job> arrayJob = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJob.getJobById(id);
                arrayJob.add(job);
            }
            ewalletPayment = new EwalletPayment(DatabaseInvoice.getLastId()+1, arrayJob, DatabaseJobseeker.getJobseekerById(jobseekerId));
            ewalletPayment.setTotalFee();
            DatabaseInvoice.addInvoice(ewalletPayment);
        }

        catch (JobNotFoundException | JobseekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        return ewalletPayment;
    }
}
