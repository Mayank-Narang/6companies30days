//mis-read the question first time. then solved it correctly


/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution {
    static void linkdelete(Node head, int n, int m) {
        
        Node early = new Node(-1);
        early.next = head;
        Node iter = early;
        Node temp = null;
        int len = 0;
        
        while (iter != null){
            
            // System.out.println(len+" "+iter.data);
            
            if (len == m){
                temp = iter;
            }
            else if (len == m+n){
                temp.next = iter.next;
                len = 0;
                temp = null;
            }
            
            len++;
            iter = iter.next;
            
        }
        
        if (temp != null) temp.next = null;
        
        head = early.next;
        
    }
}
