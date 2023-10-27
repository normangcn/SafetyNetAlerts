/**
 * 
 */

package com.oc.safetynetalerts.model;

import lombok.AllArgsConstructor;

/**
 * @author NORMAN Gareth
 *
 */

@AllArgsConstructor
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
    String address;
    int station;
     
}
