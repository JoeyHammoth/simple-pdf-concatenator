# A Simple PDF Concatenator
This is a simple PDF concatenator built using Java Swing and Pdfbox. It has 3 different functionalities: merging, reversing and concatenating. 
This is mostly a side project used for me personally to handle the amount of pdf files that I have generated from scanning a bunch of my college notes. 

# Merging
The merging functionality involves being able to merge two pdf files each containing the even and odd pages of a single document respectively. This feature was something that I needed
personally since my scanner wasn't able to scan pages in a double sided manner. Thus, I needed to cook something up to be able to handle this in a more conveniant and automated fashion 
rather than paying a fortune for acrobat. 

# Reversing 
As the name suggests, this reverses the order of the pages for a single PDF file. Nothing fancy here, I did this to handle pdfs that were scanned in reverse order to get the even pages. 

# Concatenating 
Again, pretty straightforward. This just basically concatenates two different PDF files. Did this since my scanner can only automatically scan a limited number of pages at a time. 

# Potential Extensibility Features
- Make this application accessible in the web so that you can access it simply by clicking on some button or link.
- Potentially make an exe out of this for more convenient access without running through the terminal. 
- Use ArrayLists to be able to upload and merge/concatenate more PDFs at once. Haven't figured out the appropriate Swing UI to enable this, however.
- Make a more convenient file directory system where the last directory is saved and doesn't just reset to some random directory.

# Final Notes 
This is mainly a side project used as personal refresher to basic Java programming as well as a dive into Java Swing. Hope to get more in-depth experience into Java GUI toolkits and libraries like 
Swing, AWT and FX. Probably a good idea to look at how this stuff can be utilized as a launching point to more involved technologies such as Spring and backend frameworks that houses MVC web app frameworks and such. 
