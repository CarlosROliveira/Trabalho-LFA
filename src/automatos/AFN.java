
package automatos;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 * Classe para a criacao de um automato finito n�o-determin�stico
 * 
 * @author Fabio Moreira Campos, Rafael Sachetto Oliveira, Tiago Jos� Melquiades
 */

public class AFN {

	private ConjuntoSimbolo simbolos;
	private ConjuntoEstados estados;
	private ConjuntoEstados estadosFinais;
	private ConjuntoTransicaoN funcaoPrograma;
	private Estado estadoInicial;

	/**
	 * Metodo construtor de um Automato finito deterministico
	 * 
	 * @param simbolos
	 *            ConjuntoSimbolo que representa o alfabeto do automato finito
	 *            deterministico
	 * @param estados
	 *            ConjuntoEstados que representa o conjunto de estados do
	 *            automato finito determinostico
	 * @param funcaoPrograma
	 *            ConjuntoTransicaoD que representa a funcao programa do
	 *            automato finito deterministico
	 * @param estadoInicial
	 *            Estado que representa o estado inicial do automato finito
	 *            deterministico
	 * @param estadosFinais
	 *            ConjuntoEstados que representa o conjunto de estados finais do
	 *            automato finito nao-deterministico
	 */
	public AFN(ConjuntoSimbolo simbolos, ConjuntoEstados estados,
			ConjuntoTransicaoN funcaoPrograma, Estado estadoInicial,
			ConjuntoEstados estadosFinais) {

		this.simbolos = simbolos.clonar();
		this.estados = estados.clonar();
		this.funcaoPrograma = funcaoPrograma.clonar();
		this.estadoInicial = estadoInicial.clonar();
		this.estadosFinais = estadosFinais.clonar();

	}

        public AFN(){
		simbolos = new ConjuntoSimbolo();
		estados = new ConjuntoEstados();
		estadosFinais = new ConjuntoEstados();
		funcaoPrograma = new ConjuntoTransicaoN();
	}

	/**
	 * Obtem o estado inicial do automato finito nao-deterministico
	 * 
	 * @return estadoInicial - Estado que representa o estado inicial do
	 *         aut�mato finito n�o-determin�stico
	 */
	public Estado getEstadoInicial() {
		return estadoInicial.clonar();
	}

