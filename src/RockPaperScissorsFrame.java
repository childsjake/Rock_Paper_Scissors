import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl;

    JPanel controlPnl;
    JButton rockBtn;
    ImageIcon rockIcon;
    JButton paperBtn;
    ImageIcon paperIcon;
    JButton scissorsBtn;
    ImageIcon scissorsIcon;
    JButton quitBtn;
    ImageIcon quitIcon;

    JPanel statsPnl;
    JLabel playerWinsLbl;
    JLabel computerWinsLbl;
    JLabel tiesLbl;
    JTextField playerWinsTF;
    JTextField computerWinsTF;
    JTextField tiesTF;
    int playerWinCount = 0;
    int computerWinCount = 0;
    int tieCount = 0;

    JPanel displayPnl;
    JTextArea displayTA;
    JScrollPane scroller;

    ArrayList<String> resultList;
    ArrayList<String> symbolList;
    Random rnd = new Random();
    int symbolIndex;

    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.EAST);

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.WEST);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        add(mainPnl);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        setLocation(screenWidth / 8, screenHeight / 8);
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        resultList = new ArrayList<>();
        resultList.add("Rock breaks scissors (Player wins)");
        resultList.add("Rock breaks scissors (Computer wins)");
        resultList.add("Rock ties rock (Tie)");
        resultList.add("Paper covers rock (Players wins)");
        resultList.add("Paper covers rock (Computer wins)");
        resultList.add("Paper ties paper (Tie)");
        resultList.add("Scissors cuts paper (Player wins)");
        resultList.add("Scissors cuts paper (Computer wins)");
        resultList.add("Scissors ties scissors (Tie)");

        symbolList = new ArrayList<>();
        symbolList.add("Rock");
        symbolList.add("Paper");
        symbolList.add("Scissors");
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(1, 1));
        displayPnl.setBorder(new TitledBorder(new EtchedBorder(), "Game Results"));
        displayTA = new JTextArea(30,30);
        displayTA.setEditable(false);
        displayTA.setFont(new Font("Serif", Font.PLAIN, 24));
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    private void createStatsPanel()
    {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3,2));
        statsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));

        playerWinsLbl = new JLabel("Player Wins: ");
        playerWinsLbl.setFont(new Font("Serif", Font.BOLD, 40));
        playerWinsTF = new JTextField(10);
        playerWinsTF.setFont(new Font("Serif", Font.PLAIN, 40));
        playerWinsTF.setEditable(false);
        playerWinsTF.setText(playerWinCount + "");
        playerWinsTF.setHorizontalAlignment(SwingConstants.CENTER);

        computerWinsLbl = new JLabel("Computer Wins: ");
        computerWinsLbl.setFont(new Font("Serif", Font.BOLD, 40));
        computerWinsTF = new JTextField(10);
        computerWinsTF.setFont(new Font("Serif", Font.PLAIN, 40));
        computerWinsTF.setEditable(false);
        computerWinsTF.setText(computerWinCount + "");
        computerWinsTF.setHorizontalAlignment(SwingConstants.CENTER);

        tiesLbl = new JLabel("Ties: ");
        tiesLbl.setFont(new Font("Serif", Font.BOLD, 40));
        tiesTF = new JTextField(10);
        tiesTF.setFont(new Font("Serif", Font.PLAIN, 40));
        tiesTF.setEditable(false);
        tiesTF.setText(tieCount + "");
        tiesTF.setHorizontalAlignment(SwingConstants.CENTER);

        statsPnl.add(playerWinsLbl);
        statsPnl.add(playerWinsTF);
        statsPnl.add(computerWinsLbl);
        statsPnl.add(computerWinsTF);
        statsPnl.add(tiesLbl);
        statsPnl.add(tiesTF);

    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(4, 1));
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(), "Options"));

        rockIcon = new ImageIcon("src/RockIcon.png");
        rockBtn = new JButton("Rock: ", rockIcon);
        rockBtn.setHorizontalTextPosition(JButton.LEFT);
        rockBtn.setFont(new Font("Serif", Font.BOLD, 60));
        rockBtn.addActionListener((ActionEvent ae) ->
        {
            String symbol = getRandomSymbol();
            if (symbol.equals("Rock"))
            {
                displayTA.append(resultList.get(2) +"\n");
                tieCount++;
                tiesTF.setText(tieCount + "");
            }
            if (symbol.equals("Paper"))
            {
               displayTA.append(resultList.get(4) +"\n");
               computerWinCount++;
               computerWinsTF.setText(computerWinCount + "");
            }
            if (symbol.equals("Scissors"))
            {
                displayTA.append(resultList.get(0) +"\n");
                playerWinCount++;
                playerWinsTF.setText(playerWinCount + "");
            }
        });

        paperIcon = new ImageIcon("src/PaperIcon.png");
        paperBtn = new JButton("Paper: ", paperIcon);
        paperBtn.setHorizontalTextPosition(JButton.LEFT);
        paperBtn.setFont(new Font("Serif", Font.BOLD, 60));
        paperBtn.addActionListener((ActionEvent ae) ->
        {
            String symbol = getRandomSymbol();
            if (symbol.equals("Paper"))
            {
                displayTA.append(resultList.get(5) +"\n");
                tieCount++;
                tiesTF.setText(tieCount + "");
            }
            if (symbol.equals("Scissors"))
            {
                displayTA.append(resultList.get(7) +"\n");
                computerWinCount++;
                computerWinsTF.setText(computerWinCount + "");
            }
            if (symbol.equals("Rock"))
            {
                displayTA.append(resultList.get(3) +"\n");
                playerWinCount++;
                playerWinsTF.setText(playerWinCount + "");
            }
        });

        scissorsIcon = new ImageIcon("src/ScissorsIcon.png");
        scissorsBtn = new JButton("Scissors: ", scissorsIcon);
        scissorsBtn.setHorizontalTextPosition(JButton.LEFT);
        scissorsBtn.setFont(new Font("Serif", Font.BOLD, 60));
        scissorsBtn.addActionListener((ActionEvent ae) ->
        {
            String symbol = getRandomSymbol();
            if (symbol.equals("Scissors"))
            {
                displayTA.append(resultList.get(8) +"\n");
                tieCount++;
                tiesTF.setText(tieCount + "");
            }
            if (symbol.equals("Rock"))
            {
                displayTA.append(resultList.get(1) +"\n");
                computerWinCount++;
                computerWinsTF.setText(computerWinCount + "");
            }
            if (symbol.equals("Paper"))
            {
                displayTA.append(resultList.get(6) +"\n");
                playerWinCount++;
                playerWinsTF.setText(playerWinCount + "");
            }
        });

        quitIcon = new ImageIcon("src/QuitIcon.png");
        quitBtn = new JButton("Quit: ", quitIcon);
        quitBtn.setHorizontalTextPosition(JButton.LEFT);
        quitBtn.setFont(new Font("Serif", Font.BOLD, 60));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);
    }

    private String getRandomSymbol()
    {
        symbolIndex = rnd.nextInt(symbolList.size());
        return symbolList.get(symbolIndex);
    }


}

