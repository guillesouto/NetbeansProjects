/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

/**
 *
 * @author guill
 */
public class ejemploHilos {
    
    public ejemploHilos (String str){
        super(str);
    }
    
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(i+" "+getName());
        }
        System.out.println("Termina hilo: "+getName());
    }
    
    public static void main(String[] args){
        new ejemploHilos("Palomo").start();
        new ejemploHilos("Asabache").start();
        
        System.out.println();
    }
    
}
