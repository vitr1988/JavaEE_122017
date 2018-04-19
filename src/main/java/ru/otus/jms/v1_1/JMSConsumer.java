package ru.otus.jms.v1_1;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Objects;

public class JMSConsumer {
    public static void main(String[] args) throws Exception {
        // get the initial context
        InitialContext ctx = new InitialContext();

        // lookup the topic object
        Topic topic = (Topic) ctx.lookup("jms/Topic");

        // lookup the topic connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("jms/TopicConnectionFactory");

        // create a topic connection
        TopicConnection topicConn = connFactory.createTopicConnection();

        // create a topic session
        TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        // create a topic subscriber
        TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);

        // start the connection
        topicConn.start();

        int index = 1;
        while (true) {
            // receive the message
            TextMessage message = (TextMessage) topicSubscriber.receive();

            if (index == 5) {
                System.out.println("Message received: " + message.getText());
                break;
            } else if (Objects.nonNull(message.getText())) {
                // print the message
                System.out.println("Message received: " + message.getText());
                index++;
            }
            else {
                Thread.sleep(3 * 1000);
            }

//            topicSubscriber.setMessageListener(new MessageListener() {
//                @Override
//                public void onMessage(Message message) {
//                    if (index == 5) {
//                        System.out.println("Message received: " + message.getText());
//                        break;
//                    } else if (Objects.nonNull(message.getText())) {
//                        // print the message
//                        System.out.println("Message received: " + message.getText());
//                        index++;
//                    }
//                    else {
//                        Thread.sleep(3 * 1000);
//                    }
//                }
//            });
        }

        // close the topic connection
        topicConn.close();
    }
}
