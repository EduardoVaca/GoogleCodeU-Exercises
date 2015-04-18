import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree{
	//private BinaryTreeNode root;

	//Declaration of the Node class only for the use in the BinaryTree Class
	private static class BinaryTreeNode{
		BinaryTreeNode rightChild;
		BinaryTreeNode leftChild;
		String playload;

		BinaryTreeNode (String s){
			playload = s;
			rightChild = null;
			leftChild = null;
		}
	}

		//Im assuming that the root has laready been created. (The root will be the parameter)
	private static void insertIntoBinaryTree(BinaryTreeNode root, String s){
		if(root != null){ //Just in case
			if(Integer.parseInt(s) > Integer.parseInt(root.playload)){
				if(root.rightChild == null)
					root.rightChild = new BinaryTreeNode(s);
				else
					insertIntoBinaryTree(root.rightChild, s);
			}else{
					if(root.leftChild == null)
						root.leftChild = new BinaryTreeNode(s);
					else
						insertIntoBinaryTree(root.leftChild, s);
			}
		}				 
	}

	//One way of doing it: The list is a paramter so I can traverse the tree in an easier recursive way
	//I traverse the tree by In-order
	private static void flatten (BinaryTreeNode root, List<String> list){
		if(root != null){
			if(root.leftChild != null)
				flatten(root.leftChild, list);
			list.add(root.playload);
			if(root.rightChild != null)
				flatten(root.rightChild, list);
		}
	}

	//Another way of doing it: The only parameter is the root, the list is inicialized in each call of the function and returns it.
	//I traverse the tree by In-order
	private static List<String> flatten2(BinaryTreeNode root){
		if(root != null){
			List<String> list = new ArrayList<String>();
			if(root.leftChild != null)
				list.addAll(flatten2(root.leftChild));
			list.add(root.playload);
			if(root.rightChild != null)
				list.addAll(flatten2(root.rightChild));
			return list;
		}
		return null;		
	}

	public static void main (String args[]){
		//Inicialize the root
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert the value of the root: ");		
		BinaryTreeNode root = new BinaryTreeNode(Integer.toString(scan.nextInt()));		
		System.out.println("Instert number of nodes: ");
		int number_of_nodes = scan.nextInt();
		int node;
		//Instert nodes to the tree 
		for(int i = 0; i < number_of_nodes; i++){
			System.out.println("Insert value for node " + (i + 1));			
			insertIntoBinaryTree(root, "" + scan.nextInt());
		}
        List<String> list = new ArrayList<String>();
        list = flatten2(root);
        System.out.println("Nodes in tree...");
        for(String s : list)
            System.out.print(s + " ");
	}

}
