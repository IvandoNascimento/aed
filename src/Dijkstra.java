import java.util.*;

public class Dijkstra {
    private Grafo g;
    private int[] distancia;
    private ArrayList<Integer> menorCaminho;
    private ArrayList<Integer> listaVertices;
    private ArrayList<Integer> vetoresVizinho;
    private int[][] teste;
    private boolean[] marca;
    public Dijkstra(Grafo g){
        this.g = g;
        this.marca = new boolean[g.getNumeroVertices()];
        this.distancia = new int[g.getNumeroVertices()];
        this.menorCaminho = new ArrayList<>();
        this.listaVertices =  new ArrayList<>();
        this.teste =  new int[g.getNumeroVertices()][g.getNumeroVertices()];

    }

    public void inicializar(){
        for(int i = 0; i < this.g.getNumeroVertices(); ++i) {
            this.marca[i] = false;
            this.distancia[i] = -1;
            this.vetoresVizinho =  new ArrayList<>();
            this.listaVertices = new ArrayList<>();
            this.teste[i][i] = 0;
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
            this.vetoresVizinho = new ArrayList<>();
            int v = (Integer) fila.poll();
            List<Integer> adjacenciaV = this.g.listarAdjacencias(v);

            //this.listaVertices.add(v);
            Iterator var7 = adjacenciaV.iterator();
            System.out.println("origem: " + v);

            while (var7.hasNext()) {
                int u = (Integer) var7.next();
                this.distancia[u] = u;
                c=u;
                if (!this.marca[u]) {
                    this.marca[u] = true;
                    System.out.println("distancia dos aredor: "+v+","+u+":"+ this.g.getDistancia(v, u));
                    this.vetoresVizinho.add(this.g.getDistancia(v, u));
                    this.listaVertices.add(u);
                    
                }
            }
            //Collections.sort(this.vetoresVizinho);
            int menor = this.vetoresVizinho.get(0);
            int vertice = this.listaVertices.get(0);
            for (int i = 1; i < this.vetoresVizinho.size(); i++) {
                if (menor > this.vetoresVizinho.get(i)) {
                    menor = this.vetoresVizinho.get(i);
                    vertice = this.listaVertices.get(i);
                }
            }
            
            System.out.println("VERTICE: "+this.listaVertices.get(0)+":"+this.distancia[vertice]);
            
            
            if(adjacenciaV.contains(indD) && this.g.getDistancia(v, indD) <= menor){
                System.out.println("contem entao para");
                this.menorCaminho.add(this.g.getDistancia(v, indD));
                fila.clear();
            }else{
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
        System.out.println("menor distancia:"+soma);
        System.out.print("lista dos vertices: ");
        for (Integer vertice : this.listaVertices) {

            System.out.print(vertice + " ");
        }
    }
    public void imprimirDistancia(){
        for(int i = 0; i < this.g.getNumeroVertices(); ++i) {

            for(int j = 0; j < this.g.getNumeroVertices(); ++j) {
                System.out.print(this.teste[i][j] +"\t");

            }

            System.out.println("");
        }

        System.out.println("");
    }
}

