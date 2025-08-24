package linkedlist;

public class linkedlist {
    private ListNode head;
    private ListNode tail;
    private int size;

    public linkedlist() {
        this.size = 0;
    }
   //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public ListNode deleteDuplicates(ListNode head) {
     ListNode current = head;
     while (current != null && current.next != null){
         if(current.val == current.next.val){
             current.next = current.next.next;
         }
         else {
             current = current.next;
         }
     }
     return head;
    }
//https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // dummy node to simplify list building
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes (only one of these will be non-null)
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }
//https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {
                return true;            // cycle detected
            }
        }

        return false; // no cycle
    }

    public int cycleLenth(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }
//https://leetcode.com/problems/linked-list-cycle-ii/description/
    public ListNode detectCycle(ListNode head) {
     int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                length = cycleLenth(slow);
                break;
            }
            }
        if(length == 0){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (length > 0){
            s = s.next;
            length--;
        }
        while (f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
    //https://leetcode.com/problems/happy-number/
    //Google
    public boolean isHappy(int n) {
    int slow = n;
    int fast = n;

    do {
        slow = squaresDigit(slow);
        fast = squaresDigit(squaresDigit(fast));
    }while (slow != fast);

     if (slow == 1){
         return true;
     }

     return false;
    }

    private int squaresDigit(int num){
        int ans = 0;
        while (num > 0){
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }
//https://leetcode.com/problems/middle-of-the-linked-list/
public ListNode middleNode(ListNode head) {
    ListNode temp = head;
    int length = 0;
    while (temp != null) {
        length++;
        temp = temp.next;
    }
    int mid = length / 2;
    temp = head;
    for (int i = 0; i < mid; i++) {
        temp = temp.next;
    }
    return temp;
}
//https://leetcode.com/problems/sort-list/
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    // Find the middle of the list and split the list into two halves
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    // Classic slow and fast pointer approach to find middle
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    // Split the list
    prev.next = null;

    // Recursively sort both halves
    ListNode left = sortList(head);
    ListNode right = sortList(slow);

    // Merge the sorted halves
    return mergeTwoLists(left, right);
}

    private void reverse(ListNode node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    //https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null && next.next != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
//https://leetcode.com/problems/reverse-linked-list-ii/
public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;

    // Step 1: Move `prev` to the node just before `left`
    for (int i = 1; i < left; i++) {
        prev = prev.next;
    }

    // Step 2: Set up pointers for reversal
    ListNode pres = prev.next;        // Start of the sublist to reverse
    ListNode curr = pres.next;        // The next node to reverse

    // Step 3: Reverse sublist between left and right
    for (int i = 0; i < right - left; i++) {
        ListNode next = curr.next;
        curr.next = pres;
        pres = curr;
        curr = next;
    }

    // Step 4: Connect the reversed part back
    prev.next.next = curr;  // Connect tail of reversed part to rest
    prev.next = pres;       // Connect node before left to new head of reversed part

    return dummy.next;
}

//https://leetcode.com/problems/palindrome-linked-list/description/
public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
    // Step 1: Find middle of the list
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half
    ListNode prev = null;
    ListNode curr = slow;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // Step 3: Compare first half and reversed second half
    ListNode first = head;
    ListNode second = prev;
    while (second != null) {
        if (first.val != second.val) {
            return false;
        }
        first = first.next;
        second = second.next;
    }

    return true;
}
//https://leetcode.com/problems/reorder-list/
public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    // Step 1: Find the middle of the list
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half
    ListNode second = reverseList(slow.next);
    slow.next = null; // Cut off first half

    // Step 3: Merge two halves
    ListNode first = head;
    while (second != null) {
        ListNode tmp1 = first.next;
        ListNode tmp2 = second.next;

        first.next = second;
        second.next = tmp1;

        first = tmp1;
        second = tmp2;
    }
}
//https://leetcode.com/problems/reverse-nodes-in-k-group/
public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null){
        return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    int totalSize = sizeNode(head);
    int j = 0;
    while (j < k){
        int left = k * j + 1;
        int right = k * (j + 1);

        if(right > totalSize){
            right = totalSize;
        }

        for (int i = 1;prev != null && i < left ; i++) {
            prev = prev.next;
        }
        if(prev == null) {
            break;
        }

        ListNode pres = prev.next;
        ListNode curr = pres.next;

        if(right - left + 1 != k){
            break;
        }

        for (int i = 0;curr != null && i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = pres;
            pres = curr;
            curr = next;
        }
        prev.next.next = curr;
        prev.next = pres;
        j++;
    }
    return dummy.next;
}

    private int sizeNode(ListNode head) {
        if(head == null){
            return 0;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public class ListNode{
        private ListNode next;
        private int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
}
