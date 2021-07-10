/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigohuffman;
import java.util.Random;
/**
 *
 * @author Sistema
 */
public class CodigoHuffman {

    
    
    static ListaArbol genLista(String [][] a){
        ListaArbol lista = new ListaArbol();
        
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                if (lista.vacio()==true){
                  lista.agregarFrente(1,a[i][j]);
                }
                else if(lista.existeElem(a[i][j])==true){
                    NodoArbol actual = lista.primero;
                    while(actual!= null){
                        if(a[i][j].equalsIgnoreCase(actual.num)) {
                            actual.frec++;
                            break;
                        }
                        actual= actual.sig;
                    }
                }
                else{
                  lista.agregarFrente(1,a[i][j]);
                }
            }
            
        } 
        lista.ordenarElem();
        return lista;
    }
    
    
    static void recorrerArbol(ListaCamino lista, NodoArbol a,String cadena){
        if (a!=null){
            if(a.der==null){  
                lista.agregarFrente(cadena,a.num);
            }
            recorrerArbol(lista,a.izq, cadena + "0");
            recorrerArbol(lista,a.der, cadena + "1");
        }
    }
    
    static String codificar(String[][] a, ListaCamino lista){
        String cadena ="";
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                cadena = cadena + lista.buscarNum(a[i][j]);
            }
        }
        return cadena;
    }
    
    static void decodificar(String cod, ListaArbol lista){  
        int i =0;
        while(i<cod.length()){
            NodoArbol actual = lista.primero;
            NodoArbol temp;
            while(actual.izq!=null){
                char hoja = cod.charAt(i);
                if (hoja =='0'){
                    temp=actual.izq;
                }
                else{
                    temp = actual.der;
                }
                i++;
                actual=temp;
            }
            System.out.print(actual.num);
        }
    }  

    
    
    public static void main(String[] args) {
        int n = 4;
        Random rnd = new Random();
        String[][] a = new String[n][n];
        
        ListaArbol l1=new ListaArbol();
        ListaArbol l2=new ListaArbol();
        
        ListaCamino lc1 = new ListaCamino();
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
              a[i][j] = Integer.toString(rnd.nextInt(8)+1);  
            }
            
        }
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(a[i][j]);
            }
             System.out.println("");
            
        }
        
        l1=genLista(a);
        System.out.println("/////"); 
        l1.imprimir();
        System.out.println("/////"); 
        
        l1.CrearArbol();
         
        recorrerArbol(lc1,l1.primero,"");
        
        System.out.println("---------"); 
        lc1.imprimir();
        System.out.println("---------"); 
        
        System.out.println(codificar(a, lc1));
        String cod = codificar(a, lc1);
        
        decodificar(cod, l1);
        System.out.println("");     
    }   
}
