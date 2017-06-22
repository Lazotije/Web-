package com.shishi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shishi.model.Televizor;


public class IzmeniTvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IzmeniTvController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String izmeni = request.getParameter("izmeni");
		List<Televizor> sviTvi = (List<Televizor>) getServletContext().getAttribute("baya-svih-tva");
		Televizor tv = new Televizor();
		for (int i =0;i<sviTvi.size();i++)
		{
			tv = sviTvi.get(i);
			if(tv.getSerijskiBroj().equals(izmeni)){
				break;
			}
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("zaIzmenu", tv);
		
		response.sendRedirect("PregledTv.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
