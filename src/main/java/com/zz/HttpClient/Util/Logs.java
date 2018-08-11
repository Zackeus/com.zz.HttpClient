package com.zz.HttpClient.Util;

/**
 * 
 * @Title:Logs
 * @Description:TODO(日志输出代理类)
 * 主要完成业务代码和日志工具间的解耦，使切换日志工具更加方便。
 * 如：将Log4j改为common-logging或自己的独立实现，则只需调整该类即可。
 * 简化了调用方式：如使用log4j，通常用法是先生成一个实例，再调用输出方法。 现在，只需直接使用 Logs.debug();等静态方法即可
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月11日 下午4:45:16
 */
public class Logs {
	/**
	 * 是否打印日志，true表示打印日志，false表示不打印。
	 * 开发阶段可以将其设为ture，运行阶段可以设为false
	 */
	private static final boolean enabled = true;
	/** 是否进行源代码定位，ture表示输出源代码所在类以及代码行 */
	private static boolean showLocSrc = true;
	/** 指定的日志级别 */
	private static int level = 1;
	/** 日志级别：普通 */
	private static final int info = 1;
	/** 日志级别：调试 */
	private static final int debug = 2;
	/** 日志级别：警告 */
	private static final int warn = 3;
	/** 日志级别：错误 */
	private static final int error = 4;
	/** 消息所属和消息内容的分隔符 */
	private static final String msgSplit = ":";
	/** 该类的名称，用于识别该类的堆栈 */
	private static final String thisClassName = Logs.class.getName();

	/** 默认输出日志的日志工具：log4j */
	private static org.apache.log4j.Logger logger = null;

	public Logs() {
	}

	static {
		// 可以单独指定log4j的配置文件，也可以使用默认。
		// org.apache.log4j.PropertyConfigurator.configure("src/main/resources/log4j.properties");
		// 得到logger实例，作为输出工具。
		// 此句作用是用一个输出实例，取代每个类里面的： Logger.getLogger(X.class)
		logger = org.apache.log4j.Logger.getLogger("");
	}

	/**
	 * 
	 * @Title：log
	 * @Description: TODO(根据日志级别，输出日志)
	 * @see：由原来的log4j改为System.out.println()或logging，则只需改动此类即可
	 * @param level 日志级别
	 * @param message 日志消息
	 * @param ste 堆栈信息
	 * 如果不需要输出源代码信息，则只需将静态成员属性 showLocSrc设为false即可
	 */
	private static void log(int level, Object message, StackTraceElement[] ste) {
		if (ste != null) {
			// 加入源代码定位
			message = getStackMsg(ste) + msgSplit + message;
		}
		// 转入具体实现，此处为log4j，可以改为其他不同的日志实现。
		switch (level) {
		case info:
			logger.info(message);
			break;
		case debug:
			logger.debug(message);
			break;
		case warn:
			logger.warn(message);
			break;
		case error:
			logger.error(message);
			break;
		default:
			logger.debug(message);
		}
	}

	/**
	 * 
	 * @Title：getStackMsg
	 * @Description: TODO(根据堆栈信息得到源代码行信息)
	 * @see：
	 * com.MyClass 类里的 fun()方法调用了Logs.debug("test");
	 * 则堆栈信息为: com.MyClass.fun(MyClass.java 代码行号)
	 * 原理：本工具类的堆栈下一行即为源代码的最原始堆栈。
	 * @param ste 堆栈信息
	 * @return 调用输出日志的代码所在的类.方法.代码行的相关信息
	 */
	private static String getStackMsg(StackTraceElement[] ste) {
		if (ste == null)
			return null;
		boolean srcFlag = false;
		for (int i = 0; i < ste.length; i++) {
			StackTraceElement s = ste[i];
			// 如果上一行堆栈代码是本类的堆栈，则该行代码则为源代码的最原始堆栈。
			if (srcFlag) {
				return s == null ? "" : s.toString();
			}
			// 定位本类的堆栈
			if (thisClassName.equals(s.getClassName())) {
				srcFlag = true;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title：info
	 * @Description: TODO(输出info信息)
	 * @see：
	 * @param message
	 */
	public static void info(Object message) {
		// 如果禁止日志或者输出级别不符，则返回。
		if (!enabled || info < level)
			return;
		if (showLocSrc) {
			log(info, message, Thread.currentThread().getStackTrace());
		} else {
			log(info, message, null);
		}
	}

	/**
	 * 
	 * @Title：debug
	 * @Description: TODO(输出debug信息)
	 * @see：
	 * @param message
	 */
	public static void debug(Object message) {
		// 如果禁止日志或者输出级别不符，则返回。
		if (!enabled || debug < level)
			return;
		if (showLocSrc) {
			log(debug, message, Thread.currentThread().getStackTrace());
		} else {
			log(debug, message, null);
		}
	}

	/**
	 * 
	 * @Title：warn
	 * @Description: TODO(输出warn信息)
	 * @see：
	 * @param message
	 */
	public static void warn(Object message) {
		// 如果禁止日志或者输出级别不符，则返回。
		if (!enabled || warn < level)
			return;
		if (showLocSrc) {
			log(warn, message, Thread.currentThread().getStackTrace());
		} else {
			log(warn, message, null);
		}
	}

	/**
	 * 
	 * @Title：error
	 * @Description: TODO(输出error信息)
	 * @see：
	 * @param message
	 */
	public static void error(Object message) {
		// 如果禁止日志或者输出级别不符，则返回。
		if (!enabled || error < level)
			return;
		if (showLocSrc) {
			log(error, message, Thread.currentThread().getStackTrace());
		} else {
			log(error, message, null);
		}
	}
	
	/**
	 * 
	 * @Title：main
	 * @Description: TODO(测试)
	 * @see：
	 * @param args
	 */
	public static void main(String args[]) {
		Logs.debug("调试信息");
	}
}