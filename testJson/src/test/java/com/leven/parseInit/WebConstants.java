package cn.richinfo.rmweb.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lajp.MsgQ;

import org.apache.commons.lang.StringUtils;

import cn.richinfo.common.RmConstants;
import cn.richinfo.common.log.LoggerManager;
import cn.richinfo.mailapi.ThreadPool.NewOnePolicy;
import cn.richinfo.mailapi.bean.ServerBean;
import cn.richinfo.mailapi.jna.JnaService;
import cn.richinfo.rmweb.service.FileService;
import cn.richinfo.rmweb.service.SendMailService;
import cn.richinfo.rmweb.thread.AsynComposeThread;

/**
 * 常量类，用来存放配置信息
 * 
 * @author shensh
 * 
 */
public class WebConstants {
	// 日志
	//private static LoggerManager logger = new LoggerManager(WebConstants.class);
	private static LoggerManager logger = new LoggerManager(WebConstants.class);
	// 配置属性
	public static Properties sysCfgProp = new Properties();
	public static Map<String, String> loadMailOrderMap = new HashMap<String, String>(  ); 
	public static String CONFIG_FILE_PATH = "/home/richmail/web/conf";// /home/richmail/project/webapp/conf
	public static String MAIL_ORDER_CONFIG_FILE_PATH="/home/richmail/web/conf";
	public static String POPMAIL_LOGPATH = "/home/richmail/logs/report/webapp.report.log";
	//添加的响应时间超市时间
	public static int RESPONSE_TIME_OUT=40;
	private static String CONF_FILE = "/webapp.ini";// 配置文件
	public static String MAIL_ORDER_CONF_FILE = "/mailOrderPE.ini";// 配置文件
	public static String PE_JSONNODE_KEY = "innerKey";// 配置文件
	// 默认没有初始化的INT值常量
	public static final int DEFAULT_NULL = -999;

	public static final int PKG_196608 = 196608; // 分块上传大小

	/* 文件夹操作定义开始 */
	public static final String NEW_FILE_UPLOAD = "mbox:NEW_FILE_UPLOAD";// 获取用户所有文件夹信息
	public static final String O_GETALLFOLDER = "mbox:getAllFolders";// 获取用户所有文件夹信息
	public static final String O_GETBYNAMEFOLDER = "mbox:getByNameFolders";// 获取用户所有文件夹信息
	public static final String O_CREATEFOLDER = "mbox:createUserFolder";// 请求新建文件夹
	public static final String O_DELETEFOLDER = "mbox:deleteFolders";// 请求删除文件夹
	public static final String O_UPDATEFOLDER = "mbox:updateFolders";// 请求修改文件夹信息
	public static final String O_UPDATEFOLDER2 = "mbox:updateFolders2";// 请求修改文件夹信息，个邮切换时专用
	public static final String O_SETFOLDERPASS = "mbox:setFolderPass";// 请求设置或取消文件夹的密码
	public static final String O_UPDATEFOLDERPASS = "mbox:updateFolderPass";// 请求追加取消文件夹的密码
	/* 文件夹操作定义结束 */
	/* MI清理，归档、 FTS检索等操作定义开始 */
	public static final String O_SEARCHMESSAGES = "mbox:searchMessages"; // 全文检索
	public static final String O_GETSERACHRESULT = "mbox:getSearchResult";// 获取搜索结果
	public static final String O_MAILCLEAN = "mbox:mailClean";// 邮件清理
	public static final String O_MAILFILE = "mbox:mailFile";// 邮件归档
	public static final String O_SEARCHBILLMESSAGES = "mbox:searchBillMessages"; // PE搜索账单邮件

	public static final String O_GETDELIVEERSTATUS = "mbox:getDeliverStatus";// 邮件投递状态查询
	public static final String O_SETSESSIONMODE = "mbox:setSessionMode";// 设置用户邮件会话模式
	public static final String O_DELSESSIONMESSAGES = "mbox:deleteSessionMessages";// 删除会话中的邮件
	public static final String O_QUERYSESSIONMSG_RECEIVERS = "mbox:getSessionMailReceivers";// 获取会话邮件中的收件人等信息
	
	/* MI清理，归档、 FTS检索等操作定义结束 */

	/* 星标邮件、邮件备注等操作定义开始 */
	public static final String O_UPDATEMESGSTATUS = "mbox:updateMessagesStatus";// 星标邮件
	public static final String O_MAILMEMO = "mbox:mailMemo";// 邮件备注
	public static final String O_SETTASKMAIL = "mbox:setTaskMessages";// 设置任务邮件
	/* 星标邮件、邮件备注等操作定义结束 */
	public static final String O_CHECK_TID = "user:checkTid"; // 检查用户tid是否合法
	public static final String O_MODIFY_USER_FLAG = "mbox:setUserFlag"; // 修改用户mi标志
	public static final String O_MODIFY_USER_FLAG_USER = "user:setUserFlag"; // 修改用户mi标志
	public static final String O_GET_USER_FLAG_USER = "user:getUserFlag"; // 获取用户mi标志
	public static final String O_UPDATEMESSAGESALL = "mbox:updateMessagesAll"; // 修改文件夹下所有邮件状态
	public static final String O_UPDATEMESSAGESLABEL = "mbox:updateMessagesLabel"; // 邮件标签
	public static final String O_UPDATEMESSAGESINFO = "mbox:updateMessagesInfo"; // 修改邮件的属性
	public static final String O_MOVEMAIL = "mbox:moveMessages"; // 修改邮件所属文件夹，移动邮件到xxx文件夹这种形式
	public static final String O_WRITEMAIL = "mbox:compose";// 写信
	public static final String O_GROUPWRITEMAIL = "mbox:groupCompose";// 群邮件写信
	public static final String O_WRITEMAILREALTO = "mbox:composeRealTo";// 写信
		
	public static final String O_GETMAILORDER_PE = "mbox:getMailOdersPE";// 获取行程及购物邮件的订单详情 PE
	public static final String O_GETMAILORDER = "mbox:getMailOders";// 获取行程及购物邮件的订单详情
	public static final String O_SENDEMLATTACH = "mbox:emlEncZipCompose";// 对退信中的eml附件（原信）采用加密压缩发送,国电安全加固需求
	public static final String O_VIEWATTACHMAIL = "mbox:viewAttachMessage";// 读取附件中的邮件内容，国电企业需求,针对原文打包加密
	public static final String O_READMAIL = "mbox:readMessage";// 读信
	public static final String O_VIEWMAIL = "view:readMessage";// 读信返回HTML接口
	public static final String O_VIEWEML = "view:readEML";// 读取解析eml文件（附件、URL、临时文件、上传文件），返回HTML接口
	public static final String O_IMPORTEMLATTACH = "mbox:importEmlAttach";// eml格式的附件，新增直接导入邮箱
	public static final String O_VIEW_ZIP_ATTACH = "mbox:viewZipAttach";// 获取压缩附件中的文件列表
	public static final String O_READSESSIONMAIL = "mbox:readSessionMessage";// 读会话邮件
	public static final String O_VIEWSESSIONMAIL = "view:readSessionMessage";// 读会话邮件返回HTML接口
	public static final String O_READAGGREGATEMAIL = "mbox:readAggregateMessage";// 聚合邮件阅读接口
	public static final String O_EMLCOMPOSE = "mbox:emlCompose";// eml发信
	public static final String O_READATTACHEML = "mbox:readAttachEml";// 读取邮件附件中的eml邮件
	public static final String O_TRAVELMAILUPLOAD = "mbox:travelMailUpload";// 行程邮件上传同步日历接口

	public static final String O_GETATTACH = "attach:download";// 下载附件
	public static final String O_GETTHUMB = "mbox:getThumbnail"; // 获取图片附件的缩略图(内联图片不需要)
	public static final String O_UPLOADATTACH = "attach:upload";// 上传附件
	public static final String O_UPLOADATTACH2 = "attach:upload2";// 新整合的上传附件
	public static final String O_UPLOADPART = "attach:uploadPart";// 上传分块附件，webapp内部调用
	public static final String O_ULOADPREPARE = "upload:prepare";// 多线程上传钱数据校验
	public static final String O_ULOADDATA = "upload:directData"; // 多线程上传
	public static final String O_VIEWATTACH = "attach:getAttach";// 读取附件
	public static final String O_LISTATTACHMENTS = "attach:listAttachments";// 管理附件列表
	public static final String O_UPLOADPICBASE64 = "attach:uploadPicBase64";// 图片base64字符串上传
	public static final String O_CHECKVIRUSATTACH = "attach:checkVirus";// 对上传的附件查杀病毒（国网）
	public static final String O_LISTATTACHMENTSBYMID = "attach:queryAttachmentsByMid";// 管理附件列表
	// ======
	public static final String O_AUTOPACK_2 = "mbox:autoPack";// 下载打包附件 名称不对啊这个，
	public static final String O_AUTOPACK = "attach:autoPack";// 下载打包附件，
																// 这个才是正宗的，但功能与上面一样

