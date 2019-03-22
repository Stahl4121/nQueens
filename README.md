# nQueens
*COMP 445 - Artificial Intelligence - Project 2*  
*By Miriam Tan, Logan Stahl, and Sarah Calvis*


**The n-Queens Puzzle**  
Chess queens can move any number of spaces horizontally, vertically, or diagonally. One queen can attack another queen by moving into its space. The goal of the *n*-queens problem is to arrange *n* queens on an  *n* x *n*  board such that no queen can attack another queen.

**Our Search Algorithms**  
This project solves the *n*-queens problem using Depth First Search, Depth First Search with Backtracking, Depth First Search with Foward Checking, and Local Search with Random Restart.

**The files:**
* Driver_nQueens - Allows the user to select the search algorithm and number of queens.

* DFSAlgorithms - Holds Depth First Search, Depth First Search with Backtracking, and Depth First Search with Forward Checking.

* nQueenBoard - Holds a Board object with n queens.

* nQueenBoardFC - A modification of nQueenBoard to suit the needs of Depth First Search with Forward Checking.

* lsrrAlgorithm - Holds the algorithm of Local Search with Random Restart

**To Run:**
1. Run the program.

2. Type the number corresponding to the search algorithm you would like to use.

3. Input the number of queens you would like to use.

4. The program will output the solution found, the number of nodes expanded to find that solution, and the time the algorithm took.  



