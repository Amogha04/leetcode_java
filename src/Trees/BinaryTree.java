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
        private Node next;

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
    public List<Double> averageOfLevels(Node root) {
     //https://leetcode.com/problems/average-of-levels-in-binary-tree/
    List<Double> result = new ArrayList<>();
    if(root == null){
        return result;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
        int levelSize = queue.size();
        double sum = 0.0;
        for (int i = 0; i < levelSize; i++) {
            Node currentNode = queue.poll();
            sum = sum + currentNode.value;
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }
        double avg = sum / levelSize;
        result.add(avg);
    }
    return result;
    }
    public List<List<Integer>> zigzagLevelOrder(Node root) {
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean LeftToRight = true;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if(LeftToRight){
                    currentLevel.add(currentNode.value);
                }else currentLevel.addFirst(currentNode.value);
                if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
            }
            result.add(currentLevel);
            LeftToRight = !LeftToRight;
        }
        return result;
    }
    public List<List<Integer>> levelOrderBottom(Node root) {
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0;i < levelSize;i++){
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.addFirst(currentLevel);
        }
        return result;
    }
    public Node connect(Node root) {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
      if(root == null){
          return null;
      }
      Node leftmost = root;
      while (leftmost.left != null){
          Node current = leftmost;
          while (current != null){
              current.left.next = current.right;
              if(current.next != null){
                  current.right.next = current.next.left;
              }
              current = current.next;
          }
          leftmost = leftmost.left;
          }
      return root;
    }
    public List<Integer> rightSideView(Node root) {
    //https://leetcode.com/problems/binary-tree-right-side-view/
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if(i == levelSize - 1){
                    result.add(currentNode.value);
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
    public boolean isCousins(Node root, int x, int y) {
    //https://leetcode.com/problems/cousins-in-binary-tree/
        if(root == null){
            return false;
        }
        boolean isX = false;
        boolean isY = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tree = new ArrayList<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0;i < levelSize;i++){
                Node currentNode = queue.poll();
                if(currentNode.value == x){
                    isX = true;
                }
                if(currentNode.value == y){
                    isY = true;
                }
                if(currentNode.left != null && currentNode.right != null){
                    if(currentNode.left.value == x && currentNode.right.value == y ||
                            currentNode.left.value == y && currentNode.right.value == x){
                        return false;
                    }
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            if(isX && isY ){
                return true;
            }
            if(isX || isY ){
                return false;
            }
        }
        return false;
    }
}
