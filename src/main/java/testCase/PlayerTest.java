package testCase;



import org.junit.Test;

import junit.framework.TestCase;
import model.Player;


public class PlayerTest extends TestCase {

	
	private Player player1; 
	private Player player2;
	
	void stageOne() {
		
		player1 =  new Player("2000", "BlueBirds", "Cami", 23, 3, 4, 34, 21, 12, 1);
		player2 = new Player("2001", "RedBirdfs", "Sofy", 22, 10, 21, 12, 21, 12, 2);
		
		
	}

	
	@Test
	public void testCompareTo() {
		
		 stageOne();
		
		int resulta = player1.compareTo(player2);
		
		int resultado2 = player1.compareTo(player1);
		assertTrue(resulta ==resultado2 );
		
	}
	
	
}
