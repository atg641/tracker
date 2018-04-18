import java.util.NoSuchElementException;

public class IntList {
	
	IntNode first;
	IntNode last;
	int size;
	
	void add(int e){
		IntNode newNode = new IntNode(last, e, null);
		last = newNode;
		size++;
	}
	
	int get(int i) {
		if(i < 0 || i <  size)
			throw new NoSuchElementException();
		IntNode n = first;
		for(int j = 0; j < i; i++)
			n = n.next;
		return n.item;	
	}
	
	void add(int i, int e){
		IntNode n = first;
		for(int j = 0; j < i; i++)
			n = n.next;
		IntNode newNode = new IntNode(n.prev, e, n);
		size ++;
	}
	

}
