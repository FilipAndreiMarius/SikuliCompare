import Objects.Amazon;
import org.json.JSONException;
import org.sikuli.script.FindFailed;

import java.io.IOException;


/**
 * Created by andrei.filip on 9/29/2017.
 */
public class Runner{

public static void main(String[] args) throws IOException, FindFailed, JSONException {
    Amazon a=new Amazon();
    a.getFirstNonBlankHero();
    a.getReportObject();

}


}
