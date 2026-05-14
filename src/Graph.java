import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Integer>> adjacencyList;
    private List<Edge> edges;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.put(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            System.out.println("One of the vertices does not exist");
            return;
        }

        adjacencyList.get(from).add(to);

        Vertex source = vertices.get(from);
        Vertex destination = vertices.get(to);

        Edge edge = new Edge(source, destination);
        edges.add(edge);
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");

        for (int vertexId : adjacencyList.keySet()) {
            System.out.print("AdjList[" + vertexId + "] = ");

            List<Integer> neighbours = adjacencyList.get(vertexId);

            System.out.print("(");

            for (int i = 0; i < neighbours.size(); i++) {
                System.out.print(neighbours.get(i));

                if (i < neighbours.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex does not exist");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS order: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            List<Integer> neighbours = adjacencyList.get(current);

            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex does not exist");
            return;
        }

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS order: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        List<Integer> neighbours = adjacencyList.get(current);

        for (int neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited);
            }
        }
    }

    public void bfsWithoutPrint(int start) {
        if (!vertices.containsKey(start)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            List<Integer> neighbours = adjacencyList.get(current);

            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public void dfsWithoutPrint(int start) {
        if (!vertices.containsKey(start)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        dfsHelperWithoutPrint(start, visited);
    }

    private void dfsHelperWithoutPrint(int current, Set<Integer> visited) {
        visited.add(current);

        List<Integer> neighbours = adjacencyList.get(current);

        for (int neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                dfsHelperWithoutPrint(neighbour, visited);
            }
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }
}