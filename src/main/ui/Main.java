package ui;

import javax.swing.*;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        final int MAINFRAMEWIDTH = 800;
        final int MAINFRAMEHEIGHT = 1000;
        final int BUTTONWIDTH = 300;
        final int BUTTONHEIGHT = 40;

        // JFrame code partly taken from javatpoint.com
        JFrame mainFrame = new JFrame("Line Drawing App");//creating instance of JFrame

        mainFrame.setSize(MAINFRAMEWIDTH, MAINFRAMEHEIGHT);
        mainFrame.setLayout(null);//using no layout managers
        mainFrame.setVisible(true);//making the frame visible
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton addLinesToImageButton = new JButton("Add Lines to Image");//creating instance of JButton
        addLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 250, BUTTONWIDTH, BUTTONHEIGHT);

        JButton loadLinesToImageButton = new JButton("Load Lines onto Image");//creating instance of JButton
        loadLinesToImageButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 200, BUTTONWIDTH, BUTTONHEIGHT);

        JButton quitButton = new JButton("Quit");//creating instance of JButton
        quitButton.setBounds((MAINFRAMEWIDTH - BUTTONWIDTH) / 2,
                MAINFRAMEHEIGHT - 150, BUTTONWIDTH, BUTTONHEIGHT);

        mainFrame.add(addLinesToImageButton);//adding button in JFrame
        mainFrame.add(loadLinesToImageButton);//adding button in JFrame
        mainFrame.add(quitButton);//adding button in JFrame


        try {
            new LineDrawingApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
