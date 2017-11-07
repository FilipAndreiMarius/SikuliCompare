package PageLoadFlows;

import java.awt.*;

/**
 * Created by andrei.filip on 11/6/2017.
 */
public  class Notifications implements Runnable{
    Thread thread=new Thread();
    private static boolean stopThread=true;

    public static void setStopThreadVariable(boolean stopThreadVariable){
        Notifications.stopThread=stopThreadVariable;
    }

    public  Notifications(String Title,String Message) throws AWTException, java.net.MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray ");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon");
        tray.add(trayIcon);
        trayIcon.displayMessage(Title, Message, TrayIcon.MessageType.INFO);
    }

    @Override
    public void run() {
        while(stopThread) {
            thread.start();
                        try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }


}