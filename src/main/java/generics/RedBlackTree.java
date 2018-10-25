package generics;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.IRedBlackTree;

public class RedBlackTree<A extends Comparable<A>> implements IRedBlackTree<A>, Serializable {
	
	public static final int BLACK = 1;
	public static final int RED = 0;
	
	private RedBlackNode<A> root;
	
	private RedBlackNode<A> nodex = null;
	private RedBlackNode<A> nodey = null;
	private RedBlackNode<A> nodez = null;
	private RedBlackNode<A> nodew = null;
	private ArrayList<A> elements;
	
	
	
	public RedBlackTree() {
		elements = new ArrayList<A>();
		root = null;
	}
	
	public RedBlackNode<A> getRoot(){
		return root;
	}


	private RedBlackNode<A> deleteRB(RedBlackNode<A> z){
		
		nodez = z;
		RedBlackNode<A> y = null;
		RedBlackNode<A> x = null;
		
		if(z.getLChild().FLAG || z.getRChild().FLAG) {
			
			y = z;
		}else {
			
			y = z.sucesor(z);
		}
		nodey = y;
		
		if(!y.getLChild().FLAG) {
			
			x = y.getLChild();
		}else {
			x = y.getRChild();
		}
		
		nodex = x;
		x.setParent(y.getParent());
		
		if(y.getParent() == null) {
			root = x;
		}else {
			
			if(y == y.getParent().getLChild()) {
				y.getParent().setLChild(x);
			}else {
				y.getParent().setRChild(x);
			}
		}
		
		nodex= x;
		
		if(y != z) {
			
			z.setElement(y);
		}
		if(y.getColor() == BLACK) {
			
			fixedUp(x);
		}
		
		nodex = null;
		nodey = null;
		nodez = null;
		nodew = null;
		return y;
	}


	public void insert_balance(RedBlackNode<A> z) {
		RedBlackNode<A> y = null;
		RedBlackNode<A> x = root;
		while(x != null) {
			y = x;
			if(z.getInfoNode().compareTo(x.getInfoNode()) < 0)
				x = x.getLChild();
			else
				x = x.getRChild();
		}
		
		z.setParent(y);
		if(y == null)
			root = z;
		else
			if(z.getInfoNode().compareTo(y.getInfoNode()) < 0)
				y.setLChild(z);
			else
				y.setRChild(z);
		z.setLChild(null);
		z.setRChild(null);
		z.setColor(RED);
		
	}


	public void leftRotate(RedBlackNode<A> x) {
		
		RedBlackNode<A> y = x.getRChild();
		x.setRChild(y.getLChild());
		if(y.getLChild() != null) 
			y.getLChild().setParent(x);
			y.setParent(x.getParent());
		if(x.getParent() == null)
			root = y;
		else
			if(x == x.getParent().getLChild())
				x.getParent().setLChild(y);
			else
				x.getParent().setRChild(y);
		
		y.setLChild(x);
		x.setParent(y);
		
	}

	public void rightRotate(RedBlackNode<A> x) {
		
		RedBlackNode<A> y = x.getLChild();
		x.setLChild(y.getRChild());
		if(y.getRChild() != null)
			y.getRChild().setParent(x);
			y.setParent(x.getParent());
		if(x.getParent() == null)
			root = y;
		else
			if(x == x.getParent().getRChild())
				x.getParent().setRChild(y);
			else
				x.getParent().setLChild(y);
		y.setRChild(x);
		x.setParent(y);
		
	}

