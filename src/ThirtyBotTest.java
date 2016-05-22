import javafx.util.Pair;

/**
 * Created by Jeppe Vinberg on 21-05-2016.
 */
public class ThirtyBotTest {

    public static void main(String[] args){
        ThirtyBot bot = new ThirtyBot();
        System.out.println(testBot(bot));
    }

    private static double testBot(ThirtyBot bot){
        int iterations = 100000;
        Pair<Integer,Integer> result;
        double sum = 0;
        for(int i = 0; i < iterations; i++){
            result = bot.play();
            sum += result.getValue();
        }
        return sum / iterations;
    }
}
