package SwordOffer.JavaOffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo54 {
    public static void main(String[] args) {

    }

    public static class Solution1 {
        Map<Character, Integer> map = new LinkedHashMap<>();

        public void Insert(char ch) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        public char FirstAppearingOnce() {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return '#';
        }
    }
}
