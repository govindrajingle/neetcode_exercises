import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReconstructItinerary {
    // Itinerary means journey or route
    public static void main(String[] args) {
        List<List<String>> tickets = List.of(
                List.of("JFK", "B"),
                List.of("B", "JFK"),
                List.of("JFK", "A"),
                List.of("A", "JFK"));
        List<String> route = findItinerary(tickets);
        System.out.println(route);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        tickets = new ArrayList<>(tickets);
        Comparator<List<String>> comparator = (b, a) -> {
            return a.get(0).compareTo(b.get(0));
        };
        tickets.sort(comparator);
        System.out.println(tickets);
        return null;
    }
}
