import java.util.List;
import java.util.ArrayList;

public class NBody{
    public static double readRadius(String dir) {
        In in = new In(dir);

        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }
    public static Body[] readBodies(String dir){
    	//Body[] bodyarr = new Body [5];
    	List<Body> bodyls = new ArrayList<Body>();

    	In in = new In(dir);
        int N = in.readInt();
        double R = in.readDouble();

        while(!in.isEmpty()){
        	String xxPs = in.readString();
        	try{
        		double xxPos = Double.parseDouble(xxPs);
        	} catch(java.lang.NumberFormatException e){
        		break;
        	}
        	double xxPos = Double.parseDouble(xxPs);
        	double yyPos = Double.parseDouble(in.readString());
        	double xxVel = Double.parseDouble(in.readString());
        	double yyVel = Double.parseDouble(in.readString());
        	double mass = Double.parseDouble(in.readString());
        	String img = in.readString();
        	bodyls.add(new Body(xxPos, yyPos, xxVel, yyVel, mass, img));
        }

        Body bodyarr[] = new Body[bodyls.size()];
        bodyls.toArray(bodyarr);

    	return bodyarr;
    }

    public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	double radius = readRadius(filename);
    	Body[] bodies = readBodies(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        for(double t=0;t<=T;t+=dt){
        	double[] xForces = new double[bodies.length];
        	double[] yForces = new double[bodies.length];

        	for(int i=0; i<bodies.length; i++){
        		xForces[i] = bodies[i].calcForceExertedByX(bodies);
        		yForces[i] = bodies[i].calcForceExertedByY(bodies);
        	}
        	for(int i=0; i<bodies.length; i++){
        		bodies[i].update(dt, xForces[i], yForces[i]);
        	}

        	StdDraw.picture(0, 0, "images/starfield.jpg");

        	for (Body b:bodies){
        		b.draw();
        	}
        	StdDraw.show();
        	StdDraw.pause(10);
        }

        StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
		                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
    }
}