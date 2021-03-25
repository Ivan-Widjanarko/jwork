
/**
 * Enumeration class for PaymentType
 *
 * @author Ivan Widjanarko
 * @version 25-03-2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"),
    EwalletPayment("Ewallet Payment");
    
    private String paymentType;
    
    PaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }
    
    public String toString(){
        return paymentType;
    }
}