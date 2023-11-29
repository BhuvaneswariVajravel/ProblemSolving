package com.wm_practice.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/***
 * A Problem: A company offers three types of software licenses to its client
 * company users.
 * 
 * How to count and list the users using each type of licence in the optimal
 * way? Which data structures or collections to use for calculating the same in
 * optimal way?
 *
 */

public class UserWithLicense {

	static final String LicType1 = "exclusive", LicType2 = "shared", LicType3 = "basic";

	public static void main(String[] args) {

// How to represent/store data in optimal way?

// My Proposed Approach
		Map<String, List<String>> ul = new HashMap<String, List<String>>(); // userId, List<Licenses>
		ul.put("User1", List.of(LicType1, LicType2));
		ul.put("User2", List.of(LicType1, LicType3));
		ul.put("User3", List.of(LicType2, LicType3));
		ul.put("User4", List.of(LicType1, LicType2, LicType3));
		ul.put("User5", List.of(LicType3));
		ul.put("User6", List.of(LicType1));
		ul.put("User7", List.of(LicType3));
 System.out.println(ul.toString());

// Solution (without Streams)
 getLicensedUsers(ul);

// Solution Using Streams
		getLicensedUsersUsingStream(ul);

	}

	private static void getLicensedUsers(Map<String, List<String>> ul) {

// Solution to list/count users using each type lic.
		List<String> Lic1Users = new ArrayList<>();
		List<String> Lic2Users = new ArrayList<>();
		List<String> Lic3Users = new ArrayList<>();

		for (Map.Entry<String, List<String>> e : ul.entrySet()) {
			if (e.getValue().contains(LicType1))
				Lic1Users.add(e.getKey());
			if (e.getValue().contains(LicType2))
				Lic2Users.add(e.getKey());
			if (e.getValue().contains(LicType3))
				Lic3Users.add(e.getKey());
		}

// Printing Counts/Lists of Users
		System.out.println(" Total Users with Licence Type " + LicType1 + " : " + Lic1Users.size());
		for (String s : Lic1Users)
			System.out.print(s + " ");

		System.out.println("\n\n Total Users with Licence Type " + LicType2 + " : " + Lic2Users.size());
		for (String s : Lic2Users)
			System.out.print(s + " ");

		System.out.println("\n\n Total Users with Licence Type " + LicType3 + " : " + Lic3Users.size());
		for (String s : Lic3Users)
			System.out.print(s + " ");

	}

	private static void getLicensedUsersUsingStream(Map<String, List<String>> ul) {

		Predicate<Map.Entry<String,List<String>>> predicateLic1Types = e->e.getValue().contains(LicType1);

		Predicate<Map.Entry<String, List<String>>> predicateLic2Types = e -> e.getValue().contains(LicType2);

		Predicate<Map.Entry<String, List<String>>> predicateLic3Types = e->e.getValue().contains(LicType3);
				
		List<String> Lic1Users = ul.entrySet().stream().filter(predicateLic1Types).map(e->e.getKey()).collect(Collectors.toList());
		
		List<String> Lic2Users = ul.entrySet().stream().filter(predicateLic2Types).map(e -> e.getKey()).collect(Collectors.toList());

		List<String> Lic3Users = ul.entrySet().stream().filter(predicateLic3Types).map(e->e.getKey()).collect(Collectors.toList());


// Printing Counts/Lists of Users
		System.out.println("\n\n Total Users with Licence Type " + LicType1 + " : " + Lic1Users.size());
		for (String s : Lic1Users)
			System.out.print(s + " ");

		System.out.println("\n\n Total Users with Licence Type " + LicType2 + " : " + Lic2Users.size());
		for (String s : Lic2Users)
			System.out.print(s + " ");

		System.out.println("\n\n Total Users with Licence Type " + LicType3 + " : " + Lic3Users.size());
		for (String s : Lic3Users)
			System.out.print(s + " ");

	}

}
