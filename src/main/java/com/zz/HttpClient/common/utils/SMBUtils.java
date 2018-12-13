package com.zz.HttpClient.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.common.utils.httpClient.HttpStatus;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

/**
 * 
 * @Title:SMBUtils
 * @Description:TODO(SMB协议工具类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月13日 上午9:14:13
 */
public class SMBUtils {

	/**
	 * 
	 * @Title：smbGet
	 * @Description: TODO(从共享目录拷贝文件到本地)
	 * @see：
	 * @param remoteUrl 共享目录上的文件路径
	 * @param auth
	 * @param localFilePath 本地目录
	 * @return
	 * @throws Exception 
	 */
	public static void smbGet(String remoteUrl, NtlmPasswordAuthentication auth, String localFilePath) throws Exception {
		byte[] bytes = {};
		try {
			SmbFile remoteFile = new SmbFile(remoteUrl, auth);
			if (ObjectUtils.isEmpty(remoteFile))
				throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "无此文件");
			bytes = IOUtils.toByteArray(remoteFile.getInputStream());
			OutputStream os = new FileOutputStream(localFilePath);
			IOUtils.write(bytes, os);
		} catch (Exception e) {
			Logs.error("共享下载文件失败：" + Logs.toLog(e));
			throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "共享下载文件失败：" + e.toString());
		}
	}
	
	/**
	 * 
	 * @Title：smbPut
	 * @Description: TODO(从本地上传文件到共享目录)
	 * @see：
	 * @param remoteUrl 共享文件目录
	 * @param localFilePath 本地文件绝对路径
	 * @param auth
	 * @return
	 */
	public static void smbPut(String remoteUrl, String localFilePath, NtlmPasswordAuthentication auth) {
		FileInputStream fis = null;
		try {
			File localFile = new File(localFilePath);
			localFile.setReadOnly();
			String fileName = localFile.getName();
			SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName, auth);
			fis = new FileInputStream(localFile);
			IOUtils.copyLarge(fis, remoteFile.getOutputStream());
		} catch (Exception e) {
			Logs.error("共享上传文件失败: " + Logs.toLog(e));
			throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "共享上传文件失败: " + e.toString());
		} finally {
			try {
				if (ObjectUtils.isNotEmpty(fis))
					fis.close();
			} catch (IOException e) {
				Logs.error("关闭文件流失败：" + Logs.toLog(e));
			}
		}
	}
	
	/**
	 * 
	 * @Title：smbDel
	 * @Description: TODO(从共享目录删除文件)
	 * @see：
	 * @param remoteUrl 共享目录上的文件路径
	 * @param auth
	 */
	public static void smbDel(String remoteUrl, NtlmPasswordAuthentication auth) {
		try {
			SmbFile remoteFile = new SmbFile(remoteUrl, auth);
			if (remoteFile.exists())
				remoteFile.delete();
		} catch (Exception e) {
			Logs.error("共享删除文件失败：" + Logs.toLog(e));
			throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "共享删除文件失败：" + e.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		// smb:域名;用户名:密码@目的IP/文件夹/文件名.xxx
        // test.smbGet("smb://szpcg;jiang.t:xxx@192.168.193.13/Jake/test.txt",
        // "c://") ;
		// 先登录验证
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("10.5.61.6", "YULON-FINANCE\\it01", "bnm,./789"); 
		// SmbFile fp = new SmbFile(remoteurl+"//"+dir,auth);
		// test.smbPut("smb://10.12.91.156/smp_shared", "C:\\contract1659.pdf", auth);
		// test.smbGet("smb://10.12.91.156/smp_shared/contractvayiVyjK.pdf",
		// "C://asd.pdf", auth);
		String url = "smb://10.5.61.6/shares/征信报告存档文件夹/OA附件";
		smbPut(url, "D:/test.xls", auth);
		
//		OutputStream os = new FileOutputStream("D:/test.xls");
//		IOUtils.write(smbGet(url, auth), os);
		
//        smbDel(url, auth);
	}
}


