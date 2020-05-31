##SqlSessionFactoryBean
org.mybatis.spring.SqlSessionFactoryBean
    implements FactoryBean<SqlSessionFactory>, InitializingBean, ApplicationListener<ApplicationEvent> {
    
    afterPropertiesSet() 
     org.mybatis.spring.SqlSessionFactoryBean.buildSqlSessionFactory
     初始化会解析mybatis-config.xml 得到Configuration
##Configuration     
org.apache.ibatis.session.Configuration
##MapperFactoryBean
org.mybatis.spring.mapper.MapperFactoryBean
 MapperFactoryBean org.apache.ibatis.binding.MapperRegistry使用动态代理生成
 
##MapperScannerConfigurer 
 org.mybatis.spring.mapper.MapperScannerConfigurer
  implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        if (this.processPropertyPlaceHolders) {
          processPropertyPlaceHolders();
        }
    
        ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
        scanner.setAddToConfig(this.addToConfig);
        scanner.setAnnotationClass(this.annotationClass);
        scanner.setMarkerInterface(this.markerInterface);
        scanner.setSqlSessionFactory(this.sqlSessionFactory);
        scanner.setSqlSessionTemplate(this.sqlSessionTemplate);
        scanner.setSqlSessionFactoryBeanName(this.sqlSessionFactoryBeanName);
        scanner.setSqlSessionTemplateBeanName(this.sqlSessionTemplateBeanName);
        scanner.setResourceLoader(this.applicationContext);
        scanner.setBeanNameGenerator(this.nameGenerator);
        scanner.setMapperFactoryBeanClass(this.mapperFactoryBeanClass);
        if (StringUtils.hasText(lazyInitialization)) {
          scanner.setLazyInitialization(Boolean.valueOf(lazyInitialization));
        }
        scanner.registerFilters();
        scanner.scan(
            StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
      }
      
      
        public Set<BeanDefinitionHolder> doScan(String... basePackages) {
          Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
      
          if (beanDefinitions.isEmpty()) {
            LOGGER.warn(() -> "No MyBatis mapper was found in '" + Arrays.toString(basePackages)
                + "' package. Please check your configuration.");
          } else {
            processBeanDefinitions(beanDefinitions);
          }
      
          return beanDefinitions;
        }