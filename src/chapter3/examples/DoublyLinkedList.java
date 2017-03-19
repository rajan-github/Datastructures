package chapter3.examples;

public class DoublyLinkedList<E> {

	private static class Node<E> {
		private E data;
		private Node<E> previous;
		private Node<E> next;

		public Node() {
			super();
		}

		public Node(E data, Node<E> previous, Node<E> next) {
			super();
			this.data = data;
			this.previous = previous;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((previous == null) ? 0 : previous.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("rawtypes")
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (previous == null) {
				if (other.previous != null)
					return false;
			} else if (!previous.equals(other.previous))
				return false;
			return true;
		}

	}

	private int size;
	private Node<E> header;
	private Node<E> tail;

	public DoublyLinkedList() {
		super();
		size = 0;
		header = new Node<>();
		tail = new Node<>();
		header.setNext(tail);
		tail.setPrevious(header);
		tail.setNext(null);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getHeader() {
		return header;
	}

	public void setHeader(Node<E> header) {
		this.header = header;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		E first = null;
		if (!isEmpty()) {
			first = header.getNext().getData();
		}
		return first;
	}

	public E last() {
		E last = null;
		if (!isEmpty()) {
			last = tail.getPrevious().getData();
		}
		return last;
	}

	public void addFirst(E e) {
		Node<E> node = new Node<>(e, header, header.next);
		header.getNext().setPrevious(node);
		header.setNext(node);
		size++;
	}

	public void addLast(E e) {
		Node<E> node = new Node<>(e, tail.previous, tail);
		tail.previous.setNext(node);
		tail.setPrevious(node);
		size++;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			Node<E> temp = header.getNext().getNext();
			header.setNext(temp);
			temp.setPrevious(header);
			size--;
		}
	}

	public void removeLast() {
		if (!isEmpty()) {
			Node<E> temp = tail.getPrevious().getPrevious();
			tail.setPrevious(temp);
			temp.setNext(tail);
			size--;
		}
	}

	public void display() {
		Node<E> temp = header.getNext();
		while (!temp.equals(tail)) {
			System.out.print(temp.getData() + " ,");
			temp = temp.getNext();
		}
		System.out.println();
	}

	/**
	 * this method takes two doubly linked list nodes and swaps them.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void swapDoublyListNodes(Node<E> node1, Node<E> node2) {
		if (node1 != null && node2 != null) {
			Node<E> temp, temp1;
			temp1 = node1.getNext();
			temp = node1.getPrevious();
			node1.setNext(node2.getNext());
			node1.setPrevious(node2.getPrevious());
			if (node2.getNext() != null) {
				node2.getNext().setPrevious(node1);
			}
			node2.getPrevious().setNext(node1);
			node2.setNext(temp1);
			temp1.setPrevious(node2);
			node2.setPrevious(temp);
			temp.setNext(node2);
		}
	}

	public static void main(String args[]) {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();

		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("D");
		list.addFirst("E");
		list.addLast("Last");
		list.display();

		System.out.println("Nodw swapping A and last");
		list.swapDoublyListNodes(list.header.getNext(), list.tail.getPrevious());
		list.display();
		System.out.println("From here remove operation would start-");
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();
		list.removeFirst();
		list.display();

	}

}
