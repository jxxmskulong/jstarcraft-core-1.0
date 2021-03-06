package com.jstarcraft.core.storage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jstarcraft.core.script.JsExpression;
import com.jstarcraft.core.script.ScriptExpression;
import com.jstarcraft.core.utility.StringUtility;

/**
 * 仓储引用
 * 
 * @author Birdy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StorageReference {

	/**
	 * 脚本类型
	 * 
	 * @return
	 */
	Class<? extends ScriptExpression> type() default JsExpression.class;

	/**
	 * 标识表达式(根据字段类型计算仓储标识或者Spring标识)
	 * 
	 * @return
	 */
	String expression() default StringUtility.EMPTY;

	/**
	 * 是否必须
	 * 
	 * @return
	 */
	boolean necessary() default true;

}
