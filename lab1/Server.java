import java.util.stream.Stream;

class Server {
    private final int serverIndex;
    private final double nextAvailableTime;

    public Server(int index) {
        this.serverIndex = index;
        this.nextAvailableTime = 0.0;
    }

    public Server(int index, double availableTime) {
        this.serverIndex = index;
        this.nextAvailableTime = availableTime;
    }

    Server serve(Customer customer, double servingTime) {
 
        double arrTime = customer.serveTill(0.0);
        double nextTiming = arrTime + servingTime;

        return new Server(this.serverIndex, nextTiming); 

    }

    boolean canServe(Customer customer) {
    
        return customer.canBeServed(nextAvailableTime);
    }

   
    boolean matches(Server server) {
        return this.serverIndex == server.serverIndex;
    }


    @Override
    public String toString() {
        return "server " + serverIndex; 
    }


}



