package com.example.VotingApplication;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.VotingApplication.AuthorityCounter;
import com.example.VotingApplication.PoliticalParty;
import com.example.VotingApplication.User;
import com.example.VotingApplication.UserList;

//@SpringBootApplication
public class VotingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VotingApplication.class, args);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.VotingApplication");

		AuthorityCounter authorityCounter = (AuthorityCounter) applicationContext.getBean("simpleauthoritycounter");

		//AnnotationConfigApplicationContext will scan the components and configure beans using annotations, 
		//such as @Configuration, @Component, @Service, @Repository, and @Controller.
		while(true) {
		System.out.println("Welcome to voting Application");
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose from below:\n1. I want to vote\n2. See all the votes(ADMIN)");

		int userInput = sc.nextInt();
		String beanID = "";

		switch(userInput) {
			case 1 : {
				System.out.println("Enter your Username:");
				sc.nextLine();
				String userName = sc.nextLine();
				User user = (User) applicationContext.getBean("user");
				user.setUserName(userName);

				System.out.println("Choose the party you want to vote for:\n1. Democratic\n2. Republic\n3. Independent");
				int userPartySelect = sc.nextInt();
				switch(userPartySelect) {
					case 1 : { 
						beanID = "democratic";
						break;
					}
					case 2 : {
						beanID = "republic";
						break;
					}
					case 3 : {
						beanID = "independent";
						break;
					}
					
				}
				PoliticalParty politicalParty = (PoliticalParty) applicationContext.getBean(beanID);
				user.SetPoliticalParty(politicalParty);
				UserList userList = (UserList) applicationContext.getBean("userlist");
				userList.addUser(user);
				//we have added annotations @Autowired
				//authorityCounter.setUserList(userList);
				System.out.println("Thanks for voting...\n");
				break;
			}
			case 2 : {
				authorityCounter.getUserList().getUsersList().forEach(item -> System.out.println(item.getUserName() + "is voted for "+ item.getPoliticalParty().getPartyName()));
				applicationContext.close();
				break;
			}
		}
	}
	
	}

}
