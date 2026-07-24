class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right=matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(target>matrix[i][matrix[0].length-1]){
                continue;
            }
            else if(target<=matrix[i][matrix[0].length-1]){
                int l=left;
                int r=right;
                while(l<=r){
                int mid=l+(r-l)/2;
                if(target==matrix[i][mid]){
                    return true;
                }
                else if(target>matrix[i][mid]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
                }
            }
            else{
                return false;
            }
            }
            return false;

        }
        
    }
//O(m+logn)
//check leetcode folder for optimal soln O(log(mn))