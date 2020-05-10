package PayRoll;
import java.util.Date;

class Payment_slip 
{
    public double gross_pay;
    public double deductions;
    public double net_pay;
    public Date date;

    public Payment_slip(Date date)
    {
        this.date = date;
    }

}

class service_slip
{
    public Date date;
    public double charge;
}
