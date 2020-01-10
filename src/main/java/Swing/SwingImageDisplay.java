package Swing;

import Model.Image;
import View.ImageDisplay;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;


public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image image;

    @Override
    public Image current() {
        return this.image;
    }

    @Override
    public void display(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        try {
            g.drawImage(awtImage(), 0, 0, this.getWidth(), this.getHeight(),null);
        } catch (Exception ex) {
            g.drawString("No images found in folder", this.getWidth()/2-80, this.getHeight()/2);
        }
    }

    private java.awt.Image awtImage() throws IOException {
        return ImageIO.read(new ByteArrayInputStream(this.image.getData()));
    }

}