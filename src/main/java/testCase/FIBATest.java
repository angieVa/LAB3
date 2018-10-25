package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import generics.RedBlackNode;
import junit.framework.TestCase;
import model.FIBA;
import model.Player;

public class FIBATest extends TestCase{

	private FIBA fiba;
	private Player player1; 
	void stageOne() {
		
		fiba = new FIBA();
		player1 =  new Player("2000", "BlueBirds", "Cami", 23, 3, 4, 34, 21, 12, 3);
		
	}

	@Test
	public void testAddnewPlayer() {
		
		 stageOne();
		fiba.addNewPlayer(player1);
		
		RedBlackNode<Player> pla=  fiba.getTsT().getRoot();
	
		assertEquals( fiba.getTsT().getRoot(), pla);
		
		 
	}
	
	@Test
	public void testdelete() {
		
		stageOne();
		
		fiba.addNewPlayer(player1);
		fiba.delete(player1);
		
		assertEquals( fiba.getTsT().getRoot(), null);
		
	}
}
