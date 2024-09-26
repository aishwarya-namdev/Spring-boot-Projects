package com.example.VotingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("simpleauthoritycounter")

//@Component will give the bean/object where we are calling it.
public class SimpleAuthorityCounter implements AuthorityCounter {
    
    
    @Autowired
    private UserList userList;

    @PostConstruct
    public void init() {
        System.out.println("DB Connection Successful.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Voting has been closed.");
        System.out.println();
    }

    @Override
    public UserList getUserList() {
        return this.userList;
    }

	@Override
	public void setUserList(UserList userList) {
		// TODO Auto-generated method stub
		//this.userList = userList;
		
	}


}
