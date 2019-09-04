package com.model;

import java.io.Serializable;

public class Team implements Serializable{

	private int doco;
	private int lnid;	
	private String teams;
	private String city;

	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Team(int doco, int lnid, String teams, String city) {
		super();
		this.teams = teams.toUpperCase();
		this.city = city.toUpperCase();
		setDoco(doco);
		setLnid(lnid);
		setTeams(this.teams);
		setCity(this.city);
		}
	
	public Team(String teams, String city) {
		super();
		this.teams = teams.toUpperCase();
		this.city = city.toUpperCase();
		setTeams(this.teams);
		setCity(this.city);
		}


	public int getDoco() {
		return doco;
	}


	public void setDoco(int doco) {
		this.doco = doco;
	}


	public int getLnid() {
		return lnid;
	}




	public void setLnid(int lnid) {
		this.lnid = lnid;
	}




	public String getTeams() {
		return teams;
	}


	public void setTeams(String teams) {
		this.teams = teams;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Team [doco=" + doco + ", lnid=" + lnid + ", teams=" + teams + ", city=" + city + "]";
	}
}
