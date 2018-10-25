package interfaces;

import java.util.ArrayList;

import generics.RedBlackNode;

public interface IRedBlackTree<A extends Comparable<A>> {
	
	public RedBlackNode<A> getRoot();
	public void insert_balance(RedBlackNode<A> z);
	public void leftRotate(RedBlackNode<A> x);
	public void rightRotate(RedBlackNode<A> x);
	public void insertRB(A elem);
	public void Limpiar();
	public void deleteSentinels(RedBlackNode<A> x);
	public void creatSentinel(RedBlackNode<A> x);
	public void deleteRB(A elem);
	public void fixedUp(RedBlackNode<A> x);
	public void inOrder();
	public void preOrder();
	public void postOrder(RedBlackNode<A> r);
	public ArrayList<A> getElements();
	public ArrayList<A> getHighests(A elem);
	public ArrayList<A> getLess(A elem);
	public ArrayList<A> getSame(A elem);
	public RedBlackNode<A> search(A elem, RedBlackNode<A> r);
	
	
	
	

}
