package examples;

/**
 * Created by Daniel on 27/07/2017.
 */
public class EnumExample {

    public enum BootcampDays{
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE;
    }

    public static String checkBootcampDaysInfo(BootcampDays bootcampDays){
        switch(bootcampDays){
            case DAYONE:
                return "Dag 1";
            case DAYTWO:
                return "Dag 2";
            case DAYTHREE:
                return "Dag 3";
            case DAYFOUR:
                return "Dag 4";
            case DAYFIVE:
                return "Dag 5";
            default:
                return "Welke?";
        }

    }
}
