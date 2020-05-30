org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance
//如果工厂方法不为空则使用工厂方法初始化
	if (mbd.getFactoryMethodName() != null) {
			return instantiateUsingFactoryMethod(beanName, mbd, args);
		}
		
	if (resolved) {
	    
        if (autowireNecessary) {
        //构造函数指定注入
            return autowireConstructor(beanName, mbd, null, null);
        }
        else {
        //默认构造函数
            return instantiateBean(beanName, mbd);
        }
    }	
    
    	// 根据参数解析构造函数
    		Constructor<?>[] ctors = determineConstructorsFromBeanPostProcessors(beanClass, beanName);
    		
    //排序给定的构造函数，public 构造函数优先参数数量降序，非public构造函数参数数量降序		
    AutowireUtils.sortConstructors(candidates);