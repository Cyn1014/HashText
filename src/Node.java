import java.util.ArrayList;
import java.util.List;


public class Node {

	private String key;
	private int value;
	private Node next;
	private Node previous;
	private List<Position> positions;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node(String key){
		this.key=key;
		next=null;
		previous=null;
		value=1;
		positions=null;
	}
	public Node(String key,Position p){
		this.key=key;
		next=null;
		previous=null;
		value=1;
		positions=new ArrayList<Position>();
		positions.add(p);
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void addPosition(Position p) {
		this.positions.add(p);
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	

}
