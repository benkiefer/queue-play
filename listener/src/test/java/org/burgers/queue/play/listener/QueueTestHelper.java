package org.burgers.queue.play.listener;

import org.apache.activemq.ActiveMQQueueBrowser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.jms.support.JmsAccessor;
import org.springframework.jms.support.destination.JmsDestinationAccessor;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

@Component
public class QueueTestHelper {
    @Autowired
    private JmsTemplate jmsTemplate;

    void waitForMessageCountToReachZero(){
        jmsTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object doInJms(Session session) throws JMSException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });



    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
