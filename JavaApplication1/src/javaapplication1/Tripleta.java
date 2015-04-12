/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author RafaelAngel
 */
public class Tripleta {
    private int _num;
    private int _x;
    private int _y;
    private Tripleta _next;
    private Tripleta _prev;
    
    public Tripleta(int pnum,int px,int py){
        _num = pnum;
        _x = px;
        _y = py;
        _next = null;
        _prev = null;
        System.out.println("hola");
        System.out.println(pnum);
        System.out.println(px);
        System.out.println(py);
    }
    
    public void setNext(Tripleta pnext){
        _next = pnext;
    }
    public void setPrev(Tripleta pprev){
        _prev = pprev;
    }
    public Tripleta getNext(){
        return _next;
    }
    public Tripleta getPrev(){
        return _prev;
    }
    
   public int getNum(){
        return _num;
    }
    public int getX(){
        return _x;
    }
    public int getY(){
        return _y;
    }
    
    public void setNum(int pnum){
        _num = pnum;
    }
    public void setX(int px){
        _x = px;
    }
    public void setY(int py){
        _y = py;
    }
    
}
