
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    int[][] matrix;
    Node root;

    Graph(int size){
        matrix = new int[size][size];
    }
    Graph(int[][] matrix){
        this.matrix = matrix;
    }

    public void addNode(Node node){

    }

    public void addEdge(int src, int dst){

        //src is row
        matrix[src][dst] = 1;

    }


    public boolean checkEdge(int src, int dst){
        if(matrix[src][dst] != 0){
            return true;
        }
        return false;
    }

    //weakly means u-v path for every u,v if direction ignored

    //Problem 4 (This is using BFS!)
    public boolean isWeaklyConnected(){
        boolean[] discoveredSet = new boolean[matrix.length];
        Queue<Integer> frontierQueue = new LinkedList<>();

        //Space would be O(V) because at most we add V number of vertices to the Queue and list
        frontierQueue.add(0);
        discoveredSet[0] = true;
        //O(V) because at most we visit all vertices, add
        while(frontierQueue.size() > 0){
            Integer currentNode = frontierQueue.remove();
            //O(V) because we go through all vertices
            for (int i = 0; i < matrix.length; i++) {
                if(discoveredSet[i] == false && (matrix[currentNode][i] == 1||matrix[i][currentNode]==1)){
                    frontierQueue.add(i);
                    discoveredSet[i] = true;

                }
            }
        }

        //O(V) since we go through whole discovered set worst case
        for (int i = 0; i < discoveredSet.length; i++) {
            if (discoveredSet[i] == false){
                return false;

            }
        }
        return true;

    }


    //Problem 5
    public void printAllCycles(){
        //O(V)
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> path = new ArrayList<>();
            //
            findCycles(i,i, 0, path);
        }
    }

    public void findCycles(int current, int start, int depth, List<Integer> path){

        if(depth == 4){
            if(current == start){
                System.out.print(start+ " - ");
                //O(4) so constant
                for(int node: path) {
                    System.out.print(node + " - ");
                }
                System.out.println(start);
            }
            return;
        }

        //O(V) exploring all neighbors,even if cell = 0
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[current][i] != 0 ){
                path.add(i);
                /*For every recursive call, we explore,meaning for each recursive(each neighbor)
                 call we do V amount of work because of the for loop.
                 Do note we do the recursive calls
                */
                //O(V)
                findCycles(i, start, depth+1, path);
                path.remove(path.size()-1);

            }
        }

    }

    //Problem 6

    //Build graph from given string s
    public Graph buildGraph(String s){
        String[] vertices = s.split(" ");
        int n = vertices.length;
        Graph g = new Graph(n);

        for (int i = 0; i < n; i++) {
            g.addEdge(i,(2*i+1)%n);
            g.addEdge(i,(2*i+2)%n);
        }
        return g;
    }

    // Draw adjacency matrix representation of graph
    public void drawGraph(String s){
        Graph g = buildGraph(s);
        String[] vertices = s.split(" ");
        g.printMatrix(vertices);
    }

    //helper method for printing
    public void printMatrix(String[] vertices){
        System.out.print("   ");
        for(String v : vertices){
            System.out.print(v + " ");
        }
        System.out.println();
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < vertices.length ; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}






