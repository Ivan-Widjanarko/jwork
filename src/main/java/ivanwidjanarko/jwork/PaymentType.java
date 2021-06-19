package ivanwidjanarko.jwork;

/**
 * Enumeration class for Payment's Type
 *
 * @author Ivan Widjanarko
 * @version 19-06-2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"),
    EwalletPayment("Ewallet Payment");

    /**
     * Method for set payment's type
     */
    private String paymentType;

    /**
     * Method for get payment's type
     * @param paymentType payment's type
     */
    PaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    /**
     * Method for print payment type's detail
     * @return payment's type
     */
    public String toString(){
        return paymentType;
    }
}
