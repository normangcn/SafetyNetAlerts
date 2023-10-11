/**
 * 
 */
package DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/**
 * @author gareth
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStationsInDTO {

	@JsonProperty("address")
	private String address;
	@JsonProperty("station")
	private int station;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	
	
	

}
