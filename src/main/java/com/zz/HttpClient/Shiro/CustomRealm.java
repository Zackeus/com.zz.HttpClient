package com.zz.HttpClient.Shiro;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.Bean.Sys.Principal;
import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Bean.Sys.UsernamePasswordToken;
import com.zz.HttpClient.Service.SystemService;
import com.zz.HttpClient.Util.Encodes;
import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:CustomRealm
 * @Description:TODO()
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月10日 上午10:49:28
 */
public class CustomRealm extends AuthorizingRealm {
	
	@Autowired
	SystemService systemService;
	
	 /** 
     * 登陆认证
     */
	@Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
    	Logs.info("*************** 登陆认证 ******************");
    	//令牌——基于用户名和密码的令牌,把AuthenticationToken转换成UsernamePasswordToken
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    	
    	User user = systemService.getUserByLoginName(token.getUsername());
    	
    	if (user != null) {
    	 	Logs.info("账号：" + user.getLoginName());
        	Logs.info("密码：" + user.getPassword());
        	
        	// 密码认证 见initCredentialsMatcher() 方法
        	byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
        	return new SimpleAuthenticationInfo(new Principal(user, false), 
        			user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
    	} 
    	return null;
    } 
    
	/**
	 * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， 登录成功后调用
	 */
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		Logs.info("从缓存获取授权");
		if (principals == null) {
            return null;
        }
		
        AuthorizationInfo info = null;

//        info = (AuthorizationInfo)UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);

        if (info == null) {
            info = doGetAuthorizationInfo(principals);
//            if (info != null) {
//            	UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, info);
//            }
        }

        return info;
	}
    
    /**
     * 获取授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	Logs.info("获取授权----------------");
    	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    	// 提交角色权限
    	info.addStringPermission("user");
    	return info;
    }
    
    /**
     * 
     * @Title：initCredentialsMatcher
     * @Description: TODO(设定密码校验的Hash算法与迭代次数,重写 shiro 密码校验规则)
     * @see：    被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行,init()方法之前执行。PreDestroy（）方法在destroy()方法执行执行之后执行
     */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
		matcher.setHashIterations(SystemService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
		
	/**
	 * 
	 * @Title：clearCached
	 * @Description: TODO(清除缓存)
	 * @see：
	 */
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();  
        super.clearCache(principals);  
    }  
}