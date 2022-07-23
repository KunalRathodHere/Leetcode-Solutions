/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        var temp = head;
        while(temp != null && temp.next != null)
        {
            if (map.get(temp) != null){
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 0);
            }
            temp = temp.next;
            if(map.get(temp) != null && map.get(temp) > 1) 
                return true;
        }
        return false;
}
    
}