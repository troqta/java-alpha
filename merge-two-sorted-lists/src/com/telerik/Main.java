package com.telerik;

public class Main {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = new Solution().mergeTwoLists(l1, l2);

        printNode(result);
    }

    public static void printNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-123);
            ListNode node = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                    node = node.next;
                } else {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                    node = node.next;
                }
            }
            while (l2 != null) {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }


            while (l1 != null) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;
            }

            return result.next;
        }
    }
}
