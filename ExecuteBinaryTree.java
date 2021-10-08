import java.io.IOException;
import java.util.Stack;


/**
 * 
 */
public class ExecuteBinaryTree {


    /**
     * Binary tree pre order traversal.
     * Recursive function.
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {

            // **** display node value ****
            System.out.print(node.val + " ");

            // **** visit left child ****
            preOrder(node.left);

            // **** visit right child ****
            preOrder(node.right);
        }
    }


    /**
     * Binary tree post order traversal.
     * Recursive function.
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {

            // **** visit left child ****
            postOrder(node.left);

            // **** visit right child ****
            postOrder(node.right);

            // **** display node value ****
            System.out.print(node.val + " ");
        }
    }


   /**
     * Binary tree in order traversal.
     * Recursive function.
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {

            // **** visit left child ****
            inOrder(node.left);

            // **** display node value ****
            System.out.print(node.val + " ");

            // **** visit right child ****
            inOrder(node.right);
        }
    }


    /**
     * Receive the root of a binary
     * tree and recursively evaluate it.
     * Recursive function.
     */ 
    public static int evaluate(TreeNode root) {
      
    // **** base case ****
    if (root == null || root.val.equals("null")) return 0;

    // **** leaf node i.e, an integer ****
    if (root.left == null && root.right == null)
        return Integer.parseInt(root.val);

    // **** evaluate left subtree ****
    int leftEval = evaluate(root.left);

    // **** evaluate right subtree ****
    int rightEval = evaluate(root.right);

    // **** determine which operator to apply ****
    if (root.val.equals("+"))
        return leftEval + rightEval;
  
    if (root.val.equals("-"))
        return leftEval - rightEval;
  
    if (root.val.equals("*"))
        return leftEval * rightEval;
  
    return leftEval / rightEval;
    }


    // **** used by eval function ****
    static Stack<Integer> stack = null;
    

    /**
     * 
     */
    public static int eval(TreeNode node) {

        // **** initialization ****
        stack = new Stack<Integer>();

        // **** evaluate binary tree ****
        evalStack(node);

        // **** return result ****
        return stack.pop();
    }


    /**
     * Recursive call.
     */
    private static void evalStack(TreeNode node) {
        if (node != null) {

            // **** visit left child ****
            evalStack(node.left);

            // **** visit right child ****
            evalStack(node.right);

            // **** process stack ****
            if (node.val.compareTo("+") == 0 ||
                node.val.compareTo("-") == 0 ||
                node.val.compareTo("*") == 0 ||
                node.val.compareTo("/") == 0) {

                // **** ****
                int result = 0;

                // **** pop operands ****
                int a = stack.pop();
                int b = stack.pop();

                // **** perform operation ****
                if (node.val.compareTo("+") == 0)
                    result = b + a;
                else if (node.val.compareTo("-") == 0)
                    result = b - a;
                else if (node.val.compareTo("*") == 0)
                    result = b * a;
                else 
                    result = b / a;

                // **** push result ****
                stack.push(result);

            } else
                stack.push(Integer.parseInt(node.val));
        }
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** test case 1 ****
        TreeNode root = new TreeNode("*");
        root.left = new TreeNode("5");
        root.right = new TreeNode("-");
        root.right.left = new TreeNode("4");
        root.right.right = new TreeNode("2");

        // **** test case 2 ****
        // TreeNode root = new TreeNode("+");
        // root.left = new TreeNode("*");
        // root.left.left = new TreeNode("5");
        // root.left.right = new TreeNode("4");
        // root.right = new TreeNode("-");
        // root.right.left = new TreeNode("100");
        // root.right.right = new TreeNode("20");

        // **** test case 3 ****
        // TreeNode root = new TreeNode("+");
        // root.left = new TreeNode("*");
        // root.left.left = new TreeNode("5");
        // root.left.right = new TreeNode("4");
        // root.right = new TreeNode("-");
        // root.right.left = new TreeNode("100");
        // root.right.right = new TreeNode("/");
        // root.right.right.left = new TreeNode("20");
        // root.right.right.right = new TreeNode("2");


        // ???? ????
        System.out.println("main <<< preOrder: ");
        preOrder(root);
        System.out.println();

        // ???? ????
        System.out.println("main <<< inOrder: ");
        inOrder(root);
        System.out.println();

        // ???? ????
        System.out.println("main <<< postOrder: ");
        postOrder(root);
        System.out.println();


        // **** evaluate binary tree and display result ****
        System.out.println("main <<< evaluate: " + evaluate(root));

        // **** evaluate binary tree and display result ****
        System.out.println("main <<<     eval: " + eval(root));
    }
}