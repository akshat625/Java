package Greedy;

import java.util.Arrays;

class Jobs{
    int id;
    int profit;
    int deadline;

    Jobs(int id,int profit,int deadline){
        this.id=id;
        this.profit=profit;
        this.deadline=deadline;
    }

}
public class JobSequencingWithDeadlines {

    public static void jobSequencing(Jobs[] jobs){

        Arrays.sort(jobs,(j1,j2) -> j2.profit-j1.profit);


        int maxDeadline=0;
        for(Jobs job : jobs){
            if(maxDeadline<job.deadline)
                maxDeadline= job.deadline;
        }
        int profit=0;
        int[] sol = new int[maxDeadline];

        for(Jobs job : jobs){
            for(int i= job.deadline;i>0;i--){
                if(sol[i-1]==0){
                    sol[i-1]= job.id;
                    profit += job.profit;
                    break;
                }
            }
        }

        System.out.print("Sequenced Jobs are : ");
        for(int ans : sol){
            if(ans==0)
                continue;
            System.out.print("J"+ans+" ");
        }
        System.out.println();
        System.out.println("Total profit : "+profit);
    }

    public static void main(String[] args) {
//        Jobs[] jobs ={
//                new Jobs(1,100,2),
//                new Jobs(2,50,1),
//                new Jobs(3,10,2),
//                new Jobs(4,20,1),
//                new Jobs(5,30,3)
//        };
        Jobs[] jobs ={
                new Jobs(1,70,4),
                new Jobs(2,80,1),
                new Jobs(3,30,1),
                new Jobs(4,100,1)
//                new Jobs(5,30,3)
        };
        jobSequencing(jobs);

    }
}
