/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigohuffman;

/**
 *
 * @author Sistema
 */
public class NodoArbol {
    public int frec;
    public String num;
    public NodoArbol sig;
    public NodoArbol izq,der;

    public NodoArbol(int frec,String num) {
        this.frec = frec;
        this.num=num;
        this.sig=null;
        this.izq=null;
        this.der=null;
     
    } 

    public NodoArbol() {
    }
    
}
