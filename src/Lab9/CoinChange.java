package Lab9;
//Challenge

import java.util.ArrayList;
import java.util.List;

// EXPLAIN: enum with a field and a constructor (as Planet in Program 9.2)
enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int value;

    Coin(int value) { this.value = value; }

    int getValue() { return value; }
}

public class CoinChange {

    // EXPLAIN: greedy: always take the largest coin that still fits
    static List<Coin> fewestCoins(int amount) {
        List<Coin> result = new ArrayList<>();
        Coin[] coins = Coin.values();                   // declared smallest to largest
        for (int i = coins.length - 1; i >= 0; i--) {   // so loop from the end
            while (amount >= coins[i].getValue()) {
                result.add(coins[i]);
                amount -= coins[i].getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tests = {68, 41, 25, 3, 0};
        for (int amount : tests) {
            List<Coin> coins = fewestCoins(amount);
            System.out.println(amount + " -> " + coins.size() + " coins: " + coins);
        }
    }
}