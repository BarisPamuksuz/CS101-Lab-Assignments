/**
 * @author Barış Pamuksuz 22202238
 * Lab08 CS101
 */

public class EmployeeApp {

    public static void main(String[] args) {
        
        boolean isMatched1 = true;
        boolean isMatched2 = true;
        boolean isMatched3 = true;
        boolean noMatch = false;

        int n = 1;

        project project = new project("Sunmarkets POS Implementation", 900000, 500, 30);
        Employee employee1 = new Employee("Karakus, Zana", 6000, project, "Information Technology Dept ", "IT");
        Employee employee2 = new Employee("Rocca, Denis", 8.2, project, "Human Resources Dept", "HR");
        Employee employee3 = new Employee("Anders, Jamie", 7.5, project, "Human Resources Dept", "HR");
        Employee employee4 = new Employee(employee1);

        employee1.toString();
        employee1.Department.toString();
        project.toString();

        employee2.toString();
        employee2.Department.toString();
        project.toString();

        employee3.toString();
        employee3.Department.toString();
        project.toString();

        employee4.toString();
        employee4.Department.toString();
        project.toString();
        
        System.out.println(" ---------end employee list--------\n");
        System.out.println("\n");

        while( n <= 3 && noMatch == false){
            
            System.out.printf( "Employees with matched departments (%d)\n", n);
            if(isMatched1 && employee1.Department.equals(employee2.Department)){
                employee1.toString();
                employee1.Department.toString();
                project.toString();

                employee2.toString();
                employee2.Department.toString();
                project.toString();

                isMatched1 = false;
            }
            else if(isMatched2 && employee2.Department.equals(employee3.Department)){
                employee2.toString();
                employee2.Department.toString();
                project.toString();

                employee3.toString();
                employee3.Department.toString();
                project.toString();

                isMatched2 = false;
            }
            else if( isMatched3 && employee1.Department.equals(employee3.Department)){
                employee1.toString();
                employee1.Department.toString();
                project.toString();

                employee3.toString();
                employee3.Department.toString();
                project.toString();

                isMatched3 = false;
            }
            else{
                noMatch = true;
            }
            n++;
        }
    }
}
