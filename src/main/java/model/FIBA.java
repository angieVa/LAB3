package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import generics.*;
import interfaces.*;

public class FIBA {
	
	private IRedBlackTree<Player> players;
	private IRedBlackTree<Player> statmentDouble;
//	private IAvlTree StatmentInt;
	
	
	public FIBA() {
		
	players = new RedBlackTree<Player>();
	statmentDouble = new RedBlackTree<Player>();
//	statmentInt = new AvlTree();
	addPlayerDefault();

		
	}
	
	
	public IRedBlackTree<Player> getPlayers() {
		return players;
	}


	public void setPlayers(IRedBlackTree<Player>  players) {
		this.players = players;
	}

	
	public void addPlayerDefault() {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("src/main/java/data/data.csv"));
			String line = br.readLine();
			line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String year = fields[0];
				String team = fields[1];
				String name = fields[2];
				int age = Integer.parseInt(fields[3]);
				int games = Integer.parseInt(fields[4]);
				int mp = Integer.parseInt(fields[5]);
				double per = Double.parseDouble(fields[6]);
				
				double ts = 0,ftr = 0;
				
				if(!fields[7].isEmpty()) {
					ts = Double.parseDouble(fields[7]);		
				}
				if(!fields[9].isEmpty()) {
					ftr = Double.parseDouble(fields[9]);	
				}

				Player player = new Player(year, team, name, age, games, mp, per, ts, ftr, 0);
				players.insertRB(player);
				line = br.readLine();
				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
	}
	
	public void addPlayer(int type) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/data.csv"));
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String year = fields[0];
				String team = fields[1];
				String name = fields[2];
				int age = Integer.parseInt(fields[3]);
				int games = Integer.parseInt(fields[4]);
				int mp = Integer.parseInt(fields[5]);
				double per = Double.parseDouble(fields[6]);
				double ts = Double.parseDouble(fields[7]);
				double ftr = Double.parseDouble(fields[9]);
				Player player = new Player(year, team, name, age, games, mp, per, ts, ftr, type);
				
				if(type == 3 || type == 4 || type == 5) {
					
					statmentDouble.insertRB(player);
					
				} else {
					
					//statmentInt.insert(player);
					
				}
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}
	
	
	public ArrayList<Player> getHighests(Player player) {
		
		try {
			
			players.getRoot().getNode(player);
			
			return players.getHighests(player);
			
			
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			
			players.insertRB(player);
			ArrayList<Player> list = players.getHighests(player);
			players.deleteRB(player);
			
			return list;	
			
		}
			
	}
	
	public ArrayList<Player> getLess(Player player) {
		
		try {
			
			players.getRoot().getNode(player);
			
			return players.getLess(player);
			
			
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			
			players.insertRB(player);
			ArrayList<Player> list = players.getLess(player);
			players.deleteRB(player);
			
			return list;	
			
		}
			
	}
	

}
