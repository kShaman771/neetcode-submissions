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
    public boolean isPalindrome(ListNode head) {
        int n=0;
        ListNode l=head;
        while(l!=null){
            n++;
            l=l.next;
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=head.val;
            head=head.next;

        }
        int left=0;
        int right=n-1;
        while(left<right){
            if(arr[left]!=arr[right]){
                return false;

    
            }
            left++;
            right--;
        }
        return true;
        
    }
}