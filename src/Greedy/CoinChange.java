package Greedy;

import java.util.Arrays;

public class CoinChange {

    // Function to find the minimum number of coins needed to make up the target amount
    public static void coinChange(int[] coins, int target) {

        int remainingAmount = target;
        int[] usedCoins = new int[coins.length];
        int coinCount = 0;


        Arrays.sort(coins);

        // Iterate through the coins in reverse order (largest to smallest)
        for (int i = coins.length - 1; i >= 0; i--) {
            // Calculate the maximum number of coins of the current denomination that can be used
            int maxCoins = remainingAmount / coins[i];

            // Update the usedCoins array and remainingAmount based on the maximum coins used
            if (maxCoins > 0)
                usedCoins[i] += maxCoins;
            remainingAmount -= maxCoins * coins[i];
            coinCount += maxCoins;
        }

        // Output the result: minimum coins required and the breakdown of coins used
        System.out.println("The minimum coins required for " + target + " is " + coinCount);
        System.out.println("Coins used:");
        for (int i = 0; i < usedCoins.length; i++) {
            if (usedCoins[i] > 0) {
                System.out.println(coins[i] + " x " + usedCoins[i]);
            }
        }
    }

    // Main function to test the coinChange method
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int target = 3456;
        coinChange(coins, target);
    }
}
