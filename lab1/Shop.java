import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class Shop {

    private final List<Server> servers;


    public Shop(int numServers) {
        servers = Optional.of(numServers)
                .filter(n -> n > 0) //check if shop is empty
                .map(n -> IntStream.rangeClosed(1,n)
                        .boxed()
                        .map(x -> new Server(x))
                        .toList()
                        
                    )

                .orElse(List.of());
    }

    public Shop(List<Server> servers) {
        this.servers = servers;
    }


    //find the first server that can serve
    Optional<Server> findServer(Customer customer) {
        return servers.stream()
            .filter(server -> server.canServe(customer))
            .findFirst();
    }

    Shop update(Server server) {
        return new Shop(servers.stream()
                .map(s -> s.matches(server) ? server : s)
                .toList());
    }

    public String toString() {
        return servers.toString();
    }

}
