package is.hi.hbv202g.finalproject;

public class FacultyMember extends User {
    private String department;

    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Faculty: " + name + " (" + department + ")";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
