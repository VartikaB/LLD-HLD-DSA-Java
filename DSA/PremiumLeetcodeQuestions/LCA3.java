package DSA.PremiumLeetcodeQuestions;


public class LCA3 {

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }
    }

    static Node lowestCommonAncestor(Node p, Node q) {

        Node a = p;
        Node b = q;

        while (a != b) {

            if (a == null) {
                a = q;
            } else {
                a = a.parent;
            }

            if (b == null) {
                b = p;
            } else {
                b = b.parent;
            }
        }

        return a;
    }

    public static void main(String[] args) {

        /*
                  3
                /   \
               5     1
              / \
             6   2
                / \
               7   4
        */

        Node root = new Node(3);

        Node n5 = new Node(5);
        Node n1 = new Node(1);
        Node n6 = new Node(6);
        Node n2 = new Node(2);
        Node n7 = new Node(7);
        Node n4 = new Node(4);

        root.left = n5;
        root.right = n1;

        n5.parent = root;
        n1.parent = root;

        n5.left = n6;
        n5.right = n2;

        n6.parent = n5;
        n2.parent = n5;

        n2.left = n7;
        n2.right = n4;

        n7.parent = n2;
        n4.parent = n2;

        Node ans = lowestCommonAncestor(n5, null);

        System.out.println("LCA: " + ans.val);
    }
}
