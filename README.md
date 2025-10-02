
# Horse Race Simulator Program in Java

This document aims to guide the user throught the setup instructions, dependencies required and usage guidelines.






## Dependencies

- Java
- JDK
- An IDE especially visual studio code is highly recommended, although not essential.

### Libraries

The necessary libraries have been included within the program, which are listed below.


- Swing
- Scanner
- Awt 
- Concurrent (TimeUnit)



## Setup instructions

Unzip the horse race simulator folder by right clicking on it and selecting extract all.

Move the folder to a directory of your choice (any child folder of your user directory).

Open command prompt, and navigate to the directory that the extracted file is stored in.

As you open command prompt you will see:

```bash
C:\Users\yourusername
```

This is the parent folder of all the files associated with your account.

From here you need to navigate to the directory.

Use to move forward through files to the extracted folder. This is very important, as the program accesses images using the HorseRaceSimulator folder as the root path.

```bash
cd filename
```
The root folder structure should look like 

```bash
RootFolder/
│
├── Part1/ # Code for Part I
└── Part2/ # Code for Part II
```

Please note that if you have extracted a zip folder it will produce the two folder of the same name with parent child relationship. So you need to make sure you are on the parent folder(NOT grandparent) of Part1 and Part2.

Once you have done that run the following command.

```bash 
javac Part1/*.java Part2/*.java
```
This will compile all the java files in the folders.

It is important that you run this exact command as trying to compile each file separately will result in an error.

Now run

```bash
java Part1.Main
```

This will now ask you whether you want to run the gui version or not.

And your response will run the appropriate programs.

**Note:** Ensure your java compiler and java run time environment are both up to date. You can reinstall java and JDK to make sure you have the latest version.


## Usage Guidelines

- The program will ask you if you want to run the text-based terminal version of the code. Any answer other than Yes (not case sensitive) or Y (not case sensitive), will be interpreted as a no. Then the gui version of the program will run.

- You are are given the freedom to select names for your horses and give them a confidence value. Please note that validation conditions are in place for setting confidence. An array of horses have already been declared with sensible values to facilitate the gui component.


- The symbols are purposefully kept to simple ASCII characters such as @ , # , $ to ensure compatibility between all systems. It is not reccomended to enter unconventional unicode character as there could be many isses such as difference in fonts, UTF-8 encoding and IDE settings.

- If you require further flexibility in the program, you are free to edit the main method as you wish, such as allowing the race to occur 10 times instead of 5 etc. Please ensure the changes are done before the compilation.







