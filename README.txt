README 
-- ENSF380 Final Project --
Whole package must be compiled. This can be done through an IDE 
or by typing: 

javac edu/ucalgary/oop/GUI.java

Into the commandline in the ENSF300-FINAL-PROJECT dirctory.
After compilation the prgram needs to be run. This can also be 
done through an IDE or by typing:

java -cp .;lib/mysql-connector-java-8.0.23.jar edu.ucalgary.oop.GUI

Into the commandline in the ENSF300-FINAL-PROJECT dirctory.
Once run a new window will appear that will prompt the user for
a date to generate a schedule for.
Using the spinners or typing in the boxes the required fields for
day, month and year must be filled out. Then the 'generate schedule'
button can be clicked in order to generate the schedule for the 
inputted date. If generated without issue the next screen contains
buttons to display the schedule and to download a txt file containing 
the schedule. If there are issues with the generation of the schedule
popups will guide the user through the relevant issues to resolve them.

The first issue is if multiple volunteers are required to perform the 
generated schedule. In this instance a popup will appear asking for 
permission to add a volunteer to the relevant hour. 

The seccond issue
is if the generated schedule is not possible. When this is detected a
popup will appear asking if the user wants to modify the treatment 
database in order to remedy detected conflicts. Additionally users
may also modify the database from the menu where the download and
display schedule buttons are.