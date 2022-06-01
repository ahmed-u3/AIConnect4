package com.example.demo1;

public class ALPHABETA
{
    static int nodeno;
    public static ConnectNode AlphaBeta(ConnectNode Node, int depth,ConnectNode alpha,ConnectNode beta,boolean maximizingplayer) throws CloneNotSupportedException
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
                    ConnectNode eval = AlphaBeta(child, depth - 1,alpha,beta, false).clone();
                    maxEval = ConnectNode.max(maxEval, eval);
                    alpha=ConnectNode.max(alpha,maxEval);
                    if (alpha.hurestic> beta.hurestic)
                    {    nodeno++;
                            break;}
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
                if(child !=null) {
                    ConnectNode eval = AlphaBeta(child, depth - 1,alpha,beta, true).clone();
                    minEval = ConnectNode.min(minEval, eval);
                    beta=ConnectNode.min(beta,minEval);
                    if (alpha.hurestic> beta.hurestic)
                    {    nodeno++;
                        break;
                    }
                }
            }
            return minEval;
        }
    }
}
