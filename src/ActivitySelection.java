import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {

    public static void selectActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish)); // Sort by finish time

        System.out.println("Selected Activities:");
        int lastFinishTime = activities[0].finish;
        System.out.println("Activity: (" + activities[0].start + ", " + activities[0].finish + ")");

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinishTime) {
                System.out.println("Activity: (" + activities[i].start + ", " + activities[i].finish + ")");
                lastFinishTime = activities[i].finish;
            }
        }
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(0, 6),
                new Activity(1, 2),
                new Activity(3, 4),
                new Activity(5, 7),
                new Activity(5, 9),
                new Activity(8, 9)
        };

        selectActivities(activities);
    }
}
