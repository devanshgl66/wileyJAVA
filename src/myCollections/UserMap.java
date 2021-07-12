package myCollections;
import java.util.*;

public class UserMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,Integer>map=new TreeMap<>((o1,o2)->o1-o2);
		map.put(4,5);
		map.put(1, 2);
		map.put(3, 4);
		map.forEach((k,v)->System.out.println(k+" "+v));
	}

}
