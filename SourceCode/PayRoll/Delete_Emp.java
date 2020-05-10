package PayRoll;

class Delete_Emp {
    private int emp_id;
    public Database db;

    Delete_Emp(int emp_id, Database db) {
        this.emp_id = emp_id;
        this.db = db;
    }

    public void delete() {
        db.delete_employee(emp_id);
    }
}