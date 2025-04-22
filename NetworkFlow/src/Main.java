import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FlowNetwork network = NetworkParser.parseFromFile("benchmarks/ladder_1.txt");
            network.printNetwork();
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }
    }
}
