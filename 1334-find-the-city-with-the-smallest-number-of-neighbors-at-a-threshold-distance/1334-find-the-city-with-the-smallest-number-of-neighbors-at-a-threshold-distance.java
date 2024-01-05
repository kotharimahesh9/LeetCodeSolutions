class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        int infinity = (int)1e8;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = infinity;
                if(i == j)
                    matrix[i][j] = 0;
            }
        }
        
        int m = edges.length;
        for(int i=0; i<m; i++){
            int source = edges[i][0];
            int target = edges[i][1];
            int weight = edges[i][2];
            matrix[source][target] = weight;
            matrix[target][source] = weight;
        }
        
        for(int via=0; via < n; via++){
            for(int u=0; u < n; u++){
                for(int v=0; v < n; v++){
                    matrix[u][v] = Math.min(matrix[u][v], matrix[u][via] + matrix[via][v]);
                }
            }
        }
        
        int[] cities = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(i != j){
                    if(matrix[i][j] <= distanceThreshold){
                        cities[i]++;
                    }
                }
            }
        }
        
        int answer = (int) 1e9;
        int index = -1;
        for(int i=0; i<n; i++){
            if(cities[i] <= answer){
                answer = cities[i];
                index = i;
            }
        }
        
        return index;
    }
}