	public static final String O_DOWNLOADMESG = "mbox:downloadMessages";// 下载打包附件
	public static final String O_VIEWMAILDATA = "mbox:getMessageData";// 读取邮件原文
	public static final String O_RESTOREDRAFT = "mbox:restoreDraft";// 恢复草稿
	public static final String O_READTEMPLATEMAIL = "mbox:readTemplateMail";// 读取模板邮件
	public static final String O_REPLYMAIL = "mbox:replyMessage";// 回复
	public static final String O_FASTREPLYMAIL = "mbox:fastReplyMessage";// 快捷回复
	public static final String O_FASTFORWARDMAIL = "mbox:fastForwardMessages";// 快捷转发
	public static final String O_FORWARDMAIL = "mbox:forwardMessages";// 转发
	public static final String O_FORWARDATTACH = "mbox:forwardAttachs";// 转发附件
	public static final String O_SAVEMAIL = "mbox:saveMessage";// 恢复邮件
	public static final String O_EDITMAIL = "mbox:editMessage";// 编辑邮件
	public static final String O_GETMIDBYIMAPID = "mbox:getMidByImapId";// 通过imapId获取mid
	public static final String O_GETIMAPIDBYMID = "mbox:getImapIdByMid";// 通过mid获取imapId
	public static final String O_GETMESSINFO = "mbox:getMessageInfo";// 获取指定mid的信息
	public static final String O_REPORTSPAMAIL = "mbox:reportSpamMails";// 举报垃圾邮件接口
	public static final String O_FEEDBACK = "mbox:auditFeedback";// 企邮邮件审核反馈接口

	public static final String O_COMPOSEAGENT = "mbox:composeAgent";// coreMail发邮件
	public static final String O_RECOVERY_COREMAIL = "mbox:recoverCoreMessage";// coreMail发邮件

	public static final String O_SAVEPOP = "user:setPOPAccount";// 设置邮件代收
	public static final String O_QUERYPOP = "user:getPOPAccounts";// 查询邮件代收
	public static final String O_STARTPOP = "user:syncPOPAccount";// 启动邮件代收
	public static final String O_STARTALLPOP = "user:syncPOPAccountAll";// 启动所有邮件代收
	public static final String O_AUTHENTICATE = "user:authenticate";// 用户认证
	public static final String O_AUTH = "user:auth";// 用户认证

	public static final String O_QUERYREGISTERID = "user:queryRegisterId"; // 获取登陆用户的注册地址

	public static final String O_SENDMDN = "mbox:sendMDN";// 发送读信回执
	public static final String O_SEQUENTIAL = "global:sequential";// 序列化接口
	public static final String O_QUERYMESSAGECOUNT = "mbox:queryMessageCount"; // 查询邮件数量
	public static final String O_LISTMESSAGES = "mbox:listMessages";// 读取邮件列表
	public static final String O_DELETEMESSAGES = "mbox:deleteMessages";// 删除邮件
	public static final String O_GETTRANSID = "mbox:getComposeId";// 获取事务id
	public static final String O_DELETETASKS = "upload:deleteTasks";// 删除写信事务中的附件
	public static final String O_RECALLMESSAGE = "mbox:recallMessage";// 邮件撤回
	public static final String O_QUERYRECALLRECEIVERS = "mbox:queryRecallReceivers";// 获取邮件撤回所有收件人接口
	public static final String O_QUERYRECALLRECEIVERS_CAN = "mbox:queryCanRecallReceivers";// 获取可以被邮件撤回的所有收件人接口
	public static final String O_PACKMESSAGES = "mbox:packMessages";// 打包下载文件夹邮件原文
	public static final String O_IMPORTMESSAGES = "mbox:importMessages"; // 导入eml原文
	public static final String O_UNLOCK_FOLDER = "mbox:unlockFolder"; // 解锁文件夹
	public static final String O_CHECK_UNLOCK_FOLDER = "mbox:checkFolder"; // 检查文件夹是否解锁
	public static final String O_QCONTACTMSGS = "mbox:queryContactMessages";// 查询往来邮件
	public static final String O_QCONTACTATTS = "attach:queryContactAttachments";// 查询往来附件
	public static final String O_CHECKDOMAIN = "mbox:checkDomain";// 域名拼写检查
	public static final String O_CHECKUSER = "mbox:userClassify";// 对传入的用户域名检查分类为外域和系统内用户
	public static final String O_DELETETEMPLATES = "user:deleteTemplates";// 删除模板邮件
	public static final String O_GET_TEMPLATES = "user:getTemplates";// 查詢郵件模板
	
	public static final String O_LOGIN_COMMON = "user:loginCommon";// oa邮箱，公共邮箱用户登录
	public static final String O_LOGIN = "user:login";// 登录
	public static final String O_LOGOUT = "user:logout";// 退出登录
	public static final String O_LISTMAILATTACH = "attach:refresh";// 列出事务中的附件
	public static final String O_VERIFYPWD = "user:verifyPwd";// 密码校验
	public static final String O_GETTRANS = "trans:getTrans";// 获取trans
	public static final String O_SYNCHTRANS = "trans:synchTrans";// 获取trans
	public static final String O_ADDPOPMSGIDS = "pop:addMsgIds";// 更新邮件迁移过来的msgids
	public static final String O_GETPOPIDS = "pop:getPopIds";// 获取popid
	public static final String O_ADDPOPIDS = "pop:addPopIds";// 添加popid
	public static final String O_GETATTRS = "user:getAttrs";// 获取用户基本参数
	public static final String O_SETATTRS = "user:setAttrs";// 设置用户基本参数
	public static final String O_GETUSERINFO = "user:getUserInfo";// 获取用户基本信息
	public static final String O_SETUSERINFO = "user:setUserInfo";// 获取用户基本信息
	public static final String O_GETWHITEBLACKLIST = "user:getWhiteBlackList";// 获取用户黑白名单配置
	public static final String O_SETWHITEBLACKLIST = "user:setWhiteBlackList";// 设置用户黑白名单配置
	public static final String O_SETALIAS = "user:alias";// 增删改查用户别名
	public static final String O_UPDATEPWD = "user:updatePassword";// 修改密码
	public static final String O_COPYMAIL = "user:copyMail";// 邮件复制
	public static final String O_SET_SIGNATURES = "user:signatures";// 邮件签名
	public static final String O_GET_SIGNATURES = "user:getSignatures";// 邮件签名
	public static final String O_SET_FILTER = "user:setFilter";// 设置过滤规则
	public static final String O_SET_FILTER_NEW = "user:setFilter_New";// 设置过滤规则
	public static final String O_SET_FILTER_139 = "user:setFilter_139";// 139收信规则
	public static final String O_GET_FILTER = "user:getFilter";// 获取过滤规则
	public static final String O_GET_FILTER_NEW = "user:getFilter_New";// 获取过滤规则
	public static final String O_GET_FILTER_139 = "user:getFilter_139";// 139收信规则
	public static final String O_SORT_FILTER_139 = "user:sortFilter_139";// 139收信规则
	public static final String O_STAT_MESSAGES = "user:statMessages";// 统计发信最多的发信人及封数
	public static final String O_FILTER_HISTORYMAIL = "user:filterHistoryMail";// 历史邮件分拣
	public static final String O_FILTER_HISTORYMAIL_139 = "user:filterHistoryMail139";// 139历史邮件分拣
	public static final String O_FILTER_HISTORYMAIL2 = "user:moveHOMail";// 针对个邮的帐单及订阅的历史邮件分拣
	public static final String O_RESETUSERMAIL = "user:resetMailSendId";// 针对历史邮件的重置处理
	public static final String O_SET_SUBDOMAINS = "user:subDomains";// 邮件签名

	public static final String O_SP_GET_ARTIFACT = "user:getArtifact"; // 获取跨业务平台跳转信息@V1.4.6
	public static final String O_SET_FWDVERIFY = "user:forwardVerify"; // 自动转发的邮件地址安全验证接口@V1.4.7
	public static final String O_USER_GETINITDATA = "user:getInitData";// 9.8查取用户基本信息

	public static final String O_CHECK_MAIL_GROUP = "user:checkMailGroup"; // 国网需求，发信时检查收件人列表是否包含自动邮件组（部门邮件组）

	/** MD 设置账单规则、账单规则查询 接口 **/
	public static final String O_SETBILLRULE = "corp:setBillRule";// 设置账单规则
	public static final String O_GETBILLRULES = "corp:getBillRules";// 账单规则查询

	/** MD 设置收件人状态转发规则、收件人状态转发规则查询 接口 **/
	public static final String O_SETFORWARDRULE = "corp:setForwardRule"; // 设置收件人状态转发规则
	public static final String O_GETFORWARDRULES = "corp:getForwardRules"; // 收件人状态转发规则查询

	public static final String O_QUERYSENSITWORD = "spam:querySensitWord";// 查询反垃圾的敏感词列表

	public static final String O_THIRDRECALLMESSAGE = "corp:thirdRecallMessage";// 第三方邮件撤回接口

	public static final String O_GETMAILGROUP = "corp:getMailGroup";// 邮件组信息查询
	public static final String O_SETMAILGROUP = "corp:setMailGroup";// 邮件组管理
	public static final String O_GETMAILGROUPUSER = "corp:getMailGroupUser";// 邮件组成员查询
	public static final String O_SETMAILGROUPUSER = "corp:setMailGroupUser";// 邮件组成员管理
	public static final String O_GETUSERMAILGROUP = "corp:getUserMailGroup";// 查询用户所在邮件组
	public static final String O_GETUSERCREATEMAILGROUP = "corp:getUserCreateMailGroup";// 查询用户创建的所有邮件组
	
