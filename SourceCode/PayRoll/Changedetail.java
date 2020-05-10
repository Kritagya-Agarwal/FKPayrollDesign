package PayRoll;

public abstract class Changedetail {
    private int emp_id;
    public Database db;

    public Changedetail(Database db,int emp_id)
    {
        this.emp_id = emp_id;
        this.db = db;
    }

    public void apply()
    {
        Employee e = db.find_Employee(emp_id);

        if(e != null)
        {
            apply_change(e);
        }
        else{
            // Throw Exception
        }
    }

    protected abstract void apply_change(Employee e);
}

class ChangeName extends Changedetail {
    private String name;

    public ChangeName(Database db, String name, int emp_id)
    {
        super(db, emp_id);
        this.name = name;
    }

    protected void apply_change(Employee e)
    {
        e.emp_name = name;
    }
}

abstract class ChangePaymentType extends Changedetail {
    public ChangePaymentType(Database db, int emp_id)
    {
        super(db, emp_id);
    }

    protected void apply_change(Employee e)
    {
        e.paymenttype = get_type();
        e.schedule = get_schedule();
    }

    protected abstract PaymentType get_type();
    protected abstract PaymentSchedule get_schedule();
}

class ChangeHourlyType extends ChangePaymentType
{
    private double hour_rate ;

    public ChangeHourlyType(double hour_rate, Database db, int emp_id)
    {
        super(db, emp_id);
        this.hour_rate = hour_rate;
    }

    protected PaymentType get_type()
    {
        return new Hour_type(hour_rate);
    }

    protected PaymentSchedule get_schedule()
    {
        return new Weekly();
    }
}

class ChangeSalaryType extends ChangePaymentType
{
    private double salary ;

    public ChangeSalaryType(double hour_rate, Database db, int emp_id)
    {
        super(db, emp_id);
        this.salary = hour_rate;
    }

    protected PaymentType get_type()
    {
        return new Salary_type(salary);
    }

    protected PaymentSchedule get_schedule()
    {
        return new Monthly_schedule();
    }
}

class ChangeCommisionType extends ChangePaymentType
{
    private double salary ;

    public ChangeCommisionType(double hour_rate, Database db, int emp_id)
    {
        super(db, emp_id);
        this.salary = hour_rate;
    }

    protected PaymentType get_type()
    {
        return new Commision_type(salary);
    }

    protected PaymentSchedule get_schedule()
    {
        return new BiWeekly();
    }
}