package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sign_002din_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\t\n");
      out.write("<!-- Mirrored from themesground.com/hexino/V2/sign-in.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 18 Dec 2017 12:08:07 GMT -->\n");
      out.write("<head>\n");
      out.write("\t\t<!-- Meta -->\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">\n");
      out.write("\t\t<meta name=\"description\" content=\"\">\n");
      out.write("\t\t<meta name=\"author\" content=\"\">\n");
      out.write("\t    <meta name=\"keywords\" content=\"MediaCenter, Template, eCommerce\">\n");
      out.write("\t    <meta name=\"robots\" content=\"all\">\n");
      out.write("\n");
      out.write("\t    <title>Hexino premium HTML5 & CSS3 Template</title>\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "styles.jsp", out, false);
      out.write("\n");
      out.write("\t</head>\n");
      out.write("    <body class=\"cnt-home\">\n");
      out.write("\t\t<!-- ============================================== HEADER ============================================== -->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<!-- ============================================== HEADER : END ============================================== -->\n");
      out.write("<div class=\"breadcrumb\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"breadcrumb-inner\">\n");
      out.write("\t\t\t<ul class=\"list-inline list-unstyled\">\n");
      out.write("\t\t\t\t<li><a href=\"home.html\">Home</a></li>\n");
      out.write("\t\t\t\t<li class='active'>Login</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div><!-- /.breadcrumb-inner -->\n");
      out.write("\t</div><!-- /.container -->\n");
      out.write("</div><!-- /.breadcrumb -->\n");
      out.write("\n");
      out.write("<div class=\"body-content\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"sign-in-page\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<!-- Sign-in -->\t\t\t\n");
      out.write("<div class=\"col-md-6 col-sm-6 sign-in\">\n");
      out.write("\t<h4 class=\"\">Sign in</h4>\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\t<p class=\"\">Hello, Welcome to your account.</p>\n");
      out.write("\t<div class=\"social-sign-in outer-top-xs\">\n");
      out.write("\t\t<a href=\"#\" class=\"facebook-sign-in\"><i class=\"fa fa-facebook\"></i> Sign In with Facebook</a>\n");
      out.write("\t\t<a href=\"#\" class=\"twitter-sign-in\"><i class=\"fa fa-twitter\"></i> Sign In with Twitter</a>\n");
      out.write("\t</div>\n");
      out.write("        <form class=\"register-form outer-top-xs\" role=\"form\" method=\"POST\" action=\"/GestionFormation/login\">\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputEmail1\">Email Address <span>*</span></label>\n");
      out.write("\t\t    <input type=\"email\" name=\"usr\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail1\" >\n");
      out.write("\t\t</div>\n");
      out.write("\t  \t<div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputPassword1\">Password <span>*</span></label>\n");
      out.write("\t\t    <input type=\"password\" name=\"pass\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputPassword1\" >\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"radio outer-xs\">\n");
      out.write("\t\t  \t<label> \n");
      out.write("\t\t    \t<input type=\"checkbox\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"option2\">Remember me!\n");
      out.write("\t\t  \t</label>\n");
      out.write("\t\t  \t<a href=\"#\" class=\"forgot-password pull-right spacer\">  Forgot your Password?</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t  \t<input type=\"submit\" class=\"btn-upper btn btn-primary checkout-page-button btn-block\" value=\"Login\">\n");
      out.write("\t</form>\t\t\t\t\t\n");
      out.write("</div>\n");
      out.write("<!-- Sign-in -->\n");
      out.write("\n");
      out.write("<!-- create a new account -->\n");
      out.write("<div class=\"col-md-6 col-sm-6 create-new-account\">\n");
      out.write("\t<h4 class=\"checkout-subtitle\">Create a new account</h4>\n");
      out.write("\t<p class=\"text title-tag-line\">Create your new account.</p>\n");
      out.write("\t<form class=\"register-form outer-top-xs\" role=\"form\">\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t    \t<label class=\"info-title\" for=\"exampleInputEmail2\">Email Address <span>*</span></label>\n");
      out.write("\t    \t<input type=\"email\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail2\" >\n");
      out.write("\t  \t</div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputEmail1\">Name <span>*</span></label>\n");
      out.write("\t\t    <input type=\"email\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail1\" >\n");
      out.write("\t\t</div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputEmail1\">Phone Number <span>*</span></label>\n");
      out.write("\t\t    <input type=\"email\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail1\" >\n");
      out.write("\t\t</div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputEmail1\">Password <span>*</span></label>\n");
      out.write("\t\t    <input type=\"email\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail1\" >\n");
      out.write("\t\t</div>\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("\t\t    <label class=\"info-title\" for=\"exampleInputEmail1\">Confirm Password <span>*</span></label>\n");
      out.write("\t\t    <input type=\"email\" class=\"form-control unicase-form-control text-input\" id=\"exampleInputEmail1\" >\n");
      out.write("\t\t</div>\n");
      out.write("\t  \t<button type=\"submit\" class=\"btn-upper btn btn-primary checkout-page-button btn-block\">Sign Up</button>\n");
      out.write("\t</form>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("</div>\t\n");
      out.write("<!-- create a new account -->\t\t\t</div><!-- /.row -->\n");
      out.write("\t\t</div><!-- /.sigin-in-->\n");
      out.write("\t\t<!-- ============================================== BRANDS CAROUSEL ============================================== -->\n");
      out.write("\n");
      out.write("<!-- ============================================== BRANDS CAROUSEL : END ============================================== -->\t</div><!-- /.container -->\n");
      out.write("</div><!-- /.body-content -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scripts.jsp", out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<!-- Mirrored from themesground.com/hexino/V2/sign-in.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 18 Dec 2017 12:08:07 GMT -->\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
