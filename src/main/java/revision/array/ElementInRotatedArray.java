package revision.array;

/*
* Idea is to find the half in which our element would lie.
*
* */
public class ElementInRotatedArray {
    public static void main(String[] args) {
        int[] input = {7,8,9,10,1,2,3,4,5,6};
        int targetElement = 13;
        int n = input.length;
        int targetIndex = findIndexOfTarget(input,targetElement,0,n-1);
        System.out.println("Index of Target Element " + targetIndex);
    }

    // We need to build our logic identifying the half where target Element can be present.
    private static int findIndexOfTarget(int[] input, int targetElement, int begin, int end) {

        /*
        *
        * begin > end implies we haven't found the element.
        * */
        if(begin > end)
            return -1;

        int mid = (begin + end)/2;
        if(input[mid] == targetElement)
            return mid;

        // This condition is to confirm that elements from begin to mid is increasingly sorted.
        if(input[begin] <= input[mid]){

            if(targetElement >= input[begin] && targetElement <= input[mid])
                return findIndexOfTarget(input,targetElement,begin,mid-1);

            return findIndexOfTarget(input,targetElement,mid+1,end);
        }

        // In case above condition is not valid then we are sure that mid to end is increasingly sorted.
        if(targetElement >= input[mid] && targetElement <= input[end])
            return findIndexOfTarget(input,targetElement,mid+1,end);


        // This is for the case when target element is not present between mid to end.
        return findIndexOfTarget(input,targetElement,begin,mid-1);
    }
}
