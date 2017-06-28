package com.umasuo.emqtt.tester;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

/**
 * Created by umasuo on 17/6/27.
 *
 */
public class Publisher {
  public static void main(String[] args) {
    System.out.println("asdass");
    try {
      MQTT mqtt = new MQTT();
      mqtt.setHost("localhost", 1883);
      mqtt.setUserName("umasuo");
      mqtt.setPassword("password");
      BlockingConnection con = mqtt.blockingConnection();
      con.connect();
      con.publish("topic1", "this is value.".getBytes(), QoS.AT_LEAST_ONCE, true);
      Thread.currentThread().sleep(1000);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
