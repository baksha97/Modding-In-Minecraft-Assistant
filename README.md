# Modding in Minecraft: Assistant

During my time at CodeAdvantage, I noticed the repetition of lengthy tasks that students were required to do -almost everyday. 
In my free time, I decided to build a program to my the lives of my students and myself easier by using this Java Swing GUI with various libraries for file management. 
This executable file has then been used and installed on all of the company's computers so that the students and the teachers are seamlessly able to complete restoring and completing code from a repository to get to the most important part of the lessons -teaching programming concepts.
# Features
	Import custom Java classes from the pre-lesson repositories into the Java Project with ease, taking into consideration the ages of the students and the time limitations. 

	Import custom files from folders containing student modifications into the Java project modding main (Forge Minecraft) for two different modding curricula.

	Added the functionality and support to include multiple students, importations, and curricula via the style of development.

	Added support to run necessary command line functions to facilitate workspace setup and troubleshooting.

	Handle student’s work during the modification of their Java code in accordance to lesson plan post-lesson repositories. 

# Recent updates
•	No longer restricted to one student; an unlimited amount of students may work on the same computer. 

o	We can now use this program to sort each computer to each student. The program will have the name of the student, allowing students to get to their computers with much more ease. We won't have to number each computer nor search each texture folder for a match. 

o	Students can just select their own name instead! The menu is automatically populated with their names from the folder of Students. 
•	Students can open their project from the loader! No more searching for the eclipse.exe and selecting their workspace. As long as the files conform to the format that I have specified.

•	The ability to import student textures alone has been removed from the main interface and moved into a menu since it is only used in rare situations.

•	Importing a lesson further than intended is now easier to downgrade! It's also automatic! Just reimport the needed lesson and the workspace will be adjusted.

•	The Gradle setup has been moved into a menu, where you are able to run it -opening a new window with the command's output (the process input stream) for instantly debugging issues! 

o	Each student workspace will have their own Gradle setup.

•	If the program encounters an error and begins misfunctioning by a means that had been taken into consideration during the development, it will generate a file "latest_stack_trace_error.txt" which you can then look at and/or have emailed via an IT form. 

•	The flexibility of the new Assistant makes restarting a class' computer set is even easier! Create a PRE Lesson 01 as the default setup for a student in the PRE repo, and use to one-click import to instantly make it ready for the next student [Just remove the Textures folder].

o	It may even be beneficial to keep a bunch of student projects that other students may view and play on for inspiration.

o	This may even be useful for the "slow" classes that may be able to do the same curriculum over two semesters.

•	The loader continues to be universal in terms of lesson plans and their imports. Any changes to the lesson plans will not affect the loader as long as the appropriate repositories have been updated. 

# Folder Conformity 

``` * [/Desktop/Minecraft]
   * ├── Minecraft Code
   * │   └── /FIRE
   * │   │   └── /Pre Lesson Repo
   * │   │       └── /Lesson 01
   * │   │           └── /JavaLessons
   * │   │           └── /Minecraft
   * │   │       ...
   * │   │   └── /Post Lesson Repo
   * │   │       └── /Lesson 01
   * │   │       ...
   * │   └── /ICE
   * │       └── /Pre Lesson Repo
   * │           ...
   * │       └── /Post Lesson Repo
   * │           ...
   * ├── Students
   * │   └── /Travie
   * │       └── /src
   * │       └── /Textures {the student's custom textures}
   * │       └── /eclipse
   * │           └── /JavaLessons
   * ├── eclipse
   * │   └── /eclipse.exe
   * └── README.md 
   ```

 
![](https://github.com/baksha97/Modding-In-Minecraft-Assistant/blob/master/assistant_screens/layout.png)

# Screens
GUI:
![](https://github.com/baksha97/Modding-In-Minecraft-Assistant/blob/master/assistant_screens/interface.png)
![](https://github.com/baksha97/Modding-In-Minecraft-Assistant/blob/master/assistant_screens/menu.png)
