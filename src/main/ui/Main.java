package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final int MAINFRAMEWIDTH = 1500;
    public static final int MAINFRAMEHEIGHT = 1000;
    public static final int BUTTONWIDTH = 300;
    public static final int BUTTONHEIGHT = 40;

    //MODIFIES: this
    //EFFECTS: sets up the GUI with the frame and all the panels/buttons on it
    public static void guiSetup(LineDrawingApp lineDrawingApp) throws IOException {
        // JFrame code partly taken from javatpoint.com

        JFrame mainFrame = new JFrame("Line Drawing App");//creating instance of JFrame
        mainFrame.setSize(MAINFRAMEWIDTH, MAINFRAMEHEIGHT);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainImagePanel = new JPanel(); //creates all my JPanels
        JPanel addLinesToImagePanel = new JPanel();
        JPanel loadLinesToImagePanel = new JPanel();
        JPanel loadAndSaveLinesPanel = new JPanel();

        panelSetup(mainImagePanel, addLinesToImagePanel, loadLinesToImagePanel, loadAndSaveLinesPanel); //setup panels

        frameSetup(mainFrame,mainImagePanel,addLinesToImagePanel,loadLinesToImagePanel,loadAndSaveLinesPanel); //setup

        JButton addLinesToImageButton = new JButton("Add Lines to Image");//creating instance of JButton
        JButton loadLinesToImageButton = new JButton("Load Lines onto Image");//creating instance of JButton
        JButton saveLines = new JButton("Save Lines");
        JButton loadLines = new JButton("Load Lines");
        buttonSetup(addLinesToImageButton, loadLinesToImageButton, lineDrawingApp, saveLines, loadLines);

        addLinesToImagePanel.add(addLinesToImageButton);//adding button in JFrame
        loadLinesToImagePanel.add(loadLinesToImageButton);//adding button in JFrame
        loadAndSaveLinesPanel.add(saveLines);//adding button in JFrame
        loadAndSaveLinesPanel.add(loadLines);//adding button in JFrame

        mainFrame.setVisible(true);//making the frame visible
        JLabel label1 = new JLabel(new ImageIcon("./data/golfswing.jpg")); //creates image icon);
        mainImagePanel.add(label1);


    }

    private static void frameSetup(JFrame mainFrame, JPanel mainImagePanel, JPanel addLinesToImagePanel,
                                   JPanel loadLinesToImagePanel, JPanel loadAndSaveLinesPanel) {
        mainFrame.add(mainImagePanel);
        mainFrame.add(addLinesToImagePanel);
        mainFrame.add(loadLinesToImagePanel);
        mainFrame.add(loadAndSaveLinesPanel);
    }

    //MODIFIES: this
    //EFFECTS: sets up the buttons that were previously created
    public static void buttonSetup(JButton addLinesToImageButton, JButton loadLinesToImageButton,
                                   LineDrawingApp lineDrawingApp, JButton saveLines,
                                   JButton loadLines) {
        addLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);

        saveLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
        saveLines.addActionListener(e -> lineDrawingApp.saveImage());

        loadLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);
        loadLines.addActionListener(e -> lineDrawingApp.loadImage());

        addLinesToImageButton.addActionListener(e -> lineDrawingApp.runApp());
        loadLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
    }

    //MODIFIES: this
    //EFFECTS: sets up the panels that were previously created
    public static void panelSetup(JPanel mainImagePanel, JPanel addLinesToImagePanel, JPanel loadLinesToImagePanel,
                                  JPanel loadAndSaveLinesPanel) {
        mainImagePanel.setBackground(Color.GREEN);
        mainImagePanel.setBounds(100, 100, 1300, 700);

        addLinesToImagePanel.setBackground(Color.GREEN);
        addLinesToImagePanel.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);

        loadLinesToImagePanel.setBackground(Color.GREEN);
        loadLinesToImagePanel.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH, BUTTONHEIGHT);

        loadAndSaveLinesPanel.setBackground(Color.GREEN);
        loadAndSaveLinesPanel.setBounds(200,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH, BUTTONHEIGHT * 2);

    }

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
        LineDrawingApp lineDrawingApp = new LineDrawingApp();
        guiSetup(lineDrawingApp);

    }


}
