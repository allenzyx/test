114. Flatten Binary Tree to Linked List
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur.right!=null){
                stack.push(cur.right);
            }      
            if(cur.left!=null){
                cur.right = cur.left;
                cur.left = null;
            }else if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                cur.right = node;
            }
            cur = cur.right;
        }
    }
}


116. Populating Next Right Pointers in Each Node
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left!=null){
            cur = pre;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}

117. Populating Next Right Pointers in Each Node II
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode temp = new TreeLinkNode(0);
        while(root!=null){
            TreeLinkNode cur = temp;
			//level
            while(root!=null){
                if(root.left!=null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right!=null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = temp.next;
            temp.next = null;
        }
    }
}

102. Binary Tree Level Order Traversal
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int CountInLevel = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < CountInLevel; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}

113. Path Sum II
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        Stack<Integer> list = new Stack<>();
        helper(root,sum,list);
        return res;
    }
    
    public void helper(TreeNode root, int sum, Stack<Integer> list){
        list.push(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(list));
        }
        if(root.left!=null) helper(root.left,sum-root.val,list);
        if(root.right!=null) helper(root.right,sum-root.val,list);
        list.pop();
    }
}