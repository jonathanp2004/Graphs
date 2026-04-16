import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    int[][] matrix;

    Graph(int size){
        matrix = new int[size][size];

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


    public void isWeaklyConnected(){
        boolean[] visited = new boolean[matrix.length];

        HashSet<Node> discoveredSet = new HashSet<>();
        Queue<Node> frontierQueue = new LinkedList<>();







    }


}






