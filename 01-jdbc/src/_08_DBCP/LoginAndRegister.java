package _08_DBCP;

import java.util.Scanner;

// 实现用户交互部分
public class LoginAndRegister {
    private static Scanner sc = new Scanner(System.in);
    private static Dao d = new Dao();

    public static void main(String[] args) {
        // 调用选择方法，获取用户的选择内容,得到字符串的序号
        String num = choose();
        // 对选择序号进行判断
        switch (num) {
            case "1":
                System.out.println("选择的登录，请输入用户名");
                String username = sc.next();
                System.out.println("选择的登录，请输入密码");
                String password = sc.next();
                // 调用dao包中的类login方法，传递用户名和密码
                Boolean b = d.login(username, password);
                if (b) {
                    System.out.println("登陆成功");
                } else {
                    System.out.println("登录失败，检查用户名和密码");
                }
                break;
            case "2":
                System.out.println("选择的注册，请输入用户名");
                String inputUsername = sc.next();
                System.out.println("选择的注册，请输入密码");
                String inputPassword = sc.next();
                Boolean inputb = d.register(inputUsername, inputPassword);
                if (inputb) {
                    System.out.println("用户注册成功");
                } else {
                    System.out.println("用户已经注册");
                }
                break;
            case "3":
                System.exit(0); // 退出虚拟机
            default:
                System.out.println("没有此功能");
                break;
        }
    }

    public static String choose() {
        System.out.println("欢迎光临");
        System.out.println("请选择功能菜单");
        System.out.println("1 登录 2 注册 3 退出");
        return sc.next();
    }
}
