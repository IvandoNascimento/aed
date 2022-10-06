import java.util.*;

public class Dijkstra {
    private Grafo g;
    private int[] distancia;
    private ArrayList<Integer> menorCaminho;
    private ArrayList<Integer> listaCaminho;

    private boolean[] marca;
    public Dijkstra(Grafo g){
        this.g = g;
        this.marca = new boolean[g.getNumeroVertices()];
        this.distancia = new int[g.getNumeroVertices()];
        this.menorCaminho = new ArrayList<>();
        this.listaCaminho = new ArrayList<>();
    }

    public void inicializar(){
        for(int i = 0; i < this.g.getNumeroVertices(); ++i) {
            this.marca[i] = false;
            this.distancia[i] = -1;
            this.menorCaminho = new ArrayList<>();
            this.listaCaminho = new ArrayList<>();
        }

    }
    public void executar(String s,String d) {
        System.out.println("Começando no aeroporto: " + s);
        System.out.println("Destino: " + d);
        int indS = this.g.getIndiceVertice(s);
        int indD = this.g.getIndiceVertice(d);
        this.inicializar();
        this.listaCaminho.add(indS);
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

            while (var7.hasNext()) {
                int u = (Integer) var7.next();
                this.distancia[u] = u;   
                if (!this.marca[u]) {
                    vetoresVizinho.add(this.g.getDistancia(v, u));

                    listaVertices.add(u);   
                }
            }

            int menor = vetoresVizinho.get(0);
            int vertice = listaVertices.get(0);
            System.out.println("menor:"+ menor);

            int proximo = this.g.getDistancia(indD, vertice);
            //System.out.println(proximo);
            for (int i = 0; i < listaVertices.size(); i++) {
                if(proximo==0){
                    proximo = this.g.getDistancia(indD, i);
                    //System.out.println(proximo);
                }
            }
            System.out.println("proximo fora do for"+proximo);
            if(proximo==0){
                for (int i = 0; i < listaVertices.size(); i++) {
                    if(proximo==0){
                        proximo = this.g.getDistancia(vertice, i);
                        //System.out.println(proximo);
                    }else{
                        break;
                    }
                }
            }
            //System.out.println("proximo fora do for seg"+proximo);
            int dista = proximo + menor;

            if(adjacenciaV.contains(indD) && dista > this.g.getDistancia(v, indD)) {
                this.menorCaminho.add(this.g.getDistancia(v, indD));
                this.listaCaminho.add(indD);
                fila.clear();
            }else{
                this.marca[vertice] = true;
                fila.add(vertice);

                this.menorCaminho.add(menor);
                this.listaCaminho.add(vertice);
            }
        }
    }

    public void imprimir(){
        int[] dist;
        /*
        int tam = (dist = this.distancia).length;
        int d;
        for(int i = 0; i < tam; ++i) {
            d = dist[i];
            System.out.print(d + " ");
        }

         */
        System.out.println("");
        System.out.print("menor caminho: ");
        for (Integer vertice : this.listaCaminho) {
            System.out.print(vertice + " ");
        }
        System.out.println("");
        int soma=0;
        for (Integer vertice : this.menorCaminho) {
            soma+=vertice;
            System.out.print(vertice + " ");
        }
        System.out.println("Distancia: "+soma+"km");
    }
}

