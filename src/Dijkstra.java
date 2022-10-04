import java.util.*;

public class Dijkstra {
    private Grafo g;
    private int[] distancia;
    private ArrayList<Integer> menorCaminho;
    private ArrayList<Integer> listaVertices;
    private ArrayList<Integer> menorDistancia;
    private boolean[] marca;
    public Dijkstra(Grafo g){
        this.g = g;
        this.marca = new boolean[g.getNumeroVertices()];
        this.distancia = new int[g.getNumeroVertices()];
        this.menorCaminho = new ArrayList<>();
        this.listaVertices =  new ArrayList<>();

    }

    public void inicializar(){
        for(int i = 0; i < this.g.getNumeroVertices(); ++i) {
            this.marca[i] = false;
            this.distancia[i] = -1;
            this.menorDistancia =  new ArrayList<>();
        }

    }
    public void executar(String s,String d) {
        int c = 0;
        System.out.println("Começando no aeroporto: " + s);
        System.out.println("Destino: " + d);
        int indS = this.g.getIndiceVertice(s);
        int indD = this.g.getIndiceVertice(d);
        this.inicializar();
        this.menorCaminho.add(indS);
        PriorityQueue<Integer> fila = new PriorityQueue();
        this.marca[indS] = true;
        this.distancia[indS] = 0;
        fila.add(indS);

        while(fila.size() > 0) {
            this.menorDistancia = new ArrayList<>();
            int v = (Integer) fila.poll();
            List<Integer> adjacenciaV = this.g.listarAdjacencias(v);
            this.listaVertices.add(v);
            if (v == indD) {
                System.out.println("final");
                break;

            } else {

                Iterator var7 = adjacenciaV.iterator();
                System.out.println("origem: " + v);

                while (var7.hasNext()) {
                    int u = (Integer) var7.next();
                    this.distancia[u] = u;
                    c=u;
                    if (!this.marca[u]) {
                        this.marca[u] = true;
                        System.out.println("distancia dos aredor: " + this.g.getDistancia(v, u));
                        this.menorDistancia.add(this.g.getDistancia(v, u));
                    }


                }

                int menor = this.menorDistancia.get(0);
                for (int i = 1; i < this.menorDistancia.size(); i++) {
                    if (menor > this.menorDistancia.get(i)) {
                        menor = this.menorDistancia.get(i);

                    }
                }

                fila.add(this.distancia[c]);
                System.out.println("menor:"+menor);
                this.menorCaminho.add(menor);
            }
        }
    }
    public void imprimir(){
        int[] dist;

        int tam = (dist = this.distancia).length;
        int d;
        for(int i = 0; i < tam; ++i) {
            d = dist[i];
            System.out.print(d + " ");
        }
        System.out.println("");

        int soma=0;
        for (Integer vertice : this.menorCaminho) {
            soma+=vertice;
            System.out.print(vertice + " ");
        }
        System.out.println("menor distancia:"+soma);
        System.out.print("lista dos vertices: ");
        for (Integer vertice : this.listaVertices) {

            System.out.print(vertice + " ");
        }
    }
}

