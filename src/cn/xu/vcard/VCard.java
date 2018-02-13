package cn.xu.vcard;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * vcard 的版本：https://en.wikipedia.org/wiki/VCard
 * 	private String name ="暂无";
	private String org ="暂无";//公司名称
	private String role ="暂无";
	private String workTel ="暂无";
	private String homeTel ="暂无";
	private String addrWork ="暂无";
	private String addrHome ="暂无";
	private String email ="暂无";
	private String qrPath = "C:/vcard.png";
	//是因为你选了PHOTO_MEDIATYPE_GIF 所以照片的photoImg的后缀名才是.gif
	public  String photoImg="http://www.example.com/dir_photos/my_photo.gif";
 * @author Administrator
 *
 */

public class VCard {
	public static String LF = "\n"; 
	public static String BEGIN="BEGIN:VCARD";//必须有的
	public static String VERSION = "VERSION:4.0";//必须有的
	public static String N="N:";
	public static String FN="FN:";//姓名
	public static String ORG="ORG:";//组织
	public static String TITLE="TITLE:";//职位
	public static String PHOTO_MEDIATYPE_GIF="PHOTO;MEDIATYPE=image/gif:";
	public static String PHOTO_MEDIATYPE_JPG="PHOTO;MEDIATYPE=image/jpg:";
	public static String PHOTO_MEDIATYPE_PNG="PHOTO;MEDIATYPE=image/png:";
	public static String TEL_TYPE_Work="TEL;TYPE=work,voice;VALUE=uri:";//工作电话
	public static String TEL_TYPE_Home="TEL;TYPE=home,voice;VALUE=uri:";//家庭电话
	public static String ADR_TYPE_WORK_PREF="ADR;TYPE=WORK,PREF:";//工作住址
	public static String LABEL_TYPE_WORK_PREF="LABEL;TYPE=WORK,PREF:";//工作标签和家庭标签没事区别
	
	public static String ADR_TYPE_HOME="ADR;TYPE=HOME:";//家庭住址
	public static String LABEL_TYPE_HOME="LABEL;TYPE=HOME:";//家庭标签
	public static String x_QQ="x-qq:";//不起作用
	public static String EMAIL="EMAIL:";//电子邮箱
	public static String REV="REV:";//不起作用
	public static String END="END:VCARD";//必须有的
	
	public static Integer _VERSION =18;
	public static char ERROR_CORRECT ='M' ;
	public static char ENCODE_MODE = 'B';
	public static String CHARSET = "utf-8";
	
	
	public VCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void CrateQRCodeImg(StringBuffer qrData,File filePath) {
		CreateQRCode cqr = new CreateQRCode(ERROR_CORRECT, ENCODE_MODE, _VERSION, 2, CHARSET);
		cqr.setQrData(qrData.toString());
		BufferedImage bImgQr = cqr.getBufferedImageQRCode();
		cqr.write(bImgQr, "png", filePath);
	}
	
	
	public static String autoAddLF(String arg1) {
		
		return new String(arg1+LF);
	}
	public static String autoAddContentLF(String arg1,String content) {
		
		return new String(arg1+content+LF);
	}

}
