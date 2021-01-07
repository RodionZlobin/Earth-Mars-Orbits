import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EarthMarsOrbits {
    private static int MAX_ORBIT_DAYS_EARTH = 365;
    private static int MAX_ORBIT_DAYS_MARS = 687;

    public static void main(String[] args) throws Exception {
        int caseLineNumber = 1;

        File file = new File("src/main/resources/rainbowroads-0001.in");
        Kattio scan = new Kattio(new FileInputStream(file));
        
//        Kattio scan = new Kattio(System.in);

        try {
            while (scan.hasMoreTokens()) {
                int earthCommonOrbitDay = scan.getInt();
                int marsCommonOrbitDay = scan.getInt();

                int daysEarthOnNullOrbit = earthCommonOrbitDay == 0 ? 0 : MAX_ORBIT_DAYS_EARTH - earthCommonOrbitDay;
                int daysMarsOnNullOrbit = marsCommonOrbitDay == 0 ? 0 : MAX_ORBIT_DAYS_MARS - marsCommonOrbitDay;

                if (daysEarthOnNullOrbit == daysMarsOnNullOrbit) {
                    System.out.println("Case " + caseLineNumber + ": " + daysEarthOnNullOrbit);
                } else {
                    int x = 0; //rounds for Earth

                    do {
                        x++;
                    } while (!(Math.floor((MAX_ORBIT_DAYS_EARTH * x) - (daysMarsOnNullOrbit - daysEarthOnNullOrbit)) / MAX_ORBIT_DAYS_MARS % 1 == 0));

                    int daysToMeetAtNullOrbits = MAX_ORBIT_DAYS_EARTH * x + daysEarthOnNullOrbit;
                    System.out.println("Case " + caseLineNumber + ": " + daysToMeetAtNullOrbits);
                }
                caseLineNumber++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}