package atv3;

import java.util.ArrayList;

public class SmartTV extends Televisao{
    
    protected int qtdPolegadas;

    public SmartTV(int qtdPolegadas, ArrayList<Canal> canaisDisponiveisList) {
        super(canaisDisponiveisList);
        this.qtdPolegadas = qtdPolegadas;
    }
  
    @Override
    public void cadastrarCanais(){
        System.out.println("Cadastrando todos o Canais Disponiveis. . .");
            
        for(Canal c : canaisDisponiveisList){
            canaisCadastradosList.add(c);
        }setCanalAtual(canaisCadastradosList.get(0));
    }
}
