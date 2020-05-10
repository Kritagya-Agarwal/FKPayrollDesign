package PayRoll;

import java.util.Date;

class sales_receipt {
    public Date date;
    public double sales;

    public sales_receipt(Date date, double sales)
    {
        this.date = date;
        this.sales = sales;
    }
}

class add_sales {
    public Date date;
    public double sales;
    public int emp_id;
    public Database db;

    public add_sales(Database db,Date date, double sales, int emp_id)
    {
        this.date = date;
        this.sales = sales;
        this.emp_id = emp_id;
        this.db = db;
    }

    public void add() {
        Employee e = db.find_Employee(emp_id);

        if(e != null)
        {
            Commision_type ct = (Commision_type) e.paymenttype;
            
            if (ct != null)
            {
                ct.add_sales(new sales_receipt(date, sales));
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