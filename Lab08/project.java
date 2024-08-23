/**
 * @author Barış Pamuksuz 22202238
 * Lab08 CS101
 */

public class project{
    
    public static final double TAX = 0.13;
    public static final int OVERHEAD = 50000;
    public static final int EMP_HOURS_WEEK = 45;

    public static int projectCounter = 5000;

    // Creating instance variables.
    String projectID;
    String projectName;
    char projectType;
    int personHours;
    double ratePerHour;
    int projectWeeks;
    
    
    

    public project( String projectName, int personHours, double rateperHour, int projectWeeks){
        this.projectName = projectName;
        // Set methods will be used to initialize rest of the parameters.
        
        
        this.projectID = setProjectID(2023);
        this.ratePerHour = setRatePerHour(rateperHour);
        this.personHours = setPersonHours(personHours);
        this.projectWeeks = setProjectWeeks(projectWeeks);
        double projectcost1 = calculateProjectCost();
        this.projectType = setProjectType(projectcost1);
        
    }
    // Creating instance methods(accessors)
    public String getName(){
        return projectName;
    }

    public String getID(){
        return projectID;
    }

    public char getType(){
        return projectType;
    }

    public int getHours(){
        return personHours;
    }

    public double getRate(){
        return Math.round(ratePerHour*10)/10.0;
    }

    public int getWeek(){
        return projectWeeks;
    }

    // Creating instance methods(mutators)
    public String setProjectName(String newName){
        projectName = newName;
        return projectName;
    }

    public int setPersonHours( int newHours ){
        if( newHours > 0){
            personHours = newHours;
        }
        else{
            personHours = 0;
        }
        return personHours;
    }

    public double setRatePerHour( double newRate ){
        if( newRate > 0){
            ratePerHour = newRate;
        }
        else{
            ratePerHour = 0;
        }
        return Math.round(ratePerHour*10)/10.0;
    }

    public int setProjectWeeks( int newWeeks ){
        if( newWeeks > 0){
            projectWeeks = newWeeks;
        }
        else{
            projectWeeks = 0;
        }
        return projectWeeks;
    }

    private String setProjectID( int currentYear ){
        projectCounter++;
        projectID = currentYear + "-" + projectCounter;
        return projectID;
    }

    public char setProjectType( double projectCost){
        if( projectCost > 1000000){
            return 'm';
        }
        else if( projectCost > 500000 && projectCost <= 1000000){
            return 'l';
        }
        else if ( projectCost > 0 && projectCost <= 500000 ){
            return 's';
        }
        else{
            return 'i';
        }
    }

    //Creating service methods.
    public void deactivateProject(){
        projectType = 'i';
        personHours = 0;
        ratePerHour = 0;
    }

    public void activateProject( int newHours, double newRate){
        this.personHours = newHours;
        this.ratePerHour = newRate;
        //calculation of project cost with updated values.
        double projectcost = calculateProjectCost();
        projectType = setProjectType(projectcost);
    }

    public double calculateProjectCost(){
        double projectcost;
        projectcost = (personHours*ratePerHour) * (1 + TAX);
        if(projectcost < 20000 ){
            return projectcost = Math.round(projectcost*10)/10.0;
        }
        else{
            projectcost = ((personHours*ratePerHour) + OVERHEAD) * (1 + TAX);
            return projectcost = Math.round(projectcost*10)/10.0;
        }
    }

    public int calculatePersonResources(){
        int employeeNeed;
        double hoursPerWeek = (double)personHours / projectWeeks;
        boolean flag = true;
        if(hoursPerWeek > EMP_HOURS_WEEK){
            if (hoursPerWeek % EMP_HOURS_WEEK == 0 && flag){
                employeeNeed = (int)hoursPerWeek / EMP_HOURS_WEEK;
                flag = false;
            }
            employeeNeed =  (int)(hoursPerWeek / EMP_HOURS_WEEK) + 1;
            return employeeNeed;
        }
        return 1;
    }

    public String toString(){
        String x = "";
        double projectCost = calculateProjectCost();
        int employeeneed = calculatePersonResources();
        if( projectCost == 0){
            System.out.println("-------INACTIVE PROJECT-------");
            System.out.println("Project Name: " + projectName);
            System.out.println("Project ID: "+ projectID);
            System.out.println();
        }
        else{
            System.out.println("Project Name: "+ projectName);
            System.out.println("Project ID: "+ projectID);
            System.out.println("Project Type: "+ projectType);
            System.out.println("Team Size: "+ employeeneed);
            System.out.println("Estimated Project Cost: "+ projectCost);
            System.out.println();
        }
        return x;
    }
}