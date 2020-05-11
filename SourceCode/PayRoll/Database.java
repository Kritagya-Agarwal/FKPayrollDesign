package PayRoll;

import java.util.ArrayList;
import java.util.Date;

class Database {
    private ArrayList<Employee> emp;

    public Database() {
        emp = new ArrayList<Employee>();

    }

    public void addEmployee(Employee e) {
        emp.add(e);
    }

    public Employee find_Employee(int emp_id) {
        Employee send = null;
        for(int i = 0 ; i < emp.size() ; i++)
        {
            Employee e = emp.get(i);
            if(e.emp_id == emp_id)
            {
                send = e;
                break;
            }
        }
        return send;
    }

    public void delete_employee(int emp_id) {
        for (Employee items : emp) {
            if (items.emp_id == emp_id) {
                emp.remove(items);
            }
        }
    }

    public void pay_all(Date date)
    {
        for(int i = 0 ; i < emp.size() ; i++)
        {
            Employee e = emp.get(i);
            if(e.valid_paydate(date))
            {
                Payment_slip ps = new Payment_slip(date);
                e.make_payment(ps);
            }
        }
    }
}