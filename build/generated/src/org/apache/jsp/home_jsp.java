package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/tag_library.tld");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("  <!-- Meta -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <meta name=\"keywords\" content=\"MediaCenter, Template, eCommerce\">\n");
      out.write("    <meta name=\"robots\" content=\"all\">\n");
      out.write("    <title>Hexino premium HTML5 & CSS3 Template</title>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "styles.jsp", out, false);
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body class=\"cnt-home\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"body-content outer-top-xs\">\n");
      out.write("      <div class=\"breadcrumb\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"breadcrumb-inner\">\n");
      out.write("      <ul class=\"list-inline list-unstyled\">\n");
      out.write("        <li class='active'><a href=\"#\">Home</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div><!-- /.breadcrumb-inner -->\n");
      out.write("  </div><!-- /.container -->\n");
      out.write("</div><!-- /.breadcrumb -->\n");
      out.write("<div class=\"body-content outer-top-xs\">\n");
      out.write("  <div class='container'>\n");
      out.write("    <div class='row'>\n");
      out.write("      <div class='col-md-3 sidebar'>\n");
      out.write("       <div class=\"sidebar-module-container\">\n");
      out.write("                \n");
      out.write("                <div class=\"sidebar-filter\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                  <!-- ============================================== PRICE SILDER============================================== -->\n");
      out.write("<div class=\"sidebar-widget wow fadeInUp\">\n");
      out.write("  <div class=\"widget-header\">\n");
      out.write("    <h4 class=\"widget-title\">Price Slider</h4>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"sidebar-widget-body m-t-10\">\n");
      out.write("    <div class=\"price-range-holder\">\n");
      out.write("            <span class=\"min-max\">\n");
      out.write("                 <span class=\"pull-left\">$200.00</span>\n");
      out.write("                 <span class=\"pull-right\">$800.00</span>\n");
      out.write("            </span>\n");
      out.write("            <input type=\"text\" id=\"amount\" style=\"border:0; color:#666666; font-weight:bold;text-align:center;\">\n");
      out.write("\n");
      out.write("            <input type=\"text\" class=\"price-slider\" value=\"\" >\n");
      out.write("   \n");
      out.write("        </div><!-- /.price-range-holder -->\n");
      out.write("        <a href=\"#\" class=\"lnk btn btn-primary\">Show Now</a>\n");
      out.write("  </div><!-- /.sidebar-widget-body -->\n");
      out.write("</div><!-- /.sidebar-widget -->\n");
      out.write("<!-- ============================================== PRICE SILDER : END ============================================== -->\n");
      out.write("\n");
      out.write("                  <!-- ============================================== PRODUCT TAGS ============================================== -->\n");
      out.write("<div class=\"sidebar-widget product-tag wow fadeInUp outer-top-vs\">\n");
      out.write("  <h3 class=\"section-title\">Product tags</h3>\n");
      out.write("  <div class=\"sidebar-widget-body outer-top-xs\">\n");
      out.write("    <div class=\"tag-list\">          \n");
      out.write("      <a class=\"item\" title=\"Phone\" href=\"category.html\">Phone</a>\n");
      out.write("      <a class=\"item active\" title=\"Vest\" href=\"category.html\">Vest</a>\n");
      out.write("      <a class=\"item\" title=\"Smartphone\" href=\"category.html\">Smartphone</a>\n");
      out.write("      <a class=\"item\" title=\"Furniture\" href=\"category.html\">Furniture</a>\n");
      out.write("      <a class=\"item\" title=\"T-shirt\" href=\"category.html\">T-shirt</a>\n");
      out.write("      <a class=\"item\" title=\"Sweatpants\" href=\"category.html\">Sweatpants</a>\n");
      out.write("      <a class=\"item\" title=\"Sneaker\" href=\"category.html\">Sneaker</a>\n");
      out.write("      <a class=\"item\" title=\"Toys\" href=\"category.html\">Toys</a>\n");
      out.write("      <a class=\"item\" title=\"Rose\" href=\"category.html\">Rose</a>\n");
      out.write("    </div><!-- /.tag-list -->\n");
      out.write("  </div><!-- /.sidebar-widget-body -->\n");
      out.write("</div><!-- /.sidebar-widget -->\n");
      out.write("<!-- ============================================== PRODUCT TAGS : END ============================================== -->  \n");
      out.write("\n");
      out.write("<div class=\"home-banner\">\n");
      out.write("<img src=\"assets/images/banners/LHS-banner.jpg\" alt=\"Image\">\n");
      out.write("</div> \n");
      out.write("\n");
      out.write("                </div><!-- /.sidebar-filter -->\n");
      out.write("              </div><!-- /.sidebar-module-container -->\n");
      out.write("            </div><!-- /.sidebar -->\n");
      out.write("      <div class='col-md-9'>\n");
      out.write("\n");
      out.write("        <div class=\"clearfix filters-container m-t-10\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col col-sm-6 col-md-2\">\n");
      out.write("      <div class=\"filter-tabs\">\n");
      out.write("        <ul id=\"filter-tabs\" class=\"nav nav-tabs nav-tab-box nav-tab-fa-icon\">\n");
      out.write("\n");
      out.write("          <li  class=\"active\"><a data-toggle=\"tab\" href=\"#list-container\"><i class=\"icon fa fa-th-list\"></i>List</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div><!-- /.filter-tabs -->\n");
      out.write("    </div><!-- /.col -->\n");
      out.write("    <div class=\"col col-sm-12 col-md-6\">\n");
      out.write("      <div class=\"col col-sm-3 col-md-6 no-padding\">\n");
      out.write("        \n");
      out.write("      </div><!-- /.col -->\n");
      out.write("      <div class=\"col col-sm-3 col-md-6 no-padding\">\n");
      out.write("\n");
      out.write("      </div><!-- /.col -->\n");
      out.write("    </div><!-- /.col -->\n");
      out.write("    <div class=\"col col-sm-6 col-md-4 text-right\">\n");
      out.write("      <div class=\"pagination-container\">\n");
      out.write("  <ul class=\"list-inline list-unstyled\">\n");
      out.write("    <li class=\"prev\"><a href=\"#\"><i class=\"fa fa-angle-left\"></i></a></li>\n");
      out.write("    <li><a href=\"#\">1</a></li>  \n");
      out.write("    <li class=\"active\"><a href=\"#\">2</a></li> \n");
      out.write("    <li><a href=\"#\">3</a></li>  \n");
      out.write("    <li><a href=\"#\">4</a></li>  \n");
      out.write("    <li class=\"next\"><a href=\"#\"><i class=\"fa fa-angle-right\"></i></a></li>\n");
      out.write("  </ul><!-- /.list-inline -->\n");
      out.write("</div><!-- /.pagination-container -->   </div><!-- /.col -->\n");
      out.write("  </div><!-- /.row -->\n");
      out.write("</div>\n");
      out.write("        <div class=\"search-result-container \">\n");
      out.write("          <div id=\"myTabContent\" class=\"tab-content category-list\">\n");
      out.write("            \n");
      out.write("              \n");
      out.write("            <div class=\"tab-pane active\"  id=\"list-container\">\n");
      out.write("              <div class=\"category-product\">\n");
      out.write("              \n");
      out.write("                  ");
      if (_jspx_meth_amine_listFormation_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                 \n");
      out.write("              \n");
      out.write("              </div><!-- /.category-product -->\n");
      out.write("            </div><!-- /.tab-pane #list-container -->\n");
      out.write("          </div><!-- /.tab-content -->\n");
      out.write("          <div class=\"clearfix filters-container\">\n");
      out.write("            \n");
      out.write("              <div class=\"text-right\">\n");
      out.write("                     <div class=\"pagination-container\">\n");
      out.write("  <ul class=\"list-inline list-unstyled\">\n");
      out.write("    <li class=\"prev\"><a href=\"#\"><i class=\"fa fa-angle-left\"></i></a></li>\n");
      out.write("    <li><a href=\"#\">1</a></li>  \n");
      out.write("    <li class=\"active\"><a href=\"#\">2</a></li> \n");
      out.write("    <li><a href=\"#\">3</a></li>  \n");
      out.write("    <li><a href=\"#\">4</a></li>  \n");
      out.write("    <li class=\"next\"><a href=\"#\"><i class=\"fa fa-angle-right\"></i></a></li>\n");
      out.write("  </ul><!-- /.list-inline -->\n");
      out.write("</div><!-- /.pagination-container -->               </div><!-- /.text-right -->\n");
      out.write("            \n");
      out.write("          </div><!-- /.filters-container -->\n");
      out.write("\n");
      out.write("        </div><!-- /.search-result-container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      </div><!-- /.col -->\n");
      out.write("    </div><!-- /.row -->\n");
      out.write("  </div><!-- /.container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div><!-- /.body-content -->\n");
      out.write("          \n");
      out.write("   \n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "scripts.jsp", out, false);
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_amine_listFormation_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  amine:listFormation
    handlers.listFormation _jspx_th_amine_listFormation_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(handlers.listFormation.class) : new handlers.listFormation();
    _jspx_th_amine_listFormation_0.setJspContext(_jspx_page_context);
    _jspx_th_amine_listFormation_0.setFilter(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filter}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_amine_listFormation_0.doTag();
    return false;
  }
}
