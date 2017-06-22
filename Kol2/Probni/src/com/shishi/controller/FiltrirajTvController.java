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
import com.shishi.model.Vino;


public class FiltrirajTvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FiltrirajTvController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String markaStr = request.getParameter("marka");
		int markaInt = Integer.parseInt(markaStr);

		List<Televizor> sviTvi = (List<Televizor>) getServletContext().getAttribute("baya-svih-tva");
		List<Televizor> tviZaStranicu = new ArrayList<>();
		tviZaStranicu.addAll(sviTvi);

		if (markaInt == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("tviZaStranicu", tviZaStranicu);
		} else {
			String izabraniModel = Televizor.MOGUCI_MODELI[markaInt]; 
			List<Televizor> filrirano = new ArrayList<>();
			
			for (Televizor tv : sviTvi) {
				if (tv.getModel().equals(izabraniModel)) {
					filrirano.add(tv);
				}
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("izabraniModel", izabraniModel);
			session.setAttribute("tviZaStranicu", filrirano);
		}
		
		response.sendRedirect("PregledTV.jsp");

	}
}
