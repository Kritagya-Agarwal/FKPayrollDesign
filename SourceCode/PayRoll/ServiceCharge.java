package PayRoll;

import java.util.Date;


public class ServiceCharge {
    public int emp_id;
    public Date date;
    public double charge;
    public Database db;

    public ServiceCharge(Database db, int emp_id, Date date, double charge)
    {
        this.date = date;
        this.emp_id = emp_id;
        this.charge = charge;
        this.db = db;
    }

    public void add()
    {
        Employee e = db.find_Employee(emp_id);
        service_slip s = new service_slip();
        s.date = this.date;
        s.charge = this.charge;
        e.add_union_slip(s);
    }
}