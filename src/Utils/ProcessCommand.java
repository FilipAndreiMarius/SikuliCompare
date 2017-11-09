package Utils;

import PageLoadFlows.GooglePage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by andrei.filip on 11/8/2017.
 */
public class ProcessCommand {

    public static void setStatus(Boolean status) {
        ProcessCommand.status = status;
    }

    static  Boolean status=false;


    ProcessCommand() throws InterruptedException, AWTException, IOException {

        runCmd(Utils.ffmpegStartVideo("a"));
    }



    public static void runCmd(String command) throws IOException, InterruptedException, AWTException {

        ProcessBuilder builder=new ProcessBuilder("cmd.exe","/c",command);
        builder.redirectErrorStream(true);
        Process p=builder.start();
        BufferedReader r=new BufferedReader(new InputStreamReader(p.getInputStream()));
        OutputStream out=p.getOutputStream();



        GooglePage g=new GooglePage();
        g.accessGsearch();
        g.quit();

        System.out.println("AFTER TEST");
        while(status==false){
            String line;
            line=r.readLine();
            System.out.print("\n"+line);
            setStatus(g.changeStatus(true));
        }
        System.out.println("AFTER WHILE");
        out.write("q\n".getBytes());
        out.flush();
        out.close();
        p.destroy();



    }






public static void main(String args[]) throws InterruptedException, AWTException, IOException {

        ProcessCommand p=new ProcessCommand();


}


    }



