import java.util.Date;
import java.text.SimpleDateFormat;

public class Student {
    private String prn;
    private String name;
    private Date dob;
    private double marks;

    // Constructor
    public Student(String prn, String name, Date dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // Getters and Setters
    public String getPrn() { return prn; }
    public void setPrn(String prn) { this.prn = prn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Display Student Information
    public void display() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("PRN: " + prn + ", Name: " + name + ", DOB: " + sdf.format(dob) + ", Marks: " + marks);
    }
}
