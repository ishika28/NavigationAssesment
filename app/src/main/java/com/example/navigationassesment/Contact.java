package com.example.navigationassesment;

public class Contact {
    private String name;
    private String PhoneNo;
    private int ImageId;

    public Contact(String name, String phoneNo, int imageId) {
        this.name = name;
        PhoneNo = phoneNo;
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
