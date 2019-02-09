# MasterMind - A java console implementation of the famous mastermind game
--------------------------------------------------------------------------

# Program Description

Input 
-----
The program reads the game configuration from the colors.txt file. The colors.txt file
has the following format:
<number-of-pegs>
<color-1>
   |
   |
   |
<color-n>
The minimum number of colors are 3 and there are no maximum numbers. The program reads from
the list of colors and creates a unique color code of length <number-of-pegs>
Each of the color is assigned a sequential score -> 1,2,3.....,N

Execution
---------
You'll see a list of colors when starting the game. This game only awards points when the peg 
of same color is at same position. The number of points awarded is a random number.
You can select number of rounds to be run - has to be less than 10 - as per the game standards

Output
---------
Output of the execution is logged and written in the output.txt file for further reference.