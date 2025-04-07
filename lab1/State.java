import java.util.Optional;


class State {
    private final Shop shop;
    private final Optional<Customer> customer;

    public State(Shop shop) {
        this.shop = shop;
        this.customer = Optional.empty();
    }

    public State(Shop shop, Customer customer) {
        this.shop = shop;
        this.customer = Optional.of(customer);
        System.out.println(customer + " arrives");
    }

    private Optional<Customer> getCustomer() {
        return this.customer;
    }

    State next(State nextState) {

        Shop updatedShop = nextState.getCustomer()
            .flatMap(cust -> this.shop
                    .findServer(cust)
                    .map(server -> {

                        System.out.println(cust + " served by " + server);
                        return server.serve(cust,1.0);
                    
                    }))
            .map(updatedServer -> this.shop
                    .update(updatedServer))                                                 

            .orElseGet(() -> {
                
                nextState.customer.ifPresent(x -> System.out.println(x + " leaves"));

                return this.shop;
            }
            );
           

        return new State(updatedShop);
    }

                                            
                                                     
                                                                       
}
