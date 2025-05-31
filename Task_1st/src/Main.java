import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<int[]> segments = readTxt("data_prog_contest_problem_1.txt");
        segments.sort(Comparator.comparingInt(s -> s[1]));
        for(int[] seg : segments){
            System.out.println(Arrays.toString(seg));
        }
        int countPoints = 0;
        int currentPoint = Integer.MIN_VALUE;

        for (int[] seg : segments) {
            if (seg[0] > currentPoint) {
                currentPoint = seg[1];
                countPoints++;
            }
        }

        System.out.println("Минимальное количество точек для покрытия всех отрезков: " + countPoints);
    }
    public static List<int[]> readTxt(String fileName) {
        List<int[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length < 2) continue;
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                list.add(new int[]{start, end});
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка чтения из файла");
        }
        return list;
    }
}
