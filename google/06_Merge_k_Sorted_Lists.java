/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        else if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for (int i = 0; i < lists.length; i++){

            if (lists[i] != null)
                pq.add(lists[i]);

        }

        if (pq.isEmpty()) return null;

        ListNode head = new ListNode(pq.peek().val);
        ListNode prev = head;

        if (pq.peek().next == null) pq.poll();
        else pq.add(pq.poll().next);

        while (!pq.isEmpty()){

            prev.next = pq.peek();
            prev = prev.next;

            if (pq.peek().next == null){
                pq.poll();
            }
            else pq.add(pq.poll().next);

        }

        return head;

    }
}
