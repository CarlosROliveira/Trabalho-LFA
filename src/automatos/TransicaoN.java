package automatos;

/**
 * Classe que representa a funcao programa de um automato finito nao-deterministico
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jose Melquiades
 */
public class TransicaoN {
	
	private Estado origem;
	private ConjuntoEstados destino;
	private Simbolo simbolo;

        public TransicaoN(){
            destino = new ConjuntoEstados();
        }
		
	/**
	 * Obtem o destino da transicao nao-deterministica
	 * @return destino - ConjuntoEstados que representa o destino da transicao
	 */
	public ConjuntoEstados getDestino() {               
                    return this.destino.clonar();                                    
	}
	
	/**
	 * Ajusta o destino da transicao nao-deterministica para o valor passado como parametro
	 * @param destino um ConjuntoEstados a ser definido como destino da transicao
	 */
	public void setDestino(ConjuntoEstados destino) {
		this.destino = destino.clonar();
	}
	
	/**
	 * Obtem a origem da transicao nao-deterministica
	 * @return origem - Estado que representa a origem da transicao
	 */
	public Estado getOrigem() {
                if (origem!=null)
                    return this.origem.clonar();
                else
                    return null;
	}
	
	/**
	 * Ajusta a origem da transicao nao-deterministica para o valor passado como parametro
	 * @param origem um Estado a ser definido como origem da transicao
	 */
	public void setOrigem(Estado origem) {
		this.origem = origem.clonar();
	}
	
	/**
	 * Obtem o simbolo do alfabeto
	 * @return simbolo - char que representa um simbolo do alfabeto
	 */
	public Simbolo getSimbolo() {
		return this.simbolo.clonar();
	}
	
	/**
	 * Ajusta o simbolo do alfabeto para o valor passado como parametro
	 * @param simbolo um char a ser definida como simbolo do alfabeto
	 */
	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo.clonar();
	}
	
	/**
	 * Cria e retorna uma copia do objeto TransicaoN
	 * @return um clone dessa TransicaoN
	 */
	public TransicaoN clonar() {		
		TransicaoN tn = new TransicaoN();
		tn.setOrigem(this.origem);
		tn.setDestino(this.destino);
		tn.setSimbolo(this.simbolo);		
		return tn;
	}

        public boolean igual(TransicaoN transicao){
            if (this.destino.igual(transicao.getDestino()) &&
                this.origem.igual(transicao.getOrigem()) &&
                this.simbolo.igual(transicao.getSimbolo()))
                return true;
            else return false;
        }
        
        public String toString()
	{
		String s = new String();
		s += "(";                
                s +=  this.getOrigem().toString(); s += ",";
                s +=  this.getSimbolo().toString();s += ",";
                s +=  this.getDestino().toString();                
                s += ")";
		return s;
	}                        
}
