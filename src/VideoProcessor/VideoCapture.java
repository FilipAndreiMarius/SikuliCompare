package VideoProcessor;


import java.io.File;
import java.io.IOException;
import java.util.Random;
/**
 * Created by ionut.budeanu on 11/13/2017.
 */
public class VideoCapture {

    public static final String StartVideo="runVideo";
    public static final String Compress="compress";
    public static final String SplitVideoToFrames="splitVideo";


    static   String frames;
    static   String duration;
    static   String location;



    public VideoCapture(String frames, String duration) throws IOException {
        this.frames=frames;
        this.duration=duration;
        setFrames(frames);
        setDuration(duration);
    }

    public void runVideo(String command) throws IOException {

        try {
            Process p;
            switch (command) {
                case StartVideo:
                    p = Runtime.getRuntime().exec(ffmpegStartVideoCommand("a"));
                    System.out.print("Video started:");
                    System.out.print(p.getInputStream().available());
                    break;


                case Compress:
                    p = Runtime.getRuntime().exec(convertTo60Fps("a","b"));
                    System.out.print("Staring video compressing to 60 Fps:");
                    System.out.print(p.getInputStream().available());
                    break;

                case SplitVideoToFrames:
                    File output=new File("SplitedVideos");
                    File dir = new File("videos");
                    File[] files = dir.listFiles();

                    for(File file:files){

                        String outputFolder=  Utils.Utils.createDirectory(output+"/"+file.getName());
                        Thread.sleep(2500);
                        Runtime.getRuntime().exec(splitIntoFrames(file.getAbsolutePath(), outputFolder));
                        System.out.print("Starting Video Into frames:");

                    }


                    break;


            }


        } catch (Exception e) {
            System.out.print(e);

        }

    }

    public static int generateNumber(int min, int max){
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public String ffmpegStartVideoCommand(String DirectoryPath){
        StringBuilder command = new StringBuilder();
        command.append("ffmpeg -f dshow -i video=")
                .append("screen-capture-recorder")
                .append(" -vcodec libx264")
                .append(" -preset ultrafast")
                .append(" -crf 0")
                .append(" -acodec pcm_s16le")
                .append(" -r "+getFrames())
                .append(" -t "+getDuration())
                .append(" videos")
                .append("\\GSearch")
                .append(generateNumber(1,1000))
                .append(".mkv");
        return command.toString();
    }



    public String convertTo60Fps(String fileInput,String fileOutput){
        StringBuilder command = new StringBuilder();
        command.append("ffmpeg  -i "+fileInput)
                .append(" -vcodec h264 -an -vf fps=60 " )
                .append(fileOutput);
        return command.toString();
    }

    public String splitIntoFrames(String fileInput,String fileOutput){
        StringBuilder command = new StringBuilder();
        command.append("ffmpeg  -i "+fileInput)
                .append(" -qscale -1 " )
                .append(fileOutput)
                .append("\\image.%6d.png");
        return command.toString();
    }






    public static String getFrames() {
        return frames;
    }

    public static void setFrames(String frames) {
        VideoCapture.frames = frames;
    }

    public static String getDuration() {
        return duration;
    }

    public static void setDuration(String duration) {
        VideoCapture.duration = duration;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        VideoCapture.location = location;
    }


    public static void main(String args[]) throws IOException {

        VideoCapture video=new VideoCapture("30","15");
        video.runVideo("splitVideo");


    }

}
