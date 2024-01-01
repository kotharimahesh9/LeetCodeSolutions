//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++)
            adj.add(new ArrayList<>());
        // a -> 0 , b -> 1, c -> 2 ........ z -> 26
        for(int i=0; i<N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int p1 = 0;
            int p2 = 0;
            while(p1 < s1.length() && p2 < s2.length()){
                if(s1.charAt(p1) != s2.charAt(p2)){
                    adj.get(s1.charAt(p1) - 'a').add(s2.charAt(p2) - 'a');
                    break;
                }else{
                    p1++;
                    p2++;
                }
            }
        }
        
        int[] ingress = new int[K];
        
        for(int i=0; i<K; i++){
            for(int v : adj.get(i)){
                ingress[v]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<K; i++){
            if(ingress[i] == 0)
                queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            answer.add(v);
            
            for(int u : adj.get(v)){
                ingress[u]--;
                if(ingress[u] == 0){
                    queue.offer(u);
                }
            }
            
        }
        
        String ans = "";
        for(int x : answer){
            char ch = (char)('a' + x);
            ans += ch;
        }
        
        return ans;
        
    }
}