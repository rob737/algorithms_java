package revision.array;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String ptr = "ABCA";

        /*
        * Pattern to identify Minimum Window Substring :
        * Problem asks us to match items within a range.
        *
        * */

        String result = computeMinimumWindow(str, ptr);
        System.out.println("Minimum Window substring is : " + result);
    }

    private static String computeMinimumWindow(String str, String ptr) {
        int[] ascii_ptr = new int[256];
        int[] ascii_str = new int[256];
        int ptrLen = ptr.length();
        int strLen = str.length();
        int sI = 0, eI = 0, minWl = strLen;
        int count = 0;

        for (int i = 0; i < ptrLen; i++){
            ascii_ptr[ptr.charAt(i)] += 1;
        }

        while(str.charAt(sI) != ptr.charAt(0)){
            sI++;
            eI++;
        }

        while (sI <= eI && eI < strLen) {

            char currChar = str.charAt(eI);
            ascii_str[currChar]+=1;

            // This is to keep track of whether all characters of ptr is accounted for in str or not.
            if (ascii_ptr[currChar] != 0 && ascii_str[currChar] <= ascii_ptr[currChar])
                count++;

            if (count == ptrLen && str.charAt(sI) == str.charAt(eI)) {

                // This is to reduce window length under the pretext to remove extra elements from the window.
                while (ascii_ptr[str.charAt(sI)] != ascii_str[str.charAt(sI)]) {
                    //if (ascii_str[str.charAt(sI)] > 1) {
                        ascii_str[str.charAt(sI)]--;
                        sI++;
                    //}

                    // if(ascii_ptr[str.charAt(sI)] == 0)
                    //    sI++;
                }

                if(count == ptrLen && (eI-sI) < minWl)
                    minWl=(eI-sI);
            }
            eI++;
        }
        return str.substring(sI, sI+minWl+1);
    }
}
