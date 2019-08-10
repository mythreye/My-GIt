
public class EmiCalc 
{
 static double calcIntrest(double P,double N,double R)
 {
	 double  num=P * N * R;
	 double den=100;
	 return num/den;	 
 }
 static double calcPrincipal(double P,double N)
 {
	 return P/N;	 
 }
 static double calcEmi(double P,double I)
 {
	 return P+I;	 
 }

 

}