	/**十二期新增接口**/
	public static final String O_MOVEPOPACCOUNTS = "user:movePOPAccounts";// 16.1.1	迁移代收帐号
	public static final String O_MOVETIMEMAIL = "user:moveTimeMail";// 16.1.2	迁移用户定时邮件记录数据
	public static final String O_ADDTIMEMAIL = "user:addTimeMail";// 插入用户定时邮件记录数据

	/** 企邮搬家接口 **/
	public static final String O_SETMOVECONF = "corp:setMoveConf";// 设置邮件搬家配置
	public static final String O_STARTMOVE = "corp:startMove";// 启动邮件搬家
	public static final String O_STOPMOVE = "corp:stopMove";// 启动邮件搬家
	public static final String O_QUERYMOVECOUNT = "corp:queryMoveCount";// 查询邮件搬家数目
	public static final String O_QUERYMOVESTATUS = "corp:queryMoveStatus";// 查询搬家状态
	public static final String O_USERSTARTMOVE = "user:startMove";// 用户启动邮件搬家
	public static final String O_USERSTOPMOVE = "user:stopMove";// 用户启动邮件搬家
	public static final String O_USERQUERYMOVESTATUS = "user:queryMoveStatus";// 用户查询搬家状态
	public static final String O_RESETFOLDERPASS = "corp:resetFolderPass";// 重置用户文件夹密码

	/** 对外的一些服务接口 **/
	public static final String O_SPI_MAIL_SEND = "spi:sendmail";// 给客户端调用的发送邮件接口
	public static final String O_CHECK_UMC_SID = "user:checkUmcSid";// 检查用管中心sid

	/** 139被叫控制需求 **/
	public static final String O_SET_MAIL_FILTER_RULE = "user:setMailFilterRule";// 邮件过滤规则管理（139被叫控制需求）
	public static final String O_GET_MAIL_FILTER_RULE = "user: getMailFilterRule";// 15.13.2
																					// 邮件过滤规则查询

	public static final String UTF_8 = "UTF-8"; // utf-8编码
	public static final String GB2312 = "GB2312"; // gb2312编码
	public static final String GBK = "GBK"; // gbk编码

	public static final int RESULT_SUCCESS = 0;
	public static final int RESULT_ERR_NOPOWER = 202;// 没有权限
	public static final int RESULT_ERR_FILE_TYPE = 801;// 文件类型不对
	public static final int RESULT_COMPOSE_ERR_UNKNOW = 999101;// 写信内部错误
	public static final int RESULT_ERR_UNKNOW = 999;// 内部错误
	public static final int RESPONSE_TIME_UNKNOW = 7777;// 从平台获取数据超时
	public static final int RESULT_INVALID_DATE = 901; // 时间参数错误
	public static final int RESULT_INVALID_PARA = 998;// 参数不合法
	public static final int RESULT_INVALID_VALIDATE_CODE = 902; // 验证码错误
	public static final int RESULT_INVALID_PARA_SENDWAY = 998001;// 参数不合法-发送方式不正确或不支持
	public static final int RESULT_INVALID_PARA_USER_ID_NULL = 998101;// 参数不合法-用户id为空
	public static final int RESULT_INVALID_PARA_BAD_REC = 998102;// 参数不合法-收件人地址不合法
	public static final int RESULT_ERR_NOMID = 2431004;// 邮件不存在
	public static final int RESUKT_SET_MAILREAD_FLAG_ERROR = 921003; // 安全未读邮件设已读错误
	public static final int FA_MI_NO_OPENGETDELIVER_ERROR = 2308410; // 系统未开启邮件追踪功能
	public static final int RESULT_INVALID_ADDRESS = 990; // 邮件地址不正确
	public static final int RESULT_BAD_PASSWORD = 998011; // 未输入文件夹锁密码，或没有文件夹锁
	public static final int FA_INVALID_PASSWORD_COLLECTION = 998012; // 代收邮箱帐号或密码错误，请检查后重试
	public static final int FA_INVALID_GMAIL_VERIFY_ERR = 998013; // 代收gmail邮箱帐号验证错误，可能开启了二次验证或密码错误
	public static final int FA_CROSS_SETPOP_ERR = 998107; // 设置代收失败，两个账号不能交叉设置
	public static final int FA_INVALID_GMAIL_INV_ERR = 998014; // Gmail登陆被拦截，GMAIL认为第三方imap登陆是不安全的
	// FA_MS_SMAILPASS_ERR" summary="安全邮件密码验证失败,请重新输入密码
	public static final int RESULT_BAD_SMAILPASS = 998106; // 安全邮件密码验证失败,请重新输入密码
	public static final int FA_MI_NO_FID = 2305007; // 该名称的文件夹不存在
	public static final int RESULT_SAMEURL_OLIMITS = 999901;
	public static final int FA_MI_FORDER_ERRPASS = 2331006; // 该文件夹加密且输入密码不对

	public static final int DOWNLOAD_SUCCESS = 200;// 下载成功
	public static final int NOT_FOUND = 404;// 文件不存在
	public static final int DOWNLOAD_PARTIAL_SUCCESS = 206;// 下载文件区段成功
	public static final int FR_REQUEST = 400;// 重复发信请求
	public static final int FR_REQUEST_DRAFT = 401;// 重复存草稿请求
	public static final int INTERNAL_SERVER_ERROR = 500;// 网络服务器错误
	public static final int WEB_SERVER_BUSY = 503;// Web 服务器太忙，请稍后重试；
	public static final String FA_FAIL = "FA_FAIL";// 操作失败
	public static final String FA_EXTERNAL_RECIPIENT = "FA_EXTERNAL_RECIPIENT";
	public static final String FA_ATTACH_EXCEED_LIMIT = "FA_ATTACH_EXCEED_LIMIT";// 附件大小超过限制
	public static final String FA_ATTACH_EMPTY = "FA_ATTACH_EMPTY";// 上传附件为空

	public static final String S_OK = "S_OK";// 操作成功
	public static final String S_FAILE = "RESPONSE_TIMEOUT";// 响应超时
	public static final String S_PARTIAL_OK = "S_PARTIAL_OK";// 操作部分成功
	public static final String FS_UNKNOWN = "FS_UNKNOWN";// 未知错误
	public static final String FR_INVALID_REQUEST = "FR_INVALID_REQUEST";// 非法请求，如格式错误，协议错误等
	public static final String FA_INVALID_PARAMETER = "FA_INVALID_PARAMETER";// 参数错误
	public static final String FA_XXXX_NOT_FOUND = "FA_XXXX_NOT_FOUND";// 表示某对象不存在，以至于无法进行后续操作
	public static final String FA_XXXX_EXISTS = "FA_XXXX_EXISTS";// 表示某对象已经存在，以至于无法进行后续操作
	public static final String FA_REDUNDANT_REQUEST = "FA_REDUNDANT_REQUEST";// 表示是重复冗余的请求，被拒绝
	public static final String FA_REDUNDANT_REQUEST_DRAFT = "FA_REDUNDANT_REQUEST_DRAFT";// 表示是重复冗余的存草稿请求，被拒绝
	public static final String FA_INVALID_SESSION = "FA_INVALID_SESSION";// Session不合法，通常表示用户超时。
	public static final String FA_SECURITY = "FA_SECURITY";// 提交的session没有通过安全检查，例如IP或cookie不匹配
	public static final String FA_UNAUTHORIZED = "FA_UNAUTHORIZED";// 验证密码失败，用户不存在，缺乏sid参数等。
	public static final String FA_FORBIDDEN = "FA_FORBIDDEN";// 操作不允许通常是由于COS限制,
	public static final String FA_BAD_PASSWORD = "FA_BAD_PASSWORD";// 帐号或密码错误
	public static final String FA_BAD_SERVER = "FA_BAD_SERVER";// 服务器ip或端口错误
	public static final String FA_FOLDER_EXISTS = "FA_FOLDER_EXISTS";// 文件夹已存在
	public static final String FA_INVALID_DATE = "FA_INVALID_DATE";// 定时邮件时间不正确
	public static final String FA_ATTACH_SIZE_EXCEED = "FA_ATTACH_SIZE_EXCEED";// 附件太大
	public static final String FA_IS_SPAM = "FA_IS_SPAM";// 垃圾邮件
	public static final String FA_POP_RUNNING = "FA_POP_RUNNING";// 正在代收中
	public static final String FA_GMAIL_VERIFY_ERR = "FA_GMAIL_VERIFY_ERR";// Gmail验证失败
	public static final String FA_GMAIL_INV_CRED = "FA_GMAIL_INV_CRED";// Gmail登陆被拦截，GMAIL可能不允许imap登陆
	/*** MI ERROR start ***/
	public static final String FA_PARENT_NOT_FOUND = "FA_PARENT_NOT_FOUND";// 找不到指定的父文件夹;
	public static final String FA_NAME_EXISTS = "FA_NAME_EXISTS";// 文件夹名称重复
	public static final String FA_NAME_INVALID = "FA_NAME_INVALID"; // 非法文件夹名称
	public static final String FA_ID_NOT_FOUND = "FA_ID_NOT_FOUND"; // 找不到指定的文件夹
	public static final String FA_HAS_CHILD = "FA_HAS_CHILD";// 有子文件夹
	public static final String FA_HAS_MAIL = "FA_HAS_MAIL";// 有信件
	public static final String FA_PASSWORD_INVALID = "FA_PASSWORD_INVALID";// 密码不正确或者密码不符合规则
	public static final String FA_INVALID_VERIFY_CODE = "FA_INVALID_VERIFY_CODE";// 校验码不正确
	public static final String FA_NEED_VERIFY_CODE = "FA_NEED_VERIFY_CODE";// 需要校验码
	public static final String FA_USER_LOCKED = "FA_USER_LOCKED";// 用户处于锁定状态
																	// (也可能是用户过期/组织过期)
	public static final String FA_USER_SUSPENDED = "FA_USER_SUSPENDED";// 用户被禁用
	public static final String FA_USER_WRONG_STATUS = "FA_USER_WRONG_STATUS";// 用户状态错误
	public static final String FA_USER_SELF_LOCK = "FA_USER_SELF_LOCK";// 用户处于自锁定状态
	public static final String FA_INVALID_RMKEY = "FA_INVALID_RMKEY"; // RMKEY不合法

