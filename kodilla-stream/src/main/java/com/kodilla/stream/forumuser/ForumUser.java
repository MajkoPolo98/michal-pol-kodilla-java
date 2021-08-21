package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postAmount;

    public ForumUser(int userID, String username, char sex, int yearOfBirth,
                     int monthOfBirth, int dayOfBirth, int postAmount) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postAmount = postAmount;
    }

    public int getUserID() {
        return userID;
    }


    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostAmount() {
        return postAmount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postAmount=" + postAmount +
                '}';
    }
}
