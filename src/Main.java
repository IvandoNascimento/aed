

public class Main {
    public static void main(String[] args) {


        Grafo g = new GrafoMatricial(4);
        g.imprimir();

        g.adicionarVertice("GRU");
        g.adicionarVertice("SDU");
        g.adicionarVertice("BSB");
        g.adicionarVertice("REC");
        g.adicionarAresta("GRU","BSB",863);
        g.adicionarAresta("SDU","GRU",347);
        g.adicionarAresta("REC","BSB",1672);
        g.imprimir();
        ((GrafoMatricial) g).imprimirDistancia("GRU","BSB");
        ((GrafoMatricial) g).imprimirDistancia("SDU","GRU");
        ((GrafoMatricial) g).imprimirDistancia("REC","BSB");


        BuscaLargura b = new BuscaLargura(g);
        b.execute("GRU");
        //System.out.println(g);
        b.imprimir();
        b.execute("REC");
        b.imprimir();

        Kruskal k = new Kruskal(g);
        k.inicializar();
        k.imprimir();
        k.execute();

    }
}