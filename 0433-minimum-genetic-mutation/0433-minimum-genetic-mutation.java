
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> set = new HashSet<>();

        for (String gene : bank) {
            set.add(gene);
        }

        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(startGene);
        vis.add(startGene);

        char[] chars = {'A', 'C', 'G', 'T'};
        int mutations = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.remove();

                if (curr.equals(endGene)) {
                    return mutations;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char ch : chars) {
                        arr[j] = ch;
                        String next = new String(arr);

                        if (set.contains(next) && !vis.contains(next)) {
                            vis.add(next);
                            q.add(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}
