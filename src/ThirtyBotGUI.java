import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeppe Vinberg on 17-04-2016.
 */
public class ThirtyBotGUI extends JFrame {

    public ThirtyBot thirtyBot;

    public static void main(String[] args) {
        new ThirtyBotGUI();
    }

    public ThirtyBotGUI(){

        thirtyBot = new ThirtyBot();
        Container content = getContentPane();
        content.setPreferredSize(new Dimension(400, 100));
        content.setLayout(new GridLayout(1, 2, 0, 0));

        Container leftContainer = new Container();
        leftContainer.setLayout(new GridLayout());
        JButton playButton = new JButton("Play!");
        leftContainer.add(playButton);
        content.add(leftContainer);

        Container rightContainer = new Container();
        rightContainer.setLayout(new GridLayout(2, 2));
        JLabel ownPoints = new JLabel("Own points:");
        ownPoints.setHorizontalAlignment(JLabel.CENTER);
        JTextField ownPointsTextField = new JTextField();
        ownPointsTextField.setHorizontalAlignment(JTextField.CENTER);
        ownPointsTextField.setEditable(false);
        JLabel deductPoints = new JLabel("Deduct points:");
        deductPoints.setHorizontalAlignment(JLabel.CENTER);
        JTextField deductPointsTextField = new JTextField();
        deductPointsTextField.setHorizontalAlignment(JTextField.CENTER);
        deductPointsTextField.setEditable(false);
        rightContainer.add(ownPoints);
        rightContainer.add(ownPointsTextField);
        rightContainer.add(deductPoints);
        rightContainer.add(deductPointsTextField);
        content.add(rightContainer);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        playButton.addActionListener(e -> {
            Pair<Integer,Integer> result = thirtyBot.play();
            ownPointsTextField.setText(result.getKey() + "");
            deductPointsTextField.setText(result.getValue() + "");
        });

        setVisible(true);


    }


}
