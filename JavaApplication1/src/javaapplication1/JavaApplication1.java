/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;



/**
 *
 * @author curso
 */
public class JavaApplication1 {

    /**
     * @\param args the command line arguments
     */
    public static void main(String[] args) {
        String string1 = "12 3 4|3 3 1";
        String string2 = "13 3 1|24 3 4|45 3 6";
        Facade facade = new Facade();
        facade.nuevoOperando(string1);
        facade.nuevoOperando(string2);
        facade.setOperador("*");
        facade.resolver();
        //System.out.println(facade.PoliToString(facade.));
        //facade.printPolis();
  
        
//        NewJFrame gui = new NewJFrame();
//        gui.setVisible(true);
        
        
    }
    
}
