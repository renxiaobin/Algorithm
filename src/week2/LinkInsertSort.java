package week2;

public class LinkInsertSort {
    public static void main(String[] args) {
        LinkNode header = new LinkNode(1);
        header.next=new LinkNode(3);
        header.next.next=new LinkNode(8);
        header.next.next.next=new LinkNode(6);
        header.next.next.next.next=new LinkNode(5);
        header.next.next.next.next.next=new LinkNode(2);

        print(header);
        insertSort(header);
        print(header);
    }

    public static void print(LinkNode header){
        while (header!=null){
            System.out.print(header.value+" ");
            header=header.next;
        }
        System.out.println();
    }

    private static void insertSort(LinkNode header) {
        LinkNode targetNode = header;
        LinkNode newHeader = null;

        while (targetNode!=null){
            LinkNode currentNode = newHeader;
            LinkNode lastNode = null;
            LinkNode nextNode = targetNode.next;
            while (currentNode!=null && currentNode.value<=targetNode.value){
                lastNode=currentNode;
                currentNode=currentNode.next;
            }
            if (lastNode==null){
                targetNode.next=newHeader;
                newHeader=targetNode;
            }else {
                targetNode.next=lastNode.next;
                lastNode.next=targetNode;
            }
            targetNode=nextNode;
        }
        header=newHeader;
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
