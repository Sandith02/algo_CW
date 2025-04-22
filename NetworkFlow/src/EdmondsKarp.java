import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {

    public int findMaxFlow(FlowNetwork network, int source, int sink) {
        int maxFlow = 0;

        while (true) {
            int[] parent = new int[network.size()];
            Edge[] parentEdge = new Edge[network.size()];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = -1;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            parent[source] = source;

            while (!queue.isEmpty() && parent[sink] == -1) {
                int current = queue.poll();

                for (Edge edge : network.getEdges(current)) {
                    if (parent[edge.to] == -1 && edge.remainingCapacity() > 0) {
                        parent[edge.to] = current;
                        parentEdge[edge.to] = edge;
                        queue.add(edge.to);
                    }
                }
            }

            if (parent[sink] == -1) {
                break;
            }

            int bottleneck = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                bottleneck = Math.min(bottleneck, parentEdge[v].remainingCapacity());
            }

            for (int v = sink; v != source; v = parent[v]) {
                parentEdge[v].addFlow(bottleneck);
            }

            maxFlow += bottleneck;
        }

        return maxFlow;
    }
}