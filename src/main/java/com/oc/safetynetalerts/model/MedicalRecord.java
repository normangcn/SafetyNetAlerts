package com.oc.safetynetalerts.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
"firstName",
"lastName",
"birthdate",
"medications",
"allergies"
})
@Generated("jsonschema2pojo")
public class MedicalRecord {

private UUID id;
private int age;

@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
private String fullName;
@JsonProperty("birthdate")
private String birthdate;
@JsonProperty("medications")
private List<String> medications = new ArrayList<String>();
@JsonProperty("allergies")
private List<String> allergies = new ArrayList<String>();
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public MedicalRecord() {
}

public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}

/**
*
* @param allergies
* @param firstName
* @param lastName
* @param birthdate
* @param medications
*/
public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
super();
this.firstName = firstName;
this.lastName = lastName;
this.birthdate = birthdate;
this.medications = medications;
this.allergies = allergies;
}


@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

public MedicalRecord withFirstName(String firstName) {
this.firstName = firstName;
return this;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

public MedicalRecord withLastName(String lastName) {
this.lastName = lastName;
return this;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}
public MedicalRecord withFullName(String fullName) {
this.fullName = fullName;
return this;
}
@JsonProperty("birthdate")
public String getBirthdate() {
return birthdate;
}

@JsonProperty("birthdate")
public void setBirthdate(String birthdate) {
this.birthdate = birthdate;
}

public MedicalRecord withBirthdate(String birthdate) {
this.birthdate = birthdate;
return this;
}

@JsonProperty("medications")
public List<String> getMedications() {
return medications;
}

@JsonProperty("medications")
public void setMedications(List<String> medications) {
this.medications = medications;
}

public MedicalRecord withMedications(List<String> medications) {
this.medications = medications;
return this;
}

@JsonProperty("allergies")
public List<String> getAllergies() {
return allergies;
}

@JsonProperty("allergies")
public void setAllergies(List<String> allergies) {
this.allergies = allergies;
}

public MedicalRecord withAllergies(List<String> allergies) {
this.allergies = allergies;
return this;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}
@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public MedicalRecord withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(MedicalRecord.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("firstName");
sb.append('=');
sb.append(((this.firstName == null)?"<null>":this.firstName));
sb.append(',');
sb.append("lastName");
sb.append('=');
sb.append(((this.lastName == null)?"<null>":this.lastName));
sb.append(',');
sb.append("birthdate");
sb.append('=');
sb.append(((this.birthdate == null)?"<null>":this.birthdate));
sb.append(',');
sb.append("medications");
sb.append('=');
sb.append(((this.medications == null)?"<null>":this.medications));
sb.append(',');
sb.append("allergies");
sb.append('=');
sb.append(((this.allergies == null)?"<null>":this.allergies));
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
result = ((result* 31)+((this.allergies == null)? 0 :this.allergies.hashCode()));
result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
result = ((result* 31)+((this.birthdate == null)? 0 :this.birthdate.hashCode()));
result = ((result* 31)+((this.medications == null)? 0 :this.medications.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof MedicalRecord) == false) {
return false;
}
MedicalRecord rhs = ((MedicalRecord) other);
return (((((((this.allergies == rhs.allergies)||((this.allergies!= null)&&this.allergies.equals(rhs.allergies)))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.birthdate == rhs.birthdate)||((this.birthdate!= null)&&this.birthdate.equals(rhs.birthdate))))&&((this.medications == rhs.medications)||((this.medications!= null)&&this.medications.equals(rhs.medications))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
}

}
