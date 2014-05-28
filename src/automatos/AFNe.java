/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatos;

import java.util.Iterator;

/**
 * Automatos nao deterministicos com cadeia vazia
 * @author Ciro
 */
public class AFNe extends AFN{
    @Override
    public ConjuntoEstados pe(ConjuntoEstados ce, String w){
        ConjuntoEstados c1=new ConjuntoEstados();
        if (w.isEmpty())
            return fecho_e_e(ce);
        else{
            ConjuntoEstados c2 = pe(ce,w.substring(0, w.length()-1));
            Iterator i = c2.iterator();
            while (i.hasNext()){
                c1=c1.uniao(p((Estado)i.next(),new Simbolo(w.charAt(w.length()-1))));
            }
            return fecho_e_e(c1);
        }
    }
    public ConjuntoEstados fecho_e(Estado e){
        ConjuntoEstados ce1 = new ConjuntoEstados();
        ConjuntoEstados ce2 = new ConjuntoEstados();
        ConjuntoEstados ce3 = new ConjuntoEstados();
        if(p(e,Simbolo.VAZIA).vazio()){
            ce1.inclui(e);
            return ce1;
        };
        ce1.inclui(e);
        ce2 = p(e,Simbolo.VAZIA);
        ce1=ce1.uniao(ce2);
        Iterator i = ce2.iterator();
        while (i.hasNext()){
            ce1=ce1.uniao(fecho_e((Estado)i.next()));
        }
        return ce1;
    }
    public ConjuntoEstados fecho_e_e(ConjuntoEstados ce){
        ConjuntoEstados ce1 = new ConjuntoEstados();
        Iterator i = ce.iterator();
        while(i.hasNext()){
            ce1=ce1.uniao(fecho_e((Estado)i.next()));
        }
        return ce1;
    }
}
