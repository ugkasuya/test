 // package to.msn.wings.javatips;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

public class MailTransfer {
  public static void main(String[] args) {
    Properties objPrp=new Properties();
    objPrp.put("mail.smtp.host","api.doyeah.info"); // SMTP�T�[�o��
    objPrp.put("mail.host","api.doyeah.info"); // �ڑ�����z�X�g��
    
    // ���[���Z�b�V�������m��
    Session session=Session.getDefaultInstance(objPrp,null);
    // ���M���b�Z�[�W�𐶐�
    MimeMessage objMsg=new MimeMessage(session);
    try {
    // ���M��iTO�̂ق��ACC��BCC���ݒ�\�j
      objMsg.setRecipients(Message.RecipientType.TO,"kasuya-u@yama.info.waseda.ac.jp");
    // From�w�b�_
      InternetAddress objFrm=new InternetAddress("kasuya-u@yama.info.waseda.ac.jp","Y.Yamada");

      objMsg.setFrom(objFrm);
    // ����
objMsg.setSubject("���[���e�X�g","ISO-2022-JP");
       
    // �{��
      objMsg.setText("����ɂ���","ISO-2022-JP");
      
    // ���[�����M
      Transport.send(objMsg); 
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    } 
  }
}