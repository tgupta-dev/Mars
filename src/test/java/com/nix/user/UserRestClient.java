package com.nix.user;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.nix.user.model.User;

public class UserRestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/venus";

	// GET

	@SuppressWarnings("unchecked")
	private static void listAllUsers() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/",
				List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("userId") + ", Name=" + map.get("username"));
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	// GET
	private static void getUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
		System.out.println("User : id=" + user.getUserId() + ", Name=" + user.getUsername());
	}

	// POST
	private static void createUser() {
		System.out.println("Testing createUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User();
		user.setUserId(7);
		user.setUsername("pgupta7");
		user.setFirstname("Prachi");
		user.setLastname("Gupta");
		user.setEmail("pgupta@abc.com");
		user.setStatus(1);

		restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
	}

	// PUT
	private static void updateUser() {
		System.out.println("Testing updateUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User();
		user.setUserId(1);
		user.setEmail("iii@hhh.com");
		user.setStatus(0);
		restTemplate.put(REST_SERVICE_URI + "/user", user);
	}

	// DELETE
	private static void deleteUser() {
		System.out.println("Testing deleteUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/6");
	}

	public static void main(String args[]) {
		listAllUsers();
		// getUser();
		updateUser();
		// getUser();
		// createUser();
		// getUser();
		// listAllUsers();
		// updateUser();
		// listAllUsers();
		//deleteUser();
		// listAllUsers();
		// deleteAllUsers();
		listAllUsers();
	}
}