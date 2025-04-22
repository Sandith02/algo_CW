public class FordFulkerson {

    private boolean[] visited;

    public int findMaxFlow(FlowNetwork network, int source, int sink) {
        int maxFlow = 0;

        while (true) {
            visited = new boolean[network.size()];

            // Try to find one augmenting path using DFS
            int flow = dfs(network, source, sink, Integer.MAX_VALUE);

            if (flow == 0) break; // No more paths found

            maxFlow += flow;
        }

        return maxFlow;
    }

    private int dfs(FlowNetwork network, int current, int sink, int flow) {
        if (current == sink) return flow;

        visited[current] = true;

        for (Edge edge : network.getEdges(current)) {
            if (!visited[edge.to] && edge.remainingCapacity() > 0) {
                int bottleneck = dfs(network, edge.to, sink, Math.min(flow, edge.remainingCapacity()));
                if (bottleneck > 0) {
                    edge.addFlow(bottleneck);
                    return bottleneck;
                }
            }
        }

        return 0;
    }
}
