public class Edge {

    int to;
    int capacity;
    int flow;
    Edge residual;

    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int remainingCapacity() {
        return capacity - flow;
    }

    public void addFlow(int amount) {
        flow += amount;
        residual.flow -= amount;
    }

    @Override
    public String toString() {
        return "→ " + to + " | " + flow + "/" + capacity;
    }
}
