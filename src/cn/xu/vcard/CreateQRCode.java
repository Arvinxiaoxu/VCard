package cn.xu.vcard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.swetake.util.Qrcode;

/**
 * example:
 * 		CreateQRCode cqr = new CreateQRCode('M', 'B', 7, 2, "utf-8");
 *		cqr.setQrData("www.baidu.com");
 *		BufferedImage bImgQr = cqr.getBufferedImageQRCode();
 *		cqr.write(bImgQr, "png", new File("E:/demo.png"));
 * 
 * new CreateQRCode('errorCorrect', 'encodeMode', version, pixoff, "charset");
 * errorCorrect：纠错级别，分为L、M、Q、H 纠错的级别越高，存储的信息量就越少(推荐M)
 * encodeMode：编码模式：N代表数字，A代表a-z，B代表其他字符	(推荐：B)
 * version：版本信息：即二维码的规格，QR码符号共有40种规格的矩阵(一般为黑白色)，
 * 		        从21×21(版本1)，到177×177(版本40)，每一版本符号比前一版本 每边增加4个模块
 * pixoff：偏移量：
 * charset：编码字符集gb2312 ,utf-8(可用容纳984字符),等
 * @author Administrator
 *
 */


public class CreateQRCode {
	
	 private char errorCorrect;// 纠错等级
	 private char encodeMode;// N代表数字，A代表a-z，B代表其他字符
	 private String qrData;//存储的内容
	 private Integer width;
	 private Integer height; 
	 private Integer version;//版本
	 private String charset;//字符编码
	 private  Integer pixoff;// 是指偏移量
	 
	 //字节数量
	 public static Integer MAX_BYTE_SIZE = 800;
	 
	 public CreateQRCode(char errorCorrect, char encodeMode,
				Integer version, Integer pixoff,String charset) {
			this.errorCorrect = errorCorrect;
			this.encodeMode = encodeMode;
			this.version = version;
			this.pixoff = pixoff;
			this.charset = charset;
		}

	public BufferedImage getBufferedImageQRCode() {
		
		BufferedImage bufferedImage = null;
		try {
			Qrcode x = new Qrcode();
			x.setQrcodeErrorCorrect(errorCorrect);
			x.setQrcodeEncodeMode(encodeMode);
			x.setQrcodeVersion(version);// 版本
			
			 bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufferedImage.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.setColor(Color.BLACK);
			// 通过使用当前的背景色来清除填充
			gs.clearRect(0, 0, getWidth(), getHeight());
			createQrCodePoint(gs,x);
			gs.dispose();
			bufferedImage.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedImage;
	}
	
	private void createQrCodePoint(Graphics2D gs,Qrcode x) {
		try {
			byte[] d = qrData.getBytes(charset);
			if (d.length > 0 && d.length < MAX_BYTE_SIZE) {
				boolean[][] s = x.calQrcode(d);
				for (int i = 0; i < s.length; i++) {
					for (int j = 0; j < s.length; j++) {
						if (s[i][j]) {
							gs.fillRect(i * 3 + pixoff, j * 3 + pixoff, 3, 3);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param bufferedImage 图片缓冲区
	 * @param formatName 图片类型
	 * @param file 图片的输出路径
	 */
	public void write(BufferedImage bufferedImage,String formatName,File file ) {
		try {
			ImageIO.write(bufferedImage,formatName,file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param bufferedImage 图片缓冲区
	 * @param formatName 图片类型
	 * @param output 图片输出流
	 */
	public void write(BufferedImage bufferedImage,String formatName,ImageOutputStream output ) {
		try {
			ImageIO.write(bufferedImage, formatName, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param bufferedImage 图片缓冲区
	 * @param formatName 图片类型
	 * @param output 输出流
	 */
	public void write(BufferedImage bufferedImage,String formatName,OutputStream output ) {
		try {
			ImageIO.write(bufferedImage, formatName, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public char getErrorCorrect() {
		return errorCorrect;
	}

	public void setErrorCorrect(char errorCorrect) {
		this.errorCorrect = errorCorrect;
	}

	public char getEncodeMode() {
		return encodeMode;
	}

	public void setEncodeMode(char encodeMode) {
		this.encodeMode = encodeMode;
	}

	public String getQrData() {
		return qrData;
	}

	public void setQrData(String qrData) {
		this.qrData = qrData;
	}

	public Integer getWidth() {
		
		return 67+12*(version-1);
	}

	public Integer getHeight() {
		return 67+12*(version-1);
	}

	public Integer getPixoff() {
		return pixoff;
	}

	public void setPixoff(Integer pixoff) {
		this.pixoff = pixoff;
	}
	
	
	
	
	
	
	

}
