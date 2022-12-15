class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class DesignLinkedList {

	Node head, tail;

	public DesignLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtBeginning(int data) {
		Node node = new Node(data);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head = node;	
		}
		
	}

	// O(N) to insert a node at the end.
	public void insertAtEnd_N(int data) {
		Node node = new Node(data);
		if(this.head == null) {
			this.head = node;
		} else {
			Node temp = this.head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;	
		}
		
	}

	// (1) to insert a node at the end.
	public void insertAtEnd(int data) {
		Node node = new Node(data);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
	}

	public int deleteNode(int data) {
		if(this.head == null)
			return -1;
		Node temp = this.head;
		if(temp.data == data) {
			this.head = temp.next;
			return data;
		}
		Node prev = temp;
		temp = temp.next;
		while(temp != null) {
			if(temp.data == data) {
				prev.next = temp.next;
				if(temp.next == null) {
					this.tail = prev;
				}
				return data;
			}
			prev = temp;
			temp = temp.next;
		}
		return -1;
	}

	public void printList() {
		Node temp = this.head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		DesignLinkedList ll = new DesignLinkedList();
		ll.insertAtEnd(30);
		ll.insertAtEnd(40);
		ll.insertAtEnd(50);
		ll.insertAtBeginning(20);
		ll.insertAtBeginning(10);
		ll.insertAtEnd(60);
		ll.printList();
		ll.deleteNode(20);
		ll.printList();
		ll.deleteNode(60);
		ll.printList();
		ll.insertAtEnd(70);
		ll.printList();
	}
}
