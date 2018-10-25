package generics;

import java.io.Serializable;

public class AVLNode<A> implements Serializable{

	private A elem;
	private int fe;
	private AVLNode<A> LChild;
	private AVLNode<A> RChild;
	
	public AVLNode(A elem) {
		this.elem = elem;
		this.fe = 0;
		this.RChild = null;
		this.LChild = null;
	}

	/**
	 * @return the elem
	 */
	public A getElem() {
		return elem;
	}

	/**
	 * @param elem the elem to set
	 */
	public void setElem(A elem) {
		this.elem = elem;
	}

	/**
	 * @return the fe
	 */
	public int getFe() {
		return fe;
	}

	/**
	 * @param fe the fe to set
	 */
	public void setFe(int fe) {
		this.fe = fe;
	}

	/**
	 * @return the lChild
	 */
	public AVLNode<A> getLChild() {
		return LChild;
	}

	/**
	 * @param lChild the lChild to set
	 */
	public void setLChild(AVLNode<A> lChild) {
		LChild = lChild;
	}

	/**
	 * @return the rChild
	 */
	public AVLNode<A> getRChild() {
		return RChild;
	}

	/**
	 * @param rChild the rChild to set
	 */
	public void setRChild(AVLNode<A> rChild) {
		RChild = rChild;
	}
	
	
	
}
