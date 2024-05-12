/**
 * 
 */
package DTOs;


import java.util.List;

import lombok.Data;

/**
 * @author gareth
 *
 */
@Data
public class FloodStationsStationsOutDTO {
	
	private String address;
	List<Residents> residents;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Residents> getResidents() {
		return residents;
	}
	public void setResidents(List<Residents> residents) {
		this.residents = residents;
	}

	
}
