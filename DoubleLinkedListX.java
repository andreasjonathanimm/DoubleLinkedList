package asdlTugas2;

// Created by Sriwijaya University	//
// Billingual Class A 2021		//
// Group 1 				//
// Advanced Algorithm & Data Structure	//

import java.util.*;

public class DoubleLinkedListX {
	// Represents a Node of the Double Linked List
	Node head;
	Node tail;
	int size;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	public int size() {
		// Returns the size of the Double Linked List
		return size;
	}

	public void printList(boolean asc) { // Prints the Double Linked List data
		Node nodes = null;
		if (asc)
			// Starts from the head
			nodes = head;
		else
			// Starts from the tail
			nodes = tail;

		System.out.println("#### \tDOUBLE LINKED LIST PRINTED DATA\t####");
		System.out.print("\t[ ");
		while (nodes != null) {
			// Prints the data of the node in the list
			System.out.print(nodes.data + " ");

			if (asc)
				// Cycles through the head to tail or vice versa
				nodes = nodes.next;
			else
				nodes = nodes.prev;
		}

		System.out.println("]");
	}

	public void addFirst(int data) { // Adds data from the first node of the list
		// Create a new Node
		Node newNode = new Node(data);

		if (head == null) { // If the list is empty do:
			// Both head and tail will point to the new Node
			head = tail = newNode;

			// Head (newNode) previous is null
			head.prev = null;

			// Tail (newNode) next is null, as it is the last Node
			tail.next = null;

		} else {
			// Adds a new node before the head and makes it the head
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
		}
		// Increases the size of list
		size++;
	}

