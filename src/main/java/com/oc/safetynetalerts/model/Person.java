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
"firstName",
"lastName",
"address",
"city",
"zip",
"phone",
"email"
})
@Generated("jsonschema2pojo")
public class Person {
	private UUID id;
@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
private String fullName;
@JsonProperty("address")
private String address;
@JsonProperty("city")
private String city;
@JsonProperty("zip")
private String zip;
@JsonProperty("phone")
private String phone;
@JsonProperty("email")
private String email;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Person() {
}
public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}
/**
*
* @param zip
* @param firstName
* @param lastName
* @param address
* @param city
* @param phone
* @param email
*/
public Person(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
super();
this.firstName = firstName;
this.lastName = lastName;
this.address = address;
this.city = city;
this.zip = zip;
this.phone = phone;
this.email = email;
}

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

public Person withFirstName(String firstName) {
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

public Person withLastName(String lastName) {
this.lastName = lastName;
return this;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public Person withFullName(String fullName) {
this.fullName = fullName;
return this;
}
@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

public Person withAddress(String address) {
this.address = address;
return this;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

public Person withCity(String city) {
this.city = city;
return this;
}

@JsonProperty("zip")
public String getZip() {
return zip;
}

@JsonProperty("zip")
public void setZip(String zip) {
this.zip = zip;
}

public Person withZip(String zip) {
this.zip = zip;
return this;
}

@JsonProperty("phone")
public String getPhone() {
return phone;
}

@JsonProperty("phone")
public void setPhone(String phone) {
this.phone = phone;
}

public Person withPhone(String phone) {
this.phone = phone;
return this;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
}

public Person withEmail(String email) {
this.email = email;
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

public Person withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Person.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("firstName");
sb.append('=');
sb.append(((this.firstName == null)?"<null>":this.firstName));
sb.append(',');
sb.append("lastName");
sb.append('=');
sb.append(((this.lastName == null)?"<null>":this.lastName));
sb.append(',');
sb.append("address");
sb.append('=');
sb.append(((this.address == null)?"<null>":this.address));
sb.append(',');
sb.append("city");
sb.append('=');
sb.append(((this.city == null)?"<null>":this.city));
sb.append(',');
sb.append("zip");
sb.append('=');
sb.append(((this.zip == null)?"<null>":this.zip));
sb.append(',');
sb.append("phone");
sb.append('=');
sb.append(((this.phone == null)?"<null>":this.phone));
sb.append(',');
sb.append("email");
sb.append('=');
sb.append(((this.email == null)?"<null>":this.email));
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
result = ((result* 31)+((this.zip == null)? 0 :this.zip.hashCode()));
result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Person) == false) {
return false;
}
Person rhs = ((Person) other);
return (((((((((this.zip == rhs.zip)||((this.zip!= null)&&this.zip.equals(rhs.zip)))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))));
}
public Object personRecordConcatNames() {
	Person personRecordNameConcat = new Person();
	
	return personRecordNameConcat;
}
}
 