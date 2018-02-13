package cn.xu.vcard;

import java.io.File;

public class Demo {
	
	public static void main(String[] args) {
		VCard vc = new VCard();
		StringBuffer qrData  = new StringBuffer();
		qrData.append(VCard.autoAddLF(VCard.BEGIN));
		qrData.append(VCard.autoAddLF(VCard.VERSION));
		qrData.append(VCard.autoAddContentLF(VCard.FN,"张三"));
		qrData.append(VCard.autoAddContentLF(VCard.ORG,"建设银行"));
		qrData.append(VCard.autoAddContentLF(VCard.TITLE,"收银员"));
		qrData.append(VCard.autoAddContentLF(VCard.TEL_TYPE_Home,"11111111111"));
		qrData.append(VCard.autoAddContentLF(VCard.ADR_TYPE_HOME,"河南省 xxx"));
		qrData.append(VCard.autoAddContentLF(VCard.EMAIL,"1111111111@qq.com"));
		qrData.append(VCard.autoAddLF(VCard.END));

		vc.CrateQRCodeImg(qrData, new File("E:/demo.png"));
	}

}
