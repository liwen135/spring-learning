##核心类
####DefaultListableBeanFactory
在spring-beans
org.springframework.beans.factory.support.DefaultListableBeanFactory
###解析xml
####XmlBeanFactory 
XmlBeanFactory extends DefaultListableBeanFactory
org.springframework.beans.factory.xml.XmlBeanFactory
####XmlBeanDefinitionReader
org.springframework.beans.factory.xml.XmlBeanDefinitionReader
org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.parseBeanDefinitionElement(org.w3c.dom.Element, java.lang.String, org.springframework.beans.factory.config.BeanDefinition)
xml->org.springframework.beans.factory.support.GenericBeanDefinition
org.springframework.beans.factory.xml.BeanDefinitionParserDelegate //完成了对xml的解析
####AbstractBeanDefinition
org.springframework.beans.factory.support.AbstractBeanDefinition

###注册
// Register the final decorated instance.
            BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry());
   //注册         
org.springframework.beans.factory.support.DefaultListableBeanFactory.registerBeanDefinition
    1.对AbstractBeanDefinition校验，重写方法必须存在
    2.已经注册的bean,是否允许覆盖
    3.加入map /** Map of bean definition objects, keyed by bean name. */
            	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    4.清除之前留下对应beanName的缓存
  //注册完成发送监听
  // Send registration event.
    getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));  

###获取bean
####AbstractBeanFactory
        Object bean = act.getBean("emp01");
org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean    