package String_suanfa;

class Trim {

    public static String trimString(String s)
    {
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == ' ') {
            start ++;
        }
        while (start < end && s.charAt(end) == ' ') {
            end --;
        }
        if (start == end) {
            return "";
        }

        return s.substring(start, end);

    }
}