package ivanwidjanarko.jwork;

/**
 * Class for Fee Calculator (Thread)
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */

public class FeeCalculator implements Runnable{
    private Invoice invoice;

    /**
     * Constructor for class FeeCalculator
     * @param invoice Invoice
     */
    FeeCalculator (Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Method for run the fee calculator
     */
    @Override
    public void run() {
        System.out.println("Calculating invoice ID: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finish calculating invoice ID: " + invoice.getId());
    }
}
