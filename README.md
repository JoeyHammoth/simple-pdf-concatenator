# A Simple PDF Concatenator :page_facing_up:
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/resources/logo.png" alt="logo" width="100">

This is a simple PDF concatenator built using Java Swing and Pdfbox. It has 3 different functionalities: merging, reversing and concatenating. The primarily goal is to create a simple-to-us user interface that is capable of running these three functionalities and enable ease-of-use in handling pdf files without resorting to expensive commercial products such as Acrobat. This application is available for download for MacOS and Windows. The JAR executable is also available. The Javadoc is available [here](https://joeyhammoth.github.io/simple-pdf-concatenator/).

# Features 🌆 #

## Merging :bookmark_tabs: ##
The merging functionality involves being able to merge two pdf files each containing the even and odd pages of a single document respectively.

## Reversing :page_with_curl: ##
As the name suggests, this reverses the order of the pages for a single PDF file. 

## Concatenating :file_folder: ##
Concatenates two different PDF files. 

# Installation ⬇️ #
Latest release can be found [here](https://github.com/JoeyHammoth/simple-pdf-concatenator/releases/tag/1.0.0). \
[Download the JAR file](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.jar) \
[Download for MAC](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.dmg) \
[Download for Windows64](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.zip)

To run the JAR executable, run the following command on the terminal in the same directory as the executable:
```bash
   java -jar simple-pdf-concatenator.jar
```
# Usage 🖱️ #

## Main Menu 🎋 ##
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/images/main-menu.png" alt="main-menu" width="200">
The main menu screen is the first thing that pops up when you open the application. You have a choice of four options: merging, reversing, concatenating and exiting. 

## Merge Menu 🌳 ##
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/images/merge-menu.png" alt="merge-menu" width="200">
In the merge menu, you can the even and odd files that you want to merge together, the output directory and output name.

## Reverse Menu 🌲 ##
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/images/reverse-menu.png" alt="reverse-menu" width="200">
In the reverse menu, you can add the all the files that you want to reverse, the output directory and output name. If there are multiple files to be reversed, the file number will be added next to the output name for each reversed file (e.g. name0, name1, etc). 

## Concatenation Menu 🌴 ##
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/images/con-menu.png" alt="concat-menu" width="200">
In the concatenation menu, you can add the all the files that you want to concatenate together, the output directory and output name.

# Project Structure 📁 #
```
simple-pdf-concatenator
├── LICENSE
├── README.md
├── images
│   ├── con-menu.png
│   ├── main-menu.png
│   ├── merge-menu.png
│   ├── reverse-menu.png
│   └── simple-pdf-concatenator-image.png
├── installations
│   ├── resources
│   │   └── logo.png
│   ├── simple-pdf-concatenator.dmg
│   ├── simple-pdf-concatenator.jar
│   └── simple-pdf-concatenator.zip
├── out
│   ├── artifacts
│   │   └── simple_pdf_concatenator_jar
│   │       └── simple-pdf-concatenator.jar
│   └── production
│       ├── pdf-concatenator
│       │   ├── Chooser$1.class
│       │   ├── Chooser.class
│       │   ├── Concat.class
│       │   ├── ConcatMenu$1.class
│       │   ├── ConcatMenu$2.class
│       │   ├── ConcatMenu.class
│       │   ├── Interactable.class
│       │   ├── Main.class
│       │   ├── MainMenu$1.class
│       │   ├── MainMenu$2.class
│       │   ├── MainMenu$3.class
│       │   ├── MainMenu.class
│       │   ├── MergeMenu$1.class
│       │   ├── MergeMenu$2.class
│       │   ├── MergeMenu.class
│       │   ├── Merger.class
│       │   ├── ReverseMenu$1.class
│       │   ├── ReverseMenu$2.class
│       │   ├── ReverseMenu.class
│       │   └── Reverser.class
│       └── simple-pdf-concatenator
│           ├── AbstractMenu.class
│           ├── Chooser$1.class
│           ├── Chooser.class
│           ├── Interactable.class
│           ├── META-INF
│           │   └── MANIFEST.MF
│           ├── Main.class
│           ├── MainMenu$1.class
│           ├── MainMenu$2.class
│           ├── MainMenu$3.class
│           ├── MainMenu$4.class
│           ├── MainMenu.class
│           ├── MergeMenu$1.class
│           ├── MergeMenu$2.class
│           ├── MergeMenu.class
│           ├── Merger.class
│           ├── MultiConcat.class
│           ├── MultiConcatMenu$1.class
│           ├── MultiConcatMenu$2.class
│           ├── MultiConcatMenu$3.class
│           ├── MultiConcatMenu.class
│           ├── MultiReverseMenu$1.class
│           ├── MultiReverseMenu$2.class
│           ├── MultiReverseMenu$3.class
│           ├── MultiReverseMenu.class
│           └── MultiReverser.class
├── simple-pdf-concatenator.iml
└── src
    ├── META-INF
    │   └── MANIFEST.MF
    ├── Main.java
    └── pdf
        └── concat
            ├── Chooser.java
            ├── function
            │   ├── Merger.java
            │   ├── MultiConcat.java
            │   └── MultiReverser.java
            └── menu
                ├── AbstractMenu.java
                ├── Interactable.java
                ├── MainMenu.java
                ├── MergeMenu.java
                ├── MultiConcatMenu.java
                └── MultiReverseMenu.java
```
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/diagram.png" alt="concat-menu">

# Potential Extensibility Features :chart_with_upwards_trend:
- Make this application accessible in the web so that you can access it simply by clicking on some button or link ❎
- Potentially make an executable out of this for more convenient access without running through the terminal ☑️
- Use ArrayLists to be able to upload and merge/concatenate more PDFs at once. Haven't figured out the appropriate Swing UI to enable this, however ☑️
- Make a more convenient file directory system where the last directory is saved and doesn't just reset to some random directory ☑️
- Utilize some design patterns that could potentially increase the efficiency of the program. Some ideas include using a singleton for each menu class to make sure there is only one instance of each menu instead of several menus overlapping each other ☑️
- Do unit testing on the Java Swing application in order to verify that everything works. Maybe test for key performance metrics including but not limited to latency and others ❎
- When required fields are blank, mark or highlight them when the user clicks the "go" button ☑️
- Save file directory information so that when the user go from the main menu to the a feature, the fields are the same as when the user last left them ☑️
- Alerting the user if a non-pdf file is selected ☑️

# Citations & License ⚖️ # 
The project uses [packr](https://github.com/libgdx/packr) to create the appropriate application bundles needed to build the Windows and MacOS apps. Apache PDFBox was also used for implementing the different functionalities. More project details and documentation can be found in the [wiki](https://github.com/JoeyHammoth/simple-pdf-concatenator/wiki). This project is licensed under the MIT license. 
