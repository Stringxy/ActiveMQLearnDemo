import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xy on 2017/8/21.
 */
public class test3 {
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

            dots.get(k);

        }
        System.out.println(sum-max);
    }
}
