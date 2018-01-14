package week2;

public class LinkAdd {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(5);
        l1.next = new LinkNode(0);
        l1.next.next = new LinkNode(3);

        LinkNode l2 = new LinkNode(6);
        l2.next = new LinkNode(2);
        l2.next.next = new LinkNode(1);
        l2.next.next.next = new LinkNode(2);
        l2.next.next.next.next = new LinkNode(1);
        add(l1, l2);

    }

    private static void add(LinkNode l1, LinkNode l2) {
        int carry = 0;
        String result = "";
        while (l1 != null && l2 != null) {
            int value = l1.value + l2.value + carry;
            carry = value / 10;
            int temp = value % 10;
            result = temp + result;

            l1 = l1.next;
            l2 = l2.next;
        }


        if (l1 != null) {
            if (carry == 1) {
                result = (l1.value + 1) + result;
                l1=l1.next;
            }
            while (l1 != null) {
                result = l1.value + result;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            if (carry == 1) {
                result = (l2.value + 1) + result;
                l2=l2.next;
            }
            while (l2 != null) {
                result = l2.value + result;
                l2 = l2.next;
            }
        }

        System.out.println(result);
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
