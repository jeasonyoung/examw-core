package com.examw.support;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 自定义日期格式JSON化。
 * @author yangyong
 * @since 2014-05-12.
 */
public  class CustomDateSerializer extends JsonSerializer<Date> {
	//时间格式
	private static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss",SHORT_DATE_FORMAT  = "yyyy-MM-dd";
	/**
	 * 长日期格式（yyyy-MM-dd HH:mm:ss）
	 */
	public final static CustomDateSerializer Long = new CustomDateSerializer(){
		@Override
		public void serialize(Date value, JsonGenerator jgen,SerializerProvider provider) throws IOException,JsonProcessingException {
			this.serialize(value, jgen, LONG_DATE_FORMAT);
		}
	};
	/**
	 * 短日期格式（yyyy-MM-dd）
	 */
	public final static CustomDateSerializer Short = new CustomDateSerializer(){
		@Override
		public void serialize(Date value, JsonGenerator jgen,SerializerProvider provider) throws IOException,JsonProcessingException {
			this.serialize(value, jgen, SHORT_DATE_FORMAT);
		}
	};
	/*
	 * 格式转化。
	 * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator, org.codehaus.jackson.map.SerializerProvider)
	 */
	@Override
	public void serialize(Date value, JsonGenerator jgen,SerializerProvider provider) throws IOException,JsonProcessingException {
		 Long.serialize(value, jgen, provider);
	}
	/**
	 * 格式化日期数据。
	 * @param value
	 * @param jgen
	 * @param format
	 * @throws JsonGenerationException
	 * @throws IOException
	 */
	protected void serialize(Date value, JsonGenerator jgen, String format) throws JsonGenerationException, IOException{
		 SimpleDateFormat formatter = new SimpleDateFormat(format); 
		 jgen.writeString(formatter.format(value));
	}
}