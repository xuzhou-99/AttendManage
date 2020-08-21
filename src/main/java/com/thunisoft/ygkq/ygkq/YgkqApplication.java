/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq
 * @className com.thunisoft.ygkq.ygkq.YgkqApplication
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


/**
 *
 * YgkqApplication
 *
 * @description YgkqApplication
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@EnableCaching
@SpringBootApplication
@MapperScan({"com.thunisoft.ygkq.ygkq"})
public class YgkqApplication {

	/**
     * YgkqApplication
     *
     * @description 主类
     * @param args 启动参数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     **/
    public static void main(String[] args) {
    	SpringApplication.run(YgkqApplication.class, args);
    }
}