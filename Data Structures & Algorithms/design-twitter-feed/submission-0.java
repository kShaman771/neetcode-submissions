class Twitter {

    private int time;

    // follower -> followees
    private HashMap<Integer, HashSet<Integer>> followMap;

    // user -> list of tweets
    // each tweet = {time, tweetId}
    private HashMap<Integer, List<int[]>> tweetMap;

    public Twitter() {

        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new int[]{time, tweetId});

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followee : followMap.get(userId)){

            if(!tweetMap.containsKey(followee)){
                continue;
            }

            List<int[]> tweets = tweetMap.get(followee);

            int index = tweets.size() - 1;

            int[] tweet = tweets.get(index);

            // {time, tweetId, followeeId, index}
            pq.offer(new int[]{
                tweet[0],
                tweet[1],
                followee,
                index
            });
        }

        while(!pq.isEmpty() && result.size() < 10){

            int[] current = pq.poll();

            int tweetId = current[1];
            int followee = current[2];
            int index = current[3];

            result.add(tweetId);

            index--;

            if(index >= 0){

                int[] nextTweet = tweetMap.get(followee).get(index);

                pq.offer(new int[]{
                    nextTweet[0],
                    nextTweet[1],
                    followee,
                    index
                });
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId)){

            followMap.get(followerId).remove(followeeId);
        }
    }
}