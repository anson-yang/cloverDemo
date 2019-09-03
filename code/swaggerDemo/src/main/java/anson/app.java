package anson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: anson
 * @Date: 2019/9/3 21:30
 * @version: 1.0
 */

 @SpringBootApplication   //添加启动类注解
public class app
{
    public  static  void main(String[] args)
    {
        SpringApplication.run(app.class,args);  //添加SpringApplication.run方法
    }
}
