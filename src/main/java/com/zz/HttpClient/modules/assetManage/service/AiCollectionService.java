package com.zz.HttpClient.modules.assetManage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.entity.echarts.Grid;
import com.zz.HttpClient.common.entity.echarts.Legend;
import com.zz.HttpClient.common.entity.echarts.Option;
import com.zz.HttpClient.common.entity.echarts.Series;
import com.zz.HttpClient.common.entity.echarts.Title;
import com.zz.HttpClient.common.entity.echarts.Toolbox;
import com.zz.HttpClient.common.entity.echarts.Tooltip;
import com.zz.HttpClient.common.entity.echarts.XAxis;
import com.zz.HttpClient.common.entity.echarts.YAxis;
import com.zz.HttpClient.common.service.CrudService;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.modules.assetManage.dao.AiCollectionDao;
import com.zz.HttpClient.modules.assetManage.entity.AiCollectionInfo;
import com.zz.HttpClient.modules.assetManage.entity.AiCollectionResult;
import com.zz.HttpClient.modules.assetManage.entity.StatisticsSearchParameters;

/**
 * 
 * @Title:AiCollectionService
 * @Description:TODO(智能催收Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月10日 下午4:26:06
 */
@Service("aiCollectionService")
public class AiCollectionService extends CrudService<AiCollectionDao, AiCollectionInfo> {
	
	@Autowired
	private AiCollectionDao aiCollectionDao;
	
	/**
	 * 
	 * @Title：connectionRateStatisticsByTime
	 * @Description: TODO(接通率统计(时间))
	 * @see：
	 * @param searchParameters
	 * @return
	 */
	@Cacheable(value = {"echartsCache"}, keyGenerator = "cacheKeyGenerator")
	public Option collectionRateStatisticsByTime(StatisticsSearchParameters searchParameters) {
		// 图例组件 数据
		List<Object> legendData = new ArrayList<>();
		// y轴数据
		List<Series> optionSeries = new ArrayList<>();
		// x轴
		List<Object> xAxisData = new ArrayList<>();
		
		for(int i = Integer.valueOf(searchParameters.getStartHour()); 
				i <= Integer.valueOf(searchParameters.getEndHour()); i++) {
			xAxisData.add(i);
		}
		
		for(Date date : DateUtils.getBetweenDates(searchParameters.getStartDay(), searchParameters.getEndDay())) {
			legendData.add(DateUtils.formatDate(date));
			Series series = new Series(DateUtils.formatDate(date));
			// y轴数据
			List<Object> seriesData = new ArrayList<>();
			for(int i = Integer.valueOf(searchParameters.getStartHour()); 
					i <= Integer.valueOf(searchParameters.getEndHour()); i++) {
				AiCollectionResult aiCollectionResult =  aiCollectionDao.collectionRateStatisticsByTime(date, i);
				seriesData.add(aiCollectionResult.getTotal() == 0 ? 0 : 
					(float) aiCollectionResult.getSucNum() / (float) aiCollectionResult.getTotal() * 100);
			}
			series.setData(seriesData);
			optionSeries.add(series);
		}
		return new Option(new Title(searchParameters.getTypeName()),new Tooltip(), new Legend(legendData), 
				new Grid(), new Toolbox(), new XAxis("时间段(h)", xAxisData), new YAxis("接通率(%)"), optionSeries);
	}
	
	/**
	 * 
	 * @Title：collectionRateStatisticsByAge
	 * @Description: TODO(接通率统计(年龄))
	 * @see：
	 * @param searchParameters
	 * @return
	 */
	@Cacheable(value = {"echartsCache"}, keyGenerator = "cacheKeyGenerator")
	public Option collectionRateStatisticsByAge(StatisticsSearchParameters searchParameters) {
		List<Object> legendData = new ArrayList<>();
		List<Object> xAxisData = new ArrayList<>();
		List<Series> optionSeries = new ArrayList<>();
		
		for(int i = searchParameters.getStartAge(); i < searchParameters.getEndAge(); i += 5) {
			xAxisData.add((i + 1) + "-" + (i + 5));
		}
		
		for(Date date : DateUtils.getBetweenDates(searchParameters.getStartDay(), searchParameters.getEndDay())) {
			legendData.add(DateUtils.formatDate(date));
			Series series = new Series(DateUtils.formatDate(date));
			List<Object> seriesData = new ArrayList<>();
			for(int i = searchParameters.getStartAge(); i < searchParameters.getEndAge(); i += 5) {
				AiCollectionResult aiCollectionResult =  aiCollectionDao.collectionRateStatisticsByAge(date, i + 1, i + 5);
				seriesData.add(aiCollectionResult.getTotal() == 0 ? 0 : 
					(float) aiCollectionResult.getSucNum() / (float) aiCollectionResult.getTotal() * 100);
			}
			series.setData(seriesData);
			optionSeries.add(series);
		}
		return new Option(new Title(searchParameters.getTypeName()),new Tooltip(), new Legend(legendData), 
				new Grid(), new Toolbox(), new XAxis("年龄段(s)", xAxisData), new YAxis("接通率(%)"), optionSeries);
	}
}
