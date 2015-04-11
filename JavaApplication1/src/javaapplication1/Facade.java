
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
        }
        else{
            //error
        }
        return "";
    }
    
    public void eval(String pvalores){
        if(_poli1.getPoli()!=null && _poli2.getPoli()==null){
            String[] vals = pvalores.split(" ");
            if(vals.length == 2){
                //evaluo
            }
            else{
                //error
            }
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
