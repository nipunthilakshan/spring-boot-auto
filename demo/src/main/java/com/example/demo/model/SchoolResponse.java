// Auto generated by Java Poet
package com.example.demo.model;

import java.lang.String;
import java.util.ArrayList;

public class SchoolResponse {
  private String firstName;

  private String lastName;

  private Address address;

  private ArrayList<PhoneNumber> phoneNumber;

  private int age;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ArrayList<PhoneNumber> getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(ArrayList<PhoneNumber> phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}