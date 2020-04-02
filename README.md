# BellmanFord-Algorithm
Used to find shortest path between negative weight graph

Unlike Dijkstra algorithm Bellman Ford algorithm works with negative edges also
It is slower than Dijkstra.

                          Time complexity  - O(EN)
                          Space complexity - O(N) 
                          where N=number of vertices
                                E=number of edges
                          
Call bellmanFord function exactly at N-1 times to get shortest distances.

to detect -ve cycle run for 1 more time i.e. Nth time, if on relaxation occur then -ve cycle present in graph
So we cant get accurate answer in N-1 turn.
