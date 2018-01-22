package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class dbquery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	public ArrayList<String> getName(String name) throws Exception
	{
		ArrayList<String> arr_name = new ArrayList<String>();

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=KC;integratedSecurity=true";

		Connection con = DriverManager.getConnection( connection_url );

		Statement s = con.createStatement();
		String sql_query = "select * from Java_Students where Name = '"+ name +"';";

		ResultSet rs = s.executeQuery( sql_query );

		while( rs.next() ){
			arr_name.add(rs.getString(1));
			arr_name.add(rs.getString(2));
		}

		con.close();

		return arr_name;
	}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/main.html");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>Today's Topic is JSP </h1>\r\n");
      out.write("\t<h3>JSP stands for Java Server Pages</h3>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>Response from Server</h1>\r\n");
      out.write("\t<table border ='1'>\r\n");
      out.write("\r\n");
      out.write("\t<tr><th>Name</th><th>ID</th></tr>\r\n");
      out.write('\r');
      out.write('\n');
	String name = request.getParameter("fname");  

	ArrayList<String> arr = null;

	try{
		arr = getName(name);
		if(arr != null && arr.size() == 0 ){
			out.println("<tr><td>No data is available</td><td>--</td></tr>");
		}
		else{
			for(int i = 0; i < arr.size(); i=i+2){
				out.println("<tr><td>" +arr.get(i) + "</td><td>"+arr.get(i+1)+"</td></tr>");
			}
		}

	}
	catch(Exception e){
		System.out.println(e);
	}

      out.write("\r\n");
      out.write("</table></body></html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
