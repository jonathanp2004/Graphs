
import java.util.LinkedList;
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




}






