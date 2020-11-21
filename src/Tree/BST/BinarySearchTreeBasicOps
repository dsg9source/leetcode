package Tree.BST;

import Tree.BasicTree;
import Tree.TreeTraversal;

public class BinarySearchTreeBasicOps {

	public static void main(String[] args) {
		BasicTree root = insertBST(null, 5);
		insertBST(root, 6);
		insertBST(root, 7);
		insertBST(root, 4);
		insertBST(root, -32);
		insertBST(root, 13);

		TreeTraversal traversal = new TreeTraversal();
		traversal.inorder(root);

		System.out.println("This is the output of BST");
		System.out.println(search(root, 13).data);
		System.out.println("This is max and min element in the tree");
		System.out.println(maxElementBST(root).data + "      **  MIn LEment is " + minElementBST(root).data);
		System.out.println("LCa is " + lcaBST(root, 7, 13).data);
		System.out.println("Range of numbers in rangePrinter is ");
		rangePrinterBST(root, -91, 3);
		System.out.println("Floor For BST " + searchFloorBST(root, -66, root.data));
		System.out.println("Kth Smallest Element in BST "+kthSmallestElementInBST(root,1).data);
		;

	}

	public static BasicTree insertBST(BasicTree root, int data) {
		if (root == null) {
			BSTNode node = new BSTNode();
			node.data = data;
			node.left = null;
			node.right = null;
			return node;
		} else {
			if (data > root.data) {
				root.right = insertBST(root.right, data);

			} else {
				root.left = insertBST(root.left, data);
			}
			return root;
		}
	}

	public static BasicTree search(BasicTree root, int data) {
		if (root == null) {
			return null;
		} else {
			if (root.data == data) {
				return root;
			} else {
				if (root.data > data) {
					return search(root.left, data);
				} else {
					return search(root.right, data);
				}
			}
		}

	}

	public static BasicTree minElementBST(BasicTree root) {
		if (root == null) {
			return null;
		} else {
			if (root.left == null) {
				return root;
			} else {
				return minElementBST(root.left);
			}
		}

	}

	public static BasicTree maxElementBST(BasicTree root) {
		if (root == null) {
			return null;
		} else {
			if (root.right == null) {
				return root;
			} else {
				return maxElementBST(root.right);
			}
		}
	}

	public static BasicTree lcaBST(BasicTree root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (n1 > root.data && n2 > root.data) {
			return lcaBST(root.right, n1, n2);
		} else if (n1 < root.data && n2 < root.data) {
			return lcaBST(root.left, n1, n2);
		} else if (n1 > root.data && n2 < root.data || n1 < root.data && n2 > root.data) {
			return root;
		} else if (n1 == root.data || n2 == root.data) {
			return root;
		}
		return null;

	}

	public static void rangePrinterBST(BasicTree root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.data >= k1) {
			rangePrinterBST(root.left, k1, k2);
		}
		if (root.data >= k1 && root.data <= k2) {
			System.out.println(root.data);
		}
		if (root.data <= k2) {
			rangePrinterBST(root.right, k1, k2);
		}
	}

	public static int searchFloorBST(BasicTree root, int key, int previousValue) {
		if (root == null) {
			if (previousValue < key) {
				return previousValue;
			} else {
				return Integer.MIN_VALUE;
			}

		} else if (key == root.data) {
			return root.data;
		} else if (root.data > key && previousValue < key) {
			if (root.left == null) {
				return previousValue;
			} else {
				return minElementBST(root.left).data;
			}

		} else if (root.data < key && previousValue > key) {
			if (root.right == null) {
				return root.data;
			} else {
				return maxElementBST(root.right).data;
			}

		} else if (root.data > key && previousValue > key) {
			return searchFloorBST(root.left, key, root.data);
		} else if (root.data < key && previousValue < key) {
			return searchFloorBST(root.right, key, root.data);
		}
		return -1;

	}
	public static int kthValueCounter=0;
	public static BasicTree kthSmallestElementInBST(BasicTree root, int k) {
		if (root != null) {
			BasicTree node=kthSmallestElementInBST(root.left, k);
			if(node!=null) {
				return node;
			}
			kthValueCounter++;
			if(kthValueCounter==k) {
				return root;
			}
			BasicTree node2=kthSmallestElementInBST(root.right, k);
			if(node2!=null) {
				return root;
			}
			return null;
		}else {
			return null;
		}
	}
	
	
	public static BasicTree buildBSTFromSortedArray(int[] sortedArray) {
		
	}
	public static BasicTree buildBSTFromSortedLinkedList() {
		
	}

}

class BSTNode extends BasicTree {

}
