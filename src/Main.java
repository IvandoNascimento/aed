import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Grafo g = new GrafoMatricial(9);

        g.adicionarVertice("GRU"); //0
        g.adicionarVertice("BSB"); //1
        g.adicionarVertice("SDU"); //2
        g.adicionarVertice("REC"); //3
        g.adicionarVertice("POA"); //4
        g.adicionarVertice("VCP"); //5
        g.adicionarVertice("CGB"); //6
        g.adicionarVertice("RBR"); //7
        g.adicionarVertice("MCP"); //8
        g.adicionarAresta("GRU","BSB",863); //1
        g.adicionarAresta("SDU","GRU",347); //2
        g.adicionarAresta("REC","BSB",1672); //3
        g.adicionarAresta("REC","SDU",1887); //4
        g.adicionarAresta("GRU", "REC", 2126); //5
        g.adicionarAresta("VCP","POA",834); //6
        g.adicionarAresta("BSB", "POA", 1620); //7
        g.adicionarAresta("CGB", "VCP", 1258);//8
        g.adicionarAresta("REC", "CGB", 2487); //9
        g.adicionarAresta("RBR", "REC", 3660); //10
        g.adicionarAresta("RBR","SDU", 3036); //11
        g.adicionarAresta("CGB","RBR", 1440); //12
        g.adicionarAresta("MCP","BSB", 1820);// 13
        g.adicionarAresta("MCP","REC", 2023); //14
        g.adicionarAresta("MCP", "RBR", 2180);//15
        g.adicionarAresta("POA", "CGB", 1687);//16
        g.imprimirDistancia();
        g.imprimirMapa();

        //Dijkstra d = new Dijkstra(g);

        String partida,destino,opt;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        opt = "N";
        while(opt.equals("N")) {
            Dijkstra d = new Dijkstra(g);
            System.out.println("Digite o aeroporto de partida");
            partida = sc.next();
            System.out.println("Digite o aeroporto de destino");
            destino = sc.next();
            d.inicializar();
            d.executar(partida, destino);
            d.imprimir();

            g.imprimirMapa();
            System.out.println("Sair ? S/N");
            opt = sc1.next();
            System.out.println("");

        }
    }
}