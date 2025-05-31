import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = ReadTxt("data_prog_contest_problem_2.txt");
        int n = list.size();
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int uniqueCount = 0;

        for (int right = 0; right < n; right++) {
            int val = list.get(right);
            if (val >= 1 && val <= 26) {
                freq.put(val, freq.getOrDefault(val, 0) + 1);
                if (freq.get(val) == 1) {
                    uniqueCount++;
                }
            }

            while (uniqueCount == 26) {
                minLength = Math.min(minLength, right - left + 1);
                int leftVal = list.get(left);
                if (leftVal >= 1 && leftVal <= 26) {
                    freq.put(leftVal, freq.get(leftVal) - 1);
                    if (freq.get(leftVal) == 0) {
                        uniqueCount--;
                    }
                }
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("NONE");
        } else {
            System.out.println(minLength);
        }
    }

    public static List<Integer> ReadTxt(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        numbers.add(Integer.parseInt(part));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("asdasd");
        }
        return numbers;
    }
}

