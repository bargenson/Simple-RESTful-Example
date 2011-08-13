<!DOCTYPE html>
<html>
  <head>
    <title>Simple RESTful Example</title>
    <meta charset="utf-8" />
    <meta name="title" content="Simple RESTful Example" />
    <meta name="description" content="A Simple RESTful Example designed with Java EE Technologies including JAX-RS, JAX-B and JPA and hosted by Google App Engine." />
    <meta name="language" content="fr" />
    <meta name="author" content="@bargenson" />
    <link id="theme" rel="stylesheet" type="text/css" href="/style.css" title="theme" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
    <sitemesh:write property='head'/>
    <script type="text/javascript">

		var _gaq = _gaq || [];
		_gaq.push(['_setAccount', 'UA-25122825-1']);
		_gaq.push(['_trackPageview']);
		
		(function() {
			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		})();
	
	</script>
  </head>
  <body> 
    <div id="wrapper"> 
      <div id="bg"> 
        <div id="header"></div>  
        <div id="page"> 
          <div id="container"> 
            <!-- banner -->
            <div id="banner">
            	<a href="/jsp/index.jsp" shape="rect" style="display: block; width: 50%; height: 100%">
            		<span style="display: none;">Simple RESTful Example</span>
            	</a>
            </div>  
            <!-- end banner -->  
			<!-- horizontal navigation   -->
            <div id="nav1"> 
<!--               <ul> -->
<!--                 <li id="current" style="border:none"> -->
<!--                   <a href="#" shape="rect">Home</a> -->
<!--                 </li> -->
<!--                 <li> -->
<!--                   <a href="#" shape="rect">Products</a> -->
<!--                 </li> -->
<!--                 <li> -->
<!--                   <a href="#" shape="rect">Services</a> -->
<!--                 </li> -->
<!--                 <li> -->
<!--                   <a href="#" shape="rect">News</a> -->
<!--                 </li> -->
<!--                 <li> -->
<!--                   <a href="#" shape="rect">About</a> -->
<!--                 </li> -->
<!--               </ul>  -->
            </div>  
            <!-- end horizontal navigation -->  
            <!--  content -->  
            <div id="content"> 
              <div id="center"> 
                <div id="welcome"> 
                  <sitemesh:write property='body'/>
                </div> 
              </div>  
              <div id="right"> 
                <div id="sidebar"> 
                  <h3>Documentation</h3>  
                  <ul class="vmenu">
                    <li>
                      <a href="/jsp/students/get.jsp" shape="rect">GET /students</a>
                    </li>
                    <li>
                      <a href="/jsp/students/post.jsp" shape="rect">POST /students</a>
                    </li>
                    <li>
                      <a href="/jsp/student/get.jsp" shape="rect">GET /students/{idBooster}</a>
                    </li>
                    <li>
                      <a href="/jsp/student/put.jsp" shape="rect">PUT /students/{idBooster}</a>
                    </li>
                    <li>
                      <a href="/jsp/student/delete.jsp" shape="rect">DELETE /students/{idBooster}</a>
                    </li>
                    <li>
                      <a href="/jsp/students/search/get.jsp" shape="rect">GET /students/search/{query}</a>
                    </li>
                  </ul>  
                  <h3 style="margin-top:40px">External Links</h3>
                  <ul class="vmenu">
                    <li>
                      <div style="text-align:center;margin:20px 0;">
                        <a href="https://github.com/bargenson/Simple-RESTful-Example">
                          <span style="display: none;">Simple RESTful Example Source Code</span>
                          <img src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov6-hover.png" width="150px" alt="Source Code on GitHub" />
                        </a> 
                  	    <div style="font-weight:bold;margin-top:20px">Source Code available on GitHub</div>  
                      </div>
                    </li>
                    <li>
                      <div style="text-align:center;margin:20px 0;">
                        <a href="http://www.supinfo.com">
                          <span style="display: none;">Simple RESTful Example</span>
                          <img src="http://www.supinfo.com/SupInfoCommonResources/SUPINFO-PICTURES/Charte/Logo%20SUPINFO%20horizontal%20-%20Noir%20sur%20Blanc%20-%20CMJN%20300dpi.jpg" width="200px" alt="SUPINFO logo" />
                        </a> 
                  	    <div style="font-weight:bold;margin-top:20px">www.supinfo.com</div>  
                      </div> 
                    </li>
                  </ul>
                </div> 
              </div>  
              <div class="clear" style="height:40px"></div> 
            </div>  
            <!-- end content --> 
          </div>  
          <!-- end container --> 
        </div>  
        <div id="footerWrapper"> 
          <div id="footer" style="padding-top: 10px;"> 
          	            
            <a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal">Tweet</a>
            <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
            
            <g:plusone size="medium"></g:plusone>
			<script type="text/javascript">
			  (function() {
			    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
			    po.src = 'https://apis.google.com/js/plusone.js';
			    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
			  })();
			</script>

            <p>
              <a href="http://www.dotemplate.com" shape="rect">Templates</a> maker
            </p> 
          </div> 
        </div> 
      </div> 
    </div> 
  </body>
</html>
