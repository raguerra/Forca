
import java.util.Scanner;
 
public class Forca {

static Vetor lista = new Vetor();
static Vetor carros = new Vetor();
static Scanner entrada = new Scanner(System.in);
static Pilha partes = new Pilha();
static String nome;   
static int pontos;
static String palavra;

public static void usuario(){
        System.out.println("|-------------------------------------------------|");
        System.out.println("|------------------JOGO DA FORCA------------------|");
        System.out.println("|                 DIGITE SEU NOME                 |");
        System.out.println("|-------------------------------------------------|");
        nome = entrada.nextLine();
        jogar();
    }

 public static  void jogo(){   
        System.out.println("---------------------------------------------------");
        System.out.println("|                 JOGO DA FORCA                    |");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("|                   1.NOVO JOGO                   |");
        System.out.println("|                   2.RANKING                     |");
        System.out.println("|                   3.SAIR                        |");
        System.out.println("---------------------------------------------------"); 
        int operSel = Integer.parseInt(entrada.nextLine());
        switch(operSel){
            case 1: usuario();
            case 2: ranking();
            case 3: System.exit(0); 
                }
    }
 
 public static void ranking(){     
        System.out.println("|-------------------------------------------------|");
        System.out.println("|---------------------RANKING---------------------|");
        System.out.println("|-------------------------------------------------|");
        for (int i = 0; i < lista.tamanho(); i++){
        Dados obj = lista.pega(i);
        System.out.println("|-------------------------------------------------|");
        System.out.println("NOME:..............................."+obj.getnome());
        System.out.println("PONTOS:............................."+obj.getpontos());
        System.out.println("|-------------------------------------------------|");
        }
        System.out.println("---------------------------------------------------");
        System.out.println("|                ESCOLHA A OPERAÇÃO               |");
        System.out.println("---------------------------------------------------");
        System.out.println("|         1.MENU PRINCIPAL                        |");
        System.out.println("|         2.SAIR                                  |");
        System.out.println("---------------------------------------------------"); 
        int operSel = Integer.parseInt(entrada.nextLine());
        switch(operSel){
            case 1: jogo(); 
            case 2: System.exit(0); 
            }
 }
 
 public static  void jogar(){   
        System.out.println("---------------------------------------------------");
        System.out.println("|                 JOGO DA FORCA                   |");
        System.out.println("---------------------------------------------------");
        System.out.println();
        int sort = (int) (Math.random()*16);
        Dados obj1 = carros.pega(sort);
        palavra = obj1.getcarro1();
        carros.remove(sort);
        int chances = 0;
        System.out.println("|   A PALVRA TEM :"+palavra.length()+" LETRAS     |");
        System.out.println();
        int x = 0;
        while(chances < 6){
        System.out.println("|              ADIVINHE UMA LETRA                 |");
            String letra = entrada.nextLine();
            boolean contains = palavra.contains(letra);
            if(contains == true){
                x++;
                pontos = pontos + 10;
            }else{
                Dados pCorpo = partes.pop();
                System.out.println(pCorpo.getPegaElem());
                chances++;  
            }
             if (chances == 6)System.out.println("ENFORCADO");
        System.out.println("PONTUAÇÃO:....."+nome+"....."+pontos);
             if (x == palavra.length())break;
             System.out.println("---------------------------------------------------");
             System.out.println("|        DESEJA SUICIDIO:  1 - SIM | 2 - NÃO      |");
             System.out.println("---------------------------------------------------");
             int opSuic = Integer.parseInt(entrada.nextLine());
             switch(opSuic){
                 case 1: suicidio();
                 case 2: continue;    
             } 
        }
        System.out.println("---------------------------------------------------");
        System.out.println("|                ESCOLHA A OPERAÇÃO               |");
        System.out.println("---------------------------------------------------");
        System.out.println("|         1.MENU PRINCIPAL                        |");
        System.out.println("|         2.JOGAR NOVAMENTE                       |");
        System.out.println("|         3.SAIR                                  |");
        System.out.println("---------------------------------------------------"); 
        int operSel = Integer.parseInt(entrada.nextLine());
        switch(operSel){
            case 1: Dados usuario = new Dados();
                    usuario.setAdiciona(nome, pontos);        
                    lista.adiciona(usuario);
                    nome = "";
                    pontos = 0; 
                    jogo(); 
            case 2: jogar();
            case 3: System.exit(0); 
            }  
    }
 
    public static void suicidio(){
        System.out.println("---------------------------------------------------");
        System.out.println("|      SUICIDIO - DIGITE A PALAVRA COMPLETA        |");
        System.out.println("---------------------------------------------------");
             String suicidio = entrada.nextLine();
             if(suicidio.equals(palavra)){
                 pontos = pontos + 100;
        System.out.println("---------------------------------------------------");
        System.out.println("|                 VOCÊ VENCEU                     |");   
             }else{
        System.out.println("---------------------------------------------------");
        System.out.println("|                  GAME OVER                      |");   
             }
        System.out.println("---------------------------------------------------");
        System.out.println("|                ESCOLHA A OPERAÇÃO               |");
        System.out.println("---------------------------------------------------");
        System.out.println("|         1.MENU PRINCIPAL                        |");
        System.out.println("|         2.JOGAR NOVAMENTE                       |");
        System.out.println("|         3.SAIR                                  |");
        System.out.println("---------------------------------------------------"); 
        int operSel = Integer.parseInt(entrada.nextLine());
        switch(operSel){
            case 1: Dados usuario = new Dados();
                    usuario.setAdiciona(nome, pontos);        
                    lista.adiciona(usuario);
                    nome = "";
                    pontos = 0; 
                    jogo(); 
            case 2: jogar();
            case 3: System.exit(0); 
            }  
    } 
 
    public static void main(String[] args) {
        String[] erros = {"PERNA ESQUERDA","PERNA DIREITA","BRAÇO DIREITO","BRAÇO ESQUERDO","TRONCO","CABEÇA"};
        for (int p = 0; p < 6; p++){
        Dados parte = new Dados();
        parte.setAdiciona1(erros[p]);
        partes.push(parte);
        }
        String carro[]={"FIESTA","CHEVETE","FUSION","FUSCA","GOL","FERRARI","CELTA","MONZA","SIENA","GOLF","LOGUS","BRASILIA","ECLIPSE","CAMARO","BELINA","QQ","MINICOOPER","OPALA","VARIANT"};
        for (int i = 0; i < 19; i++){
        Dados dados = new Dados();
        String insereCarro = carro[i];
        dados.setAdiciona(insereCarro);
        carros.adiciona(dados);
        }
       usuario();  
      }  
}