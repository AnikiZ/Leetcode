package Tree;
import java.util.LinkedList;
import java.util.Queue;

class SubtreeofAnotherTree_572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        // Tree里元素可能相等，corner case: [1,1]和[1]
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            TreeNode start = null;
            // 加一个result因为有重复相同元素，都要比较
            boolean result = false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (n.val == subRoot.val) {
                    start = n;
                    result = same(start, subRoot);
                    if (result == true) {
                        return true;
                    }
                }
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            return false;
        }
        private boolean same(TreeNode start, TreeNode sub) {
            if (start == null && sub == null) {
                return true;
            }
            // 可以优化！
            if (start == null || sub == null || start.val != sub.val) {
                return false;
            }
            return same(start.left, sub.left) && same(start.right, sub.right);
        }
    }
    class Solution_Official {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return dfs(s, t);
        }
    
        public boolean dfs(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
        }
    
        public boolean check(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null || s.val != t.val) {
                return false;
            }
            return check(s.left, t.left) && check(s.right, t.right);
        }
    }
}