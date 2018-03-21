/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValueEachRow = new ArrayList<>();
        traverse(root, maxValueEachRow, 0);
        return maxValueEachRow;
    }
    
    private void traverse(TreeNode root, List<Integer> maxValueEachRow, int level) {
        if (root == null)
            return;
        if (level == maxValueEachRow.size()) {
            maxValueEachRow.add(root.val);
        } else {
            int prev = maxValueEachRow.get(level);
            maxValueEachRow.set(level, Math.max(prev, root.val));
        }
        traverse(root.left, maxValueEachRow, level+1);
        traverse(root.right, maxValueEachRow, level+1);
    }
}
