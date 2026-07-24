class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);

        HashMap<Integer,Integer> count = new HashMap<>();

        for(int num : hand){
            count.put(num, count.getOrDefault(num,0) + 1);
        }

        for(int num : hand){

            if(count.get(num) == 0){
                continue;
            }

            // start a group at num
            for(int i = num; i < num + groupSize; i++){

                if(count.getOrDefault(i,0) == 0){
                    return false;
                }

                count.put(i, count.get(i) - 1);
            }
        }

        return true;
    }
}