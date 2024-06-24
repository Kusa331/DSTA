/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package W4.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacencyMatrix {
    
    private static class Graph{
        int vertices;
        int edges;
        int[][] graph;
        
        Graph(int vertices, int edges){
            this.vertices = vertices;
            this.edges = edges;
            this.graph = new int[vertices][vertices];
        }
    }
    
    public static void main(String[] args) {
        int numVertices = 5;
        int numEdges = 5;
        
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1});
        edges.add(new int[]{1,3});
        edges.add(new int[]{2,1});
        edges.add(new int[]{3,4});
        edges.add(new int[]{4,2});
        
        Graph g = new Graph(numVertices, numEdges);
        
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            g.graph[edge[0]][edge[1]]=1;            
        }
        
        for(int[] i:g.graph){
            System.out.println(Arrays.toString(i));
        }
    }
}
/*
Sample run:
[0, 1, 0, 0, 0]
[0, 0, 0, 1, 0]
[0, 1, 0, 0, 0]
[0, 0, 0, 0, 1]
[0, 0, 1, 0, 0]
*/
