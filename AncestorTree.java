

public class AncestorTree{

	public Individual root = null;

	private static class Individual{
		String name;
		Individual father;
		Individual mother;

		Individual(String s){
			name = s;
			mother = null;
			father = null;
		}

	}


	public void inicializeAncestorTree(String s){
		root = new Individual(s);
	}

	public void addPerson(String person, String mother, String father, Individual root){
		if(root != null){
			if(root.name.equals(person)){
				root.mother = new Individual(mother);
				root.father = new Individual(father);
			}
			else{
				if(root.mother != null)
					addPerson(person, mother, father, root.mother);
				if(root.father != null)
					addPerson(person, mother, father, root.father);
			}
		}
	}

	public int isAncestor(String person, String ancestor, Individual root, int cont){
		System.out.println("Se mando llamar");
		if(root != null)
			if(root.name.equals(person) || cont > 0){				
				if(root.name.equals(ancestor))
					return cont;
				return isAncestor(person, ancestor, root.father, cont++) + isAncestor(person, ancestor, root.mother, cont);
				//return isAncestor(person, ancestor, root.mother, cont++);				
			}else{
				isAncestor(person, ancestor, root.father, cont);
				isAncestor(person, ancestor, root.mother, cont);
			}
		return 0;
	}

	public void printTree(Individual root){		
		if(root != null){			
			System.out.println(root.name);
			printTree(root.mother);
			printTree(root.father);
		}
	}

}