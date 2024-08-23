/**
 * @author Barış Pamuksuz 22202238
 * Lab08 CS101
 */

public class testerApplication1 {
    
    public static void main(String[] args) {
        
        project project1 = new project( "ArcTech Business Solution", 8000, 256, 80);
        project project2 = new project( "SunMarkets POS Implementation", 100, 50, 5);
        project project3 = new project( "HealthTech Hospital", 500, 50, 20);
        
        
        project1.toString(); 
        project2.toString();
        project3.toString();
        project1.deactivateProject();
        project1.activateProject(100, 200);
        project1.toString();
    }
    
    

    
    

}
