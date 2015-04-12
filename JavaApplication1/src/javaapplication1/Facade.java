
package javaapplication1;

/**
 *
 * @author RafaelAngel
 */
public class Facade {
    private Poli _poli1;
    private Poli _poli2;
    private String _operador;
    
    public Facade(){
        _poli1 = new Poli();
        _poli2 = new Poli();
        _operador = "";
    }
    
    public void printPolis(){
        Tripleta tmp1 = _poli1.getPoli();
        Tripleta tmp2 = _poli2.getPoli();
            while(tmp1 != null){
                System.out.println("tripleta1");
                System.out.println(tmp1.getNum());
                System.out.println(tmp1.getX());
                System.out.println(tmp1.getY());
                tmp1 = tmp1.getNext();
            }
            while(tmp1 != null){
                System.out.println("tripleta2");
                System.out.println(tmp1.getNum());
                System.out.println(tmp1.getX());
                System.out.println(tmp1.getY());
                tmp1 = tmp1.getNext();
            }
    }
    
    public void borrarOperando(){
        if(_poli2.getPoli()!=null){
            _poli2=new Poli();
        }
        else if(_poli1.getPoli()!=null){
            _poli1 = new Poli();
        }
    }
   
    public void borrarOperandos(){
        _poli1 = new Poli();
        _poli2 = new Poli();
    }
    
    public void setOperador(String poperador){
        _operador = poperador;
    }
    
    public String resolver(){
        if(_poli1.getPoli()!=null && _poli2.getPoli()!=null && !_operador.equals("")){
            //resolver la operacion guardando el resultado en operando1 y borrando el 2do
            if(_operador.equals("+")){
                Tripleta tmp1 = _poli1.getPoli();
                Tripleta tmp2 = _poli2.getPoli();
                while(tmp2!=null){
                    boolean flag = true;
                    while(tmp1 != null && flag){
                        if(tmp2.getX() == tmp1.getX() && tmp2.getY() == tmp1.getY()){
                            tmp1.setNum(tmp1.getNum()+tmp2.getNum());
                            flag = false;
                        }
                        tmp1 = tmp1.getNext();
                    }
                    if(flag){//cuando no aparece esa triplata la agrega 
                        Tripleta copia = new Tripleta(tmp2.getNum(),tmp2.getX(),tmp2.getY());
                        _poli1.getTail().setNext(copia);
                        copia.setPrev(_poli1.getTail());
                        _poli1.setTail(copia);
                    }
                    tmp2 = tmp2.getNext();
                }
                _poli2 = new Poli();//reseteo el segundo operando
            }
            if(_operador.equals("-")){
                Tripleta tmp1 = _poli1.getPoli();
                Tripleta tmp2 = _poli2.getPoli();
                while(tmp2!=null){
                    boolean flag = true;
                    while(tmp1 != null && flag){
                        if(tmp2.getX() == tmp1.getX() && tmp2.getY() == tmp1.getY()){
                            tmp1.setNum(tmp1.getNum()-tmp2.getNum());
                            flag = false;
                        }
                        tmp1 = tmp1.getNext();
                    }
                    if(flag){//cuando no aparece esa triplata la agrega 
                        Tripleta copia = new Tripleta(-(tmp2.getNum()),tmp2.getX(),tmp2.getY());
                        _poli1.getTail().setNext(copia);
                        copia.setPrev(_poli1.getTail());
                        _poli1.setTail(copia);
                    }
                    tmp2 = tmp2.getNext();
                    }
                _poli2 = new Poli();//reseteo el segundo operando
            }
            if(_operador.equals("*")){
                Tripleta tmp1 = _poli1.getPoli();
                Tripleta tmp2 = _poli2.getPoli();
                Poli politmp1 = new Poli();
                while(tmp2!=null){
                    Poli politmp2 = new Poli();
                    while(tmp1 != null){
                        Tripleta tmp3 = new Tripleta(tmp1.getNum()*tmp2.getNum(),tmp1.getX()+tmp2.getX(),tmp1.getY()+tmp2.getY());
                        politmp2.nuevaTripleta(tmp3);
                        tmp1 = tmp1.getNext();
                    }
                    politmp1 = sumarPolis(politmp1,politmp2);
                    tmp1 = _poli1.getPoli();
                    tmp2 = tmp2.getNext();
                    }
                _poli1 = politmp1;
                _poli2 = new Poli();//reseteo el segundo operando
            }
        }
        else{
            //error
        }
        System.out.println(PoliToString(_poli1));
        return "";
    }
    
