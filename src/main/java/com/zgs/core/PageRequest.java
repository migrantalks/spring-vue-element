package com.zgs.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.MoreObjects;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页结果
 * @author zgs
 */
@Data
public class PageRequest implements Serializable{

	/**
	 * 每页行数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pageNum;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("pageSize", pageSize)
				.add("pageNum", pageNum)
				.toString();
	}

	/**
     * 操作执行DTO
     *
     * @author zgs
     *
     */
    @Data
    public static class Result<T> {

        private int code;
        private String message;
        private T data;

        public Result setCode(int code) {
            this.code = code;
            return this;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public Result setMessage(String message) {
            this.message = message;
            return this;
        }

        public T getData() {
            return data;
        }

        public Result setData(T data) {
            this.data = data;
            return this;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

        private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

        public static Result success(String message) {
            return new Result()
                    .setCode(200)
                    .setMessage(StringUtils.isNotBlank(message) ? message : DEFAULT_SUCCESS_MESSAGE);
        }

        public static <T> Result<T> success(T data) {
            return new Result()
                    .setCode(200)
                    .setMessage(DEFAULT_SUCCESS_MESSAGE)
                    .setData(data);
        }

        public static Result fail(String message) {
            return new Result()
                    .setCode(400)
                    .setMessage(message);
        }

        /**
         * 动态添加属性 map 用法可以参考 activiti 模块中 com.len.JsonTest 测试类中用法
         * @param count
         * @param data
         * @param map
         * @param node 绑定节点字符串 这样可以更加灵活
         * @return
         */
        public static String jsonString(long count, List<?> data,
                                       Map<String, Map<String,Object>> map,
                                       String node){
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(data));
            JSONObject object = new JSONObject();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonData = (JSONObject) jsonArray.get(i);
                jsonData.putAll(map.get(jsonData.get(node)));
            }
            object.put("total", count);
            object.put("rows", jsonArray);
            object.put("code", 0);
            object.put("msg", "");

            return object.toJSONString();
        }

    }
}
