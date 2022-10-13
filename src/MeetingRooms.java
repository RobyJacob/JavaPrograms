import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {
    static int minMeetingRooms(List<List<Integer>> meetings) {
        int numOfRooms = 1;
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (List<Integer> meeting : meetings) {
            startTimes.add(meeting.get(0));
            endTimes.add(meeting.get(1));
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        for (int i = 1, j = 0; i < meetings.size() && j < meetings.size();) {
            if (startTimes.get(i) < endTimes.get(j)) {
                i++;
                numOfRooms++;
            } else {
                i++;
                j++;
            }
        }

        return numOfRooms;
    }

    public static void main(String[] args) {
        List<List<Integer>> meetings = new ArrayList<>();
        meetings.add(new ArrayList<>(Arrays.asList(0,8)));
        meetings.add(new ArrayList<>(Arrays.asList(5,9)));
        meetings.add(new ArrayList<>(Arrays.asList(12,14)));
        meetings.add(new ArrayList<>(Arrays.asList(15,25)));

        int minRooms = minMeetingRooms(meetings);

        System.out.println(minRooms);
    }
}
