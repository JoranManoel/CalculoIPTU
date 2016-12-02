import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/resultado")
public class resultado extends HttpServlet {
	protected void service(HttpServletRequest request , HttpServletResponse response)
	throws ServletException, IOException {
		
			//Pegando o parametro do Request

		String desc = request.getParameter("desconto");
		double desconto = Double.parseDouble(desc);
		String tipoImovel = request.getParameter("tipoImovel");
		
		double base = Double.parseDouble(request.getParameter("baseCalculo")) ;
		double total = 0 ;
		if (tipoImovel.equals("res")){
			double faixa1=95450.00, faixa2=134176.00, faixa3=178970.00, faixa4=298283.00 ;
			
			if (base<=95450){
				double v = base * 0.60/100 ;
				 total = v - desconto ;
			}
			if(base > 95450 && base <= 238626){
				double f1 = faixa1;
				double f2 = base - f1 ;
				
				double valor1 = f1 * (0.60/100);
				double valor2 = f2 * (0.70/100);
				
				total = valor1 + valor2 - desconto;
			}
			if(base > 238626 && base <= 417596){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = (f1 + f2 - base)* -1 ;
				
				double valor1 = f1 * (0.60/100);
				double valor2 = f2 * (0.70/100);
				double valor3 = f3 * (0.75/100);
				total = valor1 + valor2 + valor3 - desconto;
			}
			if(base > 417596 && base <= 715879){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = faixa3 ;
				double f4 = (f1 + f2 + f3 - base)* -1 ;
				
				double valor1 = f1 * (0.60/100);
				double valor2 = f2 * (0.70/100);
				double valor3 = f3 * (0.75/100);
				double valor4 = f4 * (0.80/100);
				
				total = valor1 + valor2 + valor3 + valor4 - desconto;
			}
		}
		
		if (tipoImovel.equals("naoRes")){
			double faixa1=35793.00, faixa2=83520.00, faixa3=477252.00, faixa4=596566.00 ;
			
			if (base<=35793){
				double v = base * 1.20/100 ;
				 total = v - desconto ;
			}
			if(base > 35793 && base <= 119313){
				double f1 = faixa1;
				double f2 = base - f1 ;
				
				double valor1 = f1 * (1.20/100);
				double valor2 = f2 * (1.30/100);
				
				total = valor1 + valor2 - desconto;
			}
			if(base > 119313 && base <= 596565){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = (f1 + f2 - base)* -1 ;
				
				double valor1 = f1 * (1.20/100);
				double valor2 = f2 * (1.30/100);
				double valor3 = f3 * (1.40/100);
				total = valor1 + valor2 + valor3 - desconto;
			}
			if(base > 596565 && base <= 1193131){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = faixa3 ;
				double f4 = (f1 + f2 + f3 - base)* -1 ;
				
				double valor1 = f1 * (1.20/100);
				double valor2 = f2 * (1.30/100);
				double valor3 = f3 * (1.40/100);
				double valor4 = f4 * (1.50/100);
				
				total = valor1 + valor2 + valor3 + valor4 - desconto;
			}
		}
		
		if (tipoImovel.equals("terr")){
			double faixa1=47724.00, faixa2=310215.00, faixa3=357940.00, faixa4 =477252.00 ;
			
			if (base<=47724){
				double v = base * 1.00/100 ;
				 total = v - desconto ;
			}
			if(base > 47724 && base <= 357939){
				double f1 = faixa1;
				double f2 = base - f1 ;
				
				double valor1 = f1 * (1.00/100);
				double valor2 = f2 * (1.60/100);
				
				total = valor1 + valor2 - desconto;
			}
			if(base > 357939 && base <= 715879){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = (f1 + f2 - base)* -1 ;
				
				double valor1 = f1 * (1.00/100);
				double valor2 = f2 * (1.60/100);
				double valor3 = f3 * (2.00/100);
				total = valor1 + valor2 + valor3 - desconto;
			}
			if(base > 715879 && base <= 1193131){
				double f1 = faixa1;
				double f2 = faixa2;
				double f3 = faixa3 ;
				double f4 = (f1 + f2 + f3 - base)* -1 ;
				
				double valor1 = f1 * (1.00/100);
				double valor2 = f2 * (1.60/100);
				double valor3 = f3 * (2.00/100);
				double valor4 = f4 * (2.50/100);
				
				total = valor1 + valor2 + valor3 + valor4 - desconto;
			}
		}
		//Imprimindo 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='index.html'>"
				+ "<table bgcolor='lightblue'>"
				+ "<th bgcolor='red'>Simulador de IPTU</th>"
				+ "<tr>"
				+ "<td>O valor do imóvel é R$ "+total+"</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td align='right'><input type='submit' value='Voltar'>"
				+ "</tr>"
				+ "</table>"
				+ "</form>"		
				);
		out.println("</body>");
		out.println("</html>");		
	}	
}
