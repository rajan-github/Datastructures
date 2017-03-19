package chapter3.examples;

public class CircularlyLinkedList<E> {
	private Node<E> tail;
	private int size;

	public CircularlyLinkedList() {
		super();
	}

	public CircularlyLinkedList(Node<E> tail, int size) {
		super();
		this.tail = tail;
		this.size = size;
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

	/**
	 * This method returns the first node but doesn't remove it from list.
	 * 
	 * @return
	 */
	public E first() {
		E first = null;
		if (size == 1) {
			first = tail.getData();
		} else if (size > 1) {
			first = tail.getNext().getData();
		}
		return first;
	}

	public E last() {
		E last = null;
		if (size >= 1) {
			last = tail.getData();
		}
		return last;
	}

	/**
	 * rotate the first element to the back of the list
	 */
	public void rotate() {
		if (!isEmpty()) {
			tail = tail.getNext();
		}
	}

	public void addFirst(E e) {
		if (isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> temp = new Node<>(e, tail.getNext());
			tail.setNext(temp);
		}
		size++;
	}

	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}

	public E removeFirst() {
		E removed = null;
		if (!isEmpty()) {
			if (size == 1) {
				removed = tail.getData();
				tail = null;
			} else {
				removed = tail.getNext().getData();
				Node<E> temp = tail.getNext().getNext();
				tail.setNext(temp);
			}
			size--;
		}
		return removed;
	}

	public void display() {
		if (!isEmpty()) {
			Node<E> temp = tail.getNext(), head = tail.getNext();
			do {
				System.out.println(temp.getData());
				temp = temp.getNext();
			} while (!temp.equals(head));
			System.out.println();
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * this method checks list1 & list2 have same sequence but may be they have
	 * different starting points
	 * 
	 * @param list1
	 * @param list2
	 * @returns true if both lists have same sequence otherwise returns false.
	 */
	public boolean compareTwoCircularList(CircularlyLinkedList<E> list1, CircularlyLinkedList<E> list2) {
		if (list1 != null && list2 != null) {
			Node<E> temp1 = list1.tail.getNext(), temp2 = list2.tail.getNext();
			boolean areListEqual = true;
			do {
				if (temp1.getData().equals(temp2.getData())) {
					areListEqual = areListEqual && true;
				}
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			} while (!temp1.equals(list1.tail.getNext()));
			if (areListEqual) {
				return true;
			}
			if (!temp2.getNext().equals(list2.getTail().getNext())) {
				return false;
			}
			// now lists are of equal size and we need to compare the sequence
			// now
			temp1 = list1.getTail().getNext();
			temp2 = list2.getTail().getNext();
			boolean firstNodeFound = false, listsAreEqual = true;
			do {
				if (firstNodeFound) {
					listsAreEqual = listsAreEqual && temp1.getData().equals(temp2.getData());
				} else {
					do {
						if (temp1.getData().equals(temp2.getData())) {
							firstNodeFound = true;
							break;
						}
						if (!firstNodeFound && temp2.getNext().equals(list2.getTail())) {
							// list2 has no match for the first node of the
							// list1
							// and hence not same sequence
							return false;
						}
					} while (!temp2.equals(list2.getTail().getNext()));
				}
				temp2 = temp2.getNext();
				temp1 = temp1.getNext();
			} while (!temp1.equals(list1.getTail().getNext()));
			return (listsAreEqual) ? true : false;

		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		CircularlyLinkedList<String> list1 = new CircularlyLinkedList<>();
		CircularlyLinkedList<String> list2 = new CircularlyLinkedList<>();
		list1.addFirst("A");
		list1.addFirst("B");
		list1.addFirst("C");
		list1.addFirst("D");
		list1.addFirst("E");
		list1.addLast("Last");
		list1.display();
		// list2.addFirst("z");
		list2.addFirst("A");
		list2.addFirst("B");
		list2.addFirst("C");
		list2.addFirst("D");
		list2.addFirst("E");
		list2.addLast("Last");
		list2.display();
		System.out.println("Comparing two lists: ");
		System.out.println(list1.compareTwoCircularList(list1, list2));

		// list1.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeFirst();
		// list.display();
	}

}
