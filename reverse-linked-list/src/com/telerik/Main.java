package com.telerik;

public class Main {

    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode result = new Solution().reverseList(list);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode result = null;

            while (head != null) {
                ListNode temp = head;
                head = head.next;
                temp.next = result;
                result = temp;
            }

            return result;
        }
    }
}
