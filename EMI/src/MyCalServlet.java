
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCalServlet
 */
class Disp {
	double Princple;
	double intrest;
	double emi;

	public Disp(double princple, double intrest, double emi) {
		super();
		Princple = princple;
		this.intrest = intrest;
		this.emi = emi;
	}

}

@WebServlet("/MyCalServlet")
public class MyCalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyCalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Disp> a = new ArrayList<>();
		double p = Double.parseDouble(request.getParameter("principle"));
		double n = Double.parseDouble(request.getParameter("months"));
		double r = Double.parseDouble(request.getParameter("rate"));
		while (p != 0) {
			double i = EmiCalc.calcIntrest(p, n, r);
			System.out.println(i);
			p = p - EmiCalc.calcPrincipal(p, n);
			n = n - 1;
			a.add(new Disp(p, i, p + i));
			System.out.print(p+i);
		}
		RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
		request.setAttribute("detail", a);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