    public Poli sumarPolis(Poli ppoli1,Poli ppoli2){
        
        Tripleta tmp1 = ppoli1.getPoli();
        Tripleta tmp2 = ppoli2.getPoli();
                while(tmp2!=null){
                    boolean flag = true;
                    while(tmp1 != null && flag){
                        if(tmp2.getX() == tmp1.getX() && tmp2.getY() == tmp1.getY()){
                            tmp1.setNum(tmp1.getNum()+tmp2.getNum());
                            flag = false;
                        }
                        tmp1 = tmp1.getNext();
                    }
                    if(flag){//cuando no aparece esa triplata la agrega 
                        Tripleta copia = new Tripleta(tmp2.getNum(),tmp2.getX(),tmp2.getY());
                        if(ppoli1.getTail()!= null){
                            ppoli1.getTail().setNext(copia);
                            copia.setPrev(ppoli1.getTail());
                            ppoli1.setTail(copia);
                        }
                        else{
                            ppoli1.nuevaTripleta(copia);
                        }
                    }
                    tmp1 = ppoli1.getPoli();
                    tmp2 = tmp2.getNext();
                }
                return ppoli1;
    }
    
    public String PoliToString(Poli ppoli){
        Tripleta tmp =ppoli.getPoli();
        String result = "";
        while(tmp != null){
            result += tmp.getNum();
            result += " ";
            result += tmp.getX();
            result += " ";
            result += tmp.getY();
            result += "|";
            tmp = tmp.getNext();
        }
        return result;
    }
    
    public int eval(String pvalores){
        if(_poli1.getPoli()!=null && _poli2.getPoli()==null){
            String[] vals = pvalores.split(" ");
            if(vals.length == 2){
                int result = 0;
                int valX=Integer.parseInt(vals[0]);
                int valY=Integer.parseInt(vals[1]);
                Tripleta tmp = _poli1.getPoli();
                while(tmp != null){
                    result += tmp.getNum()*Math.pow(valX, tmp.getX())*Math.pow(valY, tmp.getY());
                    tmp = tmp.getNext();
                }
                return result;
            }
            else{
                //error
                return -999999;
            }
        }
        else{
            //error
            return -999999;
        }
        
    }
    
    public void nuevoOperando(String poperando){
        if(_poli1.getPoli()==null){
            if(poperando.contains("|")){
                String[] tripletas = poperando.split("\\|");
                for(int i = 0;i<tripletas.length;i++){
                    String[] trip = tripletas[i].split(" ");
                    if(trip.length==3 && 
                            _poli1.noExisteTripleta(Integer.parseInt(trip[1]),Integer.parseInt(trip[2]))){
                        
                        Tripleta tmp = new Tripleta(Integer.parseInt(trip[0]),
                                Integer.parseInt(trip[1]),Integer.parseInt(trip[2]));
                        _poli1.nuevaTripleta(tmp);
                    }
                    else{
                        //error
                    }
                }
            }
            else{
                if(poperando.isEmpty()){
                   //error 
                }
                else{
                    String[] trip = poperando.split(" ");
                    if(trip.length==3 && 
                            _poli1.noExisteTripleta(Integer.parseInt(trip[1]),Integer.parseInt(trip[2]))){
                        
                        Tripleta tmp = new Tripleta(Integer.parseInt(trip[0]),
                                Integer.parseInt(trip[1]),Integer.parseInt(trip[2]));
                        _poli1.nuevaTripleta(tmp);
                    }
                    else{
                        //error
                    }
                }
            }
        }
        else if(_poli2.getPoli()==null){
            if(poperando.contains("|")){
                String[] tripletas = poperando.split("\\|");
                for(int i = 0;i<tripletas.length;i++){
                    String[] trip = tripletas[i].split(" ");
                    if(trip.length==3 && 
                            _poli2.noExisteTripleta(Integer.parseInt(trip[1]),Integer.parseInt(trip[2]))){
                        
                        Tripleta tmp = new Tripleta(Integer.parseInt(trip[0]),
                                Integer.parseInt(trip[1]),Integer.parseInt(trip[2]));
                        _poli2.nuevaTripleta(tmp);
                    }
                    else{
                        //error
                    }
                }
            }
            else{
                if(poperando.isEmpty()){
                   //error 
                }
                else{
                    String[] trip = poperando.split(" ");
                    if(trip.length==3 && 
                            _poli2.noExisteTripleta(Integer.parseInt(trip[1]),Integer.parseInt(trip[2]))){
                        
                        Tripleta tmp = new Tripleta(Integer.parseInt(trip[0]),
                                Integer.parseInt(trip[1]),Integer.parseInt(trip[2]));
                        _poli2.nuevaTripleta(tmp);
                    }
                    else{
                        //error
                    }
                }
            }
        }
        else{
            //error
        }
    }
}
