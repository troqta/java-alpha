package com.telerik;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            ArrayList<Integer> elements = new ArrayList<>();

            ListNode result = new ListNode(-1);
            ListNode node = result;

            while (head != null) {
                elements.add(head.val);
                head = head.next;
            }
            Collections.rotate(elements, k);
            for (int element : elements) {
                node.next = new ListNode(element);
                node = node.next;
            }
            return result.next;
        }

        void rotate(ArrayList<Integer> arr) {
            int x = arr.get(arr.size() - 1), i;
            for (i = arr.size() - 1; i > 0; i--)
                arr.set(i, arr.get(i - 1));
            arr.set(0, x);
        }
    }
}
