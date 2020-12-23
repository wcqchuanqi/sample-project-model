# sample-project-model
<h1>项目模板</h1>

该项目搭建主要表述以下内容（之后会根据调研逐渐叠加）：

<h2>1.项目结构搭建</h2>

<h3>继承关系</h3>
  父项目：sample-project-model <br/>
  子项目：sample-project-web、sample-project-biz、sample-project-dao、sample-project-sdk、
  sample-project-common、sample-project-domain、sample-project-vo</module>
  
PS：继承关系便于共性管理，如dependency、plugin等；<br/>
    聚合关系便于构建项目；<br/>
    分析依赖关系有利于防止包冲突；<br/>

<h3>聚合关系</h3>
sample-project-model<br/>
module:<br/>
sample-project-web<br/>
sample-project-biz<br/>
sample-project-dao<br/>
sample-project-sdk<br/>
sample-project-common<br/>
sample-project-domain<br/>
sample-project-vo<br/>
<h3>依赖关系</h3>

sample-project-web依赖sample-project-biz<br/>
sample-project-biz依赖sample-project-dao/vo/common<br/>
sample-project-dao依赖sample-project-domain<br/>
sample-project-vo依赖sample-project-domain<br/>

<h2>2.vo dto entity定义与转换定义</h2>

entity：只关注与db，与db字段属性相一致；<br/>
dto：作为biz中业务处理的唯一pojo（数据传输）。也就是说biz与上（web）下（dao）游交互只使用dto；<br/>
vo：作为web与外部系统交互pojo，vo又分为requestVo和responseVo；<br/>
vo与dto转换在web中，dto与entity转换在dao中。<br/>


<h2>3.Spring boot 快速搭建项目</h2>

搭建过程"百度一下"<br/>

PS：关于Spring boot 细节后续更新，比：加载，启动等。<br/>

<h2>4.Spring boot + mybatis + mybatis plus 整合</h2>

关注两个网站：<br/>
mybatis 官网：https://mybatis.org/mybatis-3/zh/index.html <br/>
（目前阶段先不要深究，因为mybatis plus帮我们屏蔽了很多内容，建议后续要补上）<br/><br/>
mybatis-plus 官网：https://baomidou.com/guide/ （文档结合源码）<br/>

<h2>5.引入log4j2</h2>

配置可以参考 sample-project-web module 的resources下的log4j2.xml;<br/>
关于log4j2实现的异步日志问题，有兴趣可以关注下disruptor;<br/>
关注一点：spring boot 默认的是logback，因此需要将spring boot的与logback相关包 exclusion<br/>

<h2>6.引入lombox</h2>

lombox的引入包括两部分：<br/>
1.lombox 包；（尽量<optional>true</optional>，限制住不要外传，避免影响外部调用，这里sdk需要注意）<br/>
2.相应的IDE需要安装插件；<br/>

对于lombox的使用褒贬不一<br/>
优点：减少冗长的代码<br/>
缺点：强制团队都需要安装插件，还有如果对相关注解不理解会有坑。如@Data 它在自动生成 setter ，getter的同时也会做其他动作，<br/>
如 @Data 生成的equals()方法只会比较子类的属性，不会考虑父类继承的属性，无论父类属性访问权限是否开放。

<h2>7.引入easyexcel</h2>
关注官网：https://www.yuque.com/easyexcel/doc/easyexcel<br/>
比较精悍的小工具，提高excel的导入导出效率。<br/>
PS： 个人理解类似这种IO尽量异步处理，避免出现超时的情况。（关注下spring的@Async）<br/>

<h2>8.引入hutool</h2>
官网：https://www.hutool.cn/  <br/>
最近刚发现的一个小工具，包括不少common utils 和commons-lang3很相似。<br/>
具体是否使用根据自己习惯判断。<br/>

