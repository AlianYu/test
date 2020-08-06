package com.springboot.springsecurity1.bean;

import io.swagger.annotations.Api;

@Api("Owner用户实体类")
public class Owner {
    private int ownerId;
    private String ownerName;
    private String ownerSex;
    private int ownerAge;
    private String ownerAddress;
    private String ownerEmail;

    public Owner() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSex='" + ownerSex + '\'' +
                ", ownerAge=" + ownerAge +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}
