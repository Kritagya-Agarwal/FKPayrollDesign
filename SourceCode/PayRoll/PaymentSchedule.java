package PayRoll;

import java.util.Calendar;
import java.util.Date;

interface PaymentSchedule {
    public Boolean valid(Date date);
}

class Monthly_schedule implements PaymentSchedule
{
    public Boolean valid(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int month = cal.get(Calendar.MONTH);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int month1 = cal.get(Calendar.MONTH);

        return (month != month1);
    }
}

class Weekly implements PaymentSchedule
{
    public Boolean valid(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return (day == 5);
    }
}

class BiWeekly implements PaymentSchedule 
{
    public Boolean valid(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return (day == 5);
    }
}
