package main.java;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *
 * 这种数组涉及到要同时和左边和右边比的情况下，分为两次遍历会比较简单
 */
public class Candy {


    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum = sum + candy[i];
        }
        return sum;

    }


    public static void main(String[] args) {
        Candy candy = new Candy();

        System.out.println(
            candy.candy(new int[]{1, 3, 4, 5, 2}));


    }

}
