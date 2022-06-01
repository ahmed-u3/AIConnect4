package com.example.demo1;

public class Backend
{
    int[][]state={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
    int Label=1; //Next Turn
    ConnectNode root = new ConnectNode(state); //Current State
    int PlayerScore; //Score of Player
    int AiScore;//Score of AI
    int tempmove;
    String mode;//Switch between Alphabeta and Minimax
    Backend()
    {}
    public void checkWin2()//AI (Yellow)
    {
        final int HEIGHT = state.length;
        final int WIDTH = state[0].length;
        AiScore=0;
        for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
                int player = 2;

                if (c + 3 < WIDTH &&
                        player == state[r][c+1] && // look right
                        player == state[r][c+2] &&
                        player == state[r][c+3]&&player == state[r][c])
                    AiScore++;
                if (r + 3 < HEIGHT) {
                    if (player == state[r+1][c] && // look up
                            player == state[r+2][c] &&
                            player == state[r+3][c] &&player == state[r][c])
                        AiScore++;
                    if (c + 3 < WIDTH &&
                            player == state[r+1][c+1] && // look up & right
                            player == state[r+2][c+2] &&
                            player == state[r+3][c+3] &&player == state[r][c])
                        AiScore++;
                    if (c - 3 >= 0 &&
                            player == state[r+1][c-1] && // look up & left
                            player == state[r+2][c-2] &&
                            player == state[r+3][c-3]&&player == state[r][c])
                        AiScore++;
                }
            }
        }
    }
    public void checkWin1()
    {
        final int HEIGHT = state.length;
        final int WIDTH = state[0].length;
        PlayerScore=0;
        for (int r = 0; r < HEIGHT; r++)
        { // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++)
            { // iterate columns, left to right
                int player = 1;

                if (c + 3 < WIDTH &&
                        player == state[r][c+1] && // look right
                        player == state[r][c+2] &&
                        player == state[r][c+3]&&player == state[r][c])
                    PlayerScore++;
                if (r + 3 < HEIGHT) {
                    if (player == state[r+1][c] && // look up
                            player == state[r+2][c] &&
                            player == state[r+3][c]&& player == state[r][c])
                        PlayerScore++;
                    if (c + 3 < WIDTH &&
                            player == state[r+1][c+1] && // look up & right
                            player == state[r+2][c+2] &&
                            player == state[r+3][c+3]&&player == state[r][c])
                        PlayerScore++;
                    if (c - 3 >= 0 &&
                            player == state[r+1][c-1] && // look up & left
                            player == state[r+2][c-2] &&
                            player == state[r+3][c-3]&&player == state[r][c])
                        PlayerScore++;
                }
            }
        }
    }
    public void Play(int col) throws CloneNotSupportedException
    {
        for(int i=state.length-1;i>-1;i--)
        {
            if (state[i][col]== 0)
            {
                if (Label==1) //Player 1
                {
                    state[i][col]=1;
                    root.ArrayNode[i][col] =1;
                    checkWin1();
                    checkWin2();
                    display(state);
                    System.out.println("AI Score: "+AiScore+ "\nPlayer Score: "+PlayerScore);
                    if (isFull()&&PlayerScore>AiScore) //Player 1 win
                    {
                        System.out.println("Player 1 win");
                        display(state);
                        break;
                    }
                    else if (isFull()&&PlayerScore<AiScore) //Player 2 win
                    {
                        System.out.println("Player 2 win");
                        display(state);
                        break;
                    }
                    else if (isFull()&&PlayerScore==AiScore) //Draw
                    {
                        System.out.println("Draw");
                        display(state);
                        break;
                    }
                    else //Continue
                    {
                        Ai();
                        break;
                    }
                }
                else //AI turn
                {

                    state[i][col]=2;
                    root.ArrayNode[i][col] =2;
                    checkWin1();
                    checkWin2();
                    display(state);
                    System.out.println("AI Score: "+AiScore+"\nPlayer Score: "+PlayerScore);

                    if (isFull()&&PlayerScore>AiScore) //Player 1 win
                    {
                        System.out.println("Player 1 win");
                        display(state);
                        break;
                    }
                    else if (isFull()&&PlayerScore<AiScore) //Player 2 win
                    {
                        System.out.println("Player 2 win");
                        display(state);
                        break;
                    }
                    else if (isFull()&&PlayerScore==AiScore) //Draw
                    {
                        System.out.println("Draw");
                        display(state);
                        break;
                    }
                    else //Continue
                    {
                        Label=1;
                        break;
                    }
                }
            }

        }
    }

    public void Ai () throws CloneNotSupportedException
    {
        if (mode=="MiniMax")
        {
            Label=2;
            ConnectNode temp = root;
            long start=System.nanoTime();
            temp = MINMAX.minimax(temp, 6, true);
            long end=System.nanoTime();
            tempmove=Return(temp).move;
            Play(tempmove);
            System.out.println("Number of nodes: "+MINMAX.nodeno);
            System.out.println("Minimax move: "+tempmove);
            System.out.println("Hurestic: "+temp.hurestic);
            System.out.println("Minimax Time: "+(end-start)+" Nanoseconds");
        }
        else
        {
            ConnectNode Alpha = new ConnectNode(Double.NEGATIVE_INFINITY);
            ConnectNode Beta = new ConnectNode(Double.POSITIVE_INFINITY);
            Label=2;
            ConnectNode temp = root;
            long start=System.nanoTime();
            temp = ALPHABETA.AlphaBeta(temp, 6,Alpha,Beta, true);
            long end=System.nanoTime();
            tempmove=Return(temp).move;
            Play(tempmove);
            System.out.println("Number of nodes: "+ALPHABETA.nodeno);
            System.out.println("Alpha beta move: "+tempmove);
            System.out.println("Hurestic: "+temp.hurestic);
            System.out.println("AlphaBeta Time: "+(end-start)+" Nanoseconds");
        }
    }
    public void reset()
    {
        int[][]newstate={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        state=newstate;
        root.ArrayNode=state;
    }

    public ConnectNode Return(ConnectNode N)
    {
        if (N.ParentNode.equal(root) )
        {
            return N;
        }
      else return Return(N.ParentNode);
    }



    public static void display(int[][] grid)
    {
        for (int i = 0; i < 6; i++)
        {
            System.out.print("            | ");
            for (int j = 0; j < 7; j++)
            {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.print("            -----------------------------");
            System.out.println();
        }
        System.out.println();
    }
    public boolean isFull()
    {
        for (int i = 0; i < 7; i++)
        {
            if(state[0][i] == 0)
            {
                return false;
            }

        }
        return true;
    }
}
