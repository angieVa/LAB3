package controller;

import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import generics.ElementoNoExisteException;

import generics.RedBlackNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable{

	FIBA fiba = new FIBA();
	
    @FXML
    private Label addTitle;

    @FXML
    private Tab mpTitle;

    @FXML
    private Label infoTitle;

    @FXML
    private TextField standardValue;

    @FXML
    private Label ageTitle;

    @FXML
    private Label perTitle;

    @FXML
    private Label ageTitle1;

    @FXML
    private Label nameToModifyTitle;

    @FXML
    private TextField yearModTx;

    @FXML
    private Label selectTite;

    @FXML
    private Label ageTxt;

    @FXML
    private Button addPlayer;

    @FXML
    private Label yearTitle1;

    @FXML
    private TextField yearTx;

    @FXML
    private Button butFind;

    @FXML
    private ChoiceBox<String> options;

    @FXML
    private Label teamTitle;

    @FXML
    private TextField ftrModTx;

    @FXML
    private Label gamesTitle;

    @FXML
    private TextField playerToDeleteTx;

    @FXML
    private ListView<Player> list;

    @FXML
    private Label ftrTitle;

    @FXML
    private Label mpTitle1;

    @FXML
    private TextField mpTx;

    @FXML
    private TextField playerToFindTx;

    @FXML
    private Button addModify;

    @FXML
    private TextField gamesModTx;

    @FXML
    private Label playerInfoTitle;

    @FXML
    private Label minutesPlayedT;

    @FXML
    private Label nameTitle1;

    @FXML
    private Label yearTxt;

    @FXML
    private Label minpTitle;

    @FXML
    private Label nameTxt;

    @FXML
    private Label ftrTxt;

    @FXML
    private Label valueTitle;

    @FXML
    private Button delete;

    @FXML
    private TextField teamModTx;

    @FXML
    private TextField nameTx;

    @FXML
    private TextField nameModTx;

    @FXML
    private TextField mpModTx;

    @FXML
    private TextField tsTx;

    @FXML
    private TextField perTx;

    @FXML
    private TextField ageModTx;

    @FXML
    private TextField ftrTx;

    @FXML
    private TextField perModTx;

    @FXML
    private Label yearTitle;

    @FXML
    private Label teamTitle1;

    @FXML
    private TextField ageTx;

    @FXML
    private Label teamTxt;

    @FXML
    private Label nameTitle;

    @FXML
    private TextField tsModTx;

    @FXML
    private Label tsTxt;

    @FXML
    private Label gamesTitle1;

    @FXML
    private TextField teamTx;

    @FXML
    private Label deleteTitle;

    @FXML
    private Label perTxt;

    @FXML
    private TextField gamesTx;

    @FXML
    private Label tsTitle1;

    @FXML
    private Label perTitle1;

    @FXML
    private Label gamesTxt;

    @FXML
    private Label ftrTitle1;

    @FXML
    private Label tsTitle;

    @FXML
    private Label resultsTitle;

    @FXML
    private Label mpTxt;

    @FXML
    private Label time;

    @FXML
    private Label addTitle1;

    @FXML
    private Label nameDeleteTitle;

    public void addOptions() {
    	
    	options.getItems().add("Sorted by name");
    	options.getItems().add("Sorted by games");
    	options.getItems().add("Sorted by mp");
    	options.getItems().add("Sorted by per");
    	options.getItems().add("Sorted by ts");
    	options.getItems().add("Sorted by ftr");
    	options.getItems().add("Games same as");
    	options.getItems().add("Mp same as");
    	options.getItems().add("Per same as");
    	options.getItems().add("Ts same as");
    	options.getItems().add("Ftr same as");
    		
    }
    
    @FXML
    void update(MouseEvent event) {
    	Player p = list.getSelectionModel().getSelectedItem();
    	nameTxt.setText(p.getName());
    	yearTxt.setText(p.getYear());
    	teamTxt.setText(p.getTeam());
    	ageTxt.setText(String.valueOf(p.getAge()));
    	gamesTxt.setText(String.valueOf(p.getGames()));
    	mpTxt.setText(String.valueOf(p.getMp()));
    	perTxt.setText(String.valueOf(p.getPer()));
    	tsTxt.setText(String.valueOf(p.getTs()));
    	ftrTxt.setText(String.valueOf(p.getFtr()));
    }
    
    public void initPlayers() {
    	
    	fiba.getPlayers().inOrder();

    	list.getItems().addAll(fiba.getp());
    	


    	System.out.println(fiba.getPlayers().getPeso());

    }	
    
        
    @FXML
    void find(ActionEvent event) {
    	
    	if(options.getValue().equals("Sorted by name")) {
    		
    		list.getItems().clear();
    		fiba.getGamesT().inOrder();
    	
        	list.getItems().addAll(fiba.getp());
  
    	
    		
    		
    	} else if(options.getValue().equals("Sorted by games")) {
    		
    		list.getItems().clear();
    		fiba.getGamesT().inOrder();
    		list.getItems().addAll(fiba.getGames());
    		
    		
    	} else if(options.getValue().equals("Sorted by mp")) {
    		
    		list.getItems().clear();
    		fiba.getMpT().inOrder();
    		list.getItems().addAll(fiba.getMp());
    		
    	} else if(options.getValue().equals("Sorted by per")) {
    		
    		list.getItems().clear();
    		fiba.getPerT().inOrder();
    		list.getItems().addAll(fiba.getPer());
    		
    	} else if(options.getValue().equals("Sorted by ts")) {
    		
    		list.getItems().clear();
    		fiba.getTsT().inOrder();
    		list.getItems().addAll(fiba.getTs());
    		
    	} else if(options.getValue().equals("Sorted by ftr")) {
    		
    		list.getItems().clear();
    		fiba.getFtrT().inOrder();
    		list.getItems().addAll(fiba.getFtr());
    		list.refresh();
    		
    	}  else if(options.getValue().equals("Per same as")) {
    		
    		list.getItems().clear();
    		double val = Double.parseDouble(standardValue.getText());
    		Player p = new Player("","","",0,0,0,val,0,0,3);
    		fiba.getSame(p);
    		list.getItems().addAll(fiba.getPer());
    		list.refresh();

    	} else if(options.getValue().equals("Ts same as")) {
    		

    		list.getItems().clear();
    		double val = Double.parseDouble(standardValue.getText());
    		Player p = new Player("","","",0,0,0,0,val,0,4);
    		fiba.getSame(p);
    		list.getItems().addAll(fiba.getTs());
    		list.refresh();

    	} else if(options.getValue().equals("Ftr same as")) {
    		
    		list.getItems().clear();
    		double val = Double.parseDouble(standardValue.getText());
    		Player p = new Player("","","",0,0,0,0,0,val,5);
    		fiba.getSame(p);
    		list.getItems().addAll(fiba.getFtr());
    		list.refresh();
    		
    	} else if(options.getValue().equals("Games same as")) {
    		
    		list.getItems().clear();
    		int val = Integer.parseInt(standardValue.getText());
    		Player p = new Player("","","",0,val,0,0,0,0,1);
    		fiba.getSame(p);
    		list.getItems().addAll(fiba.getFtr());
    		list.refresh();
    		
    	} else if(options.getValue().equals("Mp same as")) {
    		
    		list.getItems().clear();
    		int val = Integer.parseInt(standardValue.getText());
    		Player p = new Player("","","",0,0,val,0,0,0,2);
    		fiba.getSame(p);
    		list.getItems().addAll(fiba.getFtr());
    		list.refresh();
    	} 
    }

    @FXML
    void butAddPlayer(ActionEvent event) {
    	
    	String name = nameTx.getText();
    	String year = yearTx.getText();
    	String team = teamTx.getText();
    	int age = Integer.parseInt(ageTx.getText());
    	int games = Integer.parseInt(gamesTx.getText());
    	int mp = Integer.parseInt(mpTx.getText());
    	double per = Double.parseDouble(perTx.getText());
    	double ts = Double.parseDouble(tsTx.getText());
    	double ftr = Double.parseDouble(ftrTx.getText());
    	Player p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,0);
    	fiba.addNewPlayer(p1);
    	p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,1);
		fiba.addNewPlayer(p1);
		p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,2);
		fiba.addNewPlayer(p1);
		p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,3);
		fiba.addNewPlayer(p1);
		p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,4);
		fiba.addNewPlayer(p1);	  
		p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,5);
		fiba.addNewPlayer(p1);		

		list.getItems().clear();
		fiba.getPlayers().inOrder();
		list.getItems().addAll(fiba.getp());
    	serialize();	

    }
    
    @FXML
    void butDelete(ActionEvent event) {
    	
    	String name = playerToDeleteTx.getText();
    	Player pl = new Player("", "",name,0,0,0,0,0,0,0);
    	

    	RedBlackNode<Player> p;
		try {
			p = fiba.getPlayers().getRoot().getNode(pl);
			
	    	list.getItems().remove(p.getInfoNode());
    	
	    	Player p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),0);
	    	fiba.delete(p1);
	    	p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),1);
	    	fiba.delete(p1);
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),2);
			fiba.delete(p1);
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),3);
			fiba.delete(p1);
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),4);
			fiba.delete(p1);	  
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),5);
			fiba.delete(p1);	
			
