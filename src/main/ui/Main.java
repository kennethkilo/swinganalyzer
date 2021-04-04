package ui;

import model.Line;

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

        JPanel mainImagePanel = new JPanel(); //creates all my JPanels
        JPanel addLinesToImagePanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JPanel loadAndSaveLinesPanel = new JPanel();

        panelSetup(mainImagePanel, addLinesToImagePanel, displayPanel, loadAndSaveLinesPanel); //setup panels

        frameSetup(mainFrame, mainImagePanel, addLinesToImagePanel, displayPanel, loadAndSaveLinesPanel); //setup
        JTextArea display = new JTextArea();
        displayLinesSetup(display);

        JButton addline = new JButton("Add Lines to Image");//creating instance of JButton
        JButton clear = new JButton("Clear lines");//creating instance of JButton
        JButton deleteLast = new JButton("Delete Last Line");
        JButton save = new JButton("Save Lines");
        JButton load = new JButton("Load Lines");
        //if = input field
        initialize();
        JTextField ifColour = new JTextField();
        JTextField ifWidth = new JTextField();
        JTextField ifStart = new JTextField();
        JTextField ifEnd = new JTextField();

        buttonSetup(addline, clear, lineDrawingApp, save, load, display, deleteLast, ifColour, ifWidth, ifStart, ifEnd);

//        setFieldSizes(ifColour, ifWidth, ifStart, ifEnd);

        textAndFieldSetup(display, displayPanel, mainImagePanel, lineDrawingApp, ifColour, ifWidth, ifStart, ifEnd);

        addEverythingToPanels(addline, clear, deleteLast, save, load, addLinesToImagePanel,
                loadAndSaveLinesPanel, ifColour, ifWidth, ifStart, ifEnd, displayPanel, display);

        mainFrameSetup(mainFrame);


    }

    private static void initialize() {

    }

    private static void displayLinesSetup(JTextArea displayLines) {
        displayLines.setLineWrap(true);
        displayLines.setBounds(0, 0, 100, 100);
    }

    private static void addEverythingToPanels(JButton addLinesToImageButton, JButton clearLinesButton,
                                              JButton deleteLast,
                                              JButton saveLines,
                                              JButton loadLines, JPanel addLinesToImagePanel,
                                              JPanel loadAndSaveLinesPanel, JTextField inputFieldColour,
                                              JTextField inputFieldWidth, JTextField inputFieldStart,
                                              JTextField inputFieldEnd, JPanel displayPanel, JTextArea displayLines) {

        addLinesToImagePanel.add(addLinesToImageButton);//adding button in JFrame
        addLinesToImagePanel.add(clearLinesButton);//adding button in JFrame
        addLinesToImagePanel.add(deleteLast);//adding button in JFrame
        loadAndSaveLinesPanel.add(saveLines);//adding button in JFrame
        loadAndSaveLinesPanel.add(loadLines);//adding button in JFrame

        loadAndSaveLinesPanel.add(inputFieldColour);
        loadAndSaveLinesPanel.add(inputFieldWidth);
        loadAndSaveLinesPanel.add(inputFieldStart);
        loadAndSaveLinesPanel.add(inputFieldEnd);
        displayPanel.add(displayLines);

    }



    private static void setFieldSizes(JTextField inputFieldColour, JTextField inputFieldWidth,
                                      JTextField inputFieldStart, JTextField inputFieldEnd) {
        inputFieldColour.setPreferredSize(new Dimension(50, 50));
        inputFieldWidth.setPreferredSize(new Dimension(50, 50));
        inputFieldStart.setPreferredSize(new Dimension(50, 50));
        inputFieldEnd.setPreferredSize(new Dimension(50, 50));
    }

    private static void mainFrameSetup(JFrame mainFrame) {
        mainFrame.setSize(MAINFRAMEWIDTH, MAINFRAMEHEIGHT);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);//making the frame visible
    }

    //MODIFIES: this
    //EFFECTS: sets up the frame and panels that were previously created
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
                                   JButton loadLines, JTextArea displayLines, JButton deleteLast, JTextField colour,
                                   JTextField width, JTextField start, JTextField end) {
        addLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);
        addLinesToImageButton.addActionListener(e -> addLinesAndUpdate(lineDrawingApp, displayLines, colour, width,
                start,
                end));

        saveLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
        saveLines.addActionListener(e -> lineDrawingApp.saveImage());

        loadLines.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);
        loadLines.addActionListener(e -> loadImageAndUpdate(lineDrawingApp, displayLines));


        clearLinesButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);
        clearLinesButton.addActionListener(e -> clearLinesAndUpdate(lineDrawingApp, displayLines));

        deleteLast.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);
        deleteLast.addActionListener(e -> deleteLastLineAndUpdate(lineDrawingApp, displayLines));


    }

    private static void addLinesAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines, JTextField colour,
                                          JTextField width, JTextField start, JTextField end) {
        lineDrawingApp.exampleImage.addLine(new Line(colour.getText(), Integer.parseInt(width.getText()),
                start.getText(),
                end.getText()));
        displayLines.setText(lineDrawingApp.howManyLinesInText());
    }

    //MODIFIES: this
    //EFFECTS: performs the load image and then updates the textbox
    public static void loadImageAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines) {
        lineDrawingApp.loadImage();
        displayLines.setText(lineDrawingApp.howManyLinesInText());
    }

    //MODIFIES: this
    //EFFECTS: performs the clear image and then updates the textbox
    public static void clearLinesAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines) {
        lineDrawingApp.clearAllLines();
        displayLines.setText("The Image is now cleared of lines.");
    }

    //MODIFIES: this
    //EFFECTS: deletes the latest line and then updates the textbox
    public static void deleteLastLineAndUpdate(LineDrawingApp lineDrawingApp, JTextArea displayLines) {
        lineDrawingApp.deleteLastLine();
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
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH + 100, BUTTONHEIGHT);

        displayPanel.setBackground(Color.GREEN);
        displayPanel.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH + 150, BUTTONHEIGHT + 300);

        loadAndSaveLinesPanel.setBackground(Color.GREEN);
        loadAndSaveLinesPanel.setBounds(200,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT * 4);

    }

    //MODIFIES: this
    //EFFECTS: sets up the text area that shows what lines there are
    public static void textAndFieldSetup(JTextArea displayLines, JPanel displayPanel, JPanel mainImagePanel,
                                         LineDrawingApp lineDrawingApp, JTextField inputFieldColour,
                                         JTextField inputFieldWidth, JTextField inputFieldStart, JTextField ifEnd) {
        displayLines.setText(lineDrawingApp.exampleImage.howManyLinesText());
        displayPanel.add(displayLines);
        JLabel imageLabel = new JLabel(new ImageIcon("./data/golfswing.jpg")); //creates image icon);
        mainImagePanel.add(imageLabel);

        inputFieldColour.setPreferredSize(new Dimension(50, 50));
        inputFieldWidth.setPreferredSize(new Dimension(50, 50));
        inputFieldStart.setPreferredSize(new Dimension(50, 50));
        ifEnd.setPreferredSize(new Dimension(50, 50));
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
