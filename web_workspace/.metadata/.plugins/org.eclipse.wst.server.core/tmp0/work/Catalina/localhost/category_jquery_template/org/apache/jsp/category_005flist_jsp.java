/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-04-21 09:15:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class category_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table, td{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("table{\r\n");
      out.write("\twidth:700px;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("td{\r\n");
      out.write("\tpadding: 5px; /* 안쪽 여백 너비 */\r\n");
      out.write("}\r\n");
      out.write("select{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("}\r\n");
      out.write("#product_info_layer{\r\n");
      out.write("\twidth:700px;\r\n");
      out.write("\tborder: 1px solid gray;\r\n");
      out.write("\tpadding:5px;/* 안쪽 여백 너비 */\r\n");
      out.write("\tdisplay: none;/*최초로딩시에는 안보이도록 처리*/\r\n");
      out.write("}\r\n");
      out.write("#tbody{\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/category_jquery_template/script/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#first_category\").on(\"change\", function() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/category_jquery_template/controller\",\r\n");
      out.write("\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\tdata:\"command=second_category&firstCategoryId=\" + $(this).val(),\r\n");
      out.write("\t\t\t\tdataType:\"JSON\",\r\n");
      out.write("\t\t\t\tbeforeSend:function() {\r\n");
      out.write("\t\t\t\t\tif ($(\"#first_category option\").index($(\"#first_category option:selected\"))==0) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#second_category\").empty().append(\"<option value='default'>중분류</option>\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#third_category\").empty().append(\"<option value='default'>소분류</option>\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:errorCallback,\r\n");
      out.write("\t\t\t\tsuccess:function(obj) {\r\n");
      out.write("\t\t\t\t\t$(\"#second_category\").empty().append(\"<option value='default'>중분류</option>\");\r\n");
      out.write("\t\t\t\t\t$(\"#third_category\").empty().append(\"<option value='default'>소분류</option>\");\r\n");
      out.write("\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\tfor (var idx = 0; idx < obj.length; idx++) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#second_category\").append(\"<option value='\"+ obj[idx].categoryId + \"'>\" + obj[idx].categoryName + \"</option>\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#second_category\").on(\"change\", function() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/category_jquery_template/controller\",\r\n");
      out.write("\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\tdata:\"command=third_category&secondCategoryId=\" + $(this).val(),\r\n");
      out.write("\t\t\t\tdataType:\"JSON\",\r\n");
      out.write("\t\t\t\tbeforeSend:function() {\r\n");
      out.write("\t\t\t\t\tif ($(\"#second_category option\").index($(\"#second_category option:selected\"))==0) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#third_category\").empty().append(\"<option value='default'>소분류</option>\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:errorCallback,\r\n");
      out.write("\t\t\t\tsuccess:function(obj) {\r\n");
      out.write("\t\t\t\t\t$(\"#third_category\").empty().append(\"<option value='default'>소분류</option>\");\r\n");
      out.write("\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\tfor (var idx = 0; idx < obj.length; idx++) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#third_category\").append(\"<option value='\"+ obj[idx].categoryId + \"'>\" + obj[idx].categoryName + \"</option>\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#third_category\").on(\"change\", function() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/category_jquery_template/controller\",\r\n");
      out.write("\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\tdata:\"command=get_product_list&thirdCategoryId=\" + $(this).val(),\r\n");
      out.write("\t\t\t\tdataType:\"JSON\",\r\n");
      out.write("\t\t\t\tbeforeSend:function() {\r\n");
      out.write("\t\t\t\t\tif ($(\"#third_category option\").index($(\"#third_category option:selected\"))==0) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:errorCallback,\r\n");
      out.write("\t\t\t\tsuccess:function(obj) {\r\n");
      out.write("\t\t\t\t\t$(\"#thead\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#tbody\").empty();\r\n");
      out.write("\t\t\t\t\t$(\"#product_info_layer\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#thead\").append(\"<tr><td>제품ID</td><td>제품명</td><td>제조사</td><td>제품가격</td></tr>\");\r\n");
      out.write("\t\t\t\t\tfor (var idx = 0; idx < obj.length; idx++) {\r\n");
      out.write("\t\t\t\t\t\t$(\"#tbody\").append(\"<tr id='item'><td>\"+ obj[idx].productId + \"</td><td>\"+ obj[idx].productName + \"</td><td>\"+ obj[idx].productMaker + \"</td><td>\"+ obj[idx].productPrice + \"</td></tr>\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#tbody\").on(\"click\", \"#item\", function() {\r\n");
      out.write("\t\t\t$(\"#tbody tr\").css(\"background-color\", \"white\");\r\n");
      out.write("\t\t\t$(this).css(\"background-color\", \"orange\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/category_jquery_template/controller\",\r\n");
      out.write("\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\tdata:\"command=get_product_info&productId=\" + $(this).children().html(),\r\n");
      out.write("\t\t\t\tdataType:\"JSON\",\r\n");
      out.write("\t\t\t\terror:errorCallback,\r\n");
      out.write("\t\t\t\tsuccess:function(obj) {\r\n");
      out.write("\t\t\t\t\t$(\"#product_info_layer\").html(obj.productInfo).show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction errorCallback() {\r\n");
      out.write("\t\talert(\"error\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("대분류 : \r\n");
      out.write("<select name=\"first_category\" id=\"first_category\">\r\n");
      out.write("\t<option value='default'>대분류</option>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("중분류 : \r\n");
      out.write("<select id=\"second_category\">\r\n");
      out.write("\t<option value='default'>중분류</option>\r\n");
      out.write("</select>\r\n");
      out.write("소분류 : \r\n");
      out.write("<select id=\"third_category\">\r\n");
      out.write("\t<option value='default'>소분류</option>\r\n");
      out.write("</select>\r\n");
      out.write("<p>\r\n");
      out.write("<table>\r\n");
      out.write("\t<thead id=\"thead\"></thead>\r\n");
      out.write("\t<tbody id=\"tbody\"></tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<p>\r\n");
      out.write("<!-- 상품 상세 정보 출력할 div-->\r\n");
      out.write("<div id=\"product_info_layer\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /category_list.jsp(151,1) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/category_list.jsp(151,1) '${ firstCategory }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ firstCategory }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /category_list.jsp(151,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("category");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<option value='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.categoryId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.categoryName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
