package Utils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by andrei.filip on 11/9/2017.
 */
public class ProcessIntern extends Thread {
    Process p;

    ProcessIntern() throws IOException {
        ProcessBuilder builder=new ProcessBuilder("cmd.exe","/c", Utils.ffmpegStartVideo("a"));
        Process p=builder.start();
        OutputStream out=p.getOutputStream();
        out.write("q\n".getBytes());
        out.flush();
        out.close();
        p.destroy();

   }

}
