import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xy on 2017/8/21.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        List<Integer> dots=new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                int dot=scanner.nextInt();
                dots.add(dot);
            }
            int sum=0;
            int max=0;
            for(int k=1;k<dots.size();k++){
                int old=Math.abs(dots.get(k)-dots.get(k-1));
                sum+=old;
                int change=0;
                if(k!=dots.size()-1) {
                    old+=Math.abs(dots.get(k+1)-dots.get(k));
                    change = Math.abs(dots.get(k + 1) - dots.get(k - 1));
                    int diff=old-change;
                    if(diff>max){
                        max=diff;
                    }
                }

            }
                System.out.println(sum-max);
    }
}
