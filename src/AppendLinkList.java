import java.io.IOException;
import java.util.Scanner;

public class AppendLinkList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            // bufferedWriter.write(String.valueOf(node.data));
         	System.out.println(node.data);
             node = node.next;

             if (node != null) {
                 System.out.println(sep);
             }
         }
     }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node= new SinglyLinkedListNode(data);
        SinglyLinkedListNode temp=head;
        if(head==null) { 
        	head =node;
        	return node;
        }
        while(head.next!=null){
            head=head.next;
        }
        head.next=node;
        return temp;
    }
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    	SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    	SinglyLinkedListNode temp=head;
    	if(head==null){
            return node;
        }
    	while(position-1>0) {
    		head=head.next;
    		position--;
    	}
    	node.next=head.next;
    	head.next=node;
    	
    	return temp;
    }
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    	SinglyLinkedListNode prev=null,temp=head;
    	while(position-->0) {
    		prev=head;
    		head=head.next;
    	}
    	prev.next=head.next;
    	return temp;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

          llist.head = llist_head;
        }



        printSinglyLinkedList(llist.head, "\n");
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
