package assignment;

import java.util.*;

class Address {
	String city;
	int zipcode;

	Address(String city, int zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nCity: " + city + " ZipCode: " + zipcode;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Integer(zipcode).hashCode();
	}
}

class User {
	String name;
	int id;
	List<Address> address;

	User(String name, int id, List<Address> address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id + " Name: " + name + "\n";
	}
}

public class assignment1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// making of user array
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("User3", 3,
				List.of(new Address("BLR", 5601), new Address("BLR", 5602), new Address("DEL", 1101))));
		users.add(new User("User44", 44,
				List.of(new Address("BLR", 5638), new Address("DEL", 1196), new Address("DEL", 1101))));
		users.add(new User("User2", 2, List.of(new Address("BOM", 4018), new Address("BOM", 4037),
				new Address("DEL", 1101), new Address("BLR", 5638))));
		
		final TreeMap<Address, ArrayList<User>> map = new TreeMap<Address, ArrayList<User>>((a1, a2) -> {
			if (a1.city.compareTo(a2.city) == 0)
				return a1.zipcode - (a2.zipcode);
			else
				return a1.city.compareTo(a2.city);
//			return map.get(a1).size()-map.get(a2).size();
		});
		System.out.println(map.get(new Address("BOM", 4018)));
		users.forEach(user -> {
			user.address.forEach(add -> {
				ArrayList<User> u = map.get(add);
				if (u == null) {
					u = new ArrayList<User>();
					map.put(add, u);
				}
				u.add(user);
			});
		});
		TreeMap<Address, ArrayList<User>> map2 = new TreeMap<Address, ArrayList<User>>((a1, a2) -> {
//					System.out.println(a2);
			int x = map.get(a2).size() - map.get(a1).size();
			if (x != 0)
				return x;
			else
				return a2.zipcode - a1.zipcode;

		});
		map2.putAll(map);
		System.out.println("Users: ");
		map.forEach((address, user) -> {
			System.out.println(address);
			System.out.println(user);
		});
		System.out.println("Users according to cities:");
		map2.forEach((address, user) -> {
			System.out.println(address);
			System.out.println(user);
		});
		
	}

}

/**
 *
 * List: [ User{id:3,name: User3, address: [ { city: BLR, zipCode: 560001 }, {
 * city: BLR , zipCode: 560002 }, { city: DEL, zipCode: 110001}]}
 * User{id:44,name: User44, address: [ * { city: BLR, zipCode: 560038 }, * {
 * city: DEL , zipCode: 110096 }, * { city: DEL, zipCode: 110001}]}
 * User{id:2,name: User2, address: [ * * { city: BOM, zipCode: 400018 }, * * {
 * city: BOM , zipCode: 400037 }, * * { city: DEL, zipCode: 110001 } { city:
 * BLR, zipCode: 560001 }]} ] Build a ranking system for cities based on
 * employees functioning from there, to identify / designate a city as hub
 * office [ { city:DEL, zipCode:110001 }, [ User{id:2, name: User2 }, User{id:3,
 * name: User3 }, User{id:44, name: User44 } ], { city:BLR, zipCode:560001 }, [
 * * User{id:2, name: User2 }, User{id:3, name: User3 } * ], * ], { city: BLR,
 * zipCode: 560002 },[ * * * User{id:3, name: User3 } * * * ], * { city: BOM,
 * zipCode: 400018 },[ * * * User{id:2, name: User2 } * * * ], * * { city: BOM,
 * zipCode: 400037 },[ * * * * User{id:2, name: User2 } * * * * ]
 *
 *
 *
 */
