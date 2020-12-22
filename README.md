# sample-project-model
<h1>项目模板</h1>

该项目搭建主要表述以下内容（之后会根据调研逐渐叠加）：

<h2>1.项目结构搭建</h2>

<h3>继承关系</h3>
  父项目：sample-project-model <br/>
  子项目：sample-project-web、sample-project-biz、sample-project-dao、sample-project-sdk、
  sample-project-common、sample-project-domain、sample-project-vo</module>
  
PS：继承关系便于共性管理，如dependency、plugin等

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
sample-project-dao依赖sample-project-domain<br/>
sample-project-vo依赖sample-project-domain<br/>

<h2>2.Spring boot 快速搭建项目</h2>
PS：关于Spring boot 细节后续更新，比：加载，启动等。
<h2>3.Spring boot + mybatis + mybatis plus 整合</h2>
<h2>4.引入log4j2</h2>
<h2>5.引入lombox<h2/>
<h2>5.引入easyexcel<h2/>
<h2>5.引入hutool<h2/>