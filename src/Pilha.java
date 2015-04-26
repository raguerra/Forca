
public class Pilha{
    Vetor lista = new Vetor();  
    
    public void push(Dados dados) {  // Adiciona valor na pilha
      lista.adiciona(dados);    
    }
    
    public boolean pEmpty() { // Verifica se a pilha esta vazia
        return lista.vazia(); // retornar true se lista estiver vazia
    }
                                   
    public Dados pop() {  // retorna com um elemento do top da lista
       if(!pEmpty()) {
        Dados strOb = lista.pega(lista.tamanho()-1);   //.toString();  
        lista.remove(lista.tamanho()-1);
        return strOb;
       } 
       return null; 
    }    
}                  