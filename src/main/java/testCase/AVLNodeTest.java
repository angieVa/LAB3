package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import generics.AVLNode;
import junit.framework.TestCase;

public class AVLNodeTest extends TestCase{

	private AVLNode<String> node;
	private String refers;
	
	
	void stageOne(){
		
		refers = " test";
		node = new AVLNode<String>(refers);
		
	}
	
	
	@Test
	public void testGetElem() {
		
		stageOne();
		
		
		String m =  node.getElem();
		
		assertEquals(m, refers);
		
	}
	@Test
	public void testgetFe() {
		stageOne();
		
		int m =  node.getFe();
		
		assertTrue(m == 0);

	}

	@Test
	public void testGetLChild() {
		stageOne();
		
		AVLNode<String>  m = node.getLChild();
		
		assertEquals(m, null);
	
		
	}
	@Test
	public void testGetRChild() {
		stageOne();
	
		AVLNode<String>  m = node.getRChild();
		
		assertEquals(m, null);
	}
	
	
}
