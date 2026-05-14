# Assignment 4: Graph Traversal and Representation System

## A. Project Overview

This project implements a graph traversal system in Java.

A graph consists of vertices and edges. A vertex is a node, and an edge is a connection between two vertices. In this project, I used a directed graph. This means that an edge has a direction. For example, `7 -> 9` means that we can move from vertex 7 to vertex 9, but not automatically from 9 to 7.

The graph is represented using an adjacency list. In an adjacency list, each vertex stores a list of its connected vertices.

Example:

```text
AdjList[0] = (1, 2, 3)
AdjList[1] = (4, 5)
AdjList[2] = (5, 6)
```

The project implements two traversal algorithms:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The program tests three graph sizes:

- Small graph: 10 vertices
- Medium graph: 30 vertices
- Large graph: 100 vertices

For the small graph, the program prints the graph structure and traversal order. For medium and large graphs, it prints only execution time to keep the output readable.

---

## B. Class Descriptions

### Vertex Class

The `Vertex` class represents one node in the graph.

It has:

- private field `id`
- constructor
- getter `getId()`
- `toString()` method

The `id` is used as a unique identifier for each vertex.

---

### Edge Class

The `Edge` class represents a connection between two vertices.

It has:

- `source` — starting vertex
- `destination` — ending vertex
- constructor
- getter methods
- `toString()` method

Example:

```text
1 -> 4
```

This means there is an edge from vertex 1 to vertex 4.

---

### Graph Class

The `Graph` class stores the graph structure.

It uses:

```java
Map<Integer, Vertex> vertices;
Map<Integer, List<Integer>> adjacencyList;
List<Edge> edges;
```

The `vertices` map stores all vertices by id.  
The `adjacencyList` stores connected vertices for each vertex.  
The `edges` list stores all edges.

Main methods:

- `addVertex(Vertex v)` — adds a vertex
- `addEdge(int from, int to)` — adds a directed edge
- `printGraph()` — prints adjacency list
- `bfs(int start)` — runs BFS
- `dfs(int start)` — runs DFS

The class also has `bfsWithoutPrint()` and `dfsWithoutPrint()` for medium and large graphs. These methods run traversal without printing long output.

---

### Experiment Class

The `Experiment` class creates graphs and runs tests.

It has:

- `runTraversals(Graph g)`
- `runMultipleTests()`
- `printResults()`

The program creates:

```java
Graph smallGraph = createGraph(10);
Graph mediumGraph = createGraph(30);
Graph largeGraph = createGraph(100);
```

The method `runTraversals()` runs BFS and DFS from vertex 0 and measures time using:

```java
long start = System.nanoTime();
long end = System.nanoTime();
```

---

### Main Class

The `Main` class starts the program.

It creates an `Experiment` object and runs all tests:

```java
Experiment experiment = new Experiment();

experiment.runMultipleTests();
experiment.printResults();
```

---

## C. Algorithm Descriptions

## Breadth-First Search BFS

BFS visits vertices level by level.

It starts from one vertex, visits all direct neighbours first, and then visits the neighbours of those neighbours.

BFS uses a queue.

### BFS Steps

1. Start from a selected vertex.
2. Mark it as visited.
3. Add it to the queue.
4. Take the first vertex from the queue.
5. Visit all unvisited neighbours.
6. Add those neighbours to the queue.
7. Repeat until the queue is empty.

### BFS Use Cases

BFS is useful when we need to find the shortest path in an unweighted graph. It is also useful for exploring a graph level by level.

### BFS Time Complexity

```text
O(V + E)
```

where `V` is the number of vertices and `E` is the number of edges.

---

## Depth-First Search DFS

DFS goes as deep as possible before backtracking.

It starts from one vertex, visits one neighbour, then visits the neighbour of that neighbour, and continues deeper.

DFS in this project uses recursion.

### DFS Steps

1. Start from a selected vertex.
2. Mark it as visited.
3. Visit the first unvisited neighbour.
4. Continue deeper using recursion.
5. If there are no unvisited neighbours, go back.
6. Repeat until all reachable vertices are visited.

### DFS Use Cases

