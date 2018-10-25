package generics;

import java.io.Serializable;

import interfaces.IAVLTree;

public class AVLTree<A extends Comparable<A>> implements IAVLTree<A>, Serializable{

	private AVLNode<A> root;
	
	
	public AVLTree() {
		root = null;
	}


	@Override
	public AVLNode<A> buscar(A elem, AVLNode<A> r) {
		if(root== null) {
			return null;
		}else if(r.getElem() == elem) {
			return r;
		}else if(r.getElem().compareTo(elem) < 0) {
			return buscar(elem, r.getRChild());
			
		}else {
			return buscar(elem, r.getLChild());
		}
		
	}


	@Override
	public int getFE(AVLNode<A> X) {
		if(X == null){
			return -1;
		}else {
			return X.getFe();
		}
		
	}

	//Rotacion simple izquierda

	@Override
	public AVLNode<A> leftRotate(AVLNode<A> x) {
		
		AVLNode<A> aux = x.getLChild();
		x.setLChild(aux.getRChild());
		aux.setRChild(x);
		x.setFe(Math.max(getFE(x.getLChild()), getFE(x.getRChild()))+ 1);
		aux.setFe(Math.max(getFE(aux.getLChild()), getFE(aux.getRChild()))+ 1);
		return aux;
		
	}
	//Rotacion simple derecha

	@Override
	public AVLNode<A> rightRotate(AVLNode<A> x) {

		AVLNode<A> aux = x.getRChild();
		x.setRChild(aux.getLChild());
		aux.setLChild(x);
		x.setFe(Math.max(getFE(x.getLChild()), getFE(x.getRChild()))+ 1);
		aux.setFe(Math.max(getFE(aux.getLChild()), getFE(aux.getRChild()))+ 1);
		return aux;
	}

	//Rotacion doble a la derecha
	
	@Override
	public AVLNode<A> doubleRightRotate(AVLNode<A> x) {
		AVLNode<A> temp;
		x.setRChild(leftRotate(x.getRChild()));
		temp = rightRotate(x);
		return temp;
		
	}
	
	//Rotacion doble a la izquierda

	@Override
	public AVLNode<A> doubleLeftRotate(AVLNode<A> x) {
		
		AVLNode<A> temp;
		x.setLChild(rightRotate(x.getLChild()));
		temp = leftRotate(x);
		return temp;
	}


	@Override
	public AVLNode<A> insertAVL(AVLNode<A> n, AVLNode<A> subT) {
		
		AVLNode<A> nParent = subT;
		
		if(n.getElem().compareTo(subT.getElem()) <= 0) {
			
			if(subT.getLChild() == null) {
				subT.setLChild(n);
			}else {
				
				subT.setLChild(insertAVL(n,subT.getLChild()));
				if(getFE(subT.getLChild())- getFE(subT.getRChild()) == 2) {
					if(n.getElem().compareTo(subT.getLChild().getElem()) <= 0) {
						
						nParent = leftRotate(subT);
						
					}else {
						nParent = doubleLeftRotate(subT);
					}
				}
			}
		}else if(n.getElem().compareTo(subT.getElem()) > 0) {
			
			if(subT.getRChild() == null) {
				subT.setRChild(n);
			}else {
				
				subT.setRChild(insertAVL(n, subT.getRChild()));
				if(getFE(subT.getRChild())- getFE(subT.getLChild()) == 2) {
					if(n.getElem().compareTo(subT.getRChild().getElem()) > 0) {
						
						nParent = rightRotate(subT);
					}else {
						nParent = doubleRightRotate(subT);
					}
				}
				
			}
		}else {
			System.out.println("Duplicate Node");
		}
		
		//Actualizar la altura 
		
		if((subT.getLChild() == null) && (subT.getRChild() != null)) {
			subT.setFe(subT.getFe()+1);
		}else if((subT.getRChild() == null) && (subT.getLChild() != null)) {
			subT.setFe(subT.getLChild().getFe()+1);
			
		}else {
			
			subT.setFe(Math.max(getFE(subT.getLChild()), getFE(subT.getRChild()))+1);
			
		}
		return nParent;
	}

