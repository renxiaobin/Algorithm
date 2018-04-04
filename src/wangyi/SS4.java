package wangyi;

import java.util.Scanner;

/**
 * 击落某个位置(k,j)的气球，受其影响掉落的气球的数量
 * 若某个气球可以通过直接或间接的上下左右的连接与顶部最上方的的存在的气球相通，则不会掉落；反之会掉落
 * 二维数组中对应位置值为1表示有气球，0表示没气球
 * 击中值为0则返回0
 */
public class SS4 {
    /**
     * 二次染色问题
     * 先遍历原数组不会掉落的气球，使用dfs找出不会掉落的所有气球的位置并保存再状态数组中置为1
     * 再使用dfs2遍历击落(k,j)后的气球数组，找出当前仍然不会掉落的气球并将状态数组对应位置置为2
     * 则当前状态数组中的值仍为1的位置即为受到影响掉落的气球的位置
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] state = new int[n][m];
        for (int i = 0; i < m; i++) {
            dfs(matrix, state, 0, i);
        }
        matrix[k][t] = 0;
        state[k][t] = 0;
        for (int i = 0; i < m; i++) {
            dfs2(matrix, state, 0, i);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < m; l++) {
                if(state[i][l] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs2(int[][] matrix, int[][] state, int x, int y) {
        if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
            return;
        }
        if(state[x][y] == 2) {
            return;
        }
        if(matrix[x][y] == 1) {
            state[x][y] = 2;
            dfs2(matrix, state, x, y + 1);
            dfs2(matrix, state, x, y - 1);
            dfs2(matrix, state, x + 1, y);
            dfs2(matrix, state, x - 1, y);
        }
    }

    private static void dfs(int[][] matrix, int[][] state, int x, int y) {
        if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
            return;
        }
        if(state[x][y] != 0) {
            return;
        }
        if(matrix[x][y] == 1) {
            state[x][y] = 1;
            dfs(matrix, state, x, y + 1);
            dfs(matrix, state, x, y - 1);
            dfs(matrix, state, x + 1, y);
            dfs(matrix, state, x - 1, y);
        }
    }

}