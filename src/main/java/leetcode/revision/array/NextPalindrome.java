package leetcode.revision.array;

public class NextPalindrome {
    public static void main(String[] args) {
        int[] arr = {8,3,1,7,7,9,7,9,3,2,3};
        nextPalindromeApplicable(arr,arr.length);
    }

    private static void nextPalindromeApplicable(int[] arr, int n) {
        System.out.println("Next Palindrome greater than curren number is : ");

        // Case 1 : in case of all 9's,introduce 0 equal to n-1 and append 1 on either side.
        if(isAllNine(arr,n)){
            System.out.print("1");
            for(int i=0; i<n-1;i++)
                System.out.print("0");
            System.out.println("1");

        }else {
            utilityFunction(arr,n);
            printArray(arr);
        }
    }

    private static void utilityFunction(int[] arr, int n) {
        int mid = n/2;
        int i = mid-1,j= (n%2 == 0) ? mid:mid+1;
        boolean isLeftSmaller = false;

        // Case : When subarray is already a palindrome
        while(i>=0 && arr[i] == arr[j]){
            i--;j++;
        }
        //Case: What if it is already a palindrome.(We need to find next higher palindrome).
        if(i<0 || arr[i]<arr[j]){
            isLeftSmaller = true;
        }
        /*
        * Irrespective of the fact whether mid-1 is greater or smaller than mid+1, we
        * would need to override right half of the array with left half of the array
        * to make it palindrome.
        * After this, we can manipulate to get the "next" higher palindrome wrt existing number.
        * */
        while(i>=0){
            arr[j++] = arr[i--];
        }

        if(isLeftSmaller){
            int carry=1;
            if(n%2==1){
                arr[mid] +=1;
                carry=arr[mid]/10;
                arr[mid] %= 10;
            }
            i=mid-1;
            j=(n%2==0 ? mid : mid+1);

            while(i>=0 && carry > 0){
                arr[i]=arr[i]+carry;
                carry=arr[i]/10;
                arr[i]=arr[i]%10;
                arr[j]=arr[i];
                i--;
                j++;
            }
        }
    }

    private static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
    }

    private static boolean isAllNine(int[] arr, int n) {
        for(int i=0; i<n; i++)
            if(arr[i]!=9)
                return false;
        return true;
    }
}
