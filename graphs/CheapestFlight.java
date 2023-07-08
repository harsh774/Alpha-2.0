package graphs;

import java.util.*;

public class CheapestFlight {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int CheapestFlightK(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && curr.stops <=
                // k) {
                // dist[v] = dist[u] + wt;

                // q.add(new Info(v, dist[v], curr.stops + 1));
                // }

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;

                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dest];
    }

    public static void main(String[] args) {
        // int n = 4;
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
        // }, { 2, 3, 200 } };
        // int src = 0, dst = 3, k = 1;

        int n = 5;
        int flights[][] = { { 4, 1, 1 }, { 1, 2, 3 }, { 0, 3, 2 }, { 0, 4, 10 }, { 3, 1, 1 }, { 1, 4, 3 } };
        int src = 2;
        int dst = 1;
        int k = 1;
        System.out.println(CheapestFlightK(n, flights, src, dst, k));
    }
}

// leetcode one test case not passed

// class Pair {
// int vertex;
// int cost;

// public Pair(int vertex, int cost) {
// this.vertex = vertex;
// this.cost = cost;
// }
// }

// class Tuple {
// int stops;
// int node;
// int distance;

// Tuple(int stops, int node, int distance) {
// this.stops = stops;
// this.node = node;
// this.distance = distance;
// }
// }
// class Solution {
// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// // Create the adjacency list to represent airports and flights in
// // the form of a graph.
// ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// adjacencyList.add(new ArrayList<>());
// }
// int m = flights.length;
// for (int i = 0; i < m; i++) {
// adjacencyList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
// }
// // Create a queue which stores the node and their distances from the
// // source in the form of {stops, {node, dist}} with ‘stops’ indicating
// // the no. of nodes between src and current node.
// Queue<Tuple> queue = new LinkedList<>();
// queue.add(new Tuple(0, src, 0));

// // Distance array to store the updated distances from the source.
// int[] distances = new int[n];
// for (int i = 0; i < n; i++) {
// distances[i] = Integer.MAX_VALUE;
// }

// distances[src] = 0;

// // Iterate through the graph using a queue, similar to Dijkstra's algorithm,
// // by removing the element with the minimum number of stops first.
// while (!queue.isEmpty()) {
// Tuple current = queue.peek();
// queue.remove();
// int stops = current.stops;
// int currentNode = current.node;
// int currentCost = current.distance;
// // Stop the process as soon as the limit for the number of stops is reached.
// if (stops > k) continue;

// for (Pair neighbor : adjacencyList.get(currentNode)) {
// int adjacentNode = neighbor.vertex;
// int edgeWeight = neighbor.cost;

// // Update the queue and distances array if the new calculated distance is
// // less than the previous distance and the number of stops is within limits.
// if (currentCost + edgeWeight < distances[adjacentNode]) {
// distances[adjacentNode] = currentCost + edgeWeight;
// queue.add(new Tuple(stops + 1, adjacentNode, distances[adjacentNode]));
// }
// }
// }

// // If the destination node is unreachable, return '-1',
// // otherwise return the calculated distance from the source to the
// destination.
// if (distances[dst] == Integer.MAX_VALUE) return -1;
// return distances[dst];
// }
// }