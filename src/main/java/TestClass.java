public class TestClass {

    public  static void main(String[] args){


        //Test matrices
        int[][] matrix2 = {{0,1,0},{0,0,0},{0,0,0}};
        int[][] matrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        //Given input from hw (Test for drawGraph)
        String s = "ANT CUN BOG AMA DC TOL SAN";
        Graph g = new Graph(0);
        g.drawGraph(s);
        //Test for checking if graph is weakly connected
        Graph graph = new Graph(matrix);
        Graph graph1 = new Graph(matrix2);
        System.out.println("Graph is weakly connected: " + graph.isWeaklyConnected());
        System.out.println("Graph is weakly connected: " + graph1.isWeaklyConnected());
        graph.printAllCycles();
    }


}