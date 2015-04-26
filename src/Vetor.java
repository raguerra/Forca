
import java.util.*;

public class Vetor{
       private Dados[] dados = new Dados[1];
       private int total = 0;     
           
             
       public void adiciona(Dados elem) {
              this.liberaEspaco();
              this.dados[this.total] = elem;
              this.total++;
       }
       
  /**    public void adiciona(int posicao, Dados dados) {
              this.liberaEspaco();
              if (!this.posicaoValida(posicao)) {
                 throw new IllegalArgumentException("Posicao invalida");
              }
              for (int indice = this.total - 1; indice >= posicao; indice--) {
                  this.dados[indice + 1] = this.dados[indice];
              }
              this.dados[posicao] = dados;
              this.total++;
       }**/
       
        public void remove(int posicao) {
          if (!this.posicaoOcupada(posicao)) {
               throw new IllegalArgumentException("Posicao invalida");
          }
            for (int i = posicao; i < this.total - 1; i++) {
             this.dados[i] = this.dados[i + 1];
            }
            this.total--;
        }
       
       
       private void liberaEspaco() {
               if (this.total == this.dados.length) {
                 Dados[] novoArray = new Dados[this.dados.length * 2];
                 for (int i = 0; i <= this.dados.length-1; i++) {
                     novoArray[i] = this.dados[i];
                 }
                 this.dados = novoArray;
               }
       }
       
       public int tamanho() {
              return this.total;
       }

	   public boolean vazia(){
           return this.total > 0 ? false : true; 
       }
       
   
    public String toString() {
         if (this.total == 0) {
           return "[]";
         }
         StringBuilder builder = new StringBuilder();
         builder.append("[");
         for (int i = 0; i < this.total - 1; i++) {
             builder.append(this.dados[i]);
             builder.append(", ");
         }
             builder.append(this.dados[this.total - 1]);
             builder.append("]");
             return builder.toString();
       }

         
    public Dados pega(int posicao) 
    {
         if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("***** Posicao invalida ******");
         }
           return dados[posicao];
    }
    
    private boolean posicaoOcupada(int posicao)
    {
          return posicao >= 0 && posicao < this.total;   
    }
    
       
  
       private boolean posicaoValida(int posicao) {
               return posicao >= 0 && posicao <= this.total;
       }
                   
         public boolean contem(Dados dado) {   
            for(int indice=0;indice<=total-1;indice++){
                 if(dado.getPegaElem().equals(this.dados[indice].toString()) ){  
                     return true;     
                 }
            }
            return false;
         } 
 }      