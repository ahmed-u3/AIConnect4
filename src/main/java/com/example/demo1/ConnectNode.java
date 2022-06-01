package com.example.demo1;

public class ConnectNode implements Cloneable
{
    int winplayer=0;
    int winai=0;
    ConnectNode ParentNode;
    public int [][] ArrayNode=new int[6][7];
    double hurestic;
    public int move;
    ConnectNode(int[][] state)
    {
        ArrayNode=state;
    }

    ConnectNode(double hurestic)
    {
        this.hurestic=hurestic;
    }

    public ConnectNode() {}

    public void calculateHurestic()
    {
        check4();
    }
    public static ConnectNode max(ConnectNode n1,ConnectNode n2)
    {
        if (n1.hurestic>=n2.hurestic)
        {
            return n1;
        }
        else return n2;
    }
    public static ConnectNode min(ConnectNode n1,ConnectNode n2)
    {
        if (n1.hurestic>=n2.hurestic)
        {
            return n2;
        }
        else return n1;
    }
    public static ConnectNode Createchildnode(ConnectNode Node, int drop, Boolean maximizingplayer) throws CloneNotSupportedException
    {
        ConnectNode state = Node.clone();
        state.ParentNode =  Node.clone();
        for (int i = state.ArrayNode.length-1 ; i>=0; i--)
        {
            if (state.ArrayNode[i][drop]==0)
            {
                if (maximizingplayer)
                {
                    state.ArrayNode[i][drop] = 2;
                }
                else
                {
                    state.ArrayNode[i][drop] = 1;
                }
                state.move=drop;
                state.didPlayerWin(state.ArrayNode);
                state.didAIWin(state.ArrayNode);
                state.calculateHurestic();
                return state;
            }
        }
        return null;
    }

