package Tree;

public class TreeTraversal {

	public static void preorder(BasicTree root) {
		if (root != null) {
			System.out.println(root.data + "	");
			preorder(root.left);
			preorder(root.right);
		}

	}

	public static void postorder(BasicTree root) {
		if (root != null) {

			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data + "	");
		}
	}

	public static void inorder(BasicTree root) {
		if (root != null) {

			inorder(root.left);
			System.out.println(root.data + "	");
			inorder(root.right);
		}
	}
}
