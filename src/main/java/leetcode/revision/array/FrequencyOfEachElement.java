package leetcode.revision.array;

public class FrequencyOfEachElement {
    public static void main(String[] args) {
        int [] arr = {5,2,7,7,5,5,2};
        findFrequencyOfEachElement(arr);
    }

    private static void findFrequencyOfEachElement(int[] arr) {
        int n = arr.length, result=0;
        for(int i =0; i<n; i++)
            arr[i] = arr[i] - 1;
        for(int i =0; i<n; i++){
            arr[arr[i]%n] = arr[arr[i]%n]+n;
        }

        for(int i = 0; i<n; i++){
            result = arr[i]/n;
            System.out.println("Frquency of " + (i+1) + " : " + result);
        }
    }
}
