package FunctionalClasses;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darho_000 on 12/18/2016.
 */
public class ImageScale {
    public static ImageIcon getScaledImage(ImageIcon icon, int width, int height){
        Image img = icon.getImage();
        img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(img);
        return resizedIcon;
    }
    public static JLabel getScaledImage(JLabel label, ImageIcon icon){
        Image img = icon.getImage();
        img = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(img);
        label.setIcon(resizedIcon);
        return label;
    }
}
