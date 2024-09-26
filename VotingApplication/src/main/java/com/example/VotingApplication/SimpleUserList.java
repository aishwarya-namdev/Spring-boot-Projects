package com.example.VotingApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("userlist")
public class SimpleUserList implements UserList {

    List<User> listOfUsers;

    public SimpleUserList() {
        this.listOfUsers = new ArrayList<User>();
    }

    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public List<User> getUsersList() {
        return this.listOfUsers;
    }

}
