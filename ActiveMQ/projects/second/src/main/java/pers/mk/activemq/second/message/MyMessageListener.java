package pers.mk.activemq.second.message;

import org.springframework.beans.factory.annotation.Autowired;
import pers.mk.activemq.second.controller.ActiveMqController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
//                System.out.println(textMessage.getText());
                ActiveMqController.receiveMessage = textMessage.getText();
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
