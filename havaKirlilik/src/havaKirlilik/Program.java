package havaKirlilik;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
public class Program {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		System.out.print("nüfus değerini 0 ile 15910000 aralığında giriniz: ");
		double nufus=in.nextDouble();
		 if (nufus< 0 || nufus > 15910000) {
	            System.out.println(" nüfus değeri 0 ile 15910000 arasında olmalıdır !");
	            return; 
	        }
		 System.out.print("Doğal gaz tüketim değerini 0 ile 1150 aralığında giriniz ");
			double dGaz=in.nextDouble();
			 if (dGaz< 0 || dGaz > 1150) {
		            System.out.println(" Doğal gaz tüketim değeri 0 ile 1150 arasında olmalıdır !");
		            return; 
		        }
		System.out.print("mevsim için 0 ile 12 arasında bir sayı giriniz: ");
		double mevsim=in.nextDouble();
		 if (mevsim< 0 || mevsim > 12) {
	            System.out.println(" mevsim değeri 0 ile 12 arasında olmalıdır !");
	            return; 
	        }
		try {
			Makine makine =new Makine (dGaz,nufus,mevsim);
			var kurallar=makine.getModel().getFunctionBlock("HavaKirlilik").getFuzzyRuleBlock("kuralBlok").getRules();
			for(var kural:kurallar) {
				if(kural.getDegreeOfSupport()>0) {
					System.out.println(kural);
				}
			}
			System.out.print(makine);
			//JFuzzyChart.get().chart(makine.getModel());
			JFuzzyChart.get().chart(makine.getModel().getVariable("havaOran").getDefuzzifier(),"havaOran",true);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		
		}
	
	
	
	
	}

}