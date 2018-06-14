package com.telerik;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        public ListNode deleteDuplicates(ListNode head) {
            Set<Integer> uniques = new HashSet<>();
            ListNode result = new ListNode(-1);
            ListNode node = result;
            while(head!=null){
                if(!uniques.contains(head.val)){
                    node.next = new ListNode(head.val);
                    node=node.next;
                }
                uniques.add(head.val);
                head=head.next;
            }

            return result.next;
        }
    }
}
