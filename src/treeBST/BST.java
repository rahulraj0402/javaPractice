package treeBST;



import java.security.PublicKey;

public class BST {

    public class Node{
        private int value;
        private int heigth;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public BST(){
    }

    public int height(Node node){
        if (node == null){
            return -1;
        }

        return node.heigth;
    }

    public boolean isEmpty(){
        return  root == null;
    }

    public void insert(int value ){
        root = insert(value , root);
    }

    private Node insert(int value , Node node){

        if (node == null){
            node = new Node(value);
        }
        if (value < node.value){
            node.left = insert(value , node.left);
        }

        if (value > node.value){
            node.right = insert(value , node.right);
        }

        node.heigth = Math.max(height(node.left) , height(node.right))+1;

        return node;
    }

    public void populate(int nums[]){
        for (int i = 0 ; i < nums.length ; i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int nums[]){
        populateSorted(nums , 0 , nums.length);
    }
    private void populateSorted(int nums[] , int start , int end ){
        if (start >= end){
            return;
        }
        int mid = start + (end - start) /2;
        this.insert(nums[mid]);
        populateSorted(nums , start , mid);
        populateSorted(nums , mid+1 , end);
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if (node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }



    public void display(){
        display(this.root , "root node : ");
    }
    private void display(Node node , String details){
        if (node == null){
            return;
        }

        System.out.println(details + node.value);
        display(node.left , "left of " + node.value + " : ");
        display(node.right ,  "right of " + node.value + " : ");
    }


    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);

    }


    public void postOrder(){
        inOrder(root);
    }
    private void pnOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value);

    }
}