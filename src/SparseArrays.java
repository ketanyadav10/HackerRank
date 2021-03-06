
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SparseArrays {
	
	static int freq(String[] strings, String s) {
		int count =0;
		for(String str:strings) {
			if(str.equals(s))
				count++;
		}
		return count;
	}

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] res=new int[queries.length];
        int index=0;
        for(String query:queries) {
        	res[index++]=freq(strings, query);
        } 
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        System.out.println(Arrays.toString(res));
        
		/*
		 * for (int i = 0; i < res.length; i++) {
		 * bufferedWriter.write(String.valueOf(res[i]));
		 * 
		 * if (i != res.length - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

        scanner.close();
    }
}
