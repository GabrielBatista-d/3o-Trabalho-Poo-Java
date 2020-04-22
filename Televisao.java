package atv3;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Televisao {
    public static final int VOLUME_MAX = 10;
    public static final int VOLUME_MIN = 0;
    public static final String ACAO_INCREMENTO = "INCREMENTO";
    public static final String ACAO_DECREMENTO = "DECREMENTO";
    public static final int VALOR_INCREMENTO = 1;
    public static final int VALOR_DECREMENTO = -1;
    
    
    ArrayList<Canal> canaisCadastradosList = new ArrayList<>();
    ArrayList<Canal> canaisDisponiveisList = new ArrayList<>();
    
    protected String id;
    protected int volumeAtual;
    protected Canal canalAtual;
   
    
    public Televisao(ArrayList<Canal> canaisDisponiveisList){
        this.canaisDisponiveisList = canaisDisponiveisList;
        this.volumeAtual = 5;
    }
    
    public int getVolumeAtual() {
        return volumeAtual;
    }

    public void setVolumeAtual(int volumeAtual) {
        this.volumeAtual = volumeAtual;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }
    

    public boolean alterarVolume(String tipoDeAlteracao){
        int novoValorDoVolume = 0;

        if (tipoDeAlteracao == ACAO_INCREMENTO){

            novoValorDoVolume = this.volumeAtual + VALOR_INCREMENTO;

            if (novoValorDoVolume > VOLUME_MAX){
                System.out.println("Volume não pode ser maior que dez!");
                return false;
            }

        }else if (tipoDeAlteracao == ACAO_DECREMENTO){

            novoValorDoVolume = this.volumeAtual + VALOR_DECREMENTO;

            if (novoValorDoVolume < VOLUME_MIN){
                System.out.println("Volume não pode ser menor que zero!");
                return false;
            }

        }else {
            System.out.println("Acão inválida!");
            return false;
        }

        this.setVolumeAtual(novoValorDoVolume);
        return true;
    }
 
 
    public abstract void cadastrarCanais();
    
    
    public boolean existeCanal(Canal canal){
        for (Canal c : this.canaisCadastradosList){
            if (c.getNumero() == canal.getNumero()){
                System.out.println("O Canal existe!");
                return true;
            }
        }
        System.out.println("O Canal não existe");
        return false;
    }
    
    public boolean sintonizar(int numero){
        try{
        Canal desejado;
        for(Canal c : this.canaisCadastradosList){
            if(c.getNumero() == numero){
                System.out.println("Voce escolheu o canal: "+c.getNome());
                System.out.println("Sintonizando. . .");
                desejado = c;
                
                setCanalAtual(desejado);
                return true;
            }
        }
        throw new CanalInexistenteException();
    }
        catch(CanalInexistenteException e){
            System.out.println("Aconteceu um erro");
            e.printStackTrace();
        }
        return false;
    }
    
    public void alterarCanal(String alteracao){
        int k = canaisCadastradosList.size();
        if(alteracao == "proximo"){
            if(this.canalAtual==canaisCadastradosList.get(k-1)){
                this.canalAtual = canaisCadastradosList.get(0);
            }else {
                int z = 0;
                for(Canal i : canaisCadastradosList){
                    z +=1;
                    if(this.canalAtual == i){
                        this.canalAtual=canaisCadastradosList.get(z);
                        break;
                    }
                }
            }
        }
        else if(alteracao == "voltar"){
            if(this.canalAtual == canaisCadastradosList.get(0)){
                this.canalAtual = canaisCadastradosList.get(k-1);
            }else {
                int t = 0;
                for(Canal i: canaisCadastradosList){
                    t +=1;
                    if(this.canalAtual == i){
                        this.canalAtual = canaisCadastradosList.get(t-2);
                        break;
                    }
                }
            }
        }else {
            System.out.println("Para passar o canal digite proximo e para voltar digite voltar.");
        }
    }
    
    public String informarDados(){
        String info = "";
        
        for(Canal c : canaisCadastradosList){
            if(c == getCanalAtual()){
                info += c.imprimir() + "\nVolume: " + getVolumeAtual();
            }
        }
        return info;
    }
    
    public void mostrarGrade(){
        Collections.sort(canaisCadastradosList);
        for (Canal c : canaisCadastradosList){
            System.out.println("=================");
            System.out.println(c.imprimir() + "\n");
        }
    }  
}