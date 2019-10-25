import java.lang.Comparable;
import java.util.EmptyStackException;
public class BST<String>{
    class Node{
        Comparable data;
        Node left;
        Node right;
        public Node(Comparable item){
            data = item;
            left = null;
            right = null;

        }
    }
    Node root;
    public BST(){
        root = null;
    }
    public boolean find(Comparable item){
        return find(item,root);
    }
    private boolean find(Comparable item, Node root){
        if(root == null){
            return false;
        }
        if(root.data.compareTo(item)== 0 ){
            return true;
        }
        else if(root.data.compareTo(item)>0){
            return find(item,root.right);
        }
        else{
            return find(item, root.left);
        }
    }

    public void insert(Comparable item){
        root = insert(root,item);
    }
    private Node insert(Node n, Comparable item){
        if (n==null){
            return new Node(item);
        }
        if(n.data.compareTo(item)== 0){
            return n;
        }
        if(n.data.compareTo(item)<0){
            n.left = insert(n.left,item);
        }
        else{
            n.right = insert(n.right,item);
        }
        return n;

     }
    
     public void delete(Comparable item){
        root = delete(root, item);
     }
     private Node delete(Node n , Comparable item){
        if(n == null){
            throw new EmptyStackException();
        }
        if(n.data.compareTo(item)<0){
            n.left =delete(n.left,item);
        }
        else if(n.data.compareTo(item)>0){
            n.right = delete (n.right,item);
        }
        else{
            if (n.left == null){
                return n.right;
            }
            else if (n.right == null){
                return n.left;
            }
            else{
                Node temp = find_min(n.right);
                n.data = temp.data;
                n.right =delete(n.right, temp.data);
            }

        }
        return n;
    }

    private Node find_min(Node n)
    {
    while (n.left != null) 
        n = n.left;

    return n;
    }
    public void print(){
        print(root);
    }
    private void print(Node node){
        if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);

        }
    }
    

}




    