package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import generics.ElementoNoExisteException;
import generics.RedBlackNode;
import junit.framework.TestCase;

class RedBlackNodeTest  extends TestCase{

	
	private RedBlackNode<String> redBlackNode;
	private String refers; 
	private RedBlackNode<String>  child;
	private String refer2;
	void stageOne(){
		
		refers = "test";
		redBlackNode = new RedBlackNode<String>(refers);
		refer2 = "case";
		child = new RedBlackNode<String>(refer2);
		redBlackNode.setRChild(child);
	}
	
	
	@Test
	public void tesGetUncle() {
		
		stageOne();
		RedBlackNode<String> m = redBlackNode.getUncle();
		
		assertEquals(m, null);
		
	}
	
	@Test
	public void tesGetweight() {
		
		stageOne();
		
		int tot =  redBlackNode.getWeight();
		
		assertTrue(tot == 1);
		
	}
	
	@Test
	public void tesGeHeight() {
		
		stageOne();
		
		int tot =  redBlackNode.getHeight();
		
		assertTrue(tot == 1);
		
	}
	
	@Test
	public void testisleaf() {
		
		stageOne();
		boolean yes = redBlackNode.isLeaf();
		
		assertTrue(false == yes);
	}
	
	@Test
	public void testGetNode() throws ElementoNoExisteException {
		stageOne();
		
		RedBlackNode<String> found =  redBlackNode.getNode(refers);
		
		assertEquals(found, redBlackNode );
			
	}
	
	@Test 
	public void testGetBrother() {
		
		stageOne();
		
		RedBlackNode<String> found =  redBlackNode.getBrother();
		
		assertEquals(found, null);
	}
	
	@Test 
	public void testSucesor() {
		
		stageOne();
		
		RedBlackNode<String> found =  redBlackNode.sucesor(redBlackNode);
		
		assertEquals(found, child);
	}
	
	
}
