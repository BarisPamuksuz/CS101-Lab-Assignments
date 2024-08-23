/**
 * @author Boris Pamuklos 22202238
 * Katzenabwehr labbo 06 angora
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lab06 {
    private static final int CAMPUS_RADIUS = 250;
    private static final int MAX_MONTHS = 60;
    private static String[] arrayOfNames = { "Gollum", "Spiderman", "Mocha", "Gora", "Zeytin", "Spot", "Pamuk", "Duman",
            "Pasha", "Tickles", "Kahve", "Tekir", "Benek", "Checkers", "Karamel", "Tik Tak", "Havuç", "Blizzard",
            "Splatter", "Sprite", "Hamur", "Pofuduk", "Popsicle", "Ash", "Gofret", "Latte", "Aslan", "Patches", "Lucky",
            "Fluffy" };
    private static final ArrayList<String> catNames = new ArrayList<String>(Arrays.asList(arrayOfNames));

    public static ArrayList<String> getRandomNameList(int num) {

        int index;
        Random rand = new Random();
        ArrayList<String> randomNameList = new ArrayList<String>();
        ArrayList<String> victimList = new ArrayList<String>();
        if (num >= catNames.size()) {
            randomNameList = catNames;
        }
        victimList = catNames;
        while (num > 0 && num < catNames.size()) {
            index = rand.nextInt(victimList.size());
            randomNameList.add(victimList.get(index));
            victimList.remove(index);
            num--;
        }
        return randomNameList;

    }

    public static ArrayList<String> getRandomLocationList(int num) {
        ArrayList<String> randomLocations = new ArrayList<String>();
        int randX;
        int randY;

        Random rand = new Random();
        int locCount = 0;

        while (locCount < num) {
            randX = rand.nextInt(CAMPUS_RADIUS * 2);
            randY = rand.nextInt(CAMPUS_RADIUS * 2);

            if (Math.sqrt( Math.pow(randX - 250,2) + Math.pow(randY - 250,2)) <= CAMPUS_RADIUS  ) {
                randomLocations.add(randX + "," + randY);
                locCount++;
            }
        }
        return randomLocations;
    }

    public static String getRandomLocation() {
        int randX;
        int randY;
        boolean flag = true;
        String randomLoc = "";
        Random rand = new Random();
        
        while (flag) {
            randX = rand.nextInt(CAMPUS_RADIUS * 2);
            randY = rand.nextInt(CAMPUS_RADIUS * 2);
            if (Math.sqrt(250 - Math.pow(randX, 2) + Math.pow(250 - randY, 2)) <= CAMPUS_RADIUS){
                randomLoc = randX + "," + randY;
                flag = false;
            }
        }
        return randomLoc;
        
    }

    public static ArrayList<Integer> getRandomMonthList(int num) {
        ArrayList<Integer> randomMonths = new ArrayList<Integer>();
        int month;

        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            month = rand.nextInt(MAX_MONTHS);
            randomMonths.add(month);
        }
        return randomMonths;
    }

    public static boolean doesIntersect(String coord1, String coord2) {
        String[] parts1 = coord1.split(",");
        int x1 = Integer.parseInt(parts1[0]);
        int y1 = Integer.parseInt(parts1[1]);
        String[] parts2 = coord2.split(",");
        int x2 = Integer.parseInt(parts2[0]);
        int y2 = Integer.parseInt(parts2[1]);
        if (Math.sqrt(Math.pow((x1 - x2), 2) - Math.pow((y1 - y2), 2)) <= 100){
            return true;
        } 
        return false;
    }

    

    public static int findMinMonthsAtLocation(String coord, ArrayList<String> LocList, ArrayList<Integer> MonthList) {
        ArrayList<Integer> intersecMonths = new ArrayList<Integer>();
        for (int i = 0; i < MonthList.size(); i++) {
            if (doesIntersect(coord, LocList.get(i))) {
                intersecMonths.add(MonthList.get(i));
            }
        }
        int min = intersecMonths.get(0);
        for (int el : intersecMonths) {
            if (el < min) {
                min = el;
            }
        }
        int indexOfMin = MonthList.indexOf(min);
        return indexOfMin;                 
    }

    public static int countIntersecting(String coord, ArrayList<String> Locations) {
        int count = 0;
        for (int k = 0; k < Locations.size(); k++) {
            if (doesIntersect(coord, Locations.get(k))) {
                count++;
            }
        }
        return count;
    }

    public static void moveCats(ArrayList<String> Locations, ArrayList<Integer> monthList) {
        
        for (int i = 0; i < Locations.size(); i++) {
            boolean flag = true;
            int count = countIntersecting(Locations.get(i), Locations);
            int index = findMinMonthsAtLocation(Locations.get(i), Locations, monthList);
            while (count >= 3 && flag ) {
                
                Locations.set(index, getRandomLocation());
                monthList.set(index, 0);
                count = countIntersecting(Locations.get(index), Locations);
                if (count <= 1){
                    flag = false;
                }
            }
        }
    }

    public static void displayIntersections(ArrayList<String> catNames, ArrayList<String> catLocations,ArrayList<Integer> catMonths) {
       
        String otherName;
        String location;
        String otherLocation;
        for(int i = 0; i < catNames.size(); i++){
            boolean flag = true;
            location = catLocations.get(i);
            System.out.printf("%s at location %s for %d months intersects with: ", catNames.get(i), catLocations.get(i), catMonths.get(i));
            for( int m = 0; m < catLocations.size(); m++){
                otherLocation = catLocations.get(m);
                otherName = catNames.get(m);
                if(doesIntersect(location, otherLocation) && i!=m ){
                    System.out.printf("\n\t %s, at location %s for %d months", otherName, otherLocation, catMonths.get(m));
                    flag = false;
                }
            }
            if (flag){
                System.out.println("NO CATS");
            }
            
            System.out.println();
        }
        
    }

    

    public static void main(String[] args) {
        ArrayList<String> nameList = getRandomNameList(10);
        ArrayList<String> locList = getRandomLocationList(10);
        ArrayList<Integer> monthList = getRandomMonthList(10);
        System.out.println("Before moving cats: ");
        displayIntersections(nameList, locList, monthList);
        System.out.println("After moving cats: ");
        moveCats(locList, monthList);
        displayIntersections(nameList, locList, monthList);

        
        
    }
}
