package cn.richinfo.rmweb.archiver.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.richinfo.common.log.LoggerManager;
import cn.richinfo.rmweb.common.WebConstants;

public class Test {
	private static LoggerManager logger = new LoggerManager(Test.class);
	public static void main(String[] args) {
		Test test=new Test();
	//	String str = "最后还款日:01月06日\n人民币账单金额:￥8,590.21\n美元账单金额:＄0.00\n人民币最低还款额:￥1,398.12\n美元最低还款额:＄0.00\n"
	//			+ "最后还款日1:01月07日\n人民币账单金额1:￥8,590.210\n美元账单金额1:＄0.006\n人民币最低还款额1:￥1,398.126\n美元最低还款额1:＄0.003\n"
	//			+"最后还款日2:01月08日\n人民币账单金额2:￥8,590.2100\n美元账单金额2:＄0.007\n人民币最低还款额2:￥1,398.125\n美元最低还款额2:＄0.004"
	//			;
	//	String str="航班:MU2150\n起飞:2016年10月13日 20:35   长沙黄花T2\n到达:2016年10月13日 22:15   西安咸阳T3\n姓名:白云龙,李江川,刘生兴,张正平";
	//	String str="酒店:吉隆坡晶冠酒店\n地址:No.3, Jalan Jambu MawarOff Jalan Kepong 52000 Kuala Lumpur\n电话:-uju\n到店:2016年10月10日 00:00-24:00\n离店:2016年10月11日\n姓名:lin/jingde,wang/bingfeng";
		String str="车次:G7072\n座位:05车06C号\n发车:2016年08月10日 06:02\n站点:上海—芜湖\n姓名:王茂胜\n车次:G7072\n座位:05车06D号\n发车:2016年08月10日 06:02\n站点:上海—芜湖\n姓名:王家佳";
		WebConstants.initMailOrderPEParam("C:\\Users\\Administrator\\Desktop\\mm.ini");
		Map<String, Object> innerMap =test.initJsonMap();
		test.replaceMapKey(str, innerMap);
		System.out.println(innerMap.toString());
	}
	private void replaceMapKey(String str, Map<String, Object> innerMap) {
		String[] mailOrders = str.split("\n");
		for (String string : mailOrders) {
			String[] mailOrder = string.split(":");
			String key = WebConstants.loadMailOrderMap.get(mailOrder[0]);
				if (null != key && StringUtils.isNotBlank(key)) {
					int begin = key.indexOf(".");
					int end = key.lastIndexOf(".");
					if (begin != -1) {
						String[] keys = key.split("\\.");
						Map<String, Object> firsrNode = (Map<String, Object>) innerMap.get(keys[0]);
						for (int i = 1; i < keys.length-1; i++) {
							if(null!=firsrNode){
								firsrNode=(Map<String, Object>) firsrNode.get(keys[i]);
							}
						}
						if(null!=firsrNode){
							firsrNode.put(keys[keys.length-1], mailOrder[1]);

						}else{
							logger.error(
									"the param form is wrong  in mailOrderPE.ini");
						}
					}
					else {
						innerMap.put(key, mailOrder[1]);
					}
				}
				else {
					innerMap.put(mailOrder[0], mailOrder[1]);
				}
		}
	}

	private Map<String, Object> initJsonMap() {
		Map<String, Object> innerMap = new HashMap<String, Object>();
		String jsonInnerKey = WebConstants.loadMailOrderMap.get("innerKey");
		if (StringUtils.isNotBlank(jsonInnerKey) && null != jsonInnerKey) {
			String[] jsonInnerKeys = jsonInnerKey.split(",");
			Map<String, Object> secondNode =null;
			Map<String, Object> secondNode1=null;
			for (String string : jsonInnerKeys) {
				if (string.contains(".")) {
					String[] arrs = string.split("\\.");
					 secondNode = (Map<String, Object>) innerMap.get(arrs[0]);
					if (null == secondNode) {
						innerMap.put(arrs[0], new HashMap<String, Object>());
					}
					secondNode=(Map<String, Object>) innerMap.get(arrs[0]);
					for(int i=1;i<arrs.length;i++){
						 secondNode1 = (Map<String, Object>) secondNode.get(arrs[i]);
						if (null == secondNode1) {
							if(i-1!=0){
								secondNode=(Map<String, Object>) secondNode.get(arrs[i-1]);
							}
							secondNode.put(arrs[i], new HashMap<String, Object>());
						}
	//					else{
	//						secondNode1.put(arrs[i+1], new HashMap<String, Object>());
	//					}
	//					secondNode1 = (Map<String, Object>) innerMap.get(arrs[i]);
	//					secondNode.put(arrs[i+1], new HashMap<String, Object>());
					}
				} else {
					Map<String, Object> firstNode = (Map<String, Object>) innerMap.get(string);
					if (null == firstNode) {
						innerMap.put(string, new HashMap<String, Object>());
					}
				}
			}
		}
		return innerMap;
	}

   private Map<String,Object> getMap(Map<String, Object> map,String[] arrs){
	   Map<String,Object> newmap1=null;
	   Map<String,Object> newmap=null;
	   for(int i=0;i<arrs.length-1;i++){
		   newmap=(Map<String, Object>) map.get(arrs[i]);
		   if(null!=newmap){
			   newmap=(Map<String, Object>) newmap.get(arrs[i+1]);
			   if(null!=newmap){
				   newmap1=newmap;
			   }
			   else{
				   newmap=(Map<String, Object>) newmap1.get(arrs[i-1]);
				   newmap.put(arrs[i+1], new HashMap<String, Object>());
			   }
		   }
		   else{
			   map.put(arrs[i], new HashMap<String, Object>());
			}
	   }
	  return newmap;
   }
}