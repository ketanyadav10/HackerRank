import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayLeft_Basic {
        static int[] rotLeft(int[] a, int d) {
            if(d>=a.length)d-=a.length;
            while(d-- >0) {
                int firstElement=a[0];
                for(int i=0;i<=a.length-2;i++)
                    a[i]=a[i+1];
                a[a.length-1]=firstElement;
               }
            return a;}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	Scanner scan = new Scanner(System.in);
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

    System.out.println(Arrays.toString(result));

        scanner.close();
    }
}