	public static final String FA_INVALID_ADDRESS = "FA_INVALID_ADDRESS"; // 邮件地址不正确

	public static final String FA_FORBIDDEN_FORWARD = "FA_FORBIDDEN_FORWARD_OUT_USER";
	public static final String FA_INVALID_PARA_SENDID = "FA_INVALID_PARA_SENDID";
	public static final String PE_CONFIG_JSONNODE_KEY = "innerKey";

	/*** MI ERROR end ***/
	/**
	 * 用户的状态，1 正常 2 冻结 3注销 4 删除
	 */
	public static final int USER_STATUS_NORMAL = 1;
	public static final int USER_STATUS_FREEZON = 2;
	public static final int USER_STATUS_UNREGISTER = 3;
	public static final int USER_STATUS_DELETE = 4;

	// 当COS限制用户进行某项操作时,
	// Server端一般会立即返回或者试图执行一些受系统保护的操作,某些delete操作由于还存在引用关系而不允许也使用此返回值

	public static final String FA_OVERFLOW = "FA_OVERFLOW";// 表示超出某个COS限制,
	// 或者系统限制
	public static final String FA_ATTR_SIZE_EXCEEDED = "FA_ATTR_SIZE_EXCEEDED";// 设置用户属性时，属性大小超过数据库字段长度限制。

	public static final String X_MAILER = RmConstants.SYSTEM_NAME
			+ "_Webapp(V2.0.17)";
	public static final String RM_COOKIES_NAME = RmConstants.SYSTEM_NAME;
	public static final String RM_COOKIES_KEY = "RMKEY";
	public static final String MAINDOMAIN_COOKIES_KEY = "maindomain";
	public static final String CM_COOKIES_KEY = "Coremail";
	public static final char SEND_TYPE_WEB = 3;// web发信
	public static final char SEND_TYPE_TIMER = 4;// 定时发信
	public static final int ENCODE = 1;/* 1:UTF-8 2:GBK 3:ASCII */
	public static String RM_BUSINESS_KEY = "RM_BUSINESS_KEY";
	public static Map<Integer, String> DOMAIN_MAP = new HashMap<Integer, String>();// 资源分组域名map

	// socket连接池配置，没有配置的使用短连接，格式 服务器类型:初始连接数-最大连接数
	public static String SERVER_CONNECT_NUM = "MSID:1-5|SPID:1-5|MIID:1-5|MDID:1-5|ASID:1-5";

	// 发信前取web上传附件临时存放路径
	public static String ATTACHROOT = "E:/home/shensh/webapp/attchroot";
	// DA发信邮件存放路径
	public static String DAEMLROOT = "E:/home/shensh/webapp/daemlroot";
	// 内联附件临时存放路径
	public static String TEMPATTACHROOT = "E:/home/shensh/webapp/tempattchroot";
	// 反垃圾拦截邮件临时存放路径
	public static String TEMINTCEPEMLROOT = "E:/home/shensh/webapp/tempintectpemlroot";
	// 是否需要保存反垃圾拦截邮件临时
	public static boolean IS_SAVE_INTCEPEML = false;

	/** @Fields SGCC_TEMINTCEP_LOGREPORT : TODO(开启国网特定的反垃圾拦截日志) */ 
	public static boolean SGCC_TEMINTCEP_LOGREPORT = false;

	public static String WEBAPPURL = "http://rm2.mail.10086ts.cn/RmWeb";
	/** 校验转发地址的url **/
	public static String AUTO_FWD_VERIFY_RESULT_URL = "http://";
	public static String WEBAPP_NO_D0MAIN_URL = "/RmWeb";
	public static final String WEBAPPGETATTACH = "/view.do?func=attach:getAttach";
	public static final String WEBAPPGETATTACH2 = "/view.do\\?func=attach:getAttach";

	public static final String CM_WEBAPP_NO_D0MAIN_URL = "/coremail/s";
	public static final String CM_V3_WEBAPPGETATTACH2 = "\\?func=mbox:getComposeData";
	public static final String CM_V3_WEBAPPGETATTACH = "?func=mbox:getComposeData";

	public static int TEMPFOLDER_CREATE_INTERVAL = 10;
	public static int TEMPFOLDER_DELETE_INTERVAL = 10;

	public static boolean IS_READ_NOATTACH = true;
	public static int DELTEMP_TIME_HOUR = 2;
	/** @Fields CCTASK_TIME_MIN : TODO(定时打印线程信息间隔时间，单位：min) */ 
	public static int CCTASK_TIME_MIN = 5;
	/** @Fields FIND_DEAD_LOCKED : TODO(是否开启检测死锁 默认 false) */ 
	public static boolean FIND_DEAD_LOCKED = false;
	/** @Fields ISOPEN_THREAD_LOG : TODO(是否开启打印线程日志模块 默认 true) */ 
	public static boolean ISOPEN_THREAD_LOG = true;
	/** @Fields ISOPEN_FULLSEARCH_TO : TODO(是否开启搜发件人改用搜全文检索接口，默认 false) */ 
	public static boolean ISOPEN_FULLSEARCH_TO = false;
	/** @Fields ISOPEN_QUERYCONTACT_FULLSEARCH : TODO(是否开启搜往来邮件改用搜通行证、别名等搜索条件) */ 
	public static boolean ISOPEN_QUERYCONTACT_FULLSEARCH = true;
	/** @Fields ISOPEN_DEC_USERNAME : TODO(是否开启用户名DEC解密功能) */ 
	public static boolean ISOPEN_DEC_USERNAME = false;
	/** @Fields ISOPEN_FULLSEARCH_TO : TODO(是否开启请求报文替换双引号转义字符) */ 
	public static boolean ISOPEN_TRANSF_DQUO = false;
	/** @Fields ISOPEN_SEC_ANTIXSS : TODO(是否开启XSS二次过滤) */ 
	public static boolean ISOPEN_SEC_ANTIXSS = false;
	/** @Fields ISOPEN_TIMEOUT_ANTIXSSPOOL : TODO(是否开启antisamy过滤超时后启用线程池过滤模式) */ 
	public static boolean ISOPEN_TIMEOUT_ANTIXSSPOOL = false;
	
	/** @Fields ISOPEN_ASYN_COMPOSE : TODO(是否开启异步写信 */ 
	public static boolean ISOPEN_ASYN_COMPOSE = false;
	/** @Fields ASYN_COMPOSE_ATTACH_SIZE : TODO(异步发信当原邮件超过设置大小时不添加到退信附件 默认1M) */ 
	public static int ASYN_COMPOSE_ATTACH_SIZE = 1024*1024;
	/** @Fields ASYN_COMPOSE_REJECT_BYTE : TODO(异步退信模板) */ 
	public static byte[] ASYN_COMPOSE_REJECT_BYTE;
	/** @Fields ASYN_COMPOSE_139LOGO_BYTE : TODO(异步退信模板内联logo图片) */ 
	public static byte[] ASYN_COMPOSE_139LOGO_BYTE;
	/** @Fields ASYN_TIME_MIN : TODO(定时扫描异步写信数据库间隔时间，单位：min) */ 
	public static int ASYN_TIME_MIN = 1;

	/** @Fields IS_REPLASCE_DATE : TODO(是否替换邮件发送时间，默认false) */ 
	public static boolean IS_REPLASCE_DATE  = false;

//	/** @Fields IS_OPEN_CHECKUSERORDER : TODO(开启向PS查询用户订购权益套餐) */ 
//	public static boolean IS_OPEN_CHECKUSERORDER = false;
//	/** @Fields PS_CONFIG_PATH : TODO(PS服务初始化配置配置) */ 
//	public static String PS_CONFIG_PATH = "/home/richmail/web/conf/PFSConf/";
//	public static PFSServerFactory pfsServerFactory=null;

	/** @Fields NOT_DEL_MIPOPDATA : TODO(当数据库查询代收数据不存在时，不删除mi里面数据) */ 
	public static boolean NOT_DEL_MIPOPDATA = false;
	public static boolean QUERY_PUI_LIST = true;
	
