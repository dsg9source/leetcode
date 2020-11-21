package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DistanceNetween2Nodes {
	public static void main(String[] args) {
		BasicTree tree = new BasicTree();
		tree.data = 1;
		tree.left = new BasicTree();
		tree.left.data = 2;
		tree.right = new BasicTree();
		tree.right.data = 3;
		tree.left.left = new BasicTree();
		tree.left.left.data = 4;
		tree.left.right = new BasicTree();
		tree.left.right.data = 5;
		tree.right.left = new BasicTree();
		tree.right.left.data = 6;
		tree.right.right = new BasicTree();
		tree.right.right.data = 7;

		System.out.println("LCA(4, 5): " + lowestCommonAncestor(tree, 4, 5));
		System.out.println("LCA(4, 6): " + lowestCommonAncestor(tree, 4, 6));
		System.out.println("LCA(3, 4): " + lowestCommonAncestor(tree, 3, 4));
		System.out.println("LCA(2, 4): " + lowestCommonAncestor(tree, 2, 4));
		System.out.println("LCASHORTCUT  "+LCAShortcut(tree,3,4).data);
		System.out.println("Distance between 2 nodes is "+distanceBetween2Nodes(tree, 4,2));

	}
	
	public static int distanceBetween2Nodes(BasicTree root,int n1,int n2) {
		BasicTree lcaNode=LCAShortcut(root, n1, n2);
		int distanceN1=findDistance(lcaNode,n1);
		int distacneN2=findDistance(lcaNode,n2);
		return distacneN2+distanceN1;
				
		
	}

	private static int findDistance(BasicTree root, int nodeData) {
		if(root==null) {
			return -1;
		}
		if(root.data==nodeData) {
			return 0;
		}else {
			int valueLeft=findDistance(root.left, nodeData);
			int valueRight=findDistance(root.right, nodeData);
			if(valueLeft==-1 && valueRight!=-1) {
				return 1+valueRight;
			}else if(valueLeft!=-1 && valueRight==-1) {
				return 1+ valueLeft;
			}else {
				return -1;
			}
		}

	}

	public static int lowestCommonAncestor(BasicTree root, int n1, int n2) {
		List<Integer> path1 = new LinkedList<Integer>();
		List<Integer> path2 = new LinkedList<Integer>();

		boolean isN1Exists = findPathToNode(root, n1, path1);
		boolean isN2Exists = findPathToNode(root, n2, path2);
		System.out.println(Arrays.toString(path1.toArray()));
		System.out.println(Arrays.toString(path2.toArray()));
		if (isN1Exists && isN2Exists) {
			int i = 0;
			for (; i < path1.size() && i < path2.size(); i++) {
				if (path1.get(i) != path2.get(i)) {
					return path1.get(i - 1);
				}
			}
			if (i >= path1.size()) {
				return path1.get(path1.size() - 1);
			}
			if (i >= path2.size()) {
				return path2.get(path2.size() - 1);
			}

		}
		return -1;
		// Problem to this solution is it has extra space o(n) Time complexity is fine

	}

	private static boolean findPathToNode(BasicTree root, int n1, List<Integer> path1) {
		if (root == null) {
			return false;
		}
		if (root.data == n1) {
			path1.add(n1);
			return true;
		} else {
			path1.add(root.data);
			if (findPathToNode(root.left, n1, path1) || findPathToNode(root.right, n1, path1)) {
				return true;
			} else {
				path1.remove(path1.size() - 1);
				return false;
			}
		}

	}

	public static BasicTree LCAShortcut(BasicTree root, int n1, int n2) {
		if (root == null) {
			return null;
		}else if (root.data == n1 || root.data == n2) {
			return root;
		}else {
			BasicTree nodeLeft=LCAShortcut(root.left,n1,n2);
			BasicTree nodeRight=LCAShortcut(root.right,n1,n2);
			if(nodeLeft==null && nodeRight==null) {
				return null;
			}
			else if(nodeLeft!=null && nodeRight==null) {
				return nodeLeft;
			}
			else if(nodeLeft==null && nodeRight!=null) {
				return nodeRight;
			}
			else{
				return root;
			}
		}
		
	}
}
