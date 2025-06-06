package dianyingxinxiDEMO;

import java.util.Scanner;

public class MovieOperator {
    private Movie[] movies;//记住一个电影对象数组

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    public void printAllMovie() {
        System.out.println("编号\t电影名\t价格\t主演");
        for (int i =0 ;i < movies.length;i++) {
            Movie m = movies[i];
            System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice() + "\t" + m.getActor());
        };
        }
    public void serchMovieById() {
        System.out.println("请输入要查询的电影");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        //遍历每个电影对象
        for(int i = 0 ; i < movies.length; i++) {
            //拿到当前遍历到的电影信息
            Movie m = movies[i];
            //判断当前遍历到的电影id是否是我们正在找的电影信息，是则打印出该电影信息并立即结束方法
            if (m.getId() == id) {
                System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice() + "\t" + m.getActor());
                return;
            }
        };
        System.out.println("没有找到该电影");
  }
}

