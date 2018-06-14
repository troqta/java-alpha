package telerik;

public class Main {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        image = new Solution().floodFill(image, 1 ,1 , 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fillImage(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fillImage(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || oldColor == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        fillImage(image, sr - 1, sc, oldColor, newColor);
        fillImage(image, sr + 1, sc, oldColor, newColor);
        fillImage(image, sr, sc - 1, oldColor, newColor);
        fillImage(image, sr, sc + 1, oldColor, newColor);


    }
}
