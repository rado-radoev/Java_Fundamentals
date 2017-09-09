package com.ex2129;

public class IndexedList<T extends Comparable<T>> extends List<T>{

	private List<T>[] indexes;  // create an array of lists that will contain the indexes(alphabet characters)
	
	public IndexedList () {
		indexes = new List[26];		// instantiate 26 list objects
		for (int i = 0; i < 26; i++) // create new List object for each index
			indexes[i] = new List<T>();
	}
	
	@Override
	public void print() {
		for (int i = 0; i < indexes.length - 1; i++) {
			System.out.printf("%s: ", (char)(i + 97));
			indexes[i].print();
			System.out.println();
		}
	}
	
	private int getIndex(T name) {
		String s = (String)name;
		return s.toLowerCase().charAt(0) - 97;
	}
	
	public void insertInIndexedList(T name) {
		// get the list from the array index
		List<T> temp = indexes[getIndex(name)]; 
		
		// add to the list
		temp.insertAtFront(name);
	}
	
	public T deleteFromIndexedList(T name) {
		// get the list from the array index
		List<T> temp = indexes[getIndex(name)];
		
		T returnValue = null;
		
		ListNode<T> nodeToDelete = searchIndexedList(name); // search the list and delete the node
		if (nodeToDelete != null) {
			returnValue = nodeToDelete.data;
			temp.deleteNode(nodeToDelete);
		}
		return returnValue;
	}
	
	public ListNode<T> searchIndexedList(T name) {
		List<T> temp = indexes[getIndex(name)];
		ListNode<T> currentNode = temp.getFirstNode();
		
		while (currentNode != null) {
			if (name.compareTo(currentNode.data) == 0)
				return currentNode;
			
			currentNode = currentNode.nextNode;
		}
		
		return null;
	}
}









