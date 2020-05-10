package PayRoll;

import java.util.Date;

class TimeCard {
    public Date date;
    public double hours;

    public TimeCard(Date date, double hours)
    {
        this.hours = hours;
        this.date = date;
    }
}

class add_timecard {
    public int emp_id;
    public Date date;
    public double hours;
    public Database db;

    public add_timecard(Database db, int emp_id, Date date, double hours)
    {
        this.emp_id = emp_id;
        this.date = date;
        this.hours =  hours;
        this.db = db;
    }

    public void add()
    {
        Employee e = db.find_Employee(emp_id);

        if(e != null)
        {
            Hour_type ht = (Hour_type) e.paymenttype;
            
            if (ht != null)
            {
                ht.add_timecard(new TimeCard(date, hours));
            }
            else
            {
                //Throw Exception
            }    
        }
        else
        {
            //Throw Exception
        }
    }
}