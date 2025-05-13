# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
    prints the directory tree
    uses options to use color and show hidden files.


## ConsoleColor.java
uses enums escape code for console text
used to create colors that can be added to strings to color them in the console.


## ColorPrinter.java / ColorPrinterTest.java
creates a printstream object from the directory and assigns colors to each line of the printstream.
also handles resetting to a 'default' color value if assumed.
primarily we will implementing a method to print from the printstream and assigning color values through consolecolor.


## TruffulaOptions.java / TruffulaOptionsTest.java
handles recieving data from the command line and actually understand what we will be doing with that data. 
For example, this will see if a no-color flag is raised and be the thing that signals the rest of the program that it is raised.
This interacts directly with the command line.

## TruffulaPrinter.java / TruffulaPrinterTest.java
managing which options are being used, and printing tree accordingly.
sets up defaults for color.
uses ColorPrinter instead of system.out.


## AlphabeticalFileSorter.java
takes in an array of files, and sorts them in alphabetical and returns the array.