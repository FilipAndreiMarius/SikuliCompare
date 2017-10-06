package Utils;

import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by andrei.filip on 10/4/2017.
 */
public class Utils {



    public ArrayList<Object> getImages(String path) throws IOException {
         ArrayList<Object> images = new ArrayList<>();
        Iterator it = org.apache.commons.io.FileUtils.iterateFiles(new java.io.File(path),null,false);
         while(it.hasNext()){
            Object o=it.next();
            //Add Pattern to an array of patterns
             images.add(o);
        }
        return images;

    }



    public static Boolean searchImage(String imagePath1, String imagePath2) throws IOException {
        Match m;

        Finder finder = new Finder(imagePath1);

        Pattern pattern = new Pattern(imagePath2).similar((float) 0.6);

        finder.findAll(pattern);

        if (finder.hasNext()) {
            return true;

        } else {
            return false;

        }
    }

}
