import java.util.ArrayList;

public class AVL<K extends Comparable<K>,V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVL() {
        root = null;
        size = 0;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断该二叉树是否为二分搜索树
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<K>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断该二叉树是否是一颗平衡二叉树
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    //判断以Node为根的二叉树是否是一颗平衡二叉树，递归算法
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    //获得节点node的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    //获得节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //向avl  树中添加新的元素
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 对节点y进行右旋转操作，返回旋转后新的根节点x
     *          y                                                  x
     *         / \                                               /   \
     *        x  T4            向右旋转（y）                    z      y
     *       / \            --------------->                  / \    / \
     *      z   T3                                          T1  T2 T3  T4
     *     / \
     *    T1  T2
     * @param y  从y这个节点开始不满足平衡性了
     * @return 返回的是进行右旋转操作后，最新的二叉树的根节点
     */
    private Node rightRotate(Node y) {
        Node node = y.left;
        Node temp = node.right;

        //向右旋转的过程
        node.right = y;
        y.left = temp;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    /**
     * 对节点y进行向左旋转操作，返回旋转后新的根节点x
     *         y                                                    x
     *        / \                                                 /   \
     *      T1   x                 向左旋转（y）                  y     x
     *          / \         ------------------------->          / \   / \
     *        T2   z                                          T1  T2 T3 T4
     *            / \
     *          T3  T4
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node temp = x.left;
        //向左旋转的过程
        x.left = y;
        y.right = temp;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) +1;

        return x;
    }


    /**
     * 向以node为根的二分搜索树中插入元素(key, value)，递归算法！
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return 返回的是新的二叉树的根节点
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {  // key.compareTo(node.key) == 0
            node.value = value;
        }
        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced:" + balanceFactor);
//        }

        // 因为是递归，所以对每一个节点都维护一下平衡性，维护完以后，下面执行return，到递归的上一层，上一层就是当前处理的这个节点的父亲节点
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            Node temp = leftRotate(node.left);
            node.left = temp; //转化成LL的情况
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //getNode：返回以node为根节点的二分搜索树中key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {  // key.compareTo(node.key) == 0
            return node;
        }
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = newValue;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

//    //删除以node为根的二分搜索树中的最小节点
//    //返回删除节点后新的二分搜索树的根
//    private Node removeMin(Node node) {
//        if (node.left == null) {
//            Node rightNode = node.right;
//            node.right = null;
//            size--;
//            return rightNode;
//        }
//        node.left = removeMin(node.left);
//        return node;
//    }


    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //删除以node为根的二分搜索树中键为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode =  node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {  // key.compareTo(node.key) == 0

            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }

            //待删除节点右子树为空的情况
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }

            //待删除节点左右子树都不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用找到的这个最小节点successor代替待删除节点的位置
            else {
                Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }

        //删除一个节点后，发现返回二叉树的根节点为空的话，就不需要考虑下面的问题了
        if (retNode == null) {
            return null;
        }

        //在得到retNode之后，要对retNode为根的二叉树进行判断，是否是平衡二叉树，不平衡的话要进行调整
        //更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 因为是递归，所以对每一个节点都维护一下平衡性，维护完以后，下面执行return，到递归的上一层，上一层就是当前处理的这个节点的父亲节点
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            Node temp = leftRotate(retNode.left);
            retNode.left = temp; //转化成LL的情况
            return rightRotate(retNode);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

}
