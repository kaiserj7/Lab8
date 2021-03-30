import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame 
implements ActionListener {
  JTextField userGuessField;
  JButton guessButton, replayButton;
  JLabel JlabPromptGuess, JlabLastGuess, JlabHighLow;
  int randomNum;
  Random ran;

GuessingGame() {
  ran = new Random();
  randomNum = ran.nextInt(101)+1;

  JFrame frame = new JFrame ("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(240, 120);
  userGuessField = new JTextField(10);
  userGuessField.setActionCommand("myTF");
  guessButton = new JButton("Guess");
  replayButton = new JButton("Play Again");

  userGuessField.addActionListener(this);
  guessButton.addActionListener(this);
  replayButton.addActionListener(this);

  JlabPromptGuess = new JLabel("Enter Your Guess: ");
  JlabHighLow = new JLabel ("");
  JlabLastGuess = new JLabel("");

  frame.add(JlabPromptGuess);
  frame.add(userGuessField);
  frame.add(guessButton);
  frame.add(JlabHighLow);
  frame.add(JlabLastGuess);
  frame.add(replayButton);
  frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals("Guess")){

    int guess = Integer.parseInt(userGuessField.getText());

    if (guess < randomNum) {
      JlabHighLow.setText("Too Low");
    }
    else if (guess > randomNum) {
      JlabHighLow.setText("Too High");
    }
    else{
      JlabHighLow.setText("You Got It!!");
    }
    JlabLastGuess.setText("Last Guess was: " + userGuessField.getText());
  }
  else if(ae.getActionCommand().equals("PlayAgain")){
    randomNum = ran.nextInt(101) +1;
    JlabPromptGuess.setText("Enter your guess: ");
    JlabHighLow.setText("");
    JlabLastGuess.setText("");
    userGuessField.setText("");
  }
  else {
    JlabHighLow.setText("You pressed ENTER. Please press the guess button");
  }
}
}