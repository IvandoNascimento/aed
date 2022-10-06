import java.util.*;

public class Dijkstra {
    private Grafo g;
    private int[] distancia;
    private ArrayList<Integer> menorCaminho;

    private boolean[] marca;
    public Dijkstra(Grafo g){
        this.g = g;
        this.marca = new boolean[g.getNumeroVertices()];
        this.distancia = new int[g.getNumeroVertices()];
        this.menorCaminho = new ArrayList<>();

    }

    public void inicializar(){
        for(int i = 0; i < this.g.getNumeroVertices(); ++i) {
            this.marca[i] = false;
            this.distancia[i] = -1;
        }

    }
    public void executar(String s,String d) {
        int c = 0;
        System.out.println("Começando no aeroporto: " + s);
        System.out.println("Destino: " + d);
        int indS = this.g.getIndiceVertice(s);
        int indD = this.g.getIndiceVertice(d);
        this.inicializar();
        this.menorCaminho.add(0);
        PriorityQueue<Integer> fila = new PriorityQueue();
        this.marca[indS] = true;
        this.distancia[indS] = 0;
        fila.add(indS);

        while(fila.size() > 0) {
            ArrayList<Integer> vetoresVizinho = new ArrayList<>();
            ArrayList<Integer> listaVertices = new ArrayList<>();
            int v = (Integer) fila.poll();
            if(v == indD)  {
                break;
            }
            List<Integer> adjacenciaV = this.g.listarAdjacencias(v);
            Iterator var7 = adjacenciaV.iterator();
            System.out.println("origem: " + v);

            while (var7.hasNext()) {
                int u = (Integer) var7.next();
                this.distancia[u] = u;   
                if (!this.marca[u]) {
                    vetoresVizinho.add(this.g.getDistancia(v, u));
                    listaVertices.add(u);   
                }
            }
            //Collections.sort(this.vetoresVizinho);
            int menor = vetoresVizinho.get(0);
            int vertice = listaVertices.get(0);
            for (int i = 1; i < vetoresVizinho.size(); i++) {
                if (menor > vetoresVizinho.get(i)) {
                    menor = vetoresVizinho.get(i);
                    vertice = listaVertices.get(i);
                }
            }
            int proximo = this.g.getDistancia(indD, vertice);
            if(proximo ==0){
                proximo = this.g.getDistancia(indS, vertice);
            }
            int dista = proximo + menor;
            if(adjacenciaV.contains(indD) && dista > this.g.getDistancia(v, indD)) {
                this.menorCaminho.add(this.g.getDistancia(v, indD));
                fila.clear();
            }else{
                this.marca[vertice] = true;
                fila.add(vertice);
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
        System.out.println("");
        System.out.println("menor distancia:"+soma);
    }
}

