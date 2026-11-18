package DSA.PremiumLeetcodeQuestions;


import java.util.*;

public class LCA {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ------------------------------------------------
    // BUILD TREE
    // ------------------------------------------------

    static TreeNode buildTree() {

        /*
                  3
                /   \
               5     1
              / \   / \
             6   2 0   8
                / \
               7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        return root;
    }

    // ------------------------------------------------
    // LEETCODE 236
    // LCA of Binary Tree
    // Both p and q are guaranteed to exist
    // ------------------------------------------------

    static TreeNode lca236(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null) {
            return null;
        }

        // If current node is p or q
        if (root == p || root == q) {
            return root;
        }

        // Recursive calls
        TreeNode left = lca236(root.left, p, q);
        TreeNode right = lca236(root.right, p, q);

        // Both sides found something
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found p or q
        if (left != null) {
            return left;
        }

        return right;
    }

    // ------------------------------------------------
    // LEETCODE 1644
    // LCA of Binary Tree II
    // p and q may or may not exist
    // ------------------------------------------------

    static TreeNode lca1644(TreeNode root, TreeNode p, TreeNode q) {

        int[] found = new int[2];

        TreeNode ans = dfs1644(root, p, q, found);

        // Both nodes must be present
        if (found[0] == 1 && found[1] == 1) {
            return ans;
        }

        return null;
    }

    static TreeNode dfs1644(
            TreeNode root,
            TreeNode p,
            TreeNode q,
            int[] found) {

        // Base case
        if (root == null) {
            return null;
        }

        // Search both subtrees
        TreeNode left = dfs1644(root.left, p, q, found);
        TreeNode right = dfs1644(root.right, p, q, found);

        // Check current node
        if (root == p) {
            found[0] = 1;
            return root;
        }

        if (root == q) {
            found[1] = 1;
            return root;
        }

        // Both sides contain one of the target nodes
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    // ------------------------------------------------
    // LEETCODE 1676
    // LCA of Binary Tree IV
    // Multiple target nodes, all guaranteed to exist
    // ------------------------------------------------

    static TreeNode lca1676(TreeNode root, TreeNode[] nodes) {

        if (root == null) {
            return null;
        }

        // Check if current node is one of the targets
        for (TreeNode node : nodes) {
            if (root == node) {
                return root;
            }
        }

        TreeNode left = lca1676(root.left, nodes);
        TreeNode right = lca1676(root.right, nodes);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    // ------------------------------------------------
    // BONUS
    // Multiple target nodes, some may not exist
    // ------------------------------------------------

    static TreeNode lca1676Bonus(TreeNode root, TreeNode[] nodes) {

        Set<TreeNode> set = new HashSet<>();

        for (TreeNode node : nodes) {
            set.add(node);
        }

        TreeNode[] ans = new TreeNode[1];

        int count = dfsBonus(root, set, ans);

        // All target nodes must be present
        if (count == set.size()) {
            return ans[0];
        }

        return null;
    }

    static int dfsBonus(
            TreeNode root,
            Set<TreeNode> set,
            TreeNode[] ans) {

        if (root == null) {
            return 0;
        }

        // Count targets in left subtree
        int left = dfsBonus(root.left, set, ans);

        // Count targets in right subtree
        int right = dfsBonus(root.right, set, ans);

        // Count current node if it is a target
        int current = set.contains(root) ? 1 : 0;

        int matched = left + right + current;

        // First node whose subtree contains all targets
        if (matched == set.size() && ans[0] == null) {
            ans[0] = root;
        }

        return matched;
    }

    // ------------------------------------------------
    // FIND NODE BY VALUE (FOR TESTING)
    // ------------------------------------------------

    static TreeNode findNode(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = findNode(root.left, val);

        if (left != null) {
            return left;
        }

        return findNode(root.right, val);
    }

    // ------------------------------------------------
    // MAIN METHOD
    // TEST ALL VARIATIONS
    // ------------------------------------------------

    public static void main(String[] args) {

        TreeNode root = buildTree();

        TreeNode p = findNode(root, 5);
        TreeNode q = findNode(root, 1);

        // LEETCODE 236
        TreeNode ans236 = lca236(root, p, q);

        System.out.println(
                "LeetCode 236 LCA: " +
                (ans236 != null ? ans236.val : null)
        );

        // LEETCODE 1644
        TreeNode ans1644 = lca1644(root, p, q);

        System.out.println(
                "LeetCode 1644 LCA: " +
                (ans1644 != null ? ans1644.val : null)
        );

        // Test missing node for 1644
        TreeNode missing = new TreeNode(100);

        TreeNode ans1644Missing = lca1644(root, p, missing);

        System.out.println(
                "LeetCode 1644 with missing node: " +
                (ans1644Missing != null ? ans1644Missing.val : null)
        );

        // LEETCODE 1676
        TreeNode[] nodes = {
                findNode(root, 5),
                findNode(root, 1),
                findNode(root, 4)
        };

        TreeNode ans1676 = lca1676(root, nodes);

        System.out.println(
                "LeetCode 1676 LCA: " +
                (ans1676 != null ? ans1676.val : null)
        );

        // BONUS: Missing node scenario
        TreeNode[] bonusNodes = {
                findNode(root, 5),
                findNode(root, 1),
                missing
        };

        TreeNode ansBonus = lca1676Bonus(root, bonusNodes);

        System.out.println(
                "Bonus LCA with missing node: " +
                (ansBonus != null ? ansBonus.val : null)
        );
    }
}