//			list.getItems().clear();
//			fiba.getGamesT().inOrder();
//	    	list.getItems().addAll(fiba.getGames());
//	    	

			list.getItems().clear();
			fiba.getPlayers().inOrder();
			list.getItems().addAll(fiba.getp());
	    	
	   
	    	System.out.println(fiba.getPlayers().getPeso());
			
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }

    @FXML
    void butModify(ActionEvent event) {
    	
    	String n = playerToFindTx.getText();
    	Player pl = new Player("", "",n,0,0,0,0,0,0,0);
    	

    	RedBlackNode<Player> p;
    	
    	try {
			p = fiba.getPlayers().getRoot().getNode(pl);
	    	list.getItems().remove(p.getInfoNode());
    	
	    	list.getItems().clear();
			fiba.getPlayers().inOrder();
			list.getItems().addAll(fiba.getp());
			
			String name = nameModTx.getText();
			String year = yearModTx.getText();
			String team = teamModTx.getText();
			int age = Integer.parseInt(ageModTx.getText());
			int games = Integer.parseInt(gamesModTx.getText());
			int mp = Integer.parseInt(mpModTx.getText());
			double per = Double.parseDouble(perModTx.getText());
			double ts = Double.parseDouble(tsModTx.getText());
			double ftr = Double.parseDouble(ftrModTx.getText());
			
	    	Player p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),0);
	    	fiba.delete(p1);
	    	p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,0);
	    	fiba.addNewPlayer(p1);
	    	
	    	p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),1);
	    	fiba.delete(p1);
	    	p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,1);
	    	fiba.addNewPlayer(p1);
	    	
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),2);
			fiba.delete(p1);
			p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,2);
	    	fiba.addNewPlayer(p1);
	    	
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),3);
			fiba.delete(p1);
			p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,3);
	    	fiba.addNewPlayer(p1);
	    	
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),4);
			fiba.delete(p1);
			p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,4);
	    	fiba.addNewPlayer(p1);
	    	
			p1 = new Player(p.getInfoNode().getYear(),p.getInfoNode().getTeam(),p.getInfoNode().getName(),p.getInfoNode().getAge(),p.getInfoNode().getGames(),p.getInfoNode().getMp(),p.getInfoNode().getPer(),p.getInfoNode().getTs(),p.getInfoNode().getFtr(),5);
			fiba.delete(p1);
			p1 = new Player(year,team,name,age,games,mp,per,ts,ftr,5);
	    	fiba.addNewPlayer(p1);
	    	
	    	list.getItems().clear();
			fiba.getPlayers().inOrder();
			list.getItems().addAll(fiba.getp());	
			
	    	
			
    	} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }

	@Override
	public void initialize(URL Location, ResourceBundle resources) {
		
		read();
//		serialize(); //Colocarlo donde agregue un jugador y donde elimino 
		addOptions();
		initPlayers();
		list.refresh();
		
	}
	
	public void read() {
		
		FileInputStream fos = null;
		ObjectInputStream ois = null;
		
		try {
			fos = new FileInputStream("data/class.dat");
			ois = new ObjectInputStream(fos);
			try {
				fiba = (FIBA) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}	
		
		
	
	
	public void serialize() {
		
		FileOutputStream fos = null;
		ObjectOutputStream ois = null;
		
		try {
			fos = new FileOutputStream("data/class.dat",true);
			ois = new ObjectOutputStream(fos);
			ois.writeObject(fiba);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
