public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }
    private ListNode mergeHelper(ListNode[] lists, int low, int high) {
        if (low == high)  return lists[low];
        int mid = low + (high - low) / 2;
        ListNode l1 = mergeHelper(lists, low, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, high);
        return mergeTwoLists(l1, l2);

    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}