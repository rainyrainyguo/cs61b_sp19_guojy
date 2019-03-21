public class Body{
	double xxPos,
		   yyPos,
		   xxVel,
		   yyVel,
		   mass;
	String imgFileName;
	static final double G = 6.67E-11;

	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double distance = Math.pow(xxPos - b.xxPos, 2) + Math.pow(yyPos - b.yyPos, 2);
		return Math.sqrt(distance);
	}

	public double calcForceExertedBy(Body b){
		return G*mass*b.mass/Math.pow(calcDistance(b),2);
	}

	public double calcForceExertedByX(Body b){
		return calcForceExertedBy(b)*(b.xxPos-xxPos)/calcDistance(b);
	}	
	public double calcForceExertedByY(Body b){
		return calcForceExertedBy(b)*(b.yyPos-yyPos)/calcDistance(b);
	}
}