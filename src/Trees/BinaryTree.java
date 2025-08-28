package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    Node root;
    public List<List<Integer>> levelOrder(Node root) {
        //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
      List<List<Integer>> result = new ArrayList<>();
       if(root == null){
           return result;
       }
       Queue<Node> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()){
           int levelSize = queue.size();
           List<Integer> currentLevel = new ArrayList<>(levelSize);
           for (int i = 0; i < levelSize; i++) {
               Node currentNode = queue.poll();
               currentLevel.add(currentNode.value);
               if(currentNode.left != null){
                   queue.offer(currentNode.left);
               }
               if(currentNode.right != null){
                   queue.offer(currentNode.right);
               }
           }
           result.add(currentLevel);
       }
       return result;
    }
}
