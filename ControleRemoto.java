package atv3;

import java.util.ArrayList;

public class ControleRemoto {
    
    ArrayList<Televisao> listaTelevisao = new ArrayList<>();
    
    public void adicionarTV(Televisao t){
        try{
            if(!listaTelevisao.contains(t)){
                listaTelevisao.add(t);
            }else{
                throw new TVCadastradaException(t);
            }
        }
        catch(TVCadastradaException e){
            System.out.println("Aconteceu um Erro!!");
            e.printStackTrace();
        }
    }
    
    public void aumentarVolume(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.alterarVolume("INCREMENTO");
            }
        }
    }
    
    public void diminuirVolume(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.alterarVolume("DECREMENTO");
            }
        }
    }
    
    public void sintonizar(Televisao t, int i){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.sintonizar(i);
            }
        }
    }
    
    public void proximoCanal(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.alterarCanal("proximo");
            }
        }
    }
    
    public void canalAnterior(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.alterarCanal("voltar");
            }
        }
    }
    
    public void informarDados(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.informarDados();
            }
        }
    }
    
    public void mostrarGrade(Televisao t){
        for(Televisao tt : listaTelevisao){
            if(tt == t){
                tt.mostrarGrade();
            }
        }
    }
}
