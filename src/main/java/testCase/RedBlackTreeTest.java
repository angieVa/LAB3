package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import generics.RedBlackTree;
import junit.framework.TestCase;

class RedBlackTreeTest extends TestCase {

	private RedBlackTree<String> redblackTree;
	private String refers;
	void stageOne(){
		
	redblackTree = new RedBlackTree<>();
	refers = "test";
		
	}
	
	
	@Test
	
	public void testInsert() {
		
		redblackTree.insertRB(refers);
		
		assertEquals(redblackTree.getRoot(), refers);
	}
	
	@Test
	public void testsDelete() {
		
		redblackTree.insertRB(refers);
		redblackTree.deleteRB(refers);
		
		assertEquals(redblackTree.getRoot(), null);
	}
	
	
}
