package automatos;

public class Principal {
	
    public static void main(String[] args) {				
	Principal t = new Principal();		
        //t.faca1();
        //t.faca2();
        t.faca3();
    }

    /**
     *  Esse metodo le o arquivo AFD.XML e imprime
     *  seu conteudo formatado.
     */    
    @SuppressWarnings("empty-statement")
    public void faca1() {
        AFD a = new AFD();
        String w = "abaaaa";
        try {
               a.ler("./src/automatos/AFD.XML");
               System.out.println(a);
               // a.gera(a.getEstadoInicial(), "");
               if (a.Aceita(w))
                   System.out.println("Aceitou "+w);
               System.out.println("Pe(q0,"+w+"):"+a.pe(a.getEstadoInicial(),w));
        } catch (Exception e){
               System.out.println(e); 
        } 
    }

    public void faca2() {
        AFNe a = new AFNe();
        try {
               a.ler("./src/automatos/AFNe.xml");
               System.out.println(a);
               System.out.println(a.fecho_e(a.getEstadoInicial()));
               System.out.println(a.fecho_e_e(a.getEstados()));
               ConjuntoEstados ce = new ConjuntoEstados();
               ce.inclui(a.getEstadoInicial());
               System.out.println(a.pe(ce, "ba"));
        } catch (Exception e){
               System.out.println(e);
        }     
    }
    
    public void faca3() {
        AFN a = new AFN();
        try {
            a.ler("./src/automatos/AFN01.xml");
            System.out.println("AFN:"+ a);
                      
            AFD afd = a.convertToAFD();
            System.out.println("\nAFD:"+ afd);
        } catch (Exception e){
               System.out.println(e);
        }     
    }
}
