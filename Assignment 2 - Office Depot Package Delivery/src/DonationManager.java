/**
 * The DonationManager class simulates the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient.
 * @author Nabeel Hussain
 *
 */
public class DonationManager implements DonationManagerInterface {
	
	private Container packContainer = new Container();
	private RecipientLine recipientQueue = new RecipientLine();
	private VolunteerLine volunteerQueue = new VolunteerLine();


	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	public boolean ManagerLoadcontainer(DonationPackage dPackage) throws ContainerException
	{
		
		if( packContainer.loadContainer(dPackage) == true)
		{
			return true;
		}
		else
		{
			throw new ContainerException("ContainerException: Container is full");
		}	
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully , false if queue is full
	 * @throws VolunteerException if the Volunteer Line queue is full
	 */
	public boolean ManagerQueueVolunteer(Volunteer v) throws VolunteerException {
		
		if(volunteerQueue.addNewVoluneer(v) == true)
		{
			return true;
		}
		else
		{
			throw new VolunteerException("VolunteerException: Volunteer Line is full");
		}
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException if the Recipient line is full
	 */
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException {
		if(recipientQueue.addNewRecepient(r) == true)
		{
			return true;
		}
		else
		{
			throw new RecipientException("RecipientException: Recipient Line is full");
		}
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @returns 1, if there are no volunteer, 2 if there are no recipients, 3 if container is empty, and 0 if the operation is successful
	 * 
	 */
	public int donatePackage() {

		if(volunteerQueue.volunteerLineEmpty() == true)
		{
			return 1;
		}
		else if(recipientQueue.recipientLineEmpty() == true)
		{
			return 2;
		}
		else if (packContainer.containerLineEmpty() == true)
		{
			return 3;
		}
		else{
			
			//System.out.println("Successfull");
			packContainer.removePackageFromContainer();
			
			recipientQueue.recipientTurn();
			
			Volunteer addBackToQueue = (Volunteer) volunteerQueue.toArrayVolunteer()[0];
			volunteerQueue.volunteerTurn();	
			
			volunteerQueue.addNewVoluneer(addBackToQueue);  // Add the deleted volunteer back to the volunteer queue in the back
			
			return 0;
		}
	}
	
	/**
	 * Returns an array containing the packages added into the container stack
	 * @return an array of objects from the container stack
	 */
	public Object[] contentArray()
	{
		Object[] elements = new Object[5];
		
		for(int i = 0; i < packContainer.toArrayPackage().length; i++)
		{	
			elements[i] = packContainer.toArrayPackage()[i];				
		}
		
		return elements;	
	}
	
	/**
	 * Returns an array containing the volunteers added into the volunteers Queue
	 * @return an array of the volunteers in the queue
	 */
	public Object[] volArray()
	{
		Object[] elements = new Object[5];		
		for(int i = 0; i < volunteerQueue.toArrayVolunteer().length; i++)
		{	
			elements[i] = volunteerQueue.toArrayVolunteer()[i];				
		}
		
		return elements;	
	}
	
	/**
	 * Returns an array containing the recipients added into the recipients Queue
	 * @return an array of the Recipients in the queue
	 */
	public Object[] recipArray()
	{
		Object[] elements = new Object[5];
		
		for(int i = 0; i < recipientQueue.toArrayRecipient().length; i++)
		{	
			elements[i] = recipientQueue.toArrayRecipient()[i];				
		}
		
		return elements;	
	}
}
