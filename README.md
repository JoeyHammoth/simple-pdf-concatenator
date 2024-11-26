# A Simple PDF Concatenator :page_facing_up:
This is a simple PDF concatenator built using Java Swing and Pdfbox. It has 3 different functionalities: merging, reversing and concatenating. This is mostly a side project used for me personally to handle the amount of pdf files that I have generated from scanning a bunch of my college notes. 

# Merging :bookmark_tabs:
The merging functionality involves being able to merge two pdf files each containing the even and odd pages of a single document respectively. This feature was something that I needed personally since my scanner wasn't able to scan pages in a double sided manner. Thus, I needed to cook something up to be able to handle this in a more conveniant and automated fashion rather than paying a fortune for acrobat. 

# Reversing :page_with_curl:
As the name suggests, this reverses the order of the pages for a single PDF file. Nothing fancy here, I did this to handle pdfs that were scanned in reverse order to get the even pages. 

# Concatenating :file_folder:
Again, pretty straightforward. This just basically concatenates two different PDF files. Did this since my scanner can only automatically scan a limited number of pages at a time. 

# Potential Extensibility Features :chart_with_upwards_trend:
- Make this application accessible in the web so that you can access it simply by clicking on some button or link. 
- Potentially make an exe out of this for more convenient access without running through the terminal. 
- Use ArrayLists to be able to upload and merge/concatenate more PDFs at once. Haven't figured out the appropriate Swing UI to enable this, however.
- Make a more convenient file directory system where the last directory is saved and doesn't just reset to some random directory.
- Utilize some design patterns that could potentially increase the efficiency of the program. Some ideas include using a singleton for each menu class to make sure there is only one instance of each menu instead of several menus overlapping each other.
- Do unit testing on the Java Swing application in order to verify that everything works. Maybe test for key performance metrics including but not limited to latency and others.

# Progress Updates :calendar:
## Background :milky_way: ##
As mentioned before, this project is mainly used as a means for me to handle a large number of pdf files that I need to sort out. The project itself is quite improvised with no extensive planning involved. It's mostly a Java refresher and an introduction to Swing, so I didn't do any sort of prep like sketching what the UI looks like, etc. 

## Optimizations :hammer: ##
After I was done with the bulk of the project, I figured it was a good idea to optimize the application a bit. Initially, the application was laid out such that everytime a new menu was accessed, a new instance of that menu was created. This worked fine, but I thought there was going to be some problems when it comes to memory since a lot of these new instances were going to be redundant. So I decided to utilize the singleton design pattern on the 4 menus (main, concat, reverse, merge). But this ended up making the whole thing much slower after accessing different menus for a couple of times. I don't really know why this is, but one theory is that it might have to do with recursive method calling, where a menu calls a method of another menu which calls a method of itself and this repeats over and over again, causing an exponential increase in time complexity. I decided that this was probably not going to work so I came up with four ideas. 

### Idea #1: Store Instances of the 3 Other Menus in each Menu ###
As the title suggests, each menu class will store seperate instances of the other 3 menus as seperate static attributes. This could decrease the time complexity since it's not calling the static getInstance() method of each menu class everytime it wants to access that menu, but instead it just access the menu through the stored attributed.

### Idea #2: Pass Around the same Instances of the 4 Menus between each other ###
Have the Main class implement an interface that stores references to all 4 menu instances and pass these around through compile-time polymorphism. This would increase coupling between classes but what can ya do...

### Idea #3: Create a new Instance for each Menu every set Number of Accesses ###
Since creating a new instance resets everything, we can create a new instance for each accessed menu after a set number of times that menu has been accessed. This can be achieved using inheritence. 

### Idea #4: Forgo the Optimization Idea Completely ###
Since it works well without any optimizations, why change it? Also, the JVM garbage collector will probably handle this, making it a non-issue.

### Update (3:42 AM 27/11/24) ###
I tried a number of options. First, I tried having all instances of all menus referenced in the interactable interface. I thought that an interface housing an attribute of a reference instance of a class that implements that same interface is not possible, but it turns out it is. Alas, this turned to naught since the same performance issues still remained. Thus, I tried to do idea #3 where I created an abstract class that contained a bunch of counters. Long story short, this didn't work as well. In the end, I'm just gonna stick with #4 and forget that I even tried to do this stuff. If anyone can help me understand this mess that would be greatly appreciated!!! Anyways, I'm gonna go to sleep since my head is about to explode 🤯

# Final Notes :black_nib:
This is mainly a side project used as personal refresher to basic Java programming as well as a dive into Java Swing. Hope to get more in-depth experience into Java GUI toolkits and libraries like Swing, AWT and FX. Probably a good idea to look at how this stuff can be utilized as a launching point to more involved technologies such as Spring and backend frameworks that houses MVC web app frameworks and such. 
