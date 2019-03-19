public class DynamicProgramming03 {
    public int minDistance(String word1, String word2) {
        int[][] cost = new int[word1.length() + 1][word2.length() + 1];

        // 初始化
        for (int i = 0; i <= word1.length(); i++) {
            cost[i][0] = i; // i个字符转换成0个字符，就要把i个字符都删掉，所以需要i次
        }
        for (int j = 0; j <= word2.length(); j++) {
            cost[0][j] = j; // 0个字符转换成j个字符，要加上j个字符，需要j次
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    int replace = cost[i - 1][j - 1];
                    int add = cost[i][j - 1];
                    int delete = cost[i - 1][j];
                    cost[i][j] = Math.min(replace, Math.min(add, delete)) + 1;
                }
            }
        }
        return cost[word1.length()][word2.length()];
    }

    public int minDistance01(String word1, String word2) {
        int[] cur = new int[word2.length() + 1];
        int prev = 0;
        for (int i = 0; i <= word2.length(); i++) {
            cur[i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            prev = cur[0];
            cur[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                int tempPrev = cur[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev;
                } else {
                    cur[j] = Math.min(prev, Math.min(cur[j], cur[j - 1])) + 1;
                }
                prev = tempPrev;
            }
        }
        return cur[word2.length()];
    }
}
