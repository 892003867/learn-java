public class jdbc_01 {
    public static void main(String[] args) throws Exception {
        // 1.不推荐的做法
        // DriverManager.registerDriver(new Driver());

        // 2.通过反射方式进行注册
        Class.forName("com.mysql.jdbc.Driver");

        // url连接完整
        String url="jdbc:mysql://192.168.56.1:8888/jdbc";
    }
}
