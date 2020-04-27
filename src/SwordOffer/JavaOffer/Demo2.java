package SwordOffer.JavaOffer;

public class Demo2 {

    public static void main(String[] args) {
        String result = replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(result);
    }

    public static String replaceSpace(StringBuffer str) {
        if (str.length() == 0) {
            return str.toString();
        }

        int emptyCount = 0;
        for (char ch : str.toString().toCharArray()) {
            if (ch == ' ') {
                ++emptyCount;
            }
        }

        StringBuilder sb = new StringBuilder(str.length() + emptyCount * 2);
        for (char ch : str.toString().toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}