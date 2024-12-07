# A Simple PDF Concatenator :page_facing_up:
<img src="https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/resources/logo.png" alt="drawing" width="100">
This is a simple PDF concatenator built using Java Swing and Pdfbox. It has 3 different functionalities: merging, reversing and concatenating. This is mostly a side project used for me personally to handle the amount of pdf files that I have generated from scanning a bunch of my college notes. 

# Merging :bookmark_tabs:
The merging functionality involves being able to merge two pdf files each containing the even and odd pages of a single document respectively. This feature was something that I needed personally since my scanner wasn't able to scan pages in a double sided manner. Thus, I needed to cook something up to be able to handle this in a more conveniant and automated fashion rather than paying a fortune for acrobat. 

# Reversing :page_with_curl:
As the name suggests, this reverses the order of the pages for a single PDF file. Nothing fancy here, I did this to handle pdfs that were scanned in reverse order to get the even pages. 

# Concatenating :file_folder:
Again, pretty straightforward. This just basically concatenates two different PDF files. Did this since my scanner can only automatically scan a limited number of pages at a time. 

# Installation #
[Download the JAR file](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.jar) \
[Download for MAC](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.dmg) \
[Download for Windows64](https://github.com/JoeyHammoth/simple-pdf-concatenator/blob/main/installations/simple-pdf-concatenator.zip)


# Potential Extensibility Features :chart_with_upwards_trend:
- Make this application accessible in the web so that you can access it simply by clicking on some button or link ❎
- Potentially make an executable out of this for more convenient access without running through the terminal ☑️
- Use ArrayLists to be able to upload and merge/concatenate more PDFs at once. Haven't figured out the appropriate Swing UI to enable this, however ☑️
- Make a more convenient file directory system where the last directory is saved and doesn't just reset to some random directory ☑️
- Utilize some design patterns that could potentially increase the efficiency of the program. Some ideas include using a singleton for each menu class to make sure there is only one instance of each menu instead of several menus overlapping each other ☑️
- Do unit testing on the Java Swing application in order to verify that everything works. Maybe test for key performance metrics including but not limited to latency and others.
- When required fields are blank, mark or highlight them when the user clicks the "go" button ☑️
- Save file directory information so that when the user go from the main menu to the a feature, the fields are the same as when the user last left them ☑️
- Alerting the user if a non-pdf file is selected ☑️

# Final Notes :black_nib:
This is mainly a side project used as personal refresher to basic Java programming as well as a dive into Java Swing. Hope to get more in-depth experience into Java GUI toolkits and libraries like Swing, AWT and FX. Probably a good idea to look at how this stuff can be utilized as a launching point to more involved technologies such as Spring and backend frameworks that houses MVC web app frameworks and such. 
