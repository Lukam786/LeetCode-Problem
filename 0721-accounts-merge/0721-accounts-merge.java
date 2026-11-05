class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);

                graph.putIfAbsent(firstEmail, new ArrayList<>());
                graph.putIfAbsent(email, new ArrayList<>());

                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (List<String> account : accounts) {

            String firstEmail = account.get(1);

            if (visited.contains(firstEmail)) {
                continue;
            }

            List<String> emails = new ArrayList<>();
            dfs(firstEmail, graph, visited, emails);

            Collections.sort(emails);

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(account.get(0));
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }

        return result;
    }

    private void dfs(String email, Map<String, List<String>> graph,
                     Set<String> visited, List<String> emails) {

        visited.add(email);
        emails.add(email);

        for (String neighbor : graph.getOrDefault(email, new ArrayList<>())) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, emails);
            }
        }
    }
}