package PayRoll;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

interface PaymentType {
    double get_pay(Payment_slip p);
    public void say();
}

class Commision_type implements PaymentType {
    private ArrayList<sales_receipt> sales;
    public final int sales_rate = 100;
    public double salary;

    public Commision_type (double salary)
    {
        this.salary = salary;
    }

    public void say()
    {
        System.out.println("Commision Type");
    }
    
    public double get_pay(Payment_slip p)
    {
        double total = salary;

        for(sales_receipt t : sales)
        {
            if(check(p.date))
            {
                total += Calculate((t));
                sales.remove(t);
            }
        }

        return total;
    }

    public void add_sales(sales_receipt s)
    {
        sales.add(s);
    }

    public Boolean check(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        return (day == 5);
    }

    public double Calculate(sales_receipt t)
    {
        double sales = t.sales/100;
        double total = sales*sales_rate;
        return total;
    }
}

class Salary_type implements PaymentType {
    
    public double salary;
    public Date previous_date = null;

    public Salary_type(double salary)
    {
        this.salary = salary;
    }

    public void say()
    {
        System.out.println("Salary Type");
    }

    public double get_pay(Payment_slip p)
    {
        double total = 0.0;

        if(check(p.date))
        {
            total += salary;
        }

        previous_date = p.date;
        return total;
    }
    
    public Boolean check(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int month = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int month1 = cal.get(Calendar.MONTH);

        return (month != month1);
    }
}

class Hour_type implements PaymentType {
    private ArrayList<TimeCard> card;
    public double hourly_rate;

    public Hour_type(double rate)
    {
        this.hourly_rate = rate;
    }

    public void say()
    {
        System.out.println("Hourly Type");
    }
   
    public double get_pay(Payment_slip p)
    {   
        double total = 0.0;

        for(TimeCard t : card)
        {
            if(check(p.date))
            {
                total += Calculate((t));
                card.remove(t);
            }
        }

        if(card.size() == 0)
        {
            System.out.println("Time Card Empty");
        }

        return total;
    }

    public void add_timecard(TimeCard t)
    {
        card.add(t);
    }

    public Boolean check(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        return (day == 5);
    }

    public double Calculate(TimeCard t)
    {
        double extra_hours = Math.max(0.0,t.hours - 8);
        double normal = t.hours - extra_hours;

        double total = hourly_rate*normal +
            hourly_rate*1.5*extra_hours;

        return total;
    }
}