	public void addMiddle(int data) { // Adds the data from the middle of the list

		if (size < 3) { // Checks if the list is large enough to avoid index larger than list
			System.out.println("The list is not large enough, please use 'Add First Data' first.");
			return;
		}
		// Creates a new Node
		Node newNode = new Node(data);

		if (head == null) { // If the list is empty do:
			// Both head and tail will point to the new Node
			head = tail = newNode;

			// Head (newNode) previous is null
			head.prev = null;

			// Tail (newNode) next is null
			tail.next = null;
		} else {
			// Starts the current at head
			Node current = head, temp = null;

			// Finds the middle point of the List
			int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);

			// Iterates through the list until the middle point
			for (int i = 0; i < mid; i++) {
				current = current.next;
			}

			// Node temp points to the Node next to the current
			temp = current.next;
			temp.prev = current;

			// New node added between the current and temp
			current.next = newNode;
			newNode.prev = current;
			newNode.next = temp;
			temp.prev = newNode;
		}
		size++;
	}

	public void addLast(int data) { // Adds the data from the last node of the list
		// Starts from the head
		Node last = head;

		// Creates a new Node
		Node node = new Node(data);

		if (head == null) { // If the list is empty do:
			// Both head and tail will point to the new Node
			head = tail = node;

			// Head (newNode) previous is null
			head.prev = null;

			// Tail (newNode) next is null
			tail.next = null;
		} else {
			// Iterates until the last Node
			while (last.next != null) {
				last = last.next;
			}

			// Adds a new Node next to the last Node and makes it the tail
			last.next = node;
			node.prev = last;
			last = node;
			tail = last;
		}
		size++;
	}

	public void removeFirst() {
		// If list is empty, delete nothing
		if (head == null) {
			System.out.println("List is empty, please add data first");
			return;
		}

		// Deletes the first node and makes the next node the head
		Node node = head.next;
		node.prev = null;
		head = node;

		// Reduces the List size
		size--;
	}

	public void removeMid() {
		// If list is empty, delete nothing
		if (head == null) {
			System.out.println("List is empty, please add data first");
			return;
		}

		// Starts from the head
		Node current = head;

		// Find the middle point of the list
		int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);

		// Iterates until the middle point of the list
		for (int i = 0; i < mid; i++) {
			current = current.next;
		}

		if (current == head) { // If the middle node is the head, do:
			// Moves the head to the next node
			head = current.next;

		} else if (current == tail) { // If the middle node is the tail, do:
			// Moves the tail to the previous node
			tail = current.prev;

		} else {
			// Removes the current from the next node and previous node connections
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}

		// Nullifies the current node
		current = null;

		size--;
	}

	public void removeLast() {
		// If list is empty, delete nothing
		if (head == null) {
			System.out.println("List is empty, please add data first");
			return;
		}

		// Removes the last node and makes the previous node the tail
		Node node = tail.prev;
		node.next = null;
		tail = node;

		size--;
	}

	public boolean find(int data) {
		// Starts the flag that is false until data is found
		boolean flag = false;

		// Starts from the head
		Node n = head;

		// Iterates through the list
		while (n != null) {
			if (n.data == data) { // If the data is in the list, do:
				// Makes the flag true
				flag = true;

				// Breaks the iteration
				break;
			}
			// Continue iterating to the next
			n = n.next;
		}
		// Returns the flag
		return flag;
	}

	public boolean replace(int number, int data) {
		// Starts from the head
		Node nodes = head;

		boolean flag = false;

		// Iterates through the list
		while (nodes != null) {
			if (nodes.data == number) { // If the data is found in the list, do:
				flag = true;

				// Replaces the nodes data to the new data
				nodes.data = data;

				// Breaks the iteration
				break;
			}
			// Continue iterating to the next
			nodes = nodes.next;
		}
		return flag;
	}

	public int sum() {
		// Starts from the head
		Node nodes = head;

		// Starts the sum value
		int sum = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums all the nodes data in the list
			sum += nodes.data;

			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Returns the sum of list data
		return sum;
	}

	public double average() {
		// Starts from the head
		Node nodes = head;

		// Starts the sum and average value
		int sum = 0;
		double average = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums all the nodes data in the list
			sum += nodes.data;

			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Checks if the list is empty to avoid division by zero
		if (size == 0)
			average = sum / 1;
		else
			// Divides the sum by the list size
			average = (double) sum / (double) size;

		// Returns the average value
		return average;
	}

	public int median() {
		// Starts from the head
		Node nodes = head;

		// If list is empty, return 0
		if (head == null) {
			return 0;
		}

		// Find the middle point of the list
		int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);

		// Iterates until the middle point of the list
		for (int i = 0; i < mid; i++) {
			nodes = nodes.next;
		}
		// Returns the middle nodes data
		return nodes.data;
	}

	public int max() {
		// Starts from the head
		Node nodes = head;

		// Starts the max value
		int max = 0;

		// Iterates through the list
		while (nodes != null) {
			if (nodes.data > max) { // Finds the largest number in the list
				max = nodes.data;
			}
			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Returns the max value
		return max;
	}

	public int min() {
		// Starts from the head
		Node nodes = head;

		// Starts the min value
		int min = 0;

		// Iterates through the list
		while (nodes != null) {
			if (nodes.data < min) { // Finds the smallest number in the list
				min = nodes.data;
			}
			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Returns the min value
		return min;
	}

	public double variance() {
		// If list is empty, return 0
		if (head == null) {
			return 0;
		}

		// Starts from the head
		Node nodes = head;

		// Starts the sum and average value
		int sum = 0;
		double average = 0;
		double variance = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums all the nodes data in the list
			sum += nodes.data;

			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Checks if the list is empty to avoid division by zero
		if (size == 0)
			average = sum / 1;
		else
			// Divides the sum by the list size
			average = (double) sum / (double) size;

		// Starts at the head again
		nodes = head;

		// Restarts the sum value
		sum = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums up all the nodes data minus the average, and powered by 2
			sum += Math.pow(nodes.data - average, 2);

			// Continue iterating to the next
			nodes = nodes.next;
		}

		if (size <= 1) // If the size is smaller or equal to 1, divide the sum by 1
			variance = sum / 1;
		else // Divides the sum by the list size minus 1
			variance = sum / size - 1;

		// Returns the variance value
		return variance;
	}

	public double standardDeviation() {
		// If list is empty, return 0
		if (head == null) {
			return 0;
		}

		// Starts from the head
		Node nodes = head;

		// Starts the sum and average value
		int sum = 0;
		double average = 0;
		double variance = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums all the nodes data in the list
			sum += nodes.data;

			// Continue iterating to the next
			nodes = nodes.next;
		}
		// Checks if the list is empty to avoid division by zero
		if (size == 0)
			average = sum / 1;
		else
			// Divides the sum by the list size
			average = (double) sum / (double) size;

		// Starts at the head again
		nodes = head;

		// Restarts the sum value
		sum = 0;

		// Iterates through the list
		while (nodes != null) {
			// Sums up all the nodes data minus the average, and powered by 2
			sum += Math.pow(nodes.data - average, 2);

			// Continue iterating to the next
			nodes = nodes.next;
		}

		if (size <= 1) // If the size is smaller or equal to 1, divide the sum by 1
			variance = sum / 1;
		else // Divides the sum by the list size minus 1
			variance = sum / size - 1;

		// Returns the standard deviation value
		return Math.sqrt(variance);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Starts the Scanner, Double Linked List, integers, boolean, and input
		Scanner scan = new Scanner(System.in);
		DoubleLinkedListX dllist = new DoubleLinkedListX();
		int numbers = 0;
		int index = 1;
		boolean asc = true;
		String input = "0";

		while (true) { // MAIN MENU
			System.out.println("#### \tDOUBLE LINKED LIST\t####");
			System.out.println("\t1. Manual" + "\n\t2. Packaged" + "\n\t3. EXIT");

			System.out.print("\tPlease choose [1/2/3]: ");
			input = scan.next();
			System.out.println();

			if (input.equals("1")) { // MANUAL MENU
				while (true) {
					System.out.println("#### \tMANUAL OPERATIONS\t####");
					System.out.println("\t1. Add Data" + "\n\t2. Remove Data" + "\n\t3. Replace/Find Data"
							+ "\n\t4. Statistics" + "\n\t5. RETURN");
					System.out.print("\tPlease choose [1/2/3/4/5]: ");
					input = scan.next();
					System.out.println();

					if (input.equals("1")) { // DATA ADDITION MENU
						while (true) {
							System.out.println("#### \tDATA ADDITION OPERATIONS\t####");
							System.out.println("\t1. Add First Data" + "\n\t2. Add Middle Data" + "\n\t3. Add Last Data"
									+ "\n\t4. Print Data" + "\n\t5. RETURN");
							System.out.print("\tPlease choose [1/2/3/4/5]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // FIRST DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tFIRST DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("\tData " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enters the input to the first node of the list
									numbers = scan.nextInt();
									dllist.addFirst(numbers);

									index++;
									System.out.print("\tData " + index + " : ");
								}

							}

							if (input.equals("2")) { // MIDDLE DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tMIDDLE DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("\tData " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enter the input to the middle of the list
									numbers = scan.nextInt();
									dllist.addMiddle(numbers);

									index++;
									System.out.print("\tData " + index + " : ");

								}
							}

							if (input.equals("3")) { // LAST DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tLAST DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("\tData " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enter the input to the last node of the list
									numbers = scan.nextInt();
									dllist.addLast(numbers);

									index++;
									System.out.print("\tData " + index + " : ");

								}
							}

							if (input.equals("4")) { // PRINT DATA
								dllist.printList(asc);
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("5")) { // RETURN
								break;
							}
						}
					}

					if (input.equals("2")) { // DATA REMOVAL MENU
						while (true) {
							System.out.println("#### \tDATA REMOVAL OPERATIONS\t####");
							System.out.println("\t1. Remove First Data" + "\n\t2. Remove Middle Data"
									+ "\n\t3. Remove Last Data" + "\n\t4. Print Data" + "\n\t5. RETURN");

							System.out.print("\tPlease choose [1/2/3/4/5]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // FIRST DATA REMOVAL MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to delete data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tAre you sure you want to delete the first data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) { // Removes the first data
										dllist.removeFirst();
										System.out.println("\tData has been deleted\n");
									}
									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}
								}

							}

							if (input.equals("2")) { // MIDDLE DATA REMOVAL MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to delete data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tAre you sure you want to delete the middle data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) { // Removes the middle data
										dllist.removeMid();
										System.out.println("\tData has been deleted\n");
									}
									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}
								}
							}

							if (input.equals("3")) { // LAST DATA REMOVAL MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to delete data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tAre you sure you want to delete the last data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) { // Removes the last data
										dllist.removeLast();
										System.out.println("\tData has been deleted\n");
									}
									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}
								}
							}

							if (input.equals("4")) { // PRINT DATA
								dllist.printList(asc);
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("5")) { // RETURN
								break;
							}
						}
					}
					if (input.equals("3")) { // DATA REPLACEMENT/FINDER MENU
						while (true) {
							System.out.println("#### \tDATA REPLACEMENT/FINDER OPERATIONS\t####");
							System.out.println(
									"\t1. Replace Data" + "\n\t2. Find Data" + "\n\t3. Print Data" + "\n\t4. RETURN");

							System.out.print("\tPlease choose [1/2/3/4]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // REPLACE DATA MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to replace data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tDo you want to replace data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) { // Starts replacement process
										System.out.print("\tEnter the Numbers you want to Replace : ");
										int replace = scan.nextInt();

										if (replace < 0 || replace > Integer.MAX_VALUE) { // Checks the input value
											System.out
													.println("\tThe value of " + replace + "is incorrect, try again\n");
										} else {
											System.out.print("\tEnter Data : ");
											int number = scan.nextInt();

											// Replaces the number in the list with the input
											dllist.replace(replace, number);
											System.out.println("\tData has been replaced\n");
										}
									}

									if (input.equalsIgnoreCase("q")) { // Breaks the replacement loop
										System.out.println();
										break;
									}
								}
							}

							if (input.equals("2")) { // FIND DATA MENU
								while (true) {
									System.out.print("\tEnter the number you want to find : ");
									int number = scan.nextInt();

									if (number < 0 || number > Integer.MAX_VALUE) { // Checks the input value
										System.out.println("\n\tThe value of " + number + " is incorrect, try again\n");
									} else { // Finds the data in the list with the input
										System.out.println("\tIs the value " + number + " in the list?: "
												+ dllist.find(number) + "\n");
									}
									System.out.println("\t- Input Q to exit");

									System.out.print("\t Do you want to find data again? Input anything to continue: ");
									input = scan.next();

									if (input.equalsIgnoreCase("q")) { // Breaks the find data loop
										System.out.println();
										break;
									}
								}
							}

							if (input.equals("3")) { // PRINT DATA
								dllist.printList(asc);
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("4")) { // RETURN
								break;
							}
						}
					}
					if (input.equals("4")) { // STATISTICS MENU
						while (true) {
							System.out.println("#### \tSTATISTICS OPERATIONS\t####");
							System.out.println("\t1. Sum Data" + "\n\t2. Average Data" + "\n\t3. Median" + "\n\t4. Max"
									+ "\n\t5. Min" + "\n\t6. Variance" + "\n\t7. Standard Deviation"
									+ "\n\t8. Print Data" + "\n\t9. RETURN");

							System.out.print("\tPlease choose [1/2/3/4/5/6/7/8/9]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // SUM MENU
								System.out.println("\tThe sum of the list is " + dllist.sum());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("2")) { // AVERAGE MENU
								System.out.println("\tThe average of the list is " + dllist.average());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("3")) { // MEDIAN MENU
								System.out.println("\tThe median of the list is " + dllist.median());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("4")) { // MAX MENU
								System.out.println("\tThe Max of the list is " + dllist.max());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("5")) { // MIN MENU
								System.out.println("\tThe Min of the list is " + dllist.min());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("6")) { // VARIANCE MENU
								System.out.println("\tThe Variance of the list is " + dllist.variance());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("7")) { // STANDARD DEVIATION MENU
								System.out.println(
										"\tThe Standard Deviation of the list is " + dllist.standardDeviation());
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("8")) { // PRINT DATA
								dllist.printList(asc);
								System.out.print("\n\tInput anything to RETURN: ");
								input = scan.next();
							}

							if (input.equals("9")) { // RETURN
								break;
							}
						}
					}

					if (input.equals("5")) // RETURN
						break;
				}
			}

			if (input.equals("2")) { // PACKAGE MENU
				@SuppressWarnings({ "rawtypes" })
				LinkedList llist = new LinkedList();
				while (true) {
					System.out.println("#### \tPACKAGED OPERATIONS\t####");
					System.out.println(
							"\t1. Add Data" + "\n\t2. Remove Data" + "\n\t3. Replace/Find Data" + "\n\t4. RETURN");

					System.out.print("\tPlease choose [1/2/3/4]: ");
					input = scan.next();
					System.out.println();

					if (input.equals("1")) { // DATA ADDITION MENU
						while (true) {
							System.out.println("#### \tDATA ADDITION OPERATIONS\t####");
							System.out.println("\t1. Add First Data" + "\n\t2. Add Middle Data" + "\n\t3. Add Last Data"
									+ "\n\t4. Print Data" + "\n\t5. RETURN");
							System.out.print("\tPlease choose [1/2/3/4/5]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // FIRST DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tFIRST DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("Data " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enter the input to the first node of the list
									numbers = scan.nextInt();
									llist.addFirst(numbers);

									index++;
									System.out.print("Data " + index + " : ");
								}
							}

							if (input.equals("2")) { // MIDDLE DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tMIDDLE DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("Data " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enter the input to the middle of the list
									int number = scan.nextInt();
									llist.add(number);

									index++;
									System.out.print("Data " + index + " : ");
								}
							}

							if (input.equals("3")) { // LAST DATA ADDITION MENU
								index = 1;
								System.out.println("#### \tLAST DATA ADDITION OPERATIONS\t####");
								System.out.println("INFO:\t- Enter a number data (Integer)"
										+ "\n\t- Input a non-integer to RETURN\n");
								System.out.print("Data " + index + " : ");

								// Loops until the input is not an integer
								while (scan.hasNextInt()) {
									// Enter the input to the last node of the list
									int number = scan.nextInt();
									llist.addLast(number);

									index++;
									System.out.print("Data " + index + " : ");
								}
							}

							if (input.equals("4")) { // PRINT DATA
								while (true) {
									System.out.println("\tData : " + llist + "\n");
									System.out.print("INFO:\t- Input Q to RETURN : ");
									String Return = scan.next();
									System.out.println();

									if (Return.equalsIgnoreCase("q")) {
										break;
									}
								}
							}

							if (input.equals("5")) { // RETURN
								break;
							}
						}
					}

					if (input.equals("2")) { // DATA REMOVAL MENU
						while (true) {
							System.out.println("#### \tDATA REMOVAL OPERATIONS\t####");
							System.out.println("\t1. Remove First Data" + "\n\t2. Remove Middle Data"
									+ "\n\t3. Remove Last Data" + "\n\t4. Print Data" + "\n\t5. RETURN");

							System.out.print("\tPlease choose [1/2/3/4/5]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // FIRST DATA REMOVAL MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to delete data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tAre you sure you want to delete the first data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) { // Deletes the first data
										llist.removeFirst();
										System.out.println("\tData has been deleted\n");
									}
									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}
								}
							}

							if (input.equals("2")) { // MIDDLE DATA REMOVAL MENU
								while (true) {
									System.out.print("\tEnter index of the number you want to delete : ");
									int indexMid = scan.nextInt();
									System.out.println();

									if (indexMid >= 0 && indexMid <= llist.size() - 1) { // Checks if the index is in
																							// the list
										llist.remove(indexMid);
										System.out.println("\tData has been deleted");
									} else
										System.out.println("\t Data index incorrect ");

									System.out.println("INFO:\t- Input Q to RETURN\n");

									System.out.print("\tDo you still want to delete any data (press any key)? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}

								}
							}

							if (input.equals("3")) { // LAST DATA REMOVAL MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to delete data (Integer)" + "\n\t- Input Q to RETURN\n");

									System.out.print("\tAre you sure you want to delete the last data? : ");
									input = scan.next();
									if (input.equalsIgnoreCase("y")) { // Deletes the last data
										llist.removeLast();
									}
									if (input.equalsIgnoreCase("q")) { // Breaks the removal loop
										break;
									}
								}
							}

							if (input.equals("4")) { // PRINT DATA
								while (true) {
									System.out.println("\tData : " + llist + "\n");
									System.out.print("INFO:\t- Input Q to RETURN : ");
									String back = scan.next();
									System.out.println();

									if (back.equalsIgnoreCase("q")) {
										break;
									}
								}
							}

							if (input.equals("5")) { // RETURN
								break;
							}
						}
					}

					if (input.equals("3")) { // DATA REPLACEMENT/FINDER MENU
						while (true) {
							System.out.println("#### \tDATA REPLACEMENT/FINDER OPERATIONS\t####");
							System.out.println(
									"\t1. Replace Data" + "\n\t2. Find Data" + "\n\t3. Print Data" + "\n\t4. RETURN");

							System.out.print("\tPlease choose [1/2/3/4]: ");
							input = scan.next();
							System.out.println();

							if (input.equals("1")) { // REPLACE DATA MENU
								while (true) {
									System.out.println(
											"INFO:\t- Enter Y to replace data (Integer)" + "\n\t- Input Q to RETURN\n");
									System.out.print("\tDo you want to replace data? : ");
									input = scan.next();

									if (input.equalsIgnoreCase("y")) {
										System.out.print("\tEnter Index : ");
										int indexx = scan.nextInt();

										if (indexx >= llist.size() || indexx < 0) { // Checks if the index is in the
																					// list
											System.out.println("\tThere is no data in index " + indexx + "\n");
										} else {
											System.out.print("\tEnter Data : ");
											int select = scan.nextInt();

											// Replaces the data in the list with the input
											llist.set(indexx, select);
											System.out.println("\tData has been replaced\n");
										}
									}

									if (input.equalsIgnoreCase("q")) { // Breaks the replace loop
										System.out.println();
										break;
									}
								}
							}

							if (input.equals("2")) { // FIND DATA MENU
								while (true) {
									System.out.print("\tEnter index of the number you want to find : ");
									int indexFind = scan.nextInt();

									if (indexFind >= llist.size() || indexFind < 0) { // Checks if the index is in the
																						// list
										System.out.println("\n\tThere is no data in index " + indexFind + "\n");
									} else {
										System.out.println("\tThe data in index " + indexFind + " is "
												+ llist.get(indexFind) + "\n");
									}
								}
							}

							if (input.equals("3")) { // PRINT DATA
								while (true) {
									System.out.println("\tData : " + llist + "\n");
									System.out.print("INFO:\t- Input Q to RETURN : ");
									String back = scan.next();
									System.out.println();

									if (back.equalsIgnoreCase("q")) {
										break;
									}
								}
							}

							if (input.equals("4")) { // RETURN
								break;
							}
						}
					}

					if (input.equals("4")) { // RETURN
						break;
					}
				}
			}
			if (input.equals("3")) { // EXIT
				System.out.println("<o>\t See you later!\t\t<o>");
				break;
			}
		}
		scan.close();

	}

}
