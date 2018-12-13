package com.zz.HttpClient.modules.timer.jobClass;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.config.SMBConfig;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.common.utils.ExcelUtil;
import com.zz.HttpClient.common.utils.FileUtil;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.SMBUtils;
import com.zz.HttpClient.common.utils.ZipUtils;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.common.utils.httpClient.HttpStatus;
import com.zz.HttpClient.modules.timer.config.ReportFormConfig;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerReportForm;
import com.zz.HttpClient.modules.timer.service.ReportFormService;

/**
 * 
 * @Title:CustomerReportFormJob
 * @Description:TODO(催收报表排程任务)
 * @Company:
 * @author zhou.zhang
 * @date 2018年12月12日 下午3:02:59
 */
@Component
@DisallowConcurrentExecution
public class CustomerReportFormJob extends BaseJob {

	@Autowired
	ReportFormService reportFormService;

	@Autowired
	ReportFormConfig reportFormConfig;
	
	@Autowired
	SMBConfig smbConfig;

	/**
	 * 任务执行
	 */
	@Override
	protected void executeJob(String jobName) {

		try {
			String toDayDate = DateUtils.getDate();
			String firstFileName = GlobalConfig.firstTime + ".xlsx";
			String secondFileName = GlobalConfig.secondTime + ".xlsx";
			String thirdFileName = GlobalConfig.thirdTime + ".xlsx";
			String fouthFileName = GlobalConfig.fouthTime + ".xlsx";
			String orgFilePath = reportFormConfig.getFilePath() + DateUtils.getYear() + "-" + DateUtils.getMonth()
					+ "月/" + toDayDate;
			FileUtil.makeDirectory(orgFilePath + "/" + firstFileName);

			XSSFWorkbook firstWb = (XSSFWorkbook) ExcelUtil.exportExcel(
					reportFormService.getOdReportForm(GlobalConfig.firstTime), CustomerReportForm.class, null,
					ExcelUtil.EXCEl_FILE_2007);
			firstWb.write(new FileOutputStream(orgFilePath + "/" + firstFileName));

			XSSFWorkbook secondWb = (XSSFWorkbook) ExcelUtil.exportExcel(
					reportFormService.getOdReportForm(GlobalConfig.secondTime), CustomerReportForm.class, null,
					ExcelUtil.EXCEl_FILE_2007);
			secondWb.write(new FileOutputStream(orgFilePath + "/" + secondFileName));

			XSSFWorkbook thirdWb = (XSSFWorkbook) ExcelUtil.exportExcel(
					reportFormService.getOdReportForm(GlobalConfig.thirdTime), CustomerReportForm.class, null,
					ExcelUtil.EXCEl_FILE_2007);
			thirdWb.write(new FileOutputStream(orgFilePath + "/" + thirdFileName));

			XSSFWorkbook fouthWb = (XSSFWorkbook) ExcelUtil.exportExcel(
					reportFormService.getOdReportForm(GlobalConfig.fouthTime), CustomerReportForm.class, null,
					ExcelUtil.EXCEl_FILE_2007);
			fouthWb.write(new FileOutputStream(orgFilePath + "/" + fouthFileName));

			// 文件压缩
			String zipPath = reportFormConfig.getFilePath() + "/" + toDayDate + ".zip";
			ZipUtils.toZip(orgFilePath, new FileOutputStream(new File(zipPath)), Boolean.TRUE);
			
			// 远程上传
			SMBUtils.smbPut(reportFormConfig.getSmbPath(), zipPath, smbConfig);

		} catch (Exception e) {
			Logs.error("催收报表排程异常：" + Logs.toLog(e));
			throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "催收报表排程异常," + e.toString());
		}
	}

}
