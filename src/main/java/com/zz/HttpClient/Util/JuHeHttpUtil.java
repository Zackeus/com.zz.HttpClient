package com.zz.HttpClient.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.HttpClient.HttpClientResult;
import com.zz.HttpClient.Config.GlobalConfig;
import com.zz.HttpClient.Config.JuHeConfig;
import com.zz.HttpClient.Util.HttpClient.HttpClientUtil;
import com.zz.HttpClient.Bean.CollectionTel;
import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.Task;
import com.zz.HttpClient.Bean.TaskConfig;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * @Title:JuHeHttp
 * @Description:TODO(聚合速驰接口工具类)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月5日 下午3:59:23
 */
@Component
public class JuHeHttpUtil {

	@Resource(name = "juHeConfig")
	private JuHeConfig juHeConfig;

	public static JuHeHttpUtil juHeHttpUtil;

	/**
	 * 
	 * @Title:init
	 * @Description: TODO(初始化的时候，将本类中的juHeConfig赋值给静态的本类变量)
	 */
	@PostConstruct
	public void init() {
		juHeHttpUtil = this;
		juHeHttpUtil.juHeConfig = this.juHeConfig;
	}

	/**
	 * 
	 * @Title:getToken
	 * @Description: TODO(获取鉴权)
	 * @param username
	 *            登录帐号
	 * @param password
	 *            登录密码
	 * @return
	 * @throws Exception
	 */
	public static String getToken(String username, String password) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		map.put("grant_type", "password");
		map.put("client_type", "8");

