package by.training.project.service.mail.impl;

import by.training.project.controller.command.CommandName;
import by.training.project.controller.command.RequestParameter;
import by.training.project.service.exception.ServiceException;
import by.training.project.service.mail.MailService;
import by.training.project.service.mail.MailSessionCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class MailServiceImpl implements MailService {
    private final Logger logger = LogManager.getLogger(MailServiceImpl.class);
    private final Properties mailProperties = loadMailProperties();
    private static final String MAIL_USER_NAME = "mail.user.name";
    private static final String MAIL_MESSAGE_BUNDLE = "mailcontent";
    private static final String APPROVAL_REGISTRATION = "approval-registration";
    private static final String SUBJECT="subject";
    private static final String MESSAGE_CONTENT_TYPE = "text/plain; charset=UTF-8";
    private static final String URL="url";
    private static final String START_PARAM="?";
    private static final String NEXT_PARAM="&";
    private ResourceBundle mailBundle;

    @Override
    public String getEmail() {
        if (!mailProperties.isEmpty()){
            return mailProperties.getProperty(MAIL_USER_NAME);
        } else {
            return "";
        }
    }

    @Override
    public boolean sendApprovalRegistration(String email, String password, String role, String locale) {
        if (!mailProperties.isEmpty()){
            try {
            MimeMessage message = createMessage(mailProperties);
            mailBundle = getResourceBundle(locale);
            String content = createContent(email, password, role);
            String subject = mailBundle.getString(SUBJECT);
            sendMessage(message, subject, content, email);
            } catch (ServiceException e){
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private Properties loadMailProperties() {
        Properties mailProperties = new Properties();
        InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("mail.properties");
        if (fileInputStream == null) {
            logger.error("File mail.properties doesn't exist");
            return new Properties();
        } else {
            try {
                mailProperties.load(fileInputStream);
            } catch (IOException e) {
                logger.error("Unable to read mail properties. {}", e.getMessage());
                return new Properties();
            }
            return mailProperties;
        }
    }

    private MimeMessage createMessage(Properties mailProperties) throws ServiceException {
        MailSessionCreator creator = new MailSessionCreator(mailProperties);
        Session session = creator.createSession();
        return new MimeMessage(session);
    }

    private ResourceBundle getResourceBundle(String locale) {
        Locale messageLocale = new Locale(locale);
        return ResourceBundle.getBundle(MAIL_MESSAGE_BUNDLE, messageLocale);
    }

    private void sendMessage(MimeMessage message, String subject, String content, String recipientEmail) throws ServiceException {
        try {
            message.setSubject(subject);
            message.setContent(content, MESSAGE_CONTENT_TYPE);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Unable to send message. {}", e.getMessage());
            throw new ServiceException("Unable to send message.", e);
        }
    }

    private String createContent(String email, String password, String role) throws ServiceException {
        return mailBundle.getString(APPROVAL_REGISTRATION)+" "+createLink(email,password,role);
    }

    private String createLink(String email, String password, String role) throws ServiceException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            Properties config = new Properties();
            config.load(input);
            return config.getProperty(URL)+START_PARAM+RequestParameter.COMMAND+"="+ CommandName.SHOW_CONTINUE_SIGN_UP+
                    NEXT_PARAM+RequestParameter.EMAIL+"="+email+
                    NEXT_PARAM+RequestParameter.PASSWORD+"="+password+
                    NEXT_PARAM+RequestParameter.ROLE+"="+role;
        } catch (IOException e){
            throw new ServiceException(e);
        }
    }
}
