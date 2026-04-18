import java.util.Arrays;
import java.util.Random;

public class RandomQuestionNeetcode {

    public static void main(String[] args) {
        int start = 1,
                end = 150;
        int[] excludeNumbers = { 4, 5, 9, 21, 26, 30, 34, 37, 38, 41, 45, 53, 56, 60, 63, 69, 74, 76, 86, 101, 109, 123,
                134,
                138,
                145 };
        Random rand = new Random();
        int result;

        do {
            // nextInt(bound) is exclusive, so +1 makes 'end' inclusive
            result = rand.nextInt(end - start + 1) + start;
        } while (Arrays.binarySearch(excludeNumbers, result) >= 0);

        System.out.println(result);
    }
}
