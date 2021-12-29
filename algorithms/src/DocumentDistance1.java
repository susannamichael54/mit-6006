import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentDistance1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter D1");
        String d1 = s.nextLine();
        System.out.println("Enter D2");
        String d2 = s.nextLine();
        System.out.println(findDocumentDistance(d1, d2));
    }

    public static double findDocumentDistance(String d1, String d2) {
        String [] d2split = d2.split(" ");
        String [] d1split = d1.split(" ");
        int d1Len = d1split.length;
        int d2len = d2split.length;
        HashMap<String, Integer> map1 = findWordFrequencies(d1split);
        HashMap<String, Integer> map2 = findWordFrequencies(d2split);
        return findDistance(map1, map2, d1Len, d2len);

    }

    public static HashMap findWordFrequencies(String [] dsplit) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < dsplit.length; i++) {
            if(map.get(dsplit[i]) != null) {
                int count  = map.get(dsplit[i]);
                map.put(dsplit[i], count++);
            } else {
                map.put(dsplit[i], 1);
            }
        }
        return map;
    }

    public static double findDistance(HashMap<String, Integer> map1, HashMap<String, Integer> map2, double l1, double l2) {
        double dotProduct = 0;
        for(Map.Entry<String, Integer> entry: map1.entrySet()) {
            long product = 0;
            Integer count2 = map2.get(entry.getKey());
            if(count2 != null) {
                product = count2 * entry.getValue();
            }
            dotProduct += product;
        }
        double cos = dotProduct/(l1 * l2);
        return Math.acos(cos);
    }

}
