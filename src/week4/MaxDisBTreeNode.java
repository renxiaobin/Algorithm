package week4;

public class MaxDisBTreeNode {
    public static void main(String[] args) {
        Node root = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();
        root.left=n1;
        root.right=n2;
        root.left.left=n3;
        root.left.right=n4;
        root.right.left=n5;
        root.right.right=n6;
        root.left.left.left=n7;
        root.left.left.left.right=n8;
        System.out.println(calMaxDis(root).maxDistance+1);
    }

    private static Result calMaxDis(Node root) {
        if (root==null){
            Result result = new Result();
            result.maxDepth=-1;
            result.maxDistance=0;
            return result;
        }
        Result lr = calMaxDis(root.left);
        Result rr = calMaxDis(root.right);

        Result result = new Result();
        result.maxDepth = Math.max(lr.maxDepth+1,rr.maxDepth+1);
        result.maxDistance=Math.max(Math.max(lr.maxDistance,rr.maxDistance),lr.maxDepth+rr.maxDepth+2);
        return result;
    }

    static class Node{
        Node left;
        Node right;
    }
    static class Result{
        int maxDepth;
        int maxDistance;
    }
}
