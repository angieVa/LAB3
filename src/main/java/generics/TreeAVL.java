package generics;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class TreeAVL <T extends Comparable> implements Serializable{
	

		private AVLNode<T> raiz;
		private ArrayList<T> obj = new ArrayList<T>();
		
		
		public void modificarRaiz(AVLNode<T> n){
			raiz= n;
		}
		public AVLNode<T> darRaiz(){
			return raiz;
		}
		
		public void insertar(T nuevo){
			if(raiz== null){
				raiz= new AVLNode<>(nuevo, null);
			}else{
				AVLNode<T> n= raiz.insertarObjeto(nuevo);
				n.balancear(this);
			}
		}
		
		private AVLNode<T> buscarNodo(T b) throws Exception{
			if(raiz== null){
				throw new Exception("Persona no encontrada");
			}else{
				return raiz.buscarElemento(b);
			}
		}
		public ArrayList<T> buscarElemento(T ob) throws Exception{
			AVLNode<T> encontrado= buscarNodo(ob);
			if(encontrado == null){
				return null;
			}else{
				return encontrado.darRepetidos();
			}
		}
		public void eliminarNodo(T objetoAct) throws Exception {
			AVLNode<T> z = buscarNodo(objetoAct);
			AVLNode <T> y;
			AVLNode<T> x=null;
			if (z == null) {
				throw new Exception(("No se encontro el objeto"));
			}
			if (z.darHijoIzq() == null || z.darHijoDer() == null) {
				y = z;
			} else {
				y = z.sucesor();
			}
			if (y.darHijoIzq() != null) {
				x = y.darHijoIzq();
			} else {
				x = y.darHijoDer();
			}
			if(x!=null)
				x.modificarPadre(y.darPadre());
			if (y.darPadre() == null) {
				raiz = x;
			} else {
				if (y == y.darPadre().darHijoIzq()) {
					y.darPadre().modificarHijoIzq(x);
				} else {
					y.darPadre().modificarHijoDer(x);
				}
			}
			if (y != z) {
				z.modificarObjeto(y.darObjeto());
			}
			z.balancear(this);
		}
		public AVLNode<T> getRaiz() {
			return raiz;
		}
		public void setRaiz(AVLNode<T> raiz) {
			this.raiz = raiz;
		}
		public ArrayList<T> getObj() {
			return obj;
		}
		public void setObj(ArrayList<T> obj) {
			this.obj = obj;
		}
		
		public void inOrder() {
			
			obj.clear();
			raiz.getInorder(obj);
			
		}
		
		
		
		
	}




