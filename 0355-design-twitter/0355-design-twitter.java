class Twitter {

    int time;
    Map<Integer, List<int[]>> userTweets;
    Map<Integer, Set<Integer>> userFollowing;

    public Twitter() {
        time = 0;
        userTweets = new HashMap<>();
        userFollowing = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new int[] { tweetId, time });
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        ArrayList<Integer> users = new ArrayList<>();
        users.add(userId);
        ArrayList<Integer> ans = new ArrayList<>();

        if (userFollowing.containsKey(userId)) {
            for (int x : userFollowing.get(userId)) {
                users.add(x);
            }
        }

        for (int x : users) {
            if (userTweets.containsKey(x) && !userTweets.get(x).isEmpty()) {
                pq.add(new int[] { userTweets.get(x).getLast()[0], userTweets.get(x).getLast()[1], x,
                        userTweets.get(x).size() - 1 });
            }
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            int tweet = pq.peek()[0];
            int user = pq.peek()[2];
            int index = pq.poll()[3];
            ans.add(tweet);
            if (!userTweets.get(user).isEmpty() && index - 1 >= 0) {
                pq.add(new int[] { userTweets.get(user).get(index - 1)[0], userTweets.get(user).get(index - 1)[1], user,
                        index - 1 });
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userFollowing.containsKey(followerId)) {
            userFollowing.put(followerId, new HashSet<>());
        }
        userFollowing.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowing.containsKey(followerId)) {
            userFollowing.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */