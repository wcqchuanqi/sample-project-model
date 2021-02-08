package org.primary.sample.model.biz.vm.service.Impl;

import org.primary.sample.model.dao.vm.entity.VmInfo;
import org.primary.sample.model.dao.vm.service.IVmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 缓存demo讲解.
 *
 * @author wangchuanqi02
 */
@Component
/**
 * @CacheConfig 抽取类中所有@CachePut@Cacheable@CacheEvict的公共配置，修饰在类上。
 * 属性值：
 *  cacheNames:定义缓存操作的默认名称(方法中@Cacheable的value会覆盖该属性值)（定义一个或者多个名称）;
 *  keyGenerator:用于指定key生成器。默认的key生成器（org.springframework.cache.interceptor.KeyGenerator）
 *              若需要指定自定义的key生成器，需要去实现接口KeyGenerator。PS：该属性与缓存操作注解中的key时互斥的。
 *  cacheManager:指定该类所使用的CacheManager(缓存管理器);
 *  cacheResolver:指定该类所使用的cacheResolver(获取解析器);
 */
@CacheConfig(cacheNames = "vmInfo")
public class VmInfoCacheDemo {

    @Autowired
    IVmInfoService vmInfoService;

    /**
     * @Cacheable:先查询是否已经有缓存，有会使用缓存，没有则会执行方法并缓存;
     * 属性值：
     * value与cacheNames等价：用于指定缓存名称（即：缓存存放在哪块命名空间）
     * key：缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合。
     *    如：targetClass + methodName +#p0  表示的key指为：对象实例+方法名称+方法的第一参数。
     *     PS：targetClass/methodName 是SpEL root.targetClassde/root.methodName 的缩写
     *         #p0 等价与 #vmId,都表示方法的第一参数
     * condition：条件符合则缓存，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存
     *     如：condition="#vmId.isEmpty()"
     * unless :与condition相反，
     * sync:（默认指false） 缓存过期之后，如果多个线程同时请求对某个数据的访问，会同时去到数据库，导致数据库瞬间负荷增高。
     *     当设置它为true时，只有一个线程的请求会去到数据库，其他线程都会等待直到缓存可用。这个设置可以减少对数据库的瞬间并发访问。
     */
    @Cacheable(value = "vmInfo", key = "targetClass + methodName +#p0")
    public VmInfo getVmInfoByVmIdCache(String vmId) {
        return vmInfoService.queryVmInfoByVmId(vmId);
    }


    /**
     * @CachePut:调用方法并将返回值存入缓存,通常用于修改了数据库的数据后，更新缓存中的数据.
     * 需要有一个@Cacheable定义的vlue和key都相同的方法，类获取该缓存.具体见（方法：afterUpdateVmInfoByVmIdCache）
     * @CachePut 属性值（除去sync）与@Cacheable 相同
     */
    @CachePut(value = "vmInfo", key = "#vmInfo.id")
    public VmInfo updateVmInfoCache(VmInfo vmInfo) {
        vmInfoService.updateById(vmInfo);
        return vmInfo;
    }

    @Cacheable(value = "vmInfo", key = "#id")
    public VmInfo afterUpdateVmInfoByVmIdCache(String id) {
        return vmInfoService.queryVmInfoByVmId(id);
    }

    /**
     * @CacheEvict：根据一定的条件对缓存进行清空
     * 属性值：value，cacheNames，key，condition都与上面相同
     * allEntries：指定是否清空所有缓存（默认false），true表示清空所有缓存；
     * beforeInvocation：指定是否在方法执行前清空缓存（默认false），true表示方法还没有执行就清空了缓存.
     */
    @CacheEvict(value = "vmInfo", key = "#id")
    public void deleteVmInfoByIdCache(String id){
    }

    /**
     * @Caching：组合缓存操作
     * 属性：
     * cacheable：Cacheable[]
     * put：CachePut[]
     * evict: CacheEvict[]
     */
    @Caching(cacheable = {
            // 缓存vmInfo，key为vmInfo.id
            @Cacheable(value = "vmInfoAll", key = "#vmInfo.id"),
            // 缓存vmInfo，key为vmInfo.vmId
            @Cacheable(value = "vmInfoAll", key = "#vmInfo.vmId")
    }, put ={
            // 更新缓存vmInfo，key为vmInfo.id
            @CachePut(value = "vmInfoAll",key = "#vmInfo.id")
    }
    )
    public VmInfo allVmInfoCache(VmInfo vmInfo){
        return vmInfoService.queryVmInfoByVmId(vmInfo.getId());
    }
}
