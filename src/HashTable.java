import java.io.PrintWriter;
import java.util.List;


public class HashTable {

	private LinkedList[] table;
	
	private int hash(char[] word){
		int count=0;
		for(int i=0;i<word.length;i++){
			count=count+(int)word[i]*i*i;
		}
		return count%701;
	}
	
	public HashTable(){
		table=new LinkedList[701];
		for(int i=0;i<701;i++){
			table[i]=new LinkedList();
		}
	}
	
	public void insert(String key,int value){
		table[hash(key.toCharArray())].addNode(key.toString(),value);
	}
	
	public void insert(String key,int value,List<Position> plist){
		table[hash(key.toCharArray())].addNode(key.toString(),value,plist);
	}
	
	public void delete(String key){
		table[hash(key.toCharArray())].deleteNode(key);
	}
	
	public void increase(String key){
		table[hash(key.toCharArray())].increaseNode(key);
	}
	
	public void increase(String key,Position p){
		table[hash(key.toCharArray())].increaseNode(key,p);
	}
	
	public Node find(String key){
		return table[hash(key.toCharArray())].searchNode(key);
	}
	
	public void listallkey(){
		for(int i=0;i<701;i++){
			Node node=table[i].getHead();
			while(node!=null){
				System.out.print("key: "+node.getKey()+" value:"+node.getValue()+" ");
				node=node.getNext();
			}
			System.out.println();
		}
	}
	
	public void listallkey(PrintWriter out){
		for(int i=0;i<701;i++){
			Node node=table[i].getHead();
			while(node!=null){
				if(node.getKey().equalsIgnoreCase("crab"))
				System.out.println("crab");
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				node=node.getNext();
			}
			
		}
		out.flush();
		out.close();
	}
	
	public void listallkeywithposition(PrintWriter out){
		for(int i=0;i<701;i++){
			Node node=table[i].getHead();
			while(node!=null){
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				if(node.getPositions()!=null)
					for(Position p:node.getPositions())
						out.print(" line: "+p.getLine()+" word: "+p.getNumber());
				out.println();
				node=node.getNext();
			}
		}
		out.flush();
		out.close();
	}

	public void listallkey1(PrintWriter out){
		for(int i=0;i<350;i++){
			Node node=table[i].getHead();
			while(node!=null){
				if(node.getKey().equalsIgnoreCase("crab"))
				System.out.println("crab");
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				node=node.getNext();
			}
		}
	}
	
	public void listallkeywithposition1(PrintWriter out){
		for(int i=0;i<350;i++){
			Node node=table[i].getHead();
			while(node!=null){
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				if(node.getPositions()!=null)
					for(Position p:node.getPositions())
						out.print(" line: "+p.getLine()+" word: "+p.getNumber());
				out.println();
				node=node.getNext();
			}
		}
	}
	
	public void listallkey2(PrintWriter out){
		for(int i=350;i<701;i++){
			Node node=table[i].getHead();
			while(node!=null){
				if(node.getKey().equalsIgnoreCase("crab"))
				System.out.println("crab");
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				node=node.getNext();
			}
		}
	}
	
	public void listallkeywithposition2(PrintWriter out){
		for(int i=350;i<701;i++){
			Node node=table[i].getHead();
			while(node!=null){
				out.println(i+" key: "+node.getKey()+" value:"+node.getValue()+" ;");
				if(node.getPositions()!=null)
					for(Position p:node.getPositions())
						out.print(" line: "+p.getLine()+" word: "+p.getNumber());
				out.println();
				node=node.getNext();
			}
		}
	}
}
