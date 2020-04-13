# Maze-Game <a name="intro"></a>  
Hello and welcome to my Maze-Game. Try and get to the end!

<img src="https://www.wikihow.com/images/thumb/4/40/Draw-a-Basic-Maze-Step-11.jpg/aid1126872-v4-728px-Draw-a-Basic-Maze-Step-11.jpg.webp">

Here is a piece of code showing the steps MazeGame.java will go through while playing the game.
```java
int moves = 0;

        while (!playerAtGoal())
        {
            printMaze();
            System.out.print("Type up, down, left, right or quit.\n");
            moveScanner = new Scanner(System.in);
            String move = moveScanner.nextLine();
            makeMove(move);
            moves++;
        }
```
<br>  

## Features <a name="features"></a>  
* 2 levels of difficulty. Easy and Hard.

* Leaves a trail of bread crumbs so the player knows where they have already been.

* Counts how many moves it took to reach the goal.  
<br>  

## Installation <a name="install"></a>  

The code my be downloaded <a href="https://murrayl2.github.io/Maze-Game/">here.</a>

After downloading the software run "MazeGame.Java" to start the game.  
<br>  

## Instructions  <a name="Instructions "></a>  

### Step 1:

Open the file named "MazeGame.Java".

### Step 2:

You will be prompted to type your preferred difficultly. Type "easy" or "hard".

### Step 3:

You will be prompted to type "up", "down", "left", "right", or "quit". Do so and press Enter.
```java
Type up, down, left, right or quit.
```

### Step 4:

Continue moving until you reach the goal or quit by typing "quit".  
<br>  

## FAQ <a name="FAQ"></a>  
Q: Are the mazes randomized?
* No, there are only 2 types of mazes and they do not change.

Q: How do I quit the game if I can't figure out how to reach the goal?
* Type "quit" when asked for a direction.

Q: Is there a time limit?
* No, feel free to take as much time as nessary.
<br>  

## Contributing <a name="con"></a>  
Any ideas to make this game better?
* Here is the [Source code](https://github.com/JDBrendel159/Rock-Paper-Scissors)
<br>  

## Support <a name="support"></a>  
If there are any issues you may email me at:

murrayl@appstate.edu  
<br>  

## License <a name="license"></a>  
Information for the [license](https://choosealicense.com/licenses/mit/)
