package PayRoll;

interface PaymentMethod {
    void send_receipt(Payment_slip p);
}

class Bank_account implements PaymentMethod
{
    public void send_receipt(Payment_slip p)
    {
        System.out.println("Payment Date " + p.date);
        System.out.println("Gross Pay " + p.gross_pay);
        System.out.println("Deducations " + p.deductions);
        System.out.println("Net Pay " + p.net_pay);
    }
}