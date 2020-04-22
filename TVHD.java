package atv3;

import java.util.ArrayList;

public class TVHD extends Televisao{
    
    protected String modeloTV;

    public TVHD(String modeloTV, ArrayList<Canal> canaisDisponiveisList) {
        super(canaisDisponiveisList);
        this.modeloTV = modeloTV;
    }
    
    @Override
    public void cadastrarCanais(){
        System.out.println("Cadastrando todos o Canais HD's. . .");
        
        for(Canal c : canaisDisponiveisList){
            if(c.getEhHD()){
                canaisCadastradosList.add(c);
                Canal cc = c;
                setCanalAtual(cc);
            }
        }
    }
}
    

