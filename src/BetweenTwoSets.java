import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    public static Integer getHCF(Integer a, Integer b){
    if(b==0) return a;
    return getHCF(b,a%b); 
    }
    public static Integer getLCM(Integer a, Integer b){
        return a*b/getHCF(a, b); 
     }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        
        if(a.stream().min(Integer::compare).get()>b.stream().max(Integer::compare).get())
            return 0;
        Integer lcm= a.get(0);
        Integer hcf= b.get(0);
        
        int ans=0;
        for (Integer integer : b) {  
            hcf=getHCF(hcf, integer);
        }
        for (Integer integer : a) {
            lcm=getLCM(lcm, integer);
        }
        System.out.println("LCM :"+lcm+" HCF :"+hcf);
         for(int i=lcm, x=1;i<=hcf;i=x*lcm) {
             if(hcf%i==0) {
            	 ans++;
             }
             x++;
         }  
        return ans;       
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
