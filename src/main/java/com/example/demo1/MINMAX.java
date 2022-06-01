package com.example.demo1;

public class MINMAX
{
  static int nodeno;
    public static ConnectNode minimax(ConnectNode Node, int depth,boolean maximizingplayer) throws CloneNotSupportedException
    {
        if (depth==0||Node.isFull())
        {
            return Node;
        }

        if (maximizingplayer)
        {
            ConnectNode maxEval=new ConnectNode(Double.NEGATIVE_INFINITY);
            for (int i=0;i<7;i++)
            {
                ConnectNode child=ConnectNode.Createchildnode(Node,i,true);
                if(child !=null)
                {
                    ConnectNode eval = minimax(child, depth - 1, false);
                    maxEval = ConnectNode.max(maxEval, eval);
                    nodeno++;
                }
            }
            return maxEval;
        }

        else
        {
            ConnectNode minEval=new ConnectNode(Double.POSITIVE_INFINITY);
            for (int i=0;i<7;i++)
            {
                ConnectNode child=ConnectNode.Createchildnode(Node,i,false);
                if(child !=null)
                {
                    ConnectNode eval = minimax(child, depth - 1, true);
                    minEval = ConnectNode.min(minEval, eval);
                    nodeno++;
                }
            }

            return minEval;
        }
    }

}

