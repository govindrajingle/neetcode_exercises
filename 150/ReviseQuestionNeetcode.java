import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ReviseQuestionNeetcode {
    public static void main(String[] args) {

        List<Integer> allowedNumbers = Arrays.asList(4, 9, 30, 34, 41, 45, 53, 60, 63, 69, 86, 123, 145);

        Random rand = new Random();
        int result = allowedNumbers.get(rand.nextInt(allowedNumbers.size()));

        System.out.println(result);
    }

}