	/** @Fields SET_SIGN_UNCODE : TODO(设置签名解码功能) */ 
	public static boolean SET_SIGN_UNCODE = true;
	public static int ALLOW_POP = 0;
	public static int MsgQID = 5000;
	public static int MsgID = 0;
	public static int MsgQIDType = 1;
	public static int SCANTIMEMAIL_COUNT = 100;
	public static int TIMEMAIL_THREADNUM = 3;
	public static int RESEND_TIMES = 10;// 重发测试
	public static int TOTALMEMORY = 300;// 强制垃圾回收内存占用值
	public static long CONNECT_TIMEOUT = 30000;// 心跳检查时间
	public static int GET_CONN_TIMEOUT_MS = 1000;
	public static boolean ISTEST = false;
	@Deprecated
	public static boolean NOCOOKIES = false; // 该字段已经无意义，对于免Cookies校验要逐渐用noCookiesXXX接口来代替,而不是开关。

	public static String NO_RECIPIENT_DESC = "(无)";
	public static String RECV_HEAD = "已读：{SUBJECT}";
	public static String FW_HEAD = "Fw:{SUBJECT}";
	public static String RECV_CONTENT = "这是邮件收条, {SENDDATE} 发给 {RECEIVER},  主题为 {SUBJECT} 的信件已被接收\r\n此收条只表明收件人的计算机上曾显示过此邮件";

	public static String RECALL_SUBJECT = "不好意思，撤回了一封邮件|Letter retracted reminder.";
	public static String SENDER_RECALL_SUBJECT = "【撤回邮件成功】";
	public static String RECALL_CONTENT = "不好意思，之前不小心错发了一封邮件《{SUBJECT}》，已经被我撤回了，请谅解。Sorry. A wrong letter <<{SUBJECT}>>was sent before. I have retracted it. Please understand that.";
	public static String SENDER_RECALL_CONTENT = "您好！您对邮件进行了撤回操作，结果如下：发给{RECEIVER}的邮件撤回成功(^_^)";
	public static String REPLY_CONTENT_HTML = "";
	public static String REPLY_CONTENT_TEXT = "";
	public static String FORWARD_CONTENT_HTML = "";
	public static String FORWARD_CONTENT_TEXT = "";
	public static String MAIN_URL = "";
	public static int DRAFT_IS_NEW = 1;
	public static int IS_FILTER_BY_SO = 1;
	public static int DB_IS_MYSQL = 0;
	public static int IS_ENABLE_202 = 0;
	public static int SAVE_SEND_BY_DA = 0;
	public static int IS_COREMAIL_CN_NAME = 1;
	public static int IS_INTERCEPT_SAME_URL = 0;// #是否开启拦截相同url的请求

	// public static int AutoPopTime = 12;
	
	public static int PARSE_SESSIONMSG_MAX_NUM = 10; // 会话邮件群组获取收件人信息解析最大邮件数
	public static int InterceptUrlCount = 30; // 拦截相同url的请求上限
	public static int TimeMailOverdueDay = 7; // 定时邮件过期天数
	public static int AutoMailWorkNum = 3;
	public static int ManuMailWorkNum = 3;
	public static int PushMailWorkNum = 3;
	public final static String PENDING = "PENDING";
	public final static String CONNECTING = "CONNECTING";
	public final static String RUNNING = "RUNNING";
	public final static String FA_CONNECT_TIMEOUT = "FA_CONNECT_TIMEOUT";
	public final static String FA_BAD_USER = "FA_BAD_USER";
	public final static String FA_SAME_USER = "FA_SAME_USER";
	public final static String FA_COMM_TIMEOUT = "FA_COMM_TIMEOUT";
	public final static String FA_ACCOUNT_EXISTS = "FA_ACCOUNT_EXISTS";
	public final static String RESULT_CROSS_SETPOP_ERR = "FA_CROSS_SETPOP_ERR";
	public static String NEW_CONF_PATH = null;
	public static String COREMAIL_API_HOST = "127.0.0.1";
	public static int COREMAIL_API_PORT = 6195;

	public static String COREMAIL_IMAP_HOST = "127.0.0.1";
	public static String COREMAIL_IMAP_SUPPERPASS = "pushemail";
	public static int COREMAIL_IMAP_PORT = 143;
	public static int IS_SCAN_COREMAIL_TIMEMAIL = 0;
	public static int MONITOR_PORT = 10001;
	public static String IPLIMIT_NAME = "";
	public static String NOCOOKIE_IPLIMIT_NAME;
	/** 运营类操作限制的ip列表名称 **/
	public static String CORP_IPLIMIT_NAME;
	/** 采用何种压缩方式来上传数据，默认为空，表示不采用压缩方式 **/
	public static String ZIPTYPE = "";

	public static String KEY_AUTOREPLAY_CONTENT = "auto_replay_content";

	public static List<String> ALLOWN_FRAME_URLS = new ArrayList<String>();

	public final static Map<Integer, ServerBean> appidMap = new HashMap<Integer, ServerBean>();

	/**
	 * CoreMail服务器的标志，默认为true,如果配置文件读不到，则为false，表示没有coremail
	 */
	public static boolean HAVE_CORE_MAIL = true;

	public static boolean CHECK_COMEFROM = false;

	/**
	 * 是否开启断点续传
	 */
	public static boolean IS_OPEN_MUTIL_DOWN = false;
	/**
	 * 是否不限制邮箱搬家用户名
	 */
	public static boolean IS_OPEN_MAILMOVE_FROM = false;
	/**
	 * 是否开启写信成功后返回报文包含附件信息的配置项 false表示不返回
	 */
	public static boolean WRITE_MAIL_CTRL_FLAG = false;

	public static final String SESSKEY_FOLDER_PASS = "rm_webapp_folderPass"; // 文件夹密码在Session中的定义的key

	public static final long READ_PIC_THRESHOLD_SIZE = 32 * 1024L;// 读取的图片大小阀值32K

	public static String RM_SUPPER_PWD = "RM_SUPPER_PWD";// 超级密码，用于oa邮箱公共邮箱账号登录

	private static Map<String, String[]> NO_IMAP_FOLDER_MAP = new HashMap<String, String[]>();

	/** 是否用新的配置库接口读取 **/
	public static boolean NEW_CONF_READ = true;

	public static boolean OPEN_XENGINE_SERVER = false;
	public static boolean OPEN_139_FILTER = false;// 开启139收信规则
	public static boolean OPEN_139_DENYFORWARD = false;// 开启139禁止转发功能
	public static boolean OPEN_139_RESTORE_DELMail = false;// 开启139恢复误删除功能
	public static int NO_ATTACH_SIZE = 2097152;// 默认邮件大小小于2M就全部取下来
	public static int BUFFERSTREAM_LEN = 1048576;// 默认下载附件，每次从ms取1M
	public static int WEB_MAX_SEND_NUM = 500;// 默认最大收件人数
	public static int SEARCH_SENDID_COUNT = 500;// 默认重置sendid，默认每次搜索500条

	/** 自动转发验证邮件的邮件模板内容@V1.4.8 **/
	public static String FORWARD_VERIFY_HTML = "尊敬的用户：<br>"
			+ "   您好！139邮箱用户{UserMailName}在邮箱中设置了将邮件转发至您的邮箱中。请点击下方链接，完成验证。<br>"
			+ "   链接地址：<a href=\"{url}\" target=\"_blank\">{url}</a><br><br>"
			+ "请在24小时内完成验证，否则链接失效，您需要重新进行验证。<br>"
			+ "如果该链接无法点击，请直接复制以上网址到浏览器地址栏中访问。<br>"
			+ "此邮件由139邮箱管理系统中心发出，系统不接受回信，请勿回复。<br><br>"
			+ "                                       139邮箱团队";
	public static String FORWARD_VERIFY_KEY = "139Forward";

	public static String VALIDATE_CODE_URL = "";
	//校验139个邮禁止转发权限接口
	public static String VALIDATE_USERPERMISS_URL = ""; 
	//139个邮日历邮件管理地址
	public static String CALENDAR_URL = ""; 

	/**
	 * 分布式部署配置
	 */
	public static boolean IS_OPEN_DISTRIBUTE = false;
	public static Map<Integer, ServerBean> DISTRIBUTE_WEBAPP_MAP = new HashMap<Integer, ServerBean>();
	// 增加ip白名单缓存队列
	private static List<String> IS_ALLOW_IP_CACHE = new ArrayList<String>();
	// 白名单内部发信接口可允许替换的发件人
	private static List<String> IS_ALLOW_EMAMIL_ACCOUNT = new ArrayList<String>();
	// 禁止转发邮件可以读信的客户端来源
	private static List<String> IS_ALLOW_DENYREADMAIL_COMEFROM = new ArrayList<String>();
	// 可以隐藏的文件夹配置，文件夹列表及搜索接口过滤
	public static List<String> IS_HIDE_FOlDER = new ArrayList<String>();
	/** @Fields idiotQiYouNoCheckAllowsIP : TODO(企邮不检验白名单配置) */
	public static boolean idiotQiYouNoCheckAllowsIP = true;

	/** @Fields AD_SETFILTER_KEY : TODO(广告分拣规则名字) */
	public static final String AD_SETFILTER_NAME = "AD";

