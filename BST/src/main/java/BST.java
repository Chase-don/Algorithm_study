import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    //二分搜索树内部私有类：Node  节点类
    private class Node {
        public E e;
        public Node left, right;

        //节点的构造函数
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    //二分搜索树的构造函数
    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法！
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {

//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
        if (node == null) {
            size++;
            return new Node(e);
        }
        //递归 画图去理解
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }


    //二分搜索树的前序遍历（DFS：深度优先算法）
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的非递归中序遍历
    public void inOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node cur = stack.pop();
                System.out.println(cur.e);
                root = cur.right;
            }

        }
    }
    //二分搜索树的中序遍历 ---> 二分搜索树的中序遍历结果是顺序的
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树， 递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历 ---> 应用：为BST释放内存
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树， 递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }


    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return minimum(root).e;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return maximum(root).e;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        Node max = maximum(node.right);
        return max;
    }

    //从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        //这里有返回值，返回的结果仍然是root（我们以root为根的BST中删除了最小值，最后又返回删除了最小值后结果那颗BST的对应根节点，这个根节点就是新的root）
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    //从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    //从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);

    }

    //删除掉以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e)<0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else { // e = node.e
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

//            //待删除节点左右节点
//            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点, 用这个节点顶替待删除节点的位置
//            Node successor = minimum(node.right);  //这个节点右子树的最小值（用来代替待删除节点）
//            successor.right = removeMin(node.right);   // 后继的右子树为原右子树删除最小节点后的树
//            successor.left = node.left;   // 后继的左子树就是原节点的左子树
//            node.left = node.right = null;
//            return successor;

            //或者可以找比待删除节点小的最大节点，即待删节点左子树的最大节点，用这个节点顶替待删除节点的位置
            Node predecessor = maximum(node.left);
            predecessor.left = removeMax(node.left);
            predecessor.right = node.right;
            node.left = node.right = null;
            return predecessor;

        }
    }

}
