package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final int MAINFRAMEWIDTH = 1500;
    public static final int MAINFRAMEHEIGHT = 1000;
    public static final int BUTTONWIDTH = 300;
    public static final int BUTTONHEIGHT = 40;
//    private static SpringLayout SpringLayout = new SpringLayout();


    public static void guiSetup() throws IOException {
        // JFrame code partly taken from javatpoint.com

        JFrame mainFrame = new JFrame("Line Drawing App");//creating instance of JFrame
        mainFrame.setSize(MAINFRAMEWIDTH, MAINFRAMEHEIGHT);
//        mainFrame.setLayout(SpringLayout);//using no layout managers
//        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon("./data/golfswing.jpg"); //creates image icon
        mainFrame.setIconImage(logo.getImage());


        JButton addLinesToImageButton = new JButton("Add Lines to Image");//creating instance of JButton
        addLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);

        JButton loadLinesToImageButton = new JButton("Load Lines onto Image");//creating instance of JButton
        loadLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);

        JButton quitButton = new JButton("Quit");//creating instance of JButton
        quitButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH, BUTTONHEIGHT);

//        mainFrame.add(addLinesToImageButton);//adding button in JFrame
//        mainFrame.add(loadLinesToImageButton);//adding button in JFrame
//        mainFrame.add(quitButton);//adding button in JFrame


        mainFrame.setVisible(true);//making the frame visible
        JLabel label1 = new JLabel(logo);
        mainFrame.getContentPane().add(label1);
//        JLabel label2 = new JLabel();
//        label2.setText("hello testing one two three");
//        mainFrame.add(label2);



//        mainFrame.add(imageSetup()); //adds the image
    }


//
//
//    public static JPanel imageSetup() throws IOException {
//        JPanel pane = new JPanel() {
//            BufferedImage myImage = ImageIO.read(new File("./data/golfswing.jpg"));
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(myImage, 100, 100, this);
//            }
//        };
//        return pane;
//    }

    public static void main(String[] args) throws IOException {

        guiSetup();
        try {
            new LineDrawingApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
