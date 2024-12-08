/** This class represents a Playlist of podcast episodes, where each
/*  episode is implemented as an object of type Episode. A user navigating
/*  a Playlist should be able to move between songs using next or previous references.
/*
/*  To enable flexible navigation, the Playlist is implemented as
/*  a Doubly Linked List where each episode has a link to both
/*  the next and the prev episodes in the list.
*/

/* THIS CODE WAS MY (OUR) OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR ONLINE RESOURCES.
Malia Walewski */

import java.util.*;


public class Playlist 
{
	private Episode head;
	private int size; 

	/**
	* Construct an empty playlist.
	*/
	public Playlist() {
		head = null;
		size = 0;
	}

	/**
	* Determines if list is empty.
	* @return true when empty
	*/
	public boolean isEmpty() {
		return head == null;
	}

	/**
	* Get number of episodes in list.
	* @return size of list
	*/
	public int getSize() {
		return size; 
	}

	/**
	* Convert list to string
	* @return string representation of playlist
	*/
	@Override
	public String toString() 
	{
		String output = "[HEAD] ";
		Episode current = head;
		if ( ! isEmpty() ) {
			while( current.next != null ) {
				output += current + " -> ";
				current = current.next;
			}
			output += current + " [END]\n";
		}
		else {
			output += " [END]\n";
		}
		return output;
	}


	/**
	* Returns string representing contents of playlist 
	* in reverse order.
	* @return reverse string representation of list
	*/
	public String toReverseString() 
	{
		String output = "[END] ";
		Episode current = head;
		if( ! isEmpty() ) {
			while(current.next != null) 
				current = current.next;
			// current is now pointing to last node
			
			while( current.prev != null ) {
				output += current + " -> ";
				current = current.prev;
			}
			output += current + " [HEAD]\n";
		}
		else {
			output += " [HEAD]\n";
		}
		return output;
	}
	
	
	/**************************************************************/
	// A4 Part 1 Methods (Add/Delete Operations)  
	
	public void addFirst( String title, double duration ) {
		Episode newEpisode = new Episode(title, duration, head, null);
		if(head != null) {
			head.prev = newEpisode;
		}
		head = newEpisode;
		size++;
	}

	
	public void addLast( String title, double duration ) {
		if(isEmpty()) {
			addFirst( title, duration);
		} else {
			Episode current = head; 
			while (current.next != null) {
				current = current.next; 
			}
			Episode newEpisode = new Episode(title, duration, null, current);
			current.next = newEpisode;
			size++;
		}
	}

	public Episode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} 
		Episode first = head; 
		if(first.next == null) { //if there is only one Episode
			head = null;
		} else {
			head = head.next; 
			head.prev = null; 
		}
		size--;
		return first;
	}
	
	public Episode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} 
		Episode current = head; 
		if(current.next == null) { //if there is only one episode 
			head = null; 
		} else {
			while(current.next != null) {
				current = current.next;
			}
			Episode last = current.prev; 
			last.next = null;
			current.prev = null;
		}
		size--;
		return current;
 	}
	
	public Episode deleteEpisode(String title) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		if(head.title.equals(title)){ //first Episode is title were looking for 
	     	return deleteFirst();
	    }	
		Episode current = head;
		Episode prevNode = null;
		if(current.next==null){ 
			throw new NoSuchElementException(); //title doesn't exist
		} else {
			while(current.next!=null) {
				if(current.title.equals(title)) {
					prevNode = current.prev;
					prevNode.next = current.next;
					current.next.prev = prevNode;
					current.prev = null;
					size--;
					return current;
				}
				current = current.next;
			}
		}

		if(current.next == null) {
			if(current.title.equals(title)) {
				prevNode = current.prev;
				prevNode.next = null; 
				current.prev = null;
				size--;
			} else {
				throw new NoSuchElementException();
			} 
		}
		return current;
	}


	/***************************************************************/
	// A4 Part 2 Methods (Sorting the Playlist using MergeSort)
	
	public Episode merge(Episode a, Episode b) {
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}

		Episode build;

		if(a.compareTo(b) <= 0) {
			build = a;
			if(build.next != null) {
				build.next.prev = build;
			}
			build.next = merge(a.next, b);
		} else {
			build = b;
			if(build.next != null) {
				build.next.prev = build;
			}
			build.next = merge(a, b.next);
		} 

		return build;
	}
	
	
	/**
	* Given a linked list beginning at Episode node, this
	* method returns the episode nearest to the midpoint position
	* of the list. In other words, if the given list contains
	* 3 episodes, the method will return the second episode.
	* For even-sized lists, it will return the node immediately
	* before the midpoint.
	* @param node first node in linked list, or null if empty
	* @return midpoint episode in list, or null if empty.
	*/
	private Episode getMiddleEpisode(Episode node) {
		if (node == null)
			return node;
		Episode slow = node;
		Episode fast = node;
	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return slow;
	 }
	
	/**
	* Sorts the current list by lexicographical order
	* of title of the episodes.
	*/
    public void mergeSort() {
    	// an empty list is already sorted
	    if (!isEmpty())
		    head = sort(head);
    }

	/**
	* Sorts the current list by lexicographical order
	* of title of the episodes.
	* The resulting list will contain the same episodes
	* as the initial list, but their order will determined
	* by their titles.
	* @param node first node of the list, or null if empty
	* @return first node of sorted list, or null if empty
	*/
	public Episode sort(Episode node) {
	     if (node == null || node.next == null)
	         return node;
	     Episode middle = getMiddleEpisode(node); //get the middle of the list
	     Episode left_head = node;
	     Episode right_head = middle.next;

	     // split the list into two halves:
	     if(right_head != null)
	     	right_head.prev = null;
	     middle.next = null;
	     
	     Episode left = sort(left_head);
	     Episode right = sort(right_head);
	     return merge(left, right);
	 }
	

}