    public void didPlayerWin(int[][] state)
    {
        int player ;
        winplayer=0;
        player=1;

        final int HEIGHT = state.length;
        final int WIDTH = state[0].length;
        for (int r = 0; r < HEIGHT; r++)
        { // iterate rows, bottom to top
            { // iterate rows, bottom to top
                for (int c = 0; c < WIDTH; c++)
                { // iterate columns, left to right

                    if (c + 3 < WIDTH &&
                            player == state[r][c+1] && // look right
                            player == state[r][c+2] &&
                            player == state[r][c+3]&&player == state[r][c])
                    {winplayer++;}

                    if (r + 3 < HEIGHT) {
                        if (player == state[r+1][c] && // look up
                                player == state[r+2][c] &&
                                player == state[r+3][c]&& player == state[r][c])
                         {winplayer++;}
                        if (c + 3 < WIDTH &&
                                player == state[r+1][c+1] && // look up & right
                                player == state[r+2][c+2] &&
                                player == state[r+3][c+3]&&player == state[r][c])
                               {winplayer++;}
                        if (c - 3 >= 0 &&
                                player == state[r+1][c-1] && // look up & left
                                player == state[r+2][c-2] &&
                                player == state[r+3][c-3]&&player == state[r][c])
                              {winplayer++;}
                    }
                }
            }
        }
    }
    public void didAIWin(int[][] state)
    {
        int player ;
        winai=0;
        player=2;

        final int HEIGHT = state.length;
        final int WIDTH = state[0].length;
        for (int r = 0; r < HEIGHT; r++)
        { // iterate rows, bottom to top
            { // iterate rows, bottom to top
                for (int c = 0; c < WIDTH; c++)
                { // iterate columns, left to right

                    if (c + 3 < WIDTH &&
                            player == state[r][c+1] && // look right
                            player == state[r][c+2] &&
                            player == state[r][c+3]&&player == state[r][c])
                    {winai++;}

                    if (r + 3 < HEIGHT) {
                        if (player == state[r+1][c] && // look up
                                player == state[r+2][c] &&
                                player == state[r+3][c]&& player == state[r][c])
                        {winai++;}
                        if (c + 3 < WIDTH &&
                                player == state[r+1][c+1] && // look up & right
                                player == state[r+2][c+2] &&
                                player == state[r+3][c+3]&&player == state[r][c])
                        {winai++;}
                        if (c - 3 >= 0 &&
                                player == state[r+1][c-1] && // look up & left
                                player == state[r+2][c-2] &&
                                player == state[r+3][c-3]&&player == state[r][c])
                        {winai++;}
                    }
                }
            }
        }
    }
    public ConnectNode clone()
    {
        ConnectNode Node=new ConnectNode();
        this.equals(Node);
        Node.ParentNode=this.ParentNode;
        Node.hurestic=this.hurestic;
        Node.winplayer=this.winplayer;
        Node.winai=this.winai;
        Node.move=this.move;
        return Node;
    }
    public void equals(ConnectNode n)
    {
        for (int i = 0; i < n.ArrayNode.length; i++)
        {
            for (int j = 0; j < n.ArrayNode[i].length; j++)
            {
                n.ArrayNode[i][j] = this.ArrayNode[i][j];
            }
        }
    }
    public boolean isFull()
    {
        for (int i = 0; i < 7; i++)
        {
            if(ArrayNode[0][i] == 0)
            {
                return false;
            }

        }
        return true;
    }
    public void display()
    {
        for (int i = 0; i < 6; i++)
        {
            System.out.print("            | ");
            for (int j = 0; j < 7; j++)
            {
                System.out.print(ArrayNode[i][j] + " | ");
            }
            System.out.println();
            System.out.print("            -----------------------------");
            System.out.println();
        }
        System.out.println();
    }
    public boolean equal(ConnectNode n)
    {
        for (int i = 0; i < n.ArrayNode.length; i++)
        {
            for (int j = 0; j < n.ArrayNode[i].length; j++)
            {
                if(n.ArrayNode[i][j] !=this.ArrayNode[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void check4()
    {
        hurestic=0;

       if (ArrayNode[5][0]==1)
        {
            hurestic-=3;

        }

        if (ArrayNode[4][0]==1)
        {
            hurestic-=4;
        }
        if (ArrayNode[3][0]==1)
        {
            hurestic-=5;
        }
        if (ArrayNode[2][0]==1)
        {
            hurestic-=5;
        }

        if (ArrayNode[1][0]==1)
        {hurestic-=4;}
        if (ArrayNode[0][0]==1)
        {hurestic-=3;}
        if (ArrayNode[5][1]==1)
        {
        hurestic-=4;
        }

        if (ArrayNode[4][1]==1)
        {
            hurestic-=6;
        }
        if (ArrayNode[3][1]==1)
        {
            hurestic-=8;
        }
        if (ArrayNode[2][1]==1)
        {
            hurestic-=8;
        }

        if (ArrayNode[1][1]==1)
        {hurestic-=6;}
        if (ArrayNode[0][1]==1)
        {hurestic-=4;}
        if (ArrayNode[5][2]==1)
        {
            hurestic-=5;
        }

        if (ArrayNode[4][2]==1)
        {
            hurestic-=8;
        }
        if (ArrayNode[3][2]==1)
        {
            hurestic-=11;
        }
        if (ArrayNode[2][2]==1)
        {
            hurestic-=11;
        }

        if (ArrayNode[1][2]==1)
        {hurestic-=8;}
        if (ArrayNode[0][2]==1)
        {hurestic-=5;}
        if (ArrayNode[5][3]==1)
        {
            hurestic-=7;
        }

        if (ArrayNode[4][3]==1)
        {
            hurestic-=10;
        }
        if (ArrayNode[3][3]==1)
        {
            hurestic-=13;
        }
        if (ArrayNode[2][3]==1)
        {
            hurestic-=13;
        }

        if (ArrayNode[1][3]==1)
        {hurestic-=10;}
        if (ArrayNode[0][3]==1)
        {hurestic-=7;}
        if (ArrayNode[5][4]==1)
        {
            hurestic-=5;
        }

        if (ArrayNode[4][4]==1)
        {
            hurestic-=8;
        }
        if (ArrayNode[3][4]==1)
        {
            hurestic-=11;
        }
        if (ArrayNode[2][4]==1)
        {
            hurestic-=11;
        }

        if (ArrayNode[1][4]==1)
        {hurestic-=8;}
        if (ArrayNode[0][4]==1)
        {hurestic-=5;}
        if (ArrayNode[5][5]==1)
        {
            hurestic-=4;
        }

        if (ArrayNode[4][5]==1)
        {
            hurestic-=6;
        }
        if (ArrayNode[3][5]==1)
        {
            hurestic-=8;
        }
        if (ArrayNode[2][5]==1)
        {
            hurestic-=8;
        }

        if (ArrayNode[1][5]==1)
        {hurestic-=6;}
        if (ArrayNode[0][5]==1)
        {hurestic-=4;}
        if (ArrayNode[5][6]==1)
        {
            hurestic-=3;
        }

        if (ArrayNode[4][6]==1)
        {
            hurestic-=4;
        }
        if (ArrayNode[3][6]==1)
        {
            hurestic-=5;
        }
        if (ArrayNode[2][6]==1)
        {
            hurestic-=5;
        }

        if (ArrayNode[1][6]==1)
        {hurestic-=4;}
        if (ArrayNode[0][6]==1)
        {hurestic-=3;}



        if (ArrayNode[5][0]==2)
        {
            hurestic+=3;
        }

        if (ArrayNode[4][0]==2)
        {
            hurestic+=4;
        }
        if (ArrayNode[3][0]==2)
        {
            hurestic+=5;
        }
        if (ArrayNode[2][0]==2)
        {
            hurestic+=5;
        }

        if (ArrayNode[1][0]==2)
        {hurestic+=4;}
        if (ArrayNode[0][0]==2)
        {hurestic+=3;}
        if (ArrayNode[5][1]==2)
        {
            hurestic+=4;
        }

        if (ArrayNode[4][1]==2)
        {
            hurestic+=6;
        }
        if (ArrayNode[3][1]==2)
        {
            hurestic+=8;
        }
        if (ArrayNode[2][1]==2)
        {
            hurestic+=8;
        }

        if (ArrayNode[1][1]==2)
        {hurestic+=6;}
        if (ArrayNode[0][1]==2)
        {hurestic+=4;}
        if (ArrayNode[5][2]==2)
        {
            hurestic+=5;
        }

        if (ArrayNode[4][2]==2)
        {
            hurestic+=8;
        }
        if (ArrayNode[3][2]==2)
        {
            hurestic+=11;
        }
        if (ArrayNode[2][2]==2)
        {
            hurestic+=11;
        }

        if (ArrayNode[1][2]==2)
        {hurestic+=8;}
        if (ArrayNode[0][2]==2)
        {hurestic+=5;}
        if (ArrayNode[5][3]==2)
        {
            hurestic+=7;
        }

        if (ArrayNode[4][3]==2)
        {
            hurestic+=10;
        }
        if (ArrayNode[3][3]==2)
        {
            hurestic+=13;
        }
        if (ArrayNode[2][3]==2)
        {
            hurestic+=13;
        }

        if (ArrayNode[1][3]==2)
        {hurestic+=10;}
        if (ArrayNode[0][3]==2)
        {hurestic+=7;}
        if (ArrayNode[5][4]==2)
        {
            hurestic+=5;
        }

        if (ArrayNode[4][4]==2)
        {
            hurestic+=8;
        }
        if (ArrayNode[3][4]==2)
        {
            hurestic+=11;
        }
        if (ArrayNode[2][4]==2)
        {
            hurestic+=11;
        }

        if (ArrayNode[1][4]==2)
        {hurestic+=8;}
        if (ArrayNode[0][4]==2)
        {hurestic+=5;}
        if (ArrayNode[5][5]==2)
        {
            hurestic+=4;
        }

        if (ArrayNode[4][5]==2)
        {
            hurestic+=6;
        }
        if (ArrayNode[3][5]==2)
        {
            hurestic+=8;
        }
        if (ArrayNode[2][5]==2)
        {
            hurestic+=8;
        }

        if (ArrayNode[1][5]==2)
        {hurestic+=6;}
        if (ArrayNode[0][5]==2)
        {hurestic+=4;}
        if (ArrayNode[5][6]==2)
        {
            hurestic+=3;
        }

        if (ArrayNode[4][6]==2)
        {
            hurestic+=4;
        }
        if (ArrayNode[3][6]==2)
        {
            hurestic+=5;
        }
        if (ArrayNode[2][6]==2)
        {
            hurestic+=5;
        }

        if (ArrayNode[1][6]==2)
        {hurestic+=4;}
        if (ArrayNode[0][6]==2)
        {hurestic+=3;}


        hurestic+=100000*winai;

        hurestic-=100000*winplayer;

    }

}
