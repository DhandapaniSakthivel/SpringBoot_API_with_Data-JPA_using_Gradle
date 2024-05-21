package com.root.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    String memberNumber;
    Integer age;
    String city;
    String gender;
    Integer noOfHOMPolicies;
    Integer noOfRPIPolicies;
    Integer noOfRENPolicies;

    public Member(String memberNumber, Integer age, String city, String gender, Integer noOfHOMPolicies, Integer noOfRPIPolicies, Integer noOfRENPolicies) {
        this.memberNumber = memberNumber;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.noOfHOMPolicies = noOfHOMPolicies;
        this.noOfRPIPolicies = noOfRPIPolicies;
        this.noOfRENPolicies = noOfRENPolicies;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public Integer getNoOfHOMPolicies() {
        return noOfHOMPolicies;
    }

    public Integer getNoOfRPIPolicies() {
        return noOfRPIPolicies;
    }

    public Integer getNoOfRENPolicies() {
        return noOfRENPolicies;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNoOfHOMPolicies(Integer noOfHOMPolicies) {
        this.noOfHOMPolicies = noOfHOMPolicies;
    }

    public void setNoOfRPIPolicies(Integer noOfRPIPolicies) {
        this.noOfRPIPolicies = noOfRPIPolicies;
    }

    public void setNoOfRENPolicies(Integer noOfRENPolicies) {
        this.noOfRENPolicies = noOfRENPolicies;
    }
}
