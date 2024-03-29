package revision.array;

public class DistinctCharacterWindow {
    public static void main(String[] args) {
        char[] arr = {'a','a','b','c','b','c','d','b','c','a'};
        String result = findSmallestDistinctSubstring(arr);
        System.out.println("Smallest Distinct Substring : " + result);
    }

    private static String findSmallestDistinctSubstring(char[] str) {
        byte[] ascii_str = new byte[256];
        byte[] ascii_ptr = new byte[256];
        int strLen = str.length, ptrLen = 0;
        int sI=0,eI=0,count=0,minWl=strLen;

        // This is to create ptr string which will contain all the unique characters of str.
        for (char c : str) {
            if (ascii_ptr[c] == 0) {
                ascii_ptr[c] = 1;
                ptrLen++;
            }
        }

        // This whole logic is same as minimum window substring.
        while (sI <= eI && eI < strLen){
            ascii_str[str[eI]] +=1;

            if(count != ptrLen && ascii_str[str[eI]] <= ascii_ptr[str[eI]])
                count++;

            if(count == ptrLen && ascii_str[str[eI]] == ascii_str[str[sI]]){
                while (ascii_str[str[sI]] != ascii_ptr[str[sI]]){
                    ascii_str[str[sI]]--;
                    sI++;
                }
                if(minWl > (eI-sI))
                    minWl = (eI-sI);
            }
            eI++;
        }
        StringBuilder result = new StringBuilder();
        for(int i=sI; i<sI+minWl+1; i++)
            result.append(str[i]);
        return result.toString();
    }
}
