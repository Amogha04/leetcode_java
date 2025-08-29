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
}
