package com.zz.HttpClient.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Util.annotation.excel.ExcelField;

/**
 * 
 * @Title:ExcelUtil
 * @Description:TODO(excel导出封装类)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月17日 上午10:55:24
 */
public class ExcelUtil {

	// 2007 版本以上 最大支持1048576行
	public final static String EXCEl_FILE_2007 = "2007";
	// 2003 版本 最大支持65536 行
	public final static String EXCEL_FILE_2003 = "2003";

	/**
	 * 
	 * @param <Q>
	 * @Title:exportExcel
	 * @Description: TODO(导出无头部标题行Excel)
	 * @param title
	 *            表格标题
	 * @param dataset
	 *            数据集合
	 * @param out
	 *            输出流
	 * @param version
	 *            2003 或者 2007，不传时默认生成2003版本
	 * @return 
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <Q> Workbook exportExcel(List<Q> list, Class<Q> cls, Q sumData, String version)
			throws IllegalArgumentException, IllegalAccessException, IOException {
		if (StringUtils.isEmpty(version) || EXCEL_FILE_2003.equals(version.trim())) {
			return exportExcel2003(list, cls, sumData);
		} else {
			return exportExcel2007(list, cls, sumData);
		}
	}

	/**
	 * 
	 * @Title:exportExcel2003
	 * @Description: TODO(生成excel2003)
	 * @param list
	 * @param cls
	 * @param sumData
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static <Q> HSSFWorkbook exportExcel2003(List<Q> list, Class<Q> cls, Q sumData)
			throws IllegalArgumentException, IllegalAccessException, IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		Field[] fields = cls.getDeclaredFields();
		ArrayList<String> headList = new ArrayList<String>();

		// 添加合计数据
		if (sumData != null) {
			list.add(sumData);
		}

		for (Field f : fields) {
			ExcelField field = f.getAnnotation(ExcelField.class);
			if (field != null) {
				headList.add(field.title());
			}
		}

		HSSFCellStyle titleStyle = getTitleStyle2003(wb);
		HSSFCellStyle cellStyle = getCellStyle2003(wb);
		
		HSSFSheet sheet = wb.createSheet();
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		
		// 设置Excel表的第一行即表头
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headList.size(); i++) {
			HSSFCell headCell = row.createCell(i);
			// 设置表头样式
			headCell.setCellStyle(titleStyle);
			headCell.setCellValue(new HSSFRichTextString(headList.get(i)));
		}

		for (int i = 0; i < list.size(); i++) {
			HSSFRow rowdata = sheet.createRow(i + 1);// 创建数据行
			Q q = list.get(i);
			Field[] ff = q.getClass().getDeclaredFields();
			int j = 0;
			for (Field f : ff) {
				ExcelField field = f.getAnnotation(ExcelField.class);
				if (field == null) {
					continue;
				}
				f.setAccessible(true);
				Object obj = f.get(q);
				HSSFCell cell = rowdata.createCell(j);
				cell.setCellStyle(cellStyle);

				// 当数字时
				if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
					// 将序号替换为123456
					if (j == 0)
						cell.setCellValue(i + 1);
				}
				// 当为Long时
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
				// 当为字符串时
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				// 当为布尔时
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				// 当为时间时
				else if (obj instanceof Date)
					cell.setCellValue(DateUtils.formatDate((Date) obj, DateUtils.parsePatterns[1]));
				// 当为时间时
				else if (obj instanceof Calendar)
					cell.setCellValue((Calendar) obj);
				// 当为小数时
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				// 其它数据类型都当作字符串简单处理
				else {
					if (obj != null) {
						cell.setCellValue(ObjectUtils.toString(obj));
					}
				}
				j++;
			}
		}

		if (sumData != null) {
			int rowIndex = list.size();
			HSSFRow sumRow = sheet.getRow(rowIndex);
			HSSFCell sumCell = sumRow.getCell(0);
			sumCell.setCellStyle(titleStyle);
			sumCell.setCellValue("合计");
		}
		return wb;
	}

	/**
	 * 
	 * @Title:createExcel
	 * @Description: TODO(生成excel)
	 * @param list 导出的数据
	 * @param cls list里的实体class
	 * @param sumData sumData合计数据
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <Q> XSSFWorkbook exportExcel2007(List<Q> list, Class<Q> cls, Q sumData)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		XSSFWorkbook wb = new XSSFWorkbook();
		Field[] fields = cls.getDeclaredFields();
		ArrayList<String> headList = new ArrayList<String>();

		// 添加合计数据
		if (sumData != null) {
			list.add(sumData);
		}

		for (Field f : fields) {
			ExcelField field = f.getAnnotation(ExcelField.class);
			if (field != null) {
				headList.add(field.title());
			}
		}

		XSSFCellStyle titleStyle = getTitleStyle2007(wb);
		XSSFCellStyle cellStyle = getCellStyle2007(wb);
		XSSFSheet sheet = wb.createSheet();
		// 设置Excel表的第一行即表头
		XSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headList.size(); i++) {
			XSSFCell headCell = row.createCell(i);
			// 设置表头样式
			headCell.setCellStyle(titleStyle);
			headCell.setCellValue(new XSSFRichTextString(headList.get(i)));
			// 设置单元格自适应
			sheet.autoSizeColumn((short) i);
			sheet.setColumnWidth(0, 15 * 256);
		}

		for (int i = 0; i < list.size(); i++) {
			XSSFRow rowdata = sheet.createRow(i + 1);// 创建数据行
			Q q = list.get(i);
			Field[] ff = q.getClass().getDeclaredFields();
			int j = 0;
			for (Field f : ff) {
				ExcelField field = f.getAnnotation(ExcelField.class);
				if (field == null) {
					continue;
				}
				f.setAccessible(true);
				Object obj = f.get(q);
				XSSFCell cell = rowdata.createCell(j);
				cell.setCellStyle(cellStyle);

				// 当数字时
				if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
					// 将序号替换为123456
					if (j == 0)
						cell.setCellValue(i + 1);
				}
				// 当为Long时
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
				// 当为字符串时
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				// 当为布尔时
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				// 当为时间时
				else if (obj instanceof Date)
					cell.setCellValue(DateUtils.formatDate((Date) obj, DateUtils.parsePatterns[1]));
				// 当为时间时
				else if (obj instanceof Calendar)
					cell.setCellValue((Calendar) obj);
				// 当为小数时
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				// 其它数据类型都当作字符串简单处理
				else {
					if (obj != null) {
						cell.setCellValue(ObjectUtils.toString(obj));
					}
				}
				j++;
			}
		}

		if (sumData != null) {
			int rowIndex = list.size();
			XSSFRow sumRow = sheet.getRow(rowIndex);
			XSSFCell sumCell = sumRow.getCell(0);
			sumCell.setCellStyle(titleStyle);
			sumCell.setCellValue("合计");
		}
		return wb;
	}

	/**
	 * 
	 * @Title:writeExcel
	 * @Description: TODO(导出)
	 * @param response
	 * @param fileName
	 * @param wb
	 * @throws IOException
	 */
	public static void writeExcel(HttpServletResponse response, String fileName, XSSFWorkbook wb) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		OutputStream ouputStream = null;
		try {
			ouputStream = response.getOutputStream();
			wb.write(ouputStream);
		} finally {
			ouputStream.close();
		}
	}

	/**
	 * 
	 * @Title:getCellStyle
	 * @Description: TODO(表头样式)
	 * @param wb
	 * @return
	 */
	private static XSSFCellStyle getTitleStyle2007(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.SOLID_FOREGROUND); // 让单元格居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中
		style.setWrapText(true); // 设置自动换行
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setColor(new XSSFColor(java.awt.Color.BLACK));
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);
		return style;
	}

	/**
	 * 
	 * @Title:getCellStyle
	 * @Description: TODO(单元格样式)
	 * @param wb
	 * @return
	 */
	private static XSSFCellStyle getCellStyle2007(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 
	 * @Title:getTitleStyle2003
	 * @Description: TODO(表头样式)
	 * @param wb
	 * @return
	 */
	private static HSSFCellStyle getTitleStyle2003(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setColor(HSSFColor.WHITE.index);
		font.setFontHeightInPoints((short) 11);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 
	 * @Title:getCellStyle2003
	 * @Description: TODO(单元格样式)
	 * @param wb
	 * @return
	 */
	private static HSSFCellStyle getCellStyle2003(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		style.setFont(font);
		return style;
	}

	/**
	 * 
	 * @Title:getExcelName
	 * @Description: TODO(转化为excel名称)
	 * @param filename
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getExcelName(String filename) throws UnsupportedEncodingException {
		String excelName = StringUtils.join(filename, ".xlsx");
		return URLEncoder.encode(excelName, "UTF-8");
	}
	
	/**
	 * 
	 * @Title:main
	 * @Description: TODO(测试)
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(new Long("123456"), "HP123456", "张舟", "借款人", new Long("15058041631"), new Long("5"), 
				new BigDecimal("2516.32"), null, "17037", "2018-01-12", "T", "T-1"));
		
		HSSFWorkbook firstWb = (HSSFWorkbook) ExcelUtil.exportExcel(customers, Customer.class, null, EXCEL_FILE_2003);
		firstWb.write(new FileOutputStream("D:/TEST.xls"));
		
		XSSFWorkbook secondWb = (XSSFWorkbook) ExcelUtil.exportExcel(customers, Customer.class, null, EXCEl_FILE_2007);
		secondWb.write(new FileOutputStream("D:/TEST.xlsx"));
	}
}
