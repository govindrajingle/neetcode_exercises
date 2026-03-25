import java.util.Arrays;

public class EncodeDecode {

    public static void main(String[] args) {
        String[] strs = { "tv96", "np0", "eVHgP!", "I0", "Oeu8VIuWKJ", "0" };

        EncodeDecode obj = new EncodeDecode();

        String encoded = obj.encode(strs);
        System.out.println("Encoded String: " + encoded);

        String[] decoded = obj.decode(encoded);

        // Proper way to print array
        System.out.println("Decoded String: " + Arrays.toString(decoded));
    }

    int totalWords = 0;

    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder sb = new StringBuilder();
        totalWords = s.length;
        for (String word : s) {
            int size = word.length();
            sb.append(size);
            sb.append("#");
            sb.append(word);
        }
        return sb.toString();
    }

    public String[] decode(String encoded) {
        String[] messages = new String[totalWords];
        // write your logic to decode the string
        int wordLength = 0, index = 0;
        for (int i = 0; i < encoded.length(); i++) {
            char ch = encoded.charAt(i);
            StringBuilder sb = new StringBuilder();
            if (Character.isDigit(ch)) {
                wordLength = wordLength * 10 + Integer.parseInt(ch + "");
            } else {
                // Skip #
                i += 1;
                sb.append(encoded.substring(i, wordLength + i));
                i += wordLength - 1;
                messages[index] = sb.toString();
                wordLength = 0;
                index += 1;
            }
        }
        return messages;
    }
}
