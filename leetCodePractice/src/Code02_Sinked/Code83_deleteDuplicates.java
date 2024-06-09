package Code02_Sinked;

public class Code83_deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        // 记录头节点
        ListNode head1 = head;
        while (head.next!=null){
            if(head.val == head.next.val){
                // 一样时将当前的指向，赋值成下下一个指针
                head.next = head.next.next;
            }else {
                head = head.next;
            }

        }
        return head1;
    }

    public static void show(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3};
        ListNode listNode =new ListNode(3);
        ListNode listNode1 =new ListNode(3,listNode);
        ListNode listNode2 =new ListNode(2,listNode1);
        ListNode listNode3 =new ListNode(1,listNode2);
        ListNode listNode4 =new ListNode(1,listNode3);
        show(deleteDuplicates(listNode4));
    }
}
