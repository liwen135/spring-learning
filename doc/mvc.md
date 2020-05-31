###DispatcherServlet
org.springframework.web.servlet.DispatcherServlet
DispatcherServlet 的父类org.springframework.web.servlet.HttpServletBean 重写了org.springframework.web.servlet.HttpServletBean.init方法
  增加// Let subclasses do whatever initialization they like.
    		initServletBean(); 在FrameworkServlet实现
   org.springframework.web.servlet.FrameworkServlet.initServletBean
   //初始化了webApplicationContext,启动
    this.webApplicationContext = initWebApplicationContext();
    			initFrameworkServlet(); 	
  //对initParam参数封装 
   org.springframework.web.servlet.HttpServletBean.ServletConfigPropertyValues.ServletConfigPropertyValues 
   
   
   	/**
   	 * This implementation calls {@link #initStrategies}.
   	 */
   	@Override
   	protected void onRefresh(ApplicationContext context) {
   		initStrategies(context);
   	}
   
   	/**
   	 * Initialize the strategy objects that this servlet uses.
   	 * <p>May be overridden in subclasses in order to initialize further strategy objects.
   	 */
   	protected void initStrategies(ApplicationContext context) {
   	    //文件上传下载
   		initMultipartResolver(context);
   		//国际化
   		initLocaleResolver(context);
   		//主题
   		initThemeResolver(context);
   		initHandlerMappings(context);
   		initHandlerAdapters(context);
   		//异常
   		initHandlerExceptionResolvers(context);
   		initRequestToViewNameTranslator(context);
   		initViewResolvers(context);
   		initFlashMapManager(context);
   	}	
   	
   	
   	# Default implementation classes for DispatcherServlet's strategy interfaces.
    # Used as fallback when no matching beans are found in the DispatcherServlet context.
    # Not meant to be customized by application developers.
    
    org.springframework.web.servlet.LocaleResolver=org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
    
    org.springframework.web.servlet.ThemeResolver=org.springframework.web.servlet.theme.FixedThemeResolver
    
    org.springframework.web.servlet.HandlerMapping=org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,\
    	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping,\
    	org.springframework.web.servlet.function.support.RouterFunctionMapping
    
    org.springframework.web.servlet.HandlerAdapter=org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter,\
    	org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter,\
    	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter,\
    	org.springframework.web.servlet.function.support.HandlerFunctionAdapter
    
    
    org.springframework.web.servlet.HandlerExceptionResolver=org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver,\
    	org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver,\
    	org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver
    
    org.springframework.web.servlet.RequestToViewNameTranslator=org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator
    
    org.springframework.web.servlet.ViewResolver=org.springframework.web.servlet.view.InternalResourceViewResolver
    
    org.springframework.web.servlet.FlashMapManager=org.springframework.web.servlet.support.SessionFlashMapManager		
    
###org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter    
http请求处理适配器，仅仅支持对http请求处理器的适配，
###org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter	

FrameworkServlet 下的doGet和doPost都执行了org.springframework.web.servlet.FrameworkServlet.processRequest
调用了org.springframework.web.servlet.DispatcherServlet.doService
org.springframework.web.servlet.DispatcherServlet.doDispatch

###org.springframework.web.servlet.HandlerExecutionChain

org.springframework.web.servlet.handler.AbstractUrlHandlerMapping.getHandlerInternal
org.springframework.web.servlet.handler.AbstractUrlHandlerMapping.lookupHandler
org.springframework.web.servlet.handler.AbstractUrlHandlerMapping.buildPathExposingHandler
org.springframework.web.servlet.handler.AbstractHandlerMapping.getHandlerExecutionChain