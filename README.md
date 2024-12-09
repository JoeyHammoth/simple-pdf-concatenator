# A Simple PDF Concatenator :page_facing_up:
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/resources/logo.png" alt="drawing" width="100">
This is a simple PDF concatenator built using Java Swing and Pdfbox. It has 3 different functionalities: merging, reversing and concatenating. The primarily goal is to create a simple-to-us user interface that is capable of running these three functionalities and enable ease-of-use in handling pdf files without resorting to expensive commercial products such as Acrobat. This application is available for download for MacOS and Windows. The JAR executable is also available. 

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

# Citations # 
The project uses [packr](https://github.com/libgdx/packr) to create the appropriate application bundles needed to build the Windows and MacOS apps. Apache PDFBox was also used for implementing the different functionalities. 
