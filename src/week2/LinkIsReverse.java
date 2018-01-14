package week2;

public class LinkIsReverse {
    public static void main(String[] args) {
        LinkNode header = new LinkNode(1);
        header.next=new LinkNode(2);
        header.next.next=new LinkNode(3);
        header.next.next.next=new LinkNode(3);
        header.next.next.next.next=new LinkNode(2);
        header.next.next.next.next.next=new LinkNode(1);
        System.out.println(isReverse(header));
    }

    private static boolean isReverse(LinkNode header) {
        LinkNode slow = header;
        LinkNode fast = header;

        if (fast==null || fast.next==null) return true;

        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        LinkNode midNode=slow;
        LinkNode firNode = slow.next;
        LinkNode cur = firNode.next;
        firNode.next=null;
        while (cur!=null){
            LinkNode nextNode = cur.next;
            cur.next=midNode.next;
            midNode.next=cur;
            cur=nextNode;
        }
        slow=header;
        fast=midNode.next;
        while (fast!=null){
            if (fast.value!=slow.value)
                return false;
            fast= fast.next;
            slow=slow.next;
        }
        return true;
    }

    static class LinkNode{
        LinkNode next;
        int value;
        public LinkNode(int v){
            value=v;
            next=null;
        }
    }
}
