<%@page import="java.util.ArrayList"%>
<%@page import="Model.cart"%>
<%@page import="Model.user"%>
<%@page import="jdk.nashorn.internal.ir.Symbol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Database.query"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->

        <!-- Bootstrap style --> 
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->	
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>

        <%!
            int product_id = 0;
            int item = 0;
            double total_price = 0.0;
        %>
        <%

            HttpSession ses = request.getSession(false);
            user u = new user();
            u = (user) ses.getAttribute("userinfo");

            String id = request.getParameter("id");

            if (id == null) {
                id = (String) request.getAttribute("id");
                if (id == null) {
                    RequestDispatcher rd = request.getRequestDispatcher("notfound.jsp");
                    rd.forward(request, response);
                }
            }
            query db = new query();
            ResultSet rs = db.selectbyid(Integer.parseInt(id));

            cart c = new cart();
            ArrayList<cart> car = new ArrayList<>();
            car = c.getIdcart();
            item = 0;
            total_price = 0.0;
            for (int i = 0; i < car.size(); i++) {
                item += car.get(i).getQuantity();
                total_price += (car.get(i).getPrice() * car.get(i).getQuantity());

            }
        %>
    </head>
    <body>
        <div id="header">
            <div class="container">
                <div id="welcomeLine" class="row">
                    <%if (u != null) {%>
                    <div class="span6">Welcome <strong><%=" " + u.getFname() + " " + u.getLname()%> </strong></div>
                    <%} else {%>
                    <div class="span6"> <strong> </strong></div>
                    <%}%>
                    <div class="span6">
                        <div class="pull-right">
                            <span class="btn btn-mini">$<%=total_price%></span>
                            <a href="product_summary.jsp"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ <%=item%>] Items in your cart </span> </a> 
                        </div>
                    </div>
                </div>
                <!-- Navbar ================================================== -->
                <div id="logoArea" class="navbar">
                    <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-inner">
                        <a class="brand" href="index.jsp"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
                        <ul id="topMenu" class="nav pull-right">
                            <li class=""><a href="products.jsp">Products</a></li>
                            <li class=""><a href="contact.jsp">Contact</a></li>
                                <%if (u == null) {%>
                            <li class=""><a href="register.jsp">Register</a></li>
                                <%} else if (u != null) {%>

                            <li class=""><a href="profile.jsp">profile</a></li>
                                <%}%>
                            <li class="">
                                <%if (u == null) {%>
                                <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a>
                                <%}%>
                                <div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                                        <h3>Login Block</h3>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form-horizontal loginFrm" action="login" method="post">
                                            <div class="control-group">								
                                                <input type="text" id="inputEmail" placeholder="Email" name="user" value="" required="required">
                                            </div>
                                            <div class="control-group">
                                                <input type="password" id="inputPassword" placeholder="Password" name="pass" value="" required="required">

                                            </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me
                                                </label>
                                            </div>
                                            <button type="submit" class="btn btn-success">Sign in</button>
                                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                                        </form>	
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <div id="sidebar" class="span3">
                        <div class="well well-small"><a id="myCart" href="product_summary.jsp"><img src="themes/images/ico-cart.png" alt="cart"><%=item%> Items in your cart  <span class="badge badge-warning pull-right">$<%=total_price%></span></a></div>
                        <ul id="sideManu" class="nav nav-tabs nav-stacked">

                            <li><a href="products.jsp?product_id=1">ELECTRONICS [<%=db.count(1)%>]</a></li>
                            <li><a href="products.jsp?product_id=2">CLOTHES [<%=db.count(2)%>]</a></li>
                            <li><a href="products.jsp?product_id=3">SPORTS & LEISURE [<%=db.count(3)%>]</a></li>
                            <li><a href="products.jsp?product_id=4">BOOKS & ENTERTAINMENTS [<%=db.count(4)%>]</a></li>
                            <li><a href="products.jsp?product_id=5">FOOD[<%=db.count(5)%>]</a></li>
                            <li><a href="products.jsp?product_id=6">OTHERS[<%=db.count(6)%>]</a></li>
                        </ul>                <br/>
                        <br/>
                        <div class="thumbnail">
                            <img src="themes/images/payment_methods.png" title="Bootshop Payment Methods" alt="Payments Methods">
                            <div class="caption">
                                <h5>Payment Methods</h5>
                            </div>
                        </div>
                    </div>
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
                            <li><a href="products.jsp">Products</a> <span class="divider">/</span></li>
                            <li class="active">product Details</li>
                        </ul>	
                        <div class="row">


                            <%if (rs.next()) {%>
                            <div id="gallery" class="span3">
                                <img src="images/<%=rs.getString("nimage")%>" style="width:100%;height: 300px" alt="<%=rs.getString("name")%>"/>
                                </a>
                                <div id="differentview" class="moreOptopm carousel slide">

                                    <!--  
                                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">?</a>
                                    <a class="right carousel-control" href="#myCarousel" data-slide="next">?</a> 
                                    -->
                                </div>


                            </div>
                            <div class="span6">
                                <%
                                    product_id = Integer.parseInt(rs.getString("PRODUCTS_id"));

                                %>

                                <h3><%=rs.getString("name")%></h3> 
                                <small>- <%=rs.getString("size")%></small>
                                <hr class="soft"/>
                                <form class="form-horizontal qtyFrm" action="cart" method="post">
                                    <div class="control-group">
                                        <label class="control-label"><span>$<%=rs.getString("price")%></span></label>
                                        <div class="controls">
                                            <input type="number" class="span1" placeholder="Qty." required="required" name="quantity" value="" max="<%=rs.getString("quantity")%>" min="1" /> max value <%=rs.getString("quantity")%><br><br>
                                            <input type="hidden" name="id" value="<%=id%>"/>
                                            <input type="hidden" name="name" value="<%=rs.getString("name")%>"/>
                                            <input type="hidden" name="price" value="<%=rs.getString("price")%>"/>
                                            <input type="hidden" name="nmage" value="<%=rs.getString("nimage")%>"/>
                                            <input type="hidden" name="model" value="<%=rs.getString("model")%>"/>
                                            <input type="hidden" name="itmes" value="<%=rs.getString("quantity")%>"/>
                                            <input type="submit" value="Add to cart" class="btn btn-large btn-primary pull-right"/>

                                        </div>
                                    </div>
                                </form>

                                <hr class="soft"/>
                                <h4><%=rs.getInt("quantity")%> items in stock</h4>
                                <form class="form-horizontal qtyFrm pull-right">
                                    <div class="control-group">

                                    </div>
                                </form>
                                <hr class="soft clr"/>

                                <br class="clr"/>


                            </div>
                            <%}%>
                            <div class="span9">
                                <ul id="productDetail" class="nav nav-tabs">
                                    <li class="active"><a href="#home" data-toggle="tab">Product Details</a></li>
                                    <li><a href="#profile" data-toggle="tab">Related Products</a></li>
                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade active in" id="home">
                                        <h4>Product Information</h4>
                                        <table class="table table-bordered">
                                            <tbody>
                                                <tr class="techSpecRow"><th colspan="2">Product Details</th></tr>
                                                <tr class="techSpecRow"><td class="techSpecTD1">Name : </td><td class="techSpecTD2"><%=rs.getString("name")%></td></tr>
                                                <tr class="techSpecRow"><td class="techSpecTD1">Model:</td><td class="techSpecTD2"><%=rs.getString("size")%></td></tr>
                                                <tr class="techSpecRow"><td class="techSpecTD1">Released on:</td><td class="techSpecTD2"> <%=rs.getString("releasedon")%></td></tr>
                                                <tr class="techSpecRow"><td class="techSpecTD1">Color:</td><td class="techSpecTD2"> <%=rs.getString("color")%></td></tr>
                                                <tr class="techSpecRow"><td class="techSpecTD1">Dimensions/Size:</td><td class="techSpecTD2"> <%=rs.getString("size")%></td></tr>
                                            </tbody>
                                        </table>

                                        <h5>Features</h5>
                                        <p>
                                            <%=rs.getString("features")%>
                                        </p>
                                    </div>
                                    <div class="tab-pane fade" id="profile">
                                        <div id="myTab" class="pull-right">
                                            <a href="#listView" data-toggle="tab"><span class="btn btn-large"><i class="icon-list"></i></span></a>
                                            <a href="#blockView" data-toggle="tab"><span class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
                                        </div>
                                        <br class="clr"/>
                                        <hr class="soft"/>
                                        <div class="tab-content">

                                            <div class="tab-pane" id="listView">
                                                <%
                                                    ResultSet set = db.selectbytype(product_id);
                                                %>
                                                <%while (set.next()) {%>
                                                <div class="row">	  
                                                    <div class="span2">
                                                        <img src="images/<%=set.getString("nimage")%>" style="height: 150px;width: 100%" alt=""/>
                                                    </div>
                                                    <div class="span4">
                                                        <h3>New | Available</h3>				

                                                        <h5><%=set.getString("name")%> </h5>
                                                        <p>
                                                            <%=set.getString("releasedon")%><br>
                                                        </p>

                                                        <br class="clr"/>
                                                    </div>
                                                    <div class="span3 alignR">
                                                        <form class="form-horizontal qtyFrm">
                                                            <h3> $<%=set.getString("price")%></h3>
                                                            <label class="checkbox">
                                                            </label><br/>
                                                            <div class="btn-group">
                                                                <a href="product_details.jsp" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
                                                                <a href="product_details.jsp?id=<%=set.getString("id")%>" class="btn btn-large"><i class="icon-zoom-in"></i></a>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <hr class="soft"/>
                                                <%}%>

                                            </div>
                                            <%
                                                ResultSet rset = db.selectbytype(product_id);
                                            %>
                                            <div class="tab-pane active" id="blockView">
                                                <ul class="thumbnails">
                                                    <%while (rset.next()) {%>
                                                    <li class="span3">
                                                        <div class="thumbnail">
                                                            <a href="product_details.jsp?id=<%=rset.getString("id")%>"><img src="images/<%=rset.getString("nimage")%>" alt="" style="height: 210px;width: 100%"/></a>
                                                            <div class="caption">
                                                                <h5><%=rset.getString("name")%></h5>

                                                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp?id=<%=rset.getString("id")%>"> <i class="icon-zoom-in"></i></a>  <a class="btn btn-primary" href="#">&euro;<%=rset.getString("price")%></a></h4>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <%}%>
                                                </ul>
                                                <hr class="soft"/>
                                            </div>
                                        </div>
                                        <br class="clr">
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div> </div>
        </div>
        <!-- MainBody End ============================= -->
        <!-- Footer ================================================================== -->
        <div  id="footerSection">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <h5>ACCOUNT</h5>
                        <a href="login.jsp">YOUR ACCOUNT</a>
                        <a href="login.jsp">PERSONAL INFORMATION</a> 
                        <a href="login.jsp">ADDRESSES</a> 
                        <a href="login.jsp">DISCOUNT</a>  
                        <a href="login.jsp">ORDER HISTORY</a>
                    </div>
                    <div class="span3">
                        <h5>INFORMATION</h5>
                        <a href="contact.jsp">CONTACT</a>  
                        <a href="register.jsp">REGISTRATION</a>  
                        <a href="legal_notice.jsp">LEGAL NOTICE</a>  
                        <a href="tac.jsp">TERMS AND CONDITIONS</a> 
                        <a href="faq.jsp">FAQ</a>
                    </div>
                    <div class="span3">
                        <h5>OUR OFFERS</h5>
                        <a href="#">NEW PRODUCTS</a> 
                        <a href="#">TOP SELLERS</a>  
                        <a href="special_offer.jsp">SPECIAL OFFERS</a>  
                        <a href="#">MANUFACTURERS</a> 
                        <a href="#">SUPPLIERS</a> 
                    </div>
                    <div id="socialMedia" class="span3 pull-right">
                        <h5>SOCIAL MEDIA </h5>
                        <a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
                        <a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
                        <a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
                    </div> 
                </div>
                <p class="pull-right">&copy; Bootshop</p>
            </div><!-- Container End -->
        </div>
        <!-- Placed at the end of the document so the pages load faster ============================================= -->
        <script src="themes/js/jquery.js" type="text/javascript"></script>
        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="themes/js/google-code-prettify/prettify.js"></script>

        <script src="themes/js/bootshop.js"></script>
        <script src="themes/js/jquery.lightbox-0.5.js"></script>

        <!-- Themes switcher section ============================================================================================= -->
        <div id="secectionBox">
            <link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
            <script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
            <div id="themeContainer">
                <div id="hideme" class="themeTitle">Style Selector</div>
                <div class="themeName">Oregional Skin</div>
                <div class="images style">
                    <a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
                </div>
                <div class="themeName">Bootswatch Skins (11)</div>
                <div class="images style">
                    <a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates" ></a>
                    <a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
                    <a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
                    <p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
                </div>
                <div class="themeName">Background Patterns </div>
                <div class="images patterns">
                    <a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>

                </div>
            </div>
        </div>
        <span id="themesBtn"></span>
    </body>
</html>