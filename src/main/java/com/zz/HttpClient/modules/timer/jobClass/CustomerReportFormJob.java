package com.zz.HttpClient.modules.timer.jobClass;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.common.utils.ExcelUtil;
import com.zz.HttpClient.common.utils.FileUtil;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.modules.timer.config.ReportFormConfig;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerReportForm;
import com.zz.HttpClient.modules.timer.service.CommonTimerService;
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
	
	/**
	 * 前置操作
	 */
	@Override
	protected boolean preHandle(String jobName) {
		return super.preHandle(jobName);
	}
	
	/**
	 * 任务执行
	 */
	@Override
	protected void executeJob(String jobName) {
		Logs.info(jobName + " :执行操作************************");
		
//		try {
//		
//		String firstFileName = GlobalConfig.firstTime + ".xlsx";
//		String secondFileName = GlobalConfig.secondTime + ".xlsx";
//		String thirdFileName = GlobalConfig.thirdTime + ".xlsx";
//		String fouthFileName = GlobalConfig.fouthTime + ".xlsx";
//		String orgFilePath = reportFormConfig.getFilePath() + DateUtils.getYear() + "-" + DateUtils.getMonth() + "月/"
//				+ DateUtils.getDate();
//		FileUtil.makeDirectory(orgFilePath + "/" + firstFileName);
//
//		XSSFWorkbook firstWb = (XSSFWorkbook) ExcelUtil.exportExcel(
//				reportFormService.getOdReportForm(GlobalConfig.firstTime), CustomerReportForm.class, null,
//				ExcelUtil.EXCEl_FILE_2007);
//		firstWb.write(new FileOutputStream(orgFilePath + "/" + firstFileName));
//
//		XSSFWorkbook secondWb = (XSSFWorkbook) ExcelUtil.exportExcel(
//				reportFormService.getOdReportForm(GlobalConfig.secondTime), CustomerReportForm.class, null,
//				ExcelUtil.EXCEl_FILE_2007);
//		secondWb.write(new FileOutputStream(orgFilePath + "/" + secondFileName));
//
//		XSSFWorkbook thirdWb = (XSSFWorkbook) ExcelUtil.exportExcel(
//				reportFormService.getOdReportForm(GlobalConfig.thirdTime), CustomerReportForm.class, null,
//				ExcelUtil.EXCEl_FILE_2007);
//		thirdWb.write(new FileOutputStream(orgFilePath + "/" + thirdFileName));
//
//		XSSFWorkbook fouthWb = (XSSFWorkbook) ExcelUtil.exportExcel(
//				reportFormService.getOdReportForm(GlobalConfig.fouthTime), CustomerReportForm.class, null,
//				ExcelUtil.EXCEl_FILE_2007);
//		fouthWb.write(new FileOutputStream(orgFilePath + "/" + fouthFileName));
//		
//	} catch (Exception e) {
//		Logs.error("催收报表排程异常：" + Logs.toLog(e));
//	}
	}
	
	/**
	 * 后置操作
	 */
	@Override
	protected void afterHandle(String jobName) {
		super.afterHandle(jobName);
	}
	
	/**
	 * 异常处理
	 */
	@Override
	protected void cleanup(String jobName, Exception e) throws JobExecutionException {
		super.cleanup(jobName, e);
	}

}
