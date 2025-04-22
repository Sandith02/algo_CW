public class Main {
    public static void main(String[] args) {
        try {
            FlowNetwork network = NetworkParser.parseFromFile("benchmarks/ladder_5.txt");

            FordFulkerson solver = new FordFulkerson();
            int maxFlow = solver.findMaxFlow(network, 0, 5); // source = 0, sink = 5

            System.out.println("Maximum Flow: " + maxFlow);
            System.out.println("Final Network State:");
            network.printNetwork(); // Optional: see flow values

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
