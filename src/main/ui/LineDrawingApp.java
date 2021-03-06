package ui;

import exceptions.EmptyImageException;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LineDrawingApp {
    protected static final String JSON_STORE = "./data/image.json";
    protected Scanner input;
    protected Image exampleImage;
    protected JsonWriter jsonWriter;
    protected JsonReader jsonReader;

    // UI code here largely based off of the TellerApp.
    // EFFECTS: runs the application
    public LineDrawingApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
//        runApp();
    }

    // MODIFIES: this
    // EFFECTS: takes the user input while displaying a menu of options
    void runApp() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command when they choose to add a line (option a). User starts with only option to add.
    void processCommand(String command) {
        if (command.equals("a")) {
            addLine();
            nextStage();
        } else if (command.equals("b")) {
            loadImage();
            nextStage();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads Image from file
    void loadImage() {
        try {
            exampleImage = jsonReader.read();
            System.out.println("Loaded " + exampleImage.getLines().size() + " lines" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    // MODIFIES: this
    // EFFECTS: initializes Image
    void init() {
        exampleImage = new Image();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user. This is the main menu and one out of two total.
    void displayMenu() {
        System.out.println("\nWould you like to:");
        System.out.println("\ta -> Add Lines to Image");
        System.out.println("\tb -> Load Lines onto Image");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: adds a line to the image by taking in its four fields from the user.
    void addLine() {
        String lineColour;
        int lineWidth;
        String lineStart;
        String lineEnd;
        Line newLine;

        System.out.print("Enter the Line Colour: ");
        lineColour = input.next();

        if (lineColour.matches("-?[0-9]+")) {
            System.out.print("Come on... we both know numbers aren't a colour! I didn't say RGB values!\n");
        } else {
            System.out.print("Enter the Line Width (e.g. 10): ");
            lineWidth = input.nextInt();

            System.out.print("Enter the Line starting (x,y) coordinates: ");
            lineStart = input.next();

            System.out.print("Enter the Line ending (x,y) coordinates: ");
            lineEnd = input.next();

            newLine = new Line(lineColour, lineWidth, lineStart, lineEnd);

            exampleImage.addLine(newLine);


            System.out.println("You have added a " + lineColour + " line with width " + lineWidth + " from "
                    + lineStart + " to " + lineEnd + " on the image.\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: takes the user input for the next stage after a line is added.
    void nextStage() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayMenuTwo();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                System.out.println("\nBack to the starting menu~\n");
                keepGoing = false;
            } else {
                processCommandSecond(command);
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: processes user command with the second menu.
    void processCommandSecond(String command) {
        switch (command) {
            case "a":
                addLine();
                break;
            case "b":
                checkEmpty();
                break;
            case "c":
                howManyLines();
                break;
            case "d":
                clearAllLines();
                break;
            case "e":
                deleteLastLine();
                break;
            case "f":
                deleteSpecificLine();
                break;
            case "g":
                saveImage();
                break;
        }
    }

    // EFFECTS: saves the image to file
    void saveImage() {
        try {
            jsonWriter.open();
            jsonWriter.write(exampleImage);
            jsonWriter.close();
            System.out.println("Saved " + exampleImage.getLines().size() + " lines" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: displays the options of the second menu to user
    void displayMenuTwo() {
        System.out.println("\nWhat would you like to do next?:");
        System.out.println("\ta -> Add more Lines to Image");
        System.out.println("\tb -> Check if the Image is empty");
        System.out.println("\tc -> Check how many Lines there are on the Image");
        System.out.println("\td -> Clear all the Lines from the Image");
        System.out.println("\te -> Delete the last Line added");
        System.out.println("\tf -> Delete a specific Line");
        System.out.println("\tg -> Save the Lines on the Image");
        System.out.println("\tq -> Go back to starting Menu");
    }

    // MODIFIES: this
    // EFFECTS: checks if the image is empty or not
    void checkEmpty() {
        if (exampleImage.emptyImage()) {
            System.out.println("The Image is empty and doesn't have lines.\n");
        } else {
            System.out.println("The Image is not empty and has lines.\n");
        }

    }

    // MODIFIES: this
    // EFFECTS: checks how many lines there are on the image
    void howManyLines() {
        StringBuilder listOfLines = new StringBuilder();
        if (exampleImage.howManyLinesText().equals("There are 0 lines on the drawing.")) {
            exampleImage.howManyLinesText();
        } else {
            System.out.println(exampleImage.howManyLinesText() + ".\n");
            for (Line line : exampleImage.getLines()) {
                listOfLines.append(line.getLineColour()).append(" with width ").append(line.getLineWidth()).append(
                        " from ").append(line.getLineStart()).append(" to ").append(line.getLineEnd()).append(" and ");
                System.out.println("These lines are " + listOfLines + "that's all.\n");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: checks how many lines there are on the image and returns text
    public String howManyLinesInText() {
        StringBuilder listOfLines = new StringBuilder();
        if (exampleImage.howManyLinesText().equals("There are 0 lines on the drawing.")) {
            return listOfLines.toString();
        } else {
            System.out.println(exampleImage.howManyLinesText() + ".\n");
            for (Line line : exampleImage.getLines()) {
                listOfLines.append(line.getLineColour()).append(" with width ").append(line.getLineWidth()).append(
                        " from ").append(line.getLineStart()).append(" to ").append(line.getLineEnd()).append(" and ");
                System.out.println("These lines are " + listOfLines + "that's all.\n");
            }
        }
        return listOfLines.toString();
    }

    // MODIFIES: this
    // EFFECTS: clears all the lines
    void clearAllLines() {
        exampleImage.clearLines();
        System.out.println("The image is now cleared of all lines.\n");

    }

    // MODIFIES: this
    // EFFECTS: deletes the last line added
    void deleteLastLine() {
        if (exampleImage.getLines().isEmpty()) {
            System.out.println("The Image is already empty dummy.\n");
        } else {
            try {
                exampleImage.deleteLastLine();
                System.out.println("The last added line as been removed.\n");
            } catch (EmptyImageException e) {
                System.out.println("Error, the image was already empty!");
            }

        }

    }

    // MODIFIES: this
    // EFFECTS: deletes a specific line indexed starting from 0
    void deleteSpecificLine() {
        int indexNumber;
        System.out.print("Enter the index number of the line you want to remove.\n");
        indexNumber = input.nextInt();
        if (indexNumber < exampleImage.getLines().size()) {
            try {
                exampleImage.deleteSpecificLine(indexNumber);
                System.out.print("Ok, the line in position " + indexNumber + " has been deleted.\n");
            } catch (EmptyImageException e) {
                System.out.println("Error, the image was already empty!");
            }

        } else {
            System.out.print("Error! " + indexNumber + " is greater than the Index! Remember index starts from 0!\n");
        }
    }
}
