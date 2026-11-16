
class Solution {
    int parent[];
    int size[];

    public int findParent(int n) {
        if(n == parent[n]) {
            return n;
        }

        parent[n] = findParent(parent[n]);
        return parent[n];
    }

    public void union(int nodes1, int nodes2) {
        int parent1 = findParent(nodes1);
        int parent2 = findParent(nodes2);

        if(parent1 == parent2) {
            return;
        }

        if(size[parent1] > size[parent2]) {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }
        else {
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];

        for(int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // First pass: ==
        for(int i = 0; i < equations.length; i++) {
            String str = equations[i];

            if(str.charAt(1) == '=') {
                int node1 = str.charAt(0) - 'a';
                int node2 = str.charAt(3) - 'a';

                union(node1, node2);
            }
        }

        // Second pass: !=
        for(int i = 0; i < equations.length; i++) {
            String str = equations[i];

            if(str.charAt(1) == '!') {
                int node1 = str.charAt(0) - 'a';
                int node2 = str.charAt(3) - 'a';

                if(findParent(node1) == findParent(node2)) {
                    return false;
                }
            }
        }

        return true;
    }
}
