package org.burgers.queue.play.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class JmsMessageListener implements MessageListener {

        @Autowired
        private AtomicInteger counter = null;

        public void onMessage(Message message) {
            try {
                if (message instanceof TextMessage) {
                    TextMessage tm = (TextMessage)message;
                    String msg = tm.getText();
                    System.out.println("msg = " + msg);

                    counter.incrementAndGet();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
}
