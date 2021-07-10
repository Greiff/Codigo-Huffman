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
public class NodoCamino {
    public String num;
    public String cod;
    public NodoCamino sig;

    public NodoCamino(String cod,String num) {
        this.num = num;
        this.cod=cod;
        this.sig=null;    
    } 

    public NodoCamino() {
    }
    
    
}
