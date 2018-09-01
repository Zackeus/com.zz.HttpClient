package com.zz.HttpClient.Util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.zz.HttpClient.Util.HttpClient.Md5Util;

/**
 * 
 * @Title:CacheKeyGenerator
 * @Description:TODO(自定义缓存 Key 生成策略，可以解决：多参数、原子类型数组、方法名识别 等问题)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月31日 下午6:24:07
 */
@Component
public class CacheKeyGenerator implements KeyGenerator {
	
	// custom cache key
    public static final int NO_PARAM_KEY = 0;
    public static final int NULL_PARAM_KEY = 53;
    
    @Override
    public Object generate(Object target, Method method, Object... params) {
    	
        StringBuilder key = new StringBuilder();
        key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
        if (params.length == 0) {
            return key.append(NO_PARAM_KEY).toString();
        }
        for (Object param : params) {
            if (param == null) {
                key.append(NULL_PARAM_KEY);
            } else if (ClassUtils.isPrimitiveArray(param.getClass())) {
                int length = Array.getLength(param);
                for (int i = 0; i < length; i++) {
                    key.append(Array.get(param, i));
                    key.append(',');
                }
            } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {
                key.append(param);
            } else {
            	// 实体 Bean 参数 Key生成策略 :使用反射将 属性和对应值注入 Key中
            	for (Field field : param.getClass().getDeclaredFields()) {
                	try {
                		field.setAccessible(true);
                    	key.append(field.getName());
						key.append(field.get(param));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						Logs.error("自定义缓存key异常，" + e.getMessage());
						throw new MyException("自定义缓存key异常，" + e.getMessage());
					}
                }
            }
            key.append('-');
        }
//        String finalKey = key.toString();
//        long cacheKeyHash = Hashing.murmur3_128().hashString(finalKey, Charset.defaultCharset()).asLong();
//        Logs.info("using cache key={} hashCode={}" + finalKey + " : " + cacheKeyHash);
        
        // 使用 MD5 作为缓存 Key
        return Md5Util.getMD5String(key.toString());
    }

}
