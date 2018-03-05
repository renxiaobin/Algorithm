package week3;

public class Hamilton {
    public static void main(String[] args) {
        int[][] adjMatrix = {
                {-1, 1, 1, 1, -1, -1},
                {1, -1, 1, -1, -1, 1},
                {1, 1, -1, 1, -1, -1},
                {1, -1, 1, -1, 1, -1},
                {-1, -1, -1, 1, -1, 1},
                {-1, 1, -1, -1, 1, -1}};
        getHamiltonCircuit(adjMatrix);
    }

    private static void getHamiltonCircuit(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        int[] path = new int[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            visited[i] = false;
            path[i] = -1;
        }
        visited[0] = true;
        path[0] = 0;
        dfs(adjMatrix, path, visited, 1);
    }

    /**
     * 深度优先搜索
     * @param adjMatrix
     * @param path
     * @param visited
     * @param step
     * @return
     */
    private static boolean dfs(int[][] adjMatrix, int[] path, boolean[] visited, int step) {
        if (step == adjMatrix.length) {
            if (adjMatrix[path[step - 1]][0] == 1) {
                outputPath(path);
                return true;
            }
            return false;
        } else {
            for (int i = 0; i < adjMatrix.length; i++) {
                if (!visited[i] && adjMatrix[path[step - 1]][i] == 1) {
                    visited[i] = true;
                    path[step] = i;
                    if (dfs(adjMatrix, path, visited, step + 1)) {
                        return true;
                    } else {
                        //当前路径不对，回溯处理
                        visited[i] = false;
                        path[step] = -1;
                    }
                }
            }
        }
        return false;
    }

    private static void outputPath(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(((char) (path[i] + 'a')) + "->");
        }
        System.out.println((char) (path[0] + 'a'));
    }
}
