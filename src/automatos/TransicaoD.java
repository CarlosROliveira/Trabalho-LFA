package automatos;

/**
 * Classe que representa a funcao programa de um aut�mato finito determin�stico
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jose Melquiades
 */
public class TransicaoD {
	
	private Estado origem;
	private Estado destino;
	private Simbolo simbolo;
	
	/**
	 * Obtem o destino da transicao deterministica
	 * @return destino - Estado que representa o destino da transicao
	 */
	public Estado getDestino() {
		return destino.clonar();
	}
	
	/**
	 * Ajusta o destino da transicao deterministica para o valor passado como parametro
	 * @param destino Estado a ser definido como destino da transicao
	 */
	public void setDestino(Estado destino) {
		this.destino = destino.clonar();
	}
	
	/**
	 * Obtem a origem da transicao determin�stica
	 * @return origem - Estado que representa a origem da transicao
	 */
	public Estado getOrigem() {
		return origem.clonar();
	}
	
	/**
	 * Ajusta a origem da transicao deterministica para o valor passado como parametro
	 * @param origem Estado a ser definido como origem da transicao
	 */
	public void setOrigem(Estado origem) {
		this.origem = origem.clonar();
	}
	
	/**
	 * Obtem o simbolo do alfabeto
	 * @return simbolo - char que representa um simbolo do alfabeto
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}
	
	/**
	 * Ajusta o s�mbolo do alfabeto para o valor passado como par�metro
	 * @param simbolo char a ser definido como s�mbolo do alfabeto
	 */
	public void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo.clonar();
	}
	
	/**
	 * Cria e retorna uma c�pia do objeto TransicaoD
	 * @return um clone dessa TransicaoD
	 */
	public TransicaoD clonar() {		
		TransicaoD td = new TransicaoD();		
		td.setOrigem(this.origem);
		td.setDestino(this.destino);
		td.setSimbolo(this.simbolo);		
		return td;
	}
        
        /**
	 * Compara trasicoes
	 * @return verdadeiro se forem iguais
         * @param transicao TransicaoD a ser comparada
	 */
        public boolean igual(TransicaoD transicao){
            if ( this.destino.igual(transicao.getDestino()) &&
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
