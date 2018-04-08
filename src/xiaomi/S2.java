package xiaomi;

public class S2 {
    static class Node{
        int value;
        Node left;
        Node right;
        Node(int v){
            value=v;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        root.left=n1;
        root.right=n2;
        root.left.left=n3;
        root.left.right=n4;
        root.right.right=n5;
        root.left.right.right=n6;
        //root.left.right.right.right=new Node(8);

        System.out.println(getDepth(root));
        System.out.println(isBalance(root));
    }

    public static int getDepth(Node root){
        if (root==null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int depth = leftDepth>rightDepth?leftDepth:rightDepth;
        return depth+1;
    }

    public static boolean isBalance(Node root){
        if (root==null) return true;
        int leftDepth=0,rightDepth=0;
        if (isBalance(root.left) && isBalance(root.right)){
            leftDepth = getDepth(root.left);
            rightDepth = getDepth(root.right);
            if (Math.abs(leftDepth-rightDepth)<2){
                return true;
            }
        }
        return false;
    }
}