DFS is useful for exploring paths, checking connectivity, detecting cycles, and finding connected components.

### DFS Time Complexity

```text
O(V + E)
```

where `V` is the number of vertices and `E` is the number of edges.

---

## D. Experimental Results

The program was tested on three graph sizes: 10, 30, and 100 vertices.

The small graph was created manually to show the difference between BFS and DFS traversal order.  
The medium and large graphs were generated using loops.

| Graph Size | Number of Edges | BFS Time | DFS Time |
|---|---:|---:|---:|
| 10 vertices | 13 | 15900 ns | 10500 ns |
| 30 vertices | 62 | 88100 ns | 37800 ns |
| 100 vertices | 216 | 139400 ns | 87500 ns |

### Small Graph Output

```text
SMALL GRAPH
Graph adjacency list:
AdjList[0] = (1, 2, 3)
AdjList[1] = (4, 5)
AdjList[2] = (5, 6)
AdjList[3] = (6, 7)
AdjList[4] = (8)
AdjList[5] = (8)
AdjList[6] = (9)
AdjList[7] = (9)
AdjList[8] = ()
AdjList[9] = ()

Graph size: 10 vertices
Edges: 13
BFS order: 0 1 2 3 4 5 6 7 8 9
DFS order: 0 1 4 8 5 2 6 9 3 7
```

### Observations

When the graph size increases, execution time usually increases too. This happens because BFS and DFS need to process more vertices and edges.

BFS and DFS have different traversal orders. BFS visits vertices level by level, while DFS goes deeper first.

For medium and large graphs, traversal order was not printed because the output would be too long. Only execution time was printed for comparison.

---

## Analysis Questions

### 1. How does graph size affect BFS and DFS performance?

When graph size increases, BFS and DFS usually take more time. This is because there are more vertices and edges to visit.

### 2. Which traversal is faster in your experiments?

In my experiments, the faster traversal depends on the graph size and computer performance. Sometimes BFS can be faster, and sometimes DFS can be faster. The difference is usually small because both algorithms have the same time complexity.

### 3. Do results match the expected complexity O(V + E)?

Yes, the results match `O(V + E)`. Both algorithms visit vertices and check edges, so when the number of vertices and edges increases, running time also increases.

### 4. How does graph structure affect traversal order?

Graph structure affects traversal order because BFS and DFS choose the next vertex differently. BFS uses a queue and visits by levels. DFS uses recursion and goes deeper first.

In the small graph:

```text
BFS: 0 1 2 3 4 5 6 7 8 9
DFS: 0 1 4 8 5 2 6 9 3 7
```

### 5. When is BFS preferred over DFS?

BFS is preferred when we need the shortest path in an unweighted graph. It is also useful when we want to explore a graph level by level.

### 6. What are the limitations of DFS?

DFS can go very deep before checking other paths. It does not always find the shortest path. Recursive DFS can also cause stack overflow for very large or deep graphs.

---

## E. Screenshots

### Graph Structure Output

![Graph Structure](docs/screenshots/graph_structure.png)

### BFS Traversal Output

![BFS Output](docs/screenshots/bfs_output.png)

### DFS Traversal Output

![DFS Output](docs/screenshots/dfs_output.png)

### Performance Results

![Performance Results](docs/screenshots/performance_results.png)

---

## F. Reflection

In this assignment, I learned how to represent a graph using an adjacency list. I understood that a graph consists of vertices and edges, and each vertex can store a list of connected vertices.

I also learned the difference between BFS and DFS. BFS uses a queue and visits vertices level by level. DFS uses recursion and goes deeper before backtracking.

In my experiments, DFS was faster than BFS for all graph sizes. This may happen because BFS uses a queue, while DFS in my implementation uses recursion. Queue operations can add small overhead. However, both algorithms still have the same expected time complexity O(V + E), so the difference is implementation-dependent and can vary between runs.

The main challenge was understanding how the `visited` set works. It prevents the program from visiting the same vertex many times. Another challenge was creating graphs of different sizes for testing.

Overall, this project helped me understand graph traversal, adjacency list representation, and basic performance analysis using `System.nanoTime()`.