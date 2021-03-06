/**
 * Enhanced TreeNode class typically used
 * to solve LeetCode binary tree problems.
 */
public class TreeNode {
    
    // **** class members ****
    String      val;
    int         height;

    TreeNode    left;
    TreeNode    right;

    /**
     * Constructor.
     */
    public TreeNode() {
    }

    /**
     * Constructor.
     */
    public TreeNode(String val) {
        this.val    = val;
        this.height = 1;
    }

    /**
     * Constructor.
     */
    public TreeNode(String val, TreeNode left, TreeNode right) {
        this.val    = val;
        this.left   = left;
        this.right  = right;
    }

    /**
     * Return a string representation of this node.
     */
    @Override
    public String toString() {

        // // **** value and height ****
        // return "(" + val + "," + height + ")";

        // **** value only ****
        return "(" + val + ")";
    }
}
