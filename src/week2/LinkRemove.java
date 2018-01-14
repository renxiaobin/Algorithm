package week2;

public class LinkRemove {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(3);
        l1.next = new LinkNode(2);
        l1.next.next = new LinkNode(3);
        l1.next.next.next = new LinkNode(1);
        l1.next.next.next.next = new LinkNode(3);

        removeSame(l1);
        print(l1);
        deleteNode(l1.next);
        print(l1);
    }

    private static void deleteNode(LinkNode node) {
        if (node==null) return;
        LinkNode nextNode = node.next;
        if (nextNode==null)return;
        node.next=nextNode.next;
        node.value=nextNode.value;

    }

    private static void removeSame(LinkNode l1) {
        LinkNode p = l1,q,r;
        while (p!=null){
            q=p;
            while (q.next!=null){
                if (q.next.value==p.value){
                    r=q.next;
                    q.next=r.next;

                }else{
                    q=q.next;
                }
            }
            p=p.next;
        }

        //print(l1);
    }

    private static void print(LinkNode node) {
        while (node !=null){
            System.out.println(node.value);
            node = node.next;
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
