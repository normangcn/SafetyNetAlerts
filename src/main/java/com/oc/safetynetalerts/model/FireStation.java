/**
 * 
 */

package com.oc.safetynetalerts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

/**
 * @author NORMAN Gareth
 *
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStation {
    
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
    @JsonProperty("address")
    String address;
    @JsonProperty("station")
    int station;
     
}
