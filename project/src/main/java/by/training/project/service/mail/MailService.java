package by.training.project.service.mail;

public interface MailService {
    String getEmail();
    boolean sendApprovalRegistration (String email,String password, String role, String locale);
}
