package PayRoll;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
    public int emp_id;
    public String emp_name;
    public String emp_address;
    public PaymentType paymenttype;
    public PaymentMethod paymentmethod;
    public PaymentSchedule schedule;
    private Boolean isMember;
    private ArrayList<service_slip> union_slip;

    Employee(int emp_id, String emp_name, String emp_address)
    {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.isMember = false;
        union_slip = new ArrayList<service_slip>();
    }

    public Boolean valid_paydate(Date date)
    {
        return schedule.valid(date);
    }

    public void add_union_slip(service_slip s)
    {
        union_slip.add(s);
    }

    public void make_payment(Payment_slip p)
    {
        double gross = paymenttype.get_pay(p);
        double deductions = calculate(p);
        double net = gross - deductions;

        p.gross_pay = gross;        
        p.net_pay = net;
        p.deductions = deductions;
        paymentmethod.send_receipt(p);
    }

    private double calculate(Payment_slip p)
    {
        double total = 0.0;

        for(int i = 0 ; i < union_slip.size() ; i++)
        {
            service_slip s = union_slip.get(i);
            total += s.charge;
        }

        for(int i = 0 ; i < union_slip.size() ; i++)
        {
            union_slip.get(i);
        }

        return total;
    }

    public void remove_union()
    {
        union_slip.clear();
    }
}