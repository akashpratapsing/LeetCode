class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int n = numberOfUsers;
        int[] count = new int[n];

        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2)
                return t1 - t2;

            // same timestamp → OFFLINE first
            boolean aIsOffline = a.get(0).equals("OFFLINE");
            boolean bIsOffline = b.get(0).equals("OFFLINE");

            if (aIsOffline && !bIsOffline)
                return -1;
            if (!aIsOffline && bIsOffline)
                return 1;

            return 0;
        });

        int[] nextOnlineTime = new int[numberOfUsers];

        for (List<String> e : events) {

            String message = e.get(0);
            int timestamp = Integer.parseInt(e.get(1));
            String mentions = e.get(2);

            if (message.equals("MESSAGE")) {
                if (mentions.equals("ALL")) {
                    for (int i = 0; i < n; i++) {
                        count[i]++;
                    }
                } else if (mentions.equals("HERE")) {
                    for (int i = 0; i < n; i++) {
                        if (timestamp >= nextOnlineTime[i]) {
                            count[i]++;
                        }
                    }
                } else {
                    String[] users = mentions.split(" ");
                    for (int i = 0; i < users.length; i++) {
                        int index = Integer.parseInt(users[i].substring(2));
                        count[index]++;
                    }
                }
            } else {
                int userId = Integer.parseInt(mentions);
                nextOnlineTime[userId] = timestamp + 60;
            }
        }
        return count;
    }
}