package atv3;

import java.util.Scanner;
import java.util.ArrayList;

public class Atv3 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        ArrayList<Canal> canais = new ArrayList<>();
        
        Canal Nimo   = new Canal(2, "NimoTV", true);
        Canal Zata   = new Canal(6, "ZataTV", false);
        Canal Record = new Canal(8, "Record", false);
        Canal Globo  = new Canal(10, "Globo", true);
        Canal Band   = new Canal(12, "Band", true);
        Canal Music  = new Canal(20, "MusicTV", true);
        Canal Cube   = new Canal(25, "CubeTV", false);
        
        canais.add(Nimo);
        canais.add(Zata);
        canais.add(Record);
        canais.add(Globo);
        canais.add(Band);
        canais.add(Music);
        canais.add(Cube);
        
        Televisao tvsmart = new SmartTV(50, canais); 
        Televisao tvhd = new TVHD ("LED", canais);
        
        tvsmart.cadastrarCanais();
        tvhd.cadastrarCanais();
        
        ControleRemoto c1 = new ControleRemoto();
        
        c1.adicionarTV(tvsmart);
        c1.adicionarTV(tvhd);
        
        int menu;
        
        do{
            
            exibirMenu();
            menu = entrada.nextInt();
            
            switch(menu){
                case 1://proximo canal
                    System.out.println("Passando o canal. . .");
                    
                    c1.proximoCanal(tvsmart);
                    c1.proximoCanal(tvhd);
                    
                    System.out.println("(Canal atual SmartTV)");
                    System.out.println(tvsmart.informarDados());
                    System.out.println("=====================");
                    System.out.println("(Canal atual TvHD)");
                    System.out.println(tvhd.informarDados());
                break;
                
                case 2://voltar canal
                    System.out.println("Voltando o canal. . .");
                    
                    c1.canalAnterior(tvsmart);
                    c1.canalAnterior(tvhd);
                    
                    System.out.println("(Canal atual SmartTV)");
                    System.out.println(tvsmart.informarDados());
                    System.out.println("=====================");
                    System.out.println("(Canal atual TvHD)");
                    System.out.println(tvhd.informarDados());
                break;
                
                case 3://aumentar volume
                    System.out.println("Aumentando o volume. . .");
                    
                    c1.aumentarVolume(tvsmart);
                    c1.aumentarVolume(tvhd);
                    
                    System.out.println("Volume da SmartTV: "+ tvsmart.getVolumeAtual());
                    System.out.println("===================");
                    System.out.println("Volume da TvHD: "+ tvhd.getVolumeAtual());
                    System.out.println("===================");
                break;
                
                case 4://diminuir volume
                    System.out.println("Diminuindo o volume. . .");
                    
                    c1.diminuirVolume(tvsmart);
                    c1.diminuirVolume(tvhd);
                    
                    System.out.println("Volume da SmartTV: "+ tvsmart.getVolumeAtual());
                    System.out.println("===================");
                    System.out.println("Volume da TvHD: "+ tvhd.getVolumeAtual());
                    System.out.println("===================");
                break;
                
                case 5://sintonizar canal
                    System.out.println("Digite o canal desejado: ");
                    int s = entrada.nextInt();
                    
                    c1.sintonizar(tvsmart,s);
                    c1.sintonizar(tvhd,s);
                    
                    System.out.println("(Canal atual SmartTV)");
                    System.out.println(tvsmart.informarDados());
                    System.out.println("=====================");
                    System.out.println("(Canal atual TvHD)");
                    System.out.println(tvhd.informarDados());
                break;
                
                case 6://informar dados
                    
                    System.out.println("(Canal atual SmartTV)");
                    System.out.println(tvsmart.informarDados());
                    System.out.println("=====================");
                    System.out.println("(Canal atual TvHD)");
                    System.out.println(tvhd.informarDados());
                    
                break;
                
                case 7://mostrar grade
                    System.out.println("(Grade de Canais da SmartTV)");
                    c1.mostrarGrade(tvsmart);
                    System.out.println("===========================");
                    System.out.println("(Grade de Canais da TvHD)");
                    c1.mostrarGrade(tvhd);
                break;
                
                case 0://sair
                    System.out.println("Saindo...");
                break;
                
                default:
                    System.out.println("Número digitado inválido!!");
            }
                

        }while(menu != 0);
        
    }
    static void exibirMenu(){
        System.out.println("=====================");
        System.out.println("=========MENU========");
        System.out.println("=====================");
        System.out.println();
        System.out.println("-->[1] Para próximo canal.");
        System.out.println("-->[2] Para voltar o canal.");
        System.out.println("-->[3] Para aumentar o volume.");
        System.out.println("-->[4] Para diminuir o volume.");
        System.out.println("-->[5] Para sintonizar.");
        System.out.println("-->[6] Para informar dados.");
        System.out.println("-->[7] Para mostrar grade.");
        System.out.println("-->[0] Para sair.");
        System.out.println("==> Escolha uma dessas opções : ");
        
    }
    
}
        
        
    
   

