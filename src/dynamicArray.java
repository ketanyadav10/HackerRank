import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Sol {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    	List<List<Integer>> seq= new ArrayList<>(n);
    	int lengthOfSeq=n;
    	int lastAnswer=0;
		
		  while(lengthOfSeq-- >= 0) { seq.add(new ArrayList<Integer>()); }
		 
    	List<Integer> ans= new ArrayList<>();
    	for (List<Integer> query : queries) {
			if(query.get(0)==1) {
				int seqNo=(query.get(1)^lastAnswer)%n;
				seq.get(seqNo).add(query.get(2));
			}
			else if(query.get(0)==2) {
				int seqNo=(query.get(1)^lastAnswer)%n;
				lastAnswer=seq.get(seqNo).get(query.get(2)%seq.get(seqNo).size());
				ans.add(lastAnswer);
			}
		}
    	return ans;
    }

}

public class dynamicArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Sol.dynamicArray(n, queries);

		/*
		 * bufferedWriter.write( result.stream() .map(Object::toString)
		 * .collect(joining("\n")) + "\n" );
		 */
        System.out.println(result.stream() .map(Object::toString)
       		 .collect(joining("\n")) + "\n" );
        
        bufferedReader.close();
        //bufferedWriter.close();
    }
}
