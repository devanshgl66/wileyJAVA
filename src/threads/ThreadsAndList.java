package threads;

import java.util.*;

class Project {
	int projId;
	String projName;

	Project(String name, int id) {
		projName = name;
		projId = id;
	}

	@Override
	public String toString() {
		return "Project ID: " + projId + " Name: " + projName + "\n";
	}
}

class User {
	String userName;
	int userId;
	List<Project> project;

	User(String name, int id, List<Project> project) {
		this.userId = id;
		this.userName = name;
		this.project = project;
	}

	@Override
	public String toString() {
		String str = "ID: " + userId + " Name: " + userName;
		for (int i = 0; i < project.size(); i++)
			str += project.get(i);
		str += "\n";
		return str;
	}
}

class CustomUser {
	String userName;
	int userId;
	int projectId;

	CustomUser(String name, int id, int projectId) {
		this.userId = id;
		this.userName = name;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ID: " + userId + " User Name: " + userName + " Project Id: " + projectId;
	}
}

public class ThreadsAndList {
	static int numProject = 10;
	static int numUser = 10;
	static List<User> li = new ArrayList<User>();
	static Map<CustomUser, Project> map = new TreeMap<CustomUser, Project>((p1, p2) -> {
		if (p1.userId == p2.userId)
			return p1.projectId - p2.projectId;
		else
			return p1.userId - p2.userId;
	});

	static class Creater extends Thread {
		@Override
		public void run() {
			Random rand = new Random();
			ArrayList<Project> proj = new ArrayList<Project>();
			for (int i = 0; i < numProject; i++)
				proj.add(new Project("Project" + (i + 1), i + 1));
			for (int i = 0; i < numUser; i++) {
				synchronized (li) {
					int projnum = rand.nextInt(7); // generate a random project number to associate
					int no = rand.nextInt(2) + 1; // no of project to a user
					List<Project> temp = new ArrayList<Project>();
					while (no > 0) {
						temp.add(proj.get(no + projnum));
						no--;
					}
					li.add(new User("User" + (i + 1), i + 1, temp));
					System.out.println("New User added: " + li.get(li.size() - 1));
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class Mapper extends Thread {
		static int cnt = 0;

		@Override
		public void run() {
			while (cnt < numUser) {
				synchronized (li) {
					if (li.size() > 0) {
						User u = li.remove(0);
//					System.out.println(u);
						u.project.forEach(p -> {
							CustomUser cu = new CustomUser(u.userName, u.userId, p.projId);
							map.put(cu, p);
						});
						cnt++;
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Creater a = new Creater();
		Mapper m = new Mapper();
		a.start();
		m.start();
		m.join();
		a.join();
//		System.out.println(li);
		System.out.println(map);
	}
}
