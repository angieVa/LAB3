package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.FIBA;
import model.Player;

public class FIBATest extends TestCase{

	private FIBA fiba;
	private Player player1; 
	void stageOne() {
		
		fiba = new FIBA();
		player1 =  new Player("2000", "BlueBirds", "Cami", 23, 3, 4, 34, 21, 12, 1);
		
	}

	@Test
	
	public void testGgetLess() {
		 stageOne();
		 
		 
		
		
	}
	
	
	@Test 
	public void testGetSame() {
		 stageOne();
		
	}
	
	@Test
	public void testAddnewPlayer() {
		
		 stageOne();
		fiba.addNewPlayer(player1);
		 
		
		 
	}
}
