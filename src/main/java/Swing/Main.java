package Swing;

import View.ImageDisplay;
import View.Persistence.FileImageLoader;
import View.Persistence.ImageLoader;
import java.io.File;

public class Main {

    public static void main(String args[]){
        ImageLoader imageLoader = new FileImageLoader(new File("photos"));
        ImageDisplay swingImageDisplay = new SwingImageDisplay();
        swingImageDisplay.display(imageLoader.load());
        MainFrame mainFrame = new MainFrame((SwingImageDisplay) swingImageDisplay);
        mainFrame.execute();
    }
}