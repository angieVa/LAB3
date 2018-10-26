package generics;

import java.io.Serializable;
import java.util.ArrayList;

public class AVLNode <T extends Comparable> implements Serializable {

	
		
		private int fb;
		private ArrayList<T> repetidos;
		private AVLNode<T> hijoIzq;
		private AVLNode<T> hijoDer;
		private AVLNode<T> padre;
		private T objeto;
		
		public AVLNode(T o,AVLNode<T> p){
			objeto =o;
			padre=p;
			repetidos = new ArrayList<>();
			repetidos.add(objeto);
		}
		
		public AVLNode<T> insertarObjeto(T nuevo){
			if(objeto.compareTo(nuevo)>0){
				if(hijoIzq== null){
					hijoIzq=new AVLNode<>(nuevo, this);
					return hijoIzq;
				}else{
					return hijoIzq.insertarObjeto(nuevo);
				}
			}else if(objeto.compareTo(nuevo)==0){
				repetidos.add(nuevo);
				return this;
			}else{
				if(hijoDer==null){
					hijoDer=new AVLNode<>(nuevo,this );
					return hijoDer;
				}else{
					return hijoDer.insertarObjeto(nuevo);
				}
			}
		}
		public AVLNode<T> buscarElemento(T obj){
			if(this.objeto.compareTo(obj) == 0){
				return this;
			}else if(this.objeto.compareTo(obj)>0){
				if(hijoIzq == null){
					return null;
				}else{
					return hijoIzq.buscarElemento(obj);
				}
			}else if(this.objeto.compareTo(obj)<0){
				if(hijoDer==null){
					return null;
				}else{
					return hijoDer.buscarElemento(obj);
				}
			}
			return null;
		}
		
		public void leftRotate(TreeAVL a){
			AVLNode<T> y = hijoDer;
			hijoDer=y.hijoIzq;
			if(y.hijoIzq!= null)
				y.hijoIzq.padre= this;
			y.padre=this.padre;
			if(this.padre==null){
				a.modificarRaiz(y);
			}else{
				if(this == padre.hijoIzq){
					padre.hijoIzq= y;
				}else{
					padre.hijoDer= y;
				}
			}
			y.hijoIzq=this;
			this.padre= y;
		}
		public void rightRotate(TreeAVL a){
			AVLNode<T> y = hijoIzq;
			hijoIzq=y.hijoDer;
			if(y.hijoDer!= null)
				y.hijoDer.padre= this;
			y.padre=this.padre;
			if(this.padre==null){
				a.modificarRaiz(y);
			}else{
				if(this == padre.hijoDer){
					padre.hijoDer= y;
				}else{
					padre.hijoIzq= y;
				}
			}
			y.hijoDer=this;
			this.padre= y;
		}
		public void balancear(TreeAVL t){
			AVLNode<T> actual= this;
			fb= darFactorBalanceo();
			if(Math.abs(fb)>1){
				if(fb==2){
					if(hijoDer.darFactorBalanceo()>=0){
						leftRotate(t);
						actual=this.padre;
					}else{
						hijoDer.rightRotate(t);
						leftRotate(t);
						actual= this.padre;
					}
				}else{//Fb ==-2
					if(hijoIzq.darFactorBalanceo()<=0){
						rightRotate(t);
						actual=this.padre;
					}else{
						hijoIzq.leftRotate(t);
						rightRotate(t);
						actual= this.padre;
					}
				}
			}
			if(actual.padre!= null){
				padre.balancear(t);
			}
		}
		public int darFactorBalanceo(){
			int izq =0;
			int der=0;
			if(hijoIzq != null){
				izq=hijoIzq.darAlturaIncluyendoRaiz();
			}
			if(hijoDer!= null){
				der=hijoDer.darAlturaIncluyendoRaiz();
			}
			fb= der-izq;
			return der-izq;
		}
		public int darAlturaIncluyendoRaiz(){
			int izq=1;
			int der=1;
			if(hijoIzq!=null){
				izq+=hijoIzq.darAlturaIncluyendoRaiz();
			}
			if(hijoDer!=null){
				der+=hijoDer.darAlturaIncluyendoRaiz();
			}
			return Math.max(izq, der);
		}
		public AVLNode <T> sucesor (){
			AVLNode <T> act = null;
			if (hijoDer != null) {
				act = hijoDer;
				while (act.hijoIzq != null) {
					act = act.hijoIzq;
				}
			}
			return act;
		}
		public AVLNode<T> antecesor () {
			AVLNode <T> act = null;
			if (hijoIzq != null) {
				act = hijoIzq;
				while (act.hijoDer != null) {
					act = act.hijoDer;
				}
			}
			return act;
		}
		
		public AVLNode<T> darHijoIzq() {
			return hijoIzq;
		}
		public void modificarHijoIzq(AVLNode<T> hijoIzq) {
			this.hijoIzq = hijoIzq;
		}
		public AVLNode<T> darHijoDer() {
			return hijoDer;
		}
		public void modificarHijoDer(AVLNode<T> hijoDer) {
			this.hijoDer = hijoDer;
		}
		public AVLNode<T> darPadre() {
			return padre;
		}
		public void modificarPadre(AVLNode<T> padre) {
			this.padre = padre;
		}
		public T darObjeto() {
			return objeto;
		}
		public void modificarObjeto(T objeto) {
			this.objeto = objeto;
		}
		
		public ArrayList<T> darRepetidos(){
			return repetidos;
		}
		
		public void getInorder(ArrayList<T> inorder) {
			 
			 
			 if(hijoIzq != null) {
				 
				 hijoIzq.getInorder(inorder);
				 
			 }
			 
			 if(objeto != null) {
				 
				 inorder.add(objeto); 
				 
			 }
			
			 if(hijoDer != null) {
				 
				 hijoDer.getInorder(inorder);
				 
			 }
			 
		 }
		
	}
