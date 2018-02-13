package cn.xu.vcard;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
/**
 * exapmel:
 * 	ReadQRCode rqr = new ReadQRCode();
	String content = rqr.getQrCodeContent("二维码图片路径", "字符编码");
	System.out.println(content);
 * 
 * @author Administrator
 *
 */
public class ReadQRCode {
	
	public String getQrCodeContent(String qrCodePath,String charset) {
		String result ="";
		try {
			File file =  new File(qrCodePath);
			BufferedImage bufferedImage = ImageIO.read(file);
			//解码
			QRCodeDecoder codeDecoder = new QRCodeDecoder();
			byte[] btyes = codeDecoder.decode(new QRCodeImageImpl(bufferedImage));
			result = new String(btyes,charset);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
