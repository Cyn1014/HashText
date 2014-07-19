import java.util.ArrayList;
import java.util.List;


public class LinkedList {

	private Node head;
	
	public LinkedList(){
		head=null;
	}
	
	public void increaseNode(String value){
		Node node=searchNode(value);
		if(node!=null)
			node.setValue(node.getValue()+1);
		else addNode(value,1);
	}
	
	public void addNode(String key,int value){
		Node node=new Node(key);
		node.setValue(value);
		node.setNext(head);
		if(head!=null)
		head.setPrevious(node);
		head=node;
	}
	
	public void increaseNode(String value,Position p){
		Node node=searchNode(value);
		if(node!=null){
			node.setValue(node.getValue()+1);
			node.addPosition(p);
		}
		else{
			List<Position> ps=new ArrayList<Position>();
			ps.add(p);
			addNode(value,1,ps);
		}
	}
	
	public void addNode(String key,int value,List<Position> p){
		Node node=new Node(key);
		node.setValue(value);
		node.setPositions(p);
		node.setNext(head);
		if(head!=null)
		head.setPrevious(node);
		head=node;
	}
	
	public Node searchNode(String value){
		Node result=null;
		Node node=head;
		while(node!=null){
			if(node.getKey().equalsIgnoreCase(value)){
				result=node;
				break;
			}else{
				node=node.getNext();
			}
			
		}
		return result;
	}
	
	public void deleteNode(String value){
		Node node=searchNode(value);
		if(node!=null){
			Node pre=node.getPrevious();
			Node next=node.getNext();
			if(pre==null)
				head=next;
			else
				pre.setNext(next);
				
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	

}
