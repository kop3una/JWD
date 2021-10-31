package by.training.project.service.mail;

public interface MailService {
    String getEmail();
    int getLinkHash();
    boolean sendApprovalRegistration (String email,String password, String role, String locale);
}
