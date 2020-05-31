##TxNamespaceHandler
org.springframework.transaction.config.TxNamespaceHandler
org.springframework.transaction.config.AnnotationDrivenBeanDefinitionParser
        org.springframework.transaction.config.AnnotationDrivenBeanDefinitionParser.parse
        public BeanDefinition parse(Element element, ParserContext parserContext) {
        		registerTransactionalEventListenerFactory(parserContext);
        		String mode = element.getAttribute("mode");
        		if ("aspectj".equals(mode)) {
        			// mode="aspectj"
        			registerTransactionAspect(element, parserContext);
        			if (ClassUtils.isPresent("javax.transaction.Transactional", getClass().getClassLoader())) {
        				registerJtaTransactionAspect(element, parserContext);
        			}
        		}
        		else {
        			// mode="proxy"
        			AopAutoProxyConfigurer.configureAutoProxyCreator(element, parserContext);
        		}
        		return null;
        	}
        	
        public static void configureAutoProxyCreator(Element element, ParserContext parserContext) {
                    //代理
        			AopNamespaceUtils.registerAutoProxyCreatorIfNecessary(parserContext, element);
        
        			String txAdvisorBeanName = TransactionManagementConfigUtils.TRANSACTION_ADVISOR_BEAN_NAME;
        			if (!parserContext.getRegistry().containsBeanDefinition(txAdvisorBeanName)) {
        				Object eleSource = parserContext.extractSource(element);
        
        				// Create the TransactionAttributeSource definition.
        				RootBeanDefinition sourceDef = new RootBeanDefinition(
        						"org.springframework.transaction.annotation.AnnotationTransactionAttributeSource");
        				sourceDef.setSource(eleSource);
        				sourceDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        				//注册bean,并且用spring中定义的规则生成beanName
        				String sourceName = parserContext.getReaderContext().registerWithGeneratedName(sourceDef);
        
        				// Create the TransactionInterceptor definition. 
        				RootBeanDefinition interceptorDef = new RootBeanDefinition(TransactionInterceptor.class);
        				interceptorDef.setSource(eleSource);
        				interceptorDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        				registerTransactionManager(element, interceptorDef);
        				interceptorDef.getPropertyValues().add("transactionAttributeSource", new RuntimeBeanReference(sourceName));
        				String interceptorName = parserContext.getReaderContext().registerWithGeneratedName(interceptorDef);
        
        				// Create the TransactionAttributeSourceAdvisor definition.
        				RootBeanDefinition advisorDef = new RootBeanDefinition(BeanFactoryTransactionAttributeSourceAdvisor.class);
        				advisorDef.setSource(eleSource);
        				advisorDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
###                     advisorDef.getPropertyValues().add("transactionAttributeSource", new RuntimeBeanReference(sourceName));
        				advisorDef.getPropertyValues().add("adviceBeanName", interceptorName);
        				if (element.hasAttribute("order")) {
###        					advisorDef.getPropertyValues().add("order", element.getAttribute("order"));
        				}
###        				parserContext.getRegistry().registerBeanDefinition(txAdvisorBeanName, advisorDef);
        
        				CompositeComponentDefinition compositeDef = new CompositeComponentDefinition(element.getTagName(), eleSource);
        				compositeDef.addNestedComponent(new BeanComponentDefinition(sourceDef, sourceName));
        				compositeDef.addNestedComponent(new BeanComponentDefinition(interceptorDef, interceptorName));
        				compositeDef.addNestedComponent(new BeanComponentDefinition(advisorDef, txAdvisorBeanName));
        				parserContext.registerComponent(compositeDef);
        			}
        		}	
        		
   abstract class AopNamespaceUtils {
      public static final String PROXY_TARGET_CLASS_ATTRIBUTE = "proxy-target-class";
      private static final String EXPOSE_PROXY_ATTRIBUTE = "expose-proxy";
  
      public AopNamespaceUtils() {
      }
## tx   registerAutoProxyCreatorIfNecessary
      public static void registerAutoProxyCreatorIfNecessary(ParserContext parserContext, Element sourceElement) {
          BeanDefinition beanDefinition = AopConfigUtils.registerAutoProxyCreatorIfNecessary(parserContext.getRegistry(), parserContext.extractSource(sourceElement));
          useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
          registerComponentIfNecessary(beanDefinition, parserContext);
      }
  
      public static void registerAspectJAutoProxyCreatorIfNecessary(ParserContext parserContext, Element sourceElement) {
          BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAutoProxyCreatorIfNecessary(parserContext.getRegistry(), parserContext.extractSource(sourceElement));
          useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
          registerComponentIfNecessary(beanDefinition, parserContext);
      }
## AOP registerAspectJAnnotationAutoProxyCreatorIfNecessary
      public static void registerAspectJAnnotationAutoProxyCreatorIfNecessary(ParserContext parserContext, Element sourceElement) {
          BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(parserContext.getRegistry(), parserContext.extractSource(sourceElement));
          useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
          registerComponentIfNecessary(beanDefinition, parserContext);
      }
  
      private static void useClassProxyingIfNecessary(BeanDefinitionRegistry registry, @Nullable Element sourceElement) {
          if (sourceElement != null) {
              boolean proxyTargetClass = Boolean.parseBoolean(sourceElement.getAttribute("proxy-target-class"));
              if (proxyTargetClass) {
                  AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
              }
  
              boolean exposeProxy = Boolean.parseBoolean(sourceElement.getAttribute("expose-proxy"));
              if (exposeProxy) {
                  AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
              }
          }
  
      }
  
      private static void registerComponentIfNecessary(@Nullable BeanDefinition beanDefinition, ParserContext parserContext) {
          if (beanDefinition != null) {
              parserContext.registerComponent(new BeanComponentDefinition(beanDefinition, "org.springframework.aop.config.internalAutoProxyCreator"));
          }
  
      }
  }  