	/**
	 * Ajusta o estado inicial do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param estadoInicial
	 *            um Estado a ser definido como estado inicial do aut�mato
	 *            finito n�o-determin�stico
	 */
	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial.clonar();
	}

	/**
	 * Obt�m o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * 
	 * @return estados - ConjuntoEstados que representa o conjunto de estados
	 *         finais do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoEstados getEstados() {
		return estados.clonar();
	}

	/**
	 * Ajusta o conjunto de estados do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param estados
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            do aut�mato finito n�o-determin�stico
	 */
	public void setEstados(ConjuntoEstados estados) {
		this.estados = estados.clonar();
	}

	/**
	 * Obt�m o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * 
	 * @return estadosFinais - ConjuntoEstados que representa o conjunto de
	 *         estados finais do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoEstados getEstadosFinais() {
		return estadosFinais.clonar();
	}

	/**
	 * Ajusta o conjunto de estados finais do aut�mato finito n�o-determin�stico
	 * para o valor passado como par�metro
	 * 
	 * @param estadosFinais
	 *            um ConjuntoEstados a ser definido como o conjunto de estados
	 *            finais do aut�mato finito n�o-determin�stico
	 */
	public void setEstadosFinais(ConjuntoEstados estadosFinais) {
		this.estadosFinais = estadosFinais.clonar();
	}

	/**
	 * Obt�m a fun��o programa do aut�mato finito n�o-determin�stico
	 * 
	 * @return funcaoPrograma - ConjuntoTransicaoN que representa a fun��o
	 *         programa do aut�mato finito n�o-determin�stico
	 */
	public ConjuntoTransicaoN getFuncaoPrograma() {
		return funcaoPrograma.clonar();
	}

	/**
	 * Ajusta a fun��o programa do aut�mato finito n�o-determin�stico para o
	 * valor passado como par�metro
	 * 
	 * @param funcaoPrograma
	 *            um ConjuntoTransicaoN a ser definido como a fun��o programa do
	 *            aut�mato finito n�o-determin�stico
	 */
	public void setFuncaoPrograma(ConjuntoTransicaoN funcaoPrograma) {
		this.funcaoPrograma = funcaoPrograma.clonar();
	}

	/**
	 * Obt�m o alfabeto do aut�mato finito n�o-determin�stico
	 * 
	 * @return simbolos - ConjuntoSimbolo que representa o alfabeto do aut�mato
	 *         finito n�o-determin�stico
	 */
	public ConjuntoSimbolo getSimbolos() {
		return simbolos.clonar();
	}

	/**
	 * Ajusta o alfabeto do aut�mato finito n�o-determin�stico para o valor
	 * passado como par�metro
	 * 
	 * @param simbolos
	 *            um ConjuntoSimbolo a ser definido como o alfabeto do aut�mato
	 *            finito n�o-determin�stico
	 */
	public void setSimbolos(ConjuntoSimbolo simbolos) {
		this.simbolos = simbolos.clonar();
	}

	/**
	 * Cria e retorna uma copia do objeto AFN
	 * @return um clone desse AFN
	 */
	public AFN clonar() {
		return new AFN(simbolos, estados, funcaoPrograma, estadoInicial,
				estadosFinais);
	}

	public String toString() {
		String s = new String();
		s += "(";
		s += simbolos.toString();
		s += ",";
		s += estados.toString();
		s += ",";
		s += this.getFuncaoPrograma().toString();
		s += ",";
		s += estadoInicial.toString();
		s += ",";
		s += estadosFinais.toString();
		s += ")";
		return s;
	}

	/**
	 * Funcao Programa
	 * @return conjunto de estados alcancaveis depois de processar o Simbolo s a
	 *         partir de estados e
	 * @param Estado
	 *            estado onde iniciara o processamento
	 * @param Simbolo
	 *            simbolo a ser processado
	 */

	public ConjuntoEstados p(Estado e, Simbolo s) {
		ConjuntoTransicaoN fp;
		TransicaoN t;
		fp = getFuncaoPrograma();
		for (Iterator iter = fp.getElementos().iterator(); iter.hasNext();) {
			t = (TransicaoN) iter.next();
			if (t.getOrigem().igual(e) && t.getSimbolo().igual(s))
				return t.getDestino();
		}

		ConjuntoEstados cevazio = new ConjuntoEstados();
		return cevazio;
	}

	/**
	 * Funcao Programa Estendida
	 * @return conjunto de estados alcancaveis depois de processar a palavra p a
	 *         partir de um conjunto de estados
	 * @param ConjuntoEstados
	 *            Conjunto de estados onde iniciar� o processamento
	 * @param String
	 *            palavra a ser processada
	 */
	public ConjuntoEstados pe(ConjuntoEstados e, String w) {
            ConjuntoEstados ce = new ConjuntoEstados();
            if (w.isEmpty())
                return e.clonar();
            else{
                Iterator i = e.iterator();
                while (i.hasNext()){
                    ConjuntoEstados tmp = p((Estado)i.next(),new Simbolo(w.charAt(0)));
                    ce = ce.uniao(tmp);
                }
                return pe(ce,w.substring(1));
            }
        }

	/**
	 * Retorna se uma palavra � aceita ou n�o por determinado AFN
	 * @return true caso a palavra � aceita; false caso contr�rio
	 * @param String
	 *            palavra a ser avaliada
	 */
	public boolean Aceita(String p) {
		return false;
	}

	/**
	 * Converte um AFN para um AFD
	 * @return retorna o AFD equivalente
	 */
        public AFD convertToAFD(){
            //List qLinha = get_QLinha();
            ConjuntoEstados qLinha = get_QLinha();
            //List fLinha = get_FLinha(qLinha);
            ConjuntoEstados fLinha = get_FLinha(qLinha);
            
            //Impressao dos estados QLinha e FLinha
            System.out.println("\nQLinha:");
            for(Iterator iter = qLinha.getElementos().iterator(); iter.hasNext();){
                System.out.println(iter.next().toString());
            }
            
            System.out.println("\nFLinha:");
            for(Iterator iter = fLinha.getElementos().iterator(); iter.hasNext();){
                System.out.println(iter.next().toString());
            }
            //FIM Impressao dos estados QLinha e FLinha
            
            AFD afd = new AFD();
            
            ConjuntoTransicaoD conjTransD = getConjuntoTransicaoD(qLinha);
            
            Map<String, String> hash  = new HashMap<String, String>();
            ArrayList<Estado> t = new ArrayList<Estado>(qLinha.getElementos());
            for(int i=0; i < t.size();i++){
                hash.put(t.get(i).getNome(), "q".concat(String.valueOf(i+1)));
            }
            
            ArrayList<Estado> novoNomeQLinha = new ArrayList<Estado>(qLinha.getElementos());
            for(int i = 0; i< novoNomeQLinha.size(); i++)
                novoNomeQLinha.get(i).setNome(hash.get(novoNomeQLinha.get(i).getNome()));
            
            
            ArrayList<Estado> novoNomeFLinha = new ArrayList<Estado>(fLinha.getElementos());
            for(int j=0;j<novoNomeFLinha.size();j++)
                novoNomeFLinha.get(j).setNome(hash.get(novoNomeFLinha.get(j).getNome()));
                      
            
            ArrayList<TransicaoD> novoNomeTransicaoD = new ArrayList<TransicaoD>(conjTransD.getElementos());
            for(int k=0; k< novoNomeTransicaoD.size(); k++){
                //System.out.println("----- " +novoNomeTransicaoD.get(k).getOrigem().getNome());
                //System.out.println("+++++ " +novoNomeTransicaoD.get(k).getDestino().getNome());
                novoNomeTransicaoD.get(k).setOrigem(new Estado(hash.get(novoNomeTransicaoD.get(k).getOrigem().getNome())));
                //novoNomeTransicaoD.get(k).setDestino(new Estado(hash.get(novoNomeTransicaoD.get(k).getDestino().getNome().replaceAll(",", ", "))));
            }
            
            
            afd.setSimbolos(simbolos);
            afd.setEstados(qLinha);
            afd.setEstadosFinais(fLinha);
            afd.setFuncaoPrograma(conjTransD);
            afd.setEstadoInicial(estadoInicial);
            
            System.out.println("\nAFD:"+ afd);
            
            return null;
        }

        
        private ConjuntoEstados get_QLinha(){
            
            //Coloca em "elementos" todos os estados do XML que representa o AFN
            ConjuntoEstados elementos = this.getEstados();
            ArrayList<String> nomeEstados = new ArrayList<String>();
            for (Iterator iter = elementos.getElementos().iterator(); iter.hasNext();) {
                Estado estado = (Estado) iter.next();
                nomeEstados.add(estado.getNome());
            }
            
            //aqui pode ser qualquer objeto que implemente Comparable
            List<SortedSet<Comparable>> allCombList = new ArrayList<SortedSet<Comparable>>(); // Lista que tera toda as combinacoes para Q'
            for (String nEstados : nomeEstados) {
                allCombList.add(new TreeSet<Comparable>(Arrays.asList(nEstados))); //insiro a combinação "1 a 1" de cada item
            }
            for (int nivel = 1; nivel < nomeEstados.size(); nivel++) { 
                List<SortedSet<Comparable>> estadosAntes = new ArrayList<SortedSet<Comparable>>(allCombList); //crio uma cópia para poder não iterar sobre o que já foi
                for (Set<Comparable> antes : estadosAntes) {
                    SortedSet<Comparable> novo = new TreeSet<Comparable>(antes); //para manter ordenado os objetos dentro do set
                    novo.add(nomeEstados.get(nivel));
                    if (!allCombList.contains(novo)) { //testo para ver se não está repetido
                            allCombList.add(novo);
                    }
                }
            }
            Collections.sort(allCombList, new Comparator<SortedSet<Comparable>>() { //aqui só para organizar a saída de modo "bonitinho"
                @Override
                public int compare(SortedSet<Comparable> o1, SortedSet<Comparable> o2) {
                    int sizeComp = o1.size() - o2.size();
                    if (sizeComp == 0) {
                        Iterator<Comparable> o1iIterator = o1.iterator();
                        Iterator<Comparable> o2iIterator = o2.iterator();
                        while (sizeComp == 0 && o1iIterator.hasNext() ) {
                                sizeComp = o1iIterator.next().compareTo(o2iIterator.next());
                        }
                    }
                    return sizeComp;				
                }
            });
            
            ConjuntoEstados qLinha = new ConjuntoEstados();
            for(int i=0; i< allCombList.size(); i++){
                String nome = allCombList.get(i).toString().replaceAll("[\\[]", "").replaceAll("[\\]]", "");
                qLinha.inclui(new Estado(nome));
            }                
            
            return qLinha;
            
        }
                
        
        private ConjuntoEstados get_FLinha(ConjuntoEstados qLinha){
            Set<String> combEstadosFinais = new HashSet<String>();
            
            //Coloca em "elementosFinais" todos os estados finais do XML que representa o AFN
            ConjuntoEstados elementosFinais = this.getEstadosFinais();
            ArrayList<String> nomeEstados = new ArrayList<String>();
            for (Iterator iter = elementosFinais.getElementos().iterator(); iter.hasNext();) {
                Estado estado = (Estado) iter.next();
                nomeEstados.add(estado.getNome());
            }
            //nomeEstados.add("q2");
            //nomeEstados.add("q3");
            
            String atual="";
            for (Iterator iter = qLinha.getElementos().iterator(); iter.hasNext();) {
                atual = iter.next().toString();
                for(int i=0; i < nomeEstados.size(); i++){
                    if(atual.contains(nomeEstados.get(i)))
                        combEstadosFinais.add(atual);
                }
            }
                        
            ConjuntoEstados fLinha = new ConjuntoEstados();
            for (Iterator iter = combEstadosFinais.iterator(); iter.hasNext();)
                fLinha.inclui(new Estado(iter.next().toString()));
            
            return fLinha;
        }
                
        
        private ConjuntoTransicaoD getConjuntoTransicaoD(ConjuntoEstados qLinha){
            ConjuntoTransicaoD conjTransD = new ConjuntoTransicaoD();
            
            String nomeEstadoQLinha = "";
            
            for(Iterator iter = qLinha.getElementos().iterator(); iter.hasNext();){
                ConjuntoEstados conjEstado = new ConjuntoEstados();
                nomeEstadoQLinha = iter.next().toString();
                String[] nomeEstado = nomeEstadoQLinha.split(", ");
                for(int i=0; i < nomeEstado.length; i++){
                    conjEstado.inclui(new Estado(nomeEstado[i]));
                }
                for(Iterator iterSimbolo = simbolos.iterator(); iterSimbolo.hasNext();){
                    TransicaoD transicaoD = new TransicaoD();
                    String simboloAtual =  iterSimbolo.next().toString();
                    ConjuntoEstados retornoPe = this.pe(conjEstado, simboloAtual);
                                        
                    transicaoD.setOrigem(new Estado(nomeEstadoQLinha));
                    transicaoD.setSimbolo(new Simbolo(simboloAtual.charAt(0)));
                    transicaoD.setDestino(new Estado(retornoPe.toString().replaceAll("\\{", "").replaceAll("\\}", "")));
                    
                    if(!retornoPe.toString().replaceAll("\\{", "").replaceAll("\\}", "").equals(""))
                        conjTransD.inclui(transicaoD);
                    
                }
            }
                        
            return conjTransD;
        }
        
	/*
	 * Cria arquivo XML do AFN com nome de filename.xml
	 * @param filename Nome do arquivo XML que será criado sem a extensão.
	 */
	public void toXML(String filename) throws IOException {
		FileWriter writer = new FileWriter(filename + ".xml");
		PrintWriter saida = new PrintWriter(writer);

		saida.println("<AFN>");
		saida.println();

		saida.println("\t<simbolos>");
		for (Object s : this.getSimbolos().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</simbolos>");
		saida.println();

		saida.println("\t<estados>");
		for (Object s : this.getEstados().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</estados>");
		saida.println();

		saida.println("\t<estadosFinais>");
		for (Object s : this.getEstadosFinais().getElementos()) {
			saida.println("\t\t<elemento valor= \"" + s.toString() + "\"/>");
		}
		saida.println("\t</estadosFinais>");
		saida.println();

		saida.println("\t<funcaoPrograma>");
		for (Iterator iter = this.getFuncaoPrograma().getElementos().iterator(); iter
				.hasNext();) {
			TransicaoN element = (TransicaoN) iter.next();
			ConjuntoEstados estados = element.getDestino();
			for (Iterator iterator = estados.getElementos().iterator(); iterator
					.hasNext();) {
				Estado e = (Estado) iterator.next();
				saida.println("\t\t<elemento origem= \""
						+ element.getOrigem().toString() + "\" destino= \""
						+ e.toString() + "\" simbolo= \""
						+ element.getSimbolo().toString() + "\"/>");
			}
		}
		saida.println("\t</funcaoPrograma>");
		saida.println();

		saida.println("\t<estadoInicial valor= \""
				+ this.getEstadoInicial().toString() + "\"/>");
		saida.println();

		saida.println("</AFN>");

		saida.close();
		writer.close();
	}

        /**
	* Le as informaoces de um AFN em um arquivo XML passado como parametro
	* @param pathArquivo define o arquivo de onde será lido as informacoes do automato
	* @return retorna o automato lido
	*/

	public void ler(String pathArquivo) throws Exception {
		String xmlPathname = pathArquivo;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlPathname);

		Element elem = doc.getDocumentElement();
		NodeList nl0 = elem.getElementsByTagName("simbolos");
		NodeList nl1 = elem.getElementsByTagName("estados");
		NodeList nl2 = elem.getElementsByTagName("estadosFinais");
		NodeList nl3 = elem.getElementsByTagName("funcaoPrograma");
		NodeList nl4 = elem.getElementsByTagName("estadoInicial");

		getChildTagValue(0, (Element) nl0.item(0), "elemento");
		getChildTagValue(1, (Element) nl1.item(0), "elemento");
		getChildTagValue(2, (Element) nl2.item(0), "elemento");
		Element eI = (Element) nl4.item(0);
		estadoInicial = new Estado(eI.getAttribute("valor"));

		getChildTagValue((Element) nl3.item(0), "elemento");

	}
	private void getChildTagValue(int tipo, Element elem, String tagName)
			throws Exception {
		NodeList children = elem.getElementsByTagName(tagName);

		if (children != null) {
			for (int i = 0; i < children.getLength(); i++) {
				Element child = (Element) children.item(i);

				if (child != null) {
					switch (tipo) {
					case 0:
						char[] c = child.getAttribute("valor").toCharArray();
						simbolos.inclui(new Simbolo(c[0]));
						break;
					case 1:
						estados.inclui(new Estado(child.getAttribute("valor")));
						break;
					case 2:
						estadosFinais.inclui(new Estado(child
								.getAttribute("valor")));
						break;
					}
				}
			}
		}
	}
	private void getChildTagValue(Element elem, String tagName)
			throws Exception {
		ConjuntoEstados ce = new ConjuntoEstados();
		TransicaoN transN, transTMP ;
		NodeList children = elem.getElementsByTagName(tagName);
		if (children != null) {
			for (int i = 0; i < children.getLength(); i++) {
				Element child = (Element) children.item(i);
				if (child != null) {
					transN = new TransicaoN();
					transN.setOrigem(new Estado(child.getAttribute("origem")));
					char[] c = child.getAttribute("simbolo").toCharArray();
					transN.setSimbolo(new Simbolo(c[0]));
					for (Iterator iter = funcaoPrograma.iterator(); iter.hasNext();) {
						transTMP = (TransicaoN) iter.next();
						if (transTMP.getOrigem().igual(transN.getOrigem()) &&
							transTMP.getSimbolo().igual(transN.getSimbolo())){
							transN.setDestino(transTMP.getDestino());
							funcaoPrograma.removerElemento(transTMP);
							break;
						}
					}
                                        ce = transN.getDestino();
					ce.inclui(new Estado(child.getAttribute("destino")));
					transN.setDestino(ce);
					funcaoPrograma.inclui(transN);
				}
			}
		}
	}
    
}
