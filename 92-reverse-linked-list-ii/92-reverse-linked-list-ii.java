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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
//         if(head.next == null || head == null)
//             return head;
        
//         if(l == r)
//             return head;
        
//         if(r - l == 1){
            
//             ListNode temp = head;
            
            
//         }
        
//         ListNode left = head, right = head;
//         l--;
//         r--;
//         while(l>0 || r>0){
//             if(l > 0){
//                 left = left.next;
//                 l--;
//             }
            
//             if(r > 0){
//                 right = right.next;
//                 r--;
//             }
//         }
//         System.out.println("left = " + left.val);
//         System.out.println("right = " + right.val);
        
//         ListNode last_prev = head;
//         ListNode last_next = right.next;
//         while(last_prev.next != left)
//             last_prev = last_prev.next;
        
        
//         ListNode prev = left;
        
//         ListNode curr = left.next;
//         ListNode next = null;
//         while(curr != last_next){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
        
//         left.next = last_next;
//         last_prev.next = right;
        
//         return head;
        
//         ListNode left = head, right = head;
//         l--;
//         r--;
//         while(l>0 || r>0){
//             if(l > 0){
//                 left = left.next;
//                 l--;
//             }
            
//             if(r > 0){
//                 right = right.next;
//                 r--;
//             }
//         }

//         ListNode prev = left;
//         ListNode curr = left.next;
//         ListNode next = null;
        
        
//         while(curr != right.next){
//             next =curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
            
//         }
        
//         left.next = curr;
        
//         ListNode prev_of_left = head;
        
//         while(prev_of_left != left){
//             prev_of_left = prev_of_left.next;
//         }
        
//         prev.next = prev_of_left;
        
//         return head;
        
        if(head == null)
            return null;
        
        ListNode cur =  head, prev = null;
        while(m > 1){
            prev = cur;
            cur= cur.next;
            m--;
            n--;
        }
        
        ListNode con = prev, tail = cur;
        ListNode third = null;
        
        while(n > 0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        
        if(con != null){
            con.next = prev;
            
        }
        else{
            head = prev;
        }
        
        tail.next = cur;
        return head;
    }
}