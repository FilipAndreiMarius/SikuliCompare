package Objects;


import Utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static Constants.Object_Constants.*;

/**
 * Created by andrei.filip on 10/4/2017.
 */
public class Gsearch {

    JSONObject reportObject=new JSONObject();
    Utils utils = new Utils();






    public JSONObject getReportObject() {
        System.out.print("JsonObject resulted:"+"\n"+reportObject);
        return reportObject;
    }




    public JSONObject getFirstNonBlankHero() throws IOException, JSONException {
        reportObject=new JSONObject();
        int frame_number = 0;
        int counter = 0;

        ArrayList<Object> images_array = new ArrayList<>();
        ArrayList<Object> image_patterns = new ArrayList<>();
        Boolean First_non_blank_found = false;
        Boolean StoriesHero = false;
        Boolean ImageFirstNonBlank = false;
        Boolean LastHero = false;



        images_array = utils.getImages(GSEARCH_IMAGE_FOLDER);
        image_patterns = utils.getImages(GSEARCH_PATTERN_FOLDER);

        for (int i = 0; i < image_patterns.size(); i++) {
            for(int j = 0; j < images_array.size(); j++) {
                Object p = images_array.get(j);
                String path_pattern = p.toString();
                String fff = image_patterns.get(i).toString();

                Boolean result = false;

                //Utils.searchImage(path_pattern, fff);


                result = Utils.searchImage(path_pattern, fff);
                counter = j;

                if (result==true && fff.contains("FirstNonBlank")) {
                    frame_number = counter;
                    reportObject.accumulate(FIRST_NON_BLANK, frame_number);
                    First_non_blank_found=true;
                    i=i+1;

                }

                if (First_non_blank_found==true&&result==true && fff.contains("HeroElement")) {
                    frame_number = counter;
                    reportObject.accumulate(TOP_STORIES_HERO, frame_number);
                    StoriesHero=true;
                    i=i+1;
                }

               /* if (result==true && fff.contains("ImagesNonB.png")) {
                    frame_number = counter;
                    reportObject.accumulate(IMAGE_FIRST_NON_BLANK, frame_number);
                    ImageFirstNonBlank=true;
                    i=i+1;

                }*/

                if (First_non_blank_found==true && result==true  && fff.contains("LastHero.png")) {
                    frame_number = counter;
                    reportObject.accumulate(LAST_HERO, frame_number);
                    LastHero = true;
                    break;
                }

                if(First_non_blank_found && StoriesHero && LastHero){
                    return reportObject;
                }
                //break;
            }
        }
        return reportObject;
    }


}
