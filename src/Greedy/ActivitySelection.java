package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class MyCmp implements Comparator<Activity>{
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.finish,a2.finish);
    }
}

class Activity{
    int start;
    int finish;
    public Activity(int start, int finish){
        this.start=start;
        this.finish=finish;
    }
}
public class ActivitySelection {
    public static int maxActivity(Activity[] activities){
        Arrays.sort(activities,new MyCmp());
        int count=0;
        System.out.println("Selected Activities :");

        int i=0;
        System.out.println("Activity "+(i+1)+": Start time = "+activities[0].start+" End time ="+activities[0].finish);

        for(int j=1;j<activities.length;j++){
            if(activities[j].start>=activities[i].finish){
                System.out.println("Activity "+(j+1)+": Start time = "+activities[j].start+" End time ="+activities[j].finish);
                count++;
                i=j;
            }

        }
        return count+1;
    }


    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 4),
                new Activity(1, 2),
                new Activity(0, 1),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
        };

        System.out.println("Total "+maxActivity(activities)+" activities can run.");

    }
}
