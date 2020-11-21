package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class BasicTreeProblems {
	public static void main(String[] args) {
		// Height of Binary Tree
		BasicTree tree = new BasicTree();
		tree.data = 1;
		tree.left = new BasicTree();
		tree.left.data = 552;
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
		tree.right.right.right = new BasicTree();
		tree.right.right.right.data = 6789;

		System.out.println("Height of tree is : " + heightOfBinaryTree(tree));
		System.out.println("Min Height of BinaryTree is " + minHeightOfBinaryTree(tree));
		System.out.print("Deepest node in BinaryTree is ");
		deepestNodeInBinaryTree(tree);
		System.out.println("No of Leaf Nodes in a Tree is " + getNumberOfLeafNodes(tree));
		System.out.println("No of Full Nodes in a Tree is " + getNumberOfFullNodes(tree));
		BasicTree alternateTree = new BasicTree();
		alternateTree.data = 1;
		alternateTree.left = new BasicTree();
		alternateTree.left.data = 2;
		alternateTree.right = new BasicTree();
		alternateTree.right.data = 3;
		alternateTree.left.left = new BasicTree();
		alternateTree.left.left.data = 4;
		alternateTree.left.right = new BasicTree();
		alternateTree.left.right.data = 5;
		alternateTree.right.left = new BasicTree();
		alternateTree.right.left.data = 6;
		alternateTree.right.right = new BasicTree();
		alternateTree.right.right.data = 7;

		System.out.println("Are Trees Identical ?  " + isIdenticalBinaryTree(tree, alternateTree));
		System.out.println("Creating a Mirror Tree");
		BasicTree mirrorTree = createMirrorTree(alternateTree);
		TreeTraversal.inorder(mirrorTree);
		System.out.println("Mirror Tree -->" + isMirrorTree(tree, mirrorTree));
		System.out.println("Sum of All elements in a binary Tree " + sumAllElementsInBinaryTree(tree));
		System.out.println(
				"Print All Root to Leaf paths is a Binary Tree ----------------------------->>>>>>><<<<<<<<<<--------------");
		printAllRootToLeafPathsOfBinaryTree(tree);
		System.out.println("Level Having max Sum in Binary Tree is " + findLevelThatHasMaxSumInBinaryTree(tree));
		System.out.println("***************Level Order In reverse*");
		traverseLevelOrderInReverse(tree);

		System.out.println("Maximum Width of a binary Tree " + maxWidthBinaryTree(tree));
		System.out.println("ZigZag traversal of Binary Tree");
		zigzagTraversal(tree);
		System.out.println("Vertical Columnwise Sum is --->");
		verticalColumnwiseSum(alternateTree);

	}

	public static int heightOfBinaryTree(BasicTree root) {
		if (root == null) {
			return 0;
		} else {
			return maxHeight(1 + heightOfBinaryTree(root.left), 1 + heightOfBinaryTree(root.right));
		}

	}

	public static int maxHeight(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int minHeightOfBinaryTree(BasicTree root) {
		if (root == null) {
			return 0;
		} else {
			return minHeight(1 + minHeightOfBinaryTree(root.left), 1 + minHeightOfBinaryTree(root.right));
		}
	}

	public static int minHeight(int a, int b) {
		return (a > b) ? b : a;
	}

	public static void deepestNodeInBinaryTree(BasicTree root) {
		int depth = heightOfBinaryTree(root);
		getNodesofPredefinedLevel(root, depth, 1);
		System.out.println(Arrays.toString(nodesAtParticularLevel.toArray()));

	}

	static List<Integer> nodesAtParticularLevel = new ArrayList<Integer>();

	public static boolean getNodesofPredefinedLevel(BasicTree root, int reqdLevel, int currentLevel) {
		if (root == null) {
			return false;
		} else if (currentLevel == reqdLevel) {
			nodesAtParticularLevel.add(root.data);
			return true;
		} else {
			boolean t1 = getNodesofPredefinedLevel(root.left, reqdLevel, currentLevel + 1);
			boolean t2 = getNodesofPredefinedLevel(root.right, reqdLevel, currentLevel + 1);
			if (t1 || t2) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static int getNumberOfLeafNodes(BasicTree root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return getNumberOfLeafNodes(root.left) + getNumberOfLeafNodes(root.right);
		}
	}

	public static int getNumberOfFullNodes(BasicTree root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.right != null) {
			return 1 + getNumberOfFullNodes(root.left) + getNumberOfFullNodes(root.right);
		} else {
			return getNumberOfFullNodes(root.left) + getNumberOfFullNodes(root.right);
		}
	}

	public static boolean isIdenticalBinaryTree(BasicTree root1, BasicTree root2) {
		if (root1 != null && root2 != null) {
			if (root1.data == root2.data) {
				if (isIdenticalBinaryTree(root1.left, root2.left) && isIdenticalBinaryTree(root1.right, root2.right)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			if (root1 == null && root2 == null) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static BasicTree createMirrorTree(BasicTree root) {
		if (root == null) {
			return null;
		} else {
			BasicTree temp = root.left;
			root.left = root.right;
			root.right = temp;
			createMirrorTree(root.left);
			createMirrorTree(root.right);
		}
		return root;
	}

	public static boolean isMirrorTree(BasicTree root1, BasicTree root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		} else if (root1.data == root2.data) {
			if (isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static int sumAllElementsInBinaryTree(BasicTree root) {
		if (root == null) {
			return 0;
		} else {
			return root.data + sumAllElementsInBinaryTree(root.left) + sumAllElementsInBinaryTree(root.right);
		}

	}

	static List<Integer> allRootToLeafPathStorage = new ArrayList<Integer>();

	public static void printAllRootToLeafPathsOfBinaryTree(BasicTree root) {
		if (root == null) {
			return;
		} else {
			allRootToLeafPathStorage.add(root.data);
			if (root.left == null && root.right == null) {
				System.out.println(Arrays.toString(allRootToLeafPathStorage.toArray()));

			} else if (root.left == null && root.right != null) {
				printAllRootToLeafPathsOfBinaryTree(root.right);

			} else if (root.left != null && root.right == null) {
				printAllRootToLeafPathsOfBinaryTree(root.left);

			} else {
				printAllRootToLeafPathsOfBinaryTree(root.left);
				printAllRootToLeafPathsOfBinaryTree(root.right);

			}
			allRootToLeafPathStorage.remove(allRootToLeafPathStorage.size() - 1);
			return;
		}
	}

	public static int findLevelThatHasMaxSumInBinaryTree(BasicTree root) {
		Queue<BasicTree> q = new LinkedList<BasicTree>();
		int maxSum = 0;
		int intermediateSum = 0;
		int intermediateLevel = 0;
		int levelHavingMaxSum = 0;
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BasicTree node = q.poll();
			if (node == null) {
				if (q.peek() != null) {
					q.offer(null);
				}
				if (intermediateSum > maxSum) {
					maxSum = intermediateSum;
					levelHavingMaxSum = intermediateLevel;
					intermediateLevel++;
					intermediateSum = 0;
				} else {
					intermediateLevel++;
					intermediateSum = 0;
				}
			} else {
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}

				intermediateSum = intermediateSum + node.data;
			}

		}
		return levelHavingMaxSum;
	}

	public static void traverseLevelOrderInReverse(BasicTree root) {
		Queue<BasicTree> q = new LinkedList<BasicTree>();
		Stack<BasicTree> st1 = new Stack<BasicTree>();
		Stack<BasicTree> st2 = new Stack<BasicTree>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BasicTree node = q.poll();
			if (node != null) {
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				st1.push(node);
			} else {
				if (q.peek() != null) {
					q.offer(null);
				} // push delimiter only if a level data exists in the queue

				while (!st1.isEmpty()) {
					st2.push(st1.pop());
				}
			}

		}

		while (!st2.isEmpty()) {
			System.out.println(st2.pop().data);
		}

	}

	public static int maxWidthBinaryTree(BasicTree root) {
		int heightOfBinaryTree = heightOfBinaryTree(root);
		int[] treeArr = new int[heightOfBinaryTree];
		calculateTreeWidthAtEachLevel(root, 0, treeArr);
		int maxElementsinALevel = 0;
		for (int i = 0; i < treeArr.length; i++) {
			if (treeArr[i] > maxElementsinALevel) {
				maxElementsinALevel = treeArr[i];
			}
		}
		return maxElementsinALevel;

	}

	private static void calculateTreeWidthAtEachLevel(BasicTree root, int currentLevel, int[] treeArr) {
		if (root != null) {
			treeArr[currentLevel] = treeArr[currentLevel] + 1;
			calculateTreeWidthAtEachLevel(root.left, currentLevel + 1, treeArr);
			calculateTreeWidthAtEachLevel(root.right, currentLevel + 1, treeArr);
		}
	}

	public static void zigzagTraversal(BasicTree root) {
		Queue<BasicTree> q = new LinkedList<BasicTree>();
		Stack<BasicTree> stack = new Stack<BasicTree>();
		q.offer(root);
		q.offer(null);
		int currentLevel = 1;
		while (!q.isEmpty()) {
			BasicTree temp = q.poll();

			if (temp == null) {
				currentLevel = currentLevel + 1;
				while (!stack.isEmpty()) {
					q.offer(stack.pop());
				}
				if (q.peek() != null) {
					q.offer(null);
				}
				continue;
			} else {
				System.out.println(temp.data);
			}
			if (currentLevel % 2 == 0) {

				if (temp.left != null) {
					stack.push(temp.right);
				}
				if (temp.right != null) {
					stack.push(temp.left);
				}

			} else {
				if (temp.left != null) {
					stack.push(temp.left);
				}
				if (temp.right != null) {
					stack.push(temp.right);
				}
			}

		}

	}

	public static void verticalColumnwiseSum(BasicTree root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int defaultRootColumn = 0;
		traverseAndSumVerticalCoulmnwise(root, defaultRootColumn, map);
		for(Entry<Integer,Integer> entry:map.entrySet()) {
			System.out.println("Vertical Sum for Column -->"+entry.getKey()+"  Sum is -->"+entry.getValue());
		}

	}

	private static void traverseAndSumVerticalCoulmnwise(BasicTree root, int currentColumnNumber,
			Map<Integer, Integer> map) {
		if (root != null) {
			if (map.get(currentColumnNumber) != null) {
				map.put(currentColumnNumber, map.get(currentColumnNumber) + root.data);
			} else {
				map.put(currentColumnNumber, root.data);
			}
			
			traverseAndSumVerticalCoulmnwise(root.left, currentColumnNumber-1, map);
			traverseAndSumVerticalCoulmnwise(root.right, currentColumnNumber+1, map);
		}

	}

}
