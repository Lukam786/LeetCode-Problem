class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean visited[] = new boolean[rooms.size()];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {

            int curr = q.remove();

            for (int key : rooms.get(curr)) {

                if (!visited[key]) {

                    visited[key] = true;

                    q.add(key);
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}