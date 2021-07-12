package threads;
import java.util.*;

import threads.FibonaciiAndThreads.Adder;
class Project{
	int projId;
	String projName;

	Project(String name, int id) {
		projName=name;
		projId=id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nProject ID: " + projId+ " Name: " + projName;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Integer(projId).hashCode();
	}
}

class User {
	String name;
	int id;
	List<Project> project;

	User(String name, int id, List<Project> project) {
		this.id = id;
		this.name = name;
		this.project = project;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="ID: " + id + " Name: " + name + "\n";
		for(int i=0;i<project.size();i++)
			str+=project.get(i);
		str+="\n";
		return str;
	}
}

public class ThreadsAndList {
	static int n=10;
	static List<User> li=new ArrayList<User>();
	static Map<Project,ArrayList<User>>map=new TreeMap<Project,ArrayList<User>>((p1,p2)->{
		
		return p2.projId-p1.projId;
	});
	static class Creater extends Thread{
		@Override
		public void run() {
			Random rand=new Random();
			ArrayList<Project>proj=new ArrayList<Project>();
			for(int i=0;i<n;i++)
				proj.add(new Project("Project"+(i+1),i+1));
			for(int i=0;i<5;i++) {
				int projnum=rand.nextInt(7);
				int no=rand.nextInt(2)+1;
				List<Project> temp=new ArrayList<Project>();
				while(no>0) {
					temp.add(proj.get(no+projnum));
					no--;
				}
				li.add(new User("User"+(i+1),i+1,temp));
			}
		}
	}
	static class Mapper extends Thread{
		static int cnt=0;
		@Override
		public void run() {
			while(cnt<5) {
				if(li.size()>0) {
					User u=li.get(0);
					System.out.println(u);
					li.remove(0);
					u.project.forEach(p->{
						ArrayList<User> u2=map.get(p);
						if(u2==null) {
							u2=new ArrayList<User>();
							map.put(p, u2);
						}
						u2.add(u);
					});
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Creater a=new Creater();
		Mapper m=new Mapper();
		a.start();
		m.start();
		m.join();
		a.join();
//		System.out.println(li);
		System.out.println(map);
	}
}
