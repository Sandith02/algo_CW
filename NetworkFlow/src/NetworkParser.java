import java.io.*;
import java.util.*;

public class NetworkParser {

    public static FlowNetwork parseFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int numNodes = Integer.parseInt(reader.readLine().trim());

        FlowNetwork network = new FlowNetwork(numNodes);

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split("\\s+");
            if (parts.length != 3) continue;

            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);

            network.addEdge(from, to, capacity);
        }
        reader.close();
        return network;
    }

}