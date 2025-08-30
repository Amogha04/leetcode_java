package Trees;

public class DFS {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;
    int diameter = 0;
    public int diameterOfBinaryTree(Node root) {
    //https://leetcode.com/problems/diameter-of-binary-tree/
      height(root);
      return diameter - 1;
    }
    public int height(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia,diameter);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    public Node invertTree(Node root){
        //https://leetcode.com/problems/invert-binary-tree/
        if(root == null){
            return null;
        }

        swapNode(root,root.left,root.right);

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void swapNode(Node root, Node left, Node right) {
        root.left = right;
        root.right = left;
    }
    public int maxDepth(Node root) {
        //https://leetcode.com/problems/maximum-depth-of-binary-tree/
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }
    public Node sortedArrayToBST(int[] nums) {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
        if(nums == null || nums.length == 0){
            return null;
        }
     return sortedArrayToBST(nums,0,nums.length - 1);
    }
    public Node sortedArrayToBST(int[] nums,int start,int end){
        if(start >= end){
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid);
        root.right = sortedArrayToBST(nums,mid + 1,end);

        return root;
    }
    public void flatten(Node root) {
        //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
        Node current = root;
        while (current != null) {
            while (current.left != null) {
            Node temp = current.left;
             while (temp.right != null){
                 temp = temp.right;
             }
             temp.right = current.right;
             current.right = current.left;
             current.left = null;
            }
            current = current.right;
        }
    }
        public boolean isValidBST(Node root) {
        //https://leetcode.com/problems/validate-binary-search-tree/submissions/1752725475/
            if (root == null) return true;
            return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean check(Node node, long min, long max) {
            if (node == null) return true;

            // node value must lie within (min, max)
            if (node.value <= min || node.value >= max) return false;

            // check left and right subtrees with updated constraints
            return check(node.left, min, node.value) &&
                    check(node.right, node.value, max);
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    int count = 0;
    int result = -1;

    public int kthSmallest(Node root, int k) {
        //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
        inorder(root, k);
        return result;
    }

    private void inorder(Node node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.value;
            return; // stop early once kth element is found
        }

        inorder(node.right, k);
    }
    public Node buildTree(int[] preorder, int[] inorder) {
     //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
        if(preorder.length == 0){
            return null;
        }
        int r = preorder[0];
        int index = 0;
        for (int i = 0;i < inorder.length;i++){
            if(inorder[i] == r){
                index = i;
            }
        }
        Node node = new Node(r);

        node.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),
                Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index,preorder.length),
                Arrays.copyOfRange(inorder,index,inorder.length));

        return node;
    }
    public boolean hasPathSum(Node root, int targetSum) {
   //https://leetcode.com/problems/path-sum/
        if (root == null) {
            return false;
        }

        // Subtract current node's value from target
        targetSum -= root.value;

        // If we reach a leaf, check if sum matches
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // Recurse into left OR right
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
    public int sumNumbers(Node root) {
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
       return helper(root,0);
    }

    private int helper(Node root, int sum) {
        if(root == null){
            return 0;
        }
        sum = sum * 10 + root.value;
        if(root.left == null && root.right == null){
            return sum;
        }
        int sumLeft = helper(root.left,sum);
        int sumRight = helper(root.right,sum);
        return sumLeft + sumRight;
    }
}