	private static void initImap() {
		NO_IMAP_FOLDER_MAP.put("sina.cn", new String[] { "其它邮件" });
		NO_IMAP_FOLDER_MAP.put("sina.com", new String[] { "其它邮件" });
		NO_IMAP_FOLDER_MAP.put("qq.com", new String[] { "其他文件夹" });
		NO_IMAP_FOLDER_MAP.put("sohu.com", new String[] { "Sent Items", "Sent",
				"已发送邮件", "草稿", "Deleted Items", "Trash" });
		NO_IMAP_FOLDER_MAP.put("gmail.com",
				new String[] { "所有邮件", "重要", "已加星标" });
	}

	public static boolean isNeedImap(String domain, String folderName) {
		if (!NO_IMAP_FOLDER_MAP.containsKey(domain))
			return true;
		String[] folderNames = NO_IMAP_FOLDER_MAP.get(domain);
		if (folderNames != null) {
			for (int i = 0; i < folderNames.length; i++) {
				if (folderNames[i].equals(folderName)) {
					return false;
				}
			}
		}
		return true;
	}

	// 内部发信接口可允许替换的发件人判断
	public static boolean isAllowEmailAccounts(String account) {
		if (account == null || "".equals(account))
			return false;
		if (IS_ALLOW_EMAMIL_ACCOUNT.contains(account)) {
			return true;
		} else {
			return false;
		}
	}
	// 内部发信接口可允许替换的发件人判断IS_ALLOW_DENYREADMAIL_COMEFROM
	public static boolean isAllowDenyReadMail(String comefrom) {
		if (comefrom == null || "".equals(comefrom))
			return false;
		if (IS_ALLOW_DENYREADMAIL_COMEFROM.contains(comefrom)) {
			return true;
		} else {
			return false;
		}
	}

	// 增加ip白名单缓存判断
	public static boolean isAllowNoCookisIps(String ip) {
		if (ip == null || "".equals(ip))
			return false;
		if (IS_ALLOW_IP_CACHE.contains(ip))
			return true;
		if (JnaService.checkIpLimit(NOCOOKIE_IPLIMIT_NAME, ip)) {
			IS_ALLOW_IP_CACHE.add(ip);
			return true;
		} else
			return false;
	}

