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
    objPrp.put("mail.smtp.host","api.doyeah.info"); // SMTPサーバ名
    objPrp.put("mail.host","api.doyeah.info"); // 接続するホスト名
    
    // メールセッションを確立
    Session session=Session.getDefaultInstance(objPrp,null);
    // 送信メッセージを生成
    MimeMessage objMsg=new MimeMessage(session);
    try {
    // 送信先（TOのほか、CCやBCCも設定可能）
      objMsg.setRecipients(Message.RecipientType.TO,"kasuya-u@yama.info.waseda.ac.jp");
    // Fromヘッダ
      InternetAddress objFrm=new InternetAddress("kasuya-u@yama.info.waseda.ac.jp","Y.Yamada");

      objMsg.setFrom(objFrm);
    // 件名
objMsg.setSubject("メールテスト","ISO-2022-JP");
       
    // 本文
      objMsg.setText("こんにちは","ISO-2022-JP");
      
    // メール送信
      Transport.send(objMsg); 
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    } 
  }
}