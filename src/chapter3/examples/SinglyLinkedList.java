package chapter3.examples;

public class SinglyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;

		@SuppressWarnings("unused")
		public Node(E element) {
			super();
			this.element = element;
		}

		public Node() {
			super();
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

	private Node<E> head = null, tail = null;
	private int size;

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Node<E> first() {
		return head;
	}

	public Node<E> last() {
		return tail;
	}

	public void addFirst(E item) {
		@SuppressWarnings("unchecked")
		Node<E> node = (Node<E>) new Node<Object>();
		node.setElement(item);
		node.setNext(head);
		head = node;
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E item) {
		@SuppressWarnings("unchecked")
		Node<E> node = (Node<E>) new Node<Object>();
		node.setElement(item);
		node.setNext(null);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	public Node<E> removeFirst() {
		Node<E> temp = null;
		if (!isEmpty()) {
			temp = head;
			head = head.next;
			size--;
		}
		return temp;
	}

	public void display() {
		if (!isEmpty()) {
			Node<E> temp = head;
			while (temp != null) {
				System.out.print(temp.getElement());
				System.out.print(" ,");
				temp = temp.getNext();
			}
			System.out.println();
		} else {
			System.out.println("List is empty!");
		}

	}

	/**
	 * this method takes head of the singly list and reverses it using only
	 * constant amount of space
	 * 
	 * @param head
	 */
	public Node<E> reverse(Node<E> head) {
		if (head.getNext() != null) {
			Node<E> temp, temp1;
			temp = head.getNext();
			head.setNext(null);
			while (true) {
				temp1 = temp.getNext();
				temp.setNext(head);
				head = temp;
				temp = temp1;
				if (temp.getNext() == null) {
					temp.setNext(head);
					tail = temp;
					break;
				}
			}
		}
		return this.tail;
	}

	public static void main(String args[]) {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("D");
		list.addFirst("E");
		list.addLast("Last");
		System.out.println("Before reversing the list-");
		list.display();
		System.out.println("Reversing the list");
		list.setHead(list.reverse(list.head));
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
		list.removeFirst();
		list.display();
	}

}
