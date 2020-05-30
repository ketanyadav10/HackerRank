import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {
    // Complete the arrayManipulation function below.
	
    static long arrayManipulation(int n, int[][] queries) {
    	long arr[]=new long[n];
    	for(int[] query : queries ) {
    		arr[query[0]-1]+=query[2];
    		if(query[1]<n)
    			arr[query[1]]-=query[2];
    	}
    	long temp=0,ans=0;
    	for(long l : arr) {
    		temp+=l;
    		if(ans<temp) ans=temp;
    	}
    	return ans;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        long result = arrayManipulation(n, queries);

        System.out.println(result);      
		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
        scanner.close();
    }
}
