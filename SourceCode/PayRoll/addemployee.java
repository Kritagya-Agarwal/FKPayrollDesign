package PayRoll;

public abstract class addemployee {
    public Database db;
    public String emp_name;
    public int emp_id;
    public String emp_address;

    public addemployee(Database db,int emp_id, String emp_name, String emp_address) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.emp_address = emp_address;
        this.db = db;
    }

    protected abstract PaymentType make_pay_type();
    protected abstract PaymentSchedule get_schedule();

    public void create() {
        PaymentType pt = make_pay_type();
        PaymentSchedule ps = get_schedule();
        PaymentMethod pm = new Bank_account();
        Employee e = new Employee(emp_id, emp_name, emp_address);
        e.paymenttype = pt;
        e.schedule = ps;
        e.paymentmethod = pm;
        db.addEmployee(e);
    }
}

class Salary_emp extends addemployee {

    private double salary;

    public Salary_emp(Database db, int id, String name, String address, double salary) {
        super(db, id, name, address);
        this.salary = salary;
    }

    protected PaymentType make_pay_type() {
        return new Salary_type(salary);
    }

    protected PaymentSchedule get_schedule()
    {
        return new Monthly_schedule();
    }
}

class Hourly_emp extends addemployee {

    private double hour_salary;
    public Hourly_emp(Database db, int id, String name, String address, double salary) {
        super(db, id, name, address);
        this.hour_salary = salary;
    }
    
    protected PaymentType make_pay_type() {
        return new Hour_type(hour_salary);
    }

    protected PaymentSchedule get_schedule()
    {
        return new Weekly();
    }
}

class Commision_emp extends addemployee {
    
    private double salary;
    public Commision_emp(Database db, int id, String name, String address, double salary) {
        super(db, id, name, address);
        this.salary = salary;
    }

    protected PaymentType make_pay_type() {
        return new Commision_type(salary);
    }

    protected PaymentSchedule get_schedule()
    {
        return new BiWeekly();
    }
}