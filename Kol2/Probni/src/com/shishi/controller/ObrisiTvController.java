package com.shishi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shishi.model.Televizor;


public class ObrisiTvController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ObrisiTvController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	List<Televizor> tvi = (List<Televizor>) request.getSession().getAttribute("baya-svih-tva");
		List<Televizor> tvi = (List<Televizor>) getServletContext().getAttribute("baya-svih-tva");
		String obrisi = request.getParameter("obrisi");
		for (int i=0;i< tvi.size();i++)
		{
			Televizor tv = tvi.get(i);
			if((tv.getSerijskiBroj()).equals(obrisi)){
				System.out.println(obrisi + "NEKI TEKST");
				tvi.remove(tv);
				break;
			}
		}
		
		getServletContext().setAttribute("baya-svih-tva",tvi);
		request.getSession().setAttribute("tvZaStranicu",tvi);
		request.getRequestDispatcher("PregledTv.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
