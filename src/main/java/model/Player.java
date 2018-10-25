package model;

import java.io.Serializable;
import java.util.Comparator;

public class Player implements Comparable<Player>, Serializable{
	
	private String year;
	private String name;
	private int age;
	private String team;
	private int games;
	private int mp;
	private double per;
	private double ts;
	private double ftr;
	private int type;
	
	public Player(String year, String team, String name, int age, int games, int mp, double per, double ts, double ftr, int type) {
		
		this.name = name;
		this.age = age;
		this.team = team;
		this.games = games;
		this.mp = mp;
		this.per = per;
		this.ts = ts;
		this.ftr = ftr;
		this.type = type;
		this.year = year;
		
	}
	
	

	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}

	public double getTs() {
		return ts;
	}

	public void setTs(double ts) {
		this.ts = ts;
	}

	public double getFtr() {
		return ftr;
	}

	public void setFtr(double ftr) {
		this.ftr = ftr;
	}

	public int compareTo(Player o) {
		int result = 0;
		
		if(o.getType() == 0) {
			
		return name.compareToIgnoreCase(o.getName());	
			
		} else if(o.getType() == 1) {
			
			if(this.games<o.getGames()) {
				
				result = -1;
				
			} else if(this.games>o.getGames()) {
				
				result = 1;
				
			} else {
				
				result = 0;
				
			}
			
		} else if (o.getType() == 2) {
			
			if(this.mp<o.getMp()) {
				
				result = -1;
				
			} else if(this.mp>o.getMp()) {
				
				result = 1;
				
			} else {
				
				result = 0;
				
			}
			
		} else if (o.getType() == 3) {
			
			if(this.per<o.getPer()) {
				
				result = -1;
				
			} else if(this.per>o.getPer()) {
				
				result = 1;
				
			} else {
				
				result = 0;
				
			}
			
		} else if (type == 4) {
			
			if(this.ts<o.getTs()) {
				
				result = -1;
				
			} else if(this.ts>o.getTs()) {
				
				result = 1;
				
			} else {
				
				result = 0;
				
			}
			
		} else if (type == 5) {
			
			if(this.ftr<o.getFtr()) {
				
				result = -1;
				
			} else if(this.ftr>o.getFtr()) {
				
				result = 1;
				
			} else {
				
				result = 0;
				
			}
			
		}
			
		return result;
	}


	public String toString() {
		return name;
	}

}
