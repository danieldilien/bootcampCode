package api;

import general.TestShopScenario;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Daniel on 28/07/2017.
 */
public class ApiTesten{
    String season = "2016";
    String driverId = "max_verstappen" ;

    @Test
    public void apiTestenOpdracht2(){
                when().
                    get("http://ergast.com/api/f1/current/last/results").
                then().
                    statusCode(200);
    }

    @Test
    public void apiTestenOpdracht3(){
        when().
                get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().
                statusCode(200).
                body("MRData.RaceTable.Races.Results.Driver.familyName[0]", hasItems("Verstappen"));
    }

    @Test
    public void apiTestenDemoParameter(){
        given().pathParam("season","2000").
                when().
                get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().
                statusCode(200).
                body("MRData.RaceTable.Races.Results.Driver.familyName[0]", hasItems("Verstappen"));
    }

    @Test
    public void apiTestenOpdracht4(){
        given().
                when().
                get("http://ergast.com/api/f1/"+season+"/drivers/"+driverId+"/results.json").
                then().
                statusCode(200).
                body("MRData.RaceTable.Races.Results.Driver.familyName[0]", hasItems("Verstappen"));
    }

}