	/**
	 * 校验ip是否是允许运营操作的IP
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isAllowCorpIps(String ip) {
		if (ip == null || "".equals(ip)) {
			return false;
		}
		return JnaService.checkIpLimit(CORP_IPLIMIT_NAME, ip);
	}

	public static void initTest(String configFilePath) {
		ISTEST = true;
		init(configFilePath);
	}

	public static void initMailOrderPEParam(String configFilePath) {
		if (StringUtils.isBlank(configFilePath) || configFilePath == null) {
			MAIL_ORDER_CONFIG_FILE_PATH = "/home/richmail/web/conf";
		} else {
			MAIL_ORDER_CONFIG_FILE_PATH = configFilePath;
		}
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
//			fis = new FileInputStream(MAIL_ORDER_CONFIG_FILE_PATH + WebConstants.MAIL_ORDER_CONF_FILE);
			fis = new FileInputStream(MAIL_ORDER_CONFIG_FILE_PATH );
			isr = new InputStreamReader(fis, "UTF-8");
			sysCfgProp.load(isr);
			// 返回Properties中包含的key-value的Set视图
			Set<Entry<Object, Object>> set = sysCfgProp.entrySet();
			// 返回在此Set中的元素上进行迭代的迭代器
			Iterator<Map.Entry<Object, Object>> it = set.iterator();
			String key = null, value = null;
			// 循环取出key-value
			while (it.hasNext()) {
				Entry<Object, Object> entry = it.next();
				key = String.valueOf(entry.getKey());
				value = String.valueOf(entry.getValue());
				// key = key == null ? key : key.trim().toUpperCase();
				// value = value == null ? value : value.trim().toUpperCase();
				// 将key-value放入map中
				loadMailOrderMap.put(key, value);
			}
			// mailOrderIs.close();

		} catch (Exception ioe) {
			logger.error(
					"\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/mailOrderPE.ini\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		} finally {
			if (null != isr) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if (null != fis) {
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							logger.error(
									" close inputstream throw exception in mailOrderPE.ini");
						}
					}
				}
			}
		}
	}
	public static void init(String configFilePath) {
		initImap();
		try {
			if (configFilePath != null && !"".equals(configFilePath)) {
				CONFIG_FILE_PATH = configFilePath;
			} else {
				CONFIG_FILE_PATH = "/home/richmail/web/conf";
			}
			InputStream is = new FileInputStream(CONFIG_FILE_PATH + CONF_FILE);
			sysCfgProp.load(is);
			is.close();
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/webapp.ini\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		//添加的响应时间超市时间
		RESPONSE_TIME_OUT=Integer.valueOf(sysCfgProp.getProperty("RESPONSE_TIME_OUT", "50000"));
		NOCOOKIES = "1".equals(sysCfgProp.getProperty("NOCOOKIES", "0"));
		IS_READ_NOATTACH = "1".equals(sysCfgProp.getProperty(
				"IS_READ_NOATTACH", "1"));
		GET_CONN_TIMEOUT_MS = Integer.parseInt(sysCfgProp.getProperty(
				"GET_CONN_TIMEOUT_MS", "1000"));
		CONNECT_TIMEOUT = Integer.parseInt(sysCfgProp.getProperty(
				"CONNECT_TIMEOUT", "30000"));
		CCTASK_TIME_MIN = Integer.parseInt(sysCfgProp.getProperty(
				"CCTASK_TIME_MIN", "5"));
		FIND_DEAD_LOCKED = "1".equals(sysCfgProp.getProperty(
				"FIND_DEAD_LOCKED", "0"));
		ISOPEN_THREAD_LOG = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_THREAD_LOG", "1"));
		ISOPEN_FULLSEARCH_TO = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_FULLSEARCH_TO", "0"));
		ISOPEN_QUERYCONTACT_FULLSEARCH = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_QUERYCONTACT_FULLSEARCH", "1"));
		ISOPEN_DEC_USERNAME = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_DEC_USERNAME", "0"));
		ISOPEN_TRANSF_DQUO = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_TRANSF_DQUO", "0"));
		logger.info("ISOPEN_TRANSF_DQUO=" + ISOPEN_TRANSF_DQUO);
		ISOPEN_SEC_ANTIXSS = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_SEC_ANTIXSS", "0"));
		logger.info("ISOPEN_SEC_ANTIXSS=" + ISOPEN_SEC_ANTIXSS);
		ISOPEN_TIMEOUT_ANTIXSSPOOL = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_TIMEOUT_ANTIXSSPOOL", "0"));
		logger.info("ISOPEN_TIMEOUT_ANTIXSSPOOL=" + ISOPEN_TIMEOUT_ANTIXSSPOOL);
		
		ISOPEN_ASYN_COMPOSE = "1".equals(sysCfgProp.getProperty(
				"ISOPEN_ASYN_COMPOSE", "0"));
		logger.info("ISOPEN_ASYN_COMPOSE=" + ISOPEN_ASYN_COMPOSE);
		if(ISOPEN_ASYN_COMPOSE){//初始化线程池
			AsynComposeThread.threadPool = new ThreadPoolExecutor(10, 60, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
					new NewOnePolicy());
		}
		
		try {
			ASYN_COMPOSE_REJECT_BYTE = FileService.readFile(CONFIG_FILE_PATH + "/webappBounce.eml");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/webappBounce.eml\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
		}
		try {
			ASYN_COMPOSE_139LOGO_BYTE = FileService.readFile(CONFIG_FILE_PATH + "/logo139.png");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/logo139.png\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
		}
		
		ASYN_COMPOSE_ATTACH_SIZE = Integer.parseInt(sysCfgProp.getProperty(
				"ASYN_COMPOSE_ATTACH_SIZE", "10240000"));
		logger.info("ASYN_COMPOSE_ATTACH_SIZE=" + ASYN_COMPOSE_ATTACH_SIZE);
		
		ASYN_TIME_MIN = Integer.parseInt(sysCfgProp.getProperty(
				"ASYN_TIME_MIN", "1"));
		logger.info("ASYN_TIME_MIN=" + ASYN_TIME_MIN);
		
		IS_REPLASCE_DATE = "1".equals(sysCfgProp.getProperty(
				"IS_REPLASCE_DATE", "0"));
		logger.info("IS_REPLASCE_DATE=" + IS_REPLASCE_DATE);
		
//		IS_OPEN_CHECKUSERORDER = "1".equals(sysCfgProp.getProperty(
//				"IS_OPEN_CHECKUSERORDER", "0"));
//		logger.info("IS_OPEN_CHECKUSERORDER=" + IS_OPEN_CHECKUSERORDER);
		
		NOT_DEL_MIPOPDATA = "1".equals(sysCfgProp.getProperty(
				"NOT_DEL_MIPOPDATA", "0"));
		logger.info("NOT_DEL_MIPOPDATA=" + NOT_DEL_MIPOPDATA);
		
		QUERY_PUI_LIST = "1".equals(sysCfgProp.getProperty(
				"QUERY_PUI_LIST", "1"));
		logger.info("QUERY_PUI_LIST=" + QUERY_PUI_LIST);
		
//		PS_CONFIG_PATH = sysCfgProp.getProperty(
//				"PS_CONFIG_PATH", "/home/richmail/web/conf/PFSConf/");
//		logger.info("PS_CONFIG_PATH=" + PS_CONFIG_PATH);
		
		SET_SIGN_UNCODE = "1".equals(sysCfgProp.getProperty(
				"SET_SIGN_UNCODE", "1"));
		logger.info("SET_SIGN_UNCODE=" + SET_SIGN_UNCODE);
		// APPID = Integer.parseInt(sysCfgProp.getProperty("APPID", "1"));SET_SIGN_UNCODE
		ATTACHROOT = sysCfgProp.getProperty("ATTACHROOT",
				"/home/shensh/webapp/attchroot");
		DAEMLROOT = sysCfgProp.getProperty("DAEMLROOT",
				"/home/shensh/webapp/daemlroot");
		TEMPATTACHROOT = sysCfgProp.getProperty("TEMPATTACHROOT",
				"/home/shensh/webapp/tempattchroot");
		TEMINTCEPEMLROOT = sysCfgProp.getProperty("TEMINTCEPEMLROOT",
				"/home/shensh/webapp/tempintcepemlroot");
		IS_SAVE_INTCEPEML = "1".equals(sysCfgProp.getProperty(
				"IS_SAVE_INTCEPEML", "0"));
		SGCC_TEMINTCEP_LOGREPORT = "1".equals(sysCfgProp.getProperty(
				"SGCC_TEMINTCEP_LOGREPORT", "0"));
		if (logger.isDebugEnabled()) {
			logger.debug("TEMINTCEPEMLROOT=" + TEMINTCEPEMLROOT
					+ "  |IS_SAVE_INTCEPEML=" + IS_SAVE_INTCEPEML);
		}
		WEBAPPURL = sysCfgProp.getProperty("WEBAPPURL",
				"http://api.demo.kf139.com/RmWeb");
		TimeMailOverdueDay = Integer.parseInt(sysCfgProp.getProperty(
				"TimeMailOverdueDay", "7"));

		InterceptUrlCount = Integer.parseInt(sysCfgProp.getProperty(
				"InterceptUrlCount", "30"));
		PARSE_SESSIONMSG_MAX_NUM = Integer.parseInt(sysCfgProp.getProperty(
				"PARSE_SESSIONMSG_MAX_NUM", "10"));
		logger.info("PARSE_SESSIONMSG_MAX_NUM=" + PARSE_SESSIONMSG_MAX_NUM);// 关键配置项，要打印出来
		
		String mailStr = sysCfgProp.getProperty("IS_ALLOW_EMAMIL_ACCOUNT",
				"10086@139.com");
		Collections.addAll(IS_ALLOW_EMAMIL_ACCOUNT, mailStr.split(","));
		logger.info("IS_ALLOW_EMAMIL_ACCOUNT=" + IS_ALLOW_EMAMIL_ACCOUNT);
		
		mailStr = sysCfgProp.getProperty("IS_ALLOW_DENYREADMAIL_COMEFROM",
				"10086@139.com");
		Collections.addAll(IS_ALLOW_DENYREADMAIL_COMEFROM, mailStr.split(","));
		logger.info("IS_ALLOW_DENYREADMAIL_COMEFROM=" + IS_ALLOW_DENYREADMAIL_COMEFROM);
		
		mailStr = sysCfgProp.getProperty("IS_HIDE_FOlDER",
				"");
		if(mailStr!=null&&!"".equals(mailStr)){
			Collections.addAll(IS_HIDE_FOlDER, mailStr.split(","));
		}
		logger.info("IS_HIDE_FOlDER=" + IS_HIDE_FOlDER);
		
		AUTO_FWD_VERIFY_RESULT_URL = sysCfgProp.getProperty(
				"AUTO_FWD_VERIFY_RESULT_URL", "http://");

		logger.info("WEBAPPURL=" + WEBAPPURL);// 关键配置项，要打印出来

		RECV_HEAD = decode(sysCfgProp.getProperty("RECV_HEAD", "已读：{SUBJECT}"),
				"utf-8");
		RECV_CONTENT = decode(
				sysCfgProp
						.getProperty(
								"RECV_CONTENT",
								"这是邮件收条, {SENDDATE} 发给 {RECEIVER},  主题为 {SUBJECT} 的信件已被接收\r\n此收条只表明收件人的计算机上曾显示过此邮件"),
				"utf-8");

		RECALL_SUBJECT = decode(sysCfgProp.getProperty("RECALL_SUBJECT"),
				"utf-8");
		if (RECALL_SUBJECT == null || RECALL_SUBJECT.trim().length() == 0) {
			RECALL_SUBJECT = "不好意思，撤回了一封邮件 Letter retracted reminder.";
		}
		logger.info("RECALL_SUBJECT=" + RECALL_SUBJECT);
		//邮件召回 发件人回复主题 139企邮需求
		SENDER_RECALL_SUBJECT = decode(sysCfgProp.getProperty("SENDER_RECALL_SUBJECT"),
				"utf-8");
		if (SENDER_RECALL_SUBJECT == null || SENDER_RECALL_SUBJECT.trim().length() == 0) {
			SENDER_RECALL_SUBJECT = "【邮件撤回成功】";
		}
		logger.info("SENDER_RECALL_SUBJECT=" + SENDER_RECALL_SUBJECT);
		RECALL_CONTENT = decode(sysCfgProp.getProperty("RECALL_CONTENT"),
				"utf-8");
		if (RECALL_CONTENT == null || RECALL_CONTENT.trim().length() == 0) {
			RECALL_CONTENT = "不好意思，之前不小心错发了一封邮件《{SUBJECT}》，已经被我撤回了，请谅解。Sorry. A wrong letter <<{SUBJECT}>>was sent before. I have retracted it. Please understand that.";
		}
		logger.info("RECALL_CONTENT=" + RECALL_CONTENT);
		//邮件召回 发件人回复内容 139企邮需求
		SENDER_RECALL_CONTENT = decode(sysCfgProp.getProperty("SENDER_RECALL_CONTENT"),
				"utf-8");
		if (SENDER_RECALL_CONTENT == null || SENDER_RECALL_CONTENT.trim().length() == 0) {
			SENDER_RECALL_CONTENT = "您好！您对邮件进行了撤回操作，结果如下：发给{RECEIVER}的邮件撤回成功(^_^)";
		}
		logger.info("SENDER_RECALL_CONTENT=" + SENDER_RECALL_CONTENT);
		try {
			REPLY_CONTENT_HTML = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/reply_header.htm", "utf-8");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/reply_header.htm\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		try {
			REPLY_CONTENT_TEXT = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/reply_header.txt", "utf-8");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/reply_header.txt\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		try {
			FORWARD_CONTENT_HTML = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/forward_header.htm", "utf-8");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/forward_header.htm\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		try {
			FORWARD_CONTENT_TEXT = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/forward_header.txt", "utf-8");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/forward_header.txt\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		// 初始化自动转发验证邮件
		try {
			String autoForwardContent = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/auto_forward_mail.html", "utf-8");
			SendMailService.addSendMailInfo("VERIFY_MAIL", "139邮箱-自动转发验证邮件",
					autoForwardContent);
		} catch (Exception ioe) {
			logger.warn("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/forward_header.txt\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
		}
		String trusted_links = "";
		try {
			trusted_links = FileService.readTxt(CONFIG_FILE_PATH
					+ "/trusted_links.conf", "utf-8");
		} catch (Exception ioe) {
			logger.error("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/trusted_links.conf\u5931\u8D25\uFF0C\u6A21\u5757\u6B63\u5728\u9000\u51FA....");
			System.exit(1);
		}
		if (trusted_links != null && !"".equals(trusted_links)) {
			String[] ss = trusted_links.split("\n");
			for (int i = 0; i < ss.length; i++) {
				if (ss[i] != null && !"".equals(ss[i].trim()))
					ALLOWN_FRAME_URLS.add(ss[i].trim().replaceAll("\\^", ""));
			}
		}
		// 附件上传压缩方式
		ZIPTYPE = sysCfgProp.getProperty("UPLOAD_ZIP_TYPE", "");
		logger.info("UPLOAD_ZIP_TYPE is " + ZIPTYPE);
		logger.info("ATTACHROOT is " + ATTACHROOT);
		logger.info("DAEMLROOT is " + DAEMLROOT);
		logger.info("REPLY_CONTENT_HTML is " + REPLY_CONTENT_HTML);
		NEW_CONF_PATH = sysCfgProp.getProperty("NEW_CONF_PATH",
				"/home/richmail/newconf/");
		SERVER_CONNECT_NUM = sysCfgProp.getProperty("SERVER_CONNECT_NUM");
		POPMAIL_LOGPATH = sysCfgProp.getProperty("POPMAIL_LOGPATH",
				"/home/richmail/logs/report/webapp.report.log");
		logger.info("SERVER_CONNECT_NUM is " + SERVER_CONNECT_NUM);
		if (!ISTEST) {
			MsgQID = Integer.parseInt(sysCfgProp.getProperty("MsgQID", "5000"));
			MsgQIDType = Integer.parseInt(sysCfgProp.getProperty("MsgQIDType",
					"1"));
			int msgId = MsgQ.msgget(MsgQID);// 解决消息队列不存在时，创建出的消息队列随机权限的问题
			int time = 0;
			while (msgId == -1 && time++ < 10) {// 有时reload第2次地读到－1，所以要判断
				msgId = MsgQ.msgget(MsgQID);
			}

			if (msgId >= 0) {
				MsgID = msgId;
				logger.info("MsgQID is " + MsgQID + ",MsgID is " + MsgID);
			} else {
				logger.error("Terminate_MSGQID_ERROR| MsgQID=" + MsgQID
						+ "| MsgID=" + MsgID + "|取不到消息队列ID，出错终止运行！");
				System.exit(1);
			}
		}
		DRAFT_IS_NEW = Integer.parseInt(sysCfgProp.getProperty("DRAFT_IS_NEW",
				"1"));
		DB_IS_MYSQL = Integer.parseInt(sysCfgProp.getProperty("DB_IS_MYSQL",
				"0"));
		IS_FILTER_BY_SO = Integer.parseInt(sysCfgProp.getProperty(
				"IS_FILTER_BY_SO", "1"));
		IS_ENABLE_202 = Integer.parseInt(sysCfgProp.getProperty(
				"IS_ENABLE_202", "0"));
		SAVE_SEND_BY_DA = Integer.parseInt(sysCfgProp.getProperty(
				"SAVE_SEND_BY_DA", "0"));
		IS_COREMAIL_CN_NAME = Integer.parseInt(sysCfgProp.getProperty(
				"IS_COREMAIL_CN_NAME", "1"));
		IS_INTERCEPT_SAME_URL = Integer.parseInt(sysCfgProp.getProperty(
				"IS_INTERCEPT_SAME_URL", "0"));
		COREMAIL_API_HOST = sysCfgProp.getProperty("COREMAIL_API_HOST");
		if (StringUtils.isBlank(COREMAIL_API_HOST)) {
			COREMAIL_API_HOST = "127.0.0.1";
			HAVE_CORE_MAIL = false; // 没有Core Mail的服务器配置，
		}
		COREMAIL_API_PORT = Integer.parseInt(sysCfgProp.getProperty(
				"COREMAIL_API_PORT", "6195"));

		logger.info("COREMAIL_API_PORT is " + COREMAIL_API_PORT);
		logger.info("HAVE_CORE_MAIL is " + HAVE_CORE_MAIL);

		IS_SCAN_COREMAIL_TIMEMAIL = Integer.parseInt(sysCfgProp.getProperty(
				"IS_SCAN_COREMAIL_TIMEMAIL", "0"));

		COREMAIL_IMAP_HOST = sysCfgProp.getProperty("COREMAIL_IMAP_HOST",
				"127.0.0.1");
		COREMAIL_IMAP_PORT = Integer.parseInt(sysCfgProp.getProperty(
				"COREMAIL_IMAP_PORT", "143"));

		COREMAIL_IMAP_SUPPERPASS = sysCfgProp.getProperty(
				"COREMAIL_IMAP_SUPPERPASS", "pushemail");
		MONITOR_PORT = Integer.parseInt(sysCfgProp.getProperty("MONITOR_PORT",
				"10001"));
		logger.info("MONITOR_PORT is " + MONITOR_PORT);
		IPLIMIT_NAME = sysCfgProp.getProperty("IPLIMIT_NAME", "iplimit");
		NOCOOKIE_IPLIMIT_NAME = sysCfgProp.getProperty("NOCOOKIE_IPLIMIT_NAME",
				"nocookie_iplimit");

		CORP_IPLIMIT_NAME = sysCfgProp.getProperty("NOCOOKIE_IPLIMIT_NAME",
				"webapp_corp_iplimit");

		logger.info("CORP_IPLIMIT_NAME is " + CORP_IPLIMIT_NAME);

		RM_BUSINESS_KEY = sysCfgProp.getProperty("RM_BUSINESS_KEY", "iplimit");

		AutoMailWorkNum = Integer.parseInt(sysCfgProp.getProperty(
				"MailWorkNum", "3"));
		ManuMailWorkNum = Integer.parseInt(sysCfgProp.getProperty(
				"MailWorkNum", "3"));
		PushMailWorkNum = Integer.parseInt(sysCfgProp.getProperty(
				"MailWorkNum", "3"));
		// AutoPopTime = Integer.parseInt(sysCfgProp.getProperty("AutoPopTime",
		// "12").trim());
		// logger.info("AutoPopTime=" + AutoPopTime);
		// SMS_NOTIFY_URL = sysCfgProp.getProperty("SMS_NOTIFY_URL",
		// "http://192.168.9.53:9900/proxy/MailAwokeSMS");
		// logger.info("SMS_NOTIFY_URL=" + SMS_NOTIFY_URL);
		// START_AUTOSCAN = Integer.parseInt(sysCfgProp.getProperty(
		// "START_AUTOSCAN", "0").trim());
		// logger.info("START_AUTOSCAN=" + START_AUTOSCAN);
		CHECK_COMEFROM = Integer.parseInt(sysCfgProp.getProperty(
				"CHECK_COMEFROM", "0")) == 1;
		NO_ATTACH_SIZE = Integer.parseInt(sysCfgProp.getProperty(
				"NO_ATTACH_SIZE", "2097152"));
		BUFFERSTREAM_LEN = Integer.parseInt(sysCfgProp.getProperty(
				"BUFFERSTREAM_LEN", "1048576"));
		// USER_SERIES_PAUSE_TIME = Long.parseLong(sysCfgProp.getProperty(
		// "USER_SERIES_PAUSE_TIME", "7200")) * 1000;// 配置单位为秒，转为毫秒
		// AUTO_POP_MAIL_NUM_LIMIT = Integer.parseInt(sysCfgProp.getProperty(
		// "AUTO_POP_MAIL_NUM_LIMIT", "200"));// 配置单位为封
		// AUTO_POP_NO_SMS_TIME = Long.parseLong(sysCfgProp.getProperty(
		// "AUTO_POP_NO_SMS_TIME", "2")) * 1000 * 60 * 60 * 24 * 2;// 配置单位为封

		RM_SUPPER_PWD = sysCfgProp
				.getProperty("RM_SUPPER_PWD", "RM_SUPPER_PWD");

		NEW_CONF_READ = "1"
				.equals(sysCfgProp.getProperty("NEW_CONF_READ", "1"));
		IS_OPEN_MAILMOVE_FROM = "1".equals(sysCfgProp.getProperty(
				"IS_OPEN_MAILMOVE_FROM", "0"));
		// 自动转发安全校验邮件模板
		try {
			FORWARD_VERIFY_HTML = FileService.readConfFileSkipEFBBBF(
					CONFIG_FILE_PATH + "/forward_verify.htm", "utf-8");
			logger.info("FORWARD_VERIFY_HTML=" + FORWARD_VERIFY_HTML);
		} catch (Exception ioe) {
			logger.warn("\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6/forward_verify.htm\u5931\u8D25....");
		}
		FORWARD_VERIFY_KEY = sysCfgProp.getProperty("FORWARD_VERIFY_KEY",
				"139Forward");
		WEB_MAX_SEND_NUM = Integer.parseInt(sysCfgProp.getProperty(
				"WEB_MAX_SEND_NUM", "500"));
		SEARCH_SENDID_COUNT = Integer.parseInt(sysCfgProp.getProperty(
				"SEARCH_SENDID_COUNT", "210"));
		OPEN_139_FILTER = "1".equals(sysCfgProp.getProperty("OPEN_139_FILTER",
				"0"));
		OPEN_139_DENYFORWARD = "1".equals(sysCfgProp.getProperty("OPEN_139_DENYFORWARD",
				"0"));
		OPEN_139_RESTORE_DELMail = "1".equals(sysCfgProp.getProperty("OPEN_139_RESTORE_DELMail",
				"0"));
		logger.info("OPEN_139_DENYFORWARD="+OPEN_139_DENYFORWARD+" |OPEN_139_RESTORE_DELMail="+OPEN_139_RESTORE_DELMail);
		VALIDATE_CODE_URL = sysCfgProp.getProperty("VALIDATE_CODE_URL");
		VALIDATE_USERPERMISS_URL = sysCfgProp.getProperty("VALIDATE_USERPERMISS_URL");
		CALENDAR_URL = sysCfgProp.getProperty("CALENDAR_URL");
		idiotQiYouNoCheckAllowsIP = "1"
				.equals(sysCfgProp.getProperty("QIYOU_NO_CHECK_ALLOWS_IP", "1"));
		
		//读取12期配置文件中不存在的配置参数。
		String webapp12qi = CONFIG_FILE_PATH + "/webapp12qi.ini";
		File file = new File(webapp12qi);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read;
			try {
				read = new InputStreamReader(new FileInputStream(file), "UTF-8");// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					logger.info(lineTxt);
				}
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	public static String decode(String s, String charset) {
		if (s != null && !"".equals(s)) {
			try {
				s = new String(s.getBytes("ISO8859_1"), charset);
			} catch (Exception e) {
			}
		}
		return s;
	}

	public static String getValue(String s, String start, String end) {
		return s.split(start)[1].substring(0, s.split(start)[1].indexOf(end));

	}
}
