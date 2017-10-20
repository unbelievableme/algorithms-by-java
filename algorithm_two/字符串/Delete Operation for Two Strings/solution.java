//主要是生成子序列dp[i][j]这个最优子矩阵，他表示word1前i个和word2前j个当中最大
class Solution {
    public int minDistance(String word1, String word2) {
    	//注意定义的边界
        int dp[][]= new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<word1.length()+1;i++){
            for(int j = 0;j<word2.length()+1;j++){
                if(i==0||j==0) dp[i][j] = 0;
                else{
                    dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1)?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int val = dp[word1.length()][word2.length()];
        return word1.length() + word2.length() - 2* val;
    }
}