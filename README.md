# My Personal Project - A Biomechanical Analysis Tool

## An application that allows users to *draw* on images or videos

**Application Features**
- Loading in an image/file
- Drawing on the image/file (e.g. A line from position (x1,y1) to (x2,y2))
- Deleting/erasing drawings
- Saving drawings

**Application Audience**
- Sports enthusiasts
- Sport coaches

**Project Inspiration**
- As a golfing enthusiast myself, I've often wondered if my body was doing what it was supposed to.
AKA *Feel vs Real*. Being able to have an application where I can draw a line on top of a body segment and see the relative
position changes will help me improve my swing!

## User Stories
- As a user I want to be able to specify line details and locations
- For example, a solid green line with width 20 from pixel locations (0,0) to (0,200)
- As a user, I want to be able to add a line once or repeatedly
- As a user, I want to be able to delete a specific line
- As a user, I want to be able to delete the last line
- As a user, I want to be able to clear all the lines
- As a user, I want to check if the Image is clear of all lines
- As a user, I want to see how many lines are still on the image and which ones they are
- //Added for Phase 2//
- As a user, I want to be able to save the line drawings I made on the image to a file
- As a user, I want to be able to load in the line drawings I made on the image from a file
#### Saved for next part of the project
- ~~As a user, I want to be able to load in an image~~ 
- ~~As a user, I want to be able to see the shape overlaid on the image~~

#### Phase 4: Task 2
- Choice 1: Made Image Class robust by throwing errors for the methods deleteSpecificLine and deleteLastLine.

#### Phase 4: Task 3
- I would make Lines extend an interface maybe called "Shapes" so that it's much easier to add new shapes
- I would also make my GUI more separate from my Main class where everything is currently sort of blotched together.
- I would also combine the LineDrawingApp with the GUI because right now it's a command line system and the GUI sort of just calls parts of that system.