package com.zz.HttpClient.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;

public class ListUtil extends ListUtils {

	/**
	 * 
	 * @Title:averageAssign
	 * @Description: TODO(将一个list均分成n个list,主要通过偏移量来实现的)
	 * @param source
	 * @param n
	 * @return
	 */
	public static <T> List<List<T>> listSplite(List<T> source, int n) {
		List<List<T>> result = new ArrayList<List<T>>();
		// (先计算出余数)
		int remaider = source.size() % n;
		// 然后是商
		int number = source.size() / n;
		// 偏移量
		int offset = 0;
		for (int i = 0; i < n; i++) {
			List<T> value = null;
			if (remaider > 0) {
				value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
				remaider--;
				offset++;
			} else {
				value = source.subList(i * number + offset, (i + 1) * number + offset);
			}
			result.add(value);
		}
		return result;
	}

	/**
	 * 
	 * @Title:getNoRepeatList
	 * @Description: TODO(去除List内复杂字段重复对象)
	 * @param beanList
	 * @return
	 */
	public static <T> List<T> getNoRepeatList(List<T> beanList) {
		List<T> list = new ArrayList<T>();
		if (CollectionUtils.isNotEmpty(beanList)) {
			for (T bean : beanList) {
				// list去重复，内部重写equals
				if (!list.contains(bean)) {
					list.add(bean);
				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @Title:getNoRepeatList
	 * @Description: TODO(去除重复数据)
	 * @param checkList
	 *            对比List
	 * @param repeatList
	 *            待操作List
	 * @return
	 */
	public static <T> List<T> getNoRepeatList(List<T> checkList, List<T> repeatList) {
		List<T> list = new ArrayList<T>();
		if (CollectionUtils.isNotEmpty(checkList) && CollectionUtils.isNotEmpty(repeatList)) {
			for (T bean : repeatList) {
				// list去重复，内部重写equals
				if (!checkList.contains(bean)) {
					list.add(bean);
				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @Title:getNoRepeatList
	 * @Description: TODO(拆分重复List)
	 * @param beanList
	 * @return
	 */
	public static <T> Map<String, Object> getSplitList(List<T> beanList) {
		Map<String, Object> map = new HashMap<>();
		List<T> list = new ArrayList<T>();
		List<T> repeatList = new ArrayList<T>();
		if (CollectionUtils.isNotEmpty(beanList)) {
			for (T bean : beanList) {
				// list去重复，内部重写equals
				if (!list.contains(bean)) {
					list.add(bean);
				} else {
					repeatList.add(bean);
				}
			}
		}
		map.put("list", list);
		map.put("repeatList", repeatList);
		
		return map;
	}

	/**
	 * 
	 * @Title:isRepeatByList
	 * @Description: TODO(判断是否包含重复数据)
	 * @param beanList
	 * @return
	 */
	public static <T> boolean isRepeatByList(List<T> beanList) {
		List<T> list = new ArrayList<T>();
		if (CollectionUtils.isNotEmpty(beanList)) {
			for (T bean : beanList) {
				if (list.contains(bean)) {
					return true;
				}
				list.add(bean);
			}
		}
		return false;
	}

	/**
	 * 
	 * @Title:main
	 * @Description: TODO(测试)
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
