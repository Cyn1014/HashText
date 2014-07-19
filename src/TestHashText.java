import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestHashText {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private final static char[] symbolset={32,',','!','/',':',';','?','"','(',')','[',']','*'};
	
	private static int wordend(String line){
		int i=Integer.MAX_VALUE;
		for(char ch:symbolset){
			int index=line.indexOf(ch);
			if(index!=-1)
			if(i>index)
				i=index;
		}
		int index=line.indexOf("--");
		if(index!=-1)
			if(i>index)
				i=index;
		if(i==Integer.MAX_VALUE)
			i=-1;
		return i;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		HashTable hashTable=new HashTable();
		BufferedReader br = new BufferedReader(new FileReader("D:\\alice_out.txt"));
		String line;
		int row=0;
		while ((line = br.readLine()) != null) {
			row++;
			int col=1;
			int end=wordend(line);
		   while(end!=-1){
			   String word=line.substring(0, end);
			   if(word.length()>0)
			   {
				char begin=word.charAt(0);
			   if(begin=='\''||begin=='-') word=word.substring(1);
//			   hashTable.increase(word);
			  
			   if(word.length()>0){
			   char last=word.charAt(word.length()-1);
			   if(last=='.'||last=='\'')word=word.substring(0,word.length()-1);
			   if(word.length()>0)
			   {
			   Position p=new Position(row,col);
			   hashTable.increase(word,p);
			   
			   if(word.contains("alice")) 
				   System.out.println("alice");
			   
			   col++;
			   }
			   }
			   }
			   line=line.substring(end+1);
			   end=wordend(line);
			 
		   }
		   if(line.length()>0){
			   char begin=line.charAt(0);
			   if(begin=='\''||begin=='-') line=line.substring(1);
//			   hashTable.increase(word);
			   if(line.length()>0){
			   char last=line.charAt(line.length()-1);
			   if(last=='.'||last=='\'')line=line.substring(0,line.length()-1);
			   if(line.length()>0){
//			   hashTable.increase(line);
			   Position p=new Position(row,col);
			   hashTable.increase(line,p);
			   if(line.equalsIgnoreCase("crab")) 
				   System.out.println("crab");
			   }
			   }
		   }
		}
		br.close();
		Node node=hashTable.find("crab");
		System.out.println("key: "+node.getKey()+" value:"+node.getValue());
		hashTable.increase("Alice");
	    node=hashTable.find("Alice");
		System.out.println("key: "+node.getKey()+" value:"+node.getValue());
		Node node1=hashTable.find("lice");
		if(node1!=null)
		System.out.println("key: "+node1.getKey()+" value:"+node1.getValue());
		else System.out.println("lice not found");
		hashTable.insert("lice", 88);
		node1=hashTable.find("lice");
		System.out.println("key: "+node1.getKey()+" value:"+node1.getValue());
		hashTable.delete("lice");
		node1=hashTable.find("lice");
		if(node1!=null)
		System.out.println("key: "+node1.getKey()+" value:"+node1.getValue());
		else System.out.println("lice not found");
		//System.out.println("Alice".equals("Alice"));
		hashTable.listallkey(new PrintWriter(new FileWriter("output.txt",false)));
		hashTable.listallkeywithposition(new PrintWriter(new FileWriter("output2.txt",false)));
		

	}

}
