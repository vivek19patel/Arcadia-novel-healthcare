/**
 * 
 */
package com.arcedia.config;

/**
 * @author Vivek
 *
 */
 enum VivekEnum {
	MYSQL,ORACLE,MONGODB;
}


class Arush{
	public static void main(String[] args) {
		VivekEnum oracle = VivekEnum.ORACLE;
		System.out.println(oracle);
	}
	
}
