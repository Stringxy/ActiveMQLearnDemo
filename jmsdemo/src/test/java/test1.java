import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xy on 2017/8/21.
 */
public class test1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<Integer> dots=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int dot=scanner.nextInt();
            if(!dots.contains(dot)) {
                dots.add(dot);
            }
        }
        Collections.sort(dots);
        if(dots.size()>2) {
            System.out.println(dots.get(2));
        }else{
            System.out.println(-1);
        }
    }
}