###  AopConfigUtils
  org.springframework.aop.config.AopConfigUtils   		
  
  	static {
  		// Set up the escalation list...
  		APC_PRIORITY_LIST.add(InfrastructureAdvisorAutoProxyCreator.class);
  		APC_PRIORITY_LIST.add(AspectJAwareAdvisorAutoProxyCreator.class);
  		APC_PRIORITY_LIST.add(AnnotationAwareAspectJAutoProxyCreator.class);
  	}
### 方法  	
org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessAfterInitialization
###方法 computeTransactionAttribute
org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource.computeTransactionAttribute
###TransactionAnnotationParser 的实现类
 * @author Juergen Hoeller
 * @since 2.5
 * @see AnnotationTransactionAttributeSource
 * @see SpringTransactionAnnotationParser
 * @see Ejb3TransactionAnnotationParser
 * @see JtaTransactionAnnotationParser
 */
public interface TransactionAnnotationParser

org.springframework.transaction.annotation.SpringTransactionAnnotationParser.parseTransactionAnnotation(org.springframework.core.annotation.AnnotationAttributes)
    protected TransactionAttribute parseTransactionAnnotation(AnnotationAttributes attributes) {
            RuleBasedTransactionAttribute rbta = new RuleBasedTransactionAttribute();
    
            Propagation propagation = attributes.getEnum("propagation");
            rbta.setPropagationBehavior(propagation.value());
            Isolation isolation = attributes.getEnum("isolation");
            rbta.setIsolationLevel(isolation.value());
            rbta.setTimeout(attributes.getNumber("timeout").intValue());
            rbta.setReadOnly(attributes.getBoolean("readOnly"));
            rbta.setQualifier(attributes.getString("value"));
    
            List<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
            for (Class<?> rbRule : attributes.getClassArray("rollbackFor")) {
                rollbackRules.add(new RollbackRuleAttribute(rbRule));
            }
            for (String rbRule : attributes.getStringArray("rollbackForClassName")) {
                rollbackRules.add(new RollbackRuleAttribute(rbRule));
            }
            for (Class<?> rbRule : attributes.getClassArray("noRollbackFor")) {
                rollbackRules.add(new NoRollbackRuleAttribute(rbRule));
            }
            for (String rbRule : attributes.getStringArray("noRollbackForClassName")) {
                rollbackRules.add(new NoRollbackRuleAttribute(rbRule));
            }
            rbta.setRollbackRules(rollbackRules);
    
            return rbta;
        }
###TransactionInterceptor支撑整个事务的架构
org.springframework.transaction.interceptor.TransactionInterceptor       