class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> freq= new HashMap<>();
        for(int num :nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int frequency=entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
            }
            int[] res= new int[k];
            int j=0;
            for(int i=bucket.length-1;i>=0;i--){
                if (bucket[i]!=null){
                    for(int number:bucket[i]){
                        res[j]=number;
                        j++;

                        if(j==k){
                            return res;
                        }
                    }
                }
            }
            return new int[k];
        }
        

        
    }
