class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<flights.length; i++){
            int source = flights[i][0];
            int destination = flights[i][1];
            int price = flights[i][2];
            adj.get(source).add(new Pair(destination, price));
        } 
        
        Queue<Tuple3<Integer>> queue = new LinkedList<>();
        queue.offer(new Tuple3<Integer>(0, src, 0));
        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000);
        costs[src] = 0;
        
        int answer = (int) Math.pow(10, 9);
        while(!queue.isEmpty()){
            Tuple3<Integer> tuple = queue.poll();
            int stops = tuple.stops;
            int city = tuple.city;
            int price = tuple.price;
            
            for(Pair v : adj.get(city)){
                int newStops = stops + 1;
                int newCity = v.destination;
                int newPrice = price + v.price;
                if(newPrice < costs[newCity] && stops <= k){
                    costs[newCity] = newPrice;
                    queue.offer(new Tuple3<Integer>(newStops, newCity, newPrice));
                }
            }
        }
        
        return costs[dst] == 1000000000 ? -1 : costs[dst];
        
        
    }
}

class Pair{
    int destination;
    int price;
    
    public Pair(int destination, int price){
        this.destination = destination;
        this.price = price;
    }
}

class Tuple3<T>{
    T stops;
    T city;
    T price;
    
    public Tuple3(T stops, T city, T price){
        this.stops = stops;
        this.city = city;
        this.price = price; 
    }
}