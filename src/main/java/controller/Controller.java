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
    	
    	options.getItems().add("Sorted by games");
    	options.getItems().add("Sorted by mp");
    	options.getItems().add("Sorted by per");
    	options.getItems().add("Sorted by ts");
    	options.getItems().add("Sorted by ftr");
    	options.getItems().add("Games less than");
    	options.getItems().add("Games greather than");
    	options.getItems().add("Games same as");
    	options.getItems().add("Mp less than");
    	options.getItems().add("Mp greather than");
    	options.getItems().add("Mp same as");
    	options.getItems().add("Per less than");
    	options.getItems().add("Per greather than");
    	options.getItems().add("Per same as");
    	options.getItems().add("Ts less than");
    	options.getItems().add("Ts greather than");
    	options.getItems().add("Ts same as");
    	options.getItems().add("Ftr less than");
    	options.getItems().add("Ftr greather than");
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
    	
    	Player p = fiba.getp().get(0);
    	list.getItems().add(p);
    	
    	for(int i=1; i<17263; i++) {
    		
    		Player p1 = fiba.getp().get(i);
    		Player p2 = fiba.getp().get(i-1);
    		
    		if(!p1.getName().equals(p2.getName())) {
    			
    			list.getItems().add(p1);
    			
    		}
    		
    	}
    	
    }	
    
        
    @FXML
    void find(ActionEvent event) {
    	
    	if(options.getValue().equals("Sorted by games")) {
    		
    		fiba.addPlayer(1);
    		list.getItems().clear();
    		initPlayers();
    		
    		
    	}

    }

    @FXML
    void butAddPlayer(ActionEvent event) {

    }

    @FXML
    void butDelete(ActionEvent event) {

    }

    @FXML
    void butModify(ActionEvent event) {

    }

	@Override
	public void initialize(URL Location, ResourceBundle resources) {
		
		read();
//		serialize(); //Colocarlo donde agregue un jugador y donde elimino 
		addOptions();
		initPlayers();
		
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
