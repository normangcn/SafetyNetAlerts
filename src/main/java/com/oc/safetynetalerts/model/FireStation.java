package com.oc.safetynetalerts.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"address",
"station"
})
@Generated("jsonschema2pojo")
public class FireStation {
	private UUID id;
@JsonProperty("address")
private String address;
@JsonProperty("station")
private String station;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public FireStation() {
}
public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}
/**
*
* @param address
* @param station
*/
public FireStation(String address, String station) {
super();
this.address = address;
this.station = station;
}

@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

public FireStation withAddress(String address) {
this.address = address;
return this;
}

@JsonProperty("station")
public String getStation() {
return station;
}

@JsonProperty("station")
public void setStation(String station) {
this.station = station;
}

public FireStation withStation(String station) {
this.station = station;
return this;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public FireStation withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(FireStation.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("address");
sb.append('=');
sb.append(((this.address == null)?"<null>":this.address));
sb.append(',');
sb.append("station");
sb.append('=');
sb.append(((this.station == null)?"<null>":this.station));
sb.append(',');
sb.append("additionalProperties");
sb.append('=');
sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

@Override
public int hashCode() {
int result = 1;
result = ((result* 31)+((this.station == null)? 0 :this.station.hashCode()));
result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof FireStation) == false) {
return false;
}
FireStation rhs = ((FireStation) other);
return ((((this.station == rhs.station)||((this.station!= null)&&this.station.equals(rhs.station)))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
}

}
