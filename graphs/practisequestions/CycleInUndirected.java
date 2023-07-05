package graphs.practisequestions;

import java.util.*;

public class CycleInUndirected {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    static void addEdge(ArrayList<Integer> adj[], int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public static boolean isCycle(ArrayList<Integer> adj[], int V) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleUtil(adj, i, V, vis)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Integer>[] adj, int cur, int V, boolean[] vis) {
        int[] par = new int[V];
        Arrays.fill(par, -1);
        Queue<Integer> q = new LinkedList<>();
        vis[cur] = true;
        q.add(cur);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                    par[v] = u;
                } else if (par[u] != v) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 10;
        ArrayList<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        addEdge(adj, 1, 5);
        addEdge(adj, 1, 9);

        addEdge(adj, 2, 4);
        addEdge(adj, 5, 2);
        addEdge(adj, 9, 5);

        if (isCycle(adj, V)) {
            System.out.println("Cycle Exists..");
        } else {
            System.out.println("No cycle found!!");
        }
    }
}
