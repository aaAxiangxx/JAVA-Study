package dianyingxinxiDEMO;

public class Test {
    public static void main(String[] args) {
        //1.设计电影类Movie，以便创建电影对象，封装电影数据
        //封装系统中的全部电影数据
        Movie [] movies = new Movie[6];
        movies[0] = new Movie(1,"星际穿越",9.6,"安妮海克威");
        movies[1] = new Movie(2,"111",9.5,"222");
        movies[2] = new Movie(3,"333",9.5,"4444");
        movies[3] = new Movie(4,"555",9.5,"666");
        movies[4] = new Movie(5,"777",9.5,"888");
        movies[5] = new Movie(6,"999",9.5,"000");

        //创建电影操作对象出来，专门负责电影数据的业务操作
        MovieOperator mo =new MovieOperator(movies);
        mo.printAllMovie(); //ALT + 回车 快速生成方法
        mo.serchMovieById();

    }
}
