/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-04-01 06:44:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views._3_005fCustomAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jstl_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Custom Action Tag(JSTL)</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>JSTL이란?</h1>\r\n");
      out.write("	<ul>\r\n");
      out.write("		<li>JSP Standard Tag Library의 약자로 JSP에서 사용되는 커스텀 액션태그</li>\r\n");
      out.write("		<li>공통적으로 자주 사용되는 코드를 집합하여 좀 더 쉽게 사용할 수 있도록 태그화한 표준 제공 라이브러리</li>\r\n");
      out.write("	</ul>\r\n");
      out.write("	<h3>* 라이브러리 다운로드 및 추가</h3>\r\n");
      out.write("	<ol>\r\n");
      out.write("		<li><a href=\"https://tomcat.apache.org/download-taglibs.cgi\" target=\"_blank\">아파치 톰캣</a>사이트 접속</li>\r\n");
      out.write("		<li>Taglibs 메뉴 접속</li>\r\n");
      out.write("		<li>4가지 라이브러리 (jar) 다운로드</li>\r\n");
      out.write("		<li>WEB-INF/lib/ 폴더에 추가</li>\r\n");
      out.write("	</ol>\r\n");
      out.write("	<br>\r\n");
      out.write("	<h3>* JSTL 선언 방법</h3>\r\n");
      out.write("	<p>\r\n");
      out.write("		JSTL을 사용하고자 하는 JSP 페이지 상단에<br>\r\n");
      out.write("		taglib 지시어를 사용하여 선언.<br>\r\n");
      out.write("		&lt;%@ taglib prefix=\"별칭\" uri=\"라이브러리 파일상의 uri주소\"  %&gt;\r\n");
      out.write("	</p>\r\n");
      out.write("	<h4>1) JSTL Core Library</h4>\r\n");
      out.write("	<p>\r\n");
      out.write("		변수, 조건문, 반복문 등의 로직과 관련된 문법을 제공\r\n");
      out.write("	</p>\r\n");
      out.write("	<a href=\"01_core.jsp\">Core Library</a>\r\n");
      out.write("	<br>\r\n");
      out.write("	<h4>2) JSTL Formatting Library</h4>\r\n");
      out.write("	<p>\r\n");
      out.write("		숫자, 날짜 및 시간 데이터의 출력 형식을 지정할 때 사용하는 문법 제공\r\n");
      out.write("	</p>\r\n");
      out.write("	<a href=\"02_fmt.jsp\">fmt library</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}