package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Database.query;
import java.util.ArrayList;
import Model.cart;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            int item = 0;
            double total_price = 0.0;
            String msg = "";
        
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
      response.setContentType("text/html");
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Bootshop online Shopping cart</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <!--Less styles -->\n");
      out.write("        <!-- Other Less css file //different less files has different color scheam\n");
      out.write("             <link rel=\"stylesheet/less\" type=\"text/css\" href=\"themes/less/simplex.less\">\n");
      out.write("             <link rel=\"stylesheet/less\" type=\"text/css\" href=\"themes/less/classified.less\">\n");
      out.write("             <link rel=\"stylesheet/less\" type=\"text/css\" href=\"themes/less/amelia.less\">  MOVE DOWN TO activate\n");
      out.write("        -->\n");
      out.write("        <!--<link rel=\"stylesheet/less\" type=\"text/css\" href=\"themes/less/bootshop.less\">\n");
      out.write("        <script src=\"themes/js/less.js\" type=\"text/javascript\"></script> -->\n");
      out.write("\n");
      out.write("        <!-- Bootstrap style --> \n");
      out.write("        <link id=\"callCss\" rel=\"stylesheet\" href=\"themes/bootshop/bootstrap.min.css\" media=\"screen\"/>\n");
      out.write("        <link href=\"themes/css/base.css\" rel=\"stylesheet\" media=\"screen\"/>\n");
      out.write("        <!-- Bootstrap style responsive -->\t\n");
      out.write("        <link href=\"themes/css/bootstrap-responsive.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"themes/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- Google-code-prettify -->\t\n");
      out.write("        <link href=\"themes/js/google-code-prettify/prettify.css\" rel=\"stylesheet\"/>\n");
      out.write("        <!-- fav and touch icons -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"themes/images/ico/favicon.ico\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"themes/images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"themes/images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"themes/images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"themes/images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("        <style type=\"text/css\" id=\"enject\"></style>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

             query db = new query();
            cart c = new cart();
            ArrayList<cart> car = new ArrayList<>();
            car = c.getIdcart();
            item = 0;
            total_price = 0.0;
            for (int i = 0; i < car.size(); i++) {
                item += car.get(i).getQuantity();
                total_price += (car.get(i).getPrice() * car.get(i).getQuantity());
            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div id=\"welcomeLine\" class=\"row\">\n");
      out.write("                    <div class=\"span6\">Welcome!<strong> User</strong></div>\n");
      out.write("                    <div class=\"span6\">\n");
      out.write("                        <div class=\"pull-right\">\n");
      out.write("                            <span class=\"btn btn-mini\">$");
      out.print(total_price);
      out.write("</span>\n");
      out.write("                            <a href=\"product_summary.jsp\"><span class=\"btn btn-mini btn-primary\"><i class=\"icon-shopping-cart icon-white\"></i> [  ");
      out.print(item);
      out.write(" ] Items in your cart </span> </a> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Navbar ================================================== -->\n");
      out.write("                <div id=\"logoArea\" class=\"navbar\">\n");
      out.write("                    <a id=\"smallScreen\" data-target=\"#topMenu\" data-toggle=\"collapse\" class=\"btn btn-navbar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"navbar-inner\">\n");
      out.write("                        <a class=\"brand\" href=\"index.jsp\"><img src=\"themes/images/logo.png\" alt=\"Bootsshop\"/></a>\n");
      out.write("                        <form class=\"form-inline navbar-search\" method=\"post\" action=\"search.jsp\" >\n");
      out.write("                            <input id=\"srchFld\" class=\"srchTxt\" type=\"text\" name=\"key\" value=\"\" style=\"padding-left: 30px\"/>\n");
      out.write("                            <select class=\"srchTxt\" name=\"search\">\n");
      out.write("                                <option value=\"0\">All</option>\n");
      out.write("                                <option value=\"1\"> ELECTRONICS </option>\n");
      out.write("                                <option value=\"2\">CLOTHES </option>\n");
      out.write("                                <option value=\"3\">FOOD AND BEVERAGES </option>\n");
      out.write("                                <option value=\"4\">SPORTS & LEISURE </option>\n");
      out.write("                                <option value=\"5\">BOOKS & ENTERTAINMENTS </option>\n");
      out.write("                                <option value=\"6\">OTHERS </option>\n");
      out.write("                            </select> \n");
      out.write("                            <button type=\"submit\" id=\"submitButton\" class=\"btn btn-primary\">Go</button>\n");
      out.write("                        </form>\n");
      out.write("                        <ul id=\"topMenu\" class=\"nav pull-right\">\n");
      out.write("                            <li class=\"\"><a href=\"special_offer.jsp\">Specials Offer</a></li>\n");
      out.write("                            <li class=\"\"><a href=\"normal.jsp\">Delivery</a></li>\n");
      out.write("                            <li class=\"\"><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("                            <li class=\"\">\n");
      out.write("                                <a href=\"#login\" role=\"button\" data-toggle=\"modal\" style=\"padding-right:0\"><span class=\"btn btn-large btn-success\">Login</span></a>\n");
      out.write("                                <div id=\"login\" class=\"modal hide fade in\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"login\" aria-hidden=\"false\" >\n");
      out.write("                                    <div class=\"modal-header\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                                        <h3>Login Block</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"modal-body\">\n");
      out.write("                                        <form class=\"form-horizontal loginFrm\" action=\"login\" method=\"post\">\n");
      out.write("                                            <div class=\"control-group\">\t\t\t\t\t\t\t\t\n");
      out.write("                                                <input type=\"text\" id=\"inputEmail\" placeholder=\"Email\" name=\"user\" value=\"\" required=\"required\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"control-group\">\n");
      out.write("                                                <input type=\"password\" id=\"inputPassword\" placeholder=\"Password\" name=\"pass\" value=\"\" required=\"required\">\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"control-group\">\n");
      out.write("                                                <label class=\"checkbox\">\n");
      out.write("                                                    <input type=\"checkbox\"> Remember me\n");
      out.write("                                                </label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-success\">Sign in</button>\n");
      out.write("                                            <button class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("                                        </form>\t\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Header End====================================================================== -->\n");
      out.write("        <div id=\"mainBody\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <!-- Sidebar ================================================== -->\n");
      out.write("                    <div id=\"sidebar\" class=\"span3\">\n");
      out.write("                        <div class=\"well well-small\"><a id=\"myCart\" href=\"product_summary.jsp\"><img src=\"themes/images/ico-cart.png\" alt=\"cart\"> ");
      out.print(item);
      out.write(" Items in your cart  <span class=\"badge badge-warning pull-right\">$");
      out.print(total_price);
      out.write("</span></a></div>\n");
      out.write("                        <ul id=\"sideManu\" class=\"nav nav-tabs nav-stacked\">\n");
      out.write("\n");
      out.write("                            <li><a href=\"products.jsp?product_id=1\">ELECTRONICS [");
      out.print(db.count(1));
      out.write("]</a></li>\n");
      out.write("                            <li><a href=\"products.jsp?product_id=2\">CLOTHES [");
      out.print(db.count(2));
      out.write("]</a></li>\n");
      out.write("                            <li><a href=\"products.jsp?product_id=3\">SPORTS & LEISURE [");
      out.print(db.count(3));
      out.write("]</a></li>\n");
      out.write("                            <li><a href=\"products.jsp?product_id=4\">BOOKS & ENTERTAINMENTS [");
      out.print(db.count(4));
      out.write("]</a></li>\n");
      out.write("                            <li><a href=\"products.jsp?product_id=5\">FOOD[");
      out.print(db.count(5));
      out.write("]</a></li>\n");
      out.write("                            <li><a href=\"products.jsp?product_id=6\">OTHERS[");
      out.print(db.count(6));
      out.write("]</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <br/>\n");
      out.write("                        <br/>\n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                            <img src=\"themes/images/payment_methods.png\" title=\"Bootshop Payment Methods\" alt=\"Payments Methods\">\n");
      out.write("                            <div class=\"caption\">\n");
      out.write("                                <h5>Payment Methods</h5>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Sidebar end=============================================== -->\n");
      out.write("                    <div class=\"span9\">\n");
      out.write("                        <ul class=\"breadcrumb\">\n");
      out.write("                            <li><a href=\"index.jsp\">Home</a> <span class=\"divider\">/</span></li>\n");
      out.write("                            <li class=\"active\">Login</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <h3> Login</h3>\t\n");
      out.write("                        <hr class=\"soft\"/>\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                            <div class=\"span4\">\n");
      out.write("                                <div class=\"well\">\n");
      out.write("                                    <form action=\"login\" method=\"post\">\n");
      out.write("                                        <div class=\"control-group\">\n");
      out.write("                                            <label class=\"control-label\" for=\"inputEmail1\">Email</label>\n");
      out.write("                                            <div class=\"controls\">\n");
      out.write("                                                <input class=\"span3\"  type=\"text\" id=\"inputEmail1\" placeholder=\"Email\" name=\"user\" value=\"\" required=\"required\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"control-group\">\n");
      out.write("                                            <label class=\"control-label\" for=\"inputPassword1\">Password</label>\n");
      out.write("                                            <div class=\"controls\">\n");
      out.write("                                                <input type=\"password\" class=\"span3\"  id=\"inputPassword1\" placeholder=\"Password\" name=\"pass\" value=\"\" required=\"required\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"control-group\">\n");
      out.write("                                            <div class=\"controls\">\n");
      out.write("                                                <button type=\"submit\" class=\"btn\">Sign in</button> <a href=\"forgetpass.jsp\">Forget password?</a>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <p style=\"color: red\">");
      out.print(msg);
      out.write("</p>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\t\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- MainBody End ============================= -->\n");
      out.write("        <!-- Footer ================================================================== -->\n");
      out.write("        <div  id=\"footerSection\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"span3\">\n");
      out.write("                        <h5>ACCOUNT</h5>\n");
      out.write("                        <a href=\"login.jsp\">YOUR ACCOUNT</a>\n");
      out.write("                        <a href=\"login.jsp\">PERSONAL INFORMATION</a> \n");
      out.write("                        <a href=\"login.jsp\">ADDRESSES</a> \n");
      out.write("                        <a href=\"login.jsp\">DISCOUNT</a>  \n");
      out.write("                        <a href=\"login.jsp\">ORDER HISTORY</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"span3\">\n");
      out.write("                        <h5>INFORMATION</h5>\n");
      out.write("                        <a href=\"contact.jsp\">CONTACT</a>  \n");
      out.write("                        <a href=\"register.jsp\">REGISTRATION</a>  \n");
      out.write("                        <a href=\"legal_notice.jsp\">LEGAL NOTICE</a>  \n");
      out.write("                        <a href=\"tac.jsp\">TERMS AND CONDITIONS</a> \n");
      out.write("                        <a href=\"faq.jsp\">FAQ</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"span3\">\n");
      out.write("                        <h5>OUR OFFERS</h5>\n");
      out.write("                        <a href=\"#\">NEW PRODUCTS</a> \n");
      out.write("                        <a href=\"#\">TOP SELLERS</a>  \n");
      out.write("                        <a href=\"special_offer.jsp\">SPECIAL OFFERS</a>  \n");
      out.write("                        <a href=\"#\">MANUFACTURERS</a> \n");
      out.write("                        <a href=\"#\">SUPPLIERS</a> \n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"socialMedia\" class=\"span3 pull-right\">\n");
      out.write("                        <h5>SOCIAL MEDIA </h5>\n");
      out.write("                        <a href=\"#\"><img width=\"60\" height=\"60\" src=\"themes/images/facebook.png\" title=\"facebook\" alt=\"facebook\"/></a>\n");
      out.write("                        <a href=\"#\"><img width=\"60\" height=\"60\" src=\"themes/images/twitter.png\" title=\"twitter\" alt=\"twitter\"/></a>\n");
      out.write("                        <a href=\"#\"><img width=\"60\" height=\"60\" src=\"themes/images/youtube.png\" title=\"youtube\" alt=\"youtube\"/></a>\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("                <p class=\"pull-right\">&copy; Bootshop</p>\n");
      out.write("            </div><!-- Container End -->\n");
      out.write("        </div>\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster ============================================= -->\n");
      out.write("        <script src=\"themes/js/jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"themes/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"themes/js/google-code-prettify/prettify.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"themes/js/bootshop.js\"></script>\n");
      out.write("        <script src=\"themes/js/jquery.lightbox-0.5.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Themes switcher section ============================================================================================= -->\n");
      out.write("        <div id=\"secectionBox\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"themes/switch/themeswitch.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("            <script src=\"themes/switch/theamswitcher.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n");
      out.write("            <div id=\"themeContainer\">\n");
      out.write("                <div id=\"hideme\" class=\"themeTitle\">Style Selector</div>\n");
      out.write("                <div class=\"themeName\">Oregional Skin</div>\n");
      out.write("                <div class=\"images style\">\n");
      out.write("                    <a href=\"themes/css/#\" name=\"bootshop\"><img src=\"themes/switch/images/clr/bootshop.png\" alt=\"bootstrap business templates\" class=\"active\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"businessltd\"><img src=\"themes/switch/images/clr/businessltd.png\" alt=\"bootstrap business templates\" class=\"active\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"themeName\">Bootswatch Skins (11)</div>\n");
      out.write("                <div class=\"images style\">\n");
      out.write("                    <a href=\"themes/css/#\" name=\"amelia\" title=\"Amelia\"><img src=\"themes/switch/images/clr/amelia.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"spruce\" title=\"Spruce\"><img src=\"themes/switch/images/clr/spruce.png\" alt=\"bootstrap business templates\" ></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"superhero\" title=\"Superhero\"><img src=\"themes/switch/images/clr/superhero.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"cyborg\"><img src=\"themes/switch/images/clr/cyborg.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"cerulean\"><img src=\"themes/switch/images/clr/cerulean.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"journal\"><img src=\"themes/switch/images/clr/journal.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"readable\"><img src=\"themes/switch/images/clr/readable.png\" alt=\"bootstrap business templates\"></a>\t\n");
      out.write("                    <a href=\"themes/css/#\" name=\"simplex\"><img src=\"themes/switch/images/clr/simplex.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"slate\"><img src=\"themes/switch/images/clr/slate.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"spacelab\"><img src=\"themes/switch/images/clr/spacelab.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"united\"><img src=\"themes/switch/images/clr/united.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <p style=\"margin:0;line-height:normal;margin-left:-10px;display:none;\"><small>These are just examples and you can build your own color scheme in the backend.</small></p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"themeName\">Background Patterns </div>\n");
      out.write("                <div class=\"images patterns\">\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern1\"><img src=\"themes/switch/images/pattern/pattern1.png\" alt=\"bootstrap business templates\" class=\"active\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern2\"><img src=\"themes/switch/images/pattern/pattern2.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern3\"><img src=\"themes/switch/images/pattern/pattern3.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern4\"><img src=\"themes/switch/images/pattern/pattern4.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern5\"><img src=\"themes/switch/images/pattern/pattern5.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern6\"><img src=\"themes/switch/images/pattern/pattern6.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern7\"><img src=\"themes/switch/images/pattern/pattern7.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern8\"><img src=\"themes/switch/images/pattern/pattern8.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern9\"><img src=\"themes/switch/images/pattern/pattern9.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern10\"><img src=\"themes/switch/images/pattern/pattern10.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern11\"><img src=\"themes/switch/images/pattern/pattern11.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern12\"><img src=\"themes/switch/images/pattern/pattern12.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern13\"><img src=\"themes/switch/images/pattern/pattern13.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern14\"><img src=\"themes/switch/images/pattern/pattern14.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern15\"><img src=\"themes/switch/images/pattern/pattern15.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern16\"><img src=\"themes/switch/images/pattern/pattern16.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern17\"><img src=\"themes/switch/images/pattern/pattern17.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern18\"><img src=\"themes/switch/images/pattern/pattern18.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern19\"><img src=\"themes/switch/images/pattern/pattern19.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("                    <a href=\"themes/css/#\" name=\"pattern20\"><img src=\"themes/switch/images/pattern/pattern20.png\" alt=\"bootstrap business templates\"></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <span id=\"themesBtn\"></span>\n");
      out.write("    </body>\n");
      out.write("</html>");
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