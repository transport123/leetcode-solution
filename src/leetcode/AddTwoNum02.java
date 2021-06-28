package leetcode;


import Execute.MyRunnable;

public class AddTwoNum02 implements MyRunnable {


    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int realResult = 0;
        ListNode l3 = null;
        ListNode l3head = null;
        while (l1 != null || l2 != null || val3 != 0) {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }

            realResult = (val1 + val2 + val3) % 10;
            val3 = (val1 + val2 + val3) / 10;

            if (l3 == null) {
                l3 = new ListNode(realResult);
                l3head = l3;
            } else {
                l3.next = new ListNode(realResult);
                l3 = l3.next;
            }

        }

        return l3head;
    }

    @Override
    public void run() {
        ListNode listNode = new ListNode(1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
