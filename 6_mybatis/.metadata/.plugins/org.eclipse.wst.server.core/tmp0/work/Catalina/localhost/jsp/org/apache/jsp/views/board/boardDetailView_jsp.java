/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-04-02 09:17:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.*;
import com.kh.member.model.vo.Member;

public final class boardDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/workspace/5_JSP/jstlProject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1711943105495L));
    _jspx_dependants.put("/views/board/../common/menubar.jsp", Long.valueOf(1712021233942L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.kh.board.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("com.kh.board.model.vo.Board");
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("\r\n");

Board b = (Board)request.getAttribute("board");
Attachment a = (Attachment)request.getAttribute("attachment");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>JSP Project</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer { background-color: black; color: white;\r\n");
      out.write("			width: 1000px; height: 800px; margin: auto; margin-top: 50px;\r\n");
      out.write("		}\r\n");
      out.write("	.outer table {\r\n");
      out.write("		border: 1px solid white;\r\n");
      out.write("		border-collapse: collapse;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.outer > table tr, .outer > table td {\r\n");
      out.write("		border: 1px solid white; \r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");

String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>JSP Project</title>\r\n");
      out.write("<style>\r\n");
      out.write(".login-area>* {\r\n");
      out.write("	float: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-area a {\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".nav-area {\r\n");
      out.write("	background: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu {\r\n");
      out.write("	display: table-cell; /* table의 cell 형식처럼 바꿔주는 속성. */\r\n");
      out.write("	width: 150px;\r\n");
      out.write("	height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu a {\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	color: white;\r\n");
      out.write("	font-size: 20px;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	display: block;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	line-height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menu a:hover, .login-user a:hover {\r\n");
      out.write("	background: darkgrey;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.1.min.js\"\r\n");
      out.write("	integrity=\"sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("</script>\r\n");
      out.write("<!-- bootstrap CSS -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<!-- bootstrap JS -->\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("	integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<h1 align=\"center\">Welcome Jaeyoon World</h1>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"login-area\">\r\n");
      out.write("		<!-- 1) 로그인 전-->\r\n");
      out.write("		");
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      boolean _jspx_th_c_005fchoose_005f0_reused = false;
      try {
        _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fchoose_005f0.setParent(null);
        int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
        if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("			");
            //  c:when
            org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
            boolean _jspx_th_c_005fwhen_005f0_reused = false;
            try {
              _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
              _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
              // /views/board/../common/menubar.jsp(80,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser == null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
              int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
              if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("				<form action=\"");
                  out.print(contextPath);
                  out.write("/login.me\" method=\"POST\">\r\n");
                  out.write("					<table>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th>아이디</th>\r\n");
                  out.write("							<td><input type=\"text\" name=\"userId\" required /></td>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th>비밀번호</th>\r\n");
                  out.write("							<td><input type=\"password\" name=\"userPwd\" required></td>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("						<tr>\r\n");
                  out.write("							<th colspan=\"2\">\r\n");
                  out.write("								<button type=\"submit\">로그인</button>\r\n");
                  out.write("								<button type=\"button\" onclick=\"enrollPage()\">회원가입</button>\r\n");
                  out.write("							</th>\r\n");
                  out.write("						</tr>\r\n");
                  out.write("					</table>\r\n");
                  out.write("					<script>\r\n");
                  out.write("            	function enrollPage() {\r\n");
                  out.write("            		// 회원가입 페이지를 요청\r\n");
                  out.write("            		//  location.href = \"");
                  out.print(contextPath);
                  out.write("/views/member/memberEnrollForm.jsp\"; \r\n");
                  out.write("            		// 디렉토리 구조가 url에 그대로 노출 => 보안에 취약\r\n");
                  out.write("            		\r\n");
                  out.write("            		// 단순한 페이지 요청도 서블릿을 통해 처리될 수 있도록 하자.\r\n");
                  out.write("            		location.href = \"");
                  out.print(contextPath);
                  out.write("/enrollForm.me\";\r\n");
                  out.write("            	}\r\n");
                  out.write("            </script>\r\n");
                  out.write("				</form>\r\n");
                  out.write("			");
                  int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
              _jspx_th_c_005fwhen_005f0_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
            }
            out.write("\r\n");
            out.write("			");
            //  c:otherwise
            org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
            boolean _jspx_th_c_005fotherwise_005f0_reused = false;
            try {
              _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
              _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
              int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
              if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("				<!-- 2) 로그인 후-->\r\n");
                  out.write("				<div class=\"login-user\">\r\n");
                  out.write("					<b>");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
                  out.write("</b>님의 방문을 환영합니다. <br>\r\n");
                  out.write("					<br>\r\n");
                  out.write("					<div align=\"center\">\r\n");
                  out.write("						<a href=\"");
                  out.print(contextPath);
                  out.write("/myPage.me\">마이페이지</a> <a\r\n");
                  out.write("							href=\"");
                  out.print(contextPath);
                  out.write("/logout.me\">로그아웃</a>\r\n");
                  out.write("					</div>\r\n");
                  out.write("				</div>\r\n");
                  out.write("			");
                  int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
              _jspx_th_c_005fotherwise_005f0_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
            }
            out.write("\r\n");
            out.write("		");
            int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
        _jspx_th_c_005fchoose_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
      }
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- clear : float 스타일 속성의 영향을 받지 않도록 처리 / both: 왼쪽 오른쪽 둘 다 영향 받지 않도록-->\r\n");
      out.write("	<br clear=\"both\">\r\n");
      out.write("	<br>\r\n");
      out.write("	<div class=\"nav-area\" align=\"center\">\r\n");
      out.write("		<div class=\"menu\">\r\n");
      out.write("			<a href=\"");
      out.print(contextPath);
      out.write("\">Home</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"menu\">\r\n");
      out.write("			<a href=\"");
      out.print(contextPath);
      out.write("/list.no\">공지사항</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"menu\">\r\n");
      out.write("			<a href=\"");
      out.print(contextPath);
      out.write("/list.bo?cpage=1\">일반게시판</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"menu\">\r\n");
      out.write("			<a href=\"\">사진게시판</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"outer\" align=\"center\">\r\n");
      out.write("		<br>\r\n");
      out.write("		<h2 align=\"center\">일반게시글 상세보기</h2>\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<table>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>카테고리</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.categoryNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("				<th>제목</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardTitle }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>작성자</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardWriter }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("				<th>작성일</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.createDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>내용</th>\r\n");
      out.write("				<td colspan=\"3\">\r\n");
      out.write("					<p style=\"height: 200px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardContent }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>첨부파일</th>\r\n");
      out.write("				<td colspan=\"3\">\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("					");
      out.write(' ');
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      boolean _jspx_th_c_005fchoose_005f1_reused = false;
      try {
        _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fchoose_005f1.setParent(null);
        int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
        if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("					");
            if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("					");
            //  c:otherwise
            org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
            boolean _jspx_th_c_005fotherwise_005f1_reused = false;
            try {
              _jspx_th_c_005fotherwise_005f1.setPageContext(_jspx_page_context);
              _jspx_th_c_005fotherwise_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
              int _jspx_eval_c_005fotherwise_005f1 = _jspx_th_c_005fotherwise_005f1.doStartTag();
              if (_jspx_eval_c_005fotherwise_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("					");
                  out.write("\r\n");
                  out.write("					<a download href=\"");
                  out.print(contextPath );
                  out.write('/');
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachment.filePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachment.changeName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
                  out.write('"');
                  out.write('>');
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachment.originName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
                  out.write("</a>\r\n");
                  out.write("					");
                  out.write("\r\n");
                  out.write("					");
                  int evalDoAfterBody = _jspx_th_c_005fotherwise_005f1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fotherwise_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
              _jspx_th_c_005fotherwise_005f1_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f1_reused);
            }
            out.write("\r\n");
            out.write("					");
            int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
        _jspx_th_c_005fchoose_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f1_reused);
      }
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<br><br>\r\n");
      out.write("		<div align=\"center\">\r\n");
      out.write("			<a href=\"javascript:window.history.back();\" class=\"btn btn-info\">목록으로 돌아가기</a>\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("			");
      out.write(' ');
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      boolean _jspx_th_c_005fif_005f1_reused = false;
      try {
        _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fif_005f1.setParent(null);
        // /views/board/boardDetailView.jsp(76,89) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser != null and loginUser.userId eq board.boardWriter }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
        int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
        if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("				<a href=\"");
            out.print( contextPath );
            out.write("/updateForm.bo?bno=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn btn-warning\">수정하기</a>\r\n");
            out.write("				<a href=\"");
            out.print( contextPath );
            out.write("/delete.bo?bno=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.boardNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("&attach=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachment}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn btn-danger\">삭제하기</a>\r\n");
            out.write("			");
            int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
        _jspx_th_c_005fif_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
      }
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<br>\r\n");
      out.write("		<div id=\"reply-area\">\r\n");
      out.write("			<table border=\"1\" align=\"center\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>댓글작성</th>\r\n");
      out.write("						<td>\r\n");
      out.write("							<textarea rows=\"3\" cols=\"50\" style=\"resize:none;\"></textarea>\r\n");
      out.write("						</td>\r\n");
      out.write("						<td>\r\n");
      out.write("							<button>댓글 등록</button>\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>");
      out.write("{$ loginUser.userId}</td>\r\n");
      out.write("						<td>@@댓글내용@@</td>\r\n");
      out.write("						<td>@@작성일@@</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			<script>\r\n");
      out.write("				$(function(){\r\n");
      out.write("					// 페이지가 로드되었을 때 아래 함수 호출\r\n");
      out.write("					selectReplyList();\r\n");
      out.write("				});\r\n");
      out.write("				\r\n");
      out.write("				function selectReplyList() {\r\n");
      out.write("					// rlist.do 로 요청하여 결과를 댓글 목록에 표시\r\n");
      out.write("					//  - 전달 데이터 => boardNo\r\n");
      out.write("				}\r\n");
      out.write("			</script>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /views/board/../common/menubar.jsp(65,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alertMsg != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("		<script>\r\n");
          out.write("			alert(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${alertMsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\")\r\n");
          out.write("		</script>\r\n");
          out.write("		");
          if (_jspx_meth_c_005fremove_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write('\r');
          out.write('\n');
          out.write('	');
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    boolean _jspx_th_c_005fremove_005f0_reused = false;
    try {
      _jspx_th_c_005fremove_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fremove_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /views/board/../common/menubar.jsp(69,2) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setVar("alertMsg");
      // /views/board/../common/menubar.jsp(69,2) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setScope("session");
      int _jspx_eval_c_005fremove_005f0 = _jspx_th_c_005fremove_005f0.doStartTag();
      if (_jspx_th_c_005fremove_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
      _jspx_th_c_005fremove_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fremove_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fremove_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f1_reused = false;
    try {
      _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
      // /views/board/boardDetailView.jsp(59,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachment == null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
      if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					첨부파일이 없습니다.\r\n");
          out.write("					");
          out.write("\r\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      _jspx_th_c_005fwhen_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f1_reused);
    }
    return false;
  }
}
