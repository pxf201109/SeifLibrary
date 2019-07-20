package com.seif.seiflibrary;

import com.sproutsocial.nsq.Message;
import com.sproutsocial.nsq.MessageHandler;
import com.sproutsocial.nsq.Publisher;

/**
 * Created by seif on 2019/07/11.
 */
public class SeifTest implements MessageHandler {

    public static void main(String args[]) {
        String host = "192.168.1.164";
//        String host = "192.168.1.167";
        int port = 4161;

        //发布消息
        Publisher publisher = new Publisher(host);//你的nsq服务器ip地址，如果是分布式，可以是多个地址，如new Publisher("192.168.138.128","192.168.138.x")

        byte[] data = ("sd2-1|0|0").getBytes();//要发送的消息code|status|offoron
        publisher.publish("sd2-1_status", data);//test1为主体topic

        //接收消息
//        Subscriber subscriber = new Subscriber(host);//nsq服务器ip，也可以配置多个
//        SeifTest data=new SeifTest();//实现MessageHandler接口的accept方法的类
////        subscriber.subscribe("ZDBH00008", "nsq_to_seif", data);
//        subscriber.subscribe("aaaaa", "nsq_to_seif", data);
    }


    @Override
    public void accept(Message msg) {
        System.out.println("111111111111------"+msg.getTopic()+"---"+new String(msg.getData()));

    }

    public String getSeifName(){
        return "pxf201109";
    }
}
