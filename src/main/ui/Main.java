package ui;

import model.Line;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new LineDrawingApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
