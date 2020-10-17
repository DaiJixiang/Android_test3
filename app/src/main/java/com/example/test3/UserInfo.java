package com.example.test3;

public class UserInfo {
    private String userName;
    private String password;
    private String name;
    private String age;
    private String birthday;
    private String phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "userName='" + userName + '\'' + ", password='" + password + '\'' +
                ", name='" + name + '\'' + ", age='" + age + '\'' + ", birthday='" + birthday + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
