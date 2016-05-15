/**
 * DonationManagerInterface class simulates the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient.
 * @author khandan Monshi
 *
 */
public interface DonationManagerInterface {
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */
	public boolean   ManagerLoadcontainer(DonationPackage dPackage) throws  ContainerException;
	 
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully , false if queue is full
	 * @throws VolunteerException if the Volunteer Line queue is full
	 */
	public  boolean  ManagerQueueVolunteer(Volunteer  v) throws  VolunteerException;
	 
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException if the Recipient line is full
	 */
	public boolean ManagerQueueRecipient(Recipient r) throws  RecipientException ;


	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @returns 1, if there are no volunteer, 2 if there are no recipients, 3 if container is empty, and 0 if the operation is successful
	 * 
	 */
	public  int donatePackage();
}