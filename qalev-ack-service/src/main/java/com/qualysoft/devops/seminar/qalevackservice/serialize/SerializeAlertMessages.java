package com.qualysoft.devops.seminar.qalevackservice.serialize;

import com.qualysoft.devops.seminar.qalevackservice.model.AlertMessage;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class SerializeAlertMessages {

    private Logger logger = LoggerFactory.getLogger(SerializeAlertMessages.class);

    private List<AlertMessage> alerts;

    private String filePath;
    private String fileName;

    SerializeAlertMessages() {
        filePath = "./files/";
        fileName = "alerts.txt";
        List<AlertMessage> alerts = read();
        if (alerts != null) {
            this.alerts = alerts;
        } else {
            write(new ArrayList<>());
        }
    }

    public List<AlertMessage> read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<AlertMessage> alerts = (List<AlertMessage>) objectInputStream.readObject();
            objectInputStream.close();
            return alerts;

        } catch (IOException | ClassNotFoundException exception) {
            logger.error(exception.getMessage());
        }

        return null;
    }

    public void write(List<AlertMessage> alerts) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(alerts);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException exception) {
            logger.error(exception.getMessage());
        }
    }
}