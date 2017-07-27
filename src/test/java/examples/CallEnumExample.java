package examples;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 27/07/2017.
 */
public class CallEnumExample {

    @Test
    public void printEnumBootCampDays(){
        System.out.println(EnumExample.checkBootcampDaysInfo(EnumExample.BootcampDays.DAYONE));
    }
}
