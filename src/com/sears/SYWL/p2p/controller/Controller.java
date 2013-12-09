package com.sears.SYWL.p2p.controller;


import java.io.IOException;
import java.io.PrintWriter;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sears.SYWL.p2p.api.P2PAPI;
import com.sears.SYWL.p2p.api.P2PAPIImpl;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static P2PAPI api;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		api=new P2PAPIImpl();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//Model model = new Model(getServletConfig());
		//Add Actions
		Action.add(new TestAction());
		Action.add(new CheckAvailabilityAction());
		Action.add(new ReleaseIntentAction());
		Action.add(new GetBuyerLocationHistoryAction());
		Action.add(new ActivateIntentAction());
		Action.add(new AddNewHistoryLocationAction());
		Action.add(new GetDelivererLocationHistoryAction());
		Action.add(new SendOrderAction());
		Action.add(new RegisterDeliverIntentAction());
		Action.add(new SummaryAction());
		Action.add(new DescribeAction());
		Action.add(new AddItemAction());
		Action.add(new ChooseMethodAction());
		Action.add(new DeliveryConfirmAction());
		Action.add(new GetDeliverLocInitAction());
		Action.add(new LocationAction());
		Action.add(new ContinueShoppingAction());
		Action.add(new ChoosePickupAction());
		Action.add(new WelcomeAction());
		Action.add(new SendMessageAction());
	}
	
	
    private String fixBadChars(String s) {
		if (s == null || s.length() == 0) return s;
		
		Pattern p = Pattern.compile("[<>\"&]");
        Matcher m = p.matcher(s);
        StringBuffer b = null;
        while (m.find()) {
            if (b == null) b = new StringBuffer();
            switch (s.charAt(m.start())) {
                case '<':  m.appendReplacement(b,"&lt;");
                           break;
                case '>':  m.appendReplacement(b,"&gt;");
                           break;
                case '&':  m.appendReplacement(b,"&amp;");
                		   break;
                case '"':  m.appendReplacement(b,"&quot;");
                           break;
                default:   m.appendReplacement(b,"&#"+((int)s.charAt(m.start()))+';');
            }
        }
        
        if (b == null) return s;
        m.appendTail(b);
        return b.toString();
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nextPage = performTheAction(request,response.getWriter());
	//	response.getWriter().println("fuck");
		sendToNextPage(nextPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

	/*
	 * Extracts the requested action and (depending on whether the user is
	 * logged in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	private String performTheAction(HttpServletRequest request, PrintWriter writer) {
		//return "";
		return Action.perform(getActionName(request.getServletPath()), request,writer);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
	 * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
	 * page (the view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,
					request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}
		
		if (nextPage.endsWith(".jsp")) {
			RequestDispatcher dispatch=request.getRequestDispatcher(nextPage);
			dispatch.forward(request,response);
		}

	}

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}

}
