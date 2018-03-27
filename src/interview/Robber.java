package interview;

import java.util.HashMap;
import java.util.Map;

public class Robber {
    public static void main(String[] args) {
//        Node root = new Node(3);
//        Node n1 = new Node(2);
//        Node n2 = new Node(3);
//        Node n3 = new Node(3);
//        Node n4 = new Node(1);
//        root.left=n1;
//        root.right=n2;
//        root.left.right=n3;
//        root.right.right=n4;

        Node root = new Node(10);
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        root.left=n1;
        root.right=n2;
        root.left.right=n3;
        root.right.right=n4;
        root.left.left=n5;
        root.left.left.left=new Node(6);
        System.out.println(rob(root));
    }

    public static Map<Node,Integer> map = new HashMap<>();
    public static int rob(Node root){
        if (null==root){
            return 0;
        }

        if (map.get(root)!=null){
            return map.get(root);
        }

        int maxLeft = rob(root.left);
        int maxRight = rob(root.right);

        int maxLeftLeft=0;
        int maxLeftRight=0;
        if (root.left!=null){
            maxLeftLeft = rob(root.left.left);
            maxLeftRight = rob(root.left.right);
        }
        int maxRightLeft=0;
        int maxRightRight = 0;
        if (root.right!=null){
            maxRightLeft=rob(root.right.left);
            maxRightRight=rob(root.right.right);
        }
        int chooseCurrentNodeResult = 0;
        int notChooseCurrentNodeResult = 0;
        chooseCurrentNodeResult = root.value+maxLeftLeft+maxLeftRight+maxRightLeft+maxRightRight;
        notChooseCurrentNodeResult = maxLeft+maxRight;
        int result = notChooseCurrentNodeResult>chooseCurrentNodeResult?notChooseCurrentNodeResult:chooseCurrentNodeResult;
        map.put(root,result);
        return result;
    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node(int v){
            value=v;
        }
    }
}
