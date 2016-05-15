public class MyLinkedListDriver
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add("Sarah");
		myLinkedList.add("Barbara");
		myLinkedList.add("Tom");
		myLinkedList.add("George");
		
		String largest = myLinkedList.findLargest();
		System.out.println(largest);
		
		myLinkedList.add("Zeke");
		myLinkedList.add("Adam");
	
		largest = myLinkedList.findLargest();
		System.out.println(largest);
		
		
		//additional test
		MyLinkedList myLinkedListSTUDENT = new MyLinkedList();

		myLinkedListSTUDENT.add("Alan");
		myLinkedListSTUDENT.add("Darnell");
		myLinkedListSTUDENT.add("Nabeel");
		largest = myLinkedListSTUDENT.findLargest();
		System.out.println(largest);
		
		
		
	}

}