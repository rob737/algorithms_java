package leetcode.array;

public class OverlapRectangle {

    static class Point {
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point P = new Point(1 ,5);
        Point Q = new Point(3,1);
        Point _P = new Point(4,8);
        Point _Q = new Point(8, -4);

        boolean isOverlap = checkCoordinates(P,Q,_P,_Q);

        System.out.println("Are rectangles overlapping " + isOverlap);

     }

    private static boolean checkCoordinates(Point P, Point Q, Point _P, Point _Q) {

        if(P.x > _Q.x || _P.x > Q.x)
            return false;

        if(P.y < _Q.y || _P.y < Q.y )
            return false;

        return true;
    }
}
