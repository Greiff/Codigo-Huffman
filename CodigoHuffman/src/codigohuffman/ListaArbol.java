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
public class ListaArbol {
    NodoArbol primero;
    NodoArbol frente;
    int cuenta;
    
    public void agregarFrente(int a,String b){
        NodoArbol temp = new NodoArbol(a,b);
        if (frente==null){
            primero=frente=temp;
        }
        else{
            frente.sig=temp;
            frente=temp;
        }
        cuenta++;
    }
    
    public void agregarCima(int a,String b){
        NodoArbol temp = new NodoArbol(a,b);
        if(frente==null) primero = temp;
        else{
        temp.sig = primero;
        primero=temp;
        }
        cuenta++;
    }
    public void imprimir(){
        NodoArbol actual = primero;
        while(actual!= null){
            System.out.println(actual.frec+ " : "+actual.num);
            actual= actual.sig;
        }
    }
    
    public boolean vacio(){
        if (primero == null) return true;        
        return false;
    }
    
    public boolean existeElem(String a){
        boolean existe= false;
        NodoArbol actual = primero;
        while(actual!= null){
            if(a.equalsIgnoreCase(actual.num)) existe=true;
            actual= actual.sig;
        }     
        return existe;
    }
    
    public void ordenarElem(){     
        NodoArbol actual = primero;
        while(actual!= null){
            NodoArbol menor = actual;
            NodoArbol indice = actual.sig;
            while(indice!= null){
                if(indice.frec<menor.frec){
                    menor=indice;
                }
                indice= indice.sig;
            }
            int tempMenor = actual.frec;
            String tempNum = actual.num;
            actual.frec = menor.frec;
            actual.num= menor.num;
            menor.frec=tempMenor;
            menor.num= tempNum;        
            actual=actual.sig;
        }
    }
    
    public  void CrearArbol(){
        while(primero!=null){
            NodoArbol raiz;
            NodoArbol actual = primero;

            NodoArbol rama1 = actual;
            NodoArbol rama2 =actual.sig;

            raiz = new NodoArbol(rama1.frec+rama2.frec,"*");
            raiz.izq = rama1;
            raiz.der = rama2; 
            primero= actual.sig.sig;

            NodoArbol indice = primero;
            if(primero==null){
                raiz.sig = primero;
                primero=raiz;
                break;
            }
            while(indice!= null){
                if(indice.sig==null){
                    if(indice.frec>raiz.frec){
                        raiz.sig = primero;
                        primero=raiz;
                        break;
                    }
                    else{
                        frente.sig=raiz;
                        frente=raiz;
                        break;
                    }

                }
                else if(indice.sig.frec>raiz.frec){
                    raiz.sig=indice.sig;
                    indice.sig=raiz;
                    break;   
                }
                else indice= indice.sig;  
            }
        }
    }
    
    
}

