# SquareTrouble
 A game is played by two players on a 3 by 3 board. The board’s squares are marked in a similar manner to chess. e.g. the square on the bottom left corner is a1 and so on. (You can google for an explanation of chess square notation if this is not very clear.)	Player 1 goes first and marks an X on any square of the board. Also, any square adjacent to the square marked X on his turn are also marked X except for the ones diagonally adjacent e.g. if he marks square b1 with an X, then squares a1, c1 and b2 are all marked with an X. Player 2 marks an O on any square of the board not marked with an X, and the adjacent squares (except for the ones already marked) are marked with an O following the same rules as above. For example, if player 1 marks an X on square b1 on an open board, then, if player 2 marks an O on square a2, then squares a3 and b2 are marked with an O but not square a1 since it has already been marked with X from the previous turn of player 1. The player who fills in the last remaining square(s) wins the game. Write a program that enables two players to play this game.

```
# How to Run
javac SquareTrouble.java
java SquareTrouble

Player 1, enter the position [1-9] to place X
1
-------------------------------------------------
X       -       -
-       -       -
-       -       -
-------------------------------------------------
Player 2, enter the position [1-9] to place O
2
-------------------------------------------------
X       O       -
-       -       -
-       -       -
-------------------------------------------------
Player 1, enter the position [1-9] to place X
3
-------------------------------------------------
X       O       X
-       -       -
-       -       -
-------------------------------------------------
Player 2, enter the position [1-9] to place O
4
-------------------------------------------------
X       O       X
O       -       -
-       -       -
-------------------------------------------------
Player 1, enter the position [1-9] to place X
5
-------------------------------------------------
X       O       X
O       X       -
-       -       -
-------------------------------------------------
Player 2, enter the position [1-9] to place O
6
-------------------------------------------------
X       O       X
O       X       O
-       -       -
-------------------------------------------------
Player 1, enter the position [1-9] to place X
7
-------------------------------------------------
X       O       X
O       X       O
X       -       -
-------------------------------------------------
-------------------------------------------------
Gave Over!, Player 1 is winner
-------------------------------------------------
X       O       X
O       X       O
X       -       -
-------------------------------------------------
```
