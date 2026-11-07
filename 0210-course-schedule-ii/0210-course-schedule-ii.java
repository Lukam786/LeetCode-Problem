
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int indegree[] = new int[numCourses];

        // Create directed graph
        for (int i = 0; i < prerequisites.length; i++) {

            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph[prerequisite].add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add courses with indegree 0
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int result[] = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();

            result[index] = curr;
            index++;

            for (int i = 0; i < graph[curr].size(); i++) {

                int neighbor = graph[curr].get(i);

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If cycle exists, return empty array
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}
