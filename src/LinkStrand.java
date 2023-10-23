import java.util.*;
public class LinkStrand implements IDnaStrand{

    private class Node{

        String info;
        Node next;
        Node prev;

        public Node(String info) {
            this.info = info;
            this.next = null;
            this.prev = null;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;

    
    public LinkStrand(String dna){
        initialize(dna);
    }
    public LinkStrand(){
        this("");
    }


    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        Node newNode = new Node(source);
        myFirst = newNode;
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        Node newNode = new Node(dna);
        if (myLast != null){
            myLast.next = newNode;
        }
        else{
            myFirst = newNode;
        }
        newNode.prev = myLast;
        myLast = newNode;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        Node current = myLast; 
        StringBuilder strBuilder = new StringBuilder(current.info);
        IDnaStrand newStrand = new LinkStrand(strBuilder.reverse().toString());
        
        while (current.prev != null) {
            current = current.prev;
            strBuilder = new StringBuilder(current.info);
            newStrand.append(strBuilder.reverse().toString());
        }

        return newStrand;
    }


    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
	public String toString() {
        StringBuilder myString = new StringBuilder();
        Node node = myFirst;
        while (node != null){
            myString.append(node.info);
            node = node.next;
        }
		return myString.toString();
	}  
    

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charAt'");
    }
}