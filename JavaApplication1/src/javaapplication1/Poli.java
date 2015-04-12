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
public class Poli {
    private Tripleta _head;
    private Tripleta _tail;

    public Poli(){
        _head = null;
    }
    
    public Tripleta getPoli(){
        return _head;
    }
    
    public Tripleta getTail(){
        return _tail;
    }
    public void setTail(Tripleta ptail){
        _tail = ptail;
    }
    public void nuevaTripleta(Tripleta ptripleta){
            if(_head == null){
                _head = ptripleta;
                _tail = _head;
            }
            else{
                Tripleta tmp = ptripleta;
                _tail.setNext(tmp);
                tmp.setPrev(_tail);
                _tail = tmp;
            }
    }

    public boolean noExisteTripleta(int px,int py){
        Tripleta tmp = _head;
        while(tmp != null){
            if(tmp.getX()==px && tmp.getY()==py){
                return false;
            }
            tmp = tmp.getNext();
        }
        return true;
    }
}
