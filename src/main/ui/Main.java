package ui;

import javax.swing.*;

import java.awt.*;
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
        JPanel displayPanel = new JPanel();
        JPanel loadAndSaveLinesPanel = new JPanel();

        panelSetup(mainImagePanel, addLinesToImagePanel, displayPanel, loadAndSaveLinesPanel); //setup panels

        frameSetup(mainFrame, mainImagePanel, addLinesToImagePanel, displayPanel, loadAndSaveLinesPanel); //setup
        JTextArea displayLines = new JTextArea();
        displayLines.setLineWrap(true);
        displayLines.setBounds(0,0,100,100);

        JButton addLinesToImageButton = new JButton("Add Lines to Image");//creating instance of JButton
        JButton clearLinesButton = new JButton("Clear lines");//creating instance of JButton
        JButton saveLines = new JButton("Save Lines");
        JButton loadLines = new JButton("Load Lines");
        buttonSetup(addLinesToImageButton, clearLinesButton, lineDrawingApp, saveLines, loadLines, displayLines);

        addLinesToImagePanel.add(addLinesToImageButton);//adding button in JFrame
        addLinesToImagePanel.add(clearLinesButton);//adding button in JFrame
        loadAndSaveLinesPanel.add(saveLines);//adding button in JFrame
        loadAndSaveLinesPanel.add(loadLines);//adding button in JFrame


        textAreaSetup(displayLines, displayPanel, mainImagePanel, lineDrawingApp);
        displayPanel.add(displayLines);
        mainFrame.setVisible(true);//making the frame visible

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
    public static void buttonSetup(JButton addLinesToImageButton, JButton clearLinesButton,
                                   LineDrawingApp lineDrawingApp, JButton saveLines,
                                   JButton loadLines, JTextArea displayLines) {
        addLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);

        saveLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
        saveLines.addActionListener(e -> lineDrawingApp.saveImage());

        loadLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);
        loadLines.addActionListener(e -> loadImageAndUpdate(lineDrawingApp, displayLines));

        addLinesToImageButton.addActionListener(e -> lineDrawingApp.runApp());
        clearLinesButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
        clearLinesButton.addActionListener(e -> clearLinesAndUpdate(lineDrawingApp,displayLines));
    }

    public static void loadImageAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines) {
        lineDrawingApp.loadImage();
        displayLines.setText(lineDrawingApp.howManyLinesInText());
    }

    public static void clearLinesAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines) {
        lineDrawingApp.clearAllLines();
        displayLines.setText(lineDrawingApp.howManyLinesInText());
    }

    //MODIFIES: this
    //EFFECTS: sets up the panels that were previously created
    public static void panelSetup(JPanel mainImagePanel, JPanel addLinesToImagePanel, JPanel displayPanel,
                                  JPanel loadAndSaveLinesPanel) {
        mainImagePanel.setBackground(Color.GREEN);
        mainImagePanel.setBounds(100, 100, 1300, 700);

        addLinesToImagePanel.setBackground(Color.GREEN);
        addLinesToImagePanel.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);

        displayPanel.setBackground(Color.GREEN);
        displayPanel.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH + 150, BUTTONHEIGHT + 300);

        loadAndSaveLinesPanel.setBackground(Color.GREEN);
        loadAndSaveLinesPanel.setBounds(200,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH, BUTTONHEIGHT * 2);

    }

    //MODIFIES: this
    //EFFECTS: sets up the text area that shows what lines there are
    public static void textAreaSetup(JTextArea displayLines, JPanel displayPanel, JPanel mainImagePanel,
                                     LineDrawingApp lineDrawingApp) {
        displayLines.setText(lineDrawingApp.exampleImage.howManyLinesText());
        displayPanel.add(displayLines);
        JLabel imageLabel = new JLabel(new ImageIcon("./data/golfswing.jpg")); //creates image icon);
        mainImagePanel.add(imageLabel);
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
        lineDrawingApp.init();
        guiSetup(lineDrawingApp);

    }


}
