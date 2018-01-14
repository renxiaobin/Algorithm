package week2;

public class LinkAbout {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        l1.next = new LinkNode(2);
        l1.next.next = new LinkNode(3);
        l1.next.next.next = new LinkNode(4);
        l1.next.next.next.next = new LinkNode(5);
        l1.next.next.next.next.next = l1.next.next;

        LinkNode l2 = new LinkNode(6);
        l2.next = new LinkNode(7);
        l2.next.next = new LinkNode(8);
        l2.next.next.next = new LinkNode(9);

        LinkNode l3 = new LinkNode(10);
        l3.next = new LinkNode(11);
        l3.next.next = l2.next.next;
        l3.next.next.next = l2.next.next.next;


        isLoop(l1);
        isCrossNotLoop(l2, l3);

        LinkNode l4 = new LinkNode(6);
        l4.next = new LinkNode(7);
        l4.next.next = new LinkNode(8);
        l4.next.next.next = new LinkNode(9);
        l4.next.next.next.next = l4.next;

        LinkNode l5 = new LinkNode(10);
        l5.next = new LinkNode(11);
        l5.next.next = l4.next.next;
        isCrossLoop(l4,l5);
    }

    private static LinkNode isCrossLoop(LinkNode head1, LinkNode head2) {
        LinkNode cur1 = null;
        LinkNode cur2 = null;
        LinkNode loop1 = isLoop(head1);
        LinkNode loop2 = isLoop(head2);
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            System.out.println("cross and is "+cur1.value);
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    System.out.println("cross and is "+loop1.value);
                    return loop1;
                }
                cur1 = cur1.next;
            }
            System.out.println("no cross");
            return null;
        }
    }

    private static void isCrossNotLoop(LinkNode head1, LinkNode head2) {
        if (head1 == null && head2 == null) return;
        int len1 = 0, len2 = 0;
        LinkNode p1 = head1, p2 = head2;
        LinkNode temp=null;
        while (p1 != null) {
            temp=p1;
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        temp.next=head2;
        if (isLoop(head1)!=null) {
            System.out.println(isLoop(head1).value);
        }
    }

    private static LinkNode isLoop(LinkNode head) {
        LinkNode slow = head;
        LinkNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null) {
            System.out.println("no loop");
            return null;
        } else {
            LinkNode entr = head;
            while (entr != fast) {
                entr = entr.next;
                fast = fast.next;
            }
            System.out.println("have a loop, entrance is " + entr.value);
            return entr;
        }
    }

    static class LinkNode {
        LinkNode next;
        int value;

        public LinkNode(int v) {
            value = v;
            next = null;
        }
    }
}
