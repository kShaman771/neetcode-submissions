class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> id = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        int n = 0;

        // Give every email an ID
        for (List<String> acc : accounts) {
            String nm = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);

                if (!id.containsKey(email)) {
                    id.put(email, n++);
                    name.put(email, nm);
                }
            }
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        // Union emails belonging to the same account
        for (List<String> acc : accounts) {
            int first = id.get(acc.get(1));

            for (int i = 2; i < acc.size(); i++) {
                union(first, id.get(acc.get(i)), parent);
            }
        }

        // Group emails by root
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : id.keySet()) {
            int root = find(id.get(email), parent);

            groups.computeIfAbsent(root, x -> new ArrayList<>())
                  .add(email);
        }

        // Build answer
        List<List<String>> ans = new ArrayList<>();

        for (List<String> emails : groups.values()) {
            Collections.sort(emails);

            List<String> acc = new ArrayList<>();
            acc.add(name.get(emails.get(0)));
            acc.addAll(emails);

            ans.add(acc);
        }

        return ans;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);

        return parent[x];
    }

    private void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if (a != b)
            parent[b] = a;
    }
}