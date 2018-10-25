package interfaces;

import java.util.ArrayList;

import generics.AVLNode;

public interface IAVLTree<A extends Comparable<A>> {
	
	public AVLNode<A> buscar(A elem, AVLNode<A> r);
	public int getFE(AVLNode<A> X);
	public AVLNode<A> leftRotate(AVLNode<A> x);
	public AVLNode<A> rightRotate(AVLNode<A> x);
	public AVLNode<A> doubleRightRotate(AVLNode<A> x);
	public AVLNode<A> doubleLeftRotate(AVLNode<A> x);
	public AVLNode<A> insertAVL(AVLNode<A> n, AVLNode<A> subT);
	public void insert(A elem);
	public ArrayList<A> inOrder();
	public void preOrder(AVLNode<A> r);
	public void postOrder(AVLNode<A> r);
	public AVLNode<A> getRoot();
	public void clean();
	public void delete(A elem);
	
}
