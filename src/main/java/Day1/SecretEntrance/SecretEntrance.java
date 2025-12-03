package main.java.Day1.SecretEntrance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SecretEntrance {
    public static void main(String[] args) {
        // Read input to String ArrayList.
        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Day1/SecretEntrance/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize variables.
        int count = 0;
        int currentVal = 50;

        // Loop through turns.
        for (String str : input) {
            // Extract turn direction.
            char direction = str.charAt(0);

            // Extract turn amount.
            int turnAmount = Integer.parseInt(str.substring(1));

            // Update turn amount according to direction.
            if (direction == 'L') {
                turnAmount *= -1;
            }

            // Find new unrestricted value.
            int newVal = currentVal + turnAmount;

            // Restrict new value within bounds (0-99).
            newVal = newVal % 100;
            currentVal = newVal;

            // Count each time value is at 0.
            if (currentVal == 0) {
                count++;
            }
        }
        System.out.println("Password is: " + count);
    }
}