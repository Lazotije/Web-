package com.shishi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shishi.model.Televizor;


public class DodajTvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DodajTvController(){
		super();
	}


@Override
public void init(ServletConfig config) throws ServletException {
	
	super.init(config);
	List<Televizor> tvs = new ArrayList<>();
	getServletContext().setAttribute("baya-svih-tva", tvs);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sbroj = request.getParameter("serijskiBroj");
	String cena = request.getParameter("cena");
	int cenaInt = Integer.parseInt(cena);
	String modelStr = request.getParameter("marka"); // "0"
	int modelInt = Integer.parseInt(modelStr);  // 0
	String praviModel = Televizor.MOGUCI_MODELI[modelInt]; 
	
	Televizor tv = new Televizor(sbroj,cenaInt,praviModel);
	List<Televizor> sviTvi = (List<Televizor>) getServletContext().getAttribute("baya-svih-tva");
System.out.println(request.getParameter("operacija"));
	if(request.getParameter("operacija").equals("dodaj")){
		sviTvi.add(tv);
		System.out.println("nesto");
	}else{
		Televizor zaIzmenu = (Televizor) request.getSession().getAttribute("zaIzmenu");
		for(int i =0;i< sviTvi.size();i++){
			Televizor tv2 = sviTvi.get(i);
			if(tv2.getSerijskiBroj().equals(zaIzmenu.getSerijskiBroj())){
				sviTvi.remove(tv2);
				sviTvi.add(tv);
			}
		}
		
		 request.getSession().removeAttribute("zaIzmenu");
	}
	
	HttpSession session = request.getSession();
	
	List<Televizor> tvZaStranicu = new ArrayList<>();
	tvZaStranicu.addAll(sviTvi);
	session.setAttribute("tvZaStranicu", tvZaStranicu);
	
	response.sendRedirect("PregledTv.jsp");

	
}

}