		HttpClientResult httpClientResult = HttpClientUtil.doGet(juHeHttpUtil.juHeConfig.getGetToken(), map);
		if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
			String token = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
					.getJSONArray("rows").getJSONObject(0).getString("access_token");
			return token;
		}
		return null;
	}

	/**
	 * 
	 * @Title:searchVoice
	 * @Description: TODO(查询发音人列表)
	 * @param id
	 *            发音人ID(否)
	 * @param version
	 *            发音人版本(否)
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult searchVoice() throws Exception {
		return searchVoice(null, null);
	}

	/**
	 * 
	 * @Title:searchVoice
	 * @Description: TODO(查询发音人列表)
	 * @param id
	 *            发音人ID(否)
	 * @param version
	 *            发音人版本(否)
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult searchVoice(Long id, Integer version) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("version", version);
		return HttpClientUtil.doPostJson(juHeHttpUtil.juHeConfig.getSearchVoice(), jsonObject);
	}

	/**
	 * 
	 * @Title:searchSpeechSkill
	 * @Description: TODO(查询话术列表 )
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult searchSpeechSkill() throws Exception {
		return HttpClientUtil.doPost(juHeHttpUtil.juHeConfig.getSearchSpeechSkill());
	}

	/**
	 * 
	 * @Title:searchTel
	 * @Description: TODO(查询企业外呼号码)
	 * @param token
	 *            鉴权信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<CollectionTel> searchTel(String token) throws Exception {
		HttpClientResult httpClientResult = HttpClientUtil.doPost(juHeHttpUtil.juHeConfig.getSearchTel() + token);
		if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
			List<CollectionTel> collectionTels = JSONArray.toList(
					JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result").getJSONArray("rows"),
					new CollectionTel(), new JsonConfig());
			return collectionTels;
		}
		return new ArrayList<CollectionTel>();
	}

	/**
	 * 
	 * @Title:uploadExcelDataExcel
	 * @Description: TODO(数据上传)
	 * @param filePath
	 *            文件路径
	 * @param speechSkillId
	 *            话术ID
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult uploadExcelDataExcel(String filePath, Long speechSkillId) throws Exception {
		String fileName = new File(filePath).getName();
		Map<String, ContentBody> reqParam = new HashMap<String, ContentBody>();
		reqParam.put("OBJECT", new FileBody(new File(filePath)));
		reqParam.put("fileSuffix",
				new StringBody(fileName.substring(fileName.lastIndexOf(".") + 1), ContentType.MULTIPART_FORM_DATA));
		reqParam.put("speechSkillId", new StringBody(Long.toString(speechSkillId), ContentType.MULTIPART_FORM_DATA));
		return HttpClientUtil.postFileMultiPart(juHeHttpUtil.juHeConfig.getUploadExcelDataExcel(), reqParam);
	}

	/**
	 * 
	 * @Title:manageTask
	 * @Description: TODO(管理外呼任务)
	 * @param task
	 *            任务信息
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult manageTask(Task task) throws Exception {
		return HttpClientUtil.doPostJson(juHeHttpUtil.juHeConfig.getManageTask(), JSONObject.fromObject(task));
	}

	/**
	 * 
	 * @Title:searchTaskList
	 * @Description: TODO(查询任务集合)
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult searchTaskList(Long taskId) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("taskId", taskId);
		return HttpClientUtil.doPostJson(juHeHttpUtil.juHeConfig.getSearchTaskList(), jsonObject);
	}

	/**
	 * 
	 * @Title:createTask
	 * @Description: TODO(创建任务)
	 * @param customers
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult createTask(List<Customer> customers, TaskConfig taskDataConfig) throws Exception {
		// 创建文件目录
		String orgFileName = OrderNoUtil.getDetailOrderNo() + ".xls";
		String orgFilePath = GlobalConfig.filePath + DateUtils.getDate(DateUtils.parsePatterns[0]) + "/" + orgFileName;
		FileUtil.makeDirectory(orgFilePath);

		// 生成上传的xls
		HSSFWorkbook firstWb = (HSSFWorkbook) ExcelUtil.exportExcel(customers, Customer.class, null,
				ExcelUtil.EXCEL_FILE_2003);
		firstWb.write(new FileOutputStream(orgFilePath));

		// 获取上传数据的文件名
		String fileName = JSONObject
				.fromObject(uploadExcelDataExcel(orgFilePath, juHeHttpUtil.juHeConfig.getSpeechSkillId()).getContent())
				.getJSONObject("result").getJSONArray("rows").getJSONObject(0).getString("fileName");

		// 创建 taskConfig
		TaskConfig taskConfig = createTaskConfig(fileName, orgFileName, taskDataConfig);

		// 创建 task
		Task task = new Task(1, new Long(OrderNoUtil.getRandNum(6)), 1, taskConfig);

		return manageTask(task);
	}
	
	/**
	 * 
	 * @Title:createTask
	 * @Description: TODO(创建担保人催收任务)
	 * @param customers
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult createGuaranteeTask(List<Guarantee> guarantees, TaskConfig taskDataConfig) throws Exception {
		// 创建文件目录
		String orgFileName = OrderNoUtil.getDetailOrderNo() + ".xls";
		String orgFilePath = GlobalConfig.filePath + DateUtils.getDate(DateUtils.parsePatterns[0]) + "/" + orgFileName;
		FileUtil.makeDirectory(orgFilePath);

		// 生成上传的xls
		HSSFWorkbook firstWb = (HSSFWorkbook) ExcelUtil.exportExcel(guarantees, Guarantee.class, null,
				ExcelUtil.EXCEL_FILE_2003);
		firstWb.write(new FileOutputStream(orgFilePath));
		
		// 获取上传数据的文件名
		String fileName = JSONObject
				.fromObject(uploadExcelDataExcel(orgFilePath, juHeHttpUtil.juHeConfig.getSpeechSkillId()).getContent())
				.getJSONObject("result").getJSONArray("rows").getJSONObject(0).getString("fileName");

		// 创建 taskConfig
		TaskConfig taskConfig = createGuaranteeTaskConfig(fileName, orgFileName, taskDataConfig);

		// 创建 task
		Task task = new Task(1, new Long(OrderNoUtil.getRandNum(6)), 1, taskConfig);

		return manageTask(task);
	}

	/**
	 * 
	 * @Title:createTaskConfig
	 * @Description: TODO(创建 taskConfig)
	 * @param fileName
	 * @param orgFileName
	 * @return
	 */
	public static TaskConfig createTaskConfig(String fileName, String orgFileName, TaskConfig taskDataConfig) {
		return new TaskConfig(fileName, orgFileName, taskDataConfig.getName(), System.currentTimeMillis(),
				DateUtils.getTimesnight(), juHeHttpUtil.juHeConfig.getSpeechSkillId(),
				juHeHttpUtil.juHeConfig.getRobotVoiceId(), 80, 0, null, taskDataConfig.getTelNum(),
				juHeHttpUtil.juHeConfig.getSysType(), juHeHttpUtil.juHeConfig.getTimeRange(), 1,
				taskDataConfig.getRecallMaxCount(), taskDataConfig.getRecallWaitTime(),
				juHeHttpUtil.juHeConfig.getRecallStatus());
	}
	
	/**
	 * 
	 * @Title:createTaskConfig
	 * @Description: TODO(创建担保人 taskConfig)
	 * @param fileName
	 * @param orgFileName
	 * @return
	 */
	public static TaskConfig createGuaranteeTaskConfig(String fileName, String orgFileName, TaskConfig taskDataConfig) {
		return new TaskConfig(fileName, orgFileName, taskDataConfig.getName(), System.currentTimeMillis(),
				DateUtils.getTimesnight(), juHeHttpUtil.juHeConfig.getGuaranteeSpeechSkillId(),
				juHeHttpUtil.juHeConfig.getRobotVoiceId(), 80, 0, null, taskDataConfig.getTelNum(),
				juHeHttpUtil.juHeConfig.getSysType(), juHeHttpUtil.juHeConfig.getTimeRange(), 1,
				taskDataConfig.getRecallMaxCount(), taskDataConfig.getRecallWaitTime(),
				juHeHttpUtil.juHeConfig.getRecallStatus());
	}

	/**
	 * 
	 * @Title:main
	 * @Description: TODO(测试)
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/spring-*.xml");
//		SendOdCustomerService sendOdCustomerService = (SendOdCustomerService) context.getBean("sendOdCustomerService");
//		
//		// 创建文件目录
//		String orgFileName = OrderNoUtil.getDetailOrderNo() + ".xls";
//		String orgFilePath = GlobalConfig.filePath + DateUtils.getDate(DateUtils.parsePatterns[0]) + "/" + orgFileName;
//		FileUtil.makeDirectory(orgFilePath);
//
//		List<Customer> customers = new ArrayList<>();
//		customers.add(new Customer(null, "HP123456", "张舟", "借款人", new Long("15058041631"), new Long("15"),
//				new BigDecimal("2596.32"), "户籍地", "17037", null, null, "Test"));
//
//		HSSFWorkbook firstWb = (HSSFWorkbook) ExcelUtil.exportExcel(customers, Customer.class, null,
//				ExcelUtil.EXCEL_FILE_2003);
//		firstWb.write(new FileOutputStream(orgFilePath));
//
//		// 获取上传数据的文件名
//		String fileName = JSONObject
//				.fromObject(uploadExcelDataExcel(orgFilePath, juHeHttpUtil.juHeConfig.getSpeechSkillId()).getContent())
//				.getJSONObject("result").getJSONArray("rows").getJSONObject(0).getString("fileName");
//
//		// 创建 taskConfig
//		List<Integer> recallStatus = new ArrayList<>();
//		recallStatus.add(3);
//		List<String> timeRange = new ArrayList<>();
//		timeRange.add("07:30:00-23:30:00");
//
//		TaskConfig taskConfig = new TaskConfig(fileName, orgFileName, "测试", System.currentTimeMillis(),
//				DateUtils.getTimesnight(), new Long("7312"), 48, 80, 0, null, "64000272", 2, timeRange, 1, 0, 5,
//				recallStatus);
//
//		// 创建 task
//		Task task = new Task(1, new Long(OrderNoUtil.getRandNum(6)), 1, taskConfig);
//
//		HttpClientResult httpClientResult = manageTask(task);
//		if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
//			String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
//					.getJSONArray("rows").getJSONObject(0).getString("taskId");
//			
//			sendOdCustomerService.insertCollectionInfo(taskId, "17037", "Test", customers, null);
//		}
//		System.out.println("结束");
		
		/********* 删除任务 ***********/
		System.out.println(HttpClientUtil.doPostJson("https://ptah.kxjlcc.com/yungo-outbound/api/v1/outbound/task/2940/manageTask", 
				JSONObject.fromObject(new Task(3, new Long("59804"), 1, null))));
	}
}
