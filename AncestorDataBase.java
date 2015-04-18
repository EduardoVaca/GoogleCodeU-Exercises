
public class AncestorDataBase{

	public static void main(String args[]){		
		AncestorTree tree = new AncestorTree();
		tree.inicializeAncestorTree("John");
		tree.addPerson("John", "Mary", "Jack", tree.root);
		tree.addPerson("Jack", "Martha", "Fred", tree.root);
		tree.printTree(tree.root);
		System.out.println("INT: " + tree.isAncestor("John", "Martha", tree.root, 0));
	}
}