public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("Graph size: " + g.getVertexCount() + " vertices");
        System.out.println("Edges: " + g.getEdgeCount());

        long startBfs = System.nanoTime();

        if (g.getVertexCount() == 10) {
            g.bfs(0);
        } else {
            g.bfsWithoutPrint(0);
        }

        long endBfs = System.nanoTime();
        long bfsTime = endBfs - startBfs;

        long startDfs = System.nanoTime();

        if (g.getVertexCount() == 10) {
            g.dfs(0);
        } else {
            g.dfsWithoutPrint(0);
        }

        long endDfs = System.nanoTime();
        long dfsTime = endDfs - startDfs;

        System.out.println("BFS time: " + bfsTime + " ns");
        System.out.println("DFS time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {
        Graph smallGraph = createGraph(10);
        Graph mediumGraph = createGraph(30);
        Graph largeGraph = createGraph(100);

        System.out.println("SMALL GRAPH");
        smallGraph.printGraph();
        runTraversals(smallGraph);

        System.out.println();

        System.out.println("MEDIUM GRAPH");
        runTraversals(mediumGraph);

        System.out.println();

        System.out.println("LARGE GRAPH");
        runTraversals(largeGraph);
    }

    public void printResults() {
        System.out.println("All experiments are completed.");
    }

    private Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        if (size == 10) {
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(0, 3);

            graph.addEdge(1, 4);
            graph.addEdge(1, 5);

            graph.addEdge(2, 5);
            graph.addEdge(2, 6);

            graph.addEdge(3, 6);
            graph.addEdge(3, 7);

            graph.addEdge(4, 8);
            graph.addEdge(5, 8);

            graph.addEdge(6, 9);
            graph.addEdge(7, 9);
        } else {
            for (int i = 0; i < size - 1; i++) {
                graph.addEdge(i, i + 1);
            }

            for (int i = 0; i < size - 2; i++) {
                graph.addEdge(i, i + 2);
            }

            for (int i = 0; i < size - 5; i += 5) {
                graph.addEdge(i, i + 5);
            }
        }

        return graph;
    }
}