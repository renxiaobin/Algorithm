package week6;

public class BinarySearchTree {
    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        System.out.println(insertNode(root,9));
        insertNode(root,1);
        insertNode(root,5);
        insertNode(root,8);
        insertNode(root,2);
        insertNode(root,11);
        inorder(root);
        System.out.println(search(root,5)!=null);
        deleteNode(root,3);
        inorder(root);
        System.out.println(search(root,5)!=null);
    }

    static Node pre;

    static void inorder(Node root){
        if (root!=null){
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }
    static Node search(Node root, int key) {
        if (root == null) return null;
        if (root.value == key) return root;
        if (key < root.value) {
            pre = root;
            return search(root.left, key);
        } else {
            pre = root;
            return search(root.right, key);
        }
    }

    static boolean insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        if (search(root, value) != null) return false;
        if (value < pre.value) {
            pre.left = new Node(value);
        } else {
            pre.right = new Node(value);
        }
        return true;
    }

    static boolean deleteNode(Node root, int key) {
        if (root == null) return false;
        if (root.value == key) {
            if (root.left == null) {
                root.value = root.right.value;
                root.right=null;
            } else if (root.right == null) {
                root.value = root.left.value;
                root.left=null;
            } else {
                if (root.right.left != null) {
                    Node temp = root.right;
                    Node lastTemp = root;
                    while (temp.left != null) {
                        lastTemp = temp;
                        temp = temp.left;
                    }

                    root.value = temp.value;
                    if (root.right!=null){
                        lastTemp.left=temp.right;
                    }else{
                        lastTemp.left=null;
                    }


                } else if (root.left.right != null) {
                    Node temp = root.left;
                    Node lastTemp = root;
                    while (temp.right != null) {
                        lastTemp = temp;
                        temp = temp.right;
                    }
                    root.value = temp.value;
                    if (root.left!=null){
                        lastTemp.right=temp.left;
                    }else {
                        lastTemp.right = null;
                    }
                }
            }
            return true;
        }else{
            if (key<root.value){
                return deleteNode(root.left,key);
            }else{
                return deleteNode(root.right,key);
            }
        }
    }
}
