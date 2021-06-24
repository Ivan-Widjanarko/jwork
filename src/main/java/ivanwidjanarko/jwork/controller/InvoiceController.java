package ivanwidjanarko.jwork.controller;

import ivanwidjanarko.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class for InvoiceController
 *
 * @author Ivan Widjanarko
 * @version 25-06-2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Method for get all invoice
     * @return  Database Invoice
     */
    @RequestMapping(value = "")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * Method for get invoice by ID
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
     * Method for get invoice by jobseeker's ID
     * @param jobseekerId Jobseeker's ID
     * @return Database Invoice
     */
    @RequestMapping("/jobseeker/{jobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId) {
        return DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * Method for change invoice status
     * @param id Invoice's ID
     * @param status Invoice's Status
     * @return invoice
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
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
     * Method for remove invoice
     * @param id Invoice's ID
     * @return boolean
     */
    @RequestMapping(name = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        boolean status = false;
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            if(invoice.getId() == id)
            {
                DatabaseInvoice.getInvoiceDatabase().remove(invoice);
                status = true;
            }
        }
        if(status == false)
        {
            InvoiceNotFoundException e = new InvoiceNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return status;
    }

    /**
     * Method for add bank payment invoice
     * @param jobIdList List of Job ID
     * @param jobseekerId   Jobseeker's ID
     * @param adminFee Administration Fee
     * @return Bank Payment's Invoice
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee", defaultValue="0") int adminFee)
    {
        BankPayment bankPayment = null;
        try {
            ArrayList<Job> arrayJob = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJobPostgre.getJobById(id);
                arrayJob.add(job);
            }
            bankPayment = new BankPayment(DatabaseInvoice.getLastId()+1, arrayJob, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
            bankPayment.setTotalFee();
            DatabaseInvoice.addInvoice(bankPayment);
        }

        catch (OngoingInvoiceAlreadyExistsException | JobseekerNotFoundException | JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return bankPayment;
    }

    /**
     * Method for add e-wallet payment invoice
     * @param jobIdList List of Job ID
     * @param jobseekerId   Jobseeker's ID
     * @param referralCode Referral Code
     * @return E-Wallet Payment's Invoice
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="referralCode", defaultValue="") String referralCode)
    {
        EwalletPayment ewalletPayment = null;
        try {
            ArrayList<Job> arrayJob = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJobPostgre.getJobById(id);
                arrayJob.add(job);
            }
            ewalletPayment = new EwalletPayment(DatabaseInvoice.getLastId()+1, arrayJob, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
            ewalletPayment.setTotalFee();
            DatabaseInvoice.addInvoice(ewalletPayment);
        }

        catch (OngoingInvoiceAlreadyExistsException | JobseekerNotFoundException | JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return ewalletPayment;
    }
}
