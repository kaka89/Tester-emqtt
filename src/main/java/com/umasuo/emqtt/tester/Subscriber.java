package com.umasuo.emqtt.tester;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.Message;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

import java.util.concurrent.TimeUnit;

/**
 * Created by umasuo on 17/6/27.
 */
public class Subscriber {
  public static void main(String[] args) {
    System.out.println("start");
    try {
      MQTT mqtt = new MQTT();
      mqtt.setHost("localhost", 1883);
      mqtt.setUserName("umasuo");
      mqtt.setPassword("password");
      BlockingConnection con = mqtt.blockingConnection();
      con.connect();
      Topic[] topics = {new Topic("topic1", QoS.AT_LEAST_ONCE)};
      con.subscribe(topics);
      Message message = con.receive(1, TimeUnit.SECONDS);
      byte[] payload = message.getPayload();
      message.ack();
      System.out.println(message.getTopic() + ":  " + new String(payload));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
