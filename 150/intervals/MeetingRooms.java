import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//134
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] meetings = { { 1, 4 }, { 10, 15 }, { 7, 10 } };
        System.out.println(canAttend(meetings));
    }

    static boolean canAttend(int[][] arr) {
        // code here
        List<int[]> sortedList = new ArrayList<>();
        for (int[] meeting : arr) {
            sortedList.add(meeting);
        }
        Comparator<int[]> comparator = (a, b) -> {
            return a[0] - b[0];
        };
        sortedList.sort(comparator);
        Arrays.sort(arr, comparator);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            int[] meeting = sortedList.get(i);
            int[] nextMeeting = sortedList.get(i + 1);
            if (meeting[1] > nextMeeting[0]) {
                return false;
            }
        }
        return true;
    }
}
