package leetcode.array;

import java.util.Scanner;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String ptr = scanner.next();

        int ascii_str[] = new int[256];
        int ascii_ptr[] = new int[256];
        int count = 0;
        int s_i = 0, e_i = 0, min_w_l = Integer.MAX_VALUE;
        char curr_char;

        for (int i = 0; i < ptr.length(); i++)
            ascii_ptr[ptr.charAt(i)] += 1;

        while (s_i <= e_i && e_i < str.length()) {
            curr_char = str.charAt(e_i);
            ascii_str[curr_char] += 1;

            if (ascii_ptr[curr_char] != 0 && ascii_str[curr_char] <= ascii_ptr[curr_char]) {
                count++;
            }


            if (count == ptr.length() && str.charAt(e_i) == str.charAt(s_i)) {
                // if multiple occurrence of a character or non matching character.
                while (!(ascii_ptr[str.charAt(s_i)] == 1 && ascii_str[str.charAt(s_i)] == 1)) {
                    if (ascii_str[str.charAt(s_i)] > 1) {
                        ascii_str[str.charAt(s_i)]--;
                        s_i++;
                    }

                    if (ascii_ptr[str.charAt(s_i)] == 0)
                        s_i++;
                }
            }

            if (count == ptr.length() && e_i - s_i < min_w_l) {
                min_w_l = e_i - s_i + 1;
            }
            e_i++;
        }
        System.out.println("Result : " + str.substring(s_i, s_i+min_w_l));
    }

}
