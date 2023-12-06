package com.oc.safetynetalerts.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"persons",
"firestations",
"medicalrecords"
})
@Generated("jsonschema2pojo")
public class CompleteJsonPOJO {

@JsonProperty("persons")
private List<Person> persons = new ArrayList<Person>();
@JsonProperty("firestations")
private List<FireStation> firestations = new ArrayList<FireStation>();
@JsonProperty("medicalrecords")
private List<MedicalRecord> medicalrecords = new ArrayList<MedicalRecord>();
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public CompleteJsonPOJO() {
}

/**
*
* @param persons
* @param firestations
* @param medicalrecords
*/
public CompleteJsonPOJO(List<Person> persons, List<FireStation> firestations, List<MedicalRecord> medicalrecords) {
super();
this.persons = persons;
this.firestations = firestations;
this.medicalrecords = medicalrecords;
}

@JsonProperty("persons")
public List<Person> getPersons() {
return persons;
}

@JsonProperty("persons")
public void setPersons(List<Person> persons) {
this.persons = persons;
}

public CompleteJsonPOJO withPersons(List<Person> persons) {
this.persons = persons;
return this;
}

@JsonProperty("firestations")
public List<FireStation> getFirestations() {
return firestations;
}

@JsonProperty("firestations")
public void setFirestations(List<FireStation> firestations) {
this.firestations = firestations;
}

public CompleteJsonPOJO withFirestations(List<FireStation> firestations) {
this.firestations = firestations;
return this;
}

@JsonProperty("medicalrecords")
public List<MedicalRecord> getMedicalrecords() {
return medicalrecords;
}

@JsonProperty("medicalrecords")
public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
this.medicalrecords = medicalrecords;
}

public CompleteJsonPOJO withMedicalrecords(List<MedicalRecord> medicalrecords) {
this.medicalrecords = medicalrecords;
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

public CompleteJsonPOJO withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(CompleteJsonPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("persons");
sb.append('=');
sb.append(((this.persons == null)?"<null>":this.persons));
sb.append(',');
sb.append("firestations");
sb.append('=');
sb.append(((this.firestations == null)?"<null>":this.firestations));
sb.append(',');
sb.append("medicalrecords");
sb.append('=');
sb.append(((this.medicalrecords == null)?"<null>":this.medicalrecords));
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
result = ((result* 31)+((this.firestations == null)? 0 :this.firestations.hashCode()));
result = ((result* 31)+((this.persons == null)? 0 :this.persons.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
result = ((result* 31)+((this.medicalrecords == null)? 0 :this.medicalrecords.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof CompleteJsonPOJO) == false) {
return false;
}
CompleteJsonPOJO rhs = ((CompleteJsonPOJO) other);
return (((((this.firestations == rhs.firestations)||((this.firestations!= null)&&this.firestations.equals(rhs.firestations)))&&((this.persons == rhs.persons)||((this.persons!= null)&&this.persons.equals(rhs.persons))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.medicalrecords == rhs.medicalrecords)||((this.medicalrecords!= null)&&this.medicalrecords.equals(rhs.medicalrecords))));
}

}