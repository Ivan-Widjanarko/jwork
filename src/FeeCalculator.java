/**
 * Class for FeeCalculator
 *
 * @author Ivan Widjanarko
 * @version 06-05-2021
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
     * method for run
     */
    @Override
    public void run() {
        System.out.println("Calculating invoice ID: " + invoice.getId());
        invoice.setTotalFee();
        System.out.println("Finish calculating invoice ID: " + invoice.getId());
    }
}
