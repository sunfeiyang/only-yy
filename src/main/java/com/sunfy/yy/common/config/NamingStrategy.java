package com.sunfy.yy.common.config;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * <p>Project:com.midea.jr.ecf			<p>
 * <p>Module:meloans.utils			<p>
 * <p>Description:表列名转成大写		<p>
 *
 * @author WANGZY25
 * @date 2016年9月20日 下午5:35:15
 */
public class NamingStrategy extends ImprovedNamingStrategy {

    /**  */
    private static final long serialVersionUID = 1L;

    @Override
    public String tableName(String tableName) {
        return tableName.toUpperCase();
    }

    @Override
    public String columnName( String columnName ) {
        return super.columnName( columnName ).toUpperCase();
    }

    @Override
    public String propertyToColumnName( String propertyName ) {
        return super.propertyToColumnName( propertyName ).toUpperCase();
    }
}
