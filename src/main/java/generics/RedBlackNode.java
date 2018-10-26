package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RedBlackNode<A extends Comparable<A>> implements Serializable{

	
	public static final int BLACK = 1;
	public static final int RED = 0;
	
	
	 private RedBlackNode<A> RChild;
	 private RedBlackNode<A> LChild;
	 private A elem;
	 private int color;
	 private RedBlackNode<A> parent;
	 protected boolean FLAG;
	 
	 public RedBlackNode(A elem) {
		 this.elem = elem;
		 color = RED;
		 setRChild(new RedBlackNode<A>());
		 setLChild(new RedBlackNode<A>());
		 parent = null;
		 FLAG = false;
		 
	 }
	 
	 private RedBlackNode() {
		 this.elem = null;
		 color = BLACK;
		 parent = null;
	 }
	 
	 public  RedBlackNode(RedBlackNode<A> node) {
		 this.elem = null;
		 RChild = null;
		 LChild = null;
		 parent = node;
		 color = BLACK;
		 FLAG = true;
		 
	 }
	 
	 
	 public RedBlackNode<A> getParent(){
		 return parent;
	 }
	 
	 public RedBlackNode<A> getUncle(){	
		 
		 if(parent == null || parent.parent == null) {
			 return null;
		 }else {
			 if(parent.parent.isRChild(parent))
				 return parent.parent.LChild.LChild;
			 else
				 return parent.parent.RChild;
		 }
		 
	 }
	 
	 public int getColor() {
		 return color;
	 }
	 
	 public RedBlackNode<A> getRChild(){
		 return RChild;
	 }
	 
	 public RedBlackNode<A> getLChild(){
		 return LChild;
	 }
	 
	 public boolean RChildLeaf() {
		 return RChild.elem == null;
	 }

	 
	 public boolean LChildLeaf() {
		 return LChild.elem == null;
	 }
	 
	 public RedBlackNode<A> getHigher(){
		 return RChildLeaf() ? this : RChild.getHigher();
	 }
	 
	 public RedBlackNode<A> getSmaller(){
		 return LChildLeaf() ? this : LChild.getSmaller();
	 }
	 
	 public void getPreorden(ArrayList<A> preorden) {
		 
		 preorden.add(elem);
		 if(!LChildLeaf())
			 LChild.getPreorden(preorden);
		 if(!RChildLeaf())
			 RChild.getPreorden(preorden);
	 }
	 
	 public void getInorder(ArrayList<A> inorder) {
		 
		 
		 if(!LChildLeaf()) {
			 
			 LChild.getInorder(inorder);
			 
		 }
		 
		 if(elem != null) {
			 
			 inorder.add(elem); 
			 
		 }
		
		 if(!RChildLeaf()) {
			 
			 RChild.getInorder(inorder);
			 
		 }
		 
	 }
	 
	 
	 public boolean isLeaf() {
		 return elem == null;
	 }
	 
	 public int getWeight() {
		 return isLeaf() ? 0 : 1 + RChild.getWeight() + LChild.getWeight();
	 }
	 
	 public void getLeafs(List<RedBlackNode<A>> leafs) {
		 
		 if(isLeaf())
			 leafs.add(this);
		 else {
			 if(!RChildLeaf())
				 RChild.getLeafs(leafs);
			 if(!LChildLeaf())
				 LChild.getLeafs(leafs);
		 }
	 }
	 
	 public int getHeight() {
		 
		 if(isLeaf())
			 return 0;
		 int h1 = LChild.getHeight();
		 int h2 = RChild.getHeight();
		 return (h1 >= h2) ? h1 +1 : h2 +1;
	 }

	 
	 

	 
	 public void setRChild(RedBlackNode<A> child) {
		 if(child != null) 
			 child.setParent(this);
		RChild = child;
		 
		 
	 }
	 
	 public void setLChild(RedBlackNode<A> child) {
		 
		 if(child != null) 
			 child.setParent(this);
		 LChild = child;
	 }

	public void setParent(RedBlackNode<A> parent) {
	
		this.parent = parent;	
	}
	
	public boolean isRChild(RedBlackNode<A> node) {
		
		return RChild == node;
	}
	
	 public boolean isLChild(RedBlackNode<A> node) {
		 return LChild == node;
	 }
	 
	 public RedBlackNode<A> getNode(A elem) throws ElementoNoExisteException{
		 
		 int comp = elem.compareTo(this.elem);
		 if(comp == 0)
			 return this;
		 else if(comp < 0) {
			 if(!LChildLeaf())
				 return LChild.getNode(elem);
			 else
				 throw new ElementoNoExisteException("El element buscado no existe");
		 }else {
			 if(!RChildLeaf())
				 return RChild.getNode(elem);
			 else
				 throw new ElementoNoExisteException("El element buscado no existe");
		 }
	 }
	 
	 public A getInfoNode() {
		 return elem;
	 }
	 
	 
	 public boolean exist(A a) {
		 
		try {
			getNode(a);
			return true;
		} catch (ElementoNoExisteException e) {
			// TODO Auto-generated catch block
			return false;
		}
	
	 }
	 
	 public boolean RChildBlack() {
		 return RChild.color == BLACK;
	 }
	 
	 public boolean LChildBlack() {
		 return LChild.color == BLACK;
	 }
	 
	 public boolean BlackChilds() {
		 return RChildBlack() && LChildBlack();
	 }
	 
	 public RedBlackNode<A> getBrother(){
		 if(parent == null)
			 return null;
		 else
			 return parent.isRChild(this) ? parent.LChild : parent.RChild;
	 }
	 
	 
	 public void setColor(int color) {
		 this.color = color;
	 }
	 
	 public boolean isDBlack() {
		 return color == BLACK;
	 }
	 
	 public void setElement(RedBlackNode<A> node) {
		 
		 if(node.elem != null) {
			 
			 A aux = elem;
			 elem = node.elem;
			 node.elem = aux;
		 }else {
			 elem = null;
			 color = BLACK;
			 RChild = null;
			 LChild = null;
		 }
		 
	 }
	 
	 public RedBlackNode<A> sucesor(RedBlackNode<A> x){
		 if(!x.RChild.FLAG)
			 return x.RChild.getSmaller();
		 	RedBlackNode<A> y = x.parent;
		 while(y != null && x == y.RChild) {
			 x = y;
			 y = y.parent;
			
		 }
		 return y;
	 }
	 
	 
		public ArrayList<A> highests(ArrayList<A> list, RedBlackNode<A> x){
			
			if(x.RChild != null) {
				
				list.add(x.RChild.elem);
				highests(list, x.RChild);
			}
			
			if(x.LChild != null) {
				
				list.add(x.LChild.elem);
				highests(list, x.LChild);
			}
			
			
				return list;

			
		} 
		
		public ArrayList<A> less(ArrayList<A> list, RedBlackNode<A> x){
			
			if(x != null) {
				
			
			if(x.LChild != null) {
				
				less(list,x.LChild);
					
			 }
			 
			 if(elem != null && elem.compareTo(x.getInfoNode()) < 0){
				 
				 list.add(elem); 
				 
			 }
			
			 if(x.RChild != null) {
				 
				
				 
				 less(list,x.RChild);
				 
			 }
			 
			}
					
			return list;
			
		}

		

}
