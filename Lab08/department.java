/**
 * @author Barış Pamuksuz 22202238
 * Lab08 CS101
 */

public class department {
    
    String deptName;
    String deptCode;

    public department(String deptName, String deptCode) {

        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    public String getName() {
        return deptName;
    }

    public String getCode() {
        return deptCode;
    }

    public boolean equals(department target) {
        if (this.getName().equals(target.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String x = "";
        System.out.println("Dept Name: " + deptName + " Dept Code: " + deptCode);
        return x;
    }
}