	//Metodo para insertar 
	
	@Override
	public void insert(A elem) {
		
		AVLNode<A> n = new AVLNode<A>(elem);
		
		if(root == null) {
			root = n;
		}else {
			root = insertAVL(n, root);
		}
		
	}
	
	
	

	//RECORRIDOS

	@Override
	public void inOrder(AVLNode<A> r) {
		
		if(r != null) {
			inOrder(r.getLChild());
			System.out.print(r.getElem() + ", ");
			inOrder(r.getRChild());
			
		}
		
	}


	@Override
	public void preOrder(AVLNode<A> r) {
		
		if(r != null) {
			
			System.out.print(r.getElem() + ", ");
			preOrder(r.getLChild());
			preOrder(r.getRChild());
			
		}
		
	}


	@Override
	public void postOrder(AVLNode<A> r) {
		
	if(r != null) {
			postOrder(r.getLChild());
			postOrder(r.getRChild());
			System.out.print(r.getElem() + ", ");
			
		}
		
		
	}


	@Override
	public AVLNode<A> getRoot() {
		return root;
	}


	/**
	 * @param root the root to set
	 */
	public void setRoot(AVLNode<A> root) {
		this.root = root;
	}


	@Override
	public void clean() {
		root = null;
		
	}
	
	//param = x.left
	public AVLNode<A> maxLeft(AVLNode<A> x){
		
		if(x.getRChild() != null) {
			return maxLeft(x.getRChild());
		}else {
			return x;
		}
	}
	

	//param = x.right
	public AVLNode<A> minRight(AVLNode<A> x){
		
		if(x.getLChild() != null) {
			return maxLeft(x.getLChild());
		}else {
			return x;
		}
		
	}
	
	public AVLNode<A> parent(AVLNode<A> child, AVLNode<A> x){
		
		if(x.getLChild() != null ) {
			
			if(child.getElem().compareTo(x.getLChild().getElem()) == 0 ) {
				return x;
			}
		}
		if(x.getRChild() != null) {
			
			if(child.getElem().compareTo(x.getRChild().getElem()) == 0 ) {
				return x;
			}
			
		}
		
		if(child.getElem().compareTo(x.getElem()) < 0 ) {
			
			return parent(child, x.getLChild());
			
		}else {
			return parent(child, x.getRChild());
		}
	}
	
	@Override
	public void delete(A elem) {
		
		AVLNode<A> nodeE= buscar(elem,root);
		
		int R = 0;
		if(nodeE.getRChild() != null) {
			R = nodeE.getRChild().getFe();
		}
		
		int L = 0;
		
		if(nodeE.getLChild() != null) {
			L = nodeE.getLChild().getFe();
			
		}
		
		if(L-R == 0) {
			buscar(elem,root).setElem(null);
		}else if(L-R >= 1) {
			
			AVLNode<A> maxL = maxLeft(nodeE.getLChild());
			if(nodeE.getLChild() != null) {
			parent(maxLeft(nodeE.getLChild()),root).setLChild(nodeE.getLChild());
			}
			if(nodeE.getLChild() != null) {
				parent(maxLeft(nodeE.getLChild()),root).getRChild().setLChild(nodeE.getRChild());
			}	
			buscar(elem,root).setElem(maxL.getElem());
			
			
			
		}else {
			

			AVLNode<A> minR = minRight(nodeE.getRChild());
			buscar(elem,root).setElem(minR.getElem());
			parent(minRight(nodeE.getRChild()),root).setRChild(null);
		
		}
		
//		if(getFE(nodeE) < 0) {
//			
//			AVLNode<A> maxL = maxLeft(nodeE.getLChild());
//			
//			nodeE.setElem(maxL.getElem());
//			
//			maxL = null;
//			
//			
//		}
		
		
	}
	
}
