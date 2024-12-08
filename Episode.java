// Class Episode represents an individual podcast episode.
// This is the equivalent of an individual "Node" in our class examples.
class Episode implements Comparable<Episode> {

	public String title; // episode title
	public double length; // episode length (minutes)
	public Episode next; // reference to next episode in playlist
	public Episode prev; // reference to previous episode in playlist

	/**
	* Construct an episode with the given fields.
	*/
	public Episode(String title, double length, Episode next, Episode prev) {
		this.title = title;
		this.length = length;
		this.next = next;
		this.prev = prev;
	}

	/**
	* Converts episode to string.
	* @return string representation of episode in the form
	*	(title|lengthMIN)
	*/
	public String toString() {
		return "("+ this.title + "|" + this.length + "MIN)" ;
	}

	/**
	* Compare this episode to another.
	* Result will be 0 if the two episodes are equal,
	* result will be -1 if this is less (i.e. lexicographically
	* earlier than) o, and result will be 1 if this is greater
	* than (i.e. lexicographically after) o.
	* Comparison is based on title.
	* @param o the other episode
	* @return comparison result, as above
	*/
	@Override
	public int compareTo(Episode o) {
		if (this.title.compareTo(o.title) < 0)
			return -1;
		else if (this.title.compareTo(o.title) > 0)
			return 1;
		else
			return 0;
	}
}
