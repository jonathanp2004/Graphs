public class TestClass {

    public  static void main(String[] args){

        int[][] matrix2 = {{0,1,0},{0,0,0},{0,0,0}};
        int[][] matrix = { { 0, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };

        Graph graph = new Graph(matrix);
        Graph graph1 = new Graph(matrix2);

        System.out.println("Graph is weakly connected: " + graph.isWeaklyConnected());
        System.out.println("Graph is weakly connected: " + graph1.isWeaklyConnected());

    }
}
