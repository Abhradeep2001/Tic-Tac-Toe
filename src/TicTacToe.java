import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
    //Instance of Random class
    Random random=new Random();
    //JFrame class
    JFrame jframe=new JFrame();
    //JPanel class
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    //Text field to display a message using JLabel
    JLabel textfield=new JLabel();
    //JButton Array
    JButton [] buttons=new JButton[9]; //For 9 buttons in a tic-tac-toe game
    boolean player1_turn; //If 'True' player 1's turn, if 'False' player 2's turn


    //Constructor Function of TicTacToe class
    TicTacToe(){
        //To create a new JFrame
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set size of the frame
        jframe.setSize(900,900);
        //Set backgorund color of JFrame
        jframe.getContentPane().setBackground(new Color(50,50,50));
        //Set a border layout
        jframe.setLayout(new BorderLayout());
        //Set visibility of JFrame
        jframe.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        //text color
        textfield.setForeground(new Color(25,255,0));
        //font style & size
        textfield.setFont(new Font("Ink Free",Font.BOLD,70));
        //Horizontal Alignment
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //To set the 'Title' of the game
        textfield.setText("Tic-Tac-Toe Game");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        //To start from the top left corner(0,0)
        title_panel.setBounds(0,0,900,100); //(x,y,width,height)

        //Features of buttonpanel
        button_panel.setLayout(new GridLayout(3,3)); //3 cross 3 grid
        button_panel.setBackground(new Color(0,150,150));

        //To customise all the buttons using JButton Array
        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            //To add buttons to our button panel
            button_panel.add(buttons[i]);
            //To style the buttons
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
            buttons[i].setFocusable(false);
            //To add any actionListener
            buttons[i].addActionListener(this); //Current particular button
        }


        //To add text field to our titlepanel and add titlepanel to the top of our jframe
        title_panel.add(textfield);
        jframe.add(title_panel,BorderLayout.NORTH);

        //To add button panel to our jframe
        jframe.add(button_panel);

        //To determine whose turn is first
        firstTurn();
    }

    //To add umimplemented Methods
        //Utilizing actionperformed method(for actionlistener)
    @Override
    public void actionPerformed(ActionEvent e){
        //TODO auto generated method stub
            //Action-Response for any "Button-Click"
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]) {
                //Player 1's Turn
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        //Set color to button for "X"
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        //To change turns
                        player1_turn = false;
                        textfield.setText("O's Turn");
                        check();
                    }
                }

                //Player 2's Turn
                else {
                    if (buttons[i].getText() == "") {
                        //Set color to button for "O"
                        buttons[i].setForeground(new Color(0, 255, 0));
                        buttons[i].setText("O");
                        //To change turns
                        player1_turn = true;
                        textfield.setText("X's Turn");
                        check();
                    }
                }
            }
        }
    }
    //Function to dtermine whose turn is first 'X' or 'O'
    public void firstTurn(){

        //To set a 2sec delay after starting the game
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            //TODO Auto generated catch block
            e.printStackTrace();
        }

        //To generate 0 or 1 randomly
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X's Turn");
        }
        else{
            player1_turn=false;
            textfield.setText("O's Turn");
        }

    }
    //Function to see if there are any winning conditions
    public void check(){
        //check X win Conditions(All possible combinations)
        if(
                buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X"
        ){
            xWins(0,1,2); //To send the winning coordinates
        }
        if(
                buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X"
        ){
            xWins(6,7,8);
        }
        if(
                buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X"
        ){
            xWins(0,3,6);
        }
        if(
                buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X"
        ){
            xWins(2,5,8);
        }
        if(
                buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X"
        ){
            xWins(1,4,7);
        }
        if(
                buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X"
        ){
            xWins(0,4,8);
        }
        if(
                buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X"
        ){
            xWins(3,4,5);
        }
        if(
                buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X"
        ){
            xWins(2,4,6);
        }

        //check O win conditions(All possible combinations)
        if(
                buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O"
        ){
            oWins(0,1,2); //To send the winning coordinates
        }
        if(
                buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O"
        ){
            oWins(6,7,8);
        }
        if(
                buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O"
        ){
            oWins(0,3,6);
        }
        if(
                buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O"
        ){
            oWins(2,5,8);
        }
        if(
                buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O"
        ){
            oWins(1,4,7);
        }
        if(
                buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O"
        ){
            oWins(0,4,8);
        }
        if(
                buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O"
        ){
            oWins(3,4,5);
        }
        if(
                buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O"
        ){
            oWins(2,4,6);
        }

    }
    //If 'X' wins
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(new Color(0,255,255));
        buttons[b].setBackground(new Color(0,255,255));
        buttons[c].setBackground(new Color(0,255,255));

        buttons[a].setForeground(new Color(0,0,255));
        buttons[a].setForeground(new Color(0,0,255));
        buttons[a].setForeground(new Color(0,0,255));


        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Congratulations X has Won!!");
    }
    //If 'O' wins
    public void oWins(int a,int b,int c){
        buttons[a].setBackground(new Color(0,255,255));
        buttons[b].setBackground(new Color(0,255,255));
        buttons[c].setBackground(new Color(0,255,255));

        buttons[a].setForeground(new Color(0,0,255));
        buttons[a].setForeground(new Color(0,0,255));
        buttons[a].setForeground(new Color(0,0,255));

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Congratulations O has Won!!");

    }
}
