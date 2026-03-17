import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.addAll(Arrays.asList("hello&smith", "bottle", "sun"));
        String encoded = encode(strs);
        System.out.println("Encoded String: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded String: " + decoded);
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int strLength = str.length();
            sb.append(strLength).append("#").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String encodedString) {
        List<String> data = new ArrayList<>();
        int i = 0;

        while (i < encodedString.length()) {
            // Step 1: find '#'
            int j = i;
            while (encodedString.charAt(j) != '#') {
                j++;
            }

            // Step 2: get length
            int length = Integer.parseInt(encodedString.substring(i, j));

            // Step 3: extract string
            String str = encodedString.substring(j + 1, j + 1 + length);
            data.add(str);

            // Step 4: move pointer
            i = j + 1 + length;
        }

        return data;
    }
}
