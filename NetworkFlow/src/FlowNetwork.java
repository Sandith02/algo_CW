import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private List<List<Edge>> graph;

    public FlowNetwork(int numNodes) {
        graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(to, capacity);
        Edge backward = new Edge(from, 0);

        forward.residual = backward;
        backward.residual = forward;

        graph.get(from).add(forward);
        graph.get(to).add(backward);

    }

    public List<Edge> getEdges (int node) {
        return graph.get(node);
    }

    public int size() {
        return graph.size();
    }

    public void printNetwork() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + ": ");
            for (Edge edge : graph.get(i)) {
                if (edge.capacity > 0) {
                    System.out.println(" " + edge);
                }
            }
        }
    }
}