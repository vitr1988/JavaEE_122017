package ru.otus.jms.v1_1;

import javax.jms.*;
import javax.naming.InitialContext;

public class JMSPublisher {

    public static void main(String[] args) throws Exception {
        // get the initial context
        InitialContext ctx = new InitialContext();

        // lookup the topic object
        Topic topic = (Topic) ctx.lookup("jms/Topic");

        // lookup the topic connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
                lookup("jms/TopicConnectionFactory");

        // create a topic connection
        TopicConnection topicConn = connFactory.createTopicConnection();

        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // create a topic publisher
        TopicPublisher topicPublisher = topicSession.createPublisher(topic);
        topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // create the "Hello World" message
        TextMessage message = topicSession.createTextMessage();
        message.setText("Hello from class runner");

        // publish the messages
        topicPublisher.publish(message);

        // print what we did
        System.out.println("Message published: " + message.getText());

        // close the topic connection
        topicConn.close();
    }
}
