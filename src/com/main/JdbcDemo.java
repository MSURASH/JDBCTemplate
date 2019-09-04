package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.JdbcDaoImpl;
import com.model.Team;

public class JdbcDemo {
	static {
		System.out.println("This is JDBCTemplate with Spring");
	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		//Team team = dao.getTeam(1, 1000);
//			int i = 1;
//			List<Team> list = dao.getTeamList();
		List<Team> list = dao.getTeamId(6,8);

//			for(Team t : list) {
//				System.out.println(i++ +" "+t.getDoco()+" "+t.getLnid()+" "+t.getTeams()+" "+t.getCity());
//			}
			print(list);
		//Team team = new JdbcDaoImpl().getTeam(6, 10000);
		//System.out.println(team.getTeams()+" "+team.getCity());
		//Delete
//		String num = dao.deleteTeam(1583652561, 1000);
//		System.out.println(num);
		
		//Update
//		String num = dao.updateTeam("SHELLY",1443244045, 1000);
//		System.out.println(num);
		
		//Insert 
		//Team team = new Team(10,2000,"Colts", "Indianapolis");
		
		
		
//		String num = dao.createTeam(team);
//		System.out.println(num);
	
	}
	
	public static void print(List<Team> team) {
		int i = 1;

		for(Team t : team) {
			//System.out.println(i++ +" "+t.getDoco()+" "+t.getLnid()+" "+t.getTeams()+" "+t.getCity());
			System.out.println(i++ +" "+t.getTeams()+" "+t.getCity());

		}
		
	}

}
