package com.example.VotingApplication;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*If we are not setting the scope then the same object will use and override
Scope is 2 type singleton and prototype
by default it is singleton
*/
@Component("user")
@Scope("prototype")
public class SimpleUser implements User {

    private String userName;
    
    private PoliticalParty politicalParty;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public PoliticalParty getPoliticalParty() {
        return this.politicalParty;
    }

	@Override
	public void SetPoliticalParty(PoliticalParty politicalParty) {
		this.politicalParty = politicalParty;
		
	}


}
