

public class Main {
    public static void main(String[] args) {


        Grafo g = new GrafoMatricial(9);
        //g.imprimir();

        g.adicionarVertice("GRU"); //0
        g.adicionarVertice("BSB"); //1
        g.adicionarVertice("SDU"); //2
        g.adicionarVertice("REC"); //3
        g.adicionarVertice("MUT"); //4
        g.adicionarVertice("VCP"); //5
        g.adicionarVertice("CGB"); //6
        g.adicionarVertice("RBR"); //7
        g.adicionarVertice("MCP"); //8
        g.adicionarAresta("GRU","BSB",863);
        g.adicionarAresta("SDU","GRU",347);
        g.adicionarAresta("REC","BSB",1672);
        g.adicionarAresta("REC","SDU",1887);
        g.adicionarAresta("GRU", "REC", 2126);
        g.adicionarAresta("GRU","MUT",1500);
        g.adicionarAresta("VCP", "REC", 2123);
        g.adicionarAresta("BSB", "VCP", 802);//
        g.adicionarAresta("CGB", "VCP", 1258);//
        g.adicionarAresta("REC", "CGB", 2487);
        g.adicionarAresta("RBR", "REC", 3660);
        g.adicionarAresta("RBR","SDU", 3036);
        g.adicionarAresta("CGB","RBR", 1440);
        g.adicionarAresta("MCP","BSB", 1820);//
        g.adicionarAresta("MCP","GRU", 2680);
        //g.imprimir();
        //g.imprimirDistancia();
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
        d.executar("MCP","CGB");
        d.imprimir();
        System.out.println("");
        //d.imprimirDistancia();
        //d.executar("GRU","BSB");
        //d.imprimir();
        //d.executar("GRU","MUT");
        //d.imprimir();


    }
}