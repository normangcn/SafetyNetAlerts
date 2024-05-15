/**
 * 
 */
package DTOs;


import java.util.ArrayList;
import java.util.List;


import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
public class FirestationStationNumberOutDTO {
	
	
	private List<FirestationStationNumberPeople> people;
	private int kids;
	private int adults;
	
	
	public List<FirestationStationNumberPeople> getPeople() {
		return people;
	}
	public void setPeople(List<FirestationStationNumberPeople> people) {
		this.people = people;
	}
	public void addPeople(FirestationStationNumberPeople person) {
        if (people == null) {
            people = new ArrayList<>();
        }

        people.add(person);
    }

	public int getKids() {
		return kids;
	}
	public void setKids(int kids) {
		this.kids = kids;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
}

