package revision.array;

public class DistinctCharacterWindow {
    public static void main(String[] args) {
        char[] arr = {'a','a','b','c','b','c','d','b','c','a'};
        String result = findSmallestDistinctSubstring(arr);
        System.out.println("Smallest Distinct Substring" + result);
    }

    private static String findSmallestDistinctSubstring(char[] str) {
        byte[] ascii_str = new byte[256];
        byte[] ascii_ptr = new byte[256];
        int strLen = str.length, ptrLen = 0;
        int sI=0,eI=0,count=0,minWl=strLen;

        for(int i=0; i<strLen; i++){
            if(ascii_ptr[str[i]] == 0){
                ascii_ptr[str[i]]=1;
                ptrLen++;
            }
        }

        while (sI <= eI && eI < strLen){
            ascii_str[str[eI]] +=1;

            if(count != ptrLen && ascii_str[str[eI]] < ascii_ptr[str[eI]])
                count++;

            if(count == ptrLen && ascii_str[str[eI]] == ascii_str[str[sI]]){
                while (ascii_str[str[sI]] != ascii_ptr[str[sI]]){
                    ascii_str[str[sI]]--;
                    sI++;
                }
                if(minWl < (eI-sI))
                    minWl = (eI-sI)+1;
            }
            eI++;
        }
    StringBuilder result = new StringBuilder();
        for(int i = sI; i<sI+minWl; i++)
            result.append(str[i]);

    return result.toString();
    }
}
