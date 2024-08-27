package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class plots {
    public static void main(String[] args) {
        List<Integer> plots = new ArrayList<>();
        plots.addAll(List.of(1, 2, 3, 4, 5, 6, 3, 5, 7, 8, 81, 12, 11, 15));

        int newplot = 12, target = 15, full = 22, incomplete = 11;
        System.out.println(publicity(plots,newplot,target,full,incomplete));
    }

    public static int publicity(List<Integer> plots, int newplot, int target, int full, int incomplete) {
        // Write your code here
        Collections.sort(plots,Collections.reverseOrder());
        int _n = plots.size(), _c=0, _minP=Integer.MAX_VALUE;
        for(int i =0; i<_n; i++){
            int temp = target-plots.get(i);
            if(temp<=0)
                _c++;
            else{
                if(newplot-temp>0){
                    newplot = newplot-temp;
                    _c++;
                }else{
                    if(_minP>plots.get(i)){
                        _minP=plots.get(i);
                    }
                }
            }
        }
        int _incomplete = _n - _c;
        int x =0;
        if(newplot>=_incomplete && _incomplete>0) x = newplot/_incomplete;
        else
            _minP++;
        _incomplete = _minP+x;


        return _c*full+_incomplete*incomplete;
    }
}
