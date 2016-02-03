package blog.wl.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CommonInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);  

    /* 
     * ��������ӳ�䵽��Ҫ���ص�·��     
      
    private String mappingURL; 
     
    public void setMappingURL(String mappingURL) {     
               this.mappingURL = mappingURL;     
    }    
  */  
    /**  
     * ��ҵ��������������֮ǰ������  
     * �������false  
     *     �ӵ�ǰ������������ִ��������������afterCompletion(),���˳��������� 
     * �������true  
     *    ִ����һ��������,ֱ�����е���������ִ�����  
     *    ��ִ�б����ص�Controller  
     *    Ȼ�������������,  
     *    �����һ������������ִ�����е�postHandle()  
     *    �����ٴ����һ������������ִ�����е�afterCompletion()  
     */    
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
        if ("GET".equalsIgnoreCase(request.getMethod())) {  
           // RequestUtil.saveRequest();  
        }  
        log.info("==============ִ��˳��: 1��preHandle================");    
        String requestUri = request.getRequestURI();  
        String contextPath = request.getContextPath();  
       // String url = requestUri.substring(contextPath.length()); 
        String url = request.getServletPath().toString();
        
        log.info("requestUri:"+requestUri);    
        log.info("contextPath:"+contextPath);    
        log.info("url:"+url);    
          
        Object username =  request.getSession().getAttribute("loginUser");   
        if(username == null){  
            log.info("Interceptor����ת��loginҳ�棡"); 
            response.sendRedirect(contextPath+"/login");
           // request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            //request.getRequestDispatcher("/login").forward(request, response);

/*           System.out.println(request.getRequestURI());
            System.out.println(request.getContextPath());
            System.out.println(requestUri.substring(contextPath.length()));
            System.out.println((String)request.getSession().getAttribute("loginUser"));*/
            return false;  
        }else  
            return true;     
    }    
    
    /** 
     * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���    
     * ����modelAndView�м������ݣ����統ǰʱ�� 
     */  
    @Override    
    public void postHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {     
        log.info("==============ִ��˳��: 2��postHandle================");    
        if(modelAndView != null){  //���뵱ǰʱ��    
            modelAndView.addObject("var", "����postHandle");    
        }    
    }    
    
    /**  
     * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��   
     *   
     * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()  
     */    
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {    
        log.info("==============ִ��˳��: 3��afterCompletion================");    
    }    
}
