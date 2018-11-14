package kr.or.kosta.sjrent.common.converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.simple.JSONObject;

/**
 * Object를 받아서 동적으로 jsonObject로 convert 시켜주기 위한 클래스
 * @author 남수현
 *
 */
public class ObjectToJson {

	public ObjectToJson() {
		super();
	}
	/**
	 * objcet to jsonObject converter
	 * @param object jsonobject로 변환시킬 object
	 * @return 변환된 jsonobject
	 */
	public JSONObject ObjectToJsonObject(Object object) {
		JSONObject obj = new JSONObject();
		Class inputClass = null;
		try {
			inputClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method[] methodList = inputClass.getMethods();
		for (Method method : methodList) {
			String methodName = method.getName();
			if(methodName.substring(0, 3).equals("get")&&!methodName.equals("getClass")) {
				String variableName = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
				try {
					obj.put(variableName,method.invoke(object));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				}
			}
		}
		return obj;
	}
}
