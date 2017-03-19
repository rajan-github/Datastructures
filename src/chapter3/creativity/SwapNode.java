package chapter3.creativity;

import chapter3.examples.Node;

public class SwapNode<E> {

	/**
	 * this method takes two nodes of a singly linked list and swap them.
	 * 
	 * @param node1
	 * @param node2
	 */
	public void swapSingleListNodes(Node<E> head, Node<E> node1, Node<E> node2) {
		if (head != null && node1 != null && node2 != null) {
			while (!head.getNext().equals(node1)) {
				head = head.getNext();
			}
			head.setNext(node2);
			node1.setNext(node2.getNext());
			node2.setNext(node1);
		}
	}

	}
