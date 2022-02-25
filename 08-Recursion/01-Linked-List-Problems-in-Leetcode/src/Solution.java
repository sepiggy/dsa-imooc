// p066. Leetcode 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/
// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        // 待删除元素处于头指针的情况
        while (head != null && head.val == val) { // 有可能删除多个元素, 这里使用while循环
            ListNode delNode = head; // 待删除节点就是头节点
            head = head.next;        // 维护头指针
            delNode.next = null;
        }

        if (head == null)
            return head;

        // 待删除元素处于链表中间
        ListNode prev = head; // 待删除元素的前一个位置
        while (prev.next != null) { // 有可能删除多个元素, 这里使用while循环
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else
                prev = prev.next;
        }

        return head;
    }
}