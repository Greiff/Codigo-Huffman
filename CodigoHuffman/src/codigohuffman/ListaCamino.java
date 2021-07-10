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
public class ListaCamino {
    NodoCamino primero;
    NodoCamino frente;
    int cuenta;
    
    public void agregarFrente(String a,String b){
        NodoCamino temp = new NodoCamino(a,b);
        if (frente==null){
            primero=frente=temp;
        }
        else{
            frente.sig=temp;
            frente=temp;
        }
        cuenta++;
    }
    
    public void agregarCima(String a,String b){
        NodoCamino temp = new NodoCamino(a,b);
        if(frente==null) primero = temp;
        else{
        temp.sig = primero;
        primero=temp;
        }
        cuenta++;
    }
    public void imprimir(){
        NodoCamino actual = primero;
        while(actual!= null){
            System.out.println(actual.num+ " : "+actual.cod);
            actual= actual.sig;
        }
    }
    
    public String buscarNum(String a){
        NodoCamino actual = primero;
        while(actual!= null){
            if(a.equalsIgnoreCase(actual.num)) break;
            actual= actual.sig;
        }
        return actual.cod;
    }
    
    public boolean vacio(){
        if (primero == null) return true;        
        return false;
    }
    
    public boolean existeElem(String a){
        boolean existe= false;
        NodoCamino actual = primero;
        while(actual!= null){
            if(a.equalsIgnoreCase(actual.num)) existe=true;
            actual= actual.sig;
        }     
        return existe;
    }
   
    
    
}

