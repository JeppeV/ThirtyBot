import javafx.util.Pair;

import java.util.Random;

/**
 * Created by Jeppe Vinberg on 17-04-2016.
 */
public class ThirtyBot {

    public int playFirstRound(){
        Random r = new Random();
        int dice = 6;
        int diceToRemove;
        int sum = 0;
        boolean foundHigh;
        int[] rolls = new int[6];
        int count = 0;
        while(dice > 0){
            count++;
            diceToRemove = 0;
            foundHigh = false;
            for(int i = 0; i < dice; i++){
                rolls[i] = r.nextInt(6) + 1;
                if(rolls[i] == 6){
                    diceToRemove++;

                    sum += rolls[i];
                    foundHigh = true;

                }
            }

            if(!foundHigh){
                int highestRoll = 0;
                for(int i = 0; i < dice; i++){
                    if(rolls[i] > highestRoll){
                        highestRoll = rolls[i];
                    }
                }
                sum += highestRoll;
                diceToRemove++;
            }
            dice -= diceToRemove;
        }

        return sum - 30;
    }

    public Pair<Integer,Integer> play(){
        Pair<Integer,Integer> result;
        int points = playFirstRound();
        if(points <= 0) return new Pair<>(points, 0);
        int p = playFor(points);

        return new Pair<>(points, p);
    }

    private int playFor(int k){
        Random r = new Random();
        int dice = 6;
        int points = 0;
        int diceToRemove;
        while(true){
            diceToRemove = 0;
            int roll;
            for(int i = 0; i < dice; i++){
                roll = r.nextInt(6) + 1;
                if(roll == k){
                    points += roll;
                    diceToRemove++;
                }
            }
            if(diceToRemove == 0) break;
            dice -= diceToRemove;
            if(dice == 0) dice = 6;
        }
        return points;
    }
}
