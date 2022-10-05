

public class Main {
    public static void main(String[] args) {


        Grafo g = new GrafoMatricial(4);
        //g.imprimir();

        g.adicionarVertice("GRU"); //0
        g.adicionarVertice("BSB"); //1
        g.adicionarVertice("SDU"); //2
        g.adicionarVertice("REC"); //3
        //g.adicionarVertice("MUT");
        g.adicionarAresta("GRU","BSB",863);
        g.adicionarAresta("SDU","GRU",347);
        g.adicionarAresta("REC","BSB",1672);
        g.adicionarAresta("REC","SDU",1887);
        //g.adicionarAresta("GRU", "REC", 5000);
        //g.adicionarAresta("MUT","SDU",1500);
        g.imprimir();
        g.imprimirDistancia();
        g.imprimirMapa();
        /*
        BuscaLargura b = new BuscaLargura(g);
        b.execute("GRU");
        b.imprimir();
        g.imprimirMapa();
        //System.out.println(g);

        b.execute("REC");
        b.imprimir();

        Kruskal k = new Kruskal(g);
        k.inicializar();
        k.imprimir();
        //k.execute();
        */
        Dijkstra d = new Dijkstra(g);
        d.executar("GRU","REC");
        d.imprimir();
        System.out.println("");
        d.imprimirDistancia();
        //d.executar("GRU","BSB");
        //d.imprimir();
        //d.executar("GRU","MUT");
        //d.imprimir();


    }
}