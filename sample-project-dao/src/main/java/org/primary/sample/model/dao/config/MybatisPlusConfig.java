package org.primary.sample.model.dao.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 与mybatis plus相关所有配置信息
 *
 * @author wangchuanqi
 * @version 0.0.1
 * @since 2020/12/19
 */
@Configuration
@MapperScan("org.primary.sample.model.dao.**.mapper")
public class MybatisPlusConfig {
    /**
     * mybatis plus 插件注入
     *
     * @return 所有插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptorAll() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //  添加多租户插件
//        interceptor.addInnerInterceptor(this.getTenantLineInnerInterceptor());
        // 添加分页插件
        interceptor.addInnerInterceptor(this.getPaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * 多租户插件初始化
     *
     * @return 多租户插件
     */
    private TenantLineInnerInterceptor getTenantLineInnerInterceptor() {
        // 定义多租户插件，并注入TenantLineHandler（设置租户 ID 值表达式，只支持单个 ID 值）
        return new TenantLineInnerInterceptor(() -> new LongValue(1));
    }

    /**
     * 分页插件初始化
     *
     * @return 分页插件
     */
    private PaginationInnerInterceptor getPaginationInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        //  数据库类型
        interceptor.setDbType(DbType.MYSQL);
        // 单页分页条数限制,默认 500 条，小于 0 如 -1 不受限制(处理超出分页条数限制,默认归为限制数)
        interceptor.setMaxLimit(1000L);
        return interceptor;
    }

    /**
     * 加载 MybatisConfiguration（mybatis plus 配置数据）
     *
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        // 设置UseDeprecatedExecutor 会因为要兼容历史插件，之后随着历史插件失效也随之失效（主要针对分页插件）
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