	public void insertRB(A elem) {
		
		deleteSentinels(root);
		
		RedBlackNode<A> x = new RedBlackNode<A>(elem);
		insert_balance(x);
		while(x != root && x.getParent().getColor() == RED) {
			
			boolean nodeYRed = false;
			if(x.getParent() == x.getParent().getParent().getLChild()) {
				
				RedBlackNode<A> y = x.getParent().getParent().getRChild();
				if(y != null) {
					if(y.getColor() == RED) {
						//caso1
						x.getParent().setColor(BLACK);
						y.setColor(BLACK);
						x.getParent().getParent().setColor(RED);
						x = x.getParent().getParent();
						nodeYRed = true;
					}
				}
				
				if( !nodeYRed) {
					
					if( x == x.getParent().getRChild()) {
						
						//caso2
						x = x.getParent();
						leftRotate(x);
					}
					
					//caso 3
					x.getParent().setColor(BLACK);
					x.getParent().getParent().setColor(RED);
					rightRotate(x.getParent().getParent());
				}
			}
			
			else {
				if(x.getParent() == x.getParent().getParent().getRChild()) {
					
					RedBlackNode<A> y = x.getParent().getParent().getLChild();
					if(y != null) {
						
						if(y.getColor() == RED) {
							//caso1
							x.getParent().setColor(BLACK);
							y.setColor(BLACK);
							x .getParent().getParent().setColor(RED);
							x = x.getParent().getParent();
							nodeYRed = true;
						}
					}
					
					if(!nodeYRed) {
						
						//caso2
						if( x == x.getParent().getLChild()) {
							x = x.getParent();
							rightRotate(x);
						}
						
						//caso 3
						x.getParent().setColor(BLACK);
						x.getParent().getParent().setColor(RED);
						leftRotate(x.getParent().getParent());
					}
				}
			}
			
		}
		
		root.setColor(BLACK);
		creatSentinel(root);
		
	}

	
	public void Limpiar() {
		root = null;
	}

	
	public void deleteSentinels(RedBlackNode<A> x) {

		if(x == null)
			return;
		if(x.FLAG) {
			if(x.getParent().getLChild().FLAG)
				x.getParent().setLChild(null);
				if(x.getParent().getRChild().FLAG)
					x.getParent().setRChild(null);
				
		}else {
			deleteSentinels(x.getLChild());
			deleteSentinels(x.getRChild());
		}
		
	}

	
	public void creatSentinel(RedBlackNode<A> x) {

		if(x.getLChild() == null) {
			RedBlackNode<A> sentinel = new RedBlackNode<A>(x);
			x.setLChild(sentinel);
		}else {
			
			creatSentinel(x.getLChild());
		}
		if(x.getRChild() == null) {
			RedBlackNode<A> sentinel = new RedBlackNode<A>(x);
			x.setRChild(sentinel);
		}else {
			creatSentinel(x.getRChild());
		}
	}

	
	public void deleteRB(A elem) {
		
		try {
			RedBlackNode<A> z = root.getNode(elem);

			RedBlackNode<A> p = deleteRB(z);
			p = null;
			
			if(root.FLAG) {
				root.setParent(null);
				root = null;
			}
			
			deleteSentinels(root);
			creatSentinel(root);
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void fixedUp(RedBlackNode<A> x) {

		nodez = nodey = null;
		
		while(x != root && x.getColor() == BLACK) {
			
			nodex = x;
			if(x == x.getParent().getLChild()) {
				
				RedBlackNode<A> w = x.getParent().getRChild();
				nodew = w;
				//caso 1
				if(w.getColor() == RED) {
					w.setColor(BLACK);
					x.getParent().setColor(RED);
					leftRotate(x.getParent());
					w = x.getParent().getRChild();
				}
				
				//caso2
				if(w.BlackChilds()) {
					
					w.setColor(RED);
					x = x.getParent();
				}else {
					
					//caso3
					if(w.RChildBlack()) {
						
						w.getLChild().setColor(BLACK);
						w.setColor(RED);
						rightRotate(w);
						w = x.getParent().getRChild();
						nodew = w;
						
					}
					
					//caso4
					
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(BLACK);
					w.getRChild().setColor(BLACK);
					leftRotate(x.getParent());
					x = root;
					nodex = x;
					
				}
			}
			else {
				
				if(x == x.getParent().getRChild()) {
					
					RedBlackNode<A> w = x.getParent().getLChild();
					nodew = w;
					//caso1
					if(w.getColor() == RED) {
						
						w.setColor(BLACK);
						x.getParent().setColor(RED);
						rightRotate(x.getParent());
						w = x.getParent().getLChild();
					}
					//caso2
					
					if(w.BlackChilds()) {
						w.setColor(RED);
						x = x.getParent();
					}else {
						//caso3
						
						if(w.LChildBlack()) {
							w.getRChild().setColor(BLACK);
							w.setColor(RED);
							leftRotate(w);
							w = x.getParent().getLChild();
							nodew = w;
						}
						
						//caso4
						
						w.setColor(x.getParent().getColor());
						x.getParent().setColor(BLACK);
						w.getLChild().setColor(BLACK);
						rightRotate(x.getParent());
						x = root;
						nodex = x;
					}
					
				}
			}
		}
		
		x.setColor(BLACK);
		nodex = x;
		
		
		
	}
	
	public void inOrder() {
	
		root.getInorder(elements);
		
	}


	public void preOrder() {
		
		root.getPreorden(elements);
		
	}

	public ArrayList<A> getElements() {
		return elements;
	}

	public void setElements(ArrayList<A> elements) {
		this.elements = elements;
	}

	public void postOrder(RedBlackNode<A> r) {
		
	if(r != null) {
			postOrder(r.getLChild());
			postOrder(r.getRChild());
			System.out.print(r.getInfoNode() + ", ");
			
		}
		
		
	}
	
	@Override
	public RedBlackNode<A> search(A elem, RedBlackNode<A> r) {
		if(root== null) {
			return null;
		}
		
		if(r != null) {
			
			if(r.getInfoNode() == elem) {
				return r;
			}else if(r.getInfoNode().compareTo(elem) < 0) {
				return search(elem, r.getRChild());
			
			}else {
				return search(elem, r.getLChild());
			}
		}else {
			return null;
		}
	
		
	}
	
	@Override
	public ArrayList<A> getHighests(A elem){
		
		elements.clear();
		
		RedBlackNode<A> x = search(elem,root);
		
		return root.highests(elements, x);
		
	}
	
	@Override
	public ArrayList<A> getLess(A elem){
		
		elements.clear();
		
		RedBlackNode<A> x = search(elem,root);
		
		return root.less(elements, x);
		
	}
	
	
	public void AuxSame(RedBlackNode<A> x, A elem){
		
		if(x !=null) {
		
		if(!x.LChildLeaf()) {
			
			if(x.getLChild().getInfoNode() == elem ) {
				elements.add(x.getLChild().getInfoNode());
				AuxSame(x.getLChild(),elem);
				
			}
		}
		
		if(x.getInfoNode() == elem) {
			elements.add(x.getInfoNode());
		}
		
		 
		if(!x.RChildLeaf()) {

			if(x.getRChild().getInfoNode() == elem ) {
				elements.add(x.getRChild().getInfoNode());
				AuxSame(x.getRChild(),elem);
			}
			
		}
	}
	}
	
	@Override
	public ArrayList<A> getSame(A elem){
		
		elements.clear();
		AuxSame(root, elem);
		return elements;
	}
 

	

}
