package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable
{
    //By Ahmed Yousri
    //PS: Initial depth is 6
    //PS: Reset sometimes is lagging so please restart the application   , Ahmed Yousri :D
    Backend back=new Backend();
    int Label=1;
    int PlayerScore;
    int AiScore;
    @FXML
    Label AiScoreLabel;
    @FXML
    Label PlayerScoreLabel;
    @FXML
    private AnchorPane scenePane;
    @FXML
     Circle Circle00,Circle01,Circle02,Circle03,Circle04,Circle05,Circle10,Circle11,Circle12,Circle13,Circle14,Circle15,Circle20,Circle21,Circle22,Circle23,Circle24,Circle25,Circle30,Circle31,Circle32,Circle33,Circle34,Circle35,Circle40,Circle41,Circle42,Circle43,Circle44,Circle45,Circle50,Circle51,Circle52,Circle53,Circle54,Circle55,Circle60,Circle61,Circle62,Circle63,Circle64,Circle65;

    @FXML
    ChoiceBox<String> ChooseMode;
    private String[] mode = {"MiniMax", "Alpha-Beta"};


    public void Button1(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle05,Circle04,Circle03,Circle02,Circle01,Circle00 };
        back.Play(0);
        Play(C);
    }
    public void Button2(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle15,Circle14,Circle13,Circle12,Circle11,Circle10};
        back.Play(1);
        Play(C);
    }
    public void Button3(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle25,Circle24,Circle23,Circle22,Circle21,Circle20};
        back.Play(2);
        Play(C);
    }
    public void Button4(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle35,Circle34,Circle33,Circle32,Circle31,Circle30};
        back.Play(3);
        Play(C);
    }
    public void Button5(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle45,Circle44,Circle43,Circle42,Circle41,Circle40};
        back.Play(4);
        Play(C);
    }
    public void Button6(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle55,Circle54,Circle53,Circle52,Circle51,Circle50};
        back.Play(5);
        Play(C);
    }
    public void Button7(ActionEvent e) throws CloneNotSupportedException {
        Circle[] C = {Circle65,Circle64,Circle63,Circle62,Circle61,Circle60};
        back.Play(6);
        Play(C);
    }
    public void win1()
    {
        PlayerScore=0;
        Color C=Color.RED;

        Circle []myCircle={Circle00,Circle01,Circle02,Circle03,Circle04,Circle05,Circle10,Circle11,Circle12,Circle13,Circle14,Circle15,Circle20,Circle21,Circle22,Circle23,Circle24,Circle25,Circle30,Circle31,Circle32,Circle33,Circle34,Circle35,Circle40,Circle41,Circle42,Circle43,Circle44,Circle45,Circle50,Circle51,Circle52,Circle53,Circle54,Circle55,Circle60,Circle61,Circle62,Circle63,Circle64,Circle65};
        //start of vertical
        for (int i=0;i<24;i++)
        {
        if (myCircle[i].getFill() == C && myCircle[i+6].getFill() == C && myCircle[i+12].getFill() == C && myCircle[i+18].getFill() == C)
        {
            PlayerScore++;
        }
        }
        //end of vertical

        //start of horizontal
        for (int i=3;i<6;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }

        }
        for (int i=9;i<12;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }

        }
        for (int i=15;i<18;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }
        }
        for (int i=21;i<24;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }

        }
        for (int i=27;i<30;i++)
        {
        if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
        {
            PlayerScore++;
        }

        }
        for (int i=33;i<36;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }

        }
        for (int i=39;i<=41;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                PlayerScore++;
            }
        }


        //end of horizontal

        //start Diagonal to the right
        for (int i=0;i<3;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=6;i<9;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=12;i<15;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=18;i<21;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                PlayerScore++;
            }
        }
        //end diagonal to the right

        //start diagonal to the left
        for (int i=18;i<21;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=24;i<27;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=30;i<33;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                PlayerScore++;
            }
        }

        for (int i=36;i<39;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                PlayerScore++;
            }
        }

        //end diagonal to the left
    }
    public void win2()
    {
        AiScore=0;
        Color C=Color.YELLOW;

        Circle []myCircle={Circle00,Circle01,Circle02,Circle03,Circle04,Circle05,Circle10,Circle11,Circle12,Circle13,Circle14,Circle15,Circle20,Circle21,Circle22,Circle23,Circle24,Circle25,Circle30,Circle31,Circle32,Circle33,Circle34,Circle35,Circle40,Circle41,Circle42,Circle43,Circle44,Circle45,Circle50,Circle51,Circle52,Circle53,Circle54,Circle55,Circle60,Circle61,Circle62,Circle63,Circle64,Circle65};
        //start of vertical
        for (int i=0;i<24;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+6].getFill() == C && myCircle[i+12].getFill() == C && myCircle[i+18].getFill() == C)
            {
                AiScore++;
            }
        }
        //end of vertical

        //start of horizontal
        for (int i=3;i<6;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }

        }
        for (int i=9;i<12;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }

        }
        for (int i=15;i<18;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }
        }
        for (int i=21;i<24;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }

        }
        for (int i=27;i<30;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }

        }
        for (int i=33;i<36;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }

        }
        for (int i=39;i<=41;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-1].getFill() == C && myCircle[i-2].getFill() == C && myCircle[i-3].getFill() == C)
            {
                AiScore++;
            }
        }


        //end of horizontal

        //start Diagonal to the right
        for (int i=0;i<3;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=6;i<9;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=12;i<15;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=18;i<21;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i+7].getFill() == C && myCircle[i+14].getFill() == C && myCircle[i+21].getFill() == C)
            {
                AiScore++;
            }
        }
        //end diagonal to the right

        //start diagonal to the left
        for (int i=18;i<21;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=24;i<27;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=30;i<33;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                AiScore++;
            }
        }

        for (int i=36;i<39;i++)
        {
            if (myCircle[i].getFill() == C && myCircle[i-5].getFill() == C && myCircle[i-10].getFill() == C && myCircle[i-15].getFill() == C)
            {
                AiScore++;
            }
        }

        //end diagonal to the left
    }

    public void ButtonReset()
    {
        Platform.setImplicitExit(false);
        Circle [] C= {Circle00,Circle01,Circle02,Circle03,Circle04,Circle05,Circle10,Circle11,Circle12,Circle13,Circle14,Circle15,Circle20,Circle21,Circle22,Circle23,Circle24,Circle25,Circle30,Circle31,Circle32,Circle33,Circle34,Circle35,Circle40,Circle41,Circle42,Circle43,Circle44,Circle45,Circle50,Circle51,Circle52,Circle53,Circle54,Circle55,Circle60,Circle61,Circle62,Circle63,Circle64,Circle65};
        for (int i=0;i<42;i++)
        {
            C[i].setFill(Color.WHITE);
        }
        back.reset();
        Label=1;
    }
    public boolean isFull()
    {
        Circle[] C = {Circle60,Circle50,Circle40,Circle30,Circle20,Circle10,Circle00 };
        for (int i=0;i<C.length;i++)
        {
            if (C[i].getFill()==Color.WHITE)
            {
                return false;
            }
        }
        return true;
    }
    public void Play(Circle []C) throws CloneNotSupportedException {
        for(int i=0;i<6;i++)
        {
            if (C[i].getFill()== Color.WHITE)
            {
                if (Label==1)
                {
                    C[i].setFill(Color.RED);
                    win1();
                    win2();
                    if (PlayerScore>AiScore&&isFull())
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("CONGRATULATE You Won :O");
                        alert.setContentText("Player Win\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {
                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else if (AiScore>PlayerScore && isFull())
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("LOSER XD");
                        alert.setContentText("AI Win\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            back.reset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {
                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else if (AiScore==PlayerScore&&isFull())
                    {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("DRAW");
                        alert.setContentText("DRAW\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            back.reset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {
                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else
                    {
                    Ai();
                    break;
                    }
                }
                else
                {
                    C[i].setFill(Color.YELLOW);
                    win1();
                    win2();
                    if (PlayerScore>AiScore&&isFull())
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("CONGRATULATE You Won :O");
                        alert.setContentText("Player Win\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {

                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else if (AiScore>PlayerScore&&isFull())
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("LOSER XD");
                        alert.setContentText("AI Win\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            back.reset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {
                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else if (AiScore==PlayerScore&&isFull())
                    {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("DRAW");
                        alert.setContentText("DRAW\nDo you want to reset?");
                        if (alert.showAndWait().get()==ButtonType.OK)
                        {
                            ButtonReset();
                            back.reset();
                            Label=1;
                        }
                        else if (alert.showAndWait().get()==ButtonType.CANCEL)
                        {
                            System.exit(0);
                        }
                        alert.show();
                        break;
                    }
                    else
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
        Label=2;
        if (back.tempmove==0)
        {
            Circle[] C = {Circle05,Circle04,Circle03,Circle02,Circle01,Circle00 };
            Play(C);
        }
       else if (back.tempmove==1)
        {
            Circle[] C = {Circle15,Circle14,Circle13,Circle12,Circle11,Circle10};
            Play(C);
        }
       else if (back.tempmove==2)
        {
            Circle[] C = {Circle25,Circle24,Circle23,Circle22,Circle21,Circle20};
            Play(C);
        }
       else if (back.tempmove==3)
        {
            Circle[] C = {Circle35,Circle34,Circle33,Circle32,Circle31,Circle30 };
            Play(C);
        }
       else if (back.tempmove==4)
        {
            Circle[] C = {Circle45,Circle44,Circle43,Circle42,Circle41,Circle40 };
            Play(C);
        }
       else if (back.tempmove==5)
        {
            Circle[] C = {Circle55,Circle54,Circle53,Circle52,Circle51,Circle50 };
            Play(C);
        }
        else if (back.tempmove==6)
        {
            Circle[] C = {Circle65,Circle64,Circle63,Circle62,Circle61,Circle60 };
            Play(C);
        }
       AiScoreLabel.setText(Integer.toString(AiScore));
       PlayerScoreLabel.setText(Integer.toString(PlayerScore));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ChooseMode.getItems().addAll(mode);
        ChooseMode.setOnAction(this::choosemode);
    }
    public void choosemode(ActionEvent event){
        String m=ChooseMode.getValue();
        if(m.equals("MiniMax"))
        {
            back.mode="MiniMax";
        }
        else
        {
            back.mode="AlphaBeta";
        }
    }
}