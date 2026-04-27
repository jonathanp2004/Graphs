
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


    public boolean isWeaklyConnected(){

        boolean[] discoveredSet = new boolean[matrix.length];
        Queue<Integer> frontierQueue = new LinkedList<>();

        frontierQueue.add(0);
        discoveredSet[0] = true;

        while(frontierQueue.size() > 0){
            Integer currentNode = frontierQueue.remove();

            for (int i = 0; i < matrix.length; i++) {

                if(discoveredSet[i] == false && (matrix[currentNode][i] == 1||matrix[i][currentNode]==1)){
                    frontierQueue.add(i);

                    discoveredSet[i] = true;

                }
                
            }

        }
        for (int i = 0; i < discoveredSet.length; i++) {
            if (discoveredSet[i] == false){
                return false;

            }
        }
        return true;

    }

    public void printAllCycles(){
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> path = new ArrayList<>();
            findCycles(i,i, 0, path);
        }
    }

    public void findCycles(int current, int start, int depth, List<Integer> path){
        if(depth == 4){
            if(current == start){
                System.out.print(start+ " - ");
                for(int node: path) {
                    System.out.print(node + " - ");
                }
                System.out.println(start);
            }
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[current][i] != 0 ){
                path.add(i);
                findCycles(i, start, depth+1, path);
                path.remove(path.size()-1);
            }
        }

    }
}






