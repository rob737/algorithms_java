package leetcode.heap;

class MinWinSub {
    static final int no_of_chars = 256;
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String ptr = "ABC";
        System.out.println("Smallest window is : " + findMinWindow(str,ptr));
    }

    private static String findMinWindow(String str, String ptr){
        int str_len = str.length();
        int ptr_len = ptr.length();

        if(str_len < ptr_len){
            return "Window doesn't exist";
        }
        int[] ascii_ptr = new int[no_of_chars];
        int[] ascii_str = new int[no_of_chars];

        for(int i = 0; i< ptr_len; i++)
            ascii_ptr[ptr.charAt(i)]++;

        int start =0, count = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        for(int j=0; j<str_len; j++){
            ascii_str[str.charAt(j)]++;

            if(ascii_ptr[str.charAt(j)] != 0 && ascii_str[str.charAt(j)] <= ascii_ptr[str.charAt(j)])
                count++;

            if(count == ptr_len){
                while(ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)] || ascii_ptr[str.charAt(start)] == 0){
                    if(ascii_str[str.charAt(start)] > ascii_ptr[str.charAt(start)])
                        ascii_str[str.charAt(start)]--;
                    start++;
                }
                int len_window = j-start+1;
                if(min_len > len_window){
                    min_len = len_window;
                    start_index=start;
                }
            }
        }


        return str.substring(start_index, start_index+min_len);
    }
}
