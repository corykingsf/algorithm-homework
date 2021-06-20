# Homework 1
## 本周作业

## 加一
```
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null ||digits.length == 0) return new int[]{1};

        int len = digits.length;
        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
        }
        if (carry != 0) {
           int[] res = new int[len +1];
           res[0] = 1;
           return res;
        }
        return digits;
    }
}
```


## 合并两个有序链表
```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE :l1.val;
            int val2 = l2 == null ?Integer.MAX_VALUE: l2.val;

            if (val1 <val2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
```

## 设计循环双端队列
```
```

## 和为K的子数组
```
```


# 最大子序和
```
class Solution {
    public int maxSubArray(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return 0;
       
        int len = nums.length;
        int[] s = new int[len + 1];
        int prefixMin = s[0];
        int ans = Integer.MIN_VALUE;
        
        for (int i = 1;  i < s.length; i++) {
            // s[i]
            // s[i] - prefixMin ==>max
            s[i] = s[i - 1] + nums[i - 1];
            ans = Math.max(ans, s[i] - prefixMin);
            prefixMin = Math.min(prefixMin, s[i]);
            
        } 
        return ans;
    }
}
```

6/20/2021
