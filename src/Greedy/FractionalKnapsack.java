package Greedy;

import java.util.Arrays;
import java.util.Comparator;


class Items{
    int value;
    int weight;
    double valueByWeight;
    Items(int value,int weight){
        this.value=value;
        this.weight=weight;
        this.valueByWeight=(double) value/weight;
    }
}

class Cmp implements Comparator<Items>{

    @Override
    public int compare(Items a1, Items a2) {
        return Double.compare(a2.valueByWeight, a1.valueByWeight);
    }
}
public class FractionalKnapsack {

    public static double knapsack(Items[] items,int knapsackWeight){
        double maxValue=0;

        Arrays.sort(items,new Cmp());

        for(Items item : items){
            if(item.weight<=knapsackWeight){
                maxValue += item.value;
                knapsackWeight -= item.weight;
            }
            else {
                maxValue += (double) (item.value * knapsackWeight) / item.weight;
                break;
            }
        }
        return maxValue;
    }



    public static void main(String[] args) {
        Items[] items = {
                new Items(10,5),
                new Items(5,2),
                new Items(15,8),
                new Items(7,1),
                new Items(2,2)
        };
        int knapsackWeight=10;

        System.out.println("The maximum value is : "+ knapsack(items,knapsackWeight));
    }
}
