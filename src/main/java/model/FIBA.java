package model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import generics.*;
import interfaces.*;

public class FIBA implements Serializable{
	
	private IRedBlackTree<Player> players;
	private IRedBlackTree<Player> perT;
	private IRedBlackTree<Player> tsT;
	private IRedBlackTree<Player> ftrT;
	
	private TreeAVL<Player> gamesT;
	private TreeAVL<Player> mpT;
	
	
	public FIBA() {
		
	players = new RedBlackTree<Player>();
	perT = new RedBlackTree<Player>();
	tsT = new RedBlackTree<Player>();
	ftrT = new RedBlackTree<Player>();
	gamesT = new TreeAVL<Player>();
	mpT = new TreeAVL<Player>();
	
	
//	addPlayerDefault();

		
	}
	
	
	
	public IRedBlackTree<Player> getPerT() {
		return perT;
	}



	public void setPerT(IRedBlackTree<Player> perT) {
		this.perT = perT;
	}



	public IRedBlackTree<Player> getTsT() {
		return tsT;
	}



	public void setTsT(IRedBlackTree<Player> tsT) {
		this.tsT = tsT;
	}



	public IRedBlackTree<Player> getFtrT() {
		return ftrT;
	}



	public void setFtrT(IRedBlackTree<Player> ftrT) {
		this.ftrT = ftrT;
	}



	public TreeAVL<Player> getGamesT() {
		return gamesT;
	}



	public void setGamesT(TreeAVL<Player> gamesT) {
		this.gamesT = gamesT;
	}



	public TreeAVL<Player> getMpT() {
		return mpT;
	}



	public void setMpT(TreeAVL<Player> mpT) {
		this.mpT = mpT;
	}



	public IRedBlackTree<Player> getPlayers() {
		return players;
	}
	
	public ArrayList<Player> getPer(){
		return perT.getElements();
	}
	
	public ArrayList<Player> getTs(){
		return tsT.getElements();
	}
	
	public ArrayList<Player> getFtr(){
		return ftrT.getElements();
	}
	
	public ArrayList<Player> getp(){
		return players.getElements();
	}
	
	public ArrayList<Player> getGames(){
		return gamesT.getObj();
	}
	
	public ArrayList<Player> getMp(){
		return mpT.getObj();
	}


	public void setPlayers(IRedBlackTree<Player> players) {
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
				player = new Player(year, team, name, age, games, mp, per, ts, ftr, 1);
				gamesT.insertar(player);
				player = new Player(year, team, name, age, games, mp, per, ts, ftr, 2);
				mpT.insertar(player);
				player = new Player(year, team, name, age, games, mp, per, ts, ftr, 3);
				perT.insertRB(player);
				player = new Player(year, team, name, age, games, mp, per, ts, ftr, 4);
				tsT.insertRB(player);
				player = new Player(year, team, name, age, games, mp, per, ts, ftr, 5);
				ftrT.insertRB(player);
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
	
	public void addNewPlayer(Player p) {
		
		if(p.getType() == 0) {
			
			players.insertRB(p);
			
		} else if(p.getType() == 1) {
			
			
				gamesT.insertar(p);
			
			
			
		} else if(p.getType() == 2) {
			
				mpT.insertar(p);
			
			
		} else if(p.getType() == 3) {
			
			perT.insertRB(p);
			
		} else if(p.getType() == 4) {
			
			tsT.insertRB(p);
			
		} else if(p.getType() == 5) {
			
			ftrT.insertRB(p);
			
		}
		
	}
	
	
	public void getSame(Player player){
		
		
		if(player.getType() == 3) {
			
			try {
				perT.getRoot().getNode(player);
				perT.getSame(player);
				
			} catch (ElementoNoExisteException e) {
				
				perT.insertRB(player);
				perT.getSame(player);
				perT.deleteRB(player);
			
			}
			
		} else if(player.getType() == 4) {
			
			try {
				tsT.getRoot().getNode(player);
				tsT.getSame(player);
				
			} catch (ElementoNoExisteException e) {
				
				tsT.insertRB(player);
				tsT.getSame(player);
				tsT.deleteRB(player);
				
			}
			
		} else if(player.getType() == 5) {
			
			try {
				ftrT.getRoot().getNode(player);
				ftrT.getSame(player);
				
			} catch (ElementoNoExisteException e) {
				
				ftrT.insertRB(player);
				ftrT.getSame(player);
				ftrT.deleteRB(player);
				
			}
			
		}
		
		
	}
	
	public void getLess(Player player){

		if(player.getType() == 3) {
			
			try {
				perT.getRoot().getNode(player);
				perT.getLess(player);
				
			} catch (ElementoNoExisteException e) {
				
				perT.insertRB(player);
				perT.getLess(player);
				perT.deleteRB(player);
			
			}
			
		} else if(player.getType() == 4) {
			
			try {
				tsT.getRoot().getNode(player);
				tsT.getLess(player);
				
			} catch (ElementoNoExisteException e) {
				
				tsT.insertRB(player);
				tsT.getLess(player);
				tsT.deleteRB(player);
				
			}
			
		} else if(player.getType() == 5) {
			
			try {
				ftrT.getRoot().getNode(player);
				ftrT.getLess(player);
				
			} catch (ElementoNoExisteException e) {
				
				ftrT.insertRB(player);
				ftrT.getLess(player);
				ftrT.deleteRB(player);
				
			}
			
		}
		
			
	}



	public void delete(Player elem) {
		
		
		if(elem.getType() == 0) {
			
			players.deleteRB(elem);
			
		} else if(elem.getType() == 1) {
			
			
				try {
					gamesT.eliminarNodo(elem);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		} else if(elem.getType() == 2) {
			
			
				try {
					mpT.eliminarNodo(elem);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		} else if(elem.getType() == 3) {
			
			perT.deleteRB(elem);
			
		} else if(elem.getType() == 4) {
			
			tsT.deleteRB(elem);
			
		} else if(elem.getType() == 5) {
			
			ftrT.deleteRB(elem);
			
		}
		
		
	}



}	

