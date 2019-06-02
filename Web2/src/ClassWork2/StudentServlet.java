package ClassWork2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ClassWork2.StudentList.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chosen = request.getParameter("name");
		JSONArray jsonArray = new JSONArray();

		for (Student student : StudentList.getInstance().list) {
			if (chosen == null || student.getName().equals(chosen)) {

				JSONObject object = new JSONObject();
				object.put("id", student.getId());
				object.put("name", student.getName());
				object.put("age", student.getAge());
				object.put("grade", student.getGrade());
				jsonArray.add(object);
			}
		}

		String submit = "";
		if (chosen == null)
			submit = jsonArray.toString();
		else
			submit = jsonArray.get(0).toString();

		response.getWriter().append(submit);
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
