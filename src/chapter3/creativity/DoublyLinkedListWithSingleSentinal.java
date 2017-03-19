package chapter3.creativity;

public class DoublyLinkedListWithSingleSentinal<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> previous;

		public Node(E data, Node<E> next, Node<E> previous) {
			super();
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}

	}

	private Node<E> masterNode; // Note: previous link in this node points to
								// the last node of the list
	private int size;

	public DoublyLinkedListWithSingleSentinal() {
		super();
		Node<E> masterNode = new Node<>(null, null, null);
		this.masterNode = masterNode;
	}

	public Node<E> getMasterNode() {
		return masterNode;
	}

	public void setMasterNode(Node<E> masterNode) {
		this.masterNode = masterNode;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e, null, null);
		if (!isEmpty()) {
			Node<E> temp = masterNode.getNext();
			newNode.setNext(temp);
			newNode.setPrevious(masterNode);
			temp.setPrevious(newNode);
			masterNode.setNext(newNode);

		} else {
			// list is empty
			masterNode.setNext(newNode);
			masterNode.setPrevious(newNode);
			newNode.setPrevious(masterNode);
			newNode.setNext(null);
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e, null, null);
		if (isEmpty()) {
			this.masterNode.setNext(newNode);
			this.masterNode.setPrevious(newNode);
			newNode.setPrevious(masterNode);

		} else {
			masterNode.getPrevious().setNext(newNode);
			newNode.setPrevious(masterNode.getPrevious());
			masterNode.setPrevious(newNode);
		}
		newNode.setNext(masterNode);
		size++;
	}

	public void display() {
		if (!isEmpty()) {
			Node<E> temp = masterNode.getNext();
			for (int i = 0; i < size; i++) {
				System.out.print(temp.getData() + " ,");
				temp = temp.getNext();
			}
		} else {
			System.out.println("List is empty");
		}
	}

	public static void main(String[] args) {
		DoublyLinkedListWithSingleSentinal<String> list = new DoublyLinkedListWithSingleSentinal<>();
		list.addFirst("Amar");
		list.addFirst("Bakar");
		list.addFirst("Sakar");
		list.addLast("Last Node");
		list.display();
	}

}
