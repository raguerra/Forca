
public class Dados{
        private String elem;
        private String nome;
        private int pontos;
        private String carro;
        
       
  
        public void setAdiciona1(String elem){    
             this.elem = elem;
             this.nome = nome;
        }
        
        public void setAdiciona(String nome,int pontos){    
             this.nome = nome;
             this.pontos = pontos;
        }
        
        public void setAdiciona(String c1){    
             this.carro = c1;
             
        }
        
        public String getcarro1(){
            return this.carro;      
        }
        
       
        public String getnome(){
            return this.nome;      
        }
        
        public int getpontos() {
            return this.pontos;      
        }
        
        public String getPegaElem() {
            return this.elem;      
        }   
        
        
        public String toString() {
               return this.carro;
        }    
        
     
}
