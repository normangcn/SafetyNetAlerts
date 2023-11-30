/**
 * 
 */

package com.oc.safetynetalerts.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

/**
 * @author NORMAN Gareth
 *
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) 
public class FireStation implements List<FireStation> {
    

    @JsonProperty("address")
    String address;
    @JsonProperty("station")
    int station;
    public FireStation() {
		super();
    }
    public FireStation(String address, int station) {
		this.address = address;
		this.station = station;
	}
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
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<FireStation> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(FireStation e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends FireStation> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends FireStation> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public FireStation get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FireStation set(int index, FireStation element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void add(int index, FireStation element) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public FireStation remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<FireStation> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<FireStation> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FireStation> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
