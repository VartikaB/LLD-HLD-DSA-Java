package DSA.CompanyBased.Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Topological sorting is a linear ordering of the vertices of a directed acyclic graph where every node appears before all the nodes it points to. In Kahn's algorithm, I use BFS and an indegree array. I first enqueue all nodes with indegree zero, process them one by one, and decrease the indegree of their neighbors. Whenever a neighbor's indegree becomes zero, I enqueue it. If I process fewer than V nodes, the graph contains a cycle



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            mp.put(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            mp.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int neighbor : mp